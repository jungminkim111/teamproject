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

    <!-- JAVASCRIPT -->
<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/sweetalert.min.js"></script>
<script src="/js/chatbot.js"></script>
	<script type="text/javascript">
	$(function() {
		$("#btnLogin").click(function() {
			var userId=$("#userId").val();
			var userPw=$("#userPw").val();
			
			if(userId == "") {
				swal("아이디를 입력해주세요.", "", "error");
				$("#userId").focus();
				return;
			}
			if(userPw == "") {
				swal("암호를 입력해주세요.", "", "error");
				$("#userPw").focus();
				return;
			}
			// 폼 내부의 데이터를 전송할 주소
			document.form1.action="${path}/user";
			document.form1.submit();	// 제출
		});
	});
	
	$(function(){
		$("#findid").click(function(){
			location.href='/find_id_form';
		})
	})
	
		$(function(){
		$("#findpw").click(function(){
			location.href='/find_password_form';
		})
	})

	</script>

</head>
<body>
	<!-- header import -->
		<%@ include file="/WEB-INF/views/include/mypageheader.jsp"%>
	<!-- end of header import -->
	<hr>
	<section>

<section>


<div class="w3-content w3-container w3-margin-top" style="width: 100%; margin-left:500px;">
  <div class="w3-container w3-card-4">
    <div class="w3-center w3-large w3-margin-top">
      <h3>Log In</h3>
    </div>
    <div>
      <form  method="post" name="form1">
        <p>
          <label>ID</label>
          <span class="w3-right w3-button w3-hover-white" title="아이디 찾기" id="findid">
            <i class="fa fa-exclamation-triangle w3-hover-text-red w3-large"></i>
          </span>
          <input class="w3-input" type="text" class="id" id="userId" name="userId" placeholder="아이디 입력" required>
        </p>
        <p>
          <label>Password</label>
          <span class="w3-right w3-button w3-hover-white" title="비밀번호 찾기" id="findpw">
            <i class="fa fa-exclamation-triangle w3-hover-text-red w3-large"></i>
          </span>
          <input class="w3-input" type="password" class="pw" id="userPw" name="userPw" placeholder="비밀번호 입력" required>
        </p>
        <p class="w3-center">
          <button type="button" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round" id="btnLogin">Log in</button>


          <button type="button" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round" onClick="location.href='/'">Cancel</button>
        </p>
			<c:if test="${msg == 'error' }">
				<script>
          		$(function() {
          			swal("아이디 또는 암호가 일치하지 않습니다.", "", "error");
          		})
          	</script>
			</c:if>
			<c:if test="${msg == 'logout' }">
				<script>
          		$(function() {
          			swal("로그아웃 되었습니다.", "", "error");
          		})
          	</script>
			</c:if>
      </form>
    </div>
  </div>
</div>


	</section>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
</body>

</html>