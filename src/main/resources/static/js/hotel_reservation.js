
	const res_list =function(){
			var i =document.createElement('tr');
			i.setAttribute('id','reservation_list')
			i.innerHTML='<td class="reservation_id"></td>'
			+'<td class="res_hotel_name"></td>'
			+'<td class="res_hotel_start"></td>'
			+'<td  class="res_hotel_end"></td>'
			+'<td class="res_hotel_confirm" ></td>'
			+'<td  class="res_payment"></td>'
			+'<td class="res_regitime" ></td>'
			+'<td class="res_confirm">'
			+'</td>';			
			var addressContainer = document.getElementById("reservation_list_table");
			addressContainer.appendChild(i);
	};
	const res_btn2 =function(e){
		var i =document.createElement('button');
		i.setAttribute('class','reserv_btns2')
		i.innerHTML='예약취소';			
		var addressContainer = document.getElementsByClassName("res_confirm")[e];
		addressContainer.appendChild(i);
};



$(document).ready(function () {
	let user_id="s"
	$.ajax({
		url : '/reservation' ,
		data : {'user_id':user_id},
		type : 'post',
		dataType : 'json',
		traditional:true,
		success : function(respond){
			for(let i=0; i<respond.length;i++){
				res_list();
				
				document.getElementsByClassName('reservation_id')[i+1].innerHTML=respond[i].reservation_id
				document.getElementsByClassName('res_hotel_name')[i+1].innerHTML=respond[i].hotel_name
				document.getElementsByClassName('res_hotel_start')[i+1].innerHTML=respond[i].start_date
				document.getElementsByClassName('res_hotel_end')[i+1].innerHTML=respond[i].end_date
				res_btn2(i+1);
				if(respond[i].confirm=="대기중"||respond[i].confirm=="예약승인"){
					document.getElementsByClassName('res_hotel_confirm')[i+1].innerHTML=respond[i].confirm
					document.getElementsByClassName('reserv_btns2')[i].onclick= function(){
						let con=confirm("정말로 취소하시겠습니까?")
						if(con){
							const id= innerHTML=respond[i].reservation_id;
							$.ajax({
								url : '/reservation/cancel' ,
								data : {'reservation_id':id},
								type : 'post',
								dataType : 'json',
								success : function(respond){	
									document.getElementsByClassName('res_hotel_confirm')[i+1].innerHTML=respond.result;
									document.getElementsByClassName('res_confirm')[i].innerHTML="";
									alert("예약취소됨");
									window.location.href="/reservation";
								}
						}); 
						}
						else{
							return;
						}
					}
				}
				else{
					
					document.getElementsByClassName('reserv_btns2')[i].setAttribute("hidden","hidden");
					document.getElementsByClassName('res_hotel_confirm')[i+1].innerHTML=respond[i].confirm
				}
				document.getElementsByClassName('res_payment')[i+1].innerHTML=parseInt(respond[i].payment).toLocaleString();
				document.getElementsByClassName('res_regitime')[i+1].innerHTML=respond[i].regist_time
			}
		}
}); 

});