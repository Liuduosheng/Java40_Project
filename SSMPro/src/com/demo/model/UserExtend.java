package com.demo.model;

/**
 * 用户的扩展类
 *
 */
public class UserExtend extends User{
    
    // 性别描述（对应字典表里的代码描述）
    private String user_sex_desc;
    
    // 学历描述（对应字典表里的代码描述）
    private String user_edu_desc;
    
    public String getUser_sex_desc() {
        return user_sex_desc;
    }

    public void setUser_sex_desc(String user_sex_desc) {
        this.user_sex_desc = user_sex_desc;
    }

    public String getUser_edu_desc() {
        return user_edu_desc;
    }

    public void setUser_edu_desc(String user_edu_desc) {
        this.user_edu_desc = user_edu_desc;
    }
}