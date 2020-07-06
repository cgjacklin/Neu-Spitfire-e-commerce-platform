package com.neusoft.bsp.mvo.mapper;

import com.neusoft.bsp.mvo.entity.*;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerMapper extends BaseMapper<Integer, Manufacturer> {
    int updateUserWithLastManu(int user_id);
}
