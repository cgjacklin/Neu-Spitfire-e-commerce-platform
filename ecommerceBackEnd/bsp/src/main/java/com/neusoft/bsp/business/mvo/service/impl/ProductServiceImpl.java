package com.neusoft.bsp.business.mvo.service.impl;

import com.neusoft.bsp.business.mvo.service.BrandService;
import com.neusoft.bsp.business.mvo.service.ManufacturerService;
import com.neusoft.bsp.business.mvo.service.PackageInfoService;
import com.neusoft.bsp.business.po.Brand;
import com.neusoft.bsp.business.po.PackageInfo;
import com.neusoft.bsp.business.vo.ProductVO;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.business.po.Product;
import com.neusoft.bsp.business.mvo.mapper.ProductMapper;
import com.neusoft.bsp.business.mvo.service.ProductService;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.utils.FileNameUtils;
import com.neusoft.bsp.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    UserService userService;
    @Autowired
    ManufacturerService manufacturerService;
    @Autowired
    BrandService brandService;
    @Autowired
    PackageInfoService packageInfoService;

    @Override
    public int insert(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public int update(Product product) {
        return productMapper.update(product);
    }

    @Override
    public int delete(int pk) {
        return productMapper.delete(pk);
    }

    @Override
    public List<Product> getAll() {
        return productMapper.getAll();
    }

    @Override
    public List<Product> getAllByFilter(Map<String, Object> map) {

        return productMapper.getAllByFilter(map);
    }

    @Override
    public Product getById(int pd) {
        return productMapper.getById(pd);
    }

    @Override
    public List<ProductVO> getProducts(User user) {
        int man_id = userService.getById(user.getUser_id()).getMan_buyer_id();
        if(man_id==0){
            throw BusinessException.NO_MAN_ID;
        }
        List<Brand> brands = brandService.getAllById(man_id);
        if (brands.equals(null)||brands.size()==0){
            throw BusinessException.NO_BRAND;
        }

        Map<String, Object> para= new HashMap<>();
        para.put("man_id", man_id);
        List<Product> products = getAllByFilter(para);
        List<ProductVO> productVOS = new ArrayList<>();
        if(products.size()==0){
            throw BusinessException.NO_PRODUCT;
        }else{
            for(Product pro: products){
                //获取product对应brand和packageinfo
                ProductVO productVO = new ProductVO(pro);
                Brand brand = brandService.getById(pro.getBrd_id());
                PackageInfo packageInfo = packageInfoService.getByProduct(pro.getPro_id());
                //配置VO package
                productVO.setAmazon_description(packageInfo.getAmazon_description());
                productVO.setEbay_description(packageInfo.getEbay_description());
                productVO.setWidth(packageInfo.getWidth());
                productVO.setHeight(packageInfo.getHeight());
                productVO.setLength(packageInfo.getLength());
                productVO.setWeight(packageInfo.getWeight());
                productVO.setName_en(brand.getName_en());
                productVOS.add(productVO);
                //配置VO product
            }
        }

        return productVOS;
    }

    @Override
    public int addProduct(ProductVO productvo, MultipartFile file) {
        User user = userService.getById(productvo.getUser_id());
        PackageInfo packageInfo = new PackageInfo();
        // 要上传的目标文件存放路径
//        String localPath = "src/main/resources/static/upload";
        String localPath = "E:/Develop/Files/Photos";
        // 上传成功或者失败的提示
//        ClassPathResource classPathResource = new ClassPathResource("static/upload");
//        InputStream inputStream = classPathResource.getInputStream();

        //存时间
        long time = System.currentTimeMillis();
        Date date = new java.sql.Date(time);
        Product product = new Product(productvo);
//        System.out.println(productvo.toString());
        //存package信息
        packageInfo.setAmazon_description(productvo.getAmazon_description());
        packageInfo.setEbay_description(productvo.getEbay_description());
        packageInfo.setWeight(productvo.getWeight());
        packageInfo.setHeight(productvo.getHeight());
        packageInfo.setLength(productvo.getLength());
        packageInfo.setWidth(productvo.getWidth());

        //存prodcut信息
        product.setCreated_by(user.getUsername());
        product.setLast_update_by(user.getUsername());
        product.setMan_id(user.getMan_buyer_id());
        product.setCreation_date(date);
        product.setLast_update_date(date);

        //存图片
        String fileName = FileNameUtils.getFileName(file.getOriginalFilename());
        if (FileUtils.upload(file, localPath, fileName)){
            //处理路径
            String realPath = localPath + "/" + fileName;
            product.setRemark(realPath);

            insert(product);
            packageInfo.setProId(product.getPro_id());
            packageInfoService.insert(packageInfo);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateProduct(ProductVO productvo, MultipartFile file) {
        User user = userService.getById(productvo.getUser_id());
        PackageInfo packageInfo = packageInfoService.getByProduct(productvo.getPro_id());
        System.out.println();
        System.out.println();
        System.out.println(packageInfo.toString());
        //更新product信息
        Product product = getById(productvo.getPro_id());
        long time = System.currentTimeMillis();
        Date date = new java.sql.Date(time);
        product.setCreation_date(date);
        product.setLast_update_date(date);
        product.setLast_update_by(user.getUsername());
        product.setMan_id(user.getMan_buyer_id());
        //存package信息
        packageInfo.setAmazon_description(productvo.getAmazon_description());
        packageInfo.setEbay_description(productvo.getEbay_description());
        packageInfo.setWeight(productvo.getWeight());
        packageInfo.setHeight(productvo.getHeight());
        packageInfo.setLength(productvo.getLength());
        packageInfo.setWidth(productvo.getWidth());

        //存图片
//        String localPath = "src/main/resources/static/upload";
        String localPath = "E:/Develop/Files/Photos";
        String fileName = FileNameUtils.getFileName(file.getOriginalFilename());
        if (FileUtils.upload(file, localPath, fileName)){
            String realPath = localPath + "/" + fileName;
            product.setRemark(realPath);
            update(product);
            packageInfoService.update(packageInfo);
            return 1;
        }else {
            return 0;

        }
    }

    @Override
    public int deleteProduct(Product product) {
        delete(product.getPro_id());
        return 1;
    }

    @Override
    public int updateSts(Product product) {
        return productMapper.updateSts(product);
    }

    @Override
    public List<ProductVO> getProductsOnShelf() {
        List<Product> products = productMapper.getProductOnShelf();
        List<ProductVO> productVOS = new ArrayList<>();
        if(products.size()==0){
            throw BusinessException.NO_PRODUCT;
        }else{
            for(Product pro: products){
                //获取product对应brand和packageinfo
                ProductVO productVO = new ProductVO(pro);
                Brand brand = brandService.getById(pro.getBrd_id());
                PackageInfo packageInfo = packageInfoService.getByProduct(pro.getPro_id());
                //配置VO package
                productVO.setAmazon_description(packageInfo.getAmazon_description());
                productVO.setEbay_description(packageInfo.getEbay_description());
                productVO.setWidth(packageInfo.getWidth());
                productVO.setHeight(packageInfo.getHeight());
                productVO.setLength(packageInfo.getLength());
                productVO.setWeight(packageInfo.getWeight());
                productVO.setName_en(brand.getName_en());
                productVOS.add(productVO);
                //配置VO product
            }
        }

        return productVOS;
    }
}
