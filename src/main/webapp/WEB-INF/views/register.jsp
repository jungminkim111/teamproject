<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>register</title>

    <!-- CSS -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- JAVASCRIPT -->
<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/sweetalert.min.js"></script>
<script src="/js/chatbot.js"></script>

</head>
<body>
	<!-- header import -->
		<%@ include file="/WEB-INF/views/include/mypageheader.jsp"%>
	<!-- end of header import -->
	<hr>
	<section>
			<!-- Page content-->
	    <script type="text/javascript">
      $(document).ready(function () {
        $("#confirm").click(function () {
          //pw확인
          var userPw = $("#userPw").val();
          var userPwConfirm = $("#userPwConfirm").val();
          if ($("#userId").val() == "") {
            swal("아이디를 입력해주세요.", "", "error");
            $("#userId").focus();
            return false;
          }
          if ($("#userPw").val() == "") {
            swal("암호를 입력해주세요.", "", "error");
            $("#userPw").focus();
            return false;
          }
          if (userPw != userPwConfirm) {
            swal("암호가 일치하지 않습니다.", "", "error");
            $("#userPwConfirm").focus();
            return false;
          }
          if ($("#userName").val() == "") {
            swal("이름을 입력해주세요.", "", "error");
            $("#userName").focus();
            return false;
          } 
          if ($("#userEmail").val() == "") {
              swal("이메일을 입력해주세요.", "", "error");
              $("#userEmail").focus();
              return false;
          }

          userlist.push($("#userId").val());
          alert("회원가입되었습니다.");
          location.href = "/login";
        });
        
        
      });

      function idCheck() {
        //아이디 유효성 검사
        var idReg = /^[a-zA-Z]+[a-z0-9A-Z]{3,19}$/g;
        var idCk = false;

        if (!idReg.test($("#userId").val())) {
          swal("아이디 조건이 맞지 않습니다!", "영문과 숫자로 이루어진 4~12자를 입력해주세요", "warning");
          $("#id_result").html("ex) barogo1234");
		  $("#id_result").css("color", "red");
          return;
        }
        
        $("#checkId").on("click", function() {
			$.ajax({
				url: '<%=request.getContextPath() %>/checkId',
				data: {"userId" : $("#userId").val()},
				type: 'post',
				dataType: 'json',
				success: function(data) {
					if(data == 1) {
						swal("사용중인 아이디 입니다.", "", "error");
					} else if(data == 0 && idReg.test($("#userId").val())) {
						swal("사용가능한 아이디 입니다.", "", "success");
					}
				}
			});
		});
      }
      
      function check_pw(){
    	  
          var pw = document.getElementById('userPw').value;
          var SC = ["!","@","#","$","%"];
          var check_SC = 0;

          if(pw.length < 6 || pw.length>16){
        	  swal('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
              document.getElementById('userPw').value='';
          }
          for(var i=0;i<SC.length;i++){
              if(pw.indexOf(SC[i]) != -1){
                  check_SC = 1;
              }
          }
          if(check_SC == 0){
        	  swal('비밀번호는 6글자 이상, 16글자 이하 또는 !,@,#,$,% 의 특수문자가 들어가 있지 않습니다.')
              document.getElementById('userPw').value='';
          }
          if(document.getElementById('userPw').value !='' && document.getElementById('userPw2').value!=''){
              if(document.getElementById('userPw').value==document.getElementById('userPw2').value){
                  document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                  document.getElementById('check').style.color='blue';
              }
              else{
                  document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                  document.getElementById('check').style.color='red';
              }
          }
      }
      
      function email_Check() {
    	  var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    	  var userEmail = $('#userEmail').val();
    	  
    	  if(!emailReg.test($("#userEmail").val())) {
    		  // 0 : 이메일 길이 / 문자열 검사
    		  swal("이메일 조건이 맞지 않습니다", "메일형식에 맞게 입력해주세요.", "warning");
    		  $("#email_result").html("ex) barogo@barogo.com");
    		  $('#email_result').css('color', 'red');
    	  } else if(userEmail == null) {
    		  $('#email_result').html('이메일을 입력해주세요 :)');
    		  $('#email_result').css('color', 'red');
  			}
    	  
    	  $("#checkEmail").on("click", function() {
  			$.ajax({
  				url: '<%=request.getContextPath() %>/checkEmail',
  				data: {"userEmail" : $("#userEmail").val()},
  				type: 'post',
  				dataType: 'json',
  				success: function(data) {
  					if(data == 1) {
  						swal("사용중인 이메일 입니다.", "", "error");
  					} else if(data == 0 && emailReg.test($("#userEmail").val())) {
  						swal("사용가능한 이메일 입니다.", "", "success");
  					}
  				}
  			});
  		});
      }
    	  
    </script>			
			
			
   <div class="w3-content w3-container w3-margin-top" style="width: 70%; box-sizing: border-box;">
	<div class="w3-container w3-card-4">
		<div class="w3-center w3-large w3-margin-top">
			<h3>Member Join Form</h3>
		</div>
		<div>
			<form action="/register" method="post">
				<p>
					<label>ID</label> 
					<input class="w3-input" type="text" name="userId" id="userId" placeholder="영문과 숫자로 이루어진 4~12자를 입력해주세요"  required> 
					<button class="w3-button w3-tiny w3-round-xlarge w3-black" type="button" id="checkId" onclick="idCheck()"  style="float:right">중복확인</button>
					
					<span id="id_result"></span>
				</p>
				<p>
					<label>Password</label> 
					<input class="w3-input" type="password" name="userPw" id="userPw" onchange="check_pw()" placeholder="비밀번호는 6글자 이상, 16글자 이하와 특수문자를 입력해주세요" required>
					
             		 <span id="id_result"></span>
				</p>
				<p>
					<label>Confirm</label> 
					<input class="w3-input" type="password" name="userPw2" id="userPwConfirm" onchange="check_pw()" required>
				</p>
				<p>
					<label>Name</label> 
					<input class="w3-input" type="text" name="userName" id="userName" required>
				</p>
				<p>
					<label>Email</label>
					<input type="text" name="userEmail" id="userEmail" class="w3-input" placeholder="메일형식에 맞게 입력해주세요" required>
					<button class="w3-button w3-tiny w3-round-xlarge w3-black" type="button" id="checkEmail" onclick="email_Check()" style="float:right" >EmailCheck</button>
					<span id="email_result"></span>
				</p>
				<br>
				<p class="w3-center">
					<button type="submit" id="confirm" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">Join</button>
					<button type="button" onClick="location.href='/'" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">Cancel</button>				
				</p>
			</form>
		</div>
	</div>
</div>

</form>
</section>

	</section>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
</body>

</html>