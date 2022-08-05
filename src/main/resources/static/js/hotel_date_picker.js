let startdate;
let enddate;


$('#start_date').datepicker({
    todayBtn: "linked",
    language: "ko",
	orientation: "bottom auto",
	autoclose: true,

});
$('#end_date').datepicker({
    todayBtn: "linked",
    language: "ko",
	orientation: "bottom auto",
	autoclose: true,

});
function startDate(e){
	moment(e).format("YYYY-MM-DD HH:mm:ss");
	const end_day=moment(document.getElementById("end_date").value).format("YYYY-MM-DD HH:mm:ss");
	$.ajax({
		url : '/hotel/gettoday' ,
		data : {
			'date':e,
			'endday':end_day},
		type : 'post',
		dataType : 'json',
		success : function(respond){
			document.getElementById("start_date").value=respond.date ;
			document.getElementById("end_date").value=respond.enddate ;

			let price=document.querySelector('input[name="ghost"]:checked').value; 
			startdate=document.getElementById("start_date").value;
			enddate=document.getElementById("end_date").value;
			const DateA= moment(startdate);
			const DateB= moment(enddate);
			document.getElementById("total_payment").innerText = ((DateB.diff(DateA,'days'))*price).toLocaleString() +"원";
        }
	});
};

function endDate(e){
	const day=moment(e).format("YYYY-MM-DD HH:mm:ss");
	const start_day=moment(document.getElementById("start_date").value).format("YYYY-MM-DD HH:mm:ss");
	$.ajax({
		url : '/hotel/gettomorrow' ,
		data : {
			'date': day,
			'startday':start_day},
		type : 'post',
		dataType : 'json',
		success : function(respond){
			document.getElementById("end_date").value=respond.date ;
			enddate=moment(respond.enddate).format("YYYY-MM-DD HH:mm:ss");

					let price=document.querySelector('input[name="ghost"]:checked').value; 
					startdate=document.getElementById("start_date").value;
					enddate=document.getElementById("end_date").value;
					const DateA= moment(startdate);
					const DateB= moment(enddate);
					document.getElementById("total_payment").innerText = ((DateB.diff(DateA,'days'))*price).toLocaleString() +"원";

			
		}
	});
};


$(document).ready(function () {


});