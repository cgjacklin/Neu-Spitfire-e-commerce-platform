package com.neusoft.bsp.business.mvo.mapper;

import com.neusoft.bsp.business.po.Brand;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper extends BaseMapper<Integer, Brand> {
    List<Brand> getAllById(Integer manid);

}
