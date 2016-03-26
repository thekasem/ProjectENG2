<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>paging</title>
<script src="calendar/jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
<script type="text/javascript">
	var countAll = "<s:property value="count" />";
	var page = "<s:property value="page" />";
	var totalPage = "<s:property value="totalPage" />";
	var url = location.href;
	jQuery(function() {
		hideAndShow(page, totalPage, countAll);
		url = url.substring((url.indexOf("/", 32) + 1), url.indexOf("_"));
	});

	function hideAndShow(page, totalPage, countAll) {
		if (page == 0) {
			$(".firstpage").hide();
			$(".prevpage").hide();
			$(".nextpage").show();
			$(".lastpage").show();
		}
		if (page == totalPage && totalPage > 1) {
			$(".firstpage").show();
			$(".prevpage").show();
			$(".nextpage").hide();
			$(".lastpage").hide();
		}
        if(totalPage == 1 ||totalPage == 0 || countAll == 0){
        	$(".firstpage").hide();
			$(".prevpage").hide();
			$(".nextpage").hide();
			$(".lastpage").hide();
        }
		
	}

	function next() {
		location.href = url + "_list?page=" + (parseInt(page) + 1);
	}
	function lastPage() {
		location.href = url + "_list?page=" + (parseInt(totalPage));
	}
	function previousPage() {
		location.href = url + "_list?page=" + (parseInt(page) - 1);
	}
	function first() {
		location.href = url + "_list?page=" + (parseInt(0));
	}
</script>
</head>
<body>
	<ul class="pager">
		<li class="firstpage" onclick="first()"><s:a href="">First Page</s:a></li>
		<li class="prevpage" onclick="previousPage()"><s:a href="">Previous</s:a></li>
		<s:if test="count.equals(0)">
			<h4 class="text-primary">
				<span class="fa fa-database"> NO Data </span>
			</h4>
		</s:if>
		<s:else>
			<Strong class="text-primary"><s:property value="page+1" />
				of <s:property value="totalPage+1" /></Strong>
		</s:else>
		<li class="nextpage" onclick="next()"><s:a href="">Next</s:a></li>
		<li class="lastpage" onclick="lastPage()"><s:a href="">Last Page</s:a></li>
	</ul>
	<style>
.nextpage:hover, .lastpage:hover, .prevpage:hover, .firstpage:hover {
	cursor: pointer;
}
</style>
</body>
</html>