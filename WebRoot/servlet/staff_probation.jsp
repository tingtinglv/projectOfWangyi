<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.neusoft.ehr.entity.*"%>
<%@ page import="com.neusoft.ehr.comm.*" %>

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

		<title>staff_probation</title>
		<meta name="description" content="">
		<meta name="author" content="MarsDmo">

		<meta name="viewport" content="width=device-width; initial-scale=1.0">

		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->
		<link rel="shortcut icon" href="/favicon.ico">
		<link rel="apple-touch-icon" href="/apple-touch-icon.png">

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
		
		
		<script type="text/javascript" src="/neusoft/js/page.js"></script>
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
				  <li class="active">员工试用期管理</li>
				</ul>
		</header>
		<%
			String empSeq=(String)request.getAttribute("empSeq");
			String empName = (String)request.getAttribute("empName") ;
			String depName = (String)request.getAttribute("depName") ;
			String postName = (String)request.getAttribute("postName") ;
			String startDate = (String)request.getAttribute("startDate");
			String endDate = (String)request.getAttribute("endDate");
			String dateFlag = (String)request.getAttribute("dateFlag");
			String result = (String)request.getAttribute("result");
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
			<form name="staffProbation" action="StaffProbationServlet.action" method="post">
				<table  class="table table-bordered table-striped">
					<tr>
						<th class="firstline" colspan="4">试用期员工查询</th>
					</tr>
					<tr>
						<td>员工编号</td>
						<td>
						<input type="text" id="empSeq" name="empSeq" value="<%=empSeq %>"/>
						</td>
						<td>员工姓名</td>
						<td>
						<input type="text" id="empName" name="empName" value="<%=empName %>"/>
						</td>
					</tr>
					<tr>
						<td>部门名称</td>
						<td>
						<input type="text" id="depName" name="depName" value="<%=depName %>"/>
						</td>
						<td>岗位名称</td>
						<td>
						<input type="text" id="postName" name="postName" value="<%=postName %>"/>
						</td>
					</tr>
					<tr>
						<td>试用期</td>
						<td>
							<input type="text" class="span2" id="startDate" name="startDate"  data-date-format="yyyy-mm-dd" value="<%=startDate %>"/>
							<input type="text" class="span2" id="endDate" name="endDate" data-date-format="yyyy-mm-dd" value="<%=endDate %>"/>
						</td>
						<td>试用状态</td>
						<td>
							<select >
								<option name="result" style="color:#aaa">--请选择--</option>
								<option name="result" value="正常">正常</option>
								<option name="result" value="延期">延期</option>
								<option name="result" value="不录用">不录用</option>
							</select>
						</td>
					</tr>
				</table>
				<div class="lastline">
					<div id="prob">
						<input name="dateFlag" value="start" type="radio">按试用期开始日期查询&nbsp;&nbsp;
						<input name="dateFlag" value="btw" type="radio">按试用期区间查询&nbsp;&nbsp;
						<input name="dateFlag" value="end" type="radio" checked="checked">按试用期结束日期查询
					</div>
					<div>
						<input type="submit" class="btn btn-primary" value="查询"/>
						<input type="reset" class="btn btn-primary" value="清空"/>
					</div>
				</div>
			</form>
			<form name="hideInfo" action="StaffProbationServlet.action" method="post">
				<input type="hidden" id="empSeq" name="empSeq" value="<%=empSeq%>"/>
				<input type="hidden" id="empName" name="empName" value="<%=empName%>"/>
				<input type="hidden" id="depName" name="depName" value="<%=depName%>"/>
				<input type="hidden" id="postName" name="postName" value="<%=postName%>"/>
				<input type="hidden" id="startDate" name="startDate"  value="<%=startDate %>"/>
				<input type="hidden" id="endDate" name="endDate" value="<%=endDate %>"/>
				<input type="hidden" id="dateFlag" name="dateFlag" value="<%=dateFlag %>"/>
				<input type="hidden" id="result" name="result" value="<%=result %>"/>
				<input type="hidden" id="curPage" name="curPage" value="<%=curPage %>"/>
			</form>
			</div>
			
		<form name="staffReview" action="StaffReviewServlet.action" method="post">
			<div id="probationModal" class="modalinfo hide fade">
				<div class="modal-header" style="text-align:center">
					<a class="close" data-dismiss="modal">&times;</a>
					<h3>试用期评价</h3>
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
						<td>试用开始日期</td>
						<td><input type="text" readonly id="modalStartDate" name="modalStartDate" /></td>
						<td>试用结束日期</td>
						<td><input type="text" readonly id="modalEndDate" name="modalendDate" /></td>
					</tr>
					<tr>
						<td>试用状态</td>
						<td>
							<select name="result">	
								<option  style="color:#aaa">--请选择--</option>
								<option  value="试用">试用</option>
								<option  value="延期">延期</option>
								<option  value="转正">转正</option>
								<option  value="不录用">不录用</option>
							</select>
						</td>
						<td>选择延迟日期</td>
						<td><input type="text"  id="delayDate" name="delayDate" data-date-format="yyyy-mm-dd"/></td>
					</tr>
					<tr>
						<td>评价</td>
						<td><textarea class="input-xlarge" id="reviews" name="reviews"></textarea></td>
						<td>备注</td>
						<td><textarea  class="input-xlarge" id="remark" name="remark"></textarea></td>
					</tr>
				</table>
					<input type="hidden" id="empSeq" name="empSeq" value="<%=empSeq%>"/>
					<input type="hidden" id="empName" name="empName" value="<%=empName%>"/>
					<input type="hidden" id="depName" name="depName" value="<%=depName%>"/>
					<input type="hidden" id="postName" name="postName" value="<%=postName%>"/>
					<input type="hidden" id="startDate" name="startDate"  value="<%=startDate %>"/>
					<input type="hidden" id="endDate" name="endDate" value="<%=endDate %>"/>
					<input type="hidden" id="dateFlag" name="dateFlag" value="<%=dateFlag %>"/>
					<input type="hidden" id="curPage" name="curPage" value="<%=curPage %>"/>
				</div>
			<div class="modal-footer">
				<input type="button" id="reviewSure" class="btn btn-primary" value="确定" >
			</div>
		</div>
		</form>
			<div class="info">
			<form name="staff_info" action="staff_info_maintain.jsp">
				<table  class="table table-bordered table-striped">
					<tr>
						<th  class="firstline" colspan="10">查询结果</th>
					</tr>
					<tr>
						<th>员工编号</th>
						<th>姓名</th>
						<th>部门名称</th>
						<th>岗位名称</th>
						<th>试用起始日期</th>
						<th>试用截止日期</th>
						<th>试用状态</th>
						<th>评价</th>
						<th>备注</th>
						<th>操作</th>
					</tr>
					<%
						List<Probation> pbList=(List<Probation>)request.getAttribute("pbList");
						Page p=(Page)request.getAttribute("page");
						int ep=p.getEveryPage();
						if(pbList.size()>0){
						    Iterator it = pbList.iterator();
						    while(it.hasNext()){
						    	ep--;
						        Probation pb = (Probation)it.next(); 
					 %>
					<tr>
						<td id="tdEmpSeq<%=ep%>"><%=pb.getEmpSeq() %></td>
						<td id="tdEmpName<%=ep%>"><%=pb.getEmpName() %></td>
						<td><%=pb.getDepName() %></td>
						<td><%=pb.getPostName() %></td>
						<td id="tdStartDate<%=ep%>"><%=pb.getStartDate() %></td>
						<td id="tdEndDate<%=ep%>"><%=pb.getEndDate() %></td>
						<td><%=pb.getResult() %></td>
						<td id="tdReviews<%=ep%>"><%=pb.getReviews()==null?"":pb.getReviews() %></td>
						<td id="tdRemark<%=ep%>"><%=pb.getRemark()==null?"":pb.getRemark() %></td>
						<td><input type="button" value="评价" class="btn btn-primary" onclick="reviewInfo('<%=ep %>')"/></td>
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
						<td></td>
						<td></td>
						<td></td>
					 </tr>
					 <%}%>
				</table>
			</form>
			<div id="modalPop" class="modalpop hide fade">
				<div class="modal-body" >
					<a class="close" data-dismiss="modal" >&times;</a>
					<div id=warning></div>
				</div>
			</div>"
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
