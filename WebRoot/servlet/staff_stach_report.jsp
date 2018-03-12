<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.neusoft.ehr.entity.*"%>
<%@ page import="com.neusoft.ehr.comm.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>已调动岗位</title>
		<meta name="author" content="new" />
		
		<link href="css/bootstrap.css" rel="stylesheet">
	    <link href="css/bootstrap-responsive.css"  rel="stylesheet">
	    <link href="js/google-code-prettify/prettify.css" rel="stylesheet">
	    <link href="css/staff.css" rel="stylesheet" type="text/css" />
	    
	    <script src="js/jquery.js" ></script>
	    <script src="js/google-code-prettify/prettify.js" ></script>
	    <script src="js/bootstrap-transition.js" ></script>
	    <script src="js/bootstrap-alert.js" ></script>
	    <script src="js/bootstrap-modal.js" ></script>
	    <script src="js/bootstrap-dropdown.js" ></script>
	    <script src="js/bootstrap-scrollspy.js" ></script>
	    <script src="js/bootstrap-tab.js"></script>
	    <script src="js/bootstrap-tooltip.js" ></script>
	    <script src="js/bootstrap-popover.js" ></script>
	    <script src="js/bootstrap-button.js" ></script>
	    <script src="js/bootstrap-collapse.js" ></script>
	    <script src="js/bootstrap-carousel.js" ></script>
	    <script src="js/bootstrap-typeahead.js" ></script>
	    <script src="js/application.js" ></script>
	    <script src="js/customize.js" ></script>
	    <script src="js/bootstrap-datepicker.js" ></script>
	    <script src="js/momo.js" ></script>
	    <script src="js/admin.js"></script>
	    <script type="text/javascript" src="js/year_month_day.js"></script><!--日期下拉框-->
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
				  <li class="active">已调动岗位</li>
				</ul>
		</header>
		<div class="query">
				<form name="staff_add" action="PostcfReServlet.action">
					<table  class="table table-bordered table-striped">
						<tr>
							<th class="firstline" colspan="4">已调动岗位员工信息查询</th>
						</tr>
						<tr>
        			<td>&nbsp;开始日期</td>
					<td>
						<input type="text"  name="start_date" id="startDate" data-date-format="yyyy-mm-dd" />
					</td>
					<td>&nbsp;结束日期</td>
					<td>
						<input type="text"  name="end_date" id="jobDate" data-date-format="yyyy-mm-dd" />
					</td>
        		</tr>
        		<tr>
        			<td>员工编号</td>
        			<td><input type="text" name="seq"></td>
        			<td>员工姓名</td>
        			<td><input type="text" name="name"></td>
        		</tr>
        		<tr>
        			<td></td>
        			<td></td>
        			<td>调动方式</td>
        			<td><select name="type">
        				<option value="">全部
        				<option value="升职">升职
        				<option value="降职">降职
        				<option value="数据录入错误">数据录入错误
        			</select></td>
        		</tr>
					</table>
					<div class="lastline">
						<input type="submit" class="btn btn-primary" value="查询"/>
						<input type="reset" class="btn btn-primary" value="清空"/>
					</div>
				</form>
			</div>
				<div class="info">
				<form name="staff_info" action="staff_info_maintain.jsp">
				<table  class="table table-bordered table-striped">
					<tr>
						<th  class="firstline" colspan="9">查询结果</th>
					</tr>
					<tr>
						<th>员工编号</th>
						<th>姓&nbsp;&nbsp;&nbsp;&nbsp; 名</th>
						<th>原岗位</th>
						<th>现岗位</th>
						<th>调转方式</th>
						<th>调转类型</th>
						<th>调转原因</th>
						<th>调转日期</th>
					</tr>
					<%
					List postchList = (List)session.getAttribute("postchList");
					if(postchList.size()>0){
					    Iterator it = postchList.iterator();
					    while(it.hasNext()){
					        Postch p = (Postch)it.next(); 
					 %>
					<tr>
	        			<td><%=p.getEmp_id() %></td>
	        			<td><%=p.getEmp_name() %></td>
	        			<td><%=p.getOld_postname() %></td>
	        			<td><%=p.getPostch_postname() %></td>
	        			<td><%=p.getTrance_type() %></td>
	        			<td><%=p.getTrance_mode() %></td>
	        			<td><%=p.getReason() %></td>
	        			<td><%=p.getTrantime() %></td>
	        		</tr>
	        		<%}
	        		%>
	        		
				</table>
				<%}else{%></table>无查询结果
	        		<%}%>
				</table>
				<div class="lastline">
				</div>
				
  <div class="pagination pagination-centered pagination-small">
		<ul>
		<%
			  Page mypage=(Page)session.getAttribute("page");
		 
              if(mypage.isHasPrePage())
              {
               %>
			   <li><a href="PostcfReServlet.action?currentPage=${page.currentPage -1}">上一页</a></li>
               <%
               }
               if(mypage.getTotalPage()<=7)
               {
               		for(int i=1;i<=mypage.getTotalPage();i++)
               		{
               	%>
               <li><a href="PostcfReServlet.action?currentPage=<%=i%>" id=<%=i %>><%=i %></a></li>
               	<%
               		}
               }
               else
               {
               		if(mypage.getCurrentPage()<=4)
               		{
               			for(int i =1;i<=7;i++)
               			{
               		%>
               		<li><a href="PostcfReServlet.action?currentPage=<%=i%>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		 <li><a href="PostcfReServlet.action?currentPage=${page.totalPage}">末页</a></li>
               		<%
               		}
               		else if((mypage.getTotalPage()-mypage.getCurrentPage())<=3)
               		{
               		%>
               		 <li><a href="PostcfReServlet.action?currentPage=1 ">首页</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getTotalPage()-6;i<=mypage.getTotalPage();i++)
               			{
               		%>
               		<li><a href="PostcfReServlet.action?currentPage=<%=i%> " id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		
               		}    
               		else
               		{
               		%>
               		 <li><a href="PostcfReServlet.action?currentPage=1  ">首页</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getCurrentPage()-3;i<=mypage.getCurrentPage()+3;i++)
               			{
               		%>
               		<li><a href="PostcfReServlet.action?currentPage=<%=i%>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		<li><a href="PostcfReServlet.action?currentPage=${page.totalPage} ">末页</a></li>
               		<%
               		}           
               }
              if(mypage.isHasNextPage())
              {
               %>
                <li><a href="PostcfReServlet.action?currentPage=${page.currentPage +1}  ">下一页</a></li>
               <%
               }
                %>
		</ul>
            </div>
			</form>
		</div>
		<script type="text/javascript">
            fun3(<%=mypage.getCurrentPage()%>);
            //alert("<%=mypage.getCurrentPage()%>");
			function fun3(currentpage){
			$(document).ready(function(){
	        var page = "a#"+currentpage;
	        $(page).css("background-color","#0088cc");
	        $(page).css("color","white");
});
			}
			</script>
	</body>
</html>

