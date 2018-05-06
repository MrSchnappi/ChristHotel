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


 
 <script>
 function edit_info(clientid,roomid)
 {
	$('#clientno').val(clientid);
	$('#roomno').val(roomid);
 }
 function del_info(clientid,roomid)
 {
	$('#delclientno').val(clientid);
	$('#delroomno').val(roomid);
 }  
 function delsubmit()
 {
	
     var clientnu = $('#delclientno').val();
     var  roomnu  = $('#delroomno').val();
     alert(clientnu+"  "+roomnu);
     window.location.href="deletecheckinfo?clientnu="+clientnu+"&roomnu="+roomnu;
     
 }
 
 
   // 提交表单
    function check_form()
    {
     
           var form_data = $('#days').val();
           var clientnu = $('#clientno').val();
           var  roomnu  = $('#roomno').val();
           alert(clientnu+"  "+roomnu); 
           
        
        // 异步提交数据到action/add_action.php页面
        $.ajax(
                {
                    url: "updateTime",
                    data:{"form_data":form_data,"clientnu":clientnu,"roomnu":roomnu},
                    type: "post",
                    beforeSend:function()
                    {
                        $("#tip").html("<span style='color:blue'>正在处理...</span>");
                        return true;
                    },
                    success:function(data)
                    {
                        if(data=="OK")
                        {

                            var msg = "添加";
                 
                            $("#tip").html("<span style='color:blueviolet'>恭喜，" +msg+ "成功！</span>");
                            // document.location.href='system_notice.php'
                            alert(msg + "OK！");
                            location.reload();
                        }
                        else
                        {
                            $("#tip").html("<span style='color:red'>失败，请重试</span>");
                            alert(data);
                        }
                    },
                    error:function()
                    {
                        alert('请求出错');
                    },
                    
                });

        return false;
    }


    $(function () { $('#addUserModal').on('hide.bs.modal', function () {
        // 关闭时清空edit状态为add
        $("#act").val("add");
        location.reload();
    })
    });
    
</script>
    
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
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>
  
  <body class=""> 
       
                <ul class="breadcrumb">
            <li><a href="index.html">主页</a> <span class="divider">/</span></li>
            <li class="active">入住信息</li>
               </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">

     
   
    <button class="btn" onclick="location='FindClient.jsp'">信息查找</button>
  <div class="btn-group">
  </div>
</div>


<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>客户编号</th>
          <th>客户姓名</th>
          <th>入住房间</th>                      
          <th>押金</th>
          <th>入住时间</th>
          <th>退房时间</th>
          <th>备注</th>
          <th>退房</th>
          <th>操作</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
       <c:forEach items="${CheckInfos}" var="checkin">
       <tr>
        <td>${checkin.checkin_clientid}</td>
      	<td>${checkin.clientname}</td>	
		<td>${checkin.checkin_roomid}</td>
		<td>${checkin.checkinmoney}</td> 
		<td>${checkin.checkintime}</td>
		<td>${checkin.departuretime}</td> 
		<td>${checkin.checkininfo}</td>
		<td>
		
		<!--  	<a href="#" onclick="confirm()"><i class="icon-remove">退房</i></a>-->
		 <a href="#myModal" role="button" data-toggle="modal"  onclick="return del_info(${checkin.checkin_clientid},${checkin.checkin_roomid})"><i class="icon-remove"></i></a>
          <!-- 编辑客户信息 -->
           <!--   <a href="updateClient?id=${client.clientid}" ><i class="icon-pencil"></i></a> -->
         </td>
         <td>  
             <button type="button" class="btn btn-info" data-toggle="modal"  data-target="#addUserModal"  onclick="return edit_info(${checkin.checkin_clientid},${checkin.checkin_roomid})">续住</button>                      	
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

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">温馨提示</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>你确定要删除这条信息么?</p>
    </div>
    <div class="modal-footer">
    <input type="hidden" name="delclientno" id="delclientno">
    <input type="hidden" name="delroomno" id="delroomno">
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
        <button class="btn btn-danger" data-dismiss="modal" onclick="delsubmit()">确定删除</button>
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
  
 
  
      <!-- 模态框示例（Modal） -->  
   <form method="post" action=""  role="form"  id="form_data" onsubmit="return check_form()" style="margin: 20px;">
    <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        续住
                    </h4>
                </div>
                <div class="modal-body">                
                 <form class="form-horizontal"  role="form">                      
                            <div class="form-group">
                                <label >续住天数</label>
                                <div class="col-lg-5">
                                	<input type="hidden" name="clientno" id="clientno">
                                	<input type="hidden" name="roomno" id="roomno">
                                    <input type="text" class="form-control"  onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入数字" name="days" id="days" required="required"/>                                   
                                </div>
                            </div>                                                                                  
                    </form>  
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                                              关闭
                    </button>
                    <button type="submit" class="btn btn-primary">
                                              提交
                    </button><span id="tip"> </span>
               </div>    
         </div>
       </div>
     </div>
   </form>          
  </body>
</html>


