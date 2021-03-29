package com.bit.servlet.dao;

import java.util.List;

//추상 메서드의 선언
public interface EmailDao {

	public List<EmailVO> getList();
	
	public int insert(EmailVO vo);
	
	public int delete(Long no);
}
