package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.walletTransactionRecord;

public interface walletTransactionRecordMapper {
    int insert(walletTransactionRecord record);

    int insertSelective(walletTransactionRecord record);
}