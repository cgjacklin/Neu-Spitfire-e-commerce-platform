package com.neusoft.bsp.admin.wallet.mapper;

import com.neusoft.bsp.admin.wallet.po.WalletAccountFund;

import com.neusoft.bsp.admin.wallet.po.WalletTransactionRecord;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletTransactionRecordMapper extends BaseMapper<Integer, WalletTransactionRecord> {
    List<WalletTransactionRecord> getAllById(Integer buyer_id);
}
