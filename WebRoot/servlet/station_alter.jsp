<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.neusoft.ehr.entity.Post"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>岗位修改</title>
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
	    <script src="/neusoft/js/station_alter.js" ></script>
	</head>
	<body>
	<%
	Post p = (Post)session.getAttribute("post");
	 %>
	<header>
			<ul class="breadcrumb">
				  <li>
				    <a href="main.jsp">首页</a> <span class="divider">/</span>
				  </li>
				  <li>
				    <a href="station_info.jsp">岗位管理</a> <span class="divider">/</span>
				  </li>
				  <li class="active">岗位修改</li>
				</ul>
		</header>
		<script>
		var post_type = "<%=p.getPost_type()%>";
							
							if(post_type == "管理"){
							    document.getElementById("post_type")[0].selected="selected";
							}
							else if(post_type == "技术"){
							    document.getElementById("post_type")[1].selected="selected";
							}
							else if(post_type == "营销"){
							    document.getElementById("post_type")[2].selected="selected";
							}
							else if(post_type == "市场"){
							    document.getElementById("post_type")[3].selected="selected";
							}
							else if(post_type == "人事"){
							    document.getElementById("post_type")[4].selected="selected";
							}
							else{
							    //alert("有错误。。。");
							}
		
		</script>
		<div>
			<form id="station_alter" action="PostUpdateServlet.action" method="post">
			<input type="hidden" value="<%=p.getPost_id() %>" name="post_id"/>
				<table class="table table-striped table-bordered table-condensed">
				<tr>
					<th class="firstline" colspan="6">修改岗位</th>
				</tr>
				<tr>
					<td>
						岗位编号</td>
					<td><input type="text" id="station_alter_id" name="post_seq" value="<%=p.getPost_seq() %>"/>
					</td>
					<td>
						岗位名称</td>
					<td><input type="text" id="station_alter_name" name="post_name" value="<%=p.getPost_name() %>"/>
					</td>
					</tr>
					<tr>
						<td>
						岗位编制</td>
					<td><input type="text" id="station_alter_org" name="post_org" value="<%=p.getPost_org() %>"/>
					</td>
					<td>
						岗位类型</td>
					<td>
						<select id="station_alter_type" name="post_type">
						<%String post_type = p.getPost_type(); %>
						<%if(post_type.equals("管理")) {%>
					<option value="管理" selected="selected">管理</option>
					<%}else{ %>
					<option value="管理" >管理</option>
					<%} %>
					<%if(post_type.equals("技术")) {%>
					<option value="技术" selected="selected">技术</option>
					<%}else{ %>
					<option value="技术" >技术</option>
					<%} %>
					<%if(post_type.equals("营销")) {%>
					<option value="营销" selected="selected">营销</option>
					<%}else{ %>
					<option value="营销" >营销</option>
					<%} %>
					<%if(post_type.equals("市场")) {%>
					<option value="市场" selected="selected">市场</option>
					<%}else{ %>
					<option value="市场" >市场</option>
					<%} %>
					<%if(post_type.equals("人事")) {%>
					<option value="人事" selected="selected">人事</option>
					<%}else{ %>
					<option value="人事" >人事</option>
					<%} %>
					
				</select>
					</td>
					
				</tr>
			</table>
			<div class="lastline">
					<input type="submit" class="btn btn-primary" value="修改" onclick="return alter()""/>
					<a class="btn btn-primary" href="PostFindServlet.action?post_seq=&post_name=&post_type=" target="main">取消</a>
				</div>
			</form>
		</div>
	</body>
</html>

