package com.neusoft.bsp.bvo.service.impl;

import com.neusoft.bsp.bvo.entity.Manufacturer;
import com.neusoft.bsp.bvo.mapper.ManufacturerMapper;
import com.neusoft.bsp.bvo.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("manufacturerService")
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    ManufacturerMapper manufacturerMapper;

    @Override
    public int insert(Manufacturer manufacturer) {
        return manufacturerMapper.insert(manufacturer);
    }

    @Override
    public int update(Manufacturer manufacturer) {
        return manufacturerMapper.update(manufacturer);
    }

    @Override
    public int delete(int man_id) {
        return manufacturerMapper.delete(man_id);
    }

    @Override
    public Manufacturer getById(int man_id) {
        return manufacturerMapper.getById(man_id);
    }

    @Override
    public int updateUserWithLastManu(int user_id) {
        return manufacturerMapper.updateUserWithLastManu(user_id);
    }
}
