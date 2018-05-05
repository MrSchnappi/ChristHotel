<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>酒店后台管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">  
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
   <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>   
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
    <!-- Le fav and touch icons -->
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
                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i><%=request.getAttribute("workername")%>
                            <i class="icon-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">My Account</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="sign-in.html">Logout</a></li>
                        </ul>
                    </li>            
                </ul>
                <a class="brand" href="index.jsp"><span class="first">Chris Holiday</span> <span class="second">Hotel</span></a>
        </div>
    </div>   
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>客房管理</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="FindName?id=<%=request.getAttribute("id") %>">主页</a></li>
            <li ><a href="users.html"  target="rightWindow">客房信息</a></li>
            <li ><a href="user.html"  target="rightWindow">预定房间</a></li>
            <li ><a href="media.html"  target="rightWindow">退订房间</a></li>
            <!--<li ><a href="calendar.html"></a></li>-->         
        </ul>
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>客户管理<span class="label label-info">+3</span></a>
        <ul id="accounts-menu" class="nav nav-list collapse in">
            <li ><a href="ClientInfo" target="rightWindow" >客户信息</a></li>
            <li ><a href="user.jsp" target="rightWindow" >客户登记</a></li>
            <li ><a href="FindClient.jsp" target = "rightWindow">客户信息查找</a></li>
            
       </ul>
          <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>入住管理<span class="label label-info">+3</span></a>
       	 	<ul id="accounts-menu" class="nav nav-list collapse in">
            <li ><a href="CheckInInfo" target="rightWindow" >入住信息</a></li>
            <li ><a href="Checkin.jsp" target="rightWindow" >客人入住</a></li>
            <li ><a href="leave.jsp" target = "rightWindow">客户退房</a></li>
            <li ><a href="FindCheckInfo.jsp" target = "rightWindow">入住信息查找</a></li>           
        </ul>
       
       
       
       
        <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-legal"></i>Legal</a>
        <a href="help.html" class="nav-header" ><i class="icon-question-sign"></i>Help</a>
        <a href="faq.html" class="nav-header" ><i class="icon-comment"></i>Faq</a>
    </div>   
    <div class="content">
        
        <div class="header">
            <div class="stats">
    <p class="stat"><span class="number">53</span>tickets</p>
    <p class="stat"><span class="number">27</span>tasks</p>
    <p class="stat"><span class="number">15</span>waiting</p>
</div>

            <h1 class="page-title">克里斯假日酒店欢迎您</h1>
        </div>
<div>
<iframe width=1300 height=800 name="rightWindow" src="BigInfo" >
</iframe>
  
</div>

 
                  

    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


