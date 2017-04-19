package com.bs.flower.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String realName;
	private String password;
	private String pwdQuestion;
	private String pwdQuestionAnswer;
	private String address;
	private String phoneNo;
	private String email;
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	/** full constructor */
	public Users(String userName, String realName, String password, String pwdQuestion, String pwdQuestionAnswer,
			String address, String phoneNo, String email, Set orderses) {
		this.userName = userName;
		this.realName = realName;
		this.password = password;
		this.pwdQuestion = pwdQuestion;
		this.pwdQuestionAnswer = pwdQuestionAnswer;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.orderses = orderses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPwdQuestion() {
		return this.pwdQuestion;
	}

	public void setPwdQuestion(String pwdQuestion) {
		this.pwdQuestion = pwdQuestion;
	}

	public String getPwdQuestionAnswer() {
		return this.pwdQuestionAnswer;
	}

	public void setPwdQuestionAnswer(String pwdQuestionAnswer) {
		this.pwdQuestionAnswer = pwdQuestionAnswer;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}