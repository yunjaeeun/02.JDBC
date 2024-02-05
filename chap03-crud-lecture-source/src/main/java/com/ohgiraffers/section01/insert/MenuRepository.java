package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MenuRepository {
    public int registMenu(Connection con, Menu registMenu) {
        PreparedStatement pstmt = null;
        int result = 0;

        Properties prop = new Properties();

        /* 설명. 쿼리는 XML 파일로부터 읽어와서 활용할 것 */
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section01/insert/mapper/menu-mapper.xml"));
            String query = prop.getProperty("insertMenu");

//            System.out.println(query);

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, registMenu.getMenuName());
            pstmt.setInt(2, registMenu.getMenuPrice());
            pstmt.setInt(3, registMenu.getCategoryCode());
            pstmt.setString(4, registMenu.getOrderableStatus());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public void selectMenu(Connection con, Menu selectMenu) {
        PreparedStatement pstmt = null;

        Properties prop = new Properties();

        ResultSet rset = null;

        /* 설명. 쿼리는 XML 파일로부터 읽어와서 활용할 것 */
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section01/insert/mapper/select-test.xml"));
            String query = prop.getProperty("selectTest");

            System.out.println(query);

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, selectMenu.getCategoryCode());

            rset = pstmt.executeQuery();
            while (rset.next()){
                System.out.println(rset.getString("MENU_NAME"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}