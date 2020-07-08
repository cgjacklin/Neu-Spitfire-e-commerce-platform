package com.neusoft.bsp.admin.dictionary.service;

import com.neusoft.bsp.admin.dictionary.po.Dictionary;
import com.neusoft.bsp.admin.parameter.po.Parameter;

import java.util.List;
import java.util.Map;

public interface DictionaryService {
    int insert(Dictionary dictionary);

    int update(Dictionary dictionary);

    int delete(int id);

    int deleteDictionary(Dictionary dictionary);

    Dictionary getById(int id);

    List<Dictionary> getAll();

    List<Dictionary> getAllByFilter(Map<String,Object> map);

}
