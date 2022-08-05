

var myCarousel = document.querySelector('#carouselExampleIndicators');
var carousel = new bootstrap.Carousel(myCarousel);
const makepic=function(e){
	var i =document.createElement('div');
	i.setAttribute("class","carousel-item");
	i.innerHTML='<img src="" class="d-block w-100" alt="">';
	var addressContainer = document.getElementsByClassName("carousel-inner")[0];
	addressContainer.appendChild(i);
};

const makeroom=function(e,x){
	var i =document.createElement('div');
	i.setAttribute("readonly","readonly");
	i.setAttribute("onfocus","this.blur()");
	i.setAttribute("class",'payment_hotel_room_infor ');
	i.setAttribute("id",'goedit'+x);
	i.innerHTML='<label for="ghost'+x+'"><div class="payment_hotel_room_namee"><div class="payment_hotel_room_name"><img src="/images/icons/room_bed.png"><span>'+e.room_name+'</span></div>'
	+'<div class="">유형 : '+e.room_bed_size+'</div>'
	+'<div class="">침대수 :'+e.room_bed_qty+'</div>'
	+'<div class="">가격 :'+e.room_price.toLocaleString()+'</div><input type="radio" id="ghost'+x+'"  name="ghost" class="checked3" value="'+e.room_price+'"></div></label>';
	var addressContainer = document.getElementById("payment_hotel_room_infors");
	addressContainer.appendChild(i);
};
const makepicbtn=function(e){
	var i =document.createElement('button');
	i.setAttribute("type","button");
	i.setAttribute("data-bs-target","#carouselExampleIndicators");
	i.setAttribute("data-bs-slide-to",e);
	i.setAttribute("aria-label","Slide "+ (e+1));
	var addressContainer = document.getElementsByClassName("carousel-indicators")[0];
	addressContainer.appendChild(i);
};

const makeConvenince=function(tagname){
	const makeicon=function(category,tagname,icon){
		var i =document.createElement('div');
		i.setAttribute("class","conveniences_list");
		var addressContainer = document.getElementById(category);

		addressContainer.appendChild(i);

		var j =document.createElement('img');
		j.setAttribute("src",icon);
		var addressContainer2 = i;

		addressContainer2.appendChild(j);
		i.innerHTML+=tagname;
	};
	let category;
	let icon;
	if(tagname=="주방"||tagname=="전자레인지"||tagname=="커피메이커"||tagname=="냉장고"||tagname=="식기류"|tagname=="기본조리도구"||tagname=="가스레인지또는인덕션"){
		category="kitchen";
		if(tagname=="주방"){icon="/images/icons/kitchen.png";}
		else if(tagname=="전자레인지"){icon="/images/icons/microwaves.png";}
		else if(tagname=="커피메이커"){icon="/images/icons/coffee-machine.png";}
		else if(tagname=="냉장고"){icon="/images/icons/refrigerator.png";}
		else if(tagname=="식기류"){icon="/images/icons/spoon.png";}
		else if(tagname=="기본조리도구"){icon="/images/icons/knife.png";}
		else if(tagname=="가스레인지또는인덕션"){tagname="가스레인지 또는 인덕션";icon="/images/icons/induction-stove.png";}
	}
	else if(tagname=="헤어드라이어"||tagname=="온수"||tagname=="샴푸"){
		category="bathroom";
		if(tagname=="헤어드라이어"){icon="/images/icons/hairdryer.png";}
		else if(tagname=="온수"){icon="/images/icons/hot-water.png";}
		else if(tagname=="샴푸"){icon="/images/icons/shampoo.png";}
	}	
	else if(tagname=="건조기"||tagname=="다리미"||tagname=="옷걸이"||tagname=="필수품목"||tagname=="세탁기"){
		category="cleaning";
		if(tagname=="건조기"){icon="/images/icons/bxs_dryer.png";}
		else if(tagname=="다리미"){icon="/images/icons/iron.png";}
		else if(tagname=="옷걸이"){icon="/images/icons/hanger.png";}
		else if(tagname=="필수품목"){tagname="수건,침대시트,비누,화장지"; icon="/images/icons/tissue.png";}
		else if(tagname=="세탁기"){icon="/images/icons/shampoo.png";}
	}
	else if(tagname=="난방"||tagname=="에어컨"){
		category="temperature";
		if(tagname=="난방"){icon="/images/icons/fireplace.png";}
		else if(tagname=="에어컨"){icon="/images/icons/aircon.png";}

	}
	else if(tagname=="무선인터넷"||tagname=="업무전용공간"){
		category="internet";
		if(tagname=="무선인터넷"){icon="/images/icons/wifi.png";}
		else if(tagname=="업무전용공간"){icon="/images/icons/workspace.png";}
	}	
	else if(tagname=="주차장"){
		category="parking";
		icon="/images/icons/parking.png";
	}	

	makeicon(category,tagname,icon);
};
// const Textarea = () => {
// 	const autoResizeTextarea = () => {
// 	  let textarea = document.querySelector('#hotel_detail_information_textarea');
  
// 	  if (textarea) {
// 		textarea.style.height = 'auto';
// 		let height = textarea.scrollHeight; // 높이
// 		textarea.style.height = `${height + 8}px`;
// 	  }
// 	};
//   }

let markers = new Array(); 
let infoWindows = new Array();

const x = parseFloat(document.getElementById("data_x").innerHTML);
const y = parseFloat(document.getElementById("data_y").innerText);
const title = document.getElementById("data_title").innerText;

var mapOptions = {
	center: new naver.maps.LatLng( y,x),
    zoom: 18
};
var map = new naver.maps.Map('map', mapOptions);

var marker = new naver.maps.Marker({
    position: new naver.maps.LatLng( y, x),
    map: map
});


var infoWindow = new naver.maps.InfoWindow({
	content: '<div style="width:200px;text-align:center;padding:10px;"><b>'+title +'</b></div>'
}); 
infoWindow.open(map, marker); 
markers.push(marker); 
infoWindows.push(infoWindow);


document.getElementById("pay_btn").onclick=function(){
	const url = location.href;
	const urlsplit=url.split('/');
	const hotelid =urlsplit[urlsplit.length-1];
	const business_id= document.getElementById("business_id").innerHTML;
	const hotel_name= document.getElementById("hotel_namess").innerHTML;
	startdate=document.getElementById("start_date").value;
	enddate=document.getElementById("end_date").value;
	let price=document.querySelector('input[name="ghost"]:checked').value; 
	const DateA= moment(startdate).format("YYYY-MM-DD HH:mm:ss");
	const DateB= moment(enddate).format("YYYY-MM-DD HH:mm:ss");
	const DateA2= moment(startdate);
	const DateB2= moment(enddate);
	const hotel_price=((DateB2.diff(DateA2,'days'))*price);



	$.ajax({
		url : '/hotel/getpay' ,
		data : {'hotel_id': hotelid,
				'hotel_name': hotel_name,
				'business_id': business_id,
				'start_date':DateA,
				'end_date': DateB,
				'payment': hotel_price,
				},
		type : 'post',
		dataType : 'json',
		success : function(respond){

			if(respond.pay==1){
				alert('예약 신청이 완료되었습니다.');
				window.location.href="/reservation";
			}
			else{
				alert('로그인 후 이용바랍니다.');
				window.location.href="/login";
			}
        }
	});  
}


	
$(document).ready(function () {
	const url = location.href;
	const urlsplit=url.split('/');
	const hotelid =urlsplit[urlsplit.length-1];

	$.ajax({
		url : '/hotel/getpictures' ,
		data : {'hotelId': hotelid},
		type : 'post',
		dataType : 'json',
		success : function(respond){
				for(let i =0 ;i<respond.length;i++){
					makepic();
					makepicbtn(i);
					document.querySelectorAll(".carousel-item img")[i].setAttribute("src",respond[i]);
				}			
				document.querySelectorAll(".carousel-item")[0].setAttribute("class","carousel-item active");
				const carobtn = document.querySelectorAll("button[ data-bs-target=\"#carouselExampleIndicators\"]")[0];
					carobtn.setAttribute("class","active");
					carobtn.setAttribute("aria-current","true");
					carobtn.setAttribute("aria-label","Slide 1");
        }
	});
	$.ajax({
		url : '/hotel/getconvenience' ,
		data : {'hotelId': hotelid},
		type : 'post',
		dataType : 'json',
		success : function(respond){
				for(let i =0 ;i<respond.length;i++){
					makeConvenince(respond[i]);

				}			

        }
	});  
	$.ajax({
		url : '/hotel/getroomdata' ,
		data : {'hotelId': hotelid},
		type : 'post',
		dataType : 'json',
		success : function(respond){
				for(let i =0 ;i<respond.length;i++){
					makeroom(respond[i],i);
					document.getElementsByClassName("checked3")[i].onclick= function(){
						let price=document.getElementsByClassName("checked3")[i].value;
						startdate=document.getElementById("start_date").value;
						enddate=document.getElementById("end_date").value;
						const DateA= moment(startdate);
						const DateB= moment(enddate);
						document.getElementById("total_payment").innerText = ((DateB.diff(DateA,'days'))*price).toLocaleString() +"원";
					};
				}
				document.getElementById("total_payment").innerText = respond[0].room_price.toLocaleString()+"원";
				document.getElementsByClassName("checked3")[0].setAttribute("checked","checked");
				{
				}

        }
	});  


});
