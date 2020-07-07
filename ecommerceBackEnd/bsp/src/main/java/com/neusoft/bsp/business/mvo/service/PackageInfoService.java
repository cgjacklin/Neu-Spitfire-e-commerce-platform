package com.neusoft.bsp.business.mvo.service;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.business.po.PackageInfo;
import com.neusoft.bsp.business.po.Product;
import com.neusoft.bsp.business.vo.ProductVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public interface PackageInfoService {
    int insert(PackageInfo packageInfo);

    int update(PackageInfo packageInfo);

    int delete(int pk);

    PackageInfo getByProduct(int product_id);
}
