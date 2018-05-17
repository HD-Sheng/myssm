/**
 * 注册
 */
function register() {
	var username = $("#username").val();
	var password = $("#password").val();
	var password2 = $("#password2").val();
	if(!username || !password || !password2){
		alert("请校验录入项");
		return;
	}
	if(password != password2){
		alert("密码与确认密码不一致！");
		return;
	}
    var formInfo = serializeForm("registerForm");
    $.ajax({
        url: "user/register.do",
        data: formInfo,
        type: "post",
        success:function(result){
			if(result.status=='S'){
				alert(result.msg);
				//进入login.html页面
				window.location.href="jumppage.do?destPageName=login.html";
			}else{
				alert(result.msg);
			}
		},
		error:function(result){
			alert("注册失败,错误原因："+result.msg);
		}
    });
}

/**
 * 登陆
 */
function login(){
	var username = $("#username").val();
	var password = $("#password").val();
	if(!username || !password){
		alert("请校验录入项");
		return;
	}
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

/**
 * 退出
 */
function logout(){
	deleteCookie("userId");
	$("#toLogin").show();
	$("#toRegister").show();
	$("#userinfo").hide();
}