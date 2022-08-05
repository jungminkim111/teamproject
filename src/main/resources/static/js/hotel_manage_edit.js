let hotel_category="호텔";
let hotel_animal = 0;
let loginid ;


function isCheckNum(str){
	var checkReg=/^[0-9]{3,4}$/;
	if(checkReg.test(str.value)==false){
		alert("3~4자리 숫자만 입력해 주세요");
		str.value=null;
	}else{
	}
	return checkReg.test(str);
}
function isnumpress(event,type){
	if(type=="numbers"){
		if(event.keyCode <48|| event.keyCode >57)return false;
	}
}
function ischar(obj){
	if(event.keyCode==8||event.keyCode==9||event.keyCode==37||event.keyCode==39||event.keyCode==46)return;
	obj.value= obj.value.replace(/[\a-zㄱ-하-ㅣ가-힣]/g,'');
}

function getcategory(event) {
	hotel_category = event.target.value;
}
function getanimal(event) {
	hotel_animal = event.target.value;
}
function goPopup(){
	// 호출된 페이지(jusoPopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/hotel/manage/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusoPopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
	//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}
/** API 서비스 제공항목 확대 (2017.02) **/
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
						, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	document.getElementById('roadAddrPart').value = roadAddrPart1;
	document.getElementById('roadAddrPart').append = " "+roadAddrPart2;
	document.getElementById('addrDetail').value = addrDetail;
	document.getElementById('zipNo').value = zipNo;

}
const abs_add =function(){
		var i =document.createElement('div');
		i.setAttribute('class','abs_infor_room_infors')
		i.innerHTML='<div class="abs_infor_room_infors_inner spacingtb10">'
		+'	<div>룸 이름 : <input text=text class="room_name spacingtb10 roomtxt" maxlength="7" size=7 ></div>'
		+'	<div>침대 크기/수량 : <input text=text class="room_bed_size spacingtb10 roomtxt" maxlength="6" size=6 >/<input text=text class="room_bed_qty roomtxt" maxlength="6" size=6 ></div>'
		+'	<div>가격 : <input text=text class="room_price spacingtb10 roomtxt" maxlength="10" size=10 >'
		+'	<div>기타 사항 : <input text=text class="room_etc spacingtb10 roomtxt" ></div>'
		+'</div>';
		var addressContainer = document.getElementsByClassName("abs_infor")[0];
		addressContainer.appendChild(i);
};
	const abs_delete =function(){
		var select = document.getElementById('abs_infor');
		if(select.lastChild===null) return;
		select.removeChild(select.lastChild);
	};



$(document).ready(function () {

document.getElementById("roadAddrPart").onclick=function(){	
	goPopup(); 
	loginid = document.getElementById("sessionid").innerHTML; 
	$.ajax({
		url : '/loginconsist' ,
		data : {'id':loginid},
		type : 'post',
		dataType : 'json',
		success : function(respond){}
}); 	
};  
document.getElementById("add_abs_infor").onclick=function(){if(document.querySelectorAll(".abs_infor_room_infors").length>=3){return;};abs_add();};  
document.getElementById("delete_abs_infor").onclick=function(){ abs_delete();};  



document.getElementById("manage_add_hotel").onclick=function(){
	const url = location.href;
	const urlsplit=url.split('/');
	const hotelid =urlsplit[urlsplit.length-1];
	if(document.getElementById("hotel_names").value==''){alert('호텔명을 입력하세요.');return;}
	const hotel_address1=document.getElementById('roadAddrPart').value+"";
	const hotel_address2=document.getElementById('addrDetail').value+"";
	if(hotel_address1==null || hotel_address2==null || hotel_address1=='주소를 입력해주세요.'|| hotel_address2=='상세주소를 입력해주세요.'){
		alert('주소를 확인해주세요');
		return;
	}

	const hotel_name= document.getElementById("hotel_names").value +"";
	const hotel_phone = document.getElementById("hotel_phone1").value + "-" + document.getElementById("hotel_phone2").value + "-"+ document.getElementById("hotel_phone3").value
	let hotel_convenience = '';
	const h_convenience_array=document.querySelectorAll('.h_convenience');
	for(var i=0;i<h_convenience_array.length;i++){
		if(h_convenience_array.item(i).checked){
			hotel_convenience +=  h_convenience_array[i].value+',';
		}


	}
	const hotel_room_name=document.querySelectorAll(".room_name");
	const hotel_room_bed_size=document.querySelectorAll(".room_bed_size");
	const hotel_room_bed_qty=document.querySelectorAll(".room_bed_qty");
	const hotel_room_price=document.querySelectorAll(".room_price");
	const hotel_room_etc=document.querySelectorAll(".room_etc");

	let hotel_room='['
	for(var i=0;i<hotel_room_name.length;i++){
			if(hotel_room_name[i].value==""||hotel_room_bed_size[i].value==""||hotel_room_bed_qty[i].value==""||hotel_room_price[i].value==""){
				alert("ROOM 정보 입력내용을 확인하세요");	
				return;
			}
			hotel_room +='{ \"room_name\" : \"'+ hotel_room_name[i].value+'\" ,'
			+' \"room_bed_size\" : \"'+ hotel_room_bed_size[i].value+'\" ,'
			+' \"room_bed_qty\" : \"'+ hotel_room_bed_qty[i].value+'\" ,'
			+' \"room_price\" : \"'+ hotel_room_price[i].value+'\" ,'
			+' \"room_etc\" : \"'+ hotel_room_etc[i].value+'\" '
			;

		if(hotel_room_name.length-1==i){
			hotel_room += '}'
		}
		else{
			hotel_room +='} ,';
		}
	}
	hotel_room+=']';
	const hotel_rule=document.getElementById("hotel_rull").value +"";
	const hotel_detail_account=document.getElementById("detail_infor").value +"";
	const x=document.querySelectorAll("#image_preview img");
	if(x[0]!=null){
	var pictureList = new Array() ;
	 for(var i=0; i<x.length; i++){
		 var data = new Object() ; 
		 data.path = x[i].getAttribute("id"); 
		 pictureList.push(data) ; 
	}
		 var picture_jsonData = JSON.stringify(pictureList) ; 
	}
	$.ajax({
			url : '/hotel/manage/editpost' ,
			data : {'hotel_id':hotelid,
					'hotel_name':hotel_name,
					'business_id':loginid,
					'hotel_category':hotel_category,
					'hotel_address1':hotel_address1,
					'hotel_address2':hotel_address2+"",
					'hotel_phone':hotel_phone,
					'hotel_animal':hotel_animal,
					'hotel_convenience':hotel_convenience,
					'hotel_room':hotel_room,
					'hotel_rule':hotel_rule,
					'hotel_detail_account':hotel_detail_account,
					'hotel_picture':picture_jsonData
				},
			type : 'post',
			dataType : 'json',
			traditional:true,
			success : function(respond){
			   alert("수정이 완료되었습니다");
				window.location.href="/hotel/manage?page=1";
			}
	}); 
};
	{
	const url = location.href;
	const urlsplit=url.split('/');
	const hotelid =urlsplit[urlsplit.length-1];

		$.ajax({
			url : '/hotel/manage/editinfor' ,
			data : {'hotel_id':hotelid},
			type : 'post',
			dataType : 'json',
			success : function(respond){
				const categories =	document.querySelectorAll("input[name='category']");
				const animals= document.querySelectorAll("input[name='with_animal']");
				const conveniences =document.querySelectorAll(".h_convenience");
				for(let i=0; i<categories.length;i++){
					if(respond.hotel_category==categories[i].value){
						categories[i].setAttribute("checked","checked");
						break;
					}
				}
				if(respond.hotel_animal==1){animals[0].setAttribute("checked","checked");}
				else{animals[1].setAttribute("checked","checked");}
				for(let i=0; i<conveniences.length;i++){
					if(respond.hotel_convenience.includes(conveniences[i].value)){
						conveniences[i].setAttribute("checked","checked");
					}
				}
				
				for(let i=0; i<respond.hotel_room.length;i++){
					abs_add();
					let hotel_room_name=document.querySelectorAll(".room_name");
					let hotel_room_bed_size=document.querySelectorAll(".room_bed_size");
					let hotel_room_bed_qty=document.querySelectorAll(".room_bed_qty");
					let hotel_room_price=document.querySelectorAll(".room_price");
					let hotel_room_etc=document.querySelectorAll(".room_etc");
					hotel_room_name[i].value=respond.hotel_room[i].room_name;
					hotel_room_bed_size[i].value=respond.hotel_room[i].room_bed_size;
					hotel_room_bed_qty[i].value=respond.hotel_room[i].room_bed_qty;
					hotel_room_price[i].value=respond.hotel_room[i].room_price;
					hotel_room_etc[i].value=respond.hotel_room[i].room_etc;

				}
				
				for(let i=0; i<respond.hotel_picture.length;i++){
					imageLoader2(respond.hotel_picture[i].picture_path);
				}

			},
			error: function(respond){
				alert(respond.responseText);

			}
		}); 
	};
});