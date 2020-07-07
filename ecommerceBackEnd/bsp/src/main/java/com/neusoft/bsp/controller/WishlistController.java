package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.business.bvo.service.WishlistService;
import com.neusoft.bsp.business.mvo.service.ProductService;
import com.neusoft.bsp.business.po.Product;
import com.neusoft.bsp.business.po.Wishlist;
import com.neusoft.bsp.business.vo.UserIdAndProId;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/wit")
public class WishlistController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    WishlistService wishlistService;


    @Autowired
    ProductService productService;

    @PostMapping("/getWishlist")
    public BaseModelJson<Map<String, Object>> getWishlist(@Validated({SelectGroup.class}) @RequestBody int user_id) {
        User user = userService.getById(user_id);
        BaseModelJson<Map<String, Object>> response = new BaseModelJson();
        if (user == null) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        int dsr_id = user.getMan_buyer_id();
        response.code = 200;
        if (dsr_id != 0) {
            HashMap<String, Object> res = new HashMap<>();
            List<Wishlist> list = wishlistService.getAllById(dsr_id);
            for (Wishlist wishlist : list) {
                int pro_id = wishlist.getPro_id();
//                Product pro = productService


                res.put("list", wishlist);
            }
            response.data = res;
        }
        return response;
    }


//    @PostMapping("/addWishlist")
//    public BaseModel addWishlist(@Validated({InsertGroup.class}) @RequestBody BrandWithUserId brdu, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
//                    new Object[]{brdu.toString()});
//        }else{
//            BaseModel result = new BaseModel();
//            Brand brd = new Brand(brdu.getName_en(),brdu.getRemark());
//            String name = userService.getById(brdu.getUser_id()).getName();
//            int manid = userService.getById(brdu.getUser_id()).getMan_buyer_id();
//            brd.setMan_id(manid);
//            brd.setCreated_by(name);
//            brd.setLast_update_by(name);
//            brd.setLast_update_date(Date.valueOf(now()));
//            brd.setCreation_date(Date.valueOf(now()));
//            brd.setCall_cnt(0);
//            int result_brd = brandService.insert(brd);
//            if (result_brd != 1) {
//                throw BusinessException.INSERT_FAIL;
//            }
//            else{
//                result.code = 200;
//                return result;
//            }
//        }
//    }




}



