/* cookie操作函数：新增指定时间的cookie */
function addCookie(cname,cvalue,chours){
	var str = cname + "=" + escape(cvalue);
	if(!chours || chours <= 0){
		chours = 24;
	}
	var date = new Date();
	date.setTime(date.getTime() + chours*60*60*1000);
	str += ";expires=" + date.toUTCString();
	document.cookie = str;
}

/* cookie操作函数：删除cookie */
function deleteCookie(cname){
	var date = new Date();
	date.setTime(date.getTime() - 1);
	document.cookie = cname + "=" + escape(getCookie(cname)) + ";expires=" + date.toUTCString();
}

/* cookie操作函数：获取cookie */
function getCookie(cname){
	var arrCookie = document.cookie.replace(" ", "").split(";");
	for(var i = 0; i < arrCookie.length; i++){
		var temp = arrCookie[i].split("=");
		if(temp[0] == cname){
			return unescape(temp[1]);
		}
	}
	return "";
}