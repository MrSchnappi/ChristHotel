<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>克里斯假日酒店</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <body class=""> 
 
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                </ul>
                <a class="brand" href="index.html"><span class="first">Chris Holiday</span> <span class="second">Hotel</span></a>
        </div>
    </div>  
    <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">欢迎登陆</p>
            <div class="block-body">
                <form  name="form1"   action="logincheck.jsp"  method="post" onsubmit="return logincheck()">
                    <label>员工号</label>
                    <input type="text" class="span12" id="id" required="">
                    <label>密码</label>
                    <input type="password" class="span12" id="password" required="">
                    <a href="index.html" class="btn btn-primary pull-right" onclick="login();return false;">登陆</a>
                    <label class="remember-me"><input type="checkbox">记住我</label>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        <p><a href="reset-password.html">Forgot your password?</a></p>
    </div>
</div> 
    

    <script type="text/javascript">
        function login() {
            //获得input框里面的值
            var id = $('#id').val();
            var password = $('#password').val();
            $.ajax({
                type : "post",
                url : "Ajax_Servlet",
                data : {
                    id : id,
                    password : password
                },
                success : function(data) {
                    //data为servlet返回的值
                    if (data == 'true') {
                        window.location.href="FindName?id="+id;
                    }
                    if (data == 'false') {
                        alert("密码或帐号错误，登录失败");
                    }
                },error:function(xhr){alert(xhr.responseText)}
            });
        }
    </script>

    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


