package com.neusoft.bsp.admin.wallet.mapper;


import com.neusoft.bsp.admin.wallet.po.WalletTransactionAudit;

import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletTransactionAuditMapper extends BaseMapper<Integer, WalletTransactionAudit> {
    List<WalletTransactionAudit> getAllById(Integer buyer_id);
}
