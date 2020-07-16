package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.admin.wallet.po.WalletAccount;
import com.neusoft.bsp.admin.wallet.po.WalletAccountFund;
import com.neusoft.bsp.admin.wallet.po.WalletTransactionAudit;
import com.neusoft.bsp.admin.wallet.po.WalletTransactionRecord;
import com.neusoft.bsp.admin.wallet.service.WalletAccountFundService;
import com.neusoft.bsp.admin.wallet.service.WalletAccountService;
import com.neusoft.bsp.admin.wallet.service.WalletTransactionAuditService;
import com.neusoft.bsp.admin.wallet.service.WalletTransactionRecordService;
import com.neusoft.bsp.admin.wallet.vo.Audit;
import com.neusoft.bsp.admin.wallet.vo.Recharge;
import com.neusoft.bsp.admin.wallet.vo.UseridAndAccount;
import com.neusoft.bsp.admin.wallet.vo.Withdraw;
import com.neusoft.bsp.business.vo.UserIdAndPassword;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalDate.now;

@CrossOrigin
@RestController
@RequestMapping("/wal")
public class WalletController extends BaseController {
    @Autowired
    WalletAccountService walletAccountService;

    @Autowired
    UserService userService;

    @Autowired
    WalletAccountFundService walletAccountFundService;

    @Autowired
    WalletTransactionRecordService walletTransactionRecordService;

    @Autowired
    WalletTransactionAuditService walletTransactionAuditService;

    @PostMapping("/getWallet")
    public BaseModel getWallet (@RequestBody User user){
        BaseModel result = new BaseModel();
        WalletAccount walletAccount = walletAccountService.getById(user.getUser_id()) ;
        String active = walletAccount.getIs_active();
        if(active.equals("N")){
            result.code = 504;
        }else{
            result.code = 200;
            result.message = walletAccount.getAccount_name();
        }
        return result;
    }
    @PostMapping("/getroleid")
    public BaseModel getRoleId (@RequestBody User user){
        BaseModel result = new BaseModel();
        int user_id = user.getUser_id();
        user = userService.getById(user_id);
        String roleid = user.getRole_id();
        result.code = 200;
        result.message = roleid;

        return result;
    }
    @PostMapping("/getPassword")
    public BaseModel getPassword (@RequestBody User user){
        BaseModel result = new BaseModel();
        WalletAccount walletAccount = walletAccountService.getById(user.getUser_id()) ;
        String active = walletAccount.getIs_active();
        if(active.equals("N")){
            result.code = 504;
        }else{
            result.code = 200;
            result.message = walletAccount.getPassword();
        }
        return result;
    }

    @PostMapping("/updatePassword")
    public BaseModel updatePassword (@RequestBody UserIdAndPassword userIdAndPassword){
        BaseModel result = new BaseModel();
        WalletAccount walletAccount = walletAccountService.getById(userIdAndPassword.getUser_id()) ;
        walletAccount.setPassword(userIdAndPassword.getPassword());
        int result_walletAccount = walletAccountService.update(walletAccount);
        if(result_walletAccount !=1){
            throw BusinessException.UPDATE_FAIL;
        }
        result.code = 200;
        return result;
    }

    @PostMapping("/activate")
    public BaseModel activate(@RequestBody UseridAndAccount uaa){
        BaseModel result = new BaseModel();
        User user = userService.getById(uaa.getUser_id());
        if (user == null) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        WalletAccount walletAccount = walletAccountService.getById(uaa.getUser_id()) ;
        if(walletAccount==null){
            throw BusinessException.WALLET_NOT_EXISTS;
        }
        walletAccount.setAccount_name(uaa.getAccount_name());
        walletAccount.setPassword(uaa.getPassword());
        String name = userService.getById(uaa.getUser_id()).getName();
        walletAccount.setLast_update_by(name);
        walletAccount.setLast_update_time(Date.valueOf(now()));
        Timestamp datetime = new Timestamp(System.currentTimeMillis());
        walletAccount.setActive_time(datetime);
        walletAccount.setIs_active("Y");
        int result_walletAccount = walletAccountService.update(walletAccount);
        if(result_walletAccount !=1){
            throw BusinessException.UPDATE_FAIL;
        }
        WalletAccountFund walletAccountFund = new WalletAccountFund();
        walletAccountFund.setBuyer_id(uaa.getUser_id());
        BigDecimal Available_money = new BigDecimal(0);
        BigDecimal Depositing_money = new BigDecimal(0);
        BigDecimal Withdrawing_money = new BigDecimal(0);
        walletAccountFund.setAvailable_money(Available_money);
        walletAccountFund.setDepositing_money(Depositing_money);
        walletAccountFund.setWithdrawing_money(Withdrawing_money);
        walletAccountFund.setCreate_by(name);
        walletAccountFund.setLast_update_by(name);
        walletAccountFund.setCreate_time(datetime);
        walletAccountFund.setLast_update_time(datetime);
        walletAccountFund.setCurrency("RMB");
        int result_walletAccountFund = walletAccountFundService.insert(walletAccountFund);
        if (result_walletAccountFund != 1) {
            throw BusinessException.INSERT_FAIL;
        }
        result.code = 200;
        return result;
    }

    @PostMapping("/getAvailable_money")
    public BaseModel getAvailable_money(@RequestBody User user) {
        BaseModel result = new BaseModel();
        int user_id = user.getUser_id();
        if (user_id == 0) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        WalletAccount walletAccount = walletAccountService.getById(user_id);
        if (walletAccount == null) {
            throw BusinessException.WALLET_NOT_EXISTS;
        }
        if (walletAccount.getIs_active().equals("N")) {
            result.code = 504;
            result.message = "Nonactivated";
        } else {
            WalletAccountFund walletAccountFund = walletAccountFundService.getById(user_id);
            result.code = 200;
            result.message = walletAccountFund.getAvailable_money().toString();
        }
        return  result;
    }


    @PostMapping("/recharge")
    public BaseModel Recharge(@RequestBody Recharge recharge){
        BaseModel result = new BaseModel();
        User user = userService.getById(recharge.getUser_id());
        if (user == null) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        if (user.getRole_id().equals("2")){
            WalletAccount walletAccount = walletAccountService.getById(recharge.getUser_id());
           if(walletAccount.getPassword().equals(recharge.getPassword())){
               String name = walletAccount.getAccount_name();
               WalletAccountFund walletAccountFund = walletAccountFundService.getById(recharge.getUser_id());
               walletAccountFund.setDepositing_money(walletAccountFund.getDepositing_money().add(recharge.getDepositing_money()));
               walletAccountFund.setLast_update_by(user.getName());
               Timestamp datetime = new Timestamp(System.currentTimeMillis());
               walletAccountFund.setLast_update_time(datetime);
               int i = walletAccountFundService.update(walletAccountFund);
               if(i!=1){
                   throw BusinessException.UPDATE_FAIL;
               }
               WalletTransactionRecord walletTransactionRecord =new WalletTransactionRecord();
               walletTransactionRecord.setBuyer_id(recharge.getUser_id());
               walletTransactionRecord.setTransaction_type(1);
               walletTransactionRecord.setAccount_name(name);
               walletTransactionRecord.setTransaction_money(recharge.getDepositing_money());
               walletTransactionRecord.setStatus(1);
               walletTransactionRecord.setCreate_by(name);
               walletTransactionRecord.setLast_update_by(name);
               walletTransactionRecord.setCreate_time(datetime);
               walletTransactionRecord.setLast_update_time(datetime);
               int j = walletTransactionRecordService.insert(walletTransactionRecord);
               if(j!=1){
                   throw BusinessException.INSERT_FAIL;
               }
               WalletTransactionAudit walletTransactionAudit = new WalletTransactionAudit();

               walletTransactionAudit.setBuyer_id(recharge.getUser_id());
               walletTransactionAudit.setTransaction_id(walletTransactionRecord.getTransaction_id());
               walletTransactionAudit.setAvailable_money_before(walletAccountFund.getAvailable_money());
               walletTransactionAudit.setDepositing_money_before(walletAccountFund.getDepositing_money());
               walletTransactionAudit.setOperate_money(recharge.getDepositing_money());
               walletTransactionAudit.setOperate_type(1);
               walletTransactionAudit.setStatus(1);
               walletTransactionAudit.setAvailable_money_after(walletAccountFund.getAvailable_money().add(recharge.getDepositing_money()));
               walletTransactionAudit.setCreate_by(name);
               walletTransactionAudit.setLast_update_by(name);
               walletTransactionAudit.setCreate_time(datetime);
               walletTransactionAudit.setLast_update_time(datetime);
               int b = walletTransactionAuditService.insert(walletTransactionAudit);
               if(b!=1){
                   throw BusinessException.INSERT_FAIL;
               }
               result.code = 200;
               return  result;
           }else{
               throw BusinessException.PASSWORD_WRONG;
           }
        }else{
            throw BusinessException.PERMISSION_DENY;
        }
    }

    @PostMapping("/withdraw")
    public BaseModel Withdraw(@RequestBody Withdraw withdraw){
        BaseModel result = new BaseModel();
        User user = userService.getById(withdraw.getUser_id());
        if (user == null) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        if (user.getRole_id().equals("1")){
            WalletAccount walletAccount = walletAccountService.getById(withdraw.getUser_id());
            if(walletAccount.getPassword().equals(withdraw.getPassword())){
                String name = walletAccount.getAccount_name();
                WalletAccountFund walletAccountFund = walletAccountFundService.getById(withdraw.getUser_id());
                BigDecimal origin = walletAccountFund.getWithdrawing_money();
                walletAccountFund.setWithdrawing_money(walletAccountFund.getWithdrawing_money().add(withdraw.getWithdraw_money()));
                walletAccountFund.setLast_update_by(user.getName());
                Timestamp datetime = new Timestamp(System.currentTimeMillis());
                walletAccountFund.setLast_update_time(datetime);
                int i = walletAccountFundService.update(walletAccountFund);
                if(i!=1){
                    throw BusinessException.UPDATE_FAIL;
                }
                WalletTransactionRecord walletTransactionRecord =new WalletTransactionRecord();
                walletTransactionRecord.setBuyer_id(withdraw.getUser_id());
                walletTransactionRecord.setTransaction_type(2);
                walletTransactionRecord.setAccount_name(name);
                walletTransactionRecord.setTransaction_money(withdraw.getWithdraw_money());
                walletTransactionRecord.setStatus(1);
                walletTransactionRecord.setCreate_by(name);
                walletTransactionRecord.setLast_update_by(name);
                walletTransactionRecord.setCreate_time(datetime);
                walletTransactionRecord.setLast_update_time(datetime);
                int j = walletTransactionRecordService.insert(walletTransactionRecord);
                if(j!=1){
                    throw BusinessException.INSERT_FAIL;
                }
                WalletTransactionAudit walletTransactionAudit = new WalletTransactionAudit();

                walletTransactionAudit.setBuyer_id(withdraw.getUser_id());
                walletTransactionAudit.setTransaction_id(walletTransactionRecord.getTransaction_id());
                walletTransactionAudit.setAvailable_money_before(walletAccountFund.getAvailable_money());
                walletTransactionAudit.setWithdrawing_money_before(walletAccountFund.getWithdrawing_money());
                walletTransactionAudit.setOperate_money(withdraw.getWithdraw_money());
                walletTransactionAudit.setOperate_type(2);
                walletTransactionAudit.setStatus(1);
                walletTransactionAudit.setAvailable_money_after(walletAccountFund.getAvailable_money().subtract(withdraw.getWithdraw_money()));
                BigDecimal zero = new BigDecimal(0);
                if(walletTransactionAudit.getAvailable_money_after().compareTo(zero)<0){
                    walletTransactionRecordService.delete(walletTransactionRecord.getTransaction_id());
                    walletAccountFund.setWithdrawing_money(origin);
                    walletAccountFundService.update(walletAccountFund);
                    throw BusinessException.NOT_SUFFICIENT_FUNDS;
                }
                walletTransactionAudit.setCreate_by(name);
                walletTransactionAudit.setLast_update_by(name);
                walletTransactionAudit.setCreate_time(datetime);
                walletTransactionAudit.setLast_update_time(datetime);
                int b = walletTransactionAuditService.insert(walletTransactionAudit);
                if(b!=1){
                    throw BusinessException.INSERT_FAIL;
                }
                result.code = 200;
                return  result;
            }else{
                throw BusinessException.PASSWORD_WRONG;
            }
        }else{
            throw BusinessException.PERMISSION_DENY;
        }
    }

    @PostMapping("/getRecord")
    BaseModelJson<Map<String, Object>> getRecord(@RequestBody  User user){
        BaseModelJson<Map<String, Object>> response = new BaseModelJson();
        int user_id = user.getUser_id();

        if(user_id==0){
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        HashMap<String, Object> res = new HashMap<>();
        List<WalletTransactionRecord> list = walletTransactionRecordService.getAllById(user_id);
        res.put("WalletTransactionRecord", list);
        response.code = 200;
        response.data = res;
        return response;
    }

    @PostMapping("/getAudit")
    BaseModelJson<Map<String, Object>> getAudit(@RequestBody User user){
        BaseModelJson<Map<String, Object>> response = new BaseModelJson();
        int user_id = user.getUser_id();
        user = userService.getById(user_id);
        if(user_id==0){
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        String per = user.getRole_id();
        if(per.equals("0")) {
            HashMap<String, Object> res = new HashMap<>();
            List<WalletTransactionAudit> list = walletTransactionAuditService.getAll();
            List<String> namelist = new ArrayList<>();
            for(WalletTransactionAudit walletTransactionAudit:list){
                int id = walletTransactionAudit.getBuyer_id();
                String name = userService.getById(id).getUsername();
                namelist.add(name);
            }
            res.put("WalletTransactionAudit", list);
            res.put("name", namelist);
            response.code = 200;
            response.data = res;
            return response;
        }else{
            throw BusinessException.PERMISSION_DENY;
        }
    }


    @PostMapping("/adminAudit")
    public BaseModel adminAudit(@RequestBody Audit audit){
        BaseModel result = new BaseModel();
        User admin = userService.getById(audit.getAdmin_id());
        if (admin == null) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        User user = userService.getById(audit.getUser_id());
        if (user == null) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        String per = admin.getRole_id();
        if(per.equals("0")) {
            WalletAccountFund walletAccountFund = walletAccountFundService.getById(audit.getUser_id());
            WalletTransactionAudit walletTransactionAudit = walletTransactionAuditService.getById(audit.getTransaction_audit_id());
            int transaction_id =walletTransactionAudit.getTransaction_id();
            WalletTransactionRecord walletTransactionRecord = walletTransactionRecordService.getById(transaction_id);
            Timestamp datetime = new Timestamp(System.currentTimeMillis());
            int operate_type = walletTransactionAudit.getOperate_type();
            BigDecimal money = walletTransactionAudit.getOperate_money();
            if(audit.getStatus()==2){//管理员审核通过
                walletTransactionAudit.setStatus(2);
                walletTransactionAudit.setLast_update_by(admin.getName());
                walletTransactionAudit.setOperate_by(admin.getName());
                walletTransactionAudit.setLast_update_time(datetime);
                walletTransactionAuditService.update(walletTransactionAudit);
                walletTransactionRecord.setStatus(2);
                walletTransactionRecord.setOperator_name(admin.getName());
                walletTransactionRecord.setLast_update_by(admin.getName());
                walletTransactionRecord.setLast_update_time(datetime);
                walletTransactionRecordService.update(walletTransactionRecord);
                if(operate_type==1){
                    walletAccountFund.setAvailable_money(walletAccountFund.getAvailable_money().add(money));
                    walletAccountFund.setDepositing_money(walletAccountFund.getDepositing_money().subtract(money));
                    walletAccountFund.setLast_update_by(admin.getName());
                    walletAccountFund.setLast_update_time(datetime);
                }else if(operate_type==2){
                    walletAccountFund.setAvailable_money(walletAccountFund.getAvailable_money().subtract(money));
                    walletAccountFund.setWithdrawing_money(walletAccountFund.getWithdrawing_money().subtract(money));
                    walletAccountFund.setLast_update_by(admin.getName());
                    walletAccountFund.setLast_update_time(datetime);
                }
                walletAccountFundService.update(walletAccountFund);
            }else{//其余都为不通过
                walletTransactionAudit.setStatus(audit.getStatus());
                walletTransactionAudit.setLast_update_by(admin.getName());
                walletTransactionAudit.setOperate_by(admin.getName());
                walletTransactionAudit.setLast_update_time(datetime);
                walletTransactionAuditService.update(walletTransactionAudit);
                walletTransactionRecord.setStatus(audit.getStatus());
                walletTransactionRecord.setOperator_name(admin.getName());
                walletTransactionRecord.setLast_update_by(admin.getName());
                walletTransactionRecord.setLast_update_time(datetime);
                walletTransactionRecordService.update(walletTransactionRecord);
                if(operate_type==1){
                    walletAccountFund.setDepositing_money(walletAccountFund.getDepositing_money().subtract(money));
                    walletAccountFund.setLast_update_by(admin.getName());
                    walletAccountFund.setLast_update_time(datetime);
                }else if(operate_type==2){
                    walletAccountFund.setWithdrawing_money(walletAccountFund.getWithdrawing_money().subtract(money));
                    walletAccountFund.setLast_update_by(admin.getName());
                    walletAccountFund.setLast_update_time(datetime);
                }
                walletAccountFundService.update(walletAccountFund);
            }
            result.code = 200;
            return  result;
        }else{
            throw BusinessException.PERMISSION_DENY;
        }
    }

}



