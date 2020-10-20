package com.myBank.dao;

import com.myBank.User;

import java.sql.SQLException;

/**
 * @author mickzhu
 * @version 1.0
 * @date 2020/10/20 18:58
 */
public interface UserDao {
    //添加用户
    int addUser(User user) throws SQLException;

    //存款 or 取款
    int updateMoney(String cardno,double money) throws SQLException;

    //转账
    int trans(String cardno1,String cardno2,double money) throws SQLException;

    //查询
    User query(String username) throws SQLException;

    boolean queryCardNo(String cardno) throws SQLException;

    //修改密码
    int updatePwd(String cardno,String pwd) throws SQLException;

}