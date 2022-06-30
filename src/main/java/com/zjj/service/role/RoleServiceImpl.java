package com.zjj.service.role;

import com.zjj.dao.BaseDao;
import com.zjj.dao.role.RoleDao;
import com.zjj.dao.role.RoleDaoImpl;
import com.zjj.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    @Override
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;
        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return roleList;
    }

    @Test
    public void test() {
        RoleService roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        System.out.println(Arrays.toString(roleList.toArray()));
    }
}