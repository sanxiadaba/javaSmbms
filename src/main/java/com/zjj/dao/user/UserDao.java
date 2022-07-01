package com.zjj.dao.user;

import java.sql.Connection;
import java.util.List;

import com.zjj.pojo.User;

// user需要执行的操作
public interface UserDao {
    // 获取User
    public User getLoginUser(Connection connection, String userCode) throws Exception;

    // 修改当前用户密码
    public int updatePwd(Connection connection, int id, String pwd) throws Exception;

    // 通过条件查询用户
    public int getUserCount(Connection connection, String userName, int userRole) throws Exception;

    // 通过条件查询-userList
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)
            throws Exception;

    // 增加用户信息
    public int add(Connection connection, User user) throws Exception;

    // 通过userId删除user
    public int deleteUserById(Connection connection, Integer delId) throws Exception;

    // 修改用户信息
    public int modify(Connection connection, User user) throws Exception;

    // 通过userId获取user
    public User getUserById(Connection connection, String id) throws Exception;
}
