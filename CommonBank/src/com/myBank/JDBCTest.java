package com.myBank;

import com.myBank.control.UserControlImpl;
import com.myBank.dao.UserDaoImpl;
import com.myBank.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author mickzhu
 * @version 1.0
 * @date 2020/10/20 10:04
 */
public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        UserControlImpl userControlImpl = new UserControlImpl();
        userControlImpl.showMenu();
    }

    /**
     *
     */
    public static void updatePwdTest() {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        int row = userServiceImpl.updatePwd("23977", "55555");
        System.out.println(row);
    }

    /**
     * 查询余额
     */
    public static void queryTest() {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        double money = userServiceImpl.queryMoney("23422223");
        System.out.println(money);
    }

    /**
     * 用户转账测试
     */
    public static void transTest() throws SQLException {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        int row = userDaoImpl.trans("23422223", "23977", 900);
        System.out.println(row);
    }

    /**
     * 用户存款测试
     */
    public static void saveTest() throws SQLException {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        int row = userDaoImpl.updateMoney("23422223", 10000);
        System.out.println(row);
    }

    /**
     * 添加用户测试
     */
    public static void addUserTest() throws SQLException {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        User user = new User();
        user.setCardNo("23422223");
        user.setIdentity("VIP");
        user.setUserName("donmo");
        user.setPassword("666");
        user.setPhone("18216492988");
        user.setBalance(0);

        int row = userDaoImpl.addUser(user);
        System.out.println(row);
    }

    /**
     * 连接测试
     */
    public static void ConnectTest() throws SQLException {
        Connection connection = JdbcUtil.getConn();

        System.out.println(connection);
    }
}