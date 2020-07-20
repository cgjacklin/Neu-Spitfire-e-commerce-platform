package com.neusoft.bsp.admin.user.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.admin.user.po.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Map;

//@CacheConfig(cacheNames="userCache")
@Repository
public interface UserMapper extends BaseMapper<Integer, User> {
//    @Cacheable()
    public User getByUsername(String username);
//    @Cacheable()
    User getBuyerOrSeller(Map<String, Object> map);
//    @Cacheable()
    int updateBasicInfo(User user);
}
