package com.bit.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmailDaoOrcImpl implements EmailDao {
	
	//커넥션 메서드
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
	public List<EmailVO> getList() {
		List<EmailVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT no,first_name,last_name,email,created_at FROM emaillist ORDER by created_at DESC";
			
			rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String first_name = rs.getString(2);
				String last_name = rs.getString(3);
				String email = rs.getString(4);
				Date createAt = rs.getDate(5);
				
				EmailVO vo = new EmailVO(no, last_name, first_name, email, createAt);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e ) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

	@Override
	public int insert(EmailVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO emaillist (no,last_name,first_name,email) VALUES(seq_emaillist_pk.nextval,?,?,?)";
		int insertedCount = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getLast_name());
			pstmt.setString(2, vo.getFirst_name());
			pstmt.setString(3, vo.getEmail());
			
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
	public int delete(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM emaillist where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			
			deletedCount = pstmt.executeUpdate();
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
		
		return deletedCount;
	}

}
