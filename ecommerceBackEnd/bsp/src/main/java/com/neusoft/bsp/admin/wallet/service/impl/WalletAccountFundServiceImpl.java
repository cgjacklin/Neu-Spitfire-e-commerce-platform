package com.neusoft.bsp.admin.wallet.service.impl;

import com.neusoft.bsp.admin.wallet.mapper.WalletAccountFundMapper;
import com.neusoft.bsp.admin.wallet.po.WalletAccountFund;
import com.neusoft.bsp.admin.wallet.service.WalletAccountFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("WalletAccountFundService")
public class WalletAccountFundServiceImpl implements WalletAccountFundService {

    @Autowired
    WalletAccountFundMapper walletAccountFundMapper;

    @Override
    public int insert(WalletAccountFund walletAccountFund) {
        return walletAccountFundMapper.insert(walletAccountFund);
    }

    @Override
    public int update(WalletAccountFund walletAccountFund) {
        return walletAccountFundMapper.update(walletAccountFund);
    }

    @Override
    public int delete(int buyer_id) {
        return walletAccountFundMapper.delete(buyer_id);
    }

    @Override
    public WalletAccountFund getById(int buyer_id) {
        return walletAccountFundMapper.getById(buyer_id);
    }

    @Override
    public List<WalletAccountFund> getAll() {
        return walletAccountFundMapper.getAll();
    }

    @Override
    public List<WalletAccountFund> getAllById(Integer buyer_id) {
        return walletAccountFundMapper.getAllById(buyer_id);
    }

}
