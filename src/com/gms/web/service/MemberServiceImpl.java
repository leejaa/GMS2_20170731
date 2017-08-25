package com.gms.web.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gms.web.dao.MemberDaoImpl;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;

public class MemberServiceImpl implements MemberService{
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {}
	@Override
	public String addMember(Map<?,?> map) {
		return MemberDaoImpl.getInstance().insert(map)=="0"?"join":"main";
	}
	@Override
	public List<?> getMembers(Object o) {
		return MemberDaoImpl.getInstance().selectAll(o);
	}
	@Override
	public String countMembers() {
		return MemberDaoImpl.getInstance().count();
	}
	@Override
	public StudentBean studentById(String id) {
		return MemberDaoImpl.getInstance().selectById(id);
	}
	@Override
	public List<MemberBean> getMemberByName(String name) {
		return MemberDaoImpl.getInstance().selectByName(name);
	}
	@Override
	public String modify(Map<?,?> map) {
		return MemberDaoImpl.getInstance().update(map)=="0"?"update":"list";
	}
	@Override
	public String remove(String id) {
		return MemberDaoImpl.getInstance().delete(id)=="0"?"회원탈퇴실패":"회원탈퇴성공";
	}
	@Override
	public Map<String,Object> login(StudentBean student) {
		Map<String,Object> map=new HashMap<>();
		String page="";
		System.out.println("입력한 아이디값 : "+student.getMember_id());
		StudentBean s=studentById(student.getMember_id());
		System.out.println(s.toString());
		if(s!=null){
			if(student.getPassword().equals(s.getPassword())){
				page="main";
			}else{
				page="login";
			}
		}else{
			page="join";
		}
		map.put("page", page);
		map.put("user", s);
		return map;
	}
	@Override
	public MemberBean memberById(String id) {
		return MemberDaoImpl.getInstance().memberById(id);
	}
}
