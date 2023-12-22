package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
//	USER_NO	NUMBER
	private int userNo;
//	USER_ID	VARCHAR2(30 BYTE)
	private String userId;
//	USER_PWD	VARCHAR2(100 BYTE)
	private String userPwd;
//	USER_NAME	VARCHAR2(15 BYTE)
	private String userName;
//	PHONE	VARCHAR2(13 BYTE)
	private String phone;
//	EMAIL	VARCHAR2(100 BYTE)
	private String email;
//	ADDRESS	VARCHAR2(100 BYTE)
	private String address;
//	INTEREST	VARCHAR2(100 BYTE)
	private String interest;
//	enrollDate_DATE	DATE
	private Date enrollDate;
//	MODIFY_DATE	DATE
	private Date modifyDate;
//	STATUS	VARCHAR2(1 BYTE)
	private char status;
	
	public Member() {
		super();
	}

	public Member(int userNo, String userId, String userPwd, String userName, String phone, String email,
			String address, String interest, Date enrollDate, Date modifyDate, char status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.interest = interest;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	
	/**
	 * 회원가입용 생성자
	 * @param userId
	 * @param userPwd
	 * @param userName
	 * @param phone
	 * @param email
	 * @param address
	 * @param interest
	 */
	public Member(String userId, String userPwd, String userName, String phone, String email, String address,
			String interest) {
		this(userId, userName, phone, email, address, interest);
		this.userPwd = userPwd;
	}
	

	/**
	 * 회원정보 업데이트용 생성자
	 * @param userId
	 * @param userName
	 * @param phone
	 * @param email
	 * @param address
	 * @param interest
	 */
	public Member(String userId, String userName, String phone, String email, String address, String interest) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + ", interest=" + interest
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}

	public int getUserNo() {
		return userNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getInterest() {
		return interest;
	}

	public Date getenrollDate() {
		return enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public char getStatus() {
		return status;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public void setenrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setStatus(char status) {
		this.status = status;
	}
}