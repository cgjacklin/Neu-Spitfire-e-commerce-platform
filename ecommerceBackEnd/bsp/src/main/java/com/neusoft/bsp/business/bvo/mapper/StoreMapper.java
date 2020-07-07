package com.neusoft.bsp.business.bvo.mapper;

import com.neusoft.bsp.business.po.Store;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreMapper extends BaseMapper<Integer, Store> {

    List<Store> getAllByDsrId(int dsr_id);
}
