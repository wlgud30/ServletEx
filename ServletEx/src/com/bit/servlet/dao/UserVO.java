package com.bit.servlet.dao;

import java.util.Date;

public class UserVO {
	//필드
	private Long no;
	private String name;
	private String pw;
	private String email;
	private String gender;
	private Date created_at;
	
	public UserVO() {
	
	}

	public UserVO(String name, String pw, String email, String gender) {
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.gender = gender;
	}

	public UserVO(Long no, String name, String pw, String email, String gender, Date created_at) {
		this(name,pw,email,gender);
		this.no = no;
		this.created_at = created_at;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "UserVO [no=" + no + ", name=" + name + ", pw=" + pw + ", email=" + email + ", gender=" + gender
				+ ", created_at=" + created_at + "]";
	}
	
	
	

}
