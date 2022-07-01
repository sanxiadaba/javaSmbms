package com.zjj.dao.provider;

import java.sql.Connection;
import java.util.List;

import com.zjj.pojo.Provider;

public interface ProviderDao {
    // 通过供应商名称、编码获取供应商列表-模糊查询-providerList
    public List<Provider> getProviderList(Connection connection, String proName, String proCode) throws Exception;

    // 增加供应商
    public int add(Connection connection, Provider provider) throws Exception;

    // 通过proId删除Provider

    public int deleteProviderById(Connection connection, String delId) throws Exception;

    // 修改供应商信息
    public int modify(Connection connection, Provider provider) throws Exception;

    // 通过proId获取Provider
    public Provider getProviderById(Connection connection, String id) throws Exception;
}
