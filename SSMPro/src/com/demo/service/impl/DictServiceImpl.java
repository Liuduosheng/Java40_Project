package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IDictDao;
import com.demo.model.Dict;
import com.demo.service.IDictService;

@Service
public class DictServiceImpl implements IDictService{
    
    /**
     * 自动装配
     */
    @Autowired
    private IDictDao dictDao;
    /**
     * 根据字段获取字典
     * @param field
     * @return
     */
    public List<Dict> getDictByField(String field){
        return dictDao.getDictByField(field);
    }

}