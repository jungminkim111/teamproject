<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

    <!-- CSS -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- JAVASCRIPT -->
<script type="text/javascript"src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="/js/payment.js"></script>
<body>
	<!-- header import -->
	<%@ include file="/WEB-INF/views/include/findheader.jsp"%>
	<!-- end of header import -->
	<hr>
	<br>
	<br>

	<form action="/payment" method="post" id="payform">
		<div class="w3-content w3-container w3-margin-top">
			<div class="w3-container w3-card-4">
				<div class=" w3-large w3-margin-top">
					<div>
						<label class="label" for="proname">상품 이름 </label> <br> <input
							type="text" class="w3-input" id="proname" name="proname">
					</div>

					<div>
						<label class="label" for="amount">가격 </label> <br> <input
							type="text" class="w3-input" id="amount" name="amount">
					</div>
					<div>
						<br> <br>
						<h2>결제 정보 등록</h2>
						<p>정보 입력후 결제하기를 눌러주세요</p>
					</div>
					<div>
						<label class="label" for="buyer_email">이메일</label> <input
							type="text" class="w3-input w3-border w3-round" id="buyer_email"
							name="buyer_email">
					</div>

					<div>
						<label class="label" for=" buyer_name">이름 </label> <input
							type="text" class="w3-input w3-border w3-round" id="buyer_name"
							name="buyer_name">
					</div>

					<div>
						<label class="label" for="buyer_tel">번호 </label> <input
							type="text" class="w3-input w3-border w3-round" id="buyer_tel"
							name="buyer_tel">
					</div>

					<div>
						<label class="label" for="buyer_addr">주소 </label> <input
							type="text" class="w3-input w3-border w3-round" id="buyer_addr"
							name="buyer_addr">
					</div>

					<div>
						<label class="label" for="buyer_addr">번지수 </label> <input
							type="text" class="w3-input w3-border w3-round"
							id="buyer_postcode" name="buyer_postcode">
					</div>

				</div>
				<button id="iamportPayment" type="button"
					class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">결제하기</button>
			</div>
		</div>
	</form>


</body>
</html>