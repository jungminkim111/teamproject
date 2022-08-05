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
		<div class="manage_hotel_list">
			<div id="manage_join_agrees">
				<div class="infor_dongui">
<h3 class="titl3">제1장 총칙</h3>



<h4 class="titl4">제1조 (목적)</h4> 
<p>이 약관은 멀티캠퍼스 풀스택과정 6회차 2조의 팀프로젝트 홈페이지 ‘BARO GO’ (이하 "바로고”라 합니다) 가 제공하는 모든 서비스(이하 "서비스"라 합니다)를 이용함에 있어 이용자와 "바로고"간의 권리·의무 및 책임사항과 기타 필요한 사항을 정하는 데 목적이 있습니다.</p>

<h4 class="titl4">제2조 (약관의 효력 및 변경)</h4>
<p>"바로고"는 귀하가 본 약관 내용에 동의하는 경우, "바로고"의 서비스 제공 행위 및 귀하의 서비스 사용 행위에 본 약관이 우선적으로 적용됩니다. "바로고"는 본 약관을 사전 고지 없이 변경할 수 있고, 변경된 약관은 이용자가 직접 확인할 수 있도록 서비스 화면에 공지하며, 공지와 동시에 그 효력이 발생됩니다. 이용자가 변경된 약관에 동의하지 않는 경우, 이용자는 본인의 회원등록을 취소(회원탈퇴)할 수 있으며 계속 사용의 경우는 약관 변경에 대한 동의로 간주됩니다.</p>

<h4 class="titl4">제3조 (약관 외 준칙)</h4>
<p>이 약관에 명시되지 않은 사항에 대해서는 전기통신기본법, 전기통신사업법, 정보통신망이용촉진및정보보호등에관한법률, 방송통신심의위원회 심의규정, 정보통신 윤리강령, 프로그램 보호법 등 기타 대한민국의 관련법령과 상관습에 의합니다.</p>


<h4 class="titl4">제4조 (용어의 정의)</h4>

<p class="list">① 이 약관에서 사용하는 용어의 정의는 다음과 같습니다.</p>

<p class="list">1. 이용자 : 이 약관에 따라 "바로고"가 제공하는 서비스를 받는자</p>

<p class="list">2. 가입 : “바로고”가 제공하는 신청서 양식에 해당 정보를 기입하고, 이 약관에 동의하여 서비스 이용계약을 완료시키는 행위</p>

<p class="list">3. 회원 : "바로고"에 개인정보 등 관련 정보를 제공하여 회원등록을 한 자로서, 일반회원과 호텔,마켓 사업자 회원으로 나뉨</p>

<p class="list">4. 비밀번호 : 이용자와 회원ID가 일치하는지를 확인하고 통신상의 자신의 비밀보호를 위하여 이용자 자신이 선정한 문자와 숫자의 조합</p>

<p class="list">5. 이용해지 : "바로고" 또는 회원이 서비스 이용 이후 그 이용계약을 종료시키는 의사표시</p>

<p class="list">② 이 약관에서 사용하는 용어의 정의는 제1항에서 정하는 것을 제외하고는 관계법령 및 서비스별 안내에서 정하는 바에 의합니다.</p>



<h3 class="titl3">제2장 서비스 이용계약</h3>


<h4 class="titl4">제5조 (이용계약의 성립)</h4>
<p class="list">이용계약은 이용자가 약관내용을 동의하고 "바로고"에서 제공하는 소정의 회원 가입신청 양식에서 요구하는 사항을 기록하여 가입을 완료한 후 "바로고"가 회원가입을 승낙하면 성립됩니다.</p>



<h4 class="titl4">제6조 (이용계약의 유보와 거절)</h4>

<p class="list">① "바로고"는 다음 각 호에 해당하는 이용계약에 대하여는 그 제한 사유가 해소될 때까지 일부 서비스 이용을 제한하거나 가입을 제한할 수 있습니다.</p>

<p class="list">1. 신청서의 내용이 허위(차명 등)인 것으로 판명되거나, 그러하다고 의심할만한 합리적인 사유가 발생할 경우</p>

<p class="list">2. 사회의 안녕 질서 또는 미풍양속을 저해할 목적으로 신청한 경우</p>

<p class="list">3. 기타 "바로고"가 정한 이용계약 요건에 미비 되었을 경우</p>

<p class="list">② "바로고"는 다음에 해당하는 경우 그 사유가 해소될 때까지 이용계약 성립을 유보할 수 있습니다.</p>

<p class="list">1. 서비스 관련 제반 용량이 부족한 경우</p>

<p class="list">2. 기술상 장애 사유가 있는 경우</p>



<h4 class="titl4">제7조 (계약사항의 변경)</h4>
<p>회원은 회원정보관리를 통해 언제든지 자신의 정보를 열람하고 수정할 수 있습니다. 회원은 이용신청 시 기재한 사항이 변경되었을 때에는 수정을 하여야 하며, 수정하지 아니하여 발생하는 문제의 책임은 회원에게 있습니다.</p>



<h4 class="titl4">제8조 (회원정보 사용에 대한 동의) </h4>

<p class="list">① 회원의 개인정보는 [공공기관의 개인정보보호에 관한 법률]에 의해 보호됩니다.</p>

<p class="list">② 회원 정보는 다음과 같이 사용, 관리, 보호됩니다.</p>

<p class="list">1. “바로고”는 서비스 제공과 관련해서 수집된 회원의 신상정보를 본인의 승낙 없이 제3자에게 누설, 배포하지 않습니다. 단, 전기통신기본법 등 법률의 규정에 의해 국가기관의 요구가 있는 경우, 범죄에 대한 수사상의 목적이 있거나 정보통신윤리위원회의 요청이 있는 경우 또는 기타 관계법령에서 정한 절차에 따른 요청이 있는 경우, 귀하가 “바로고”에 제공한 개인정보를 스스로 공개한 경우에는 그러하지 않습니다.</p>

<p class="list">2. 개인정보의 관리 : 귀하는 개인정보의 보호 및 관리를 위하여 서비스의 개인정보관리에서 수시로 귀하의 개인정보를 수정/삭제할 수 있습니다.</p>

<p class="list">3. 개인정보의 보호 : 귀하의 개인정보는 오직 귀하만이 열람/수정/삭제 할 수 있으며, 이는 전적으로 귀하의 ID와 비밀번호에 의해 관리되고 있습니다. 따라서 타인에게 본인의 ID와 비밀번호를 알려주어서는 안되며, 작업 종료시에는 반드시 로그아웃 하고 웹브라우저의 창을 닫아주시기 바랍니다.</p>

<p class="list">4. 회원이 이 약관에 따라 이용신청을 하는 것은, 신청서에 기재된 회원정보를 "바로고"가 수집, 이용하는 것에 동의하는 것으로 간주됩니다.</p>

<strong class="list">부 칙</strong>

<p class="list">① 이 약관은 2022년 4월 14일부터 적용합니다.</p>

</div>
					<div class="manage_join_agree ml20">
					  <input type="checkbox" name="agree_all" id="agree_all" >
					<label for="agree_all"></label>
					  <span>모두 동의합니다</span>
				</div>
				<div class="manage_join_agree ml20">
					  <input type="checkbox" id = "agree1" name="agree" value="1" >
					<label for="agree1"></label>
					  <span>이용약관 동의<strong>(필수)</strong></span>
				</div>
				<div class="manage_join_agree ml20">
					  <input type="checkbox" id = "agree2" name="agree" value="2"  >
					<label for="agree2"></label>
					  <span>개인정보 수집, 이용 동의<strong>(필수)</strong></span>
				</div>
				<div class="manage_join_agree ml20">
					  <input type="checkbox" id = "agree3" name="agree" value="3"  >
					<label for="agree3"></label>
					  <span>개인정보 이용 동의<strong>(필수)</strong></span>
				</div>
			</div>
			<button id="manage_add_hotel" >제출 </button>
		</div>
	
	</section>
	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
	<script src="/js/hotel_manage_agree.js"></script>
</body>

</html>