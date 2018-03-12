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
		<title>员工查询</title>
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
	</head>
	<body>
	<%
			String depName="";
			String postName="";
			List<Dept> depList = (List<Dept>)session.getAttribute("depList");
			List<Post> postList = (List<Post>)session.getAttribute("postList");
			if(postList.size()>0){
			    Iterator it = postList.iterator();
			    while(it.hasNext()){
			    	Post p = (Post)it.next();
			    	if(postName.equals(""))
			    		postName="\""+p.getPost_name()+"\"";
			    	else
			    		postName=postName+","+"\""+p.getPost_name()+"\"";
			    }
			}
			if(depList.size()>0){
			    Iterator it = depList.iterator();
			    while(it.hasNext()){
			    	Dept d = (Dept)it.next();
			    	if(depName.equals(""))
			    		depName="\""+d.getDep_name()+"\"";
			    	else
			    		depName=depName+","+"\""+d.getDep_name()+"("+d.getDep_seq()+")\"";
			    }
			}
		 %>
		<header>
			<ul class="breadcrumb">
				  <li>
				    <a href="main.jsp">首页</a> <span class="divider">/</span>
				  </li>
				  <li>
				    <a href="#">岗位管理</a> <span class="divider">/</span>
				  </li>
				  <li class="active">员工查询</li>
				</ul>
		</header>
		<div class="query">
			<form name="staff_add" action="PostStaffServlet.action" method="post">
					<table  class="table table-bordered table-striped">
						<tr>
							<th class="firstline" colspan="4">员工查询</th>
						</tr>
						<tr>
							<td>部门名称</td>
							<td>
						<input type="text" data-provide="typeahead" data-items="5" name="depName" data-source='[<%=depName %> ]' />
						</td>
							<td>岗位名称</td>
							<td>
						<input type="text" data-provide="typeahead" data-items="5" name="postName" data-source='[<%=postName %> ]' />
						</td>
						</tr>
						<tr>
							<td>员工编号</td>
							<td><input type="text" name="empSeq"/></td>
							<td>员工姓名</td>
							<td><input type="text" name="empName"/></td>
						</tr>
					</table>
					<div class="lastline">
						<input type="submit" class="btn btn-primary" value="查询"/>
						<input type="reset" class="btn btn-primary" value="清空"/>
					</div>
				</form>
			</div>
			
			<div class="info">
			<form name="station_staff_info" action="">
				<table  class="table table-bordered table-striped">
					<tr>
						<th  class="firstline" colspan="9">查询结果</th>
					</tr>
					<tr>
						<th>员工序号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>部门</th>
						<th>岗位</th>
						<th >操作</th>
					</tr>
					<%
					List list = (List)session.getAttribute("post_staff_list");
					if(list.size()>0){
					    Iterator<Staff> it = list.iterator();
					    while(it.hasNext()){
					        Staff s = (Staff)it.next(); 
					 %>
					<tr>
	        			<td><%=s.getEmpSeq() %></td>
	        			<td><%=s.getEmpName() %></td>
	        			<td><%=s.getEmpSex() %></td>
	        			<td><%=s.getDepName() %></td>
	        			<td><%=s.getPostName() %></td>
	        			<td><a href="PostchServlet.action?seq=<%=s.getEmpSeq() %>">岗位调动</a></td>
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
			   <li><a href="PostStaffServlet.action?currentPage=${page.currentPage -1}">上一页</a></li>
               <%
               }
               if(mypage.getTotalPage()<=7)
               {
               		for(int i=1;i<=mypage.getTotalPage();i++)
               		{
               	%>
               <li><a href="PostStaffServlet.action?currentPage=<%=i%>" id=<%=i %>><%=i %></a></li>
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
               		<li><a href="PostStaffServlet.action?currentPage=<%=i%>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		 <li><a href="PostStaffServlet.action?currentPage=${page.totalPage}">末页</a></li>
               		<%
               		}
               		else if((mypage.getTotalPage()-mypage.getCurrentPage())<=3)
               		{
               		%>
               		 <li><a href="PostStaffServlet.action?currentPage=1 ">首页</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getTotalPage()-6;i<=mypage.getTotalPage();i++)
               			{
               		%>
               		<li><a href="PostStaffServlet.action?currentPage=<%=i%> " id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		
               		}    
               		else
               		{
               		%>
               		 <li><a href="PostStaffServlet.action?currentPage=1  ">首页</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getCurrentPage()-3;i<=mypage.getCurrentPage()+3;i++)
               			{
               		%>
               		<li><a href="PostStaffServlet.action?currentPage=<%=i%>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		<li><a href="PostStaffServlet.action?currentPage=${page.totalPage} ">末页</a></li>
               		<%
               		}           
               }
              if(mypage.isHasNextPage())
              {
               %>
                <li><a href="PostStaffServlet.action?currentPage=${page.currentPage +1}  ">下一页</a></li>
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

