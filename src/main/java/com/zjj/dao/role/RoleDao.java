package com.zjj.dao.role;

import com.zjj.pojo.Role;

import java.sql.Connection;
import java.util.List;

public interface RoleDao {
    public List<Role> getRoleList(Connection connection)throws Exception;
}
