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
    <link rel="stylesheet" type="text/css" href="dist/css/bootstrapValidator.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>  
    
    <script type="text/javascript" src="dist/js/bootstrapValidator.js"></script>

    
 <!--    <script src="js/jquery.validate.min.js" type="text/javascript"></script>
   <script src="js/jquery_data_validate.js" type="text/javascript"></script>-->
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
   

<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">信息</a></li>
     <!--  <li><a href="#profile" data-toggle="tab">Password</a></li>--> 
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
      
       <form id="tab" method="post" action="UpdateClientData" >
                        <fieldset>
                            <div class="form-group">
                                <label >客户编号</label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" name="ClientNo" id="ClientNo" value="${Client.clientid}" readonly="true" />
                                   
                                </div>
                            </div>                         
                            <div id="message"></div>							
                            <div class="form-group">
                                <label class="col-lg-3 control-label">身份证号</label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" name="IdCard" value="${Client.clientno}" />
                                </div>
                            </div>
                        </fieldset>
                        <fieldset>  
                            <div class="form-group">
                                <label class="col-lg-3 control-label">客户姓名</label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" name="Name"  value="${Client.clientname}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-3 control-label">联系方式</label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" name="phoneNumber" value="${Client.clientphone}"  />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-3 control-label">客户类型</label>
                               <select name="ClientType" id="ClientType" class="input-xlarge" value="${Client.clienttype}">
                               <c:if test="${Client.clienttype=='member'}">
                                    <option value="member" name="Remember"   selected = "selected" >普通用户</option>
                                     <option value="VIP" name="VIP"  >会员</option>
                                     <option value="SVIP"  name="SVIP"  >高级会员</option>
                               </c:if>
                               
                               <c:if test="${Client.clienttype=='VIP'}">
                               <option value="member" name="Remember"   >普通用户</option>
                                    <option value="VIP" name="VIP"  selected = "selected">会员</option>
                                     <option value="SVIP"  name="SVIP"  >高级会员</option>
                               </c:if>
                               
                               <c:if test="${Client.clienttype=='SVIP'}">
                               <option value="member" name="Remember"   >普通用户</option>
                                    <option value="VIP" name="VIP" >会员</option>
                                   <option value="SVIP"  name="SVIP"  selected = "selected">高级会员</option>
                               </c:if>
                               </select>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-3 control-label">备注</label>
                                <textarea name="ClientInfo" rows="3" class="input-xlarge">
                                   
                                      ${Client.clientinfo}
                                  
                                </textarea>
                            </div>
                        </fieldset>


                      
                        <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="submit" class="btn btn-primary">保存</button>
                            </div>
                        </div>
                    </form>
                </div>
            </section>             
                    <footer>
                        <hr>                        
                        <p class="pull-right">Collect from <a href="#" title="SuperTechnology" target="_blank">SuperTechnology</a></p>
                        <p>&copy; 2018 <a href="#" target="_blank">超凡科技网络公司</a></p>
                    </footer>                          
            </div>
        </div>
    </div>
    


 <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
 <script type="text/javascript">
   $(function(){
	   $("#ClientNo").change(function(){
		 
		   var NO=$(this).val();
		   NO = $.trim(NO);
		   if(NO != ""){
			   var url = "CheckClientNO";
			   var args = {"ClientNo":NO,"time":new Date()};
			   $.post(url,args,function(data){  
				 
			if(data=="wrong"){		  
					   var textinput= document.getElementById('ClientNo');				 
					   alert("编号已重复请重新输入");
					   window.location.reload();		  
		      }   
			   });
		   }
	   });
   });
</script>
<script>
 window.onload = function()
 {
	 <%
	 	String result =(String)request.getParameter("result");
	 %>
	 var s = "<%=result%>";
		
  if(s=='Success')
	   alert("添加成功");  
	
 }
	
</script>


<script type="text/javascript">
$(document).ready(function() {
    $('#tab').bootstrapValidator({
        message: '输入不合法',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            ClientNo: {
                message: '客户编号不合法',
                validators: {
                    notEmpty: {
                        message: '客户编号不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 9,
                        message: '长度应该为至少为6，最长为9'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: '编号只能为纯数字'
                    }
                }
            },
            Name: {
                validators: {
                    notEmpty: {
                        message: '姓名不能为空！'
                    }
                }
            },
            ClientInfo: {
                validators: {
                    notEmpty: {
                        message: '备注信息如无，请填写无！'
                    },
                     stringLength: {
                        min: 1,
                        max: 40,
                        message: '字数有限制。20字以内'
                    }

                }
            },
            IdCard:{
                validators: {

                    notEmpty: {
                        message: '身份证号不能为空！'
                    },
                    stringLength: {
                        min: 18,
                        max: 18,
                        message: '长度应该为18'
                    },
                    regexp: {
                        regexp: /^[x-xX-X0-9]+$/,
                        message: '格式不合法！'
                    }
                  }
            },
            phoneNumber: {
                validators: {
                  notEmpty: {
                        message: '联系方式不能为空'
                    },
                     stringLength: {
                        min: 11,
                        max: 11,
                        message: '电话号码长度应该为11'
                    },
                    digits: {
                        message: '只能为数字！'
                    }
                }
            },

        }
    });
});
</script>


  </body>
</html>


