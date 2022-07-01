package com.zjj.dao.role;

import java.sql.Connection;
import java.util.List;

import com.zjj.pojo.Role;

public interface RoleDao {
    public List<Role> getRoleList(Connection connection) throws Exception;
}
