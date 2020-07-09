package com.neusoft.bsp.admin.wallet.service;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.wallet.po.WalletAccount;

import java.util.List;
import java.util.Map;

public interface WalletAccountService {
    int insert(WalletAccount walletAccount);

    int update(WalletAccount walletAccount);

    int delete(int id);

    WalletAccount getById(int id);

    List<WalletAccount> getAll();

    List<WalletAccount> getAllByFilter(Map<String,Object> map);

    int registerWalletAccount(User user);
}
