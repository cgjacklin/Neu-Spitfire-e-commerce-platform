package com.neusoft.bsp;

import com.neusoft.bsp.admin.dictionary.po.Dictionary;
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
            int user_id = 1;
            BaseModelJson<List<Dictionary>> bmj = dictionaryController.getDictionaries();
        });
    }




}
