$(document).ready(function(){
	var curPage = document.getElementById("curPage");
	var page = "a#"+parseInt(curPage.value);
	$(page).css("background-color","#0088cc");
	$(page).css("color","white");
	$("#query").on("click",function(){
		curPage.value=1;
	});
});
function firstPage(){
	var curPage = document.getElementById("curPage");
	curPage.value=1;
	document.hideInfo.submit();
}
function proPage(){
	var curPage = document.getElementById("curPage");
	if(parseInt(curPage.value)!=1){
		curPage.value = parseInt(curPage.value) - 1;
	}
	document.hideInfo.submit();
}
function nPage(n){
	curPage.value = n;
	document.hideInfo.submit();
}
function nextPage(total){
	var curPage = document.getElementById("curPage");
	if(parseInt(curPage.value)!=total){
		curPage.value = parseInt(curPage.value) + 1;
	}
	document.hideInfo.submit();
}
function lastPage(total){
	var curPage = document.getElementById("curPage");
	curPage.value=total;
	document.hideInfo.submit();
}