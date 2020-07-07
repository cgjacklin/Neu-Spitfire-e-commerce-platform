package com.neusoft.bsp.business.mvo.service;

import com.neusoft.bsp.business.po.Product;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.business.vo.ProductVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public interface ProductService {
    int insert(Product product);

    int update(Product product);

    int delete(int pk);

    List<Product> getAll();

    List<Product> getAllByFilter(Map<String, Object> map);

    List<Product> getProducts(User user);

    int addProduct(ProductVO productvo, MultipartFile file);

    int updateProduct(ProductVO productvo, MultipartFile file);

    int deleteProduct(Product product);
}
