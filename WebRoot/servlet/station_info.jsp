<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.neusoft.ehr.entity.*"%>
<%@ page import="com.neusoft.ehr.comm.*"%>
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
		<title>岗位管理</title>
		<meta name="lvwenlong" content="new" />

		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/bootstrap-responsive.css" rel="stylesheet">
		<link href="js/google-code-prettify/prettify.css" rel="stylesheet">
		<link href="css/staff.css" rel="stylesheet" type="text/css" />

		<script src="js/jquery.js"></script>
		<script src="js/google-code-prettify/prettify.js"></script>
		<script src="js/bootstrap-transition.js"></script>
		<script src="js/bootstrap-alert.js"></script>
		<script src="js/bootstrap-modal.js"></script>
		<script src="js/bootstrap-dropdown.js"></script>
		<script src="js/bootstrap-scrollspy.js"></script>
		<script src="js/bootstrap-tab.js"></script>
		<script src="js/bootstrap-tooltip.js"></script>
		<script src="js/bootstrap-popover.js"></script>
		<script src="js/bootstrap-button.js"></script>
		<script src="js/bootstrap-collapse.js"></script>
		<script src="js/bootstrap-carousel.js"></script>
		<script src="js/bootstrap-typeahead.js"></script>
		<script src="js/application.js"></script>
		<script src="js/customize.js"></script>
		<script src="js/station_info.js" charset="UTF-8"></script>

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
				<a href="main.jsp">首页</a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				岗位管理
			</li>
		</ul>
		</header>
		<div class="query">
			<form name="staff_add" action="PostFindServlet.action" id="station_query" method="post">
				<table class="table table-striped table-bordered table-condensed">
					<tr>
						<th class="firstline" colspan="6">
							查询
						</th>
					</tr>
					<tr>
						<td>
							岗位编号
						</td>
						<td>
							<input type="text" id="station_info_id" name="post_seq"/>
						</td>
						<td>
							岗位名称
						</td>
						<td>
						<input type="text" data-provide="typeahead" data-items="5" name="post_name" data-source='[<%=postName %> ]' />
						</td>
						<td>
							岗位类型
						</td>
						<td>
							<select id="station_info_type" name="post_type">
								<option value="">
									全部
								</option >
								<option value="管理">
									管理
								</option>
								<option value="技术">
									技术
								</option>
								<option value="营销">
									营销
								</option>
								<option value="市场">
									市场
								</option>
								<option value="人事">
									人事
								</option>
							</select>
						</td>
					</tr>
				</table>
				<div class="lastline">
				<input type="submit" class="btn btn-primary" value="查询" />
					<a class="btn btn-primary" href="/neusoft/servlet/station_add.jsp">新建岗位</a>
					<input type="reset" class="btn btn-primary" value="清空" />
				</div>
			</form>
		</div>

		<div class="info">
			<form name="staff_info" action="PostDelServlet.action">
				<table class="table table-striped table-bordered table-condensed">
					<tr>
						<th class="firstline" colspan="7">
							岗位信息
						</th>
					</tr>
					<tr>
						<th>
							选择
						</th>
						<th>
							岗位编号
						</th>
						<th>
							岗位名称
						</th>
						<th>
							岗位类型
						</th>
						<th>
							岗位编制
						</th>
						<th>
							岗下员工
						</th>
						<th>
							操作
						</th>
					</tr>
<%
					List postList2 = (List)session.getAttribute("post_list");
					if(postList2.size()>0){
					    Iterator it = postList2.iterator();
					    while(it.hasNext()){
					        Post p = (Post)it.next(); 
					 %>
					<tr>
	        			<td><input type="checkbox" name="pcbx" value="<%=p.getPost_id() %>"></td>
	        			<td><%=p.getPost_seq()%></td>
	        			<td><%=p.getPost_name()%></td>
	        			<td><%=p.getPost_type()%></td>
	        			<td><%=p.getPost_org()%></td>
	        			<td><a href="PostStaffServlet.action?postName=<%=p.getPost_name() %>">员工</a></td>
	        			<td><a href="PostUpdServlet.action?post_id=<%=p.getPost_id() %>">修改</a></td>
	        		</tr>
	        		<%}
	        		%>
	        		
				</table>
				<%}else{%></table>无查询结果
	        		<%}%>
				</table>
				<div class="lastline">
					<input type="submit" class="btn btn-primary" value="删除岗位" />
				</div>
				 <div class="pagination pagination-centered pagination-small">
		<ul>
		<%
			  Page mypage=(Page)session.getAttribute("page");
		 
              if(mypage.isHasPrePage())
              {
               %>
			   <li><a href="PostFindServlet.action?currentPage=${page.currentPage -1}">上一页</a></li>
               <%
               }
               if(mypage.getTotalPage()<=7)
               {
               		for(int i=1;i<=mypage.getTotalPage();i++)
               		{
               	%>
               <li><a href="PostFindServlet.action?currentPage=<%=i%>" id=<%=i %>><%=i %></a></li>
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
               		<li><a href="PostFindServlet.action?currentPage=<%=i%>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		 <li><a href="PostFindServlet.action?currentPage=${page.totalPage}">末页</a></li>
               		<%
               		}
               		else if((mypage.getTotalPage()-mypage.getCurrentPage())<=3)
               		{
               		%>
               		 <li><a href="PostFindServlet.action?currentPage=1 ">首页</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getTotalPage()-6;i<=mypage.getTotalPage();i++)
               			{
               		%>
               		<li><a href="PostFindServlet.action?currentPage=<%=i%> " id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		
               		}    
               		else
               		{
               		%>
               		 <li><a href="PostFindServlet.action?currentPage=1  ">首页</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getCurrentPage()-3;i<=mypage.getCurrentPage()+3;i++)
               			{
               		%>
               		<li><a href="PostFindServlet.action?currentPage=<%=i%>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		<li><a href="PostFindServlet.action?currentPage=${page.totalPage} ">末页</a></li>
               		<%
               		}           
               }
              if(mypage.isHasNextPage())
              {
               %>
                <li><a href="PostFindServlet.action?currentPage=${page.currentPage +1}  ">下一页</a></li>
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

