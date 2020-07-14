package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.business.bvo.service.WishlistService;
import com.neusoft.bsp.business.mvo.service.BrandService;
import com.neusoft.bsp.business.mvo.service.PackageInfoService;
import com.neusoft.bsp.business.mvo.service.ProductService;
import com.neusoft.bsp.business.po.Brand;
import com.neusoft.bsp.business.po.PackageInfo;
import com.neusoft.bsp.business.po.Product;
import com.neusoft.bsp.business.po.Wishlist;
import com.neusoft.bsp.business.vo.UserIdAndProId;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalDate.now;

@CrossOrigin
@RestController
@RequestMapping("/wit")
public class WishlistController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    WishlistService wishlistService;

    @Autowired
    BrandService brandService;

    @Autowired
    ProductService productService;

    @Autowired
    PackageInfoService packageInfoService;

    @PostMapping("/getWishlist")
    public BaseModelJson<Map<String, Object>> getWishlist(@Validated({SelectGroup.class}) @RequestBody User user1) {
        User user = userService.getById(user1.getUser_id());
        BaseModelJson<Map<String, Object>> response = new BaseModelJson();
        if (user == null) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        int dsr_id = user.getMan_buyer_id();
        response.code = 200;
        if (dsr_id != 0) {
            HashMap<String, Object> res = new HashMap<>();
            List<Wishlist> wishlist1 = wishlistService.getAllById(dsr_id);
            List<Product> pro1 = new ArrayList<Product>();
            List<PackageInfo> pio1 = new ArrayList<PackageInfo>();
            List<Brand> brand1 = new ArrayList<Brand>();
            int j = 0;
            for (Wishlist wishlist : wishlist1) {
                int pro_id = wishlist.getPro_id();
                Product pro = productService.getById(pro_id);
                pro1.add(pro);
                PackageInfo pio = packageInfoService.getByProduct(pro_id);
                pio1.add(pio);
                int brd_id = pro.getBrd_id();
                Brand brand = brandService.getById(brd_id);
                brand1.add(brand);
                j++;
            }
            res.put("wishlist",wishlist1);
            res.put("product",pro1);
            res.put("packageinfo",pio1);
            res.put("brand",brand1);
            res.put("number",j);
            response.data = res;
        }
        return response;
    }


    @PostMapping("/addWishlist")
    public BaseModel addWishlist(@Validated({InsertGroup.class}) @RequestBody UserIdAndProId uap, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{uap.toString()});
        }else{
            BaseModel result = new BaseModel();
            Wishlist wit = new Wishlist(uap.getPro_id());
            User user = userService.getById(uap.getUser_id());
            if(user == null){
                throw BusinessException.USERNAME_NOT_EXISTS;
            }
            String name = userService.getById(uap.getUser_id()).getName();
            int dsr_id = userService.getById(uap.getUser_id()).getMan_buyer_id();
            wit.setDsr_id(dsr_id);
            wit.setCreated_by(name);
            wit.setLast_update_by(name);
            wit.setLast_update_date(Date.valueOf(now()));
            wit.setCreation_date(Date.valueOf(now()));
            wit.setCall_cnt(0);
            wit.setPro_id(uap.getPro_id());
//            wit.setRemark();
//            wit.setSts_cd();
            int result_wit = wishlistService.insert(wit);
            if (result_wit != 1) {
                throw BusinessException.INSERT_FAIL;
            }
            else{
                result.code = 200;
                return result;
            }
        }
    }

    @PostMapping("/deletedWishlist")
    public BaseModel deletedWishlist(@RequestBody Wishlist wit_id) {
        int i = wishlistService.delete(wit_id.getWit_id());
        BaseModel result = new BaseModel();
        if(i!=1){
            throw BusinessException.DELETE_FAIL;
        }else{
            result.code = 200;
            return result;
        }
    }


//    @PostMapping("/updateWishlist")
//    public BaseModel updateWishlist(@Validated({UpdateGroup.class}) @RequestBody BrandWithBrdId brdu, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {    //传值错误
//            throw BusinessException.UPDATE_FAIL.newInstance(this.getErrorResponse(bindingResult),
//                    new Object[]{brdu.toString()});
//        }else{
//            BaseModel result = new BaseModel();
//            Brand brand = brandService.getById(brdu.getBrd_id());
//            String name = userService.getById(brdu.getUser_id()).getName();
//            brand.setLast_update_date(Date.valueOf(now()));
//            brand.setLast_update_by(name);
//            brand.setName_en(brdu.getName_en());
//            brand.setRemark(brdu.getRemark());
//            int i =brandService.update(brand);
//            if(i!=1){
//                throw BusinessException.UPDATE_FAIL;
//            }else{
//                result.code = 200;
//                return result;
//            }
//        }
//    }

}



