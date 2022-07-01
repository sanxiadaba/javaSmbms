package com.zjj.service.bill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.zjj.dao.BaseDao;
import com.zjj.dao.bill.BillDao;
import com.zjj.dao.bill.BillDaoImpl;
import com.zjj.pojo.Bill;

public class BillServiceImpl implements BillService {
    private BillDao billDao;

    public BillServiceImpl() {
        billDao = new BillDaoImpl();
    }

    @Override
    public boolean add(Bill bill) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            /*
             * 默认的话为自动提交，
             * 当没执行一个update ,delete或者insert的时候都会自动提交到数据库，无法回滚事务。
             * setAutoCommit总的来说就是保持数据的完整性，一个系统的更新操作可能要涉及多张表，需多个SQL语句进行操作
             * 循环里连续的进行插入操作，如果你在开始时设置了：conn.setAutoCommit(false);
             * 最后才进行conn.commit(),这样你即使插入的时候报错，修改的内容也不会提交到数据库，
             * 而如果你没有手动的进行setAutoCommit(false);
             * 出错时就会造成，前几条插入，后几条没有
             * 会形成脏数据~~
             */

            connection.setAutoCommit(false);// 开启JDBC事务管理
            if (billDao.add(connection, bill) > 0) {
                flag = true;
            }
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            // 在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public List<Bill> getBillList(Bill bill) {
        Connection connection = null;
        List<Bill> billList = null;
        System.out.println("query productName ---- > " + bill.getProductName());
        System.out.println("query providerId ---- > " + bill.getProviderId());
        System.out.println("query isPayment ---- > " + bill.getIsPayment());

        try {
            connection = BaseDao.getConnection();
            billList = billDao.getBillList(connection, bill);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return billList;

    }

    @Override
    public boolean deleteBillById(String delId) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (billDao.deleteBillById(connection, delId) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public Bill getBillById(String id) {
        Bill bill = null;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            bill = billDao.getBillById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
            bill = null;
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return bill;
    }

    @Override
    public boolean modify(Bill bill) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (billDao.modify(connection, bill) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
