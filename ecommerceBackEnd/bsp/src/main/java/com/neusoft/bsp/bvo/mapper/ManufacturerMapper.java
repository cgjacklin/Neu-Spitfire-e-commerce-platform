package com.neusoft.bsp.bvo.mapper;

import com.neusoft.bsp.bvo.entity.*;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerMapper extends BaseMapper<Integer, Manufacturer> {
    int updateUserWithLastManu(int user_id);
}
