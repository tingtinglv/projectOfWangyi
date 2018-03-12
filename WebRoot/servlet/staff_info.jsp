<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="com.neusoft.ehr.entity.Staff" %>
<%@ page import="com.neusoft.ehr.comm.Page" %>
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

		<title>staff_info</title>
		<meta name="description" content="">
		<meta name="author" content="MarsDmo">

		<meta name="viewport" content="width=device-width; initial-scale=1.0">

		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->
		<link href="/neusoft/css/bootstrap.css" rel="stylesheet">
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
		
		<script type="text/javascript" src="/neusoft/js/page.js"></script>
	</head>

	<body>
		<header>
			<ul class="breadcrumb">
				  <li>
				    <a href="#">首页</a> <span class="divider">/</span>
				  </li>
				  <li>
				    <a href="#">员工管理</a> <span class="divider">/</span>
				  </li>
				  <li class="active">员工信息中心</li>
				</ul>
		</header>
		<%
			String empSeq=(String)request.getAttribute("empSeq");
			String empName = (String)request.getAttribute("empName") ;
			String depName = (String)request.getAttribute("depName") ;
			String postName = (String)request.getAttribute("postName") ;
			int curPage = (Integer)request.getAttribute("curPage");
			if(empSeq==null)
				empSeq="";
			if(empName==null)
				empName="";
			if(postName==null)
				postName="";
			if(depName==null)
				depName="";
		 %>
		<div class="query">
			<form name="staffInfo" action="StaffFindServlet.action" method="post">
				<table  class="table table-bordered table-striped">
					<tr>
						<th class="firstline" colspan="4">员工查询</th>
					</tr>
					<tr>
						<td>员工编号</td>
						<td>
						<input type="text" id="empSeq" name="empSeq" value="<%=empSeq%>"/>
						</td>
						<td>员工姓名</td>
						<td>
						<input type="text" id="empName" name="empName" value="<%=empName%>"/>
						</td>
					</tr>
					<tr>
						<td>部门名称</td>
						<td>
						<input type="text" id="depName" name="depName" value="<%=depName%>"/>
						</td>
						<td>岗位名称</td>
						<td>
						<input type="text" id="postName" name="postName" value="<%=postName%>"/>
						</td>
					</tr>
				</table>
				<div class="lastline">
					<input type="submit" class="btn btn-primary" id="query"value="查询" />
					<input type="reset" class="btn btn-primary" value="清空"/>
				</div>
			</form>
			<form name="hideInfo" action="StaffFindServlet.action" method="post">
				<input type="hidden" id="empSeq" name="empSeq" value="<%=empSeq%>"/>
				<input type="hidden" id="empName" name="empName" value="<%=empName%>"/>
				<input type="hidden" id="depName" name="depName" value="<%=depName%>"/>
				<input type="hidden" id="postName" name="postName" value="<%=postName%>"/>
				<input type="hidden" id="curPage" name="curPage" value="<%=curPage %>"/>
			</form>
		</div>
		<div class="info">
			<form name="staff_probation" action="staff_probation.jsp" method="post">
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
						<th>学位</th>
						<th >操作</th>
					</tr>
					<%
					List<Staff> staffList=(List<Staff>)request.getAttribute("staffList");
					Page p=(Page)request.getAttribute("page");
					int ep=p.getEveryPage();
					if(staffList.size()>0){
					    Iterator it = staffList.iterator();
					    while(it.hasNext()){
					    	ep--;
					        Staff s = (Staff)it.next(); 
					 %>
					<tr>
						<td><%=s.getEmpSeq() %></td>
						<td><%=s.getEmpName() %></td>
						<td><%=s.getEmpSex() %></td>
						<td><%=s.getDepName() %></td>
						<td><%=s.getPostName() %></td>
						<td><%=s.getDegree() %></td>
						<td>
					<a class="btn btn-primary"  href="StaffMaintainServlet.action?empSeq=<%=s.getEmpSeq() %>">信息维护</a>
					</td>
					</tr>
					<% }
					}
						for(int i=0;i<ep;i++){
					 %>
					 <tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					 </tr>
					 <%}%>
				</table>
			</form>
			<div class="pagination pagination-centered">
              <ul>
               <li><a href="#" onclick="firstPage()">首页</a></li>
			    <li><a href="#" onclick="proPage()">上一页</a></li>
			    <%for(int i=0;i<p.getTotalPage();i++) {%>
			    <li><a href="#" onclick="nPage(<%=i+1 %>)" id="<%=i+1 %>"><%=i+1 %></a></li>
			    <%} %>
			    <li><a href="#" onclick="nextPage(<%=p.getTotalPage() %>)">下一页</a></li>
			    <li><a href="#" onclick="lastPage(<%=p.getTotalPage() %>)">末页</a></li>
			    </ul>
            </div>
		</div>
	</body>
</html>
