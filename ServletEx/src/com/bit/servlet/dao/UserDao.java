package com.bit.servlet.dao;

public interface UserDao {
	
	public int insert(UserVO vo);
	
	public UserVO getUserByEmailAndPW(String email,String pw);

}
