
$(document).ready(function () {
	
	const urlParams = new URL(location.href).searchParams;
	let page = urlParams.get('page');
	if(page==null){
		page=1;
	}

	const makelist=function(){
		var i =document.createElement('li');
		i.innerHTML='<a class="manage_hotel_list_infor goedit" >'
		+'	<div class="manage_hotel_list_infor_pic_div"><img class="manage_hotel_list_infor_pic"/></div>'
		+'	<div class="manage_hotel_list_infor_contents">'
		+'		<div class="manage_hotel_list_infor_name">'
		+'			<span class="manage_hotel_name"></span>'
		+'		</div>'
		+'		<div class="manage_hotel_list_infor_detail"></div>'
		+'	</div></a>';
		var addressContainer = document.getElementsByClassName("manage_hotel_ul")[0];
		addressContainer.appendChild(i);
	}
	const makepage=function(e){
		//<li class='manage_hotel_list_page'><a href=/hotel/manage?page=1>1</a></li>
		var i =document.createElement('li');
		i.setAttribute("class",'manage_hotel_list_page');
		i.innerHTML='<a href=/hotel/manage?page='+e+'>'+e+'</a>';
		var addressContainer = document.getElementById("manage_hotel_list_pages");
		addressContainer.appendChild(i);
	}
	// const add_clcik=function(){
	document.getElementById("add_hotel").onclick=function(){
		window.location.href="/hotel/manage/post";
	};

	$.ajax({
			url : '/hotel/manage/getcount' ,
			data : {'page':1},
			type : 'post',
			dataType : 'json',
			success : function(respond){
               for(let i=1;i<= parseInt(respond.count/3+1);i++){
					makepage(i);

			   } 
               
            }
    }); 
	$.ajax({
		url : '/hotel/manage' ,
		data : {'page':page},
		type : 'post',
		dataType : 'json',
		success : function(respond){
		   for(let i=0;i<respond.length;i++){
				makelist();
				const hotelname= document.getElementsByClassName("manage_hotel_list_infor_name")[i];
				const pic_url= document.getElementsByClassName("manage_hotel_list_infor_pic")[i];
				const contents= document.getElementsByClassName("manage_hotel_list_infor_detail")[i];
				const edithref = document.getElementsByClassName("goedit")[i];
				edithref.setAttribute("href","/hotel/manage/edit/"+respond[i].hotel_id);
				hotelname.innerHTML = respond[i].hotelname;
				pic_url.setAttribute("src",respond[i].pic_url);
				contents.innerHTML = respond[i].contents;
		   } 
		   
		}
}); 
});