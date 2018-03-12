<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.neusoft.ehr.entity.*" %>
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

		<title>staff_depch_report</title>
		<meta name="description" content="">
		<meta name="author" content="new">

		<meta name="viewport" content="width=device-width; initial-scale=1.0">

		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->
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
		<header>
			<ul class="breadcrumb">
				  <li>
				    <a href="#">首页</a> <span class="divider">/</span>
				  </li>
				  <li>
				    <a href="#">报表管理</a> <span class="divider">/</span>
				  </li>
				  <li class="active">部门调动员工报表</li>
				</ul>
		</header>
		<div>	
			
			<form name="department_changed" action="/neusoft/ReportDepchServlet.action">
					<table  class="table table-bordered table-striped">
						<tr>
							<th class="firstline" colspan="4">已调动部门的员工信息查询</th>
						</tr>
						<tr>
							<td>开始日期</td>
							<td>
							<div >
								<select class="birthsel" id="selYear" name="syear"></select>
								<select class="birthsel" id="selMonth" name="smonth"></select>
								<select class="birthsel" id="selDay" name="sday"></select>
								<script type="text/javascript">
								   	//alert("asd");
								   	var selYear = window.document.getElementById("selYear");
								    var selMonth = window.document.getElementById("selMonth");
								    var selDay = window.document.getElementById("selDay");
							    	new DateSelector(selYear, selMonth, selDay,1900 ,1,11);
							    </script>
						    </div>
						</td>
							<td>结束日期</td>
							<td>
							<div >
								<select class="birthsel" id="selYear1" name="eyear"></select>
								<select class="birthsel" id="selMonth1" name="emonth"></select>
								<select class="birthsel" id="selDay1" name="eday"></select>
								<script type="text/javascript">
								   	var selYear = window.document.getElementById("selYear1");
								    var selMonth = window.document.getElementById("selMonth1");
								    var selDay = window.document.getElementById("selDay1");
							    	new DateSelector(selYear, selMonth, selDay,2014,12,31);
							    </script>
						    </div>
						</td>
						</tr>
						<tr>
							<td>员工编号</td>
							<td><input type="text" name="empseq"/></td>
							<td>员工姓名</td>
							<td><input type="text" name="empname"/></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
							<td>调转类型</td>
							<td>
								<select name="type">
									<option value="">全部</option>
									<option value="升职">升职</option>
									<option value="降职">降职</option>
									<option value="其他">其他</option>
								</select>
							</td>
						</tr>
					</table>
					<div class="lastline">
						<input type="button" class="btn btn-primary" value="查询" onclick="fun88()"/>
						<input type="reset" class="btn btn-primary" value="重置"/>
						<script>
						function fun88(){
						
						document.department_changed.submit();
						}
						</script>
					</div>
				</form>
		</div>
		<div class="info">
			<form name="staff_probation" action="staff_probation.jsp">
				<table  class="table table-bordered table-striped">
				<tr>
					<th class="firstline" colspan="8">查询结果</th>
				</tr>
				<tr>
        			<th>员工编号</th>
        			<th>员工姓名</th>
        			<th>原部门名称</th>
        			<th>新部门名称</th>
        			<th>调动原因</th>
        			<th>调动类型</th>
        			<th>调动方式</th>
        			<th>调动日期</th>
        		</tr>
        		<%
        		List findList = (List)session.getAttribute("findList");
					if(findList.size()>0){
					    Iterator it = findList.iterator();
					    while(it.hasNext()){
					         Depch dc = (Depch)it.next(); 
        		 %>
        		<tr>
        			<td><%=dc.getEmp_seq() %></td>
        			<td><%=dc.getEmp_name() %></td>
        			<td><%=dc.getOld_name() %></td>
        			<td><%=dc.getDepch_name() %></td>
        			<td><%=dc.getDepch_yy() %></td>
        			<td><%=dc.getDepch_mode() %></td>
        			<td><%=dc.getDepch_class() %></td>
        			<td><%=dc.getDepch_time() %></td>
        		</tr>
        		<%} %>
				</table>
				<%}else{%></table>无查询结果
	        		<%}%>
				</form>
				</div>
				
				<div class="pagination pagination-centered pagination-small">
		<ul>
		<%
			  Page mypage=(Page)session.getAttribute("page");
              String syear =(String)session.getAttribute("syear");
              String smonth=(String)session.getAttribute("smonth");
              String sday=(String)session.getAttribute("sday");
              String eyear =(String)session.getAttribute("eyear");
              String emonth=(String)session.getAttribute("emonth");
              String eday=(String)session.getAttribute("eday");
              String empseq=(String)session.getAttribute("empseq");
              String empname=(String)session.getAttribute("empname");
              String type=(String)session.getAttribute("type");
		 
              if(mypage.isHasPrePage())
              {
               %>
			   <li><a href="ReportDepchServlet.action?currentPage=${page.currentPage -1}&syear=<%=syear %>&smonth=<%=smonth %>&sday=<%=sday %>&eyear=<%=eyear %>&emonth=<%=emonth %>&eday=<%=eday %>&empseq=<%=empseq %>&empname=<%=empname %>&type=<%=type %> ">上一页</a></li>
               <%
               }
               if(mypage.getTotalPage()<=7)
               {
               		for(int i=1;i<=mypage.getTotalPage();i++)
               		{
               	%>
               <li><a href="ReportDepchServlet.action?currentPage=<%=i%>&syear=<%=syear %>&smonth=<%=smonth %>&sday=<%=sday %>&eyear=<%=eyear %>&emonth=<%=emonth %>&eday=<%=eday %>&empseq=<%=empseq %>&empname=<%=empname %>&type=<%=type %>" id=<%=i %>><%=i %></a></li>
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
               		<li><a href="ReportDepchServlet.action?currentPage=<%=i%>&syear=<%=syear %>&smonth=<%=smonth %>&sday=<%=sday %>&eyear=<%=eyear %>&emonth=<%=emonth %>&eday=<%=eday %>&empseq=<%=empseq %>&empname=<%=empname %>&type=<%=type %>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		 <li><a href="ReportDepchServlet.action?currentPage=${page.totalPage}&syear=<%=syear %>&smonth=<%=smonth %>&sday=<%=sday %>&eyear=<%=eyear %>&emonth=<%=emonth %>&eday=<%=eday %>&empseq=<%=empseq %>&empname=<%=empname %>&type=<%=type %>">末页</a></li>
               		<%
               		}
               		else if((mypage.getTotalPage()-mypage.getCurrentPage())<=3)
               		{
               		%>
               		 <li><a href="ReportDepchServlet.action?currentPage=1&syear=<%=syear %>&smonth=<%=smonth %>&sday=<%=sday %>&eyear=<%=eyear %>&emonth=<%=emonth %>&eday=<%=eday %>&empseq=<%=empseq %>&empname=<%=empname %>&type=<%=type %>">首页</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getTotalPage()-6;i<=mypage.getTotalPage();i++)
               			{
               		%>
               		<li><a href="ReportDepchServlet.action?currentPage=<%=i%>&syear=<%=syear %>&smonth=<%=smonth %>&sday=<%=sday %>&eyear=<%=eyear %>&emonth=<%=emonth %>&eday=<%=eday %>&empseq=<%=empseq %>&empname=<%=empname %>&type=<%=type %>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		
               		}    
               		else
               		{
               		%>
               		 <li><a href="ReportDepchServlet.action?currentPage=1&syear=<%=syear %>&smonth=<%=smonth %>&sday=<%=sday %>&eyear=<%=eyear %>&emonth=<%=emonth %>&eday=<%=eday %>&empseq=<%=empseq %>&empname=<%=empname %>&type=<%=type %>">首页</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getCurrentPage()-3;i<=mypage.getCurrentPage()+3;i++)
               			{
               		%>
               		<li><a href="ReportDepchServlet.action?currentPage=<%=i%>&syear=<%=syear %>&smonth=<%=smonth %>&sday=<%=sday %>&eyear=<%=eyear %>&emonth=<%=emonth %>&eday=<%=eday %>&empseq=<%=empseq %>&empname=<%=empname %>&type=<%=type %>" id=<%=i %>><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		<li><a href="ReportDepchServlet.action?currentPage=${page.totalPage}&syear=<%=syear %>&smonth=<%=smonth %>&sday=<%=sday %>&eyear=<%=eyear %>&emonth=<%=emonth %>&eday=<%=eday %>&empseq=<%=empseq %>&empname=<%=empname %>&type=<%=type %>">末页</a></li>
               		<%
               		}           
               }
              if(mypage.isHasNextPage())
              {
               %>
                <li><a href="ReportDepchServlet.action?currentPage=${page.currentPage +1}&syear=<%=syear %>&smonth=<%=smonth %>&sday=<%=sday %>&eyear=<%=eyear %>&emonth=<%=emonth %>&eday=<%=eday %>&empseq=<%=empseq %>&empname=<%=empname %>&type=<%=type %> ">下一页</a></li>
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
				
	</body>
</html>

