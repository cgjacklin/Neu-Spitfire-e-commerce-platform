package com.neusoft.bsp.admin.wallet.mapper;
import com.neusoft.bsp.admin.wallet.po.WalletAccountFund;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

//@CacheConfig(cacheNames="walletAccountFundCache")
@Repository
public interface WalletAccountFundMapper  extends BaseMapper<Integer, WalletAccountFund> {
//    @Cacheable()
    List<WalletAccountFund> getAllById(Integer buyer_id);
}
