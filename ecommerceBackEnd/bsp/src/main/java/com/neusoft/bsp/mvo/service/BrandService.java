package com.neusoft.bsp.mvo.service;

import com.neusoft.bsp.mvo.entity.Brand;

public interface BrandService {

    int delete(Integer brdId);

    int insert(Brand record);

    Brand getById(Integer brdId);

    int update(Brand record);

}
