package com.neusoft.bsp.mvo.service.impl;

import com.neusoft.bsp.mvo.entity.Brand;
import com.neusoft.bsp.mvo.mapper.BrandMapper;
import com.neusoft.bsp.mvo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("brandService")
public class BrandServiceimpl implements BrandService {


    @Autowired
    BrandMapper brandMapper;
    @Override
    public int delete(Integer brdId) {
        return brandMapper.delete(brdId);
    }

    @Override
    public int insert(Brand record) {
        return brandMapper.insert(record);
    }

    @Override
    public Brand getById(Integer brdId) {
        return brandMapper.getById(brdId);
    }

    @Override
    public int update(Brand record) {
        return brandMapper.update(record);
    }
}
