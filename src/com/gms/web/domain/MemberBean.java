package com.gms.web.domain;

import java.io.Serializable;

public class MemberBean implements Serializable{
	private static final long serialVersionUID=1L;
	private String id,pw,ssn,name,regdate,major,subject,email,phone,profile;
	public String getPhone() {
		return phone;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setPw(String pw){
		this.pw=pw;
	}
	public String getPw(){
		return pw;
	}
	public void setSsn(String ssn){
		this.ssn=ssn;
	}
	public String getSsn(){
		return ssn;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return String.format("ID : %s, PW : %s, NAME : %s SSN : %s , REGDATE : %s \n ", id,pw,name,ssn,regdate);
	}
}
