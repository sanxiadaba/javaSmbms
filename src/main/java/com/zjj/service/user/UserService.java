package com.zjj.service.user;

import java.util.List;

import com.zjj.pojo.User;

public interface UserService {
    // 用户登录
    User login(String userCode, String userPassword);

    // 根据userId修改密码
    boolean updatePwd(int id, String pwd);

    // 根据条件查询用户表记录数
    int getUserCount(String queryUserName, int queryUserRole);

    // 根据条件查询用户列表
    List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);

    // 增加用户信息
    boolean add(User user);

    // 根据ID删除user
    boolean deleteUserById(Integer delId);

    // 修改用户信息
    boolean modify(User user);

    // 根据userCode查询出User
    User selectUserCodeExist(String userCode);

    // 根据ID查找user
    User getUserById(String id);

}
