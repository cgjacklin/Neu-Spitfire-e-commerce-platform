package com.neusoft.bsp.admin.dictionary.service.impl;

import com.neusoft.bsp.admin.dictionary.mapper.DictionaryMapper;
import com.neusoft.bsp.admin.dictionary.po.Dictionary;
import com.neusoft.bsp.admin.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("DictionaryService")
@CacheConfig(cacheNames="dictionaryCache")
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    @CachePut(key = "#dictionary.cdm_id")
    public int insert(Dictionary dictionary) {
        return dictionaryMapper.insert(dictionary);
    }

    @Override
    @CachePut(key = "#dictionary.cdm_id")
    public int update(Dictionary dictionary) {
        return dictionaryMapper.update(dictionary);
    }

    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public int delete(int id) {
        return dictionaryMapper.delete(id);
    }

    @Override
//    @Cacheable(key = "root.args[0]")
    public Dictionary getById(int id) {
        return dictionaryMapper.getById(id);
    }

    @Override
//    @Cacheable("dictionaryList")
    public List<Dictionary> getAll() {
        return dictionaryMapper.getAll();
    }

    @Override
//    @Cacheable(key = "#dictionary.cdm_id")
    public List<Dictionary> getAllByFilter(Map<String, Object> map) {
        return dictionaryMapper.getAllByFilter(map);
    }

    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public int deleteDictionary(Dictionary dictionary) {
        int id = dictionary.getCdm_id();
        return delete(id);
    }
}
