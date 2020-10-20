package com.myBank;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author mickzhu
 * @version 1.0
 * @date 2020/10/19 19:57
 */
public class JdbcUtil {

    private static String driver =null;
    private static String url = null;
    private static String name = null;
    private static String pwd = null;

    static {
        try {
            //读取配置文件
            InputStream rs = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(rs);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            name = properties.getProperty("name");
            pwd = properties.getProperty("pwd");

            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        Connection connection =null;
        try {
            connection = DriverManager.getConnection(url,name,pwd);
        } catch (SQLException e) {
            System.out.println("获取连接池失败");
            e.printStackTrace();
        }
        return  connection;
    }

    public static void  close(Connection connection, Statement statement,ResultSet rst){
        if (rst !=null) {
            try {
                rst.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (statement !=null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection !=null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //提供一个专门执行dml语句的方法
    public static int executeUDI(String sql,Object[] params) throws Exception{
        Connection conn = getConn();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for(int i=0;params!=null&&i<params.length;i++){
            pstmt.setObject(i+1, params[i]);
        }
        return pstmt.executeUpdate();
    }

    //提供一个转么执行select语句的方法，返回对象集合
    public static ArrayList executeQuery(String sql, Object[] params){
        //....
        return null;
    }

}
