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
import com.neusoft.bsp.admin.wallet.vo.Recharge;
import com.neusoft.bsp.admin.wallet.vo.UseridAndAccount;
import com.neusoft.bsp.admin.wallet.vo.Withdraw;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
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
    public BaseModel getAvailable_money(@RequestBody int user_id) {
        BaseModel result = new BaseModel();
        User user = userService.getById(user_id);
        if (user == null) {
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
    BaseModelJson<Map<String, Object>> getRecord(@RequestBody int user_id){
        BaseModelJson<Map<String, Object>> response = new BaseModelJson();
        User user = userService.getById(user_id);
        if(user==null){
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        HashMap<String, Object> res = new HashMap<>();
        List<WalletTransactionRecord> list = walletTransactionRecordService.getAllById(user_id);
        int j = 0;
        for (WalletTransactionRecord walletTransactionRecord : list) {
            String s = String.valueOf(j);
            res.put("WalletTransactionRecord"+j, walletTransactionRecord);
            j++;
        }
        response.code = 200;
        response.data = res;
        return response;
    }

    @PostMapping("/getAudit")
    BaseModelJson<Map<String, Object>> getAudit(@RequestBody int user_id){
        BaseModelJson<Map<String, Object>> response = new BaseModelJson();
        User user = userService.getById(user_id);
        if(user==null){
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        String per = user.getRole_id();
        if(per.equals("0")) {

            HashMap<String, Object> res = new HashMap<>();
            List<WalletTransactionAudit> list = walletTransactionAuditService.getAll();
            int j = 0;
            for (WalletTransactionAudit walletTransactionAudit : list) {
                String s = String.valueOf(j);
                res.put("WalletTransactionAudit"+j, walletTransactionAudit);
                j++;
            }
            response.code = 200;
            response.data = res;
            return response;
        }else{
            throw BusinessException.PERMISSION_DENY;
        }




    }
}



