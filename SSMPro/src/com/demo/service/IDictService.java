package com.demo.service;

import java.util.List;

import com.demo.model.Dict;

/**
 * 字典业务接口
 *
 */
public interface IDictService {
    
    /**
     * 根据字段获取字典
     * @param field
     * @return
     */
    public List<Dict> getDictByField(String field);
}