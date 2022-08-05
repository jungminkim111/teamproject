<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/chatbot.js"></script>
<link rel="stylesheet" href="/css/hotel.css" />
</head>
<body>
	<hr />
	<section>
			<div class="page_name">My호텔삭제</div>
		<div class="manage_hotel_list">
			<ul class="manage_hotel_ul"></ul>
			<button id="delete_hotel">삭제 </button>
			<ul id="manage_hotel_list_pages"></ul>
		</div>
	
		
	</section>

	<!-- footer import -->
	<script src="/js/hotel_manage_delete.js"></script>
	<!-- end of footer import -->
</body>

</html>