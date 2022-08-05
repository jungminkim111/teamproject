let page= 2;
document.getElementsByClassName("search_btns1")[0].onclick=function(){
	const val= document.getElementsByClassName("searchtextbox")[0];

	window.location.href="/hotel/search?text="+val.value+"?page=";

}
const getAjax = function() {
	return new Promise((resolve, reject) => { // 1.
	  $.ajax({
		url: "/hotel",
		type: "post",
		dataType: "json",
		data: {'page':page},
		success: (respond) => {
			resolve(respond);
		},
		error: (e) => {
		  reject(e);  // 3.
		}
	  });
	});
  }
	
const makediv=function(){
	return new Promise((resolve, reject) => {
	var i =document.createElement('li');
	i.innerHTML='<div class="hotel_list_infor" ><a class="goedit" href="">'
			+'<div class="hotel_list_infor_pic"><img class="hotel_list_infor_pic_img" src=""></div>'
			+'<div class="hotel_list_infor_contents">'
			+'	<div class="hotel_list_infor_name">'
			+'		<span class="hotel_name"></span>'
			+'			<div class="hotel_reservation_button"></div>'
			+'		</div>'
			+'	<div class="hotel_list_infor_detail">'
			+'	</div>'
			+'</div>'
			+'</a></div>';
	var addressContainer = document.getElementsByClassName("hotel_list")[document.getElementsByClassName("hotel_list").length-1];
	addressContainer.appendChild(i);
	resolve(addressContainer.appendChild(i));
	})
};
const makesection=function(){
	var i =document.createElement('div');
	i.setAttribute("class","hotel_list");
	var addressContainer = document.getElementById("search_list");
	addressContainer.appendChild(i);
}
const inserttodiv = function(i,respond) {
	return new Promise((resolve, reject) => {
	const hotelname= document.getElementsByClassName("hotel_list_infor_name")[i+15*(page-2)];
	const pic_url= document.getElementsByClassName("hotel_list_infor_pic_img")[i+15*(page-2)];
	const contents= document.getElementsByClassName("hotel_list_infor_detail")[i+15*(page-2)];
	const edithref = document.getElementsByClassName("goedit")[i+15*(page-2)];
	edithref.setAttribute("href","/hotel/"+respond[i].hotel_id);
	hotelname.innerHTML = respond[i].hotel_name;
	pic_url.setAttribute("src",respond[i].hotel_picture);
	contents.innerHTML = respond[i].hotel_phone+"<br>"+respond[i].hotel_address1+" "+respond[i].hotel_address2+"<br>";
	resolve();
	})
	};

	window.addEventListener('scroll',async () => { 
		 scrollTop = parseInt( $(window).scrollTop());
		 innerHeight = $(window).innerHeight();
		 scrollHeight = $('html').prop('scrollHeight')
		if( scrollTop+innerHeight>=scrollHeight){
			 const respond=await getAjax()
			 if(respond.length==0){return;}
			 else{				
				 makesection();
				 page++;
				 for(let i=0;i<respond.length;i++){
					 makediv();
				 } 
				 for(let i=0;i<respond.length;i++){
					 inserttodiv(i,respond);
				 } 
			 }
		}				

	});


$(document).ready(function () {
	const url = decodeURI(location.href);
	const urlsplit=url.split('/');
	const txt=urlsplit[urlsplit.length-1]
	const txt1=txt.split('?')[1];
	const txt2=txt1.split('=')[1].split('?')[0];
	const text=txt2.split('?')[0];

	$.ajax({
		url : '/hotel/search' ,
		data : {'text':text,
				'page':1},
		type : 'post',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType : 'json',
		success : function(respond){
			makesection();
			for(let i=0;i<respond.length;i++){
				makediv();
				const hotelname= document.getElementsByClassName("hotel_list_infor_name")[i];
				const pic_url= document.getElementsByClassName("hotel_list_infor_pic_img")[i];
				const contents= document.getElementsByClassName("hotel_list_infor_detail")[i];
				const edithref = document.getElementsByClassName("goedit")[i];
				edithref.setAttribute("href","/hotel/"+respond[i].hotel_id);
				hotelname.innerHTML = respond[i].hotel_name;
				pic_url.setAttribute("src",respond[i].hotel_picture);
				contents.innerHTML = respond[i].hotel_phone+"<br>"+respond[i].hotel_address1+" "+respond[i].hotel_address2+"<br>";
		   } 
		  
		}
	}); 


});