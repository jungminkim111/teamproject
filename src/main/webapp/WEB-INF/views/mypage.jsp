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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="/css/styles.css" rel="stylesheet" />
<link href="/css/hotel.css" rel="stylesheet" />
<!-- JAVASCRIPT -->
<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/sweetalert.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="/js/userlist.js"></script>
<script src="/js/chatbot.js"></script>

<script type="text/javascript">
	$(function() {
		$("#btnUpdate").click(function() {
			if (confirm("회원정보를 수정하시겠습니까?")) {
				// 폼 내부의 데이터를 전송할 주소
				document.form1.action = "${path}/update";
				alert("수정되었습니다.");
				document.form1.submit(); // 제출			
			}
		});
	});

</script>


</head>
<body>
	<!-- header import -->
	<%@ include file="/WEB-INF/views/include/mypageheader.jsp"%>
	<!-- end of header import -->
	<hr>
	<section>
	<!-- Sidebar-->
		<div class="d-flex" id="wrapper">
			<div class="border-end bg-white" id="sidebar-wrapper">
				<div class="list-group list-group-flush">
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="/mypage">회원 수정</a> 
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="/deletemember">회원 탈퇴</a> 
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="/reservation">예약 내역</a>
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="/hotel/manage">호텔관리</a>
					<a class=" list-group-item-action list-group-item-light p-1 mypagelists"	href="/hotel/manage/reservation">호텔예약관리</a>
					<a class=" list-group-item-action list-group-item-light p-1 mypagelists"	href="/hotel/manage">호텔등록/수정</a>
					<a class=" list-group-item  list-group-item-action list-group-item-light p-1 mypagelists"	href="/hotel/manage/delete">호텔삭제</a>
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="/marketceo">마켓 관리</a>
						<a class="list-group-item-action list-group-item-light p-1 mypagelists" href="#!">마켓 예약등록</a> 
						<a class="list-group-item-action list-group-item-light p-1 mypagelists" href="#!">마켓 등록/수정</a>
						<a class="list-group-item list-group-item-action list-group-item-light p-1 mypagelists" href="#!">마켓 삭제</a>

				</div>
			</div>
			<c:if test="${userId == null }">
				<script type="text/javascript">
					alert("로그인후 이용해주세요.");
					location.href = "/login";
				</script>
			</c:if>

			<c:if test="${userId != null }">
				<div class="mypage">
					<form name="form1" method="post">
						<div class="w3-content w3-container w3-margin-top" style="max-width: 100%; width: 100%; margin-left:500px;">
							<div class="w3-container w3-card-4">
								<div class="w3-center w3-large w3-margin-top">
									<h2>회원수정</h2>
									<br /> <label for="name">Id</label> <input name="userId"
										value="${userId }" class="w3-input" readonly required /> <br />
									<br />
									<h2>정보변경</h2>
									<br /> <label for="name">Revise Name</label> <input
										name="userName" value="${userName }" class="w3-input" required />
									<br /> 
									   <label for="name">Revise Email</label> 
									   <input id="userEmail" name="userEmail" value="${userEmail }" class="w3-input"required /> 							
										<button class="w3-button w3-tiny w3-round-xlarge w3-black" type="button" id="checkEmail2" onclick="email_Check2()" style="float:right" >EmailCheck</button>
										<span id="email_result"></span>
										<br /> 
										<br /> 
										
										<input type="button"
										value="회원정보 변경"
										class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round"
										id="btnUpdate" /> <br /> <br />
								</div>
							</div>
						</div>
					</form>
				</div>

			</c:if>
</section>
<script type="text/javascript">
	      function email_Check2() {
    	  var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    	  var userEmail = $('#userEmail').val();
    	  
    	  if(!emailReg.test($("#userEmail").val())) {
    		  // 0 : 이메일 길이 / 문자열 검사
    		  swal("이메일 조건이 맞지 않습니다", "메일형식에 맞게 입력해주세요.", "warning");
    	  } else if(userEmail == null) {
    		  $('#email_result').html('이메일을 입력해주세요 :)');
    		  $('#email_result').css('color', 'red');
  			}
    	  
    	  $("#checkEmail2").on("click", function() {
  			$.ajax({
  				url: '<%=request.getContextPath() %>/checkEmail',
  				data: {"userEmail" : $("#userEmail").val()},
  				type: 'post',
  				dataType: 'json',
  				success: function(data) {
  					if(data == 1) {
  						swal("사용중인 이메일 입니다.", "", "error");
  					} else if(data == 0 && emailReg.test($("#userEmail").val())) {
  						swal("사용가능한 이메일 입니다.", "", "success");
  					}
  				}
  			});
  		});
      }
	      </script>
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