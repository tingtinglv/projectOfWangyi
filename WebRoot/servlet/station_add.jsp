<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>岗位增加</title>
		<meta name="author" content="new" />
		<!-- Date: 2014-07-05 -->
		<link href="/neusoft/css/bootstrap.css" rel="stylesheet" type="text/css" />
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
	    <script src="/neusoft/js/station_add.js" ></script>
	</head>
	<body>
		<header>
			<ul class="breadcrumb">
				  <li>
				    <a href="main.jsp">首页</a> <span class="divider">/</span>
				  </li>
				  <li>
				    <a href="station_info.jsp">岗位管理</a> <span class="divider">/</span>
				  </li>
				  <li class="active">岗位增加</li>
				</ul>
		</header>
		<div>
	
			<form id="station_add" action="../PostAddServlet.action" method="post">
				<table class="table table-striped table-bordered table-condensed">
				<tr>
					<th class="firstline" colspan="6">添加岗位</th>
				</tr>
				<tr>
					<td>
						岗位编号</td>
					<td><input type="text" id="station_add_id" name="post_seq"/>
					</td>
					<td>
						岗位名称</td>
					<td><input type="text" id="station_add_name" name="post_name"/>
					</td>
					</tr>
					<tr>
						<td>
						岗位编制</td>
					<td><input type="text" id="station_add_org" name="post_org"/>
					</td>
					<td>
						岗位类型</td>
					<td>
						<select id="station_add_type" name="post_type">
					<option value="管理">管理</option>
					<option value="技术">技术</option>
					<option value="营销">营销</option>
					<option value="市场">市场</option>
					<option value="人事">人事</option>
				</select>
					</td>
					
				</tr>
			</table>
			<div class="lastline">
					<input type="submit" class="btn btn-primary" value="添加" onclick="return add()"/>
					<a class="btn btn-primary" href="../PostFindServlet.action?post_seq=&post_name=&post_type=" target="main">取消</a>
				</div>
			</form>
		</div>
	</body>
</html>

