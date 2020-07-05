package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.monitorResult;

public interface monitorResultMapper {
    int insert(monitorResult record);

    int insertSelective(monitorResult record);
}