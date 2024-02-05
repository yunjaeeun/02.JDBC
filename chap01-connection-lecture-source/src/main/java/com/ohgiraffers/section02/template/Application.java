package com.ohgiraffers.section02.template;

import java.sql.Connection;

/* 설명. import 뒤에 static을 붙이고 메소드명까지 쓰게되면 다른 클래스의 static 메소드를 마치 내 class에 있는 것처럼 사용할 수 있다. */
import static com.ohgiraffers.section02.template.JDBCTemplate.close;
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {
//        Connection con = JDBCTemplate.getConnection();
        /* 설명. Connection에서 연결점을 찾고 아래 비즈니스 로직에서 쿼리문 실행 */
        Connection con = getConnection();

        /* 설명. 비즈니스 로직(트랙잭션 처리) 실행 */

        System.out.println("con = " + con);

        close(con);
    }
}
