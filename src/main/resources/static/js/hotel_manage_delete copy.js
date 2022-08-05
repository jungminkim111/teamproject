let deleteChk= new Array();
const listarr = new Array();
const makelist=function(e){
	var i =document.createElement('li');
	i.innerHTML='<div class="manage_hotel_list_infor" id="list_infor'+e+'" for="checkbox_infor'+e+'" ><input type:"checkbox" class="delete_checkbox" id="checkbox_infor'+e+'">'
	+'	<div class="manage_hotel_list_infor_pic"></div>'
	+'	<div class="manage_hotel_list_infor_contents">'
	+'		<div class="manage_hotel_list_infor_name">'
	+'			<span class="manage_hotel_name"></span>'
	+'		</div>'
	+'		<div class="manage_hotel_list_infor_detail"></div>'
	+'	</div></div>';
	var addressContainer = document.getElementsByClassName("manage_hotel_ul")[0];

	listarr[e]=addressContainer.appendChild(i);
};

$(document).ready(function () {
	document.getElementById("delete_hotel").onclick=function(){
		if(deleteChk[0].checked||deleteChk[1].checked||deleteChk[2].checked){
		let conf = confirm("정말로 삭제하시겠습니까?");
		if(conf){
			$.ajax({
				url : '/hotel/manage/delete' ,
				data : {'str':'str2'},
				type : 'post',
				dataType : 'json',
				success : function(respond){
					 
					window.location.href="/hotel/manage/delete";
					}
				}); 
		
		}
		}
	};

	$.ajax({
		url : '/hotel/manage' ,
		data : {'str':'str2'},
		type : 'post',
		dataType : 'json',
		success : function(respond){
               for(let i=0;i<respond.length;i++){
				   makelist(i);
				   const hotelname= document.getElementsByClassName("manage_hotel_list_infor_name")[i];
				   const pic_url= document.getElementsByClassName("manage_hotel_list_infor_pic")[i];
				   const contents= document.getElementsByClassName("manage_hotel_list_infor_detail")[i];
				   const sethid = document.getElementsByClassName("goedit")[i];
				   hotelname.innerHTML = respond[i].hotelname;
				   pic_url.style.backgroundImage='url("'+respond[i].pic_url +'")';
				   contents.innerHTML = respond[i].contents;
				   listarr[i]=document.getElementById('list_infor'+i+'"');
				   edithref.setAttribute("hid","/hotel/manage/edit/"+respond[i].hotel_id);
				   document.getElementById('list_infor'+i).onclick=function(){
					   if(document.getElementById('checkbox_infor'+i).getAttribute("checked")=="checked"){
						   document.getElementById('checkbox_infor'+i).removeAttribute("checked");
						   document.getElementById('list_infor'+i).setAttribute("class","manage_hotel_list_infor");
						}
						else{
						   document.getElementById('checkbox_infor'+i).setAttribute("checked","checked");
						   document.getElementById('list_infor'+i).setAttribute("class","manage_hotel_list_infor checked");
					   }
					};
					deleteChk[i] = document.getElementById('checkbox_infor'+i);
				}
            }
		}); 


});