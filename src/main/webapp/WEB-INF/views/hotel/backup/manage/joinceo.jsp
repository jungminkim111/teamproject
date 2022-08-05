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
			<h1>이곳에 검색창을 만들예정?</h1>
		</div>
		
			<div class="page_name">호텔사업자등록</div>
				<div class="wrapper22">
					<div class="side_bar">
					
					</div>
					<div class="manage_hotel_list">
						<div id="manage_hotel_add_form">
							<div class="title mb10"><span class="ml10 fw800 font-sans-serif">자기소개</span><span class="yet ml20 fw200 f-s16">프로필 사진과 자기소개글을 작성해주세요</span></div>
							<div class="introduce_form">
								<div id="upload_profile_img">
									<div class="row">
									     <div class="circle">
									       <img class="profile-pic" src="https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg" id="https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg">
									
									     </div>
									     <div class="p-image">
									       <button class="upload-button">프로필 업로드</button>
									        <input class="file-upload" type="file" accept="image/*" method="post" enctype="multipart/form-data"/>
										  </div>
									</div>
								</div>
								<div id="self-introduce"> <textarea id="self-introduce_text"></textarea></div>
							</div>
							<div id="phone-cert" class="mt20">
								<div class="title"><span class="ml10 fw800 font-sans-serif">개인인증</span><span class="yet ml20 fw200 f-s16">휴대폰 번호를 입력해주세요 (이거 할때마다 돈나가니까 제발 누르지 말아주세요)</span></div>
								<div id="phone-cert-form" class="mt20"> <select id="txtMobile1" >
								    <option value=""> &ensp;선택&ensp;</option>
								    <option value="011">011</option>
								    <option value="016">016</option>
								    <option value="017">017</option>
								    <option value="019">019</option>
								    <option value="010">010</option>
								</select>
								<input type="text" id="txtMobile2" maxlength="4" size=4 onkeypress="isCheckNum();" />
								<input type="text" id="txtMobile3" maxlength="4" size=4 onkeypress="isCheckNum();"/>
								
								<input type="button" value="인증요청" class="cert_freeze" onclick="CheckForm();" />
                               <div id="check_cert_number_form"></div>
                               </div>
							</div>
							<div id="business_reg_form">
								<div class="title"><span class="ml10 fw800 font-sans-serif">사업자등록증</span>								<label id ="brlabel" for="brup">업로드</label>
								      <input type="file" id="brup"onchange="addFile(this);" method="post" multiple accept="image/*,.pdf" enctype="multipart/form-data"/><span class="yet ml20 fw200 f-s16">사업자등록증을 업로드해주세요. (image파일, pdf파일만 가능)</span></div>
										<input class="brid" hidden="">
								<div class="insert ml20 mt20">
								<div id ="brresult"></div>
								</div>
							</div>
						</div>
						<button id="manage_add_ceo" >제출 </button>
					</div>
				</div>
				<div hidden id="business_id">${id}</div>
	</section>
	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
	<script src="/js/hotel_manage_joinceo.js"></script>
</body>

</html>