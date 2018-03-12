<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>station_dev</title>
		<meta name="author" content="new" />
		<!-- Date: 2014-07-06 -->
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
		<div class="info">
			<form name="department_dev" method="post" action="/neusoft/DeptAddServlet.action" id="myform">
				<table class="table table-bordered table-striped">
					<tr>
						<th class="firstline" colspan="4">
							新建部门
						</th>
					</tr>
					<tr>
						<td>
							部门编号
						</td>
						<td>
							<input type="text" id="seq" name="seq">
						</td>
						<td>
							部门名称
						</td>
						<td>
							<input type="text" id="name" name="name">
						</td>
					</tr>
					<tr>
						<td>
							部门类型
						</td>
						<td>
							<select id="type" name="type">
								<option value="no">
									不限
									<option value="公司">
										公司
										<option value="部门">
											部门
							</select>
						</td>
						<td>
							电话
						</td>
						<td>
							<input type="text" id="tel" name="tel">
						</td>
					</tr>
					<tr>
						<td>
							成立日期
						</td>
						<td>
							<div>
									<select class="birthsel" id="selYear" name="year"></select>
									<select class="birthsel" id="selMonth" name="month"></select>
									<select class="birthsel" id="selDay" name="day"></select>
									<script type="text/javascript">
									 var selYear = window.document.getElementById("selYear");
									 var selMonth = window.document.getElementById("selMonth");
									 var selDay = window.document.getElementById("selDay");
									 new DateSelector(selYear, selMonth, selDay,2014,7,11);
									</script>
									
							 </div>							
						</td>
						<td>
							描述
						</td>
						<td>
							<input type="text" id="desc" name="desc">
						</td>
					</tr>
					<tr>
						<td>
							上级部门
						</td>
						<td>
							<select id="up_dept" name="updep">
								<option value="总公司">
									总公司</option>
								<option value="分部门">
										分部门</option>
							</select>
						</td>
						<td>
							传真
						</td>
						<td>
							<input type="text" id="fax" name="fax">
						</td>
					</tr>
				</table>
				<div class="lastline">
					<input class="btn btn-primary" type="button" value="确定" onclick="return fun1()">
					<script type="text/javascript">
		             function fun1(){
		                var seq = document.getElementById("seq");
		                var name = document.getElementById("name");
		                var tel = document.getElementById("tel");
		               
						var type = document.getElementById("type");
						
		                if(seq.value == ""){
		                alert("部门编号不能为空。。。");
		                return false;
		                }
		                if(name.value == ""){
		                alert("部门名称不能为空。。。");
		                return false;
		                }
		                if(type.value == "no"){
		                alert("部门类型不能为空。。。");
		                return false;
		                }
		                if(tel.value == ""){
		                alert("电话不能为空。。。");
		                return false;
		                }
		                if(selYear.value == ""||selMonth.value == ""||selDay.value == ""){
		                alert("日期不能为空。。。");
		                return false;
		                }
		                else{
		                alert("创建成功。。。");
		                //var myform=document.getElementById("myform");
		                document.department_dev.submit();
		                return true;
		                }
		                
	                    
		             }
		            </script>
					<a class="btn btn-primary" href="../DeptSeleServlet.action?seq=&name=&type="> 返回</a>
					<input class="btn btn-primary" type="reset" value="清空">
				</div>
			</form>
		</div>
	</body>
</html>

