package com.neusoft.bsp.business.mvo.service;


import java.util.List;


public interface BrandService {

    int delete(Integer brd_id);

    int insert(Brand brand);

    List<Brand> getAllById(Integer man_id);

    int update(Brand brand);

    Brand getById(Integer brd_id);
}
