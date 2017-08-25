package com.gms.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gms.web.constant.Database;
import com.gms.web.constant.SQL;
import com.gms.web.constant.Vendor;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;
import com.gms.web.domain.StudentSubjectBean;
import com.gms.web.factory.DatabaseFactory;
public class MemberDaoImpl implements MemberDao{
	List<StudentBean> members;
	MemberBean member;
	StudentBean student;
	static Connection conn;
	public static MemberDaoImpl getInstance() {
		try {
			Class.forName(Database.ORACLE_DRIVER);
			conn=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MemberDaoImpl();
	}
	
	
	@Override
	public String insert(Map<?,?> map) {
		String rs="";
		MemberBean member=(MemberBean) map.get("member");
		List<StudentSubjectBean> subjects=(List<StudentSubjectBean>) map.get("subject");
		PreparedStatement pstmt=null;
		Connection conn=null;
		try {
			conn=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERID, Database.PASSWORD)
					.getConnection();
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(SQL.MEMBER_INSERT);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getSsn());
			pstmt.setString(5, member.getMajor());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getProfile());
			pstmt.setString(9, member.getGender());
			pstmt.executeUpdate();
			for(int i=0;i<subjects.size();i++){
				pstmt=conn.prepareStatement(SQL.MEMBER_SUBJECT_INSERT);
				pstmt.setString(1, subjects.get(i).getMember_id());
				pstmt.setString(2, subjects.get(i).getSubj_id());
				rs= String.valueOf(pstmt.executeUpdate());
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn != null){
				try{
					conn.rollback();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
			
		}
			return rs;	
	}
	@Override
	public List<?> selectAll(Object o) {
		members=new ArrayList<>();
		
		int[] arr=(int[])o;
		
		try{
			 conn=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERID, Database.PASSWORD).getConnection();
			
					PreparedStatement pstmt=conn.prepareStatement(SQL.STUDENT_LIST);
					pstmt.setString(1, String.valueOf(arr[0]));
					pstmt.setString(2, String.valueOf(arr[1]));
			
			ResultSet rs=pstmt.executeQuery();
			StudentBean student=null;
			while(rs.next()){
				student=new StudentBean();
				student.setNum(rs.getString(Database.MEMBER_NUM));
				student.setMember_id(rs.getString(Database.MEMBER_ID));
				student.setName(rs.getString(Database.MEMBER_NAME));
				student.setPassword(rs.getString(Database.MEMBER_PASSWORD));
				student.setSsn(rs.getString(Database.MEMBER_SSN));
				student.setRegdate(rs.getString(Database.MEMBER_REGDATE));
				student.setMajor_id(rs.getString(Database.MEMBER_MAJOR));
				student.setPhone(rs.getString(Database.MEMBER_PHONE));
				student.setEmail(rs.getString(Database.MEMBER_EMAIL));
				student.setProfile(rs.getString(Database.MEMBER_PROFILE));
				student.setGender(rs.getString(Database.MEMBER_GENDER));
				student.setSubject(rs.getString(Database.MEMBER_TITLE));
				members.add(student);
			}
			
		}catch (Exception e) {
		}
		return members;
	}

	@Override
	public String count() {
		String count="0";
		try{
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERID, Database.PASSWORD).getConnection().prepareStatement(SQL.STUDENT_COUNT).executeQuery();
			while(rs.next()){
				count=rs.getString("count");
			}
		}catch (Exception e) {
		}
		return count;
	}

	@Override
	public StudentBean selectById(String id) {
		StudentBean student=new StudentBean();
		try {
			PreparedStatement pstmt=DriverManager.getConnection(Database.ORACLE_URL,Database.USERID,Database.PASSWORD)
					.prepareStatement(SQL.MEMBER_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				student.setNum(rs.getString(Database.MEMBER_NUM));
				student.setMember_id(rs.getString(Database.MEMBER_ID));
				student.setName(rs.getString(Database.MEMBER_NAME));
				student.setPassword(rs.getString(Database.MEMBER_PASSWORD));
				student.setSsn(rs.getString(Database.MEMBER_SSN));
				student.setRegdate(rs.getString(Database.MEMBER_REGDATE));
				student.setMajor_id(rs.getString(Database.MEMBER_MAJOR));
				student.setPhone(rs.getString(Database.MEMBER_PHONE));
				student.setEmail(rs.getString(Database.MEMBER_EMAIL));
				student.setProfile(rs.getString(Database.MEMBER_PROFILE));
				student.setGender(rs.getString(Database.MEMBER_GENDER));
				student.setSubject(rs.getString(Database.MEMBER_TITLE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> list=new ArrayList<>();
		MemberBean member=new MemberBean();
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERID, Database.PASSWORD).getConnection()
					.prepareStatement(SQL.MEMBER_FINDBYNAME);
			pstmt.setString(1, name);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				member.setId(rs.getString(Database.MEMBER_ID));
				member.setName(rs.getString(Database.MEMBER_NAME));
				member.setPw(rs.getString(Database.MEMBER_PASSWORD));
				member.setRegdate(rs.getString(Database.MEMBER_REGDATE));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String update(Map<?,?> map) {
		String rs="";
		MemberBean member=(MemberBean) map.get("member");
		List<StudentSubjectBean> subjects=(List<StudentSubjectBean>) map.get("subject");
		PreparedStatement pstmt=null;
		Connection conn=null;
		try {
			conn=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERID, Database.PASSWORD)
					.getConnection();
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getId());
			pstmt.executeUpdate();
			for(int i=0;i<subjects.size();i++){
				pstmt=conn.prepareStatement(SQL.MEMBER_SUBJECT_UPDATE);
				pstmt.setString(1, subjects.get(i).getMember_id());
				pstmt.setString(2, subjects.get(i).getSubj_id());
				rs= String.valueOf(pstmt.executeUpdate());
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn != null){
				try{
					conn.rollback();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
			
		}
			return rs;	
	}

	@Override
	public String delete(String id) {
		String rs="0";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERID, Database.PASSWORD).getConnection()
					.prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, id);
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}


	@Override
	public MemberBean memberById(String id) {
		MemberBean member=new MemberBean();
		try {
			PreparedStatement pstmt=DriverManager.getConnection(Database.ORACLE_URL,Database.USERID,Database.PASSWORD)
					.prepareStatement(SQL.MEMBER_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				member.setId(rs.getString(Database.MEMBER_ID));
				member.setName(rs.getString(Database.MEMBER_NAME));
				member.setPw(rs.getString(Database.MEMBER_PASSWORD));
				member.setSsn(rs.getString(Database.MEMBER_SSN));
				member.setRegdate(rs.getString(Database.MEMBER_REGDATE));
				member.setPhone(rs.getString(Database.MEMBER_PHONE));
				member.setEmail(rs.getString(Database.MEMBER_EMAIL));
				member.setProfile(rs.getString(Database.MEMBER_PROFILE));
				member.setGender(rs.getString(Database.MEMBER_GENDER));
				member.setSubject(rs.getString(Database.MEMBER_TITLE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

}
