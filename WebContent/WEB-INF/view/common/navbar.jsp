<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" onclick="moveTo('common','move','main')">HOME</a>
    </div>
    <ul id="ul">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">MEMBER
        <span class="caret"></span></a>
        <ul id="ul1">
          <li><a>회원목록</a></li>
          <li><a>회원정보수정</a></li>
          <li><a>회원탈퇴</a></li>
        </ul>
      </li>
      
   	   <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">GRADE
        <span class="caret"></span></a>
        <ul id="ul2">
          <li><a>성적입력</a></li>
          <li><a>성적목록</a></li>
          <li><a>성적수정</a></li>
        </ul>
      </li>
      
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">BOARD
        <span class="caret"></span></a>
        <ul id="ul3">
          <li><a>게시글쓰기</a></li>
          <li><a>게시글목록</a></li>
          <li><a>게시글수정</a></li>
        </ul>
      </li>
      
    </ul>
    
     <ul class="nav navbar-nav navbar-right">
      <c:choose>
		<c:when test="${empty sessionScope.user}">
      <li><a onclick="moveTo('member','move','join')"><span class="glyphicon glyphicon-user"></span>회원가입</a></li>
      <li><a onclick="moveTo('member','move','login')"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
        </c:when>
        <c:otherwise>
        <li><a onclick="detail()"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;${sessionScope.user.name}님</a></li>
		 <li><a id="logout" onclick="logout()"><span class="glyphicon glyphicon-log-in"></span>로그아웃</a></li>
		</c:otherwise>
	</c:choose>
    </ul>
  </div>
</nav>
<script>
function detail(){
	location.href="${ctx}/member.do?action=detail&page=detail&member_id=${sessionScope.user.id}";
}

function moveTo(dir,action,page){
	location.href="${ctx}/"+dir+".do?action="+action+"&page="+page;
}
function Delete(dir,action){
	var id=prompt("탈퇴할 회원 아이디 입력..","ID");
	location.href="${ctx}/"+dir+".do?action="+action+"&id="+id;
}

function logout(){
	location.href="${ctx}/common.do?action=logout&page=main";
}

function list(dir){
	location.href="${ctx}/"+dir+".do?action=search&page=search&pageNumber=1";
}
function mainLoad(){
	var ul=document.getElementById("ul");
	ul.setAttribute("class","nav navbar-nav");

	var ul_nav1=document.getElementById("ul1");
	var ul_nav2=document.getElementById("ul2");
	var ul_nav3=document.getElementById("ul3");

	ul_nav1.setAttribute("class","dropdown-menu");
	ul_nav2.setAttribute("class","dropdown-menu");
	ul_nav3.setAttribute("class","dropdown-menu");

	var u1=document.getElementById("ul1");
	var u2=document.getElementById("ul2");
	var u3=document.getElementById("ul3");
	
	var u1c=u1.children;
	var u2c=u2.children;
	var u3c=u3.children;
	
		u1c[0].setAttribute("onclick","list('member')");
		u1c[1].setAttribute("onclick","moveTo('member','move','update')");
		u1c[2].setAttribute("onclick","moveTo('member','move','delete')");
		
		u2c[0].setAttribute("onclick","moveTo('grade','move','write')");
		u2c[1].setAttribute("onclick","list('grade')");
		u2c[2].setAttribute("onclick","moveTo('grade','move','update')");
		
		u3c[0].setAttribute("onclick","moveTo('board','move','write')");
		u3c[1].setAttribute("onclick","list('board')");
		u3c[2].setAttribute("onclick","moveTo('board','move','update')");
	
}


</script>

