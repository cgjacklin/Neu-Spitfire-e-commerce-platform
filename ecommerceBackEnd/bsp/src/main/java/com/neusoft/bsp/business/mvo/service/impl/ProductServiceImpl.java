package com.neusoft.bsp.business.mvo.service.impl;

import com.neusoft.bsp.business.bvo.mapper.WishlistMapper;
import com.neusoft.bsp.business.bvo.service.WishlistService;
import com.neusoft.bsp.business.mvo.service.BrandService;
import com.neusoft.bsp.business.mvo.service.ManufacturerService;
import com.neusoft.bsp.business.mvo.service.PackageInfoService;
import com.neusoft.bsp.business.po.Brand;
import com.neusoft.bsp.business.po.PackageInfo;
import com.neusoft.bsp.business.po.Wishlist;
import com.neusoft.bsp.business.vo.ProductVO;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.business.po.Product;
import com.neusoft.bsp.business.mvo.mapper.ProductMapper;
import com.neusoft.bsp.business.mvo.service.ProductService;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.controller.WishlistController;
import com.neusoft.bsp.utils.FileNameUtils;
import com.neusoft.bsp.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.util.*;

@Service("ProductService")
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
    @Autowired
    WishlistMapper wishlistMapper;
    @Value("${winPath}")
    String realPath;

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
        String role_id = userService.getById(user.getUser_id()).getRole_id();
        if(man_id==0 && !role_id.equals("0")){
            throw BusinessException.NO_MAN_ID;
        }
//        List<Brand> brands = brandService.getAllById(man_id);
//        if (brands.equals(null)||brands.size()==0){
//            throw BusinessException.NO_BRAND;
//        }

        Map<String, Object> para= new HashMap<>();
        para.put("man_id", man_id);
        para.put("role_id", role_id);
        System.out.println(role_id);
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
    public String uploadPicture(MultipartFile uploadFile, HttpServletRequest request) {
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下

//        String realPath = new String("ecommerceBackEnd/bsp/src/main/resources/static/upload");
        //存放上传文件的文件夹
//        File file = new File(realPath);
        File file = new File("/image/");
        System.out.println("-----------存放上传文件的文件夹【"+ file +"】-----------");
        System.out.println("-----------输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径【"+ file.getAbsolutePath() +"】-----------");
        if(!file.isDirectory()){
            //递归生成文件夹
            file.mkdirs();
        }
        String fileName = FileNameUtils.getFileName(uploadFile.getOriginalFilename());
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称

        try {
            //构建真实的文件路径
            File newFile = new File(file.getAbsolutePath() + File.separator + fileName);
            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
            uploadFile.transferTo(newFile);
//            uploadFile.transferTo(new File(tmp.getAbsoluteFile()+File.separator+fileName));
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/image/" + fileName;
//            logger.info("-----------【"+ filePath +"】-----------");
            System.out.println(filePath);
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NOPHOTO";

    }





    @Override
    public int addProduct(ProductVO productvo) {
        User user = userService.getById(productvo.getUser_id());
        PackageInfo packageInfo = new PackageInfo();
        // 要上传的目标文件存放路径
//        String localPath = "src/main/resources/static/upload";
//        String localPath = "E:/Develop/Files/Photos";
        // 上传成功或者失败的提示
//        ClassPathResource classPathResource = new ClassPathResource("static/upload");
//        InputStream inputStream = classPathResource.getInputStream();

        //存时间
        long time = System.currentTimeMillis();
        Date date = new java.sql.Date(time);
        Product product = new Product(productvo);
        System.out.println("BRDDDID"+product.getBrd_id());
//        System.out.println(productvo.toString());
        //存package信息
        packageInfo.setAmazon_description(productvo.getAmazon_description());
        packageInfo.setEbay_description(productvo.getEbay_description());
        packageInfo.setWeight(productvo.getWeight());
        packageInfo.setHeight(productvo.getHeight());
        packageInfo.setLength(productvo.getLength());
        packageInfo.setWidth(productvo.getWidth());

        //存product信息
        product.setCreated_by(user.getUsername());
        product.setLast_update_by(user.getUsername());
        product.setMan_id(user.getMan_buyer_id());
        product.setCreation_date(date);
        product.setLast_update_date(date);
        product.setSts_cd("Not in warehouse");

        product.setRemark(productvo.getRemark());

        insert(product);
        packageInfo.setProId(product.getPro_id());
        packageInfoService.insert(packageInfo);
        return 1;

//        //存图片
//        String fileName = FileNameUtils.getFileName(file.getOriginalFilename());
//        if (FileUtils.upload(file, localPath, fileName)){
//            //处理路径
//            String realPath = localPath + "/" + fileName;
//            insert(product);
//            packageInfo.setProId(product.getPro_id());
//            packageInfoService.insert(packageInfo);
//            return 1;
//        }
//        return 0;
    }

    @Override
    public ProductVO getProduct(Product product) {
        int pro_id = product.getPro_id();
        Product productReal = getById(pro_id);
        ProductVO productVO = new ProductVO(getById(pro_id));
        Brand brand = brandService.getById(productReal.getBrd_id());
        PackageInfo packageInfo = packageInfoService.getByProduct(productReal.getPro_id());
        //配置VO package
        productVO.setAmazon_description(packageInfo.getAmazon_description());
        productVO.setEbay_description(packageInfo.getEbay_description());
        productVO.setWidth(packageInfo.getWidth());
        productVO.setHeight(packageInfo.getHeight());
        productVO.setLength(packageInfo.getLength());
        productVO.setWeight(packageInfo.getWeight());
        productVO.setName_en(brand.getName_en());
        return  productVO;
    }

    @Override
    public int updateProduct(ProductVO productvo) {
        User user = userService.getById(productvo.getUser_id());
        PackageInfo packageInfo = packageInfoService.getByProduct(productvo.getPro_id());
        System.out.println();
        System.out.println();
//        System.out.println(packageInfo.toString());
        System.out.println();
        System.out.println();
        //更新product信息
        Product product = new Product(productvo);
        long time = System.currentTimeMillis();
        Date date = new java.sql.Date(time);
//        product.setCreation_date(date);
        product.setLast_update_date(date);
        product.setLast_update_by(user.getUsername());
        product.setMan_id(user.getMan_buyer_id());
        product.setTitle(productvo.getTitle());

        //存package信息
        packageInfo.setAmazon_description(productvo.getAmazon_description());
        packageInfo.setEbay_description(productvo.getEbay_description());
        packageInfo.setWeight(productvo.getWeight());
        packageInfo.setHeight(productvo.getHeight());
        packageInfo.setLength(productvo.getLength());
        packageInfo.setWidth(productvo.getWidth());

        product.setRemark(productvo.getRemark());
        update(product);
        packageInfoService.update(packageInfo);
        return 1;
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
    public List<ProductVO> getProductsOnShelf(User user_id) {
        List<Product> products = productMapper.getProductOnShelf();
        List<ProductVO> productVOS = new ArrayList<>();
        User user = userService.getById(user_id.getUser_id());
        System.out.println("MANBUYERIDDDD: "+user.getMan_buyer_id());
        List<Wishlist> wishlists = wishlistMapper.getAllById(user.getMan_buyer_id());
        List<Integer> wishProId = new LinkedList<>();
        for(Wishlist wishlist: wishlists){
            wishProId.add(wishlist.getPro_id());
        }

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
                //配置VO star
                if(wishProId.contains(pro.getPro_id())){
                    productVO.setStar(1);
                }
                else{
                    productVO.setStar(2);
                }
            }
        }

        return productVOS;
    }
}
