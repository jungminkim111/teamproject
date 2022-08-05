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
<title>바로고</title>

<!-- CSS -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="/css/styles.css" rel="stylesheet" />
<link href="/css/hotel.css" rel="stylesheet" />

<!-- JAVASCRIPT -->
<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/sweetalert.min.js"></script>
<script src="/js/chatbot.js"></script>

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
			<!-- Page content-->
			<script type="text/javascript">
				$(document).ready(function() {
					$("#submit").on("click", function() {
						if ($("#userPw").val() == "") {
							swal("비밀번호를 입력해주세요.");
							$("#userPw").focus();
							return false;
						}
						$.ajax({
							url : "passChk",
							type : "POST",
							dataType : "json",
							data : $("#delForm").serializeArray(),
							success : function(data) {

								if (data == 0) {
									swal("패스워드가 틀렸습니다.", " ", "error");
									return;
								} else {
									if (confirm("회원탈퇴하시겠습니까?")) {
										$("#delForm").submit();
									}
								}
							}
						})
					});
				})
			</script>

			<c:if test="${userId == null }">
				<script type="text/javascript">
					alert("로그인후 이용해주세요.");
					location.href = "/login";
				</script>
			</c:if>

			<c:if test="${userId != null }">
				<section id="container" >
				<br>
				<br>
					<form action="/delete" method="post" id="delForm">
						<div class="w3-content w3-container w3-margin-top"
							style="width: 100%; margin-left: 500px;">
							<div class="w3-container w3-card-4">
								<div class="w3-center w3-large w3-margin-top">
								<h1>회원 탈퇴</h1>
									<div class="form-group has-feedback">
										<label class="control-label" for="userId">Id</label> <input
											class="w3-input" type="text" id="userId" name="userId"
											value="${userId}" readonly="readonly" />
									</div>
									<div class="form-group has-feedback">
										<label class="control-label" for="userPw">Password</label> <input
											class="w3-input" type="password" id="userPw" name="userPw" />
											<br>
									</div>
								</div>
							</div>
						</div>
					</form>
					<div class="form-group has-feedback" style="width: 96%; margin-left: 515px;">
						<button
							class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round"
							type="button" id="submit">회원탈퇴</button>
					</div>
					<c:if test="${msg == false}">비밀번호가 맞지 않습니다.</c:if>
				</section>
			</c:if>
	</section>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
</body>

</html>