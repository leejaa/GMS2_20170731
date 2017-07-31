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