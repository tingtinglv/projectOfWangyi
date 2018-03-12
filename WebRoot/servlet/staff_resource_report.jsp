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

		<title>staff_resource_report</title>
		<meta name="description" content="">
		<meta name="author" content="Marine">

		<meta name="viewport" content="width=device-width; initial-scale=1.0">

		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->

		<link href="/neusoft/css/bootstrap.css" rel="stylesheet">
		<link href="/neusoft/css/staff.css" rel="stylesheet" type="text/css" />

	</head>

	<body>
		<header>
			<ul class="breadcrumb">
				  <li>
				    <a href="#">首页</a> <span class="divider">/</span>
				  </li>
				  <li>
				    <a href="#">报表管理</a> <span class="divider">/</span>
				  </li>
				  <li class="active">人事月报表</li>
				</ul>
		</header>
		<div>
			<div class="info">
				<table class="table table-striped table-bordered table-condensed" >
					<tr>
						<th class="firstline" colspan="11">岗位调动员工报表</th>
					</tr>
					<tr>
						<th  rowspan="2" >部门名称</th>
						<th colspan="6">人数统计</th>
						<th colspan="4">学历统计</th>
					</tr>
					<tr>
						<th>月初人数</th>
						<th>月末人数</th>
						<th>本月新入职</th>
						<th>本月离职</th>
						<th>本月调入</th>
						<th>本月调出</th>
						<th>研究生</th>
						<th>本科生</th>
						<th>大专</th>
						<th>高中及以下</th>
					</tr>
					<tr>
						<td>财政部</td>
						<td>32</td>
						<td>31</td>
						<td>5</td>
						<td>3</td>
						<td>8</td>
						<td>9</td>
						<td>20</td>
						<td>8</td>
						<td>5</td>
						<td>2</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
