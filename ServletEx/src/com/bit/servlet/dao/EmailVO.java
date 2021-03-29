package com.bit.servlet.dao;

import java.util.Date;

public class EmailVO {
	//필드
	private Long no;			//pk
	private String last_name;
	private String first_name;
	private String email;
	private Date created_at;
	
	public EmailVO() {
		
	}

	public EmailVO(String last_name, String first_name, String email) {
		this.last_name = last_name;
		this.first_name = first_name;
		this.email = email;
	}

	public EmailVO(String last_name, String first_name, String email, Date created_at) {
		this(last_name,first_name,email);
		this.created_at = created_at;
	}

	public EmailVO(Long no, String last_name, String first_name, String email, Date created_at) {
		this(last_name,first_name,email,created_at);
		this.no = no;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "EmailVO [no=" + no + ", last_name=" + last_name + ", first_name=" + first_name + ", email=" + email
				+ ", created_at=" + created_at + "]";
	}
	
	
	
	
}
