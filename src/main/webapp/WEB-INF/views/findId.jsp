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
	<form method="post" class="form-signin" action="/find_id" name="findform">
		<div class="w3-content w3-container w3-margin-top">
			<div class="w3-container w3-card-4">
				<div class="w3-center w3-large w3-margin-top">
					<h1>Find Id</h1>
					<br>
					<div class="form-label-group">
						<label for="name">Name</label> <input type="text" id="userName"
							name="userName" class="w3-input">

					</div>
					<br>
					<div class="form-label-group">
						<label for="Email">Email</label> <input type="text" id="userEmail"
							name="userEmail" class="w3-input"  onchange="email_Check()">

					</div>

					<div class="btn1">
						<input
							class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round"
							type="submit" value="check">
					</div>

					<!-- 이름과 이메일 일치하지 않을 때-->
					<c:if test="${check == 1}">
						<script>
							opener.document.findform.userName.value = "";
							opener.document.findform.userEmail.value = "";
						</script>
						<script type="text/javascript">
							swal("다시입력해주세요", "입력하신 정보가 존재하지 않습니다", "warning");
						</script>
					</c:if>

					<!-- 일치시 -->
					<c:if test="${check == 0 }">
						<script type="text/javascript">
							swal("찾으시는 아이디는' ${id} ' 입니다");
						</script>
						<script type="text/javascript">
							$(".btn1").hide();
						</script>
						<div class="form-label-group">
							<input
								class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round"
								type="button" value="Login" onclick="location.href='/login'">
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</form>

	<script type="text/javascript">
	
    function email_Check() {
  	  var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
  	  var userEmail = $('#userEmail').val();
  	  
  	  if(!emailReg.test($("#userEmail").val())) {
  		  // 0 : 이메일 길이 / 문자열 검사
  		  swal("이메일 조건이 맞지 않습니다", "메일형식에 맞게 입력해주세요.", "warning");
  		  $("#email_result").html("ex) barogo@barogo.com");
  		  $('#email_result').css('color', 'red');
  	  } else if(userEmail == null) {
  		  $('#email_result').html('이메일을 입력해주세요 :)');
  		  $('#email_result').css('color', 'red');
			}
    }
	
	</script>
</body>
</html>