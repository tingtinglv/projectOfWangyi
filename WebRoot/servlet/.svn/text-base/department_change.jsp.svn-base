<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<title>station_change</title>
		<meta name="author" content="new" />
		<!-- Date: 2014-07-05 -->
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
				  <li class="active">员工部门调动</li>
				</ul>
		</header>
		<div class="query">
			<form name="staff_probation" action="DepChFindServlet.action">
				<table  class="table table-bordered table-striped">
					<tr>
						<th class="firstline" colspan="4">员工查询</th>
					</tr>
					<tr>
						<td>员工编号</td>
						<td>
						<input type="text" name="seq"/>
						</td>
						<td>员工姓名</td>
						<td>
						<input type="text" name="name"/>
						</td>
					</tr>
					<tr>
						<td>部门名称</td>
						<td>
						<input type="text" name="depname"/>
						</td>
						<td>岗位名称</td>
						<td>
						<input type="text" name="postname"/>
						</td>
					</tr>
				</table>
				<div class="lastline">
					<input type="submit" class="btn btn-primary" value="查询"/>
					<input type="reset" class="btn btn-primary" value="重置"/>
				</div>
			</form>
		</div>
		<div class="info">
			<form name="staff_probation" action="staff_probation.jsp">
				<table  class="table table-bordered table-striped">
				<tr>
					<th class="firstline" colspan="4">查询结果</th>
				</tr>
				<tr>
        			<th>员工编号</th>
        			<th>员工姓名</th>
        			<th>部门名称</th>
        			<th>操作</th>
        		</tr>
        		<%
        		List findList = (List)session.getAttribute("findList");
					if(findList.size()>0){
					    Iterator it = findList.iterator();
					    while(it.hasNext()){
					        Staff s = (Staff)it.next(); 
        		 %>
        		<tr>
        			<td><%=s.getEmpSeq() %></td>
        			<td><%=s.getEmpName() %></td>
        			<td><%=s.getDepName() %></td>
        			<td><a href = "DepchServlet.action?seq=<%= s.getEmpSeq() %>">部门调动</a></td>
        		</tr>
        		<%} %>
				</table>
				<%}else{%></table>无查询结果
	        		<%}%>
			</form>
     
            
            
            <div class="pagination pagination-centered pagination-small">
		<ul>
		<%
			  Page mypage=(Page)session.getAttribute("page");
              String findseq=(String)session.getAttribute("findseq");
              String findname=(String)session.getAttribute("findname");
              String finddeptname=(String)session.getAttribute("finddeptname");
              String findpostname=(String)session.getAttribute("findpostname");
		 
              if(mypage.isHasPrePage())
              {
               %>
			   <li><a href="DepChFindServlet.action?currentPage=${page.currentPage -1}&seq=<%= findseq %>&name=<%= findname %>&depname=<%= finddeptname %>&<%= findpostname %> ">上一页</a></li>
               <%
               }
               if(mypage.getTotalPage()<=7)
               {
               		for(int i=1;i<=mypage.getTotalPage();i++)
               		{
               	%>
               <li><a href="DepChFindServlet.action?currentPage=<%=i%>&seq=<%= findseq %>&name=<%= findname %>&depname=<%= finddeptname %>&<%= findpostname %>" id=<%=i %>><%=i %></a></li>
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
               		<li><a href="DepChFindServlet.action?currentPage=<%=i%>&seq=<%= findseq %>&name=<%= findname %>&depname=<%= finddeptname %>&<%= findpostname %> " id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		 <li><a href="DepChFindServlet.action?currentPage=${page.totalPage}&seq=<%= findseq %>&name=<%= findname %>&depname=<%= finddeptname %>&<%= findpostname %>">末页</a></li>
               		<%
               		}
               		else if((mypage.getTotalPage()-mypage.getCurrentPage())<=3)
               		{
               		%>
               		  <li><a href="DepChFindServlet.action?currentPage=1&seq=<%= findseq %>&name=<%= findname %>&depname=<%= finddeptname %>&<%= findpostname %>">首页</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getTotalPage()-6;i<=mypage.getTotalPage();i++)
               			{
               		%>
               		<li><a href="DepChFindServlet.action?currentPage=<%=i%>&seq=<%= findseq %>&name=<%= findname %>&depname=<%= finddeptname %>&<%= findpostname %>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		
               		}    
               		else
               		{
               		%>
               		 <li><a href="DepChFindServlet.action?currentPage=1&seq=<%= findseq %>&name=<%= findname %>&depname=<%= finddeptname %>&<%= findpostname %>">首页</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getCurrentPage()-3;i<=mypage.getCurrentPage()+3;i++)
               			{
               		%>
               		<li><a href="DepChFindServlet.action?currentPage=<%=i%>&seq=<%= findseq %>&name=<%= findname %>&depname=<%= finddeptname %>&<%= findpostname %>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		<li><a href="DepChFindServlet.action?currentPage=${page.totalPage}&seq=<%= findseq %>&name=<%= findname %>&depname=<%= finddeptname %>&<%= findpostname %>">末页</a></li>
               		<%
               		}           
               }
              if(mypage.isHasNextPage())
              {
               %>
                <li><a href="DepChFindServlet.action?currentPage=${page.currentPage +1}&seq=<%= findseq %>&name=<%= findname %>&depname=<%= finddeptname %>&<%= findpostname %> ">下一页</a></li>
               <%
               }
                %>
		</ul>
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
		</div>
	</body>
</html>

