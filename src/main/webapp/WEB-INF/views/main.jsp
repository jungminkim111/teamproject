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
<title>바로고</title>

    <!-- CSS -->
<link href="/css/slide.css" rel="stylesheet" />

    <!-- JAVASCRIPT -->
<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/chatbot.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>

</head>
<body>
	<!-- header import -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!-- end of header import -->
	<hr>
	<section>
		<div class="slide">
			<div class="slidetext">
				<br> <br> <br> <br>
				<p style="font-size: 70px; line-height: 10px;">Travel to Korea.</p>
				<p style="font-size: 33px; line-height: 10px; color: gray;">Almost
					before we knew it, we
				<p style="font-size: 33px; color: gray;">had left the ground.</p>
			</div>
			<div class="slidebox">
				<input type="radio" name="slide" id="slide01" checked> <input
					type="radio" name="slide" id="slide02"> <input type="radio"
					name="slide" id="slide03"> <input type="radio" name="slide"
					id="slide04">
				<ul class="slidelist">
					<li class="slideitem">
						<div>
							<label for="slide04" class="left"></label> <label for="slide02"
								class="right"></label> <a><img src="/images/slideimg01.jpg"></a>
						</div>
					</li>
					<li class="slideitem">
						<div>
							<label for="slide01" class="left"></label> <label for="slide03"
								class="right"></label> <a><img src="/images/slideimg02.jpg"></a>
						</div>
					</li>
					<li class="slideitem">
						<div>
							<label for="slide02" class="left"></label> <label for="slide04"
								class="right"></label> <a><img src="/images/slideimg03.jpg"></a>
						</div>
					</li>
					<li class="slideitem">
						<div>
							<label for="slide03" class="left"></label> <label for="slide01"
								class="right"></label> <a><img src="/images/slideimg04.jpg"></a>
						</div>
					</li>
				</ul>
			</div>
					<div class="weather">
		<iframe width="100%" height="245"
			src="https://forecast.io/embed/#lat=37.5662&lon=126.9785&name=서울&color=#F6A8A6&font=arial&units=si"
			frameborder="0"></iframe>
		<iframe width="100%" height="245"
			src="https://forecast.io/embed/#lat=33.5007&lon=126.5288&name=제주&color=#ffc261&font=arial&units=si"
			frameborder="0"></iframe>
			</div>
		</div>

	</section>




	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
</body>

</html>