let agreeChk = document.querySelectorAll('input[name=agree]');
 const agreeChkAll = document.querySelector('input[name=agree_all]');
     agreeChkAll.addEventListener('change', (e) => {
     for(let i = 0; i < agreeChk.length; i++){
      agreeChk[i].checked = e.target.checked;
     }
 	});


$(document).ready(function () {

	document.getElementById("manage_add_hotel").onclick=function(){
		if(agreeChk[0].checked&&agreeChk[1].checked&&agreeChk[2].checked){
			window.location.href="/hotel/manage/joinceo"
		}
		else{
			alert("모든 필수 약관에 동의해주세요");
		}
	};
			
	$.ajax({
		url : '/hotel/manage' ,
		data : {'str':'str2'},
		type : 'post',
		dataType : 'json',
		success : function(respond){
				
        }
	}); 


});