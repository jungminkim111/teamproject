<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BAROGO</title>

<link href="/css/hotel.css" rel="stylesheet" />

<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/hotel_managelist.js"></script>

<!-- 
<link rel="stylesheet" href="/css/hotel.css" /> -->
</head>
<body >

				<div class="manage_hotel_list">
					<div class="page_name">호텔등록/수정</div>
					<ul class="manage_hotel_ul"></ul>
					<button id="add_hotel" href="/hotel/manage/post">호텔추가 </button>
					<ul id="manage_hotel_list_pages"></ul>
				</div> 


</body>

</html>