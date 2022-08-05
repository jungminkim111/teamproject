<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="css/geolocation.css" rel="stylesheet">
<script src="jquery-3.6.0.min.js"></script>
<script src="js/chatbot.js"></script>
<script src="js/market.js"></script>


<script type="text/javascript">
$(document).ready(
				function(){
					alert('a');
		 navigator.geolocation.getCurrentPosition((position) => {
				let latitude =position.coords.latitude;
				let longitude =position.coords.longitude;
				
				console.log('latitude',latitude);
				console.log('longitude',longitude);
			});

			var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
			var options = { //지도를 생성할 때 필요한 기본 옵션
				center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
				level: 3 //지도의 레벨(확대, 축소 정도)
			};

			var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		
			$('#select2').change(
					function(){
							location.href='market?market='+$('#select2').val()
								}
							)
		
		});//ready
		
		
</script>
<style type="text/css">

</style>

</head>
<body  style="background-image: URL(images/market.png); 
background-repeat: no-repeat;
background-size: 100% 250px; ">
	<!-- header import -->
	<%@ include file="/WEB-INF/views/include/hotelheader.jsp"%>
	<!-- end of header import -->
	<hr />
	<div id="container">
	
	<div id='container1'>
	<div id="martselect">
	<h1>마트 선택하기</h1>
	<div id='martlist'>
	<select id='select2'>
		<option>마트선택</option>
			<c:forEach items="${marketlist1 }" var="dto3">
				
					<option>${dto3.market }</option>
				
			</c:forEach>	
	</select>
	</div>
	</div>
	<div id="map"></div>
	</div>
	</div>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer2.jsp"%>
	<!-- end of footer import -->
</body>
<script 
type="text/javascript" 
src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8b8e20da3fad3900177a9adc57e347f4">
</script>

</html>