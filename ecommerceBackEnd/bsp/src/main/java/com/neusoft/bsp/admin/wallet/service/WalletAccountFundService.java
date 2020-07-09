package com.neusoft.bsp.admin.wallet.service;

import com.neusoft.bsp.admin.wallet.po.WalletAccountFund;

import java.util.List;


public interface WalletAccountFundService {

    int insert(WalletAccountFund walletAccountFund);

    int update(WalletAccountFund walletAccountFund);

    int delete(int buyer_id);

    WalletAccountFund getById(int buyer_id);

    List<WalletAccountFund> getAll();

    List<WalletAccountFund> getAllById(Integer buyer_id);
}
