function register() {
    var formInfo = serializeForm("registerForm");
    $.ajax({
        url: "user/register.do",
        data: formInfo,
        type: "post",
        success:function(result){
        	alert(result);
        	alert(typeof(result));
			if(result.status=='S'){
				alert("s");
				alert(result.msg);
				//进入login.html页面
				window.location.href="jumppage.do?destPageName=login.html";
			}else{
				alert("f");
				alert(result.msg);
			}
		},
		error:function(result){
			alert("注册失败,错误原因："+result.msg);
		}
    });
}

function login(){
	var formInfo = serializeForm("loginForm");
	$.ajax({
		url: "user/login.do",
		data: formInfo,
		type: "post",
		success:function(result){
			if(result.status=='S'){
				var user = result.data;
				addCookie("userId", user.userId, 1);
				//进入index.html页面
				window.location.href="jumppage.do?destPageName=index.html&userId="+user.userId;
			}else{
				alert("登陆失败,错误原因："+result.msg);
			}
		},
		error:function(result){
			alert("登陆失败,错误原因："+result.status);
		}
	});
}

function logout(){
	deleteCookie("userId");
	window.location.href="jumppage.do?destPageName=login.html";
}