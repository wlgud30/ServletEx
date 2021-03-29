package com.bit.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserDaoOrcImpl implements UserDao {
	
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			
			conn = DriverManager.getConnection(dburl, "C##KJH", "1234");
			
		} catch (ClassNotFoundException e) {
			System.err.println("클래스를 찾을 수 없습니다.");
		}
		
		return conn;
	}

	@Override
	public int insert(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO users (no,name,password,email,gender) VALUES(seq_users_pk.nextval,?,?,?,?)";
		int insertedCount = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getGender());
			
			insertedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(Exception e ) {
				e.printStackTrace();
			}
		}
		return insertedCount;
	}

	@Override
	public UserVO getUserByEmailAndPW(String email, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		UserVO vo = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			//만약에 레코드가 있다면 -> 사용자가 있다는뜻
			if(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String pw = rs.getString(3);
				String eml = rs.getString(4);
				String gender = rs.getString(5);
				Date created_at = rs.getDate(6);
				
				vo = new UserVO(no,name,pw,eml,gender,created_at);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(Exception e ) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}

}
