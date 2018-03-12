<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">

		<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

		<title>human_resource</title>
		<meta name="description" content="">
		<meta name="author" content="MarsDmo">

		<meta name="viewport" content="width=device-width; initial-scale=1.0">

		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->
		<link rel="shortcut icon" href="/favicon.ico">
		<link rel="apple-touch-icon" href="/apple-touch-icon.png">
		
		 <link href="/neusoft/css/initialization.css" rel="stylesheet" type="text/css" />
		<link href="/neusoft/css/bootstrap.css" rel="stylesheet" type="text/css">
	    <link href="/neusoft/css/staff.css" rel="stylesheet" type="text/css" />
	    
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
	    <script type="text/javascript" src="/neusoft/js/year_month_day.js"></script><!--日期下拉框-->
		
	</head>

	<body>
		<header class="main">
			<ul class="breadcrumb">
				  <li>
				    <a href="#">首页</a> <span class="divider">/</span>
				  </li>
				  <li>
				    <a href="#">员工管理</a> <span class="divider">/</span>
				  </li>
				  <li class="active">员工入职管理</li>
				</ul>
		</header>
		<div class="query">
			<form name="staff_add" action="staff_entry.jsp">
				<table  class="table table-bordered table-striped">
					<tr>
						<th class="firstline" colspan="4">查询条件</th>
					</tr>
					<tr>
						<td>姓&nbsp;&nbsp;&nbsp;&nbsp; 名</td>
						<td><input type="text" /></td>
						<td>身份证号</td>
						<td><input type="text" /></td>
					</tr>
				</table>
				<div class="lastline">		
					<input type="submit" class="btn btn-primary" value="查询"/>			
					<input type="reset" class="btn btn-primary" value="清除"/>
					<a href="staff_entry.jsp" class="btn btn-primary">添加</a>
					
				</div>
			</form>
		</div>
		
		<div id="modalbackdroptrue" class="modal hide fade">
			<div class="modal-header">
				<a class="close" data-dismiss="modal" >&times;</a>
				<h3>有遮蔽背景</h3>
			</div>
			<div class="modal-body">
				<h4>backdrop为true</h4>
				<p>
					有遮蔽背景，点击背景即可关闭对话框。
				</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal" >关闭</a>
				<a href="#" class="btn btn-primary">保存更改</a>
			</div>
		</div>

		<div id="modalbackdropfalse" class="modal hide fade">
			<div class="modal-header">
				<a class="close" data-dismiss="modal" >&times;</a>
				<h3>无遮蔽背景</h3>
			</div>
			<div class="modal-body">
				<h4>backdrop为false</h4>
				<p>
					对对话框背景使用 <code>
						static</code>
					，无遮蔽，不支持背景click关闭对话框。
				</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal" >关闭</a>
				<a href="#" class="btn btn-primary">保存更改</a>
			</div>
		</div>
		
		<div class="info">
			<form name="staff_info" action="staff_info_maintain.jsp">
				<table  class="table table-bordered table-striped">
					<tr>
						<th  class="firstline" colspan="7">查询结果</th>
					</tr>
					<tr>
						<th>姓&nbsp;&nbsp;&nbsp;&nbsp; 名</th>
						<th>性&nbsp;&nbsp;&nbsp;&nbsp; 别</th>
						<th>最高学位</th>
						<th colspan="2">操&nbsp;&nbsp;&nbsp;&nbsp; 作</th>
					</tr>
					<tr>
						<td>sdf</td>
						<td>sdf</td>
						<td>sdf</td>
						<td><a href="staff_info.jsp">详细信息</a></td>
						<td><a href="">录入</a></td>
					</tr>
				</table>
				<div class="lastline">
				</div>
			</form>
		</div>
	</body>
</html>
