package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.walletAccountFund;

public interface walletAccountFundMapper {
    int insert(walletAccountFund record);

    int insertSelective(walletAccountFund record);
}