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
<link rel="stylesheet" href="/css/hotelheader.css" />
<link rel="stylesheet" href="/css/hotel.css" />
<script>
  $(document).ready(function () {
    $("#logoimg").css({
      height: "75px",
    });

    $("#header, #nav").css({
      width: "1850px",
      height: "80px",
      margin: "0 auto",

    });

    $("#nav").css({
      display: "block",
    });

    $("#header h1").css({
      float: "left",
      paddingTop: "0",
      margin: "0 auto",
    });

    $("#header #headerlogin").css({
      float: "right",
    });

    $("#headerlogin li").css({
      float: "left",
      marginTop: "0px",
      marginLeft: "20px",
      lineHeight: "60px",
      fontSize: "25px",      
    });
    
    


  });
</script>
</head>
<body style="background-image: URL(/images/hotel.png); 
background-repeat: no-repeat;
background-size: 100% 250px; 
 background-blend-mode: multiply;">
 <header >
	
<div id="header" >
	<h1 id="logo_font">
		<a class="logo_font" href="<c:url value='/main' />"> <img
			src="<c:url value='/images/barogo_logo2.png' />" alt=" " id="logoimg" />
		</a>
	</h1>
	<div id="headerlogin">
		<ul>
			<li><a href="<c:url value='/Hotel' />" style="font-size: 30px;">Hotel</a></li>
			<li><a href="<c:url value='/Market' />" style="font-size: 30px;">Market</a></li>
			<li><a href="<c:url value='/login' />" style="font-size: 15px;">Login</a></li>
			<li><a href="<c:url value='/agreement' />
			"style="font-size: 15px; border: 1px solid gray;">Sign Up</a></li>
		</ul>
	</div>

</div>

</header>
	<!-- header import -->
	<%-- <%@ include file="/WEB-INF/views/include/hotelheader.jsp"%> --%>
	<!-- end of header import -->
	<hr />
	<section id="hotel_lists_section">

		<div class="search_bar">
			<div id="search_bars">
				<input type="text" class="searchtextbox"><button class="search_btns1">검색</button>
			</div>
		</div>
		<div id="search_list">

		</div>
	</section>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
<!-- 	<script src="/js/hotel_list.js"></script> -->
	<script src="/js/hotel_search.js"></script>
	<!-- end of footer import -->
</body>

</html>