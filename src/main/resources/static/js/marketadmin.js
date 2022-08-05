/**
 * 
 */
var count=0

function ajaxdelete(){
	var name = $("input[type='checkbox']").val()

	if(confirm("삭제하시겠습니까?")){
	 $.ajax({
		
		 url:"ajaxdelete",
		data: {name:$('input:checked~p').text()} ,
		type:"post",
		dataType:"json",
		success:function(dto){
		 location.href='marketadmin?id=aaaa '
			}	,
		/*success함수는 받는게있어야 함수실행됨*/
		error:function(err){
			console.log(err)
		}
		
		
		
	})//ajax end
	alert("삭제됨")
		}else{
	alert("삭제안됨")
		}
}

function upajax(){
			var formData1 = new FormData($('#updateform')[0]);
			formData1.append("name1",$('input:checked~p').text())
		$.ajax({
					url: '/ajaxupdate'	,
					data: formData1 ,
					processData : false,
					contentType : false,
					type:"post",
					dataType:"json",
					enctype :'multipart/form-data',
					success:function(dto){
						alert('수정완료')
						location.href='marketadmin?id=aaaa '
					},
					error:function(err){
						console.log(err)
					}
					
					
				})//ajax end
}
			

			
	//상품등록		
function requestajax(k){
		
		var formData = new FormData($('#insert'+k)[0]);
	 $.ajax({
		 	
		 url:"/ajaxtable2",
		data: formData ,
		processData : false,
		contentType : false,
		type:"post",
		dataType:"json",
		enctype :'multipart/form-data',
		success:function(list){
			alert(list[list.length-1].name+"상품등록완료")
			var tb_1 = "";
	 		tb_1+="<table border = '1' id='tb_1'>"
	 		tb_1+="<tr>"
	 		tb_1+="<td>No</td>"
	 		tb_1+="<td>상품명</td>"
	 	    tb_1+="<td>판매가</td>"
	 	    tb_1+="<td>수량</td><td>상품설명</td></tr>"
	 	    $("#tb_1").html(
				tb_1
			)
			for(var i = 0 ; i<list.length;i++){
			$("#tb_1").append(
				"<tr><td>"+(i+1)+"</td><td><input type='checkbox' class='cbox'><img class='tdimg' src=/upload/"+
				list[i].imgname+">"+"<p>"+list[i].name+"</p>"+"</td><td>"+"￦"+
				list[i].price+"</td><td>"+list[i].num+"</td><td>"+list[i].explain1+"</td></tr>"	
				
				)
			}
			+"</table>"
				
			
		},
		error:function(err){
			console.log(err)
		}
				})//ajax end 
}
function deleteinsert(i){ //1
	$("form").remove("#insert"+i);
	count --;
}





$(document).ready(function(){
	
			/* 상품수정 */
	$("#proupdate").click(
		function(){
				count=0
		
			$.ajax({
					url:"/updateinfo",
					data: {name:$('input:checked~p').text(),id:'aaaa'} ,
					type:"post",
					dataType:"json",
					success:function(dto){
						var tb_2 = ""
				tb_2+="<form id = 'updateform'>"	
				tb_2+="<table border='3'>"
				tb_2+="<tr><td rowspan='2' id='td_2' style='height:300px;width:600px;' >"
				tb_2+="<input type ='file' id='file1' name='img'></td>"
				tb_2+=" <td>상품명 :<input type = 'text' id='pro'  name= 'name' value="+dto.name +" /></td>"
				tb_2+="<td>상품수량 : <input type = 'number' id = 'num1' name= 'num' value="+dto.num +"> </td>"
				tb_2+="<td>상품가격 : <input type= 'text' id = 'price'  name= 'price' value="+dto.price +"></td></tr>" 
				tb_2+="<tr><td colspan='3' style='height:240px;'><textarea rows=''  name= 'explain1' cols='' placeholder='상품설명'>"+dto.explain1+"</textarea>	</td></tr> "
				tb_2+="</table><div id='sub'><input type='button' value = '수정완료' id='updateajax' onclick=upajax() class='inbtn'></div></form>"	
				
						alert(dto.id)
					$("input:checked").attr("disabled", true)	
					$("#fd").html(tb_2)	
					$("#sub").html
				("<input type='button' value = '수정완료' id='updateajax' onclick=upajax() class='inbtn'> ")		
					},
					error:function(err){
			console.log(err)
		}
				
				
				
		})  
	} 
	
		)	//click end
	

		/* 주문내역  필터기능 추가*/
	 	$("#orderby").click(
	 		
	 		function(){
	 		count=0
	 		var tb_1 = "";
	 		tb_1+="<table border = '1' id='tb_1'>"
	 		tb_1+="<tr>"
	 		tb_1+="<td>No</td>"
	 		tb_1+="<td>상품명</td>"
	 	    tb_1+="<td>판매가</td>"
	 	    tb_1+="<td>수량</td></tr>"
	 	    tb_1+="<tr><td></td><td>오더</td><td></td><td></td><td</td></tr>"			
	 	    tb_1+="</table>"	
	 		$("#con2").html(tb_1)
	 		}		
	 	)
	 	/*상품등록  */
	 	$("#proregister").click(
	 			
		function(){
			
		
			switch (count) {
				
			case 0:
				var tb_2 = ""
					tb_2+="<form id='insert1'>"
					tb_2+="<table border='3'>"
					tb_2+="<tr><td rowspan='2' id='td_2' style='height:300px;width:600px;' >"
					tb_2+="<input type ='file' id='file1' name= 'img' ></td>"
					tb_2+=" <td>상품명 : <input type = 'text'  id='name' name= 'name'></td>"
					tb_2+="<td>상품수량 : <input type = 'number'  id='num'  name= 'num'> </td>"
					tb_2+="<td>상품가격 : <input type= 'text'  id='price' name= 'price'></td></tr>" 
					tb_2+="<tr><td colspan='3' style='height:240px;'><textarea rows='' cols='' placeholder='상품설명'  id='explain1'  name= 'explain1'></textarea>	</td></tr> "
					tb_2+="</table><div id='sub'><input type='button' id='ajaxbtn1' value='상품등록' onclick='requestajax(1);deleteinsert(1);' class='inbtn'> </div></form>"
		
				$("#fd").html(tb_2)
	 			
			
				
				count++;
				
				break;

			case 1:
				var tb_2 = ""
					tb_2+="<form id='insert2'>"	
					tb_2+="<table border='3'>"
					tb_2+="<tr><td rowspan='2' id='td_2' style='height:300px;width:600px;' >"
					tb_2+="<input type ='file' id='file1'  name= 'img'></td>"
					tb_2+=" <td>상품명 : <input type = 'text'  id='name' name= 'name'></td>"
					tb_2+="<td>상품수량 : <input type = 'number'  id='num' name= 'num'> </td>"
					tb_2+="<td>상품가격 : <input type= 'text'  id='price' name= 'price'></td></tr>" 
					tb_2+="<tr><td colspan='3' style='height:240px;'><textarea rows='' cols='' placeholder='상품설명'  id='explain1'  name= 'explain1'></textarea>	</td></tr> "
					tb_2+="</table><div id='sub'><input type='button' id='ajaxbtn1' value='상품등록' onclick='requestajax(2);deleteinsert(2)' class='inbtn'> </div></form>"
				$("#fd").append(tb_2)
	 			
				
				count++;
				break;
			case 2:
				var tb_2 = ""
					tb_2+="<form id='insert3'>"	
					tb_2+="<table border='3'>"
					tb_2+="<tr><td rowspan='2' id='td_2' style='height:300px;width:600px;' >"
					tb_2+="<input type ='file' id='file1'  name= 'img'></td>"
					tb_2+=" <td>상품명 : <input type = 'text'  id='name' name= 'name'></td>"
					tb_2+="<td>상품수량 : <input type = 'number'  id='num' name= 'num'> </td>"
					tb_2+="<td>상품가격 : <input type= 'text'  id='price' name= 'price'></td></tr>" 
					tb_2+="<tr><td colspan='3' style='height:240px;'><textarea rows='' cols='' placeholder='상품설명'  id='explain1'  name= 'explain1'></textarea>	</td></tr> "
					tb_2+="</table><div id='sub'><input type='button' id='ajaxbtn1' value='상품등록' onclick='requestajax(3);deleteinsert(3)' class='inbtn'> </div></form>"
				$("#fd").append(tb_2)
	 			count++;
				break;
				
			default:
				count--;
				alert("상품등록은 한번에 세개까지 가능합니다")
				break;
				}	
				
				
		}
			)
			
		
	
		

		
	}
	)//ready end
	
	
	
	
	