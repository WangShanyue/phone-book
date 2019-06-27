//加载留言列表
getMovListRequest()

function getMovListRequest() {
    post('movie/Movie',[],function (result) {
        listHtml = ''
        for (var i = 0; i < 8; i++){
            listHtml += '<li class="list-group-item">'
            listHtml+='<div class="OneMovie">'
            listHtml+='<img src="/images/1.jpg"  alt="复仇者联盟3" width="150"/>'
            listHtml+='<span class="input-group-addon" id="msg_btn1" style="cursor: pointer">点赞</span>'
            listHtml+='</div>'
            listHtml += '</li>'
        }
        $('#movie_list').html(listHtml)
    })
}

$('#mov_btn1').on('click',function () {
    if (userId == -1){
        alert("Please log in")
        window.location.href="login.jsp"
    }else {
        var param = {'id':1}
        post('movie/updateMovies',param,function (result) {
            alert(result.desc)
            getMovListRequest()
        })
    }
})
$('#mov_btn2').on('click',function () {
    if (userId == -1){
        alert("Please log in")
        window.location.href="login.jsp"
    }else {
        var param = {'id':2}
        post('movie/updateMovies',param,function (result) {
            alert(result.desc)
            getMovListRequest()
        })
    }
})
$('#mov_btn3').on('click',function () {
    if (userId == -1){
        alert("Please log in")
        window.location.href="login.jsp"
    }else {
        var param = {'id':3}
        post('movie/updateMovies',param,function (result) {
            alert(result.desc)
            getMovListRequest()
        })
    }
})
$('#mov_btn4').on('click',function () {
    if (userId == -1){
        alert("Please log in")
        window.location.href="login.jsp"
    }else {
        var param = {'id':4}
        post('movie/updateMovies',param,function (result) {
            alert(result.desc)
            getMovListRequest()
        })
    }
})
$('#mov_btn5').on('click',function () {
    if (userId == -1){
        alert("Please log in")
        window.location.href="login.jsp"
    }else {
        var param = {'id':5}
        post('movie/updateMovies',param,function (result) {
            alert(result.desc)
            getMovListRequest()
        })
    }
})
$('#mov_btn6').on('click',function () {
    if (userId == -1){
        alert("Please log in")
        window.location.href="login.jsp"
    }else {
        var param = {'id':6}
        post('movie/updateMovies',param,function (result) {
            alert(result.desc)
            getMovListRequest()
        })
    }
})
$('#mov_btn7').on('click',function () {
    if (userId == -1){
        alert("Please log in")
        window.location.href="login.jsp"
    }else {
        var param = {'id':7}
        post('movie/updateMovies',param,function (result) {
            alert(result.desc)
            getMovListRequest()
        })
    }
})
$('#mov_btn8').on('click',function () {
    if (userId == -1){
        alert("Please log in")
        window.location.href="login.jsp"
    }else {
        var param = {'id':8}
        post('movie/updateMovies',param,function (result) {
            alert(result.desc)
            getMovListRequest()
        })
    }
})