package com.zjj.service.bill;

import java.util.List;

import com.zjj.pojo.Bill;

public interface BillService {
    // 增加订单
    boolean add(Bill bill);

    // 通过条件获取订单列表-模糊查询-billList
    List<Bill> getBillList(Bill bill);

    // 通过billId删除Bill
    boolean deleteBillById(String delId);

    // 通过billId获取Bill
    Bill getBillById(String id);

    // 修改订单信息
    boolean modify(Bill bill);

}
