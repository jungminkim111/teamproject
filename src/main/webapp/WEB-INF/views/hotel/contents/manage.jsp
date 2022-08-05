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
<title>BAROGO</title>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="/css/styles.css" rel="stylesheet" />
<!-- <link href="/css/hotel.css" rel="stylesheet" /> -->

<script src="/jquery-3.6.0.min.js"></script>
<!-- <script src="/js/hotel_managelist.js"></script> -->
<script src="/js/sweetalert.min.js"></script>
<script src="/js/chatbot.js"></script>
<!-- 
<link rel="stylesheet" href="/css/hotel.css" /> -->
</head>
<body >
	<!-- header import -->
		<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<%-- <%@ include file="/WEB-INF/views/include/hotelheader.jsp"%> --%>
	<!-- end of header import -->
	<hr >
	<section>
		<div class="d-flex" id="wrapper">
			<!-- Sidebar-->
			<div class="border-end bg-white" id="sidebar-wrapper">
				<div class="list-group list-group-flush">
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="mypage">회원가입</a> 
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="#!">수정/탈퇴</a> 
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="#!">장바구니</a> 
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="reservation">예약 내역</a>
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="/hotel/manage">호텔관리</a>
					<a class=" list-group-item-action list-group-item-light p-1 mypagelists"	href="/hotel/manage/reservation">호텔예약관리</a>
					<a class=" list-group-item-action list-group-item-light p-1 mypagelists"	href="/hotel/manage">호텔등록/수정</a>
					<a class=" list-group-item-action list-group-item-light p-1 mypagelists"	href="/hotel/manage/delete">호텔삭제</a>
				</div>
			</div>
<!--  			<div class="manage_hotel_list">
					<div class="page_name">호텔등록/수정</div>
					<ul class="manage_hotel_ul"></ul>
					<button id="add_hotel" href="/hotel/manage/post">호텔추가 </button>
					<ul id="manage_hotel_list_pages"></ul>
				</div>  -->
				<%@ include file="/WEB-INF/views/hotel/contents/manage_contents.jsp"%>
		</div>
	
		
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
</body>

</html>