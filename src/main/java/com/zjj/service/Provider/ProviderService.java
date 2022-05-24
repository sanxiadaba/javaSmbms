package com.zjj.service.Provider;

import com.zjj.pojo.Provider;

import java.util.List;

public interface ProviderService {
    /**
     * 通过供应商名称、编码获取供应商列表-模糊查询-providerList
     * @param proName
     * @return
     */
    List<Provider> getProviderList(String proName, String proCode);
    /**
     * 增加供应商
     * @param provider
     * @return
     */
    boolean add(Provider provider);
    /**
     * 通过proId删除Provider
     * @param delId
     * @return
     */
    int deleteProviderById(String delId);
    /**
     * 修改供应商信息
     * @param provider
     * @return
     */
    boolean modify(Provider provider);
    /**
     * 通过proId获取Provider
     * @param id
     * @return
     */
    Provider getProviderById(String id);
}
