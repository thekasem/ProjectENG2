    var countAll;
	var page;
	var totalPage;

	jQuery(function() {
		hideAndShow(page, totalPage);
	});

	function hideAndShow(page, totalPage) {
		if (page == 0) {
			$(".firstpage").hide();
			$(".prevpage").hide();
			$(".nextpage").show();
			$(".lastpage").show();
		}
		if (page == totalPage) {
			$(".firstpage").show();
			$(".prevpage").show();
			$(".nextpage").hide();
			$(".lastpage").hide();
		}
	}
	
	function setparam(c , p , t){
		countAll = c;
		page = p;
		totalPage = t;
	}

	function next() {
		location.href = "activityArchive_list?page=" + (parseInt(page) + 1);
	}
	function lastPage() {
		location.href = "activityArchive_list?page=" + (parseInt(totalPage));
	}
	function previousPage(){
		location.href = "activityArchive_list?page=" + (parseInt(page) - 1);
	}