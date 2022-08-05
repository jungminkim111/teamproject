<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=hb8r593xf9"></script>
<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/chatbot.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	});
</script>
<link rel="stylesheet" href="/css/hotel.css" />
</head>
<body style="background-image: URL(/images/hotel.png); 
background-repeat: no-repeat;
background-size: 100% 250px; 
 background-blend-mode: multiply;">
	<!-- header import -->
	<%@ include file="/WEB-INF/views/include/hotelheader.jsp"%>
	<!-- end of header import -->
	<hr />
	<section>

		<div class="search_bar">
		
			<h1>세션태그부터 입력하시면 됩니다</h1>
			
		</div>
		<div class="hotel_listss">
		<div id= "hotel_namess" >${title }</div>
		<div id="h_d_infors"> 유형: <span class="h_d_infor">${hotel_category }</span> &ensp; 반려동물동반 :<span class="h_d_infor"> ${hotel_animal }</span>  &ensp; 위치 :<span class="h_d_infor"> ${hotel_address }</span> </div>
			<div id="image_and_map">
			<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" >
				  <div class="carousel-indicators"></div>
				  <div class="carousel-inner"></div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button> 
				</div> 
				
				<div id="map" ></div>
			</div>	
				<div class="ml30 f-s30 fw600 mt20">편의시설</div>
				<div id="convenience_and_phone">
					<div class="convenience_divs">
						<div class="convenience_div" id="kitchen">
							<div class="convenience_divs_name" >주방 및 식당</div>
						</div>
						 <div class="convenience_div" id="bathroom">
							<div class="convenience_divs_name" >욕실</div>
						</div>
					    <div class="convenience_div" id="cleaning">
							<div class="convenience_divs_name" >침실 및 세탁 시설</div>
						</div>
						<div class="convenience_div" id="temperature">
							<div class="convenience_divs_name" >냉난방</div>
						</div>
						<div class="convenience_div" id="internet">
							<div class="convenience_divs_name" >인터넷 및 업무공간</div>
						</div>
						<div class="convenience_div" id="parking">
							<div class="convenience_divs_name" >주차장</div>
						</div>
					</div>
				<div id="hotel_telephone">
					<div id="hotel_telephone_box">
						<div id ="hotel_telephoneimg">
							<img src="/images/icons/phone.png">
							<div>대표전화</div>
							<div>${hotel_phone }</div>
						</div>

					</div>
				</div>
			</div>
		<div>
		<div id="hotel_detail_information_and_payment_box">
			<div class= "hotel_detail_information">
				<div class="ml20 f-s30 fw800" >상세설명</div>
				<pre id="hotel_detail_information_textarea"> ${hoteldetail }</pre>
			</div>
			<div id="hotel_payment_box">
				<div id="payment_hotel_room_infors">
					<div class="payment_hotel_room_infor">
						<div class="payment_hotel_room_name"><img src="/images/icons/room_bed.png"><span> 룸 이름</span></div>
						<div class="">룸 정보</div>
						<div class="">??</div>
						<div class="">가격</div>
					</div>




				</div>
				<div id="payment_form">
					<div class=""></div>
				
				</div>
			</div>
		</div>
		<div class="ml30 f-s30 fw800 mt20" >이용 규칙</div>
		<div id="hotel_rule_box">
		<pre id="hotel_detail_information_textarea">${hotel_rule }</pre></div>
		<div id="hb_owner-infors">
			<div id="hb_onwer_profile"><img src="${profile_picture }"></div>
			<div id="hb_onwer_profile_text"><div id ="hb_onwer_profiles"><div id ="hb_onwer_id"><span class="hb_name">사업주</span> ${business_id }</div><pre id="hotel_detail_information_textarea">${profile_text }</pre></div></div>
		</div>
			
		</div>

		
	</section>
	<span id="data_x" hidden>${x }</span>
	<span id="data_y" hidden>${y }</span>
	<span id="data_title" hidden>${title }</span>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="/js/hotel_hotels.js"></script>
</body>

</html>