<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>바로고</title>

<!-- CSS -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<!-- JAVASCRIPT -->
<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/sweetalert.min.js"></script>

</head>
<body>
	<!-- header import -->
	<%@ include file="/WEB-INF/views/include/findheader.jsp"%>
	<!-- end of header import -->
	<hr>
	<br>
	<br>

	<br>
	<br>
	<form method="post" class="form-signin" action="/find_password"
		name="findform">
		<div class="pass">
			<div class="w3-content w3-container w3-margin-top">
				<div class="w3-container w3-card-4">
					<div class="w3-center w3-large w3-margin-top">
						<h1>Find Password</h1>
						<div class="form-label-group">
							<label for="id">ID</label> <input type="text" id="userId"
								name="userId" class="w3-input" />
						</div>
						<br>
						<div class="form-label-group">
							<label for="name">name</label> <input type="text" id="userName"
								name="userName" class="w3-input" />
						</div>
						<br>
						<div class="form-label-group">
							<label for="phone">Email</label> <input type="text"
								id="userEmail" name="userEmail" class="w3-input" />
						</div>
						<br>
						<div class="form-label-group">
							<input
								class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round"
								type="submit" value="check">
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- 정보가 일치하지 않을 때-->
		<c:if test="${check == 1}">
			<script>
				opener.document.findform.userId.value = "";
				opener.document.findform.userName.value = "";
				opener.document.findform.userEmail.value = "";
			</script>
			<script>
			swal("다시입력해주세요", "입력하신 정보가 존재하지 않습니다", "warning");
			</script>
		</c:if>

		<!-- 이름과 비밀번호가 일치하지 않을 때 -->


		<c:if test="${check == 0 }">
			<script type="text/javascript">
				$(".pass").hide();
			</script>
			<div class="w3-content w3-container w3-margin-top">
				<div class="w3-container w3-card-4">
					<div class="w3-center w3-large w3-margin-top">
						<h1>Revise Password</h1>
						<br>
						<div class="form-label-group">
							<input type="hidden" id="id" name="updateid" value="${updateid }">
							<label for="password">Password</label>
							<input type="password" id="userPw" name="userPw" onchange="check_pw()" class="w3-input" />
							
						</div>
						<br>
						<div class="form-label-group">
							<label for="confirmpassword">Confirm Password</label>
							<input type="password" id="userPw2" onchange="check_pw()" name="userPw2"class="w3-input" /> 					
						</div>
						<br>
						<div class="form-label-group">
							<input
								class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round"
								type="button" value="update password" onclick="updatePassword()">
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</form>
	<script type="text/javascript">
		function updatePassword() {
			if (document.findform.userPw.value == "") {
				swal("비밀번호를 입력해주세요.");
				document.findform.userPw.focus();
			} else if (document.findform.userPw.value != document.findform.userPw2.value) {
				swal("비밀번호가 일치하지 않습니다.");
				document.findform.userPw2.focus();
			} else {
				document.findform.action = "/update_password";
				document.findform.submit();
			}
		}
		
		function check_pw(){
	    	  
	          var pw = document.getElementById('userPw').value;
	          var SC = ["!","@","#","$","%"];
	          var check_SC = 0;

	          if(pw.length < 6 || pw.length>16){
	        	  swal('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
	              document.getElementById('userPw').value='';
	          }
	          for(var i=0;i<SC.length;i++){
	              if(pw.indexOf(SC[i]) != -1){
	                  check_SC = 1;
	              }
	          }
	          if(check_SC == 0){
	        	  swal('!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.')
	              document.getElementById('userPw').value='';
	          }
	      }
	</script>
</body>
</html>