$(document).ready(function(){ 
	$("#iamportPayment").click(function(){ 
		
		 var name = document.getElementById('proname').value;
		 var amount = document.getElementById('amount').value;
		 var buyer_email = document.getElementById('buyer_email').value;
		 var buyer_name = document.getElementById('buyer_name').value;
		 var buyer_tel = document.getElementById('buyer_tel').value;
		 var buyer_addr = document.getElementById('buyer_addr').value;
		 var buyer_postcode = document.getElementById('buyer_postcode').value;
    	payment(); //버튼 클릭하면 호출 
    }); 
})

function payment(data) {
	
	
IMP.init('imp27550428');

IMP.request_pay({
    pg : 'inicis', // version 1.1.0부터 지원.
    pay_method : 'card',
    merchant_uid : 'merchant_' + new Date().getTime(),
    name : document.getElementById('proname').value,
    amount : document.getElementById('amount').value,
    buyer_email : document.getElementById('buyer_email').value,
    buyer_name : document.getElementById('buyer_name').value,
    buyer_tel : document.getElementById('buyer_tel').value,
    buyer_addr : document.getElementById('buyer_addr').value,
    buyer_postcode : document.getElementById('buyer_postcode').value,
}, function(rsp) {
    if ( rsp.success ) {
        var msg = '결제가 완료되었습니다.';
        msg += '고유ID : ' + rsp.imp_uid;
        msg += '상점 거래ID : ' + rsp.merchant_uid;
        msg += '결제 금액 : ' + rsp.paid_amount;
        msg += '카드 승인번호 : ' + rsp.apply_num;
    } else {
        var msg = '결제에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;
    }
    alert(msg);
    document.getElementById('payform').submit();
    location.href="/";
});
}