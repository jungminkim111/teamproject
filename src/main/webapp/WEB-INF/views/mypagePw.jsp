<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Insert title here</title>

    <!-- CSS -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="/css/styles.css" rel="stylesheet" />

    <!-- JAVASCRIPT -->
<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/sweetalert.min.js"></script>
<script src="/js/userlist.js"></script>
<script src="/js/chatbot.js"></script>
</head>
<body>
	<!-- header import -->
	<%@ include file="/WEB-INF/views/include/mypageheader.jsp"%>
	<!-- end of header import -->
	<hr>
	<br>
	<br>
	<br>
	<c:if test="${userId == null }">

		<script type="text/javascript">
			alert("로그인후 이용해주세요.");
			location.href = "/login";
		</script>
	</c:if>


	<c:if test="${userId != null }">
		<form method="post" class="form-signin" action="/pw_injeung" name="findform">
			<div class="w3-content w3-container w3-margin-top"style="width: 100%; margin-left: 500px;">
				<div class="w3-container w3-card-4">
					<div class="w3-center w3-large w3-margin-top">
						<div class="form-group has-feedback">
							<h3>Password Check</h3>
							<br>
							<label class="control-label" for="userId">아이디</label> 
							<input class="w3-input" type="text" id="userId" name="userId" value="${userId}" readonly="readonly" />
						</div>
						<br>
						<div class="form-label-group">
							<label for="password">password</label>
							<input type="password" id="userPw" name="userPw" class="w3-input" /> 	
						</div>
						<br>
						<div class="form-label-group">
							<input class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round" type="submit" value="check">
						</div>

						<!-- 이름과 전화번호가 일치하지 않을 때-->
						<c:if test="${check == 1}">
							<script>
								opener.document.findform.userPw.value = "";
							</script>
							<script>
								swal("비밀번호가 틀렸습니다.");
							</script>
						</c:if>

						<!-- 일치시 -->
						<c:if test="${check == 0 }">
							<script>
								alert("비밀번호 확인되었습니다.");
								location.href = "/mypage";
							</script>
						</c:if>
					</div>
				</div>
			</div>
		</form>
	</c:if>
</body>
</html>