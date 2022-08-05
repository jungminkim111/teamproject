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
<script src="/js/hotel_reservation.js"></script>

<!-- 
<link rel="stylesheet" href="/css/hotel.css" /> -->
</head>
<body >
				<div class="manage_hotel_list">
					<div class="page_name">예약내역</div>
<!-- 					<div id="reservation_list">
						<div id="reservation_top"><span class="reservation_id big ml40">예약번호</span><span class="res_hotel_name big ml20">호텔이름</span><span class="res_hotel_start big ml20">시작일</span> <span class="res_hotel_end big ml20">종료일</span><span class="res_hotel_confirm big ml20">현재상태</span><span class="res_payment big ml20"> 결제금액</span><span class="res_regitime big ml20"  >요청시간</span></div>
						<div class="reservation_list"><span class="reservation_id ml40">1</span><span class="res_hotel_name ml20">호텔이름</span><span class="res_hotel_start ml20">2022-04-25</span> <span class="res_hotel_end ml20">2022-04-26</span><span class="res_hotel_confirm ml20">대기중</span><span class="res_payment ml20" >20,000</span><span class="res_regitime ml20">2022-02-02 00:00:00</span></div>
					</div> -->
					<div id="reservation_lists">
					<table id="reservation_list_table">
						<tr id="reservation_top" ><td class="reservation_id">예약번호</td><td class="res_hotel_name">호텔명</td><td class="res_hotel_start">시작일</td><td  class="res_hotel_end">종료일</td><td class="res_hotel_confirm" >현재상태</td><td class="res_payment">결제금액</td><td class="res_regitime">요청시간</td><td class="res_confirm">상태변경</td></tr>

					</table>
					</div>
				</div> 


</body>

</html>