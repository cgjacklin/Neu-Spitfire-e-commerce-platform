package com.neusoft.bsp;

import com.neusoft.bsp.admin.parameter.po.Parameter;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.business.vo.ParameterVO;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.controller.ParameterController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =BspApplication.class)
class ParameterTest {
    @Autowired
    ParameterController parameterController;
    @Test
    void test_getParameter_success() {

        BaseModelJson<List<Parameter>> bmj = parameterController.getParameter();
        assertEquals(200, bmj.code);
    }

    @Test
    void testaddParameter_success() {
        ParameterVO parameter=new ParameterVO();
        parameter.setParam_cd("aaa");
        parameter.setUser_id(1);
        BaseModel bm= parameterController.addParameter(parameter);
        assertEquals(200, bm.code);
    }

    @Test
    void test_addParameter_sameParam_cd() {
        ParameterVO parameter=new ParameterVO();
        parameter.setParam_cd("aaa");
        parameter.setUser_id(1);
        assertThrows(BusinessException.class, () -> {
            BaseModel bm= parameterController.addParameter(parameter);
        });
    }

    @Test
    void TestupdateParameter_success() {
        ParameterVO parameter=new ParameterVO();
        parameter.setParam_cd("a");
        parameter.setPar_id(18);
        parameter.setUser_id(1);
        BaseModel bm= parameterController.updateParameter(parameter);
        assertEquals(200, bm.code);
    }

    @Test
    void test_updateParameter_sameParam_cd() {
        ParameterVO parameter=new ParameterVO();
        parameter.setParam_cd("ajj");
        parameter.setPar_id(18);
        parameter.setUser_id(1);
        assertThrows(BusinessException.class, () -> {
            BaseModel bm= parameterController.updateParameter(parameter);
        });
    }

    @Test
    void test_deleteParameter_sameParam_cd() {
        ParameterVO parameter=new ParameterVO();
        parameter.setPar_id(18);
        parameter.setUser_id(1);
        BaseModel bm= parameterController.deleteParameter(parameter);
        assertEquals(200, bm.code);
    }

}
