<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.neusoft.ehr.entity.Fired" %>
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

		<title>staff_fire</title>
		<meta name="description" content="">
		<meta name="author" content="MarsDmo">

		<meta name="viewport" content="width=device-width; initial-scale=1.0">

		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->
		<link href="/neusoft/css/bootstrap.css" rel="stylesheet">
		<link href="/neusoft/css/staff.css" rel="stylesheet" type="text/css" />
		<link href="/neusoft/css/datepicker.css" rel="stylesheet">

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
		<script src="/neusoft/js/bootstrap-datepicker.js" ></script>
		<script type="text/javascript" src = "/neusoft/js/momo.js"></script>
		<script type="text/javascript" src="js/page.js"></script>
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
				  <li class="active">员工离职管理</li>
				</ul>
		</header>
		
		<%
			String empSeq=(String)request.getAttribute("empSeq");
			String empName = (String)request.getAttribute("empName") ;
			String depName = (String)request.getAttribute("depName") ;
			String postName = (String)request.getAttribute("postName") ;
			String startDate = (String)request.getAttribute("startDate");
			String endDate = (String)request.getAttribute("endDate");
			String firedType = (String)request.getAttribute("firedType");
			int curPage = (Integer)request.getAttribute("curPage");
			if(empSeq==null)
				empSeq="";
			if(empName==null)
				empName="";
			if(postName==null)
				postName="";
			if(depName==null)
				depName="";
			if(startDate==null)
				startDate="";
			if(endDate==null)
				endDate="";
		 %>
		<div class="query">
    		<form name="staff_probation" action="StaffFiredServlet.action" method="post">
				<table  class="table table-bordered table-striped">
					<tr>
						<th class="firstline" colspan="6">已离职员工信息查询</th>
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
					<tr>
						<td>离职日期区间</td>
						<td>
							<input type="text" class="span2" id="startDate" data-date-format="yyyy-mm-dd" name="startDate" value="<%=startDate %>"/>
							<input type="text" class="span2" id="endDate" data-date-format="yyyy-mm-dd" name="endDate" value="<%=endDate %>"/>
						</td>
						<td>离职类型</td>
						<td>
						<select name="firedType">
							<option value="" style="color:#aaa">--请选择--</option>
							<option value="主动辞职">主动辞职</option>
							<option value="辞退">辞退</option>
							<option value="退休">退休</option>
							<option value="开除">开除</option>
							<option value="试用期未通过">试用期未通过</option>
						</select>
						</td>
					</tr>
				</table>
				<div class="lastline">
					<input type="submit" class="btn btn-primary" value="查询"/>
					<input type="reset" class="btn btn-primary" value="清空"/>
				</div>
			</form>
			<form name="hideInfo" action="StaffFiredServlet.action" method="post">
				<input type="hidden" id="empSeq" name="empSeq" value="<%=empSeq%>"/>
				<input type="hidden" id="empName" name="empName" value="<%=empName%>"/>
				<input type="hidden" id="depName" name="depName" value="<%=depName%>"/>
				<input type="hidden" id="postName" name="postName" value="<%=postName%>"/>
				<input type="hidden" id="depName" name="depName" value="<%=startDate%>"/>
				<input type="hidden" id="postName" name="postName" value="<%=endDate%>"/>
				<input type="hidden" id="postName" name="postName" value="<%=firedType%>"/>
				<input type="hidden" id="curPage" name="curPage" value="<%=curPage %>"/>
			</form>
			</div>
			<div class="info">
			<form name="staff_probation" action="staff_probation.jsp">
				<table  class="table table-bordered table-striped">
					<tr>
						<th  class="firstline" colspan="7">查询结果</th>
					</tr>
					<tr>
						<th>员工编号</th>
						<th>姓名</th>
						<th>离职日期</th>
						<th>离职类型</th>
						<th>离职去向</th>
						<th>是否进入人才库</th>
						<th>备注</th>
					</tr>
					<%
					List<Fired> fList=(List<Fired>)request.getAttribute("fList");
					Page p=(Page)request.getAttribute("page");
					int ep=p.getEveryPage();
					if(fList.size()>0){
					    Iterator it = fList.iterator();
					    while(it.hasNext()){
					    	ep--;
					        Fired f = (Fired)it.next(); 
					 %>
					<tr>
						<td><%=f.getEmpSeq() %></td>
						<td><%=f.getEmpName() %></td>
						<td><%=f.getFiredDate() %></td>
						<td><%=f.getFiredType() %></td>
						<td><%=f.getFiredTraced() %></td>
						<td><%=f.getHumanResource() %></td>
						<td><%=f.getFiredMemo() %></td>
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
