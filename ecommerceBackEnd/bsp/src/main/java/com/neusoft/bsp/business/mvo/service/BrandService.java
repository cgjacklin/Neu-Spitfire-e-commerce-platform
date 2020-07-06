package com.neusoft.bsp.business.mvo.service;


import com.neusoft.bsp.business.po.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {

    int delete(Integer brdId);

    int insert(Brand record);

    List<Brand> getAllById(Integer manid);

    int update(Brand record);

}
