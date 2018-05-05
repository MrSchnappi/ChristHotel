<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">  
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
   <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>  
   <script src="lib/bootstrap/js/bootstrap.js"></script>

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
<body>
        <div class="container-fluid">
            <div class="row-fluid">
                    

<div class="row-fluid">

    <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>温馨提示:</strong> 欢迎使用克里斯假日酒店管理系统!
    </div>

    <div class="block">
        <a href="#page-stats" class="block-heading" data-toggle="collapse">最新动态</a>
        <div id="page-stats" class="block-body collapse in">

            <div class="stat-widget-container">
                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title"><%=request.getAttribute("CheckInPeo")%></p>
                        <p class="detail">入住人数</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title"><%=request.getAttribute("SpareRoom")%></p>
                        <p class="detail">剩余空闲房间</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title"><%=request.getAttribute("TocleanRoom")%></p>
                        <p class="detail">待打扫房间</p>
                    </div>
                </div>

               
            </div>
        </div>
    </div>
</div>

<div>
<div class="row-fluid">
    <div class="block span6">
        <a href="#tablewidget" class="block-heading" data-toggle="collapse">客户信息<span class="label label-warning">+10</span></a>
        <div id="tablewidget" class="block-body collapse in">
            <table class="table">
              <thead>
                <tr>
                  <th>客户编号</th>
                  <th>客户姓名</th>
                  <th>联系方式</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${clients}" var="client">
                                        <tr>
                                            <td>${client.getClientid()}</td>
                                            <td>${client.clientname}</td>
                                            <td>${client.clientphone}</td>
                                         </tr>                                         
              </c:forEach>
              </tbody>
            </table>
            <p><a href="users.html">更多...</a></p>
        </div>
    </div>
    <div class="block span6">
        <a href="#widget1container" class="block-heading" data-toggle="collapse">企业文化 </a>
        <div id="widget1container" class="block-body collapse in">
            <h2>公司简介</h2>
           
            <p> 最有魅力的企业</p>
            
        </div>
    </div>
</div>

<div class="row-fluid">
    <div class="block span6">
        <div class="block-heading">
            <span class="block-icon pull-right">
                <a href="#" class="demo-cancel-click" rel="tooltip" title="Click to refresh"><i class="icon-refresh"></i></a>
            </span>

            <a href="#widget2container" data-toggle="collapse">入住记录</a>
        </div>
        
        
        <div id="widget2container" class="block-body collapse in">
            <table class="table list">
            <thead>
                <tr>
                  <th>客户编号</th>
                  <th>客户姓名</th>
                  <th>入住房间</th>
                </tr>
              </thead>
              <tbody>
                   <c:forEach items="${orders}" var="order">
                                        <tr>
                                            <td>${order.checkin_clientid}</td>
                                            <td>${order.clientname}</td>
                                            <td>${order.checkin_roomid}</td>
                                         </tr>                                         
              </c:forEach>
              </tbody>
            </table>
            <p><a href="users.html">更多...</a></p>
        </div>
    </div>
    
    
    
    <div class="block span6">
        <p class="block-heading">公告</p>
        <div class="block-body">
            <h2>Information</h2>
            <p>探索永无止境</p>
            <p>这里用来管理员 发布一些信息</p>
            <p><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
        </div>
    </div>
</div>          
                   
                   
                   
                   
                   
                  
                    
            </div>
        </div>
    </div>
    
</body>
</html>