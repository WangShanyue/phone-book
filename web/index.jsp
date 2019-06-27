<%@ page import="f.classdesign.entity.UserEntity" %>
<%@ page import="f.classdesign.entity.MovieEntity" %><%--
  Created by IntelliJ IDEA.
  User: VULCAN
  Date: 2018/4/20
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>留言板</title>
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
<style>
  body{
    background-color: #f9f9f9;
  }
  .top{
    height: 60px;
    background-color: #d0e9c6;
    margin-bottom: 40px;
  }
  .top > div{
    display: flex;
    align-items: center;
    height: 60px;
  }
  .top-text{
    color: #65508f;
    font-size: 18px;
  }
  .scroll{
    width: 100%;
    height: 350px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #FFFFFF;
    border-radius: 4px;
    overflow-y: scroll;
    float:right;
  }
  .comment{
      width: 40%;
      height: 450px;
      margin: 0 auto;
      padding: 20px;
      border: 0px solid #FFFFFF;
      border-radius: 4px;
      float:right;
  }
  .btn{
    color: #65508f;
    border: none;
  }
  .list-group{
    width: 100%;
    margin: 0 auto;
    padding-bottom: 20px;
  }
  .input-group{
    width: 100%;
    margin: 0 auto;
    float:right;
  }
   .movies{
       width: 50%;
       height: 480px;
       margin-left: 75px ;
       padding: 20px;
       border: 1px solid #FFFFFF;
       border-radius: 4px;
       float:left
   }
    .OneMovie
    {
        width: 100%;
        margin: 0 auto;
        padding: 15px;
        border: 0px solid #1dd;
        border-radius: 4px;

    }
</style>
</head>
<%
  UserEntity user = (UserEntity) session.getAttribute("user");
  String username = "未登录";
  Integer userId = -1;
  if (user != null){
      username = user.getName();
      userId = user.getId();
  }
%>
<%--<%--%>
    <%--MovieEntity movie = (MovieEntity) session.getAttribute("user");--%>
    <%--String username = "未登录";--%>
    <%--Integer userId = -1;--%>
    <%--if (user != null){--%>
        <%--username = user.getName();--%>
        <%--userId = user.getId();--%>
    <%--}--%>
<%--%>--%>
<body style="background: url(/images/bg4.jpg); background-size:cover">
<div>
  <div class="top row">
    <div class="col-md-1"></div>
    <div class="col-md-9 top-text">电影交流区</div>
    <div class="col-md-2 row">
      <div class="col-md-6 top-text" id="username">Username</div>
      <div class="col-md-6">
        <button type="button" class="btn btn-default" id="log">Logout</button>
      </div>
    </div>
  </div>
    <div>
        <div class="comment">
            <div class="col-md-9 top-text">评论区</div>
            <div class="scroll">
                <ul class="list-group" id="msg_list"></ul>
            </div>
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Content" id="msg_con">
                <span class="input-group-addon" id="msg_btn" style="cursor: pointer">提交</span>
            </div>
        </div>
        <div class="movies">
            <table>
                <tr>
                    <td>
                        <div class="OneMovie">
                            <img src="/images/1.jpg"  alt="复仇者联盟3" width="130" height="175"/>
                            <button class="input-group-addon" id="mov_btn1" style="cursor: pointer">点赞</button>

                        </div>
                    </td>
                    <td>
                        <div class="OneMovie">
                            <img src="/images/2.jpg"  alt="复仇者联盟3" width="130" height="175"/>
                            <button class="input-group-addon" id="mov_btn2" style="cursor: pointer">点赞</button>
                        </div>
                    </td>
                    <td>
                        <div class="OneMovie">
                            <img src="/images/3.jpg"  alt="复仇者联盟3" width="130" height="175"/>
                            <button class="input-group-addon" id="mov_btn3" style="cursor: pointer">点赞</button>
                        </div>
                    </td>
                    <td>
                        <div class="OneMovie">
                            <img src="/images/4.jpg"  alt="复仇者联盟3" width="130" height="175"/>
                            <button class="input-group-addon" id="mov_btn4" style="cursor: pointer">点赞</button>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="OneMovie">
                            <img src="/images/5.jpg"  alt="复仇者联盟3" width="130" height="175"/>
                            <button class="input-group-addon" id="mov_btn5" style="cursor: pointer">点赞</button>
                        </div>
                    </td>

                    <td>
                        <div class="OneMovie">
                            <img src="/images/6.jpg"  alt="复仇者联盟3" width="130" height="175"/>
                            <button class="input-group-addon" id="mov_btn6" style="cursor: pointer">点赞</button>
                        </div>
                    </td>
                    <td>
                        <div class="OneMovie">
                            <img src="/images/7.jpg"  alt="复仇者联盟3" width="130" height="175"/>
                            <button class="input-group-addon" id="mov_btn7" style="cursor: pointer">点赞</button>
                        </div>
                    </td>
                    <td>
                        <div class="OneMovie">
                            <img src="/images/8.jpg"  alt="复仇者联盟3" width="130" height="175"/>
                            <button type="button" class="input-group-addon " id="mov_btn8" style="cursor: pointer">点赞</button>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>


</div>
<script src="js/jquery/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/common/ajaxfunc.js"></script>
<script>
  var username = '<%=username%>'
  var userId = <%=userId%>
      var movId=
  $("#username").text(username)
  $("#log").text(userId==-1?'Login':'Logout')
</script>

<script src="js/message/message.js"></script>
<script src="js/movies/like_it.js"></script>
</body>
</html>
