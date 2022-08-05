let phonetmp;
let cert_num;
let cert_ok=false;
let business_reg_ok=false;
function isCheckNum(str){
	var checkReg=/^[0-9]{3,4}$/;
	return checkReg.test(str);
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
				alert(cert_num);
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
			alert(cert_num);
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
            }
    
            reader.readAsDataURL(input.files[0]);
        }
    }
	document.getElementById("brup").onchange =function(){
		let x=(String)(document.getElementById("brup").value);
		const s = x.lastIndexOf("\\");
		const n = x.substring(s+1,x.length); 
		document.getElementById("brresult").innerHTML="파일명 : "+n;
		business_reg_ok=true;

	}

    $(".file-upload").on('change', function(){
        readURL(this);
    });
    
    $(".upload-button").on('click', function() {
       $(".file-upload").click();
    });
	document.getElementById("manage_add_ceo").onclick=function(){
		if(cert_ok&&business_reg_ok){
			alert("등록이 완료되었습니다.");
			window.location.href="/hotel/manage";
		}
		else{
			alert("모든 항목을 입력해 주세요.");
		}
	};

			
});