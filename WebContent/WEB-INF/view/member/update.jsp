<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp" %>
<body>
<div class="container">
  <h2>회원정보수정</h2>
  <form action="/index.jsp">
    <div class="form-group">
      <label for="id">ID</label>
      <input type="email" class="form-control" id="id" name="id" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" placeholder="비밀번호를 입력하세요" name="pw">
    </div>
     <div class="form-group">
      <label for="name">이름</label>
      <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요" name="name">
    </div>
    <div class="form-group">
      <label for="email">이메일</label>
      <input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요" name="email">
    </div>
    <div class="form-group">
      <label for="ssn">생년월일</label>
      <input type="date" id="birthday" name="birthday" class="form-control" placeholder="생년월일입력">
    </div>
     <div class="form-group">
      <label for="gender">성별</label>
      <label><input type="radio" name="gender" value="male">남성</label>
      <label><input type="radio" name="gender" value="female">여성</label>
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
    <button type="submit" class="btn btn-danger">전송</button>
  </form>
</div>
</body>
<%@ include file="/WEB-INF/view/common/footer.jsp" %>
</html>