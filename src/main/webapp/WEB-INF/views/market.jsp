<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/market.css" rel="stylesheet">
<script src="jquery-3.6.0.min.js"></script>
<script src="js/chatbot.js"></script>
<script src="js/market.js"></script>
<script type="text/javascript">
function numchange(i){
	var total1= $('#changenum'+i).val()*$('#changeprice'+i).text()
	
	$('.num_only'+i).text(total1)
		
	var total = 0
	for(var j = 0 ; j<${fn:length(basketlist)} ; j++){
		total += parseInt($('.num_only'+j).text())
		
	}
	$('#totalinput').val(total)
	}//numchange end


	
	$(document).ready(function(){
	
		var total = 0
		for(var j = 0 ; j<${fn:length(basketlist)} ; j++){
			total += parseInt($('.num_only'+j).text())
			
		}
		$('#totalinput').val(total)
		}
	
	)
	
	
	
	
	
	
		
		
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
	

	<div id="con1">
		<div id="con2">
			<select id="select1">
			<!--foreach 옵션 -->
					<option>마켓선택</option>
			<c:forEach items="${marketlist }" var="dto3">
				
					<option>${dto3.market }</option>
				
			</c:forEach>	
			<!--/foreach  -->	
			
			</select>
			<!--foreach리스트  -->
		<div id="con3">
		<ul>
		<c:forEach items = "${marketprolist}" var="dto" varStatus="prolist">	
		<c:set var="i" value = "${i+1 }"/>
		
			<li class="lii${prolist.index } lid" ) onmouseover="lihover(${prolist.index })" onmouseout="liout(${prolist.index })">
			<div class="li3 lif${prolist.index }">
				<div class='li4 lia'>
			<input type ="button" value = "장바구니담기" id = "basket${prolist.index }" onclick = basketajax(${prolist.index })>
				</div>
			</div>
			<div class='li5 lib'>
			<img class='listimg' src ='/upload/${dto.imgname}' } >
			</div>
			<h3>상품명 :</h3> <p id="p_product${prolist.index }">${dto.name}</p>
			<h3>가격 :</h3>  <p id = "p_price${prolist.index }">${dto.price}</p><br>
			<h4>상품소개 :</h4><br> <p id = "p_explain${prolist.index }"> ${dto.explain1}</p>
			
			</li>
		<c:if test="${i==7 }">
			<br>
		<c:set var="i" value = "0"/>
		</c:if>	
		
		</c:forEach>	
		</ul>
		</div>			
		</div>
		<form action= "payment">
		<div class="modal"> 
		<div class="modal_body">
			 <div class="modal_tb">
        	<table border='1' id="basket_tb">
           	<tr><th style= 'width:170px'>상품명</th><th style= 'width:70px'>수량</th><th style= 'width:130px'>주문금액</th><th style= 'width:90px'></th></tr>
            <c:forEach items='${basketlist}' var = 'dto' varStatus="dto1">
           	<tr><td style= 'width:170px'>
           	<input class="ckbox" type = "checkbox" id = "bs_ck${dto1.index }" class="bscl" checked='checked'>
           	<input class='payname' readonly='readonly' type=text name='name' style = 'border:0;' value='${dto.name}'></td>
           	<td style= 'width:70px'><input min="0" id='changenum${dto1.index }' onchange=numchange(${dto1.index }) type = number value =${dto.num} style = 'width:30px;height:20px;'> </td>
           	<td style= 'width:130px' id='changeprice${dto1.index }'>${dto.price }</td>
           	<td style='width:90px' class='num_only${dto1.index }'>
           	${dto.num*dto.price }
           	</td></tr>
           	</c:forEach>
           	
            </table>
            
            </div>
		
				<div id="totalprice">
		
		총 결제금액 :<input readonly="readonly" type= "text" id = "totalinput" name = "price" style='border:0;' />
			
				</div>
			<input id="delete_bs" type = "button" value="장바구니에서 삭제"> 
			<div id="inbtn">
			
			<input type="submit" value = "결제하기" id= "clo2">
			<input type="button" value = "장바구니닫기" id= "clo1">
			
			</div>
		</div> 
		</div>
			</form>
	</div>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer2.jsp"%>
	<!-- end of footer import -->
</body>

</html>