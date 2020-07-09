package com.neusoft.bsp.admin.wallet.service.impl;

import com.neusoft.bsp.admin.wallet.mapper.WalletTransactionRecordMapper;
import com.neusoft.bsp.admin.wallet.po.WalletTransactionRecord;
import com.neusoft.bsp.admin.wallet.service.WalletTransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("WalletTransactionRecordService")
public class WalletTransactionRecordServiceImpl implements WalletTransactionRecordService {

    @Autowired
    WalletTransactionRecordMapper walletTransactionRecordMapper;
    @Override
    public int insert(WalletTransactionRecord walletTransactionRecord) {
        return walletTransactionRecordMapper.insert(walletTransactionRecord);
    }

    @Override
    public int update(WalletTransactionRecord walletTransactionRecord) {
        return walletTransactionRecordMapper.update(walletTransactionRecord);
    }

    @Override
    public int delete(int transaction_id) {
        return walletTransactionRecordMapper.delete(transaction_id);
    }

    @Override
    public WalletTransactionRecord getById(int transaction_id) {
        return walletTransactionRecordMapper.getById(transaction_id);
    }

    @Override
    public List<WalletTransactionRecord> getAll() {
        return walletTransactionRecordMapper.getAll();
    }

    @Override
    public List<WalletTransactionRecord> getAllById(Integer buyer_id) {
        return walletTransactionRecordMapper.getAllById(buyer_id);
    }
}
