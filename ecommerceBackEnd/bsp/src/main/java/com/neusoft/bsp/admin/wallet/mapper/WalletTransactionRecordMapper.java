package com.neusoft.bsp.admin.wallet.mapper;

import com.neusoft.bsp.admin.wallet.po.WalletAccountFund;

import com.neusoft.bsp.admin.wallet.po.WalletTransactionRecord;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

//@CacheConfig(cacheNames="walletTransactionRecordCache")
@Repository
public interface WalletTransactionRecordMapper extends BaseMapper<Integer, WalletTransactionRecord> {
//    @Cacheable()
    List<WalletTransactionRecord> getAllById(Integer buyer_id);
}
