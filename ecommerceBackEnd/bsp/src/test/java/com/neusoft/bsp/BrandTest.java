package com.neusoft.bsp;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.business.po.Brand;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.controller.BrandController;
import com.neusoft.bsp.controller.WalletController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =BspApplication.class)
 class BrandTest {
    @Autowired
    BrandController brandController;

    @Test
    void getBrand_success() {
        User user=new User();
        user.setUser_id(1);

        BaseModelJson<List<Brand>> bmj = brandController.getBrand(user);

        assertEquals(200, bmj.code);
    }

    @Test
    void getBrand_noUser() {
        User user=new User();
        user.setUser_id(17);

        assertThrows(BusinessException.class, () -> {
            BaseModelJson<List<Brand>> bmj = brandController.getBrand(user);
        });
    }

//    @Test
//    void deleteBrand_success() {
//        User user=new User();
//        user.setUser_id(1);
//        Brand brand=new Brand();
//        brand.setBrd_id(2);
//        BaseModel bmj = brandController.deleteBrand(brand);
//        assertEquals(200, bmj.code);
//    }
    @Test
    void deleteBrand_noBrand() {
        Brand brand=new Brand();
        brand.setBrd_id(80);
        assertThrows(BusinessException.class, () -> {
            BaseModel bmj = brandController.deleteBrand(brand);
        });
    }





}
