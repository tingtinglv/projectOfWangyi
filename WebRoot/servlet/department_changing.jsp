<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.neusoft.ehr.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>station_changing</title>
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
		<header class="main">
			<ul class="breadcrumb">
				<li>
					<a href="#">首页</a><span class="divider">/</span>
				</li>
				<li>
					<a href="#">员工管理</a><span class="divider">/</span>
				</li>
				<li class="active">
					员工部门调动
				</li>
			</ul>
		</header>
		<div>
			<table>
				<div class="info">
					<form name="department_changing" action="DepchangeServlet.action" method="post">
						<table  class="table table-bordered table-striped">
						<%
				Staff s = (Staff)session.getAttribute("staff");
				String seq = s.getEmpSeq();
				String name = s.getEmpName();
				 %>
							<tr>
								<th  class="firstline" colspan="9">部门调动</th>
							</tr>
							<tr>
								<td>员工编号</td>
								<td>
								<input type="text" name="empseq" value="<%=seq %>" readonly="readonly">
								</td>
								<td>员工姓名</td>
								<td>
								<input type="text" name="empname" value="<%=name %>" readonly="readonly">
								</td>
							</tr>
							<tr>
								<td>调动日期</td>
								<td>
								<input type="text" name="date" id="date">
								</td>
								<td>调动原因</td>
								<td>
								<input type="text" name="reason" id="reason">
								</td>
							</tr>
							<tr>
								<td>调转后部门</td>
								<td>
								<input type="text" name="depchdep" id="depchdep"></td>
								<td>调转类型</td>
								<td>
								<select name="type" id="type">
									<option value="">请选择 </option>
									<option value="主动调动">主动调动</option>
									 <option value="被动调动">被动调动</option>
									  <option value="数据录入错误">数据录入错误</option>
								</select></td>
							</tr>
							
							<tr>
								<td>调转方式</td>
							<td>
								<select name="mode" id="mode">
									<option value="">全部</option>
									<option value="升职">升职</option>
									<option value="降职">降职</option>
									<option value="其他">其他</option>
								</select>
							</td>
								<td>备注</td>
								<td ><textarea name="ps"></textarea></td>
							</tr>
						</table>
						<script type="text/javascript">
							function fun1()
							{
							
			                var date = document.getElementById("date");
			                //alert("date");
			                var reason = document.getElementById("reason");
			                //alert("reason");
			                var depchdep = document.getElementById("depchdep");
			               // alert("depchdep");
			                var type = document.getElementById("type");
			                //alert("type");
							var mode = document.getElementById("mode");
							//alert("mode");
			                if(date.value == ""){
			                alert("调动日期不能为空。。。");
			                return false;
			                }
			                if(reason.value == ""){
			                alert("调动原因不能为空。。。");
			                return false;
			                }
			                if(depchdep.value == ""){
			                alert("调动部门不能为空。。。");
			                return false;
			                }
			                if(type.value == ""){
			                alert("调动类型不能为空。。。");
			                return false;
			                }
			                if(mode.value == ""){
			                alert("调动方式不能为空。。。");
			                }
			                else{
			                alert("调动成功。。。");
			                document.department_changing.submit();
			                return true;
			                }
			                
		             		}
							</script>
						<div class="lastline">
							<a class="btn btn-primary" href="department_change.jsp" >返回</a>
							<input class="btn btn-primary" type="button" value="确定" onclick="return fun1()">
							
						</div>
					</form>
				</div>
			</table>
		</div>
	</body>
</html>

