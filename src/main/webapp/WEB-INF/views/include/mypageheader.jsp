<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/header.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- header -->
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
      paddingTop: "9px",
      margin: "0 auto",
    });

    $("#header #headerlogin").css({
      float: "right",
    });

    $("#headerlogin li").css({
      float: "left",
      marginTop: "23px",
      marginLeft: "20px",
      lineHeight: "60px",
      fontSize: "25px",      
    });
    
    


  });
</script>
<!-- end of header -->
</head>

<header>
<div id="header">
	<h1 id="logo_font">
		<a class="logo_font" href="<c:url value='/' />"> <img
			src="<c:url value='/images/barogo_logo1.png' />" alt=" " id="logoimg" />
		</a>
	</h1>
	<div id="headerlogin">
		<ul>
			<li><a href="<c:url value='/Hotel' />" style="font-size: 30px;">Hotel</a></li>
			<li><a href="<c:url value='/Market' />" style="font-size: 30px;">Market</a></li>
		

		<c:if test="${userId == null }">
			

				<li><a href="<c:url value='/login' />" style="font-size: 15px;">Login</a></li>
				<li><a href="<c:url value='/Agreement' />
					"
					style="font-size: 15px; border: 1px solid gray;">Sign Up</a></li>
		
		</c:if>
		<c:if test="${userId != null }">
			
				<li><a href="<c:url value='/logout' />" style="font-size: 15px;">Logout</a></li>
				<li><a href="<c:url value='/mypagepw_form' />" style="font-size: 15px;">Mypage</a></li>
			
		</c:if>
		</ul>
	</div>
</div>
</header>

</html>