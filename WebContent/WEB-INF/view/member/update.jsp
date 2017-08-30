<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/common/common_head.jsp" />
<div class="container" style="width:60%">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Update User Profile</h1>
	               		<hr />
	               	</div>
	            </div> 
				<div class="main-login main-center">
					<form class="form-horizontal" id="update_form">
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name" value="${requestScope.student.name}"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="email" value="${requestScope.student.email}"/>
								</div>
							</div>
						</div>

						
						<div class="form-group">
							<label for="phone" class="cols-sm-2 control-label">phone number</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="phone" id="phone" value="${requestScope.student.phone}"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password" data-toggle="popover" value="${requestScope.student.password}"/>
								</div>
								<span id="passwordInfo" class="hide">
								    <ul>
								        <li>At least 6 characters.</li>
								        <li>Use of special Characters like, [@, $].</li>
								        <li>Use of uppercase [A – Z] and lowercase [a – z] letters.</li>
								        <li>Use of numbers [0 – 9].</li>
								    </ul>
								</span>
								<span id="result"></span>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password"/>
								</div>
								<span id="confirmPass"></span>
							</div>
						</div>

						<div class="form-group ">
							<button type="button" class="btn btn-primary btn-lg btn-block login-button">UPDATE</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<script>
		window.onload=mainLoad();
		
		
		function studentInfo(){
			  
			  
			  var keyword='id';
			  var value='${requestScope.student.member_id}';
			  sessionStorage.setItem('id','${requestScope.student.member_id}');
			  sessionStorage.setItem('name','${requestScope.student.name}');
			  sessionStorage.setItem('email','${requestScope.student.email}');
			  
			  show();
		}

		function show(){
			  var show=document.getElementById("show");
			  var value=sessionStorage.getItem('name');
			  
			alert(value+'이거다');
			  
		}
		function updateAlert(){
			var name=document.getElementById("name").value;
			var phone=document.getElementById("phone").value;
			var email=document.getElementById("email").value;
			
			var password=document.getElementById("password").value;
			var confirm=document.getElementById("confirm").value;
			
			if(password != confirm){
				alert('비밀번호가 서로 일치하지 않습니다');
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
			if(password===""){
				alert("비밀번호를 입력해주세요");
				return false;
			}
			if(confirm===""){
				alert("비밀번호를 입력해주세요");
				return false;
			}
			
			var form=document.getElementById("join_form");
			form.method="post";
			form.action="${ctx}/member.do";
			
			return true;
		}
		</script>
		