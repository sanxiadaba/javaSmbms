package com.zjj.service.Provider;

import java.util.List;

import com.zjj.pojo.Provider;

public interface ProviderService {
    // 通过供应商名称、编码获取供应商列表-模糊查询-providerList
    List<Provider> getProviderList(String proName, String proCode);

    // 增加供应商
    boolean add(Provider provider);

    // 通过proId删除Provider
    int deleteProviderById(String delId);

    // 修改供应商信息
    boolean modify(Provider provider);

    // 通过proId获取Provider
    Provider getProviderById(String id);
}
