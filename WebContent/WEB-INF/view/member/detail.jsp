<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="${stx}/WEB-INF/view/common/common_head.jsp" />
<div class="container">
  <h2>${requestScope.student.member_id}님의 상세정보</h2>
   <form method="post" id="join_form">
      <div class="form-group">
      <label for="id">ID</label>
      <input type="text" class="form-control" id="member_id" value="${requestScope.student.member_id}" readonly="readonly" name="member_id">
    </div>
     <div class="form-group">
      <label for="name">이름</label>
      <input type="text" class="form-control" id="name" value="${requestScope.student.name}" readonly="readonly" name="name">
    </div>
    <div class="form-group">
      <label for="email">이메일</label>
      <input type="email" class="form-control" id="email" value="${requestScope.student.email}" readonly="readonly" name="email">
    </div>
    <div class="form-group">
      <label for="phone">전화번호</label>
      <input type="text" class="form-control" id="phone" value="${requestScope.student.phone}" readonly="readonly" name="phone">
    </div>
     <div class="form-group">
      <label for="gender">성별</label>
      <input type="text" class="form-control" id="gender" value="${requestScope.student.gender}" readonly="readonly" name="gender">
    </div>
   
	  <div>
	  <label for="subject">수강과목</label>
	  <input type="text" class="form-control" id="subject" value="${requestScope.student.subject}" readonly="readonly" name="subject">
	  </div>
  </form>
   <script>
   window.onload=mainLoad();
   </script>
</div>
</body>


</html>