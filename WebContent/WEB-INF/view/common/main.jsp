<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<header>
현재 시간 : <%=new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss").format(new Date()) %>  <br />
<h1><a href="<%=request.getContextPath()%>/index.jsp" class="float-right">메인으로 가기</a></h1>
</header>
<body>
<div id="wrapper" class="gms-width-100pro">

<h1 class="gms-text-center">성적관리시스템(GMS)</h1>
<hr />
<form action="<%=request.getContextPath()%>/member/join.do" method="post">
<input type="submit" />
</form>
<div class="container" style="border-color:black; width: 80%; height: 1300px; margin-left: 130px; margin-top: 80px; margin-right: 50px;">
<table id="index-tab" style="margin-left: 130px;margin-top: 50px; border-color: red; border-style: solid;">
	<tr id="index-tab-tr">
		<td><i class="glyphicon glyphicon-user">학생관리</i></td>
		<td><i class="glyphicon glyphicon-cloud">성적관리</i></td>
		<td><i class="glyphicon glyphicon-thumbs-up">게시판</i></td>
	</tr>
	<tr id="index-tab-tr">
		<td>
			<ul class="index-ul">
				<li><a href="<%=request.getContextPath()%>/common.do?action=move&page=main">회원가입</a></li>
				<li><a href="<%=request.getContextPath()%>/member/list.do">회원목록</a></li>
				<li><a href="<%=request.getContextPath()%>/member/update.do">회원정보수정</a></li>
				<li><a href="<%=request.getContextPath()%>/member/delete.do">회원탈퇴</a></li>
			</ul>
		</td>
		<td>
			<ul class="index-ul">
				<li><a href="/WEB-INF/grade/grade_write.jsp">성적입력</a></li>
				<li><a href="/WEB-INF/grade/grade_list.jsp">성적목록</a></li>
				<li><a href="/WEB-INF/grade/grade_update.jsp">성적수정</a></li>
				<li>성적삭제</li>
			</ul>
		</td>
		<td>
			<ul class="index-ul">
				<li><a href="/WEB-INF/board/board_write.jsp">게시글 쓰기</a></li>
				<li><a href="/WEB-INF/board/board_list.jsp">게시글 목록</a></li>
				<li><a href="/WEB-INF/board/board_update.jsp">게시글 수정</a></li>
				<li>게시글 삭제</li>
			</ul>
		</td>
	</tr>

</table>
</div>
</div>
<footer style="width: 100%;height: 50px;padding: 10px;">
	<div>
  <p>Posted by: Lee Jahun</p>
  <p>Contact information: <a href="jahun135@hanmail.net">
  jahun135@hanmail.net</a>.</p>
  <a href="/WEB-INF/util/jdbc_test.jsp">DB 연결테스트</a>
  </div>
  
<div align="right">
<img src="<%=request.getContextPath()%>/img/sigong.png" style="max-width: 10%; height: auto;"/>
</div>
</footer>
</body>
</html>