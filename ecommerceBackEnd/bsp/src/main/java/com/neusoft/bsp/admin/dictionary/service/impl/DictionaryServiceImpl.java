package com.neusoft.bsp.admin.dictionary.service.impl;

import com.neusoft.bsp.admin.dictionary.mapper.DictionaryMapper;
import com.neusoft.bsp.admin.dictionary.po.Dictionary;
import com.neusoft.bsp.admin.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("DictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    public int insert(Dictionary dictionary) {
        return dictionaryMapper.insert(dictionary);
    }

    @Override
    public int update(Dictionary dictionary) {
        return dictionaryMapper.update(dictionary);
    }

    @Override
    public int delete(int id) {
        return dictionaryMapper.delete(id);
    }

    @Override
    public Dictionary getById(int id) {
        return dictionaryMapper.getById(id);
    }

    @Override
    public List<Dictionary> getAll() {
        return dictionaryMapper.getAll();
    }

    @Override
    public List<Dictionary> getAllByFilter(Map<String, Object> map) {
        return dictionaryMapper.getAllByFilter(map);
    }

    @Override
    public int deleteDictionary(Dictionary dictionary) {
        int id = dictionary.getCdm_id();
        return delete(id);
    }
}
