package com.demo.model;


//字典类
public class Dict {
    
    //字典id
    private int dictid;
    //对照字段
    private String field;
    //对照字段名称
    private String fieldname;
    //代码
    private String code;
    //代码描述
    private String codedesc;
    
    public int getDictid() {
        return dictid;
    }
    public void setDictid(int dictid) {
        this.dictid = dictid;
    }
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getFieldname() {
        return fieldname;
    }
    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCodedesc() {
        return codedesc;
    }
    public void setCodedesc(String codedesc) {
        this.codedesc = codedesc;
    }
}