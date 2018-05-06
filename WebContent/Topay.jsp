<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet" /> 
    <link href="lib/bootstrap/css/custom-styles.css" rel="stylesheet" />
</head>

<body>


                <ul class="breadcrumb">
            <li><a href="index.html">主页</a> <span class="divider">/</span></li>
            <li class="active">账单</li>
               </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">

     
   
   
  <div class="btn-group">
  </div>
</div>


                <div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>客户编号</th>
          <th>房间号</th>
          <th>入住天数</th>                      
          <th>房间单价</th>
          <th>押金</th>
          <th>支付金额</th>
          <th>操作</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
      
       <tr>
        <td>${pay.getCno()}</td>
      	<td>${pay.getRno()}</td>	
		<td>${pay.getDays()}</td>
		<td>${pay.getUntilPrice()}</td> 
		<td>${pay.getMoney()}</td>
		<td>${pay.getPay()}</td> 
	
		
         <td>  
             <button type="button" class="btn btn-info" data-toggle="modal"  data-target="#addUserModal"  onclick="window.location='paid?roomid=${pay.getRno()}&clientid=${pay.getCno()} }'">确认支付</button>                      	
        </td>
       </tr>

     </tbody>
    </table>
   
 
</div>

       
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="lib/js/bootstrap.min.js"></script>

</body>

</html>





</body>
</html>