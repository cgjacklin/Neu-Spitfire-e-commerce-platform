package com.neusoft.bsp.admin.wallet.mapper;


import com.neusoft.bsp.admin.wallet.po.WalletTransactionAudit;

import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

//@CacheConfig(cacheNames="walletTransactionAuditCache")
@Repository
public interface WalletTransactionAuditMapper extends BaseMapper<Integer, WalletTransactionAudit> {
//    @Cacheable()
    List<WalletTransactionAudit> getAllById(Integer buyer_id);
}
