<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.neusoft.ehr.entity.*" %>
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
		<title>station_dev</title>
		<meta name="author" content="new" />
		<!-- Date: 2014-07-06 -->
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
		<div class="info">
			<form name="department_update" method="post" action="DeptUpdate2Servlet.action"  id="myform">
				<table class="table table-bordered table-striped">
				<%
				Dept d = (Dept)session.getAttribute("dept");
				String date = d.getDep_date();
				StringTokenizer st=new StringTokenizer(date);
				String year = st.nextToken("-");
				String month = st.nextToken("-");
				String day = st.nextToken("-");
				 %>
					<tr>
						<th class="firstline" colspan="4">
							部门信息维护
						</th>
					</tr>
					<tr>
						<td>
							部门编号
						</td>
						<td>
							<input type="text" name="seq" id="seq" value="<%=d.getDep_seq() %>">
						</td>
						<td>
							部门名称
						</td>
						<td>
							<input type="text" name="name" id="name" value="<%=d.getDep_name()%>">
						</td>
					</tr>
					<tr>
						<td>
							部门类型
						</td>
						<td>
							<select id="type" name="type">
							
								<option >
									不限
								</option>	
									<option value="公司">
										公司</option>
									<option value="部门">
										部门</option>
										</select>
							
							
							
							
							

						</td>
						<td>
							电话
						</td>
						<td>
							<input type="text" name="tel" id="tel" value="<%=d.getDep_tel() %>">
						</td>
					</tr>
					<tr>
						<td>
							成立日期
						</td>
						<td>
							<div>
									<select class="birthsel" name="year" id="selYear"></select>
									<select class="birthsel" name="month" id="selMonth"></select>
									<select class="birthsel" name="day" id="selDay"></select>
									<script type="text/javascript">
									var selYear = window.document.getElementById("selYear");
						            var selMonth = window.document.getElementById("selMonth");
						            var selDay = window.document.getElementById("selDay");
						            new DateSelector(selYear, selMonth, selDay,<%=year%>,<%=month%>,<%=day%>);
									</script>
							 </div>							
						</td>
						<td>
							描述
						</td>
						<td>
							<input type="text" id="desc" name="desc" value="<%=d.getDep_desc() %>">
						</td>
					</tr>
					<tr>
						<td>
							上级部门
						</td>
						<td>
							<select id="updep" name="updep">
								<option value="总公司">
									总公司</option>
									<option value="分部门">
										分部门</option>
							
							</select>
						</td>
						<td>
							传真
						</td>
						<td>
							<input type="text" id="fax" name="fax" value="<%=d.getDep_fax() %>">
						</td>
					</tr>
				</table>
				<div class="lastline">
					<input class="btn btn-primary" type="button" value="确定" onclick="return fun1()">
					<script type="text/javascript">
		             function fun1(){
		                var seq = document.getElementById("seq");
		                var name = document.getElementById("name");
		                var tel = document.getElementById("tel");
		                
						var type = document.getElementById("type");
						
		                if(seq.value == ""){
		                alert("部门编号不能为空。。。");
		                return false;
		                }
		                if(name.value == ""){
		                alert("部门名称不能为空。。。");
		                return false;
		                }
		                if(type.value == "no"){
		                alert("部门类型不能为空。。。");
		                return false;
		                }
		                if(tel.value == ""){
		                alert("电话不能为空。。。");
		                return false;
		                }
		                if(selYear.value == ""||selMonth.value == ""||selDay.value == ""){
		                alert("日期不能为空。。。");
		                return false;
		                }
		                else{
		                alert("修改成功。。。");
		                document.department_update.submit();
		                return true;
		                }
		                //var myform=document.getElementById("myform");
	                    //myform.submit();
		             }
		            </script>
					<a class="btn btn-primary" href="department_info.jsp"> 返回</a>
					<input class="btn btn-primary" type="reset" value="清空">
				</div>
			</form>
		</div>

<script>
							//var type[]=document.getElementById("type");
							//alert("<%=d.getDep_type()%>");
							var type = "<%=d.getDep_type()%>";
							//alert(type);
							if(type == "公司"){
							    document.getElementById("type")[1].selected = "selected";
							}
							else if(type == "部门"){
							//alert("t1"+type);
							    document.getElementById("type")[2].selected = "selected";
							//alert("t2"+type);
							
							}
							/*if(type == "部门"){
							alert("type1");
							//alert(document.getElementById("a1").value);
							var op=document.getElementById("a1");
							eval(op.selected=true);
							 //document.getElementById("a1").selected = "selected";
							// document.getElementsByTagName("option")[2].selected = "selected";
							}
							else{
							    //alert("部门类型有错误。。。");
							}*/
							//type[2].selected = "selected";
							//document.getElementById("type")[1].selected = "selected";
							</script>
							<script>
							var updep = "<%=d.getDep_updep()%>";
							
							if(updep == "总公司"){
							    document.getElementById("updep")[0].selected = "selected";
							}
							if(updep == "分部门"){
							    document.getElementById("updep")[1].selected = "selected";
							}
							else{
							    //alert("有错误。。。");
							}
							
							</script>
	</body>
</html>

