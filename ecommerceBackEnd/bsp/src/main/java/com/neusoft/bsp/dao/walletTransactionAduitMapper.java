package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.walletTransactionAduit;

public interface walletTransactionAduitMapper {
    int insert(walletTransactionAduit record);

    int insertSelective(walletTransactionAduit record);
}