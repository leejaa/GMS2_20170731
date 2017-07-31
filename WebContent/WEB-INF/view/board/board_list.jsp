<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp" %>
<body>
<div class="container">
<h1 align="center">게시판목록</h1>
<a href="../index.jsp" class="float-right">메인으로 가기</a>
  <table class="table">
    <thead>
      <tr>
        <th>글번호</th>
        <th>아이디</th>
        <th>제목</th>
        <th>내용</th>
        <th>날짜</th>
      </tr>
    </thead>	
    <tbody>
      <tr>
        <td>Default</td>
        <td>Defaultson</td>
        <td>def@somemail.com</td>
        <td>def@somemail.com</td>
        <td>def@somemail.com</td>
      </tr>      
      <tr class="success">
       <td>Default</td>
        <td>Defaultson</td>
        <td>def@somemail.com</td>
        <td>def@somemail.com</td>
        <td>def@somemail.com</td>
      </tr>
      <tr class="danger">
        <td>Default</td>
        <td>Defaultson</td>
        <td>def@somemail.com</td>
        <td>def@somemail.com</td>
        <td>def@somemail.com</td>
      </tr>
      <tr class="info">
       <td>Default</td>
        <td>Defaultson</td>
        <td>def@somemail.com</td>
        <td>def@somemail.com</td>
        <td>def@somemail.com</td>
      </tr>
    </tbody>
  </table>
</div>

</body>
<%@ include file="/WEB-INF/view/common/footer.jsp" %>
</html>

