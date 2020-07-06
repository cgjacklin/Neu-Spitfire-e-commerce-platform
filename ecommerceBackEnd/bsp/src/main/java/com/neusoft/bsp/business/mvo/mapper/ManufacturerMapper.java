package com.neusoft.bsp.business.mvo.mapper;

import com.neusoft.bsp.business.po.Manufacturer;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerMapper extends BaseMapper<Integer, Manufacturer> {
    int updateUserWithLastManu(int user_id);
}
