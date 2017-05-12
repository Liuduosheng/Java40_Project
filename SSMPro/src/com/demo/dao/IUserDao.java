package com.demo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.demo.model.User;
import com.demo.model.UserExtend;

public interface IUserDao {
    
    /**
     * 查询用户信息并分页
     * @param skip
     * @param size
     * @return
     */
    public List<UserExtend> queryUserPager(@Param("skip") int skip,@Param("size") int size);
    
    /**
     * 查询用户总数
     * @return
     */
    public int queryUserCount();
    
    /**
     * 根据用户id查询用户
     * @param userid
     * @return
     */
    public User queryUserById(int userid);
    
    /**
     * 新增用户
     * @param user
     * @return
     */
    public int insertUser(User user);
    
    /**
     * 修改用户
     * @param user
     * @return
     */
    public int updateUser(User user);
    
    /**
     * 根据用户id删除用户
     * @param user_id
     * @return
     */
    public int deleteUserById(int user_id);
    
    /**
     * 删除多个用户
     * @param userIds
     * @return
     */
    public int deleteUsers(int[] userIds);
}