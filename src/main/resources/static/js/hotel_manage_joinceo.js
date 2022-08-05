let phonetmp;
let cert_num;
let cert_ok=false;
let business_reg_ok=false;


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
const makecertform=function(e){
	var i =document.createElement('div');
	i.innerHTML='<div> 인증번호를 입력해주세요 </div>'
	+'<input type="text" id="check_cert_number"><input type="button" value="재요청" class="ml10 cert_freeze"  onclick="retry();" /><input type="button" value="확인" class="ml10 cert_freeze" onclick="Checkcert();" />';

	var addressContainer = document.getElementById("check_cert_number_form");

	addressContainer.appendChild(i);
};

function CheckForm() {
	let txt1=document.getElementById("txtMobile1");
	let txt2=document.getElementById("txtMobile2");
	let txt3=document.getElementById("txtMobile3");
	if (txt1.value == ""||txt2.value.length != 4 ||txt2.value.length != 4) {
		window.alert("휴대폰 번호를 확인하세요.");
		return false;
	}
	if(!isCheckNum(txt2.value)){window.alert("숫자만 입력해주세요"); return false;}
	else if(!isCheckNum(txt3.value)){window.alert("숫자만 입력해주세요");return false;}
	
	const phone= (String)(txt1.value+txt2.value+txt3.value) ;
	phonetmp=phone;
	
	$.ajax({
		url : '/hotel/manage/phonecert' ,
		data : {'phone_number': phone},
		type : 'post',
		dataType : 'json',
		success : function(respond){
				cert_num=respond.randomNumber;
				alert("문자가 전송되었습니다. 잠시만 기다려주세요");
				document.getElementById("check_cert_number_form").innerHTML="";
				makecertform();
        }
	}); 
}
function retry(){
	$.ajax({
		url : '/hotel/manage/phonecert' ,
		data : {'phone_number': phonetmp},
		type : 'post',
		dataType : 'json',
		success : function(respond){
			cert_num=respond.randomNumber;
			alert("문자가 재전송 되었습니다.");
        }
	}); 
}
function Checkcert(){
	const ccn=document.getElementById('check_cert_number');
	if(ccn.value==cert_num){
		alert("인증이 완료되었습니다.");
		document.getElementById("txtMobile1").disabled=true;
		document.getElementById("txtMobile2").disabled=true;
		document.getElementById("txtMobile3").disabled=true;
		ccn.disabled=true;
		document.getElementsByClassName("cert_freeze")[0].disabled=true;
		document.getElementsByClassName("cert_freeze")[1].disabled=true;
		document.getElementsByClassName("cert_freeze")[2].disabled=true;
		cert_ok=true;
	}
	else{
		alert("인증번호가 일치하지 않습니다.");
	}
}


$(document).ready(function () {
	    
    var readURL = function(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.profile-pic').attr('src', e.target.result);
				var form = new FormData();
				form.append( "file1", input.files[0] );

				jQuery.ajax({
					url : "/hotel/manage/upload"
				  , type : "post"
				  , processData : false
				  , contentType : false
				  , data : form
				  , dataType : 'json'
				  , enctype :'multipart/form-data'	   
				  , success:function(response) {
					  document.querySelectorAll('.profile-pic')[0].setAttribute("id",response.path);
				  }
			  });
            }
    
            reader.readAsDataURL(input.files[0]);
        }
    }

	var readURLBR = function(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function (e) {
					var form = new FormData();
					form.append( "file1", input.files[0] );
					jQuery.ajax({
						url : "/hotel/manage/upload"
					  , type : "post"
					  , processData : false
					  , contentType : false
					  , data : form
					  , dataType : 'json'
					  , enctype :'multipart/form-data'	   
					  , success:function(response) {
						  document.querySelectorAll('.brid')[0].setAttribute("id",response.path);
					  }
				  });
				}
		
				reader.readAsDataURL(input.files[0]);
			}
	};

	document.getElementById("brup").onchange =function(){
		let x=(String)(document.getElementById("brup").value);
		const s = x.lastIndexOf("\\");
		const n = x.substring(s+1,x.length); 
		document.getElementById("brresult").innerHTML="파일명 : "+n;
		business_reg_ok=true;

	}

	$("#brup").on('change', function(){
		readURLBR(this);		
	});

    $(".file-upload").on('change', function(){
        readURL(this);
    });
    
    $(".upload-button").on('click', function() {
       $(".file-upload").click();
    });
	document.getElementById("manage_add_ceo").onclick=function(){
		 if(cert_ok&&business_reg_ok){
			const business_id=document.getElementById("business_id").innerHTML;
			const profile_picture=document.getElementsByClassName("profile-pic")[0].getAttribute("id");
			const profile_text=document.getElementById("self-introduce_text").value;
			const business_registration = document.getElementsByClassName('brid')[0].getAttribute("id");
				$.ajax({
					url : '/hotel/manage/joinceo' ,
					data : {'business_id':business_id
							,'profile_picture':profile_picture
							,'profile_text':profile_text
							,'business_registration':business_registration
						},
					type : 'post',
					dataType : 'json',
					success : function(respond){
						alert("사업자 등록이 완료되었습니다.");
						window.location.href="/hotel/manage";
						}
					}); 
		}
		else{
			alert("모든 항목을 입력해 주세요.");
		}
	};

			
});

