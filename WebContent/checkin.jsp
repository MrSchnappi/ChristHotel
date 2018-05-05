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
    <link href="css/foundation-datepicker.css" rel="stylesheet" type="text/css">
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
      
       <form id="tab" method="post" action="InsertCheckin" >
                        <fieldset>
                            <div class="form-group">
                                <label >客户编号</label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" name="ClientNo" id="ClientNo"/>       
                                </div>
                            </div>                         
                            <div id="message"></div>	
                            						
                         
                            
                              						
                            <div class="form-group">
                                <label class="col-lg-3 control-label">入住房间</label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" name="CheckRoom" id="CheckRoom"/>
                                </div>
                            </div>
                            
                            
                        </fieldset>
                        <fieldset>  
                            <div class="form-group">
                                <label class="col-lg-3 control-label">入住人数</label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" name="CheckinNum" id="CheckinNum"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-3 control-label">押金</label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" name="CheckinMoney" id="CheckinMoney"  />
                                </div>
                            </div>




                             <div class="form-group">
                                <label class="col-lg-3 control-label">入住时间</label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" name= "CheckinTime" id="CheckinTime"  />
                                </div>
                            </div>
                             <div class="form-group">
                                <label class="col-lg-3 control-label">离开时间</label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" name="DepartureTime" id="DepartureTime"  />
                                </div>
                            </div>
                            
                                                                                                               
                            <div class="form-group">
                                <label class="col-lg-3 control-label">备注</label>
                                <textarea name="CheckinInfo" rows="3" class="input-xlarge">
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
  
	   $("#CheckRoom").change(function(){
		   var RoomID = $(this).val();
		   RoomID = $.trim(RoomID);
		   if(RoomID != "")
			   {
			      var url = "CheckRoomId";
			      var args = {"CheckRoom":RoomID,"time":new Date()};
			      $.post(url,args,function(data){  
			    	  if(data != "exist")
			    		  {  			 
						   alert("房间不存在请重新填写！");
						   window.location.reload();
			    		  }
			    	  
			      });
			   }
		   
	   });
</script>  
     
<script type="text/javascript">   
	   $("#ClientNo").change(function(){
		
		   var NO=$(this).val();
		   NO = $.trim(NO);
		   if(NO != ""){
			   var url = "CheckClientNO";
			   var args = {"ClientNo":NO,"time":new Date()};
			   $.post(url,args,function(data){  
				 
			if(data!="wrong"){		  
					   			 
					   alert("客户未注册，即将跳转到客户注册页面......");
					   window.location="user.jsp";		  
		      }   
			   });
		   }
	   });

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
            
            
            CheckinInfo: {
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
            
            
            CheckRoom:{
            	validators:{
            		notEmpty:{
            			message:'入住房间不能为空！'
            		},
                     stringLength:{
                    	 min:4,
                    	 max:4,
                    	 message:'长度应该为4'
                     },
                     regexp:{
                    	 regexp: /^[0-9]+$/,
                    	 message:'格式不合法！'
                     }
            	}
            },
            
            
          
            
            CheckinNum:{
            	validators:{
            		notEmpty:{
            			message:'入住人数不能为空！'
            		},
                     stringLength:{
                    	 min:1,
                    	 max:4,
                    	 message:'超过房间入住最大的人数！'
                     },
                     regexp:{
                    	 regexp: /^[0-9]+$/,
                    	 message:'格式不合法！'
                     }
            	}
            },
       
            CheckinMoney:{
            	validators:{
            		notEmpty:{
            			message:'押金不能为空，请填写无！'
            		},
                   
                     regexp:{
                    	 regexp: /^[0-9]+$/,
                    	 message:'格式不合法！'
                     }
            	}
            }     

        }
    });
});
</script>


 <!--  <script src="js/jquery-1.11.3.min.js"></script>-->
      <script src="js/foundation-datepicker.js"></script>
    <script src="js/locales/foundation-datepicker.zh-CN.js"></script>       
    <script>


        var nowTemp = new Date();
        var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
        var checkin = $('#CheckinTime').fdatepicker({
            onRender: function (date) {
                return date.valueOf() < now.valueOf() ? 'disabled' : '';
            }
        }).on('changeDate', function (ev) {
            if (ev.date.valueOf() > checkout.date.valueOf()) {
                var newDate = new Date(ev.date)
                newDate.setDate(newDate.getDate() + 1);
                checkout.update(newDate);
            }
            checkin.hide();
            $('#DepartureTime')[0].focus();
        }).data('datepicker');



        
        var checkout = $('#DepartureTime').fdatepicker({
            onRender: function (date) {
                return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
            }
        }).on('changeDate', function (ev) {
            checkout.hide();
        }).data('datepicker');
        </script>





  </body>
</html>


