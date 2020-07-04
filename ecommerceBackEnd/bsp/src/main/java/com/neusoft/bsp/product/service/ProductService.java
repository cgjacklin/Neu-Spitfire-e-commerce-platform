package com.neusoft.bsp.product.service;

import com.neusoft.bsp.product.entity.Product;
import com.neusoft.bsp.user.entity.User;
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

    int addProduct(Product product, MultipartFile file);

    int updateProduct(Product product, MultipartFile file);

    int deleteProduct(Product product);
}
