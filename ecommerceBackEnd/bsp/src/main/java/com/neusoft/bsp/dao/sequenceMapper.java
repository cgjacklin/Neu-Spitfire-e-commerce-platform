package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.sequence;

public interface sequenceMapper {
    int insert(sequence record);

    int insertSelective(sequence record);
}