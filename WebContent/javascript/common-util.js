//获取url中的参数

function getParam(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var url = window.location.search.substring(1, window.location.search.length);
	var val = url.match(reg);
	return val;
};