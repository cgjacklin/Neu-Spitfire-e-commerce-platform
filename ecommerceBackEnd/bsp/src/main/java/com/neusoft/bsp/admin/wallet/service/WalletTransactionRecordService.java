package com.neusoft.bsp.admin.wallet.service;

import com.neusoft.bsp.admin.wallet.po.WalletTransactionRecord;

import java.util.List;

public interface WalletTransactionRecordService {

    int insert(WalletTransactionRecord walletTransactionRecord);

    int update(WalletTransactionRecord walletTransactionRecord);

    int delete(int transaction_id);

    WalletTransactionRecord getById(int transaction_id);

    List<WalletTransactionRecord> getAll();

    List<WalletTransactionRecord> getAllById(Integer buyer_id);
}
