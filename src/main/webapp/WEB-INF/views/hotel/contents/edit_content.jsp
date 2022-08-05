<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.6.0.min.js"></script>
<!-- <script src="/js/hotel_manage_add.js"></script> -->
<link rel="stylesheet" href="/css/hotel.css" />
</head>
<body>
	<section>
			<div class="page_name">My호텔추가</div>
		<div class="manage_hotel_list">
			<div id="manage_hotel_add_form">
				<div class="manage_hotel_add_form textbox">
					<span  class="manage_hotel_add_question">호텔명</span>
						<div>
							 <input type="text" readonly="readonly" class="txt" name="hotel_name" id="hotel_names" value="${hotel_name }">
						 </div>
				</div>
				<div class="manage_hotel_add_form textbox">
					<div>
						<span class="manage_hotel_add_question">호텔 유형</span> 
						<div class="mb20 mt20 f-s16">
						<input type="radio" name="category" value="호텔" onclick='getcategory(event)'> 호텔
						<input type="radio" name="category" value="모텔" onclick='getcategory(event)'> 모텔
						<input type="radio" name="category" value="펜션" onclick='getcategory(event)'> 펜션
						<input type="radio" name="category" value="기타" onclick='getcategory(event)'> 기타
						</div>
					</div>
				</div>
				<div class="manage_hotel_add_form textbox">
					<span class="manage_hotel_add_question">호텔 위치</span> 
					<div class="mb20 mt20 f-s16">
						<input type="text"  id="roadAddrPart"class="txt " name="location_address" readonly="readonly" value="${hotel_address1}">
						<input type="text"  id="addrDetail" class="txt" name="location_address_detail" value="${hotel_address2}">
						<input type="hidden"  id="zipNo" name="zipNo" >
					</div>
				</div>
				<div class="manage_hotel_add_form mt8 mb4 hp_hp">
					<span class="manage_hotel_add_question">호텔 전화번호</span> 
					<div class="mb20 mt20 f-s16">
						<input type="text"  id="hotel_phone1"class="phone" name="hotel_phone1"  value="${hotel_phone1 }" maxlength="3" size=3 onblur="isCheckNum(this)" onkeydown="ischar(this)" onkeypress="return isnumpress(event,'numbers')" > - <input type="text"  id="hotel_phone2"class="phone " name="hotel_phone2"  value="${hotel_phone2 }" maxlength="4" size=4 onblur="isCheckNum(this)" onkeydown="ischar(this)" onkeypress="return isnumpress(event,'numbers')"> - <input type="text"  id="hotel_phone3"class="phone" name="hotel_phone3"   value="${hotel_phone3 }" maxlength="4" size=4 onblur="isCheckNum(this)" onkeydown="ischar(this)" onkeypress="return isnumpress(event,'numbers')" >
					</div>
				</div>
				<div class="manage_hotel_add_form textbox">
					<div>
						<span  class="manage_hotel_add_question">동물가능여부</span> 	
						<div class="mb20 mt20 f-s16">				
						<input type="radio" class="radiob" name="with_animal" value="1" onclick='getanimal(event)'> 가능
						<input type="radio" class="radiob" name="with_animal" value="0" onclick='getanimal(event)'> 불가능
						</div>
					</div>
				</div>
				<div class="manage_hotel_add_form textbox">
					<span class="manage_hotel_add_question">편의시설</span> 
					<div class="convenience mb40">
						<div class="manage_kitchen ml20">
							<div class="manage_hotel_add_question_s">주방 및 식당</div> 
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="주방">주방</div>
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="전자레인지">전자레인지</div>
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="커피메이커">커피메이커</div>
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="냉장고">냉장고</div>
						</div>
						<div class="manage_bath ml20">
							<div class="manage_hotel_add_question_s">욕실</div> 
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="헤어드라이어">헤어드라이어</div>
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="온수">온수</div>
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="샴푸">샴푸</div>
						</div>
						<div class="manage_bed ml20">
							<div class="manage_hotel_add_question_s">침실 및 세탁 시설</div> 
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="건조기">건조기</div>
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="다리미">다리미</div>
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="옷걸이">옷걸이</div>
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="필수품목">수건,침대시트,비누,화장지</div>
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience"  name="convenience" value="세탁기">세탁기</div>
						</div>
						<div class="manage_temperature ml20">
							<div class="manage_hotel_add_question_s">냉난방</div> 
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="난방">난방</div>
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="에어컨">에어컨</div>
						</div>
						<div class="manage_internet ml20">
							<div class="manage_hotel_add_question_s">인터넷 및 업무공간</div> 
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="무선인터넷">무선인터넷</div>
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="업무전용공간">업무 전용 공간</div>
						</div>

						<div class="manage_parking ml20">
							<div class="manage_hotel_add_question_s">주차장</div> 
							<div class="manage_hotel_add_answer_s"><input type="checkbox"  class="checkbox h_convenience" name="convenience" value="주차장">주차장</div>
						</div>
					</div>
				</div>
				<div class="manage_hotel_add_form textbox">
					<span class="manage_hotel_add_question">객실 정보</span><button id="add_abs_infor" class="ml20 mr20" >+</button><button id="delete_abs_infor" class=" mr20" >-</button><span class="yet">객실 정보를 입력해주세요.(최대 3개)</span>
					<div class="abs_infor" id="abs_infor">

					</div>
				</div>
				<div class="manage_hotel_add_form textbox">
					<span class="manage_hotel_add_question">이용규칙</span>
				<span class="yet">체크인,체크아웃 시간 등을 입력해주세요.</span>
					<div>
						<textarea  class="textareas" id ="hotel_rull" name="hotel_rull" maxlength="1000" spellcheck="false">${hotel_rule }</textarea>
					</div>
				</div>
				<div class="manage_hotel_add_form textbox">
					<span class="manage_hotel_add_question">상세설명</span><span class="yet">상세 설명을 입력해주세요</span>
					<div>
					<textarea  class="textareas" id ="detail_infor" name="detail_infor" maxlength="1000" spellcheck="false">${hotel_detail_account}</textarea>
					</div>
				</div>
				<div class="manage_hotel_add_form textbox">
					<span class="manage_hotel_add_question">사진</span> <label className="input-file-button" class="input-file-button" for="btnAtt"> 업로드</label>
					  <div id='image_preview'>
					    <input type='file' id='btnAtt' multiple='multiple' method="post" accept="image/*" style={{display:none} enctype="multipart/form-data"} />
					    <div id='att_zone' data-placeholder='파일을 첨부 하려면 파일 선택 버튼을 클릭하세요'></div>
					  </div>

					<div id="picture_views"></div>
				</div>
							
			</div>
			<button id="manage_add_hotel" >호텔수정 </button>
		</div>
	
		<div id="sessionid" hidden>${id }</div>
		<div id="hotelid" hidden >${hotelid }</div>
		</section>

<script src="/js/hotel_manage_add_picture.js"></script>
<script src="/js/hotel_manage_edit.js"></script>

</body>

</html>