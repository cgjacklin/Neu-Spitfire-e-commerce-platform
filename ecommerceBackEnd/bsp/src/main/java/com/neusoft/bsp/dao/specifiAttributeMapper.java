package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.specifiAttribute;

public interface specifiAttributeMapper {
    int insert(specifiAttribute record);

    int insertSelective(specifiAttribute record);
}