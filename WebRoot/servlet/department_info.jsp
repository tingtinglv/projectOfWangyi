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
		<title>station_info</title>
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
				  <li class="active">部门管理</li>
				</ul>
		</header>
        <div class="station_div1">
        <form name="department_select" method="post" action="DeptSeleServlet.action" id="myform">
        	<table  class="table table-bordered table-striped">
				<tr>
					<th class="firstline" colspan="4">查询条件</th>
				</tr>
        		<tr>
        			<td>部门编号</td>
        			<td><input type="text" name = "seq"></td>
        			<td>部门名称</td>
        			<td><input type="text" name = "name"></td>
        		</tr>
        		<tr>
        			<td colspan="2"></td>
        			<td>部门类型</td>
        			<td ><select name="type">
        				<option value="">不限</option>
        				<option value="公司">公司</option>
        				<option value="部门">部门</option>
        			</select>
        			</td>
        		</tr>
        	</table>
        	<div class="lastline">
					<input type="button" class="btn btn-primary" value="查询" onclick="sele()"/>
					<a class="btn btn-primary" href="servlet/department_dev.jsp"?>新建部门</a>
					<input type="reset" class="btn btn-primary" value="清空"/>
					<script>
					function sele(){
					    document.department_select.submit();
					}
					</script>
			</div>
			</form>
        </div>
        
        <div id="modalbackdropfalse" class="modal hide fade">
			<div class="modal-header">
				<a class="close" data-dismiss="modal" >&times;</a>
				<h3>无遮蔽背景</h3>
			</div>
			<div class="modal-body">
				<h4>backdrop为false</h4>
				<p>
					对对话框背景使用 <code>
						static</code>
					，无遮蔽，不支持背景click关闭对话框。
				</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal" >关闭</a>
				<a href="#" class="btn btn-primary">保存更改</a>
			</div>
		</div>
		
		<div id="modalbackdroptrue" class="modal hide fade">
			<div class="modal-header">
				<a class="close" data-dismiss="modal" >&times;</a>
				<h3>有遮蔽背景</h3>
			</div>
			<div class="modal-body">
				<h4>backdrop为true</h4>
				<p>
					有遮蔽背景，点击背景即可关闭对话框。
				</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal" >关闭</a>
				<a href="#" class="btn btn-primary">保存更改</a>
			</div>
		</div>
        
        <div class="info">
			<form name="department_info" action="DeptBatchDelServlet.action">
				<table  class="table table-bordered table-striped">
					<tr>
						<th  class="firstline" colspan="9">查询结果</th>
					</tr>
					<tr>
						<th>选&nbsp;&nbsp; 择</th>
	        			<th>部门编号</th>
	        			<th>部门名称</th>
	        			<th>部门类型</th>
	        			<th>部门电话</th>
	        			<th>部门描述</th>
	        			<th>上级部门</th>
	        			<th>成立日期</th>
	        			<th>部门员工</th>
	        			<th>信息维护</th>
					</tr>
					<%
					List deptList = (List)session.getAttribute("deptList");
					if(deptList.size()>0){
					    Iterator it = deptList.iterator();
					    while(it.hasNext()){
					        Dept d = (Dept)it.next(); 
					 %>
					<tr>
	        			<td><input type="checkbox" name="cbx" value="<%=d.getDep_seq() %>"></td>
	        			<td><%=d.getDep_seq() %></td>
	        			<td><%=d.getDep_name() %></td>
	        			<td><%=d.getDep_type() %></td>
	        			<td><%=d.getDep_tel() %></td>
	        			<td><%=d.getDep_desc() %></td>
	        			<td><%=d.getDep_updep() %></td>
	        			<td><%=d.getDep_date() %></td>
	        			<td><a href="DepChFindServlet.action?seq=&name=&depname=<%=d.getDep_name() %>&postname=">部门员工</a></td>
	        			<td><a href="DeptUpdateServlet.action?seq=<%= d.getDep_seq() %>">修改</a></td>
	        		</tr>
	        		<%}
	        		%>
	        		
				</table>
				<%}else{%></table>无查询结果
	        		<%}%>
				<div class="lastline">
					<input type="button" class="btn btn-primary"   value="删除" onclick = "dele()"/>
					<script type="text/javascript">
					function dele(){
					    document.department_info.submit();
					}
					function update(){
					    
					}
					</script>
				</div>
				</form>
				
				<div class="pagination pagination-centered pagination-small">
		<ul>
		<%
			  Page mypage=(Page)session.getAttribute("page");
              String seleseq=(String)session.getAttribute("seleseq");
              String selename=(String)session.getAttribute("selename");
              String seletype=(String)session.getAttribute("seletype");
		 
              if(mypage.isHasPrePage())
              {
               %>
			   <li><a href="DeptSeleServlet.action?currentPage=${page.currentPage -1}&seq=<%= seleseq %>&name=<%= selename %>&type=<%= seletype %> ">上一页</a></li>
               <%
               }
               if(mypage.getTotalPage()<=7)
               {
               		for(int i=1;i<=mypage.getTotalPage();i++)
               		{
               	%>
               <li><a href="DeptSeleServlet.action?currentPage=<%=i%>&seq=<%= seleseq %>&name=<%= selename %>&type=<%= seletype %>" id=<%=i %>><%=i %></a></li>
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
               		<li><a href="DeptSeleServlet.action?currentPage=<%=i%>&seq=<%= seleseq %>&name=<%= selename %>&type=<%= seletype %>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		 <li><a href="DeptSeleServlet.action?currentPage=${page.totalPage}&seq=<%= seleseq %>&name=<%= selename %>&type=<%= seletype %> ">末页</a></li>
               		<%
               		}
               		else if((mypage.getTotalPage()-mypage.getCurrentPage())<=3)
               		{
               		%>
               		 <li><a href="DeptSeleServlet.action?currentPage=1&seq=<%= seleseq %>&name=<%= selename %>&type=<%= seletype %>">首页</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getTotalPage()-6;i<=mypage.getTotalPage();i++)
               			{
               		%>
               		<li><a href="DeptSeleServlet.action?currentPage=<%=i%>&seq=<%= seleseq %>&name=<%= selename %>&type=<%= seletype %>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		
               		}    
               		else
               		{
               		%>
               		 <li><a href="DeptSeleServlet.action?currentPage=1&seq=<%= seleseq %>&name=<%= selename %>&type=<%= seletype %>">首页</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getCurrentPage()-3;i<=mypage.getCurrentPage()+3;i++)
               			{
               		%>
               		<li><a href="DeptSeleServlet.action?currentPage=<%=i%>&seq=<%= seleseq %>&name=<%= selename %>&type=<%= seletype %>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		<li><a href="DeptSeleServlet.action?currentPage=${page.totalPage}&seq=<%= seleseq %>&name=<%= selename %>&type=<%= seletype %> ">末页</a></li>
               		<%
               		}           
               }
              if(mypage.isHasNextPage())
              {
               %>
                <li><a href="DeptSeleServlet.action?currentPage=${page.currentPage +1}&seq=<%= seleseq %>&name=<%= selename %>&type=<%= seletype %> ">下一页</a></li>
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

