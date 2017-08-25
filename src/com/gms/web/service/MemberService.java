package com.gms.web.service;
import java.util.List;
import java.util.Map;

import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;

public interface MemberService {
	public String addMember(Map<?,?> map);
	public List<?> getMembers(Object o);
	public String countMembers();
	public StudentBean studentById(String id);
	public MemberBean memberById(String id);
	public List<MemberBean> getMemberByName(String name);
	public String modify(Map<?,?> map);
	public String remove(String id);
	public Map<String,Object> login(StudentBean student);
	
}
