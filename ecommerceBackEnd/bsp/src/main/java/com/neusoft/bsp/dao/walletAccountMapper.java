package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.walletAccount;

public interface walletAccountMapper {
    int insert(walletAccount record);

    int insertSelective(walletAccount record);
}