//var time = $('#selecttime').val();

$(function (){
	$('.selectfromyear').hide(0);
	$('.selectfrommonth').hide(0);
});
$('#selecttime').change(function() {
	var time = $('#selecttime').val();
	if(time==1){
		$('.selectfromyear').hide(0);
		$('.selectfrommonth').hide(0);
	}
	if(time==2){
		$('.selectfromyear').show(0);
		$('.selectfrommonth').hide(0);
	}
	if(time==3){
		$('.selectfromyear').hide(0);
		$('.selectfrommonth').show(0);
	}
});