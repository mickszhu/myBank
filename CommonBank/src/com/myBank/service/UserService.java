package com.myBank.service;

import com.myBank.User;

/**
 * @author mickzhu
 * @version 1.0
 * @date 2020/10/20 19:00
 */
public interface UserService {
    int register(User user);

    int save(String cardno,double money);

    int withdraw(String cardno,double money);

    int trans(String cardno1,String cardno2,double money);

    double queryMoney(String cardno);

    int updatePwd(String cardno,String pwd);

    User query(String username);

    boolean queryCardNo(String cardNo);
}
