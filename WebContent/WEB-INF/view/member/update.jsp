<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="${stx}/WEB-INF/view/common/common_head.jsp" />
<body>
<div class="container">
  <h2>회원정보수정</h2>
  <form id="update_form">
    <div class="form-group">
      <label for="id">ID</label>
      <input type="email" class="form-control" id="member_id" name="member_id" value="${requestScope.student.member_id}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="password" value="${requestScope.student.password}" name="password">
    </div>
     <div class="form-group">
      <label for="name">이름</label>
      <input type="text" class="form-control" id="name" value="${requestScope.student.name}" name="name">
    </div>
    <div class="form-group">
      <label for="email">이메일</label>
      <input type="email" class="form-control" id="email" value="${requestScope.student.email}" name="email">
    </div>
       <div class="form-group">
      <label for="gender">성별</label>
      <label><input type="radio" name="gender" value="male">남성</label>
      <label><input type="radio" name="gender" value="female">여성</label>
    </div>
    <div class="form-group">
      <label for="phone">폰번호</label>
      <label><input type="text" name="phone" id="phone" value="${requestScope.student.phone}"></label>
    </div>
    
    <div class="form-group">
      <select name="major">
		  <option value="computer">컴퓨터공학</option>
		  <option value="science">생명공학</option>
		  <option value="physics">물리학</option>
		  <option value="english">영어</option>
	  </select>
    </div>
    <div class="form-group">
      <label for="subject">수강과목</label>
	      <div class="checkbox">
	  		<label><input type="checkbox" name="subject" value="java" checked="checked">java</label>
			</div>
		<div class="checkbox">
	  		<label><input type="checkbox" name="subject" value="c" checked="checked">c</label>
		</div>
		<div class="checkbox">
	  		<label><input type="checkbox" name="subject" value="phython">phython</label>
		</div>
		<div class="checkbox">
	  		<label><input type="checkbox" name="subject" value="css">css</label>
		</div>
		<div class="checkbox">
	  		<label><input type="checkbox" name="subject" value="javascript">javascript</label>
		</div>
    </div>
    <input type="hidden" id=profile name="profile" value="profile"/>
    <input type="hidden" id=action name="action" value="update"/>
    <input type="hidden" id=page name="page" value="list"/>
    <button type="submit" class="btn btn-danger" onclick="joinAlert()">전송</button>
  </form>
</div>
</body>
<script>
window.onload=mainLoad();

function joinAlert(){
	var member_id=document.getElementById("member_id").value;
	var password=document.getElementById("password").value;
	var name=document.getElementById("name").value;
	var email=document.getElementById("email").value;
	var phone=document.getElementById("phone").value;
	var gender=document.getElementById("gender").value;
	var major=document.getElementById("major").value;
	var subject=document.getElementById("subject").value;
	
	if(member_id===""){
		alert("아이디를 입력해주세요");
		return false;
	}
	if(password===""){
		alert("비밀번호를 입력해주세요");
		return false;
	}
	if(name===""){
		alert("이름을 입력해주세요");
		return false;
	}
	if(email===""){
		alert("이메일을 입력해주세요");
		return false;
	}
	if(phone===""){
		alert("휴대폰번호를 입력해주세요");
		return false;
	}
	
	if(gender===""){
		alert("성별을 입력해주세요");
		return false;
	}
	if(major===""){
		alert("전공을 입력해주세요");
		return false;
	}
	if(subject===""){
		alert("수강과목을 입력해주세요");
		return false;
	}
	
	var form=document.getElementById("update_form");
	form.method="post";
	form.action="${ctx}/member.do";
	
	return true;
}
</script>

</html>