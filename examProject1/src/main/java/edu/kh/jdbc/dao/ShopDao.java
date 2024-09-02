
package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kh.jdbc.dto.ShopMember;

public class ShopDao {

    // 필드
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public ShopMember selectMember(Connection conn, String memberId) {

        ShopMember sm = null;  // 반환할 객체 초기화

        try {
            // SQL 쿼리 작성
            String sql = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID = ?";
            pstmt = conn.prepareStatement(sql);// PreparedStatement 객체 생성
            pstmt.setString(1, memberId);// 쿼리의 첫 번째 ?에 memberId 값 설정
            rs = pstmt.executeQuery(); // 쿼리 실행 후 결과를 ResultSet에 저장

            // 결과가 있을 경우 ShopMember 객체 생성
            if (rs.next()) {
                String id = rs.getString("MEMBER_ID");
                String pw = rs.getString("MEMBER_PW");
                String phone = rs.getString("PHONE");
                String gender = rs.getString("성별");

                sm = new ShopMember(id, pw, phone, gender);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();  // ResultSet 닫기
                if(pstmt != null) pstmt.close();  // PreparedStatement 닫기
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return sm;  // 결과 반환
    }
}



