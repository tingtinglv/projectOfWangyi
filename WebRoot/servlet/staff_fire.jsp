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

		<title>staff_fire</title>
		<meta name="description" content="">
		<meta name="author" content="MarsDmo">

		<meta name="viewport" content="width=device-width; initial-scale=1.0">

		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->
		<link href="/neusoft/css/bootstrap.css" rel="stylesheet">
		<link href="/neusoft/css/staff.css" rel="stylesheet" type="text/css" />
		<link href="/neusoft/css/datepicker.css" rel="stylesheet" type="text/css" />

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
		
		<script type="text/javascript" src="js/page.js"></script>
		<script type="text/javascript" src="/neusoft/js/momo.js"></script>
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
			<form name="staffInfo" action="StaffFireServlet.action" method="post">
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
			<form name="hideInfo" action="StaffFireServlet.action" method="post">
				<input type="hidden" id="empSeq" name="empSeq" value="<%=empSeq%>"/>
				<input type="hidden" id="empName" name="empName" value="<%=empName%>"/>
				<input type="hidden" id="depName" name="depName" value="<%=depName%>"/>
				<input type="hidden" id="postName" name="postName" value="<%=postName%>"/>
				<input type="hidden" id="curPage" name="curPage" value="<%=curPage %>"/>
			</form>
		</div>
		<form name="staffFire" action="StaffFireingServlet.action" method="post">
			<div id="fireModal" class="modalinfo hide fade">
				<div class="modal-header" style="text-align:center">
					<a class="close" data-dismiss="modal">&times;</a>
					<h3>离职处理</h3>
				</div>
				<div class="modal-body" style="text-align:center">
					<table  class="table table-bordered table-striped">
						<tr>
							<td>员工编号</td>
							<td><input type="text" readonly id="modalEmpSeq" name="modalEmpSeq"/></td>
							<td>员工姓名</td>
							<td><input type="text" readonly id="modalEmpName" name="modalEmpName"/></td>
						</tr>
						<tr>
							<td>离职日期</td>
							<td><input type="text"  id="firedDate" name="firedDate" data-date-format="yyyy-mm-dd"/></td>
							<td>离职类型</td>
							<td>
								<select name="firedType">	
									<option  style="color:#aaa">--请选择--</option>
									<option  value="主动辞职">主动辞职</option>
									<option  value="辞退">辞退</option>
									<option  value="退休">退休</option>
									<option  value="开除">开除</option>
									<option  value="试用期未通过">试用期未通过</option>
								</select><br/>
							</td>
						</tr>
						<tr>
							<td colspan="4">是否进入人才库
							<input name="humanResource" id="typeYes" value="是" type="radio" >是&nbsp;&nbsp;
							<input name="humanResource" value="否" type="radio" checked="checked"/>否
							</td>
						</tr>
						<tr>
							<td>离职去向</td>
							<td><textarea class="input-xlarge" name="firedTraced"></textarea></td>
							<td>备注</td>
							<td><textarea  class="input-xlarge" name="firedMemo"></textarea></td>
						</tr>
					</table>
					<input type="hidden" id="empSeq" name="empSeq" value="<%=empSeq%>"/>
					<input type="hidden" id="empName" name="empName" value="<%=empName%>"/>
					<input type="hidden" id="depName" name="depName" value="<%=depName%>"/>
					<input type="hidden" id="postName" name="postName" value="<%=postName%>"/>
					<input type="hidden" id="curPage" name="curPage" value="<%=curPage %>"/>
				</div>
				<div class="modal-footer">
					<input type="button" id="firedSure" name="firedSure"  class="btn btn-primary" value="确定" data-dismiss="modal">
				</div>
			</div>
		</form>
		<div class="info">
			<form name="staff_probation" action="staff_probation.jsp">
				<table  class="table table-bordered table-striped">
					<tr>
						<th  class="firstline" colspan="6">查询结果</th>
					</tr>
					<tr>
						<th>员工编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>部门</th>
						<th>岗位</th>
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
						<td id="tdEmpSeq<%=ep %>"><%=s.getEmpSeq() %></td>
						<td id="tdEmpName<%=ep %>"><%=s.getEmpName() %></td>
						<td><%=s.getEmpSex() %></td>
						<td><%=s.getDepName() %></td>
						<td><%=s.getPostName() %></td>
						<td><input type="button" value="离职" class="btn btn-primary" onclick="fireInfo('<%=ep %>')"/></td>
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
