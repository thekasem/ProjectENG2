$(function (){
	$('.analysisidcustomer').show(0);
	$('.analysisidasset').hide(0);
});
$('#analysisid').change(function (){
		var id = $('#analysisid').val();
		if(id==1){
			$('.analysisidcustomer').show(0);
			$('.analysisidasset').hide(0);
		}
		if(id==2){
			$('.analysisidcustomer').hide(0);
			$('.analysisidasset').show(0);
		}
});