package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/* 설명. JDBC 연결을 위한 메소드만 따로 모듈화(Connection 객체 생성, close메소드 처리(Connection, Statement, PreparedStatement) */
public class JDBCTemplate {
    public static Connection getConnection() {
        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            Class.forName(driver);

            con = DriverManager.getConnection(url, prop);       // url, prop의 키 값을 가지고 db와 통신할 수 있는 길을 만듦

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    public static void close(Connection con) {
        try {
            if (con != null && !con.isClosed())
                con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(Statement stmt) {
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(ResultSet rset) {
        try {
            if (rset != null && !rset.isClosed())
                rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
