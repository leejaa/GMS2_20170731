package com.gms.web.dao;

import java.util.List;
import java.util.Map;

import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;

public interface MemberDao {
	public String insert(Map<?,?>map);
	public List<?> selectAll(Object o);
	public String count();
	public StudentBean selectById(String id);
	public MemberBean memberById(String id);
	public List<MemberBean> selectByName(String name);
	public String update(Map<?,?> map);
	public String delete(String id);
}
