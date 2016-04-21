$(function (){
	$('.selectidcustomer').show(0);
	$('.selectidasset').hide(0);
});
$('#selectid').change(function (){
		var id = $('#selectid').val();
		if(id==1){
			$('.selectidcustomer').show(0);
			$('.selectidasset').hide(0);
		}
		if(id==2){
			$('.selectidcustomer').hide(0);
			$('.selectidasset').show(0);
		}
});