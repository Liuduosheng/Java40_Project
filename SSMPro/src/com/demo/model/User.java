package com.demo.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

//用户类
public class User {
    
    //用户id
    private int user_id;
    //姓名
    @NotEmpty(message="{user_name.notEmpty}")
    private String user_name;
    //性别
    @NotEmpty(message="{user_sex.notEmpty}")
    private String user_sex;
    //出生日期
    @NotEmpty(message="{user_birthday.notEmpty}")
    private String user_birthday;
    //邮箱
    @NotEmpty(message="{user_email.notEmpty}")
    @Email(message="{user_email.wrong}")
    private String user_email;
    //学历
    @NotEmpty(message="{user_edu.notEmpty}")
    private String user_edu;
    //联系方式
    @NotEmpty(message="{user_telephone.notEmpty}")
    private String user_telephone;
    //住址
    private String user_address;
    
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_sex() {
        return user_sex;
    }
    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }
    public String getUser_birthday() {
        return user_birthday;
    }
    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }
    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    public String getUser_edu() {
        return user_edu;
    }
    public void setUser_edu(String user_edu) {
        this.user_edu = user_edu;
    }
    public String getUser_telephone() {
        return user_telephone;
    }
    public void setUser_telephone(String user_telephone) {
        this.user_telephone = user_telephone;
    }
    public String getUser_address() {
        return user_address;
    }
    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
    
}
