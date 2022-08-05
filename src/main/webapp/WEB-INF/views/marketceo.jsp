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
					<a
						class="list-group-item list-group-item-action list-group-item-light p-3"
						href="/Agreement">회원가입</a> <a
						class="list-group-item list-group-item-action list-group-item-light p-3"
						href="/mypage">회원 수정</a> <a
						class="list-group-item list-group-item-action list-group-item-light p-3"
						href="/deletemember">회원 탈퇴</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="/marketceo">마켓 관리</a>

						<a style="text-align: right; font-size: 15px;"href="#!">마켓 예약등록</a> 
						<a style="text-align: right; font-size: 15px;" href="#!">마켓 등록/수정</a>
						<a style="text-align: right; font-size: 15px;" href="#!">마켓 삭제</a>

				</div>
			</div> content-->
			<div>
				<div class="page_name">마켓사업자등록</div>
				<div class="wrapper22">
					<div class="manage_hotel_list">
						<div id="manage_hotel_add_form">
							<div class="title mb10">
								<span class="ml10 fw800 font-sans-serif">자기소개</span><span
									class="yet ml20 fw200 f-s16">마트이름과 마트주소를 입력해주세요</span>
							</div>
							<div class="introduce_form" style="width: 40%;">
								<div id="upload_profile_img">
									<div class="rowasd">
										<div class="circle">
											<img class="profile-pic"
												src="https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg"
												id="https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg">

										</div>
										<div class="p-image">
											<button class="upload-button">프로필 업로드</button>
											<input class="file-upload" type="file" accept="image/*"
												method="post" enctype="multipart/form-data" />
										</div>
									</div>
								</div>
								<div id="self-introduce">
									<div>
									<label style="font-size : 20px;">Mart Name</label>
									<br>
									<input class="martname" type="text"  />
									</div>
									<br>
									<div>
									<label style="font-size : 20px;">Mart Adress </label>
									<br>
									<input class="martadress" type="text"  />
									</div>	
								</div>
							</div>
							<div id="phone-cert" class="mt20">
								<div class="title">
									<span class="ml10 fw800 font-sans-serif">개인인증</span><span
										class="yet ml20 fw200 f-s16">휴대폰 번호를 입력해주세요 (이거 할때마다
										돈나가니까 제발 누르지 말아주세요)</span>
								</div>
								<div id="phone-cert-form" class="mt20">
									<select id="txtMobile1">
										<option value="">&ensp;선택&ensp;</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="019">019</option>
										<option value="010">010</option>
									</select> <input type="text" id="txtMobile2" maxlength="4" size=4
										onkeypress="isCheckNum();" /> <input type="text"
										id="txtMobile3" maxlength="4" size=4
										onkeypress="isCheckNum();" /> <input type="button"
										value="인증요청" class="cert_freeze" onclick="CheckForm();" />
									<div id="check_cert_number_form"></div>
								</div>
							</div>
							<div id="business_reg_form">
								<div class="title">
									<span class="ml10 fw800 font-sans-serif">사업자등록증</span> <label
										id="brlabel" for="brup">업로드</label> <input type="file"
										id="brup" onchange="addFile(this);" method="post" multiple
										accept="image/*,.pdf" enctype="multipart/form-data" /><span
										class="yet ml20 fw200 f-s16">사업자등록증을 업로드해주세요. (image파일,
										pdf파일만 가능)</span>
								</div>
								<input class="brid" hidden="">
								<div class="insert ml20 mt20">
									<div id="brresult"></div>
								</div>
							</div>
						</div>
						<button id="manage_add_ceo">제출</button>
					</div>
				</div>
			</div>
			<div hidden id="business_id">${id}</div>
	</section>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
</body>

</html>