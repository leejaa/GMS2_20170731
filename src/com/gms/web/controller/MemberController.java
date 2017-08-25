package com.gms.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.web.constant.Action;
import com.gms.web.constant.Database;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;
import com.gms.web.domain.StudentSubjectBean;
import com.gms.web.proxy.BlockHandler;
import com.gms.web.proxy.PageHandler;
import com.gms.web.proxy.PageProxy;
import com.gms.web.service.MemberService;
import com.gms.web.service.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.ParamsIterator;
import com.gms.web.util.Separator;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Member Controller 진입");
		HttpSession session=request.getSession();
		MemberBean member=null;
		StudentBean student=null;
		MemberService service=MemberServiceImpl.getInstance();
		Separator.init(request);
		switch (request.getParameter(Action.CMD)) {
		case Action.MOVE:
			DispatcherServlet.send(request, response);
			break;
		case Action.LOGIN:
			student=new StudentBean();
			student.setMember_id(request.getParameter(Database.MEMBER_ID));
			student.setPassword(request.getParameter(Database.MEMBER_PASSWORD));
			
			System.out.println("입력한 아이디비번은 .." +student.getMember_id()+"/"+student.getPassword());
			
			Map<String,Object> param=service.login(student);
			if(param.get("page").equals("main")){
				Separator.cmd.setDir("common");
				session.setAttribute("user", param.get("user"));
				System.out.println(session.getAttribute("user"));
			}
			Separator.cmd.setPage(String.valueOf(param.get("page")));
			Separator.cmd.process();
			DispatcherServlet.send(request, response);
			break;
		case Action.JOIN:
			
			System.out.println("join 진입");
			member=new MemberBean();
			Map<?,?> map=ParamsIterator.execute(request);
			System.out.println(map.toString());
			member.setId((String)map.get("member_id"));
			member.setPw((String)map.get("password"));
			member.setName((String)map.get("name"));
			member.setSsn((String)map.get("ssn"));
			member.setMajor((String)map.get("major"));
			member.setPhone((String)map.get("phone"));
			member.setProfile((String)map.get("profile"));
			member.setGender((String)map.get("gender"));
			member.setEmail((String)map.get("email"));
			// major 은 여러행을 입력해야함
			
			System.out.println("담긴 멤버빈 : "+member.toString());
			
			String[] subjects=((String)map.get("subject")).split(",");
			List<StudentSubjectBean> list= new ArrayList<>();
			StudentSubjectBean subject=null;
			for(int i=0;i<subjects.length;i++){
				subject=new StudentSubjectBean();
				subject.setMember_id((String)map.get("member_id"));
				subject.setSubj_id(subjects[i]);
				list.add(subject);
			}
			
			System.out.println("과목 리스트 : "+list.toString());
			Map<String,Object>tempMap=new HashMap<>();
			tempMap.put("member", member);
			tempMap.put("subject", list);
			
			System.out.println("템프맵 : "+tempMap.toString());
			String result =service.addMember(tempMap);
			
			System.out.println("결과는 : "+result);
			
			if(result.equals("main")){
				Separator.cmd.setPage(result);
				Separator.cmd.setDir("common");
				Separator.cmd.process();
				System.out.println("회원가입 성공..");
			}else if(result.equals("join")){
				Separator.cmd.setPage(result);
				Separator.cmd.setDir("member");
				Separator.cmd.process();
				System.out.println("회원가입 실패..");
			}
			DispatcherServlet.send(request, response);
			break;
			
		case Action.LIST:
			System.out.println("member list진입");
			PageProxy pxy=new PageProxy(request);
			pxy.setPageSize(5);
			pxy.setBlockSize(5);
			pxy.setTheNumberOfRows(Integer.parseInt(service.countMembers()));
			pxy.setPageNumber(Integer.parseInt(request.getParameter("pageNumber")));
			int[] arr=PageHandler.attr(pxy);
			int[] arr2=BlockHandler.attr(pxy);
			pxy.execute(arr2, service.getMembers(arr));
			
			System.out.println("request : "+request);
			DispatcherServlet.send(request, response);
			break;
		case Action.DETAIL:
			System.out.println("member detail 진입");
			student=new StudentBean();
			System.out.println("디테일 아이디 : "+request.getParameter("member_id"));
			student=service.studentById(request.getParameter("member_id"));
			System.out.println("가져온 학생 정보 : "+student);
			request.setAttribute("student", student);
			DispatcherServlet.send(request, response);
			break;
		case Action.UPDATE:
			System.out.println("member update 진입");
			member=new MemberBean();
			Map<?,?> map2=ParamsIterator.execute(request);
			System.out.println(map2.toString());
			member.setId((String)map2.get("member_id"));
			member.setPw((String)map2.get("password"));
			member.setName((String)map2.get("name"));
			member.setMajor((String)map2.get("major"));
			member.setPhone((String)map2.get("phone"));
			member.setProfile((String)map2.get("profile"));
			member.setGender((String)map2.get("gender"));
			member.setEmail((String)map2.get("email"));
			
			// major 은 여러행을 입력해야함
			
			System.out.println("담긴 멤버빈 : "+member.toString());
			
			String[] subjects2=((String)map2.get("subject")).split(",");
			List<StudentSubjectBean> list2= new ArrayList<>();
			StudentSubjectBean subject2=null;
			for(int i=0;i<subjects2.length;i++){
				subject2=new StudentSubjectBean();
				subject2.setMember_id((String)map2.get("member_id"));
				subject2.setSubj_id(subjects2[i]);
				list2.add(subject2);
			}
			
			System.out.println("과목 리스트 : "+list2.toString());
			Map<String,Object>tempMap2=new HashMap<>();
			tempMap2.put("member", member);
			tempMap2.put("subject", list2);
			
			System.out.println("템프맵 : "+tempMap2.toString());
			String result2 =service.modify(tempMap2);
			
			System.out.println("결과는 : "+result2);
			String path=request.getContextPath();
			response.sendRedirect(path+"/member.do?action=list&page="+result2+"&pageNumber=1");
			break;
		case Action.DELETE:
			System.out.println("delete 진입..");
			String result3=service.remove(request.getParameter("member_id"));
			String path2=request.getContextPath();
			response.sendRedirect(path2+"/member.do?action=list&page=list&pageNumber=1");
			break;
		case "dbtest":
			request.setAttribute("count", service.countMembers());
			DispatcherServlet.send(request, response);
			break;
		default:
			break;
		}
	}

	
}
