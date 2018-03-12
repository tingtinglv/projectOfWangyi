<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.neusoft.ehr.entity.*" %>
<%@ page import="com.neusoft.ehr.comm.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>岗位调动</title>
		<meta name="author" content="new" />
		
		<link href="/neusoft/css/bootstrap.css" rel="stylesheet">
	    <link href="/neusoft/css/bootstrap-responsive.css"  rel="stylesheet">
	    <link href="/neusoft/js/google-code-prettify/prettify.css" rel="stylesheet">
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
	    <script src="js/bootstrap-datepicker.js" ></script>
	    <script src="js/momo.js" ></script>
	    <script type="text/javascript" src="/neusoft/js/year_month_day.js"></script><!--日期下拉框-->
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
				  <li class="active">岗位调动</li>
				</ul>
		</header>
		<%
				Staff s = (Staff)session.getAttribute("staff");
				 %>
			<div class="query">
			<form action="PostchAddServlet.action">
				<table class="table table-striped table-bordered table-condensed">
				<tr>
					<th class="firstline" colspan="6">岗位调动</th>
				</tr>
				<tr>
				<td>
						员工编号</td><td><input type="text" value="<%=s.getEmpSeq() %>" name="empSeq" readonly="readonly">
					</td>
					<td>
						员工姓名</td><td><input type="text" value="<%=s.getEmpName() %>" name="empName" readonly="readonly"/>
					</td>
					<td>
						原岗位名称</td><td><input type="text" value="<%=s.getPostName() %>" name="oldPost" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td>
						调转岗位</td><td><input type="text" name="newPost"/>
					</td>
					<td>
						调转方式 </td><td>
			<select name="type">
				<option value="升职">升职</option>
				<option value="降职">降职</option>
				<option value="数据录入错误">数据录入错误</option>
				</select>
					</td>
					<td>
						调转类型 </td><td>
			<select name="mode">
				<option value="主动">主动</option>
				<option value="被动">被动</option>
				<option value="数据录入错误">数据录入错误</option>
				</select>
					</td>
				</tr>
				<tr>
					<td>
						调转日期
						</td>
						<td>
							<input type="text"  name="date" id="startDate" data-date-format="yyyy-mm-dd" />
						</td>
						<td>
						调转原因</td><td><input type="text" name="reason"/>
					</td>
					<td>
						备注</td><td><input type="text" name="ps"/>
					</td>
					<td colspan="2"></td>
			</table>
			<div class="lastline">
					<input type="submit" class="btn btn-primary" value="调动"/>
					<input type="reset" class="btn btn-primary" value="清空"/>
				</div>	
			</form>
		</div>
			
	</body>
</html>

