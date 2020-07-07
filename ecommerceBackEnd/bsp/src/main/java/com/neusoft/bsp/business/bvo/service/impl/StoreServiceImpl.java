package com.neusoft.bsp.business.bvo.service.impl;

import com.neusoft.bsp.business.bvo.mapper.StoreMapper;
import com.neusoft.bsp.business.bvo.service.StoreService;
import com.neusoft.bsp.business.po.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("storeService")
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreMapper storeMapper;

    @Override
    public int insert(Store store) {
        return storeMapper.insert(store);
    }

    @Override
    public int update(Store store) {
        return storeMapper.update(store);
    }

    @Override
    public int delete(int str_id) {
        return storeMapper.delete(str_id);
    }

    @Override
    public Store getById(int str_id) {
        return storeMapper.getById(str_id);
    }

    @Override
    public List<Store> getAllByDsrId(int dsr_id) {
        return storeMapper.getAllByDsrId(dsr_id);
    }
}
