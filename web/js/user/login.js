function go_to_login() {
    window.location.href = "login.jsp"
}

$("#reg_btn").on('click',function () {
    var username = $('#username').val()
    var password = $('#password').val()
    var param = {'name':username,'password':password}
    post('user/register',param,function (result) {
        if (result.code == '200'){
            alert(result.desc)
            window.location.href = "login.jsp"
        }else {
            alert(result.desc)
            window.location.href = "register.jsp"
        }
    })
})
// 获取cookie中相应字段的值
var username = getCookie('demo_username')
var password = getCookie('demo_password')
var flag = getCookie('demo_flag')
$("#username").val(username!=null?username:'')
$("#password").val(password!=null?password:'')
if (flag != null){
    $("#remb").attr('checked','checked')
}

// 前往注册界面
function go_to_register() {
    window.location.href = "register.jsp"
}

//点击登录按钮效果(登录按钮的id为`loginBtn`)
$("#loginBtn").on('click',function () {
    //按照通过input的id获取填写的值
    var username = $('#username').val()
    var password = $('#password').val()
    var param = {'name':username, 'password':password}
    post("user/login",param,function (result) {
        if (result.code == "200"){
            // 判断是否记住密码
            var flag = $('#remb').is(':checked')
            if (flag == true){
                //如果记住密码，则将值设置到cookie中去
                setCookie('demo_username',username)
                setCookie('demo_password',password)
                setCookie('demo_flag',flag)
            }else {
                // 如果忘记，则使相应的cookie值失效
                delCookie('demo_username')
                delCookie('demo_password')
                delCookie('demo_flag')
            }
            window.location.href = "index.jsp"
        }else if (result.code == "400"){
            alert(result.desc)
            window.location.href = "login.jsp"
        }else {
            //TODO:处理其他结果
        }
    });
})

//设置cookie
function setCookie(name,value) {
    var Days = 7
    var exp = new Date()
    exp.setTime(exp.getTime() + Days*24*60*60*1000)
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()
}
// 获取cookie
function getCookie(name) {
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg)){
        return unescape(arr[2])
    } else{
        return null
    }
}
//删除cookies
function delCookie(name) {
    var exp = new Date()
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name)
    if(cval!=null){
        document.cookie= name + "="+cval+";expires="+exp.toGMTString()
    }
}