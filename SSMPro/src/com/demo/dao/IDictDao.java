package com.demo.dao;

import java.util.List;

import com.demo.model.Dict;

public interface IDictDao {
    
    /**
     * 根据字段获取字典
     * @param field
     * @return
     */
    public List<Dict> getDictByField(String field);
}