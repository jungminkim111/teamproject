/**
 * 
 */
function lihover(i){
		$(".lif"+i).css("display","block")		
				}
function liout(i){
		$(".lif"+i).css("display","none")
				}		
function basketajax(i){	
	var product = '#p_product'+i
	var price = '#p_price'+i
	$.ajax({
			url:"/basket",
			data:{name:$('#p_product'+i).text() , num:'1' , price:$('#p_price'+i).text() },
			type:'post',
			dataType:'json',
			success:function(dto){
				alert($(product).text() + "상품이 장바구니에 담겼습니다")
					$("#basket_tb").html(
			"<tr><th style= 'width:170px'>상품명</th><th style= 'width:70px'>수량</th><th style= 'width:130px'>주문금액</th><th style= 'width:90px'></th></tr>"	
			)		
				for(var j=0 ; j<dto.length;j++){
						
					$("#basket_tb").append(
								
			"<tr><td style= 'width:170px'><input type = 'checkbox' checked='checked' class='bscl'><p>"+
			dto[j].name+"</p></td><td style= 'width:70px'><input type = 'number' style = 'width:30px;height:20px;' value ="+dto[j].num+">"+
			"</td><td style= 'width:130px'>"+dto[j].price+"</td><td style='width:90px'>"+dto[j].num*dto[j].price+"</td></tr>"	
					)
				}
           	
			},
			err:function(err){
				console.log(err)
			}
		})
			}
			
			
		
$(document).ready(function(){	
		
		/*결제 total 금액*/
		
		
		
		
		
		
		
	
		
		/*장바구니 삭제*/
	$('#delete_bs').click(
			
			function(){
		var name = []
	
		$('input:checked~p').each(function(){
			name.push($(this).text());
		})	
		var name1 = {
			'name':name
		}
		$.ajax({
			url: '/deletebasket'	,
					data:name1,
					type:'post',
					dataType:'json',
					traditional:true,
					success:function(dto){
						alert('장바구니 삭제완료')
						$('#basket_tb').html(
		"<tr><th style= 'width:170px'>상품명</th><th style= 'width:70px'>수량</th><th style= 'width:130px'>주문금액</th><th style= 'width:90px'></th></tr>"	
						)
						for(var i =0 ; i<dto.length;i++){
						$('#basket_tb').append(	
			"<tr><td style= 'width:170px'><input type = 'checkbox'  class='bscl' checked='checked'>"+dto[i].name+
			"</td><td style= 'width:70px'><input type = 'number' style = 'width:30px;height:20px;' value ="+dto[i].num+">"+
			" </td><td style= 'width:130px'>"+dto[i].price+"</td><td style='width:90px'>"+dto[i].num*dto[i].price+"</td></tr>"					
					
						)
						
						
						}
						
					
					},
					error:function(err){
						console.log(err)
					}
					
					
				})//ajax end	
			
					})
			$('#select1').change(function(){
				
				location.href='market?market='+$('#select1').val()
				
				})

		
	/*				$.ajax({
					url: '/changeoption'	,
					data: {market:$('#select1').val()},
					type:'post',
					dataType:'json',
					success:function(changelist){
						
			$('li').remove('.lid')
			
			for(var i = 0 ;i<changelist.length;i++)	{				
			$('#con3 ul').append(	
			"<li class='lii" + i + " lid' ) onmouseover='lihover("+i+")' onmouseout='liout("+i+")'>"+
			"<div class='li3 lif"+i+"'>"+
			"<div class='li4 lia'>"+
			"<input type ='button' value = '장바구니담기' id = 'basket"+i+"' onclick = basketajax("+i+")>"+
			"</div>"+
			"</div>"+
			"<div class='li5 lib'>"+
			"<img class='listimg' src ='/upload/"+changelist[i].imgname+"' >"+
			"</div>"+
			"<h3>상품명 :</h3> <p id='p_product"+i+"'>"+changelist[i].name+"</p>"+
			"<h3>가격 :</h3>  <p id = 'p_price'"+i+">"+changelist[i].price+"</p><br>"+
			"<h4>상품소개 :</h4><br> <p id = 'p_explain'"+i+"> "+changelist[i].explain1+"</p>"+
			"</li>"
						
					)//append end
				}
					
					},//success end
					error:function(err){
						console.log(err)
					}
					
					
				})//ajax end	*/
				
				$('#clo1').click(function(){
					$('.modal').css('display','none')
					
				})
					
	
	
		
		
	
		
		
	
})




	
	
 
 
