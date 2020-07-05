package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.codeMaster;

public interface codeMasterMapper {
    int insert(codeMaster record);

    int insertSelective(codeMaster record);
}