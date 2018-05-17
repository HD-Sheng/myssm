function getParam(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var url = window.location.search.substring(1, window.location.search.length);
	var val = url.match(reg);
	alert("reg========="+reg);//      /(^|&)username=([^&]*)(&|$)/
	alert("url========="+url);
	alert("val========="+val);
	return val;
};