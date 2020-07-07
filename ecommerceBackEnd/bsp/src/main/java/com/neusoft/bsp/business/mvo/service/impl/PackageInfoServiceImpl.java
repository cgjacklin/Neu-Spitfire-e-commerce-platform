package com.neusoft.bsp.business.mvo.service.impl;

import com.neusoft.bsp.business.mvo.mapper.PackageInfoMapper;
import com.neusoft.bsp.business.mvo.service.PackageInfoService;
import com.neusoft.bsp.business.po.PackageInfo;
import com.neusoft.bsp.business.po.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("packageInfoServiceImpl")
public class PackageInfoServiceImpl implements PackageInfoService {
    @Autowired
    PackageInfoMapper packageInfoMapper;

    @Override
    public int insert(PackageInfo packageInfo) {
        return packageInfoMapper.insert(packageInfo);
    }

    @Override
    public int update(PackageInfo packageInfo) {
        return packageInfoMapper.updateByPrimaryKeySelective(packageInfo);
    }

    @Override
    public int delete(int pk) {
        return packageInfoMapper.deleteByPrimaryKey(pk);
    }

    @Override
    public PackageInfo getByProduct(int product_id) {
        return packageInfoMapper.getByProduct(product_id);
    }
}
