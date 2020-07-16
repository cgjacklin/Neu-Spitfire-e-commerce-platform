package com.neusoft.bsp;

import com.neusoft.bsp.admin.dictionary.po.Dictionary;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.controller.DictionaryController;
import io.swagger.annotations.Authorization;
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
class DictionaryTest {

    @Autowired
    DictionaryController dictionaryController;

    @Test
    void TestgetDictionaries_success() {

        BaseModelJson<List<Dictionary>> bmj = dictionaryController.getDictionaries();
        assertEquals(200, bmj.code);
    }

    @Test
    void TestgetDictionaries_nothing() {
        assertThrows(BusinessException.class, () -> {

            BaseModelJson<List<Dictionary>> bmj = dictionaryController.getDictionaries();
        });
    }

    @Test
    void TestaddDictionary_success() {
        Dictionary dictionary =new Dictionary();
        dictionary.setCode_type("2");
        BaseModel bm = dictionaryController.addDictionary(dictionary);
        assertEquals(200, bm.code);
    }
//update dictionary
    @Test
    void TestupdateDictionary_success() {
        Dictionary dictionary =new Dictionary();
        dictionary.setCdm_id(13);
        dictionary.setCode_type("3");

        BaseModel bm = dictionaryController.updateDictionary(dictionary);
        assertEquals(200, bm.code);
    }

//delete dictionary
    @Test
    void TestdeleteDictionary_success() {
        Dictionary dictionary =new Dictionary();
        dictionary.setCdm_id(13);
        dictionary.setCode_type("3");

        BaseModel bm = dictionaryController.deleteDictionary(dictionary);
        assertEquals(200, bm.code);
    }



}
