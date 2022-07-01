package com.zjj.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

//操作数据库的公共类
public class BaseDao {
    // 静态代码块,在类加载的时候执行，且只执行一次
    static {
        init();
    }

    // 配置文件的各个参数
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    // 初始化连接参数,从配置文件里获得
    public static void init() {
        Properties properties = new Properties();
        String configFile = "db.properties";
        // 通过类加载器去读取对应的资源
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream(configFile);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    // 获取数据库连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回一个数据库连接
        return connection;
    }

    // 编写查询公共类
    // 传入：连接、PreparedStatement、结果集的返回对象、要执行的sql、参数列表
    public static ResultSet execute(Connection connection, PreparedStatement pstm, ResultSet rs, String sql,
            Object[] params) throws Exception {
        // 预编译的sql，执行的时候不需要传sql,防止sql注入
        // 参见文章 https://www.jianshu.com/p/245a05eef716
        pstm = connection.prepareStatement(sql);
        // 占位符替换
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i + 1, params[i]);
        }
        rs = pstm.executeQuery();
        return rs;
    }

    // 编写增删改公共类
    public static int execute(Connection connection, PreparedStatement pstm,
            String sql, Object[] params) throws Exception {
        int updateRows = 0;
        pstm = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i + 1, params[i]);
        }
        updateRows = pstm.executeUpdate();
        // 删改增都是update,返回的是操作收到影响的行数
        return updateRows;
    }

    // 释放资源
    public static boolean closeResource(Connection connection, PreparedStatement pstm, ResultSet rs) {
        boolean flag = true;
        if (rs != null) {
            try {
                rs.close();
                rs = null;// GC回收
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
                pstm = null;// GC回收
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if (connection != null) {
            try {
                connection.close();
                connection = null;// GC回收
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }
}