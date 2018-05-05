<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>  
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">  
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script type="text/javascript" src="dist/js/bootstrapValidator.js"></script>
    <link rel="stylesheet" type="text/css" href="dist/css/bootstrapValidator.css">
    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
    
      <script>
  			function SerId(){
  				alert("精确查找");
  				var text =  $("#text").val();
  				//alert(text);
  			if(!text.match(/^\d.*$/))
  			alert("请输入数字后提交");		
				
  			else if(text!="")   
  					window.location.href="FindClient?type=NO&text="+text;
  			else
  					alert("输入为空！请输入后提交")
  			}
			
  			function Serinfo()
  			{
  				alert("模糊查找");
  				var text =  $("#text").val();
  				alert(text);
  				if(text!="")  
  					{
  					var searchUrl =encodeURI("FindClient?type=DIZ&text="+encodeURI(text));
  					window.location.href=searchUrl;
  					}
  				else
  					alert("输入为空！，请输入后提交")
  			}
  </script>
    
    
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
       
            <ul class="breadcrumb">
            <li><a href="index.html">主页</a> <span class="divider">/</span></li>
            <li class="active">客户信息查找</li>
            </ul>

       <div class="container-fluid">
            <div class="row-fluid">                   
				<div class="btn-toolbar">	
				   <div class="col-lg-5">
				             <table>
				             <tr>
				               <td>
				               		  <input  type="text"   width="1005" style="width: 400px;"  class="form-control" name="text" id="text" maxlength=20/>
				               </td>
				               <td>
				                        <button class="btn"  style="float:left;margin-left:20px;" onclick="SerId()">编号查找</button>                          
				               </td>
				               
				               <td>
				                        <button class="btn"  style="float:left;margin-left:20px;"onclick="Serinfo()">模糊查找</button>   
				               </td>
				             </tr>
				             
				             
				             </table>                              
                                 
                   </div>			
	 				
	 				
  					
				</div>


				<div class="well">
    				<table class="table">
      					<thead>
        				<tr>
          					<th>编号</th>
          					<th>身份证号</th>
          					<th>客户姓名</th>
          					<th>客户电话</th>
          					<th>客户类型</th>
          					<th>备注</th>
          					<th>操作</th>
          					<th style="width: 26px;"></th>
        				</tr>
      				</thead>
     				<tbody>
       					<c:forEach items="${Clients}" var="client">
       					<tr>
        					<td>${client.clientid}</td>
      						<td>${client.clientno}</td>
							<td>${client.clientname}</td>
							<td>${client.clientphone}</td>
							<td>${client.clienttype}</td> 
							<td>${client.clientinfo}</td> 
       					    <td>      
             				<a href="updateClient?id=${client.clientid}" ><i class="icon-pencil"></i></a>              
        					</td>
       					</tr>
     				 </c:forEach>
     				</tbody>
    				</table>
   
  			<div class="pagination" > 
				${pagination.pageBar}
				${pagination.numPageBar}   
			</div>
		</div>

        
                   <footer>
                        <hr>                        
                        <p class="pull-right">Collect from <a href="#" title="SuperTechnology" target="_blank">SuperTechnology</a></p>
                        <p>&copy; 2018 <a href="#" target="_blank">超凡科技网络公司</a></p>
                    </footer>                        
            </div>
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


