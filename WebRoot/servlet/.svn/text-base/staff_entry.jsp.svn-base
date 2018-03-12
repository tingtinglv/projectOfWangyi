<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

		<link href="/neusoft/css/bootstrap.css" rel="stylesheet">
		<link href="/neusoft/css/staff.css" rel="stylesheet" type="text/css" />

		<script src="/neusoft/js/jquery.js"></script>
		<script src="/neusoft/js/bootstrap-transition.js"></script>
		<script src="/neusoft/js/bootstrap-modal.js"></script>

	</head>

	<body>
		<header class="main">
		<ul class="breadcrumb">
			<li>
				<a href="#">首页</a>
				<span class="divider">/</span>
			</li>
			<li>
				<a href="#">员工管理</a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				员工入职管理
			</li>
		</ul>
		</header>
		<div class="query">
			<form name="staff_add" action="staff_entry.jsp">
				<table class="table table-bordered table-striped">
					<tr>
						<th class="firstline" colspan="4">
							查询条件
						</th>
					</tr>
					<tr>
						<td>
							姓&nbsp;&nbsp;&nbsp;&nbsp; 名
						</td>
						<td>
							<input type="text" />
						</td>
						<td>
							身份证号
						</td>
						<td>
							<input type="text" />
						</td>
					</tr>
				</table>
				<div class="lastline">
					<input type="submit" class="btn btn-primary" value="查询" />
					<input type="reset" class="btn btn-primary" value="清除" />

				</div>
			</form>
		</div>
		<div id="infoModal" class="modalinfo hide in" data-backdrop="false">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">&times;</a>
				<h3>
					详细信息
				</h3>
			</div>
			<div class="modal-body">
				<table id="infotable" class="table-bordered table-striped">
					<tr>
						<td>
							姓&nbsp; 名
						</td>
						<td></td>
						<td>
							性别
						</td>
						<td></td>
						<td>
							民族
						</td>
						<td></td>
					</tr>

					<tr>
						<td>
							出生日期
						</td>
						<td></td>
						<td>
							身份证号
						</td>
						<td></td>
						<td>
							政治面貌
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							身高
						</td>
						<td></td>
						<td>
							血型
						</td>
						<td></td>
						<td>
							婚姻状况
						</td>
						<td></td>
					</tr>

					<tr>
						<td>
							联系电话
						</td>
						<td></td>
						<td>
							电子邮件
						</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>
							最高学历
						</td>
						<td></td>
						<td>
							最高学位
						</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>
							毕业院校
						</td>
						<td></td>
						<td>
							所学专业
						</td>
						<td></td>
						<td>
							毕业日期
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							籍贯
						</td>
						<td></td>
						<td>
							出生地
						</td>
						<td></td>
						<td>
							户口所在地
						</td>
						<td></td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">关闭</a>
			</div>
		</div>
		<div id="empModal" class="modalinfo hide fade">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">&times;</a>
				<h3>
					填写录入信息
				</h3>
			</div>
			<div class="modal-body">
				<div class="info">
					<table class="table table-bordered table-striped">
						<tr>
							<th class="firstline" colspan="6">
								职业信息
							</th>
						</tr>
						<tr>
							<td>
								员工号
							</td>
							<td>
								<input type="text" />
							</td>
							<td>
								部门
							</td>
							<td>
								<input type="text" />
							</td>
							<td>
								岗位
							</td>
							<td>
								<input type="text" />
							</td>
						</tr>

						<tr>
							<td>
								入职日期
							</td>
							<td>
								<input type="text" />
							</td>
							<td>
								参加工作日期
							</td>
							<td>
								<input type="text" />
							</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>
								人员来源
							</td>
							<td>
								<select>
									<option value="">
										--请选择--
									</option>
									<option value="">
										校园招聘
									</option>
									<option value="">
										社会招聘
									</option>
									<option value="">
										其他
									</option>
								</select>
							</td>
							<td>
								用工形式
							</td>
							<td>
								<select>
									<option value="">
										--请选择--
									</option>
									<option value="">
										正式员工
									</option>
									<option value="">
										临时员工
									</option>
								</select>
							</td>
							<td>
								试用期
							</td>
							<td>
								<input name="probation" type="radio">
								是
								<input name="probation" type="radio">
								否
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">关闭</a>
				<a href="#" class="btn btn-primary">确定录入</a>
			</div>
		</div>
		<div class="info">
			<form name="staff_info" action="staff_info_maintain.jsp">
				<table class="table table-bordered table-striped">
					<tr>
						<th class="firstline" colspan="7">
							查询结果
						</th>
					</tr>
					<tr>
						<th>
							姓&nbsp;&nbsp;&nbsp;&nbsp; 名
						</th>
						<th>
							性&nbsp;&nbsp;&nbsp;&nbsp; 别
						</th>
						<th>
							最高学位
						</th>
						<th colspan="2">
							操&nbsp;&nbsp;&nbsp;&nbsp; 作
						</th>
					</tr>
					<tr>
						<td>
							sdf
						</td>
						<td>
							sdf
						</td>
						<td>
							sdf
						</td>
						<td>
							<a href="#infoModal" data-toggle="modal">详细信息</a>
						</td>
						<td>
							<a href="#empModal" data-toggle="modal">录入</a>
						</td>
					</tr>
				</table>
				<div class="lastline">
				</div>
			</form>
		</div>
	</body>
</html>
