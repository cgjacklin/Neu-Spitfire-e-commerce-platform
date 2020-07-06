package com.neusoft.bsp.business.mvo.service.impl;


import com.neusoft.bsp.business.mvo.mapper.BrandMapper;
import com.neusoft.bsp.business.mvo.service.BrandService;
import com.neusoft.bsp.business.po.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public List<Brand> getAllById(Integer manid) {
        return brandMapper.getAllById(manid);
    }

    @Override
    public int update(Brand record) {
        return brandMapper.update(record);
    }
}
