let deleteChk= new Array();

const listarr = new Array();
const makelist=function(e){
	var i =document.createElement('li');
	i.setAttribute("class","delete_list");
	i.setAttribute("readonly","readonly");
	i.setAttribute("onfocus","this.blur()");
	i.innerHTML='<a class="manage_hotel_list_infor goedit" id="goedit'+e+'"><div class ="hid_id" id="hid'+e+'" hidden ></div>'
	+'	<div class="manage_hotel_list_infor_pic_div"><img class="manage_hotel_list_infor_pic"/></div>'
	+'	<div class="manage_hotel_list_infor_contents">'
	+'		<div class="manage_hotel_list_infor_name " readonly>'
	+'			<span class="manage_hotel_name" readonly></span>'
	+'		</div>'
	+'		<div class="manage_hotel_list_infor_detail" readonly></div>'
	+'	</div></a>';
	var addressContainer = document.getElementsByClassName("manage_hotel_ul")[0];

	listarr[e]=addressContainer.appendChild(i);
};

document.getElementById("delete_hotel").onclick=function(){

	let delete_member = document.querySelectorAll(".delete_member");
	let deleteid=new Array();
	let str="";
	let count = 0;
	let bbbtn = new Promise(function (resolve, reject) { 
		for(var i=0; i<delete_member.length;i++){
			deleteid[i]=delete_member[i].getElementsByClassName("hid_id")[0].innerHTML;
				 str+=deleteid[i];
				 count++;
		}
	if(count==0){		
		alert("삭제할 항목을 선택해주세요.");
		return;
	}
	else{

		let conf = confirm("정말로 삭제하시겠습니까?");
		if(conf){
			$.ajax({
				url : '/hotel/manage/delete' ,
				data : {'delete_id':str},
				type : 'post',
				dataType : 'json',
				success : function(respond){
					window.location.href="/hotel/manage/delete";
					}
				}); 
		}
	}
	});

};

$(document).ready(function () {
	const urlParams = new URL(location.href).searchParams;
	let page = urlParams.get('page');
	if(page==null){
		page=1;
	}
	const makepage=function(e){
		var i =document.createElement('li');
		i.setAttribute("class",'manage_hotel_list_page');
		i.innerHTML='<a href=/hotel/manage/delete?page='+e+'>'+e+'</a>';
		var addressContainer = document.getElementById("manage_hotel_list_pages");
		addressContainer.appendChild(i);
	}
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
				   makelist(i);
				   const hotelname= document.getElementsByClassName("manage_hotel_list_infor_name")[i];
				   const pic_url= document.getElementsByClassName("manage_hotel_list_infor_pic")[i];
				   const contents= document.getElementsByClassName("manage_hotel_list_infor_detail")[i];
				   const sethid = document.getElementById("hid"+i);
				   hotelname.innerHTML = respond[i].hotelname;
				   pic_url.style.backgroundImage='url("'+respond[i].pic_url +'")';
				   contents.innerHTML = respond[i].contents;
				   listarr[i]=document.getElementById('list_infor'+i+'"');
				   sethid.innerHTML=respond[i].hotel_id;
				   document.getElementsByClassName('delete_list')[i].onclick=function(){
					   if(document.getElementById('goedit'+i).getAttribute("checked")=="checked"){
						   document.getElementById('goedit'+i).removeAttribute("checked");
						   document.getElementById('goedit'+i).setAttribute("class","manage_hotel_list_infor");
						}
						else{
						   document.getElementById('goedit'+i).setAttribute("checked","checked");
						   document.getElementById('goedit'+i).setAttribute("class","manage_hotel_list_infor checked delete_member");
					   }
					};


				}
            }
		}); 


});