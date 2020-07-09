package com.neusoft.bsp.admin.wallet.service.impl;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.wallet.mapper.WalletAccountMapper;
import com.neusoft.bsp.admin.wallet.po.WalletAccount;
import com.neusoft.bsp.admin.wallet.service.WalletAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("WalletAccountService")
public class WalletAccountServiceImpl implements WalletAccountService {
    @Autowired
    WalletAccountMapper walletAccountMapper;

    @Override
    public int insert(WalletAccount walletAccount) {
        return walletAccountMapper.insert(walletAccount);
    }

    @Override
    public int update(WalletAccount walletAccount) {
        return walletAccountMapper.update(walletAccount);
    }

    @Override
    public int delete(int id) {
        return walletAccountMapper.delete(id);
    }

    @Override
    public WalletAccount getById(int id) {
        return walletAccountMapper.getById(id);
    }

    @Override
    public List<WalletAccount> getAll() {
        return walletAccountMapper.getAll();
    }

    @Override
    public List<WalletAccount> getAllByFilter(Map<String, Object> map) {
        return null;
    }

    @Override
    public int registerWalletAccount(User user) {
        WalletAccount walletAccount = new WalletAccount();
        walletAccount.setBuyer_id(user.getUser_id());
        walletAccount.setIs_active("N");
        walletAccount.setAccount_name(user.getRole_id());
        return insert(walletAccount);
    }
}
