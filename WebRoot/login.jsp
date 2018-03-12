<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
		String logresult = (String)request.getAttribute("logresult");
		if(logresult!=null)
		{
			if(logresult.equals("mistake"))
			{
  			
 %>
  			<script>
				alert("账号或密码错误");
  			</script>
<%
  			}
  			else if(logresult.equals("login"))
  			{
 %>
  			<script>
				alert("用户已在线，无法重复登录");
  			</script>
<% 		
  			}
  			else if(logresult.equals("unactive"))
  			{
 %>
  			<script>
				alert("用户尚未激活，请等待管理员审核");
  			</script>
<%
  			}
  		}
  			
     			
%>
<%
	String  regresult = (String)request.getAttribute("regresult");
	if(regresult!=null)
	{
		if(regresult.equals("success"))
		{
 %>
 <script>
 alert("注册成功,请等待管理员审核");
 </script>
 <%
 		}
 		else
 		{
%>
<script>
 alert("注册失败");
 </script>
 		
<%
 		}
 	}
 %>
<%
	String  pwdforresult = (String)request.getAttribute("pwdforresult");
	if(pwdforresult!=null)
	{
		if(pwdforresult.equals("success"))
		{
 %>
 <script>
 alert("密码修改成功");
 </script>
 <%
 		}
 		else
 		{
%>
<script>
 alert("密码修改失败");
 </script>
 		
<%
 		}
 	}
 %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">

		<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

		<title>menu</title>
		<meta name="description" content="">
		<meta name="author" content="Marine">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width; initial-scale=1.0">

		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->
		<link rel="shortcut icon" href="/favicon.ico">
		<link rel="apple-touch-icon" href="/apple-touch-icon.png">
		
		<link href="/neusoft/css/bootstrap.css" rel="stylesheet">
	    <link href="/neusoft/css/login.css" rel="stylesheet" />
	
	    <script src="/neusoft/js/jquery.js" ></script>
	    <script src="/neusoft/js/google-code-prettify/prettify.js" ></script>
	    <script src="/neusoft/js/bootstrap-transition.js" ></script>
	    <script src="/neusoft/js/bootstrap-alert.js" ></script>
	    <script src="/neusoft/js/bootstrap-modal.js" ></script>
	    <script src="/neusoft/js/bootstrap-dropdown.js" ></script>
	    <script src="/neusoft/js/bootstrap-scrollspy.js" ></script>
	    <script src="/neusoft/js/bootstrap-tab.js"></script>
	    <script src="/neusoft/js/bootstrap-tooltip.js" ></script>
	    <script src="/neusoft/js/bootstrap-popover.js" ></script>
	    <script src="/neusoft/js/bootstrap-button.js" ></script>
	    <script src="/neusoft/js/bootstrap-collapse.js" ></script>
	    <script src="/neusoft/js/bootstrap-carousel.js" ></script>
	    <script src="/neusoft/js/bootstrap-typeahead.js" ></script>
	    <script src="/neusoft/js/application.js" ></script>
	    <script src="/neusoft/js/customize.js" ></script>
	    <script src="/neusoft/js/login.js"></script>

	</head>

	<body>
		<div id="t3zrydiv3"> 
			<img src="/neusoft/imgs/Neusoft.jpg" />
		</div>
		<div>
			<header>
				<img src="/neusoft/imgs/login-title.png" />
				<br>
			</header>
			<form action="UserPwdChangeServlet" name="pwdforgetform" method="post">
			<div id="myModal1" class="modal hide fade">
		     <div class="modal-header">
		       <a class="close" data-dismiss="modal" >&times;</a>
		       <h3>找回密码</h3>
		     </div>
	   		 <div class="modal-body" id ="myModal1body">
		     <div id="mydiv1">
		     	请输入要找回密码的账号
				<div class="" id="inputdiv1">
					<div class="controls">
						账号:&nbsp;&nbsp;
						<input type="text" class="input-medium search-query" id="pwdforuname" name="pwdforuname" 
						onchange="pwdforunamecheck('pwdforuname','inputdiv1','pwdforunamespan')" 
       					onblur="pwdforunamecheck('pwdforuname','inputdiv1','pwdforunamespan')" 
       					onclick="changecolor('inputdiv1','pwdforunamespan')"maxlength="30"/>
						<span class="help-inline" id="pwdforunamespan"></span>
					</div>
				</div>
				<input type="button" id="mydiv1next" class="btn btn-primary" value="下 一 步" onclick="next()" disabled />
			</div>
			<div id="mydiv2" >
				请回答找回密码问题:
				<div class="" id="inputdiv2">
					<div class="controls">
						<span  id="pwdforquesspan"></span><!--此处span用于存放验证问题-->
						&nbsp;
						<input type="text" class="input-medium search-query" id="pwdforans" name="pwdforans" 
						onchange="answercheck('pwdforans','inputdiv2','pwdforansspan')"
		           		onclick="changecolor('inputdiv2','pwdforansspan')"
		           		maxlength="50" />
						<span class="help-inline" id="pwdforansspan"></span>
					</div>
				</div>
				<div class="" id="inputdiv3">
					<div class="controls">
						&nbsp;&nbsp;&nbsp;你的Email地址:&nbsp;
						<input type="text" class="input-medium search-query" id="pwdforemail" name="pwdforemail" 
						onchange="emailcheck('pwdforemail','inputdiv3','pwdforemailspan')"
		           		onclick="changecolor('inputdiv3','pwdforemailspan')" maxlength="50"/>
						<span class="help-inline" id="pwdforemailspan"></span>
					</div>
				</div>
				<input type="button" class="btn btn-primary" value="上 一 步" onclick="back()" />
				<input type="button" class="btn btn-primary" value="下 一 步" onclick="judgeforanswer('pwdforuname','pwdforans','pwdforemail')" />
			</div>
			<div id="mydiv3" >
				请输入新的密码
				<div class="" id="inputdiv4">
					<div class="controls">
						请输入密码:&nbsp;&nbsp;
						<input type="password"  class="input-medium search-query" id="pwdforpwd" name="pwdforpwd" 
						onchange="regpwdcheck('pwdforpwd','inputdiv4','pwdforpwdspan')"
		           		onclick="changecolor('inputdiv4','pwdforpwdspan')" 
						maxlength="30" />
						<span class="help-inline" id="pwdforpwdspan"></span>
					</div>
				</div>
				
				<div class="" id="inputdiv5">
					<div class="controls">
						请再次输入:&nbsp;&nbsp;
						<input type="password" class="input-medium search-query" id="pwdforpwdconf" name="pwdforpwdconf" 
						onchange="pwdconfcheck('pwdforpwdconf','inputdiv5','pwdforpwdconfspan')"
		           		onclick="changecolor('inputdiv5','pwdforpwdconfspan')" maxlength="30">
						<span class="help-inline" id="pwdforpwdconfspan"></span>
					</div>
				</div>
				<input type="button" class="btn btn-primary" value="上 一 步" onclick="back()" />
				<input type="button" class="btn btn-primary" value="确认修改" onclick="pwdforsubmit()"  />
			</div>
			<script>
					document.getElementById("mydiv1").style.display="block";
					document.getElementById("mydiv2").style.display="none";
					document.getElementById("mydiv3").style.display="none";
			</script> 
	    </div>
    </div>	
			</form>
			<form action="UserRegistServlet"  name="registaccount" method="post">
				<div id="myModal" class="modal hide fade">
					<div class="modal-header">
						<a class="close" data-dismiss="modal" >&times;</a>
						<h3>注册帐号</h3>
					</div>
					<div class="modal-body" id="t3zrydiv4">
					
						<div id="t3zrydivloginput4" class="">
		           				<div class="controls"  >
		           					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账号:&nbsp;&nbsp;
		           					<input type="text" class="input-medium search-query" name="reguname" id = "reguname" 
		           					onchange="regunamecheck('reguname','t3zrydivloginput4','regunamespan')" 
		           					onblur="regunamecheck('reguname','t3zrydivloginput4','regunamespan')" 
		           					 onclick="changecolor('t3zrydivloginput4','regunamespan')" maxlength="30">
		              				<span class="help-inline" id="regunamespan"></span>
		            			</div>
		            	</div>
		            	<div id="t3zrydivloginput5" class="">
		           				<div class="controls"  >
		           					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码:&nbsp;&nbsp;
		           					<input type="password" class="input-medium search-query" name="regpwd" id = "regpwd"
		           					 onchange="regpwdcheck('regpwd','t3zrydivloginput5','regpwdspan')"
		           					  onclick="changecolor('t3zrydivloginput5','regpwdspan')" 
		           					  maxlength="30">
		              				<span class="help-inline" id="regpwdspan"></span>
		            			</div>
		            	</div>
		            	<div id="t3zrydivloginput6" class="">
		           				<div class="controls"  >
		           					确认密码:&nbsp;&nbsp;
		           					<input type="password" class="input-medium search-query" id = "regpwdconf" 
		           					onchange="pwdconfcheck('regpwdconf','t3zrydivloginput6','regpwdconfspan')"
		           					onclick="changecolor('t3zrydivloginput6','regpwdconfspan')" maxlength="30">
		              				<span class="help-inline" id="regpwdconfspan"></span>
		            			</div>
		            	</div>
		            	<div id="t3zrydivloginput7" class="">
		            		
		            		<div class="controls"  >
		            		密保问题:&nbsp;
		            		<select id="questionselect" 
		            		onblur="questioncheck('questionselect','t3zrydivloginput7','regquestionspan')"
		            		onclick="changecolor('t3zrydivloginput7','regquestionspan')" 
		            		name = "question">
		            		<option value="">--请选择密保问题--</option>
		            		<option value="你最喜欢哪个球队？">你最喜欢哪个球队？</option>
		            		<option value="你少年时代最好的朋友叫什么？">你少年时代最好的朋友叫什么？</option>
		            		<option value="你的生日是多少？">你的生日是多少？</option>
		            		<option value="你最喜欢的乐队">你最喜欢的乐队</option>
		            		<option value="你大学时的入学日期">你大学时的入学日期</option>
		            		</select>
		            		<span class="help-inline" id="regquestionspan"></span>
		            		</div>
		            	</div>
		            	<div id="t3zrydivloginput8" class="">
		           				<div class="controls"  >
		           					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;答案:&nbsp;&nbsp;
		           					<input type="text" class="input-medium search-query" id = "reganswer" name ="answer"
		           					onchange="answercheck('reganswer','t3zrydivloginput8','reganswerspan')"
		           					onclick="changecolor('t3zrydivloginput8','reganswerspan')" maxlength="30">
		              				<span class="help-inline" id="reganswerspan"></span>
		            			</div>
		            	</div>
		            	<div id="t3zrydivloginput9" class="">
		           				<div class="controls"  >
		           					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email:&nbsp;
		           					<input type="text" class="input-medium search-query" id = "regemail" name="email"
		           					onchange="emailcheck('regemail','t3zrydivloginput9','regemailspan')"
		           					onclick="changecolor('t3zrydivloginput9','regemailspan')" maxlength="30">
		              				<span class="help-inline" id="regemailspan"></span>
		            			</div>
		            	</div>
	          		</div>
					<div class="modal-footer">
						<input class="btn btn-primary" type = "button" onclick ="registaccount1()" value ="注册">
						<button type="reset" class="btn btn-primary" onclick="resetall1()">清除</button>
					</div>
				</div>
			</form>
			
			<div id="t3zrydiv2">
			<div id="myCarousel" class="carousel slide">
            <div class="carousel-inner">
              <div class="item active"align="center">
                <img src="/neusoft/imgs/6.jpg" alt="">
                <div class="carousel-caption">
                  <h4>东软</h4>
                  <p>欢迎来到东软人事管理系统</p>
                </div>
              </div>
              <div class="item" align="center">
                <img src="/neusoft/imgs/login01.jpg"  alt="">
                <div class="carousel-caption">
                  <h4>人事管理</h4>
                  <p>欢迎来到东软人事管理系统 </p>
                </div>
              </div>
              <div class="item" align="center">
                <img src="/neusoft/imgs/login02.jpg"  alt="">
                <div class="carousel-caption">
                  <h4>Neusoft</h4>
                  <p>Welcome to Neusoft Dalian</p>
                </div>
              </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
          </div>
			</div>
			<form action="UserLoginServlet" name="t3zryform1" method = "post">
				<div id="t3zrydiv1" >
					
					<div>
						<div id="t3zrydivloginput3" class="">
		           				<div class="controls"  >
		           					账号:&nbsp;&nbsp;<input type="text" class="input-medium search-query" id = "uname" name = "uname" onblur="unamecheck('uname','t3zrydivloginput3','unamespan')" onclick="changecolor('t3zrydivloginput3','unamespan')" maxlength="30">
		              				<span class="help-inline" id="unamespan"></span>
		            			</div>
		          		</div>
						<div id="t3zrydivloginput2" class="">
		           				<div class="controls">
		           					密码:&nbsp;&nbsp;<input type="password" class="input-medium search-query" id = "pwd" name= "pwd" onblur="pwdcheck('pwd','t3zrydivloginput2','pwdspan')" onclick="changecolor('t3zrydivloginput2','pwdspan')" maxlength="30">
		              				<span class="help-inline" id="pwdspan"></span>
		            			</div>
		          		</div>
		          		
						<div id="t3zrydivloginput1">
							<!--<a class="btn btn-primary" href="index.jsp" >登录</a>-->
							<input class="btn btn-primary" type = "button" onclick ="judgelogin()" value = "登录">
							&nbsp;
							<a class="btn btn-primary" href="#myModal" onclick ="linkReg()" data-toggle="modal">注册</a>
							&nbsp;<button type="reset" class="btn btn-primary" onclick="resetall2()">清除</button>
							<a data-toggle="modal" href="#myModal1"  data-keyboard="false" onclick ="resetforpwd()">找回密码</a>
						</div>
					</div>
					
					
				</div>
			</form>
			<footer>
				<p align="center">
					&copy; 版权所有 东软集团
				</p>
			</footer>
		</div>
	</body>
</html>
