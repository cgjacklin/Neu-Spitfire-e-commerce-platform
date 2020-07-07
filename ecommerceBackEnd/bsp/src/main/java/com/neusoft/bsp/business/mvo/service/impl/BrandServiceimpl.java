package com.neusoft.bsp.business.mvo.service.impl;


import com.neusoft.bsp.business.mvo.mapper.BrandMapper;
import com.neusoft.bsp.business.mvo.service.BrandService;
import com.neusoft.bsp.business.po.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("BrandService")
public class BrandServiceimpl implements BrandService {


    @Autowired
    BrandMapper brandMapper;

    @Override
    public int delete(Integer brd_id) {
        return brandMapper.delete(brd_id);
    }

    @Override
    public int insert(Brand brand) {
        return brandMapper.insert(brand);
    }

    @Override
    public List<Brand> getAllById(Integer man_id) {
        return brandMapper.getAllById(man_id);
    }

    @Override
    public int update(Brand brand) {
        return brandMapper.update(brand);
    }

    @Override
    public Brand getById(Integer brd_id) {
        return brandMapper.getById(brd_id);
    }
}
