package com.neusoft.bsp.admin.wallet.mapper;

import com.neusoft.bsp.admin.wallet.po.WalletAccount;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//@CacheConfig(cacheNames="walletAccountCache")
@Repository
public interface WalletAccountMapper extends BaseMapper<Integer, WalletAccount> {

}
