<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/common/common_head.jsp" />
<body>
<div class="container">
  <h2>로그인</h2>
  <form id="login_box" name="login_box">
    <div class="form-group">
      <label for="id">ID</label>
      <input type="text" class="form-control" id="member_id" placeholder="아이디를 입력하세요" name="member_id">
    </div>
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요" name="password">
    </div>
    <div class="checkbox">
      <label><input type="checkbox" name="remember">아이디저장</label>
    </div>
    <input type="hidden" name="action" value="login"/>
    <input type="hidden" name="page" value="main"/>
    <button type="submit" class="btn btn-default" onclick="loginAlert()">Submit</button>
  </form>
</div>
	<script>
	window.onload=mainLoad();
	function loginAlert(){
		var member_id=document.getElementById("member_id").value;
		var password=document.getElementById('password').value;
		if(member_id==""){
			alert('ID를 입력해주세요..');
			return false;
		}
		if(password==""){
			alert('비밀번호를 입력해주세요..');
			return false;
		}
		var form=document.getElementById('login_box');
		form.method="post";
		form.action="${ctx}/member.do";
		return true;
	}
	</script>
</body>
</html>
