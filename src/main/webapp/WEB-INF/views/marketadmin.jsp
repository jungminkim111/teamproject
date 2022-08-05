<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.6.0.min.js"></script>
<script src="js/chatbot.js"></script>
<script src="js/marketadmin.js"></script>
<script type="text/javascript">




</script>
<link href="css/marketadmin.css" rel="stylesheet">
</head>

<body>
	<!-- header import -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!-- end of header import -->
	
	<div id="container">	
		<div id="con">
			
			<div id="li_div" style="margin-bottom:20px">
			<ul>
			
			<a href="marketadmin?id=aaaa"><li>등록상품</li></a>
			<a href="#" id="orderby"><li>주문내역</li></a>
			<a href="#" id="proregister"><li>상품등록</li></a>
			<a href="#"id="proupdate"><li>상품정보 수정</li></a>
			<a href="#" id="deletemember" onclick=ajaxdelete() ><li>선택상품 삭제</li></a>
			</ul>
			</div>	
			<div id="fd"></div>
			<div id="con2">
			
			<table border = "1" id="tb_1">
			<tr>
			
			<td>No</td>
			<td>상품명</td>
			<td>판매가</td>
			<td>수량</td>
			<td>상품설명</td>
			</tr>
		
			<c:forEach items="${list}" varStatus ="dto" var="dto1">
				
					<tr>
				<td>
				${dto.index+1 }
				</td>
				<td>
				<input type='checkbox' class='cbox'>
				<img class='tdimg' src ='/upload/${dto1.imgname}' } > 
				<p class='p_${dto.index }'>${dto1.name}</p>
				</td>
				<td>￦${dto1.price}</td>
				<td>${dto1.num}</td>
				<td>${dto1.explain1 }</td>
				</tr>
					
			</c:forEach>
				</table>
		
		
		
			</div>
		</div>
		
	</div>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
</body>

</html>