package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.admin.wallet.po.WalletAccount;
import com.neusoft.bsp.admin.wallet.po.WalletAccountFund;
import com.neusoft.bsp.admin.wallet.service.WalletAccountFundService;
import com.neusoft.bsp.admin.wallet.service.WalletAccountService;
import com.neusoft.bsp.admin.wallet.service.impl.WalletAccountFundServiceImpl;
import com.neusoft.bsp.admin.wallet.vo.UseridAndAccount;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

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
        walletAccountFund.setBuyer_id(walletAccount.getBuyer_id());
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
        if(result_walletAccountFund!=1){
            throw BusinessException.INSERT_FAIL;
        }
        result.code = 200;
        return result;

    }

}
