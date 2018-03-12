<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.neusoft.ehr.entity.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.neusoft.ehr.comm.Page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">

		<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

		<title>Administrator</title>
		<meta name="description" content="">
		<meta name="author" content="MarsDmo">

		<meta name="viewport" content="width=device-width; initial-scale=1.0">

		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->

		<link href="/neusoft/css/bootstrap.css" rel="stylesheet">
		<link href="/neusoft/css/staff.css" rel="stylesheet" type="text/css" />
		 <link rel="stylesheet" href="/neusoft/css/home.css"  type="text/css"/>
	 
		 
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
		<script src="/neusoft/js/admin.js"></script>
		<script type="text/javascript" src="/neusoft/js/year_month_day.js"></script><!--����������-->
	</head>
	
<%
	List<User> userlist = (List)session.getAttribute("userlist");
	Iterator<User> it = userlist.iterator();
	Page mypage = (Page)request.getAttribute("page");
	
	int startYear, startMonth, startDay, endYear, endMonth, endDay,currentPage;
	
	String startYearstr=(String)session.getAttribute("startYear");
	String startMonthstr=(String)session.getAttribute("startMonth");
	String startDaystr =(String)session.getAttribute("startDay");
	String endYearstr=(String)session.getAttribute("endYear");
	String endMonthstr=(String)session.getAttribute("endMonth");
	String endDaystr=(String)session.getAttribute("endDay");
	String userName=(String)session.getAttribute("userName");
	String userActiveState=(String)session.getAttribute("userActiveState");
	String timeType=(String)session.getAttribute("timeType");
	String currentPagestr =(String)session.getAttribute("currentPage");
	
	if(userName==null||"".equals(userName))
		{
			userName="";
		}
		if(userActiveState==null||userActiveState.equals(""))
		{
			userActiveState ="none";
		}
		
		if(startYearstr==null||"0".equals(startYearstr))
		{
			startYear=2014;
		}
		else
		{
			startYear=Integer.parseInt(startYearstr);
		}
		
		if(startMonthstr==null||"0".equals(startMonthstr))
		{
			startMonth=7;
		}
		else
		{
			startMonth=Integer.parseInt(startMonthstr);
		}
		
		if(startDaystr==null||"0".equals(startDaystr))
		{
			startDay=22;
		}
		else
		{
			startDay=Integer.parseInt(startDaystr);
		}
		
		if(endYearstr==null||"0".equals(endYearstr))
		{
			endYear=2014;
		}
		else
		{
			endYear=Integer.parseInt(endYearstr);
		}
		if(endMonthstr==null||"0".equals(endMonthstr))
		{
			endMonth=7;
		}
		else
		{
			endMonth=Integer.parseInt(endMonthstr);
		}
		if(endDaystr==null||"0".equals(endDaystr))
		{
			endDay=23;
		}
		else
		{
			endDay=Integer.parseInt(endDaystr);
		}
		if(currentPagestr==null||"".equals(currentPagestr))
		{
			currentPage=1;
		}
		else
		{
			currentPage=Integer.parseInt(currentPagestr);
		}
		if(timeType==null||timeType.equals(""))
		{
			timeType="notbytime";
		}
		
%>
  
 <body>
		<div id="t3zrytopdv1">
			<img  src="/neusoft/imgs/Neusoft.jpg"/>
			<img id="headerimg1" src="/neusoft/imgs/c.png" />
		</div>
		<div id="t3zrytopdv2">
		<%
			String uname ="";
			uname = (String)session.getAttribute("uname"); 
			int uid = 0;
			 uid =Integer.parseInt((String)session.getAttribute("uid")); 
		 %>
			����:&nbsp;<%=uname %> &nbsp;
			<span id="time"></span>&nbsp;&nbsp;&nbsp;
			<script>
			function time1() {
				var date = new Date();
				document.getElementById("time").innerHTML =date.getFullYear() + "��" + (date.getMonth() + 1) + "��" + date.getDate() + "��" + "   " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
				setTimeout("time1()", 1000);
			}
			time1();
			</script>
			<a class="btn btn-primary" href="#">��Ϣά��</a>
			<a class="btn btn-primary" href="UserUnloginServlet?uid=<%=uid %>" onClick="return confirm('ȷ���˳���')" target="_parent">�˳�</a>
		</div><br>
		
		<div class="query">
			<form name="adminform" action="UserListServlet.do" method="post">
				<table  class="table table-bordered table-striped">
					<tr>
						<th class="firstline" colspan="4">��ѯ����</th>
					</tr>
					<tr>
						<td>�˺�</td>
						<td><input type="text" name="userName" id="userName"/></td>
						<script>
						var userName= document.getElementById("userName");
						userName.value="<%=userName%>";
						</script>
						<td>��Ȩ״̬</td>
						<td>
							<select name ="userActiveState" id = "userActiveSel">
								<option value="none">������Ȩ��ѯ</option>
								<option value="unactive">δ��Ȩ</option>
								<option value="active">����Ȩ</option>
							</select>
							<%
							if(userActiveState.equals("none"))
							{
							%>
							<script>
							var userActiveState = document.getElementById("userActiveSel");
							userActiveState[0].selected = "selected";
							</script>
							<%
							}
							else if(userActiveState.equals("unactive"))
							{
							%>
							<script>
							 var userActiveState = document.getElementById("userActiveSel");
							userActiveState[1].selected = "selected";
							</script>
							<%
							}
							else if(userActiveState.equals("active"))
							{
							%>
							<script>
							var userActiveState = document.getElementById("userActiveSel");
							userActiveState[2].selected = "selected";
							</script>
							<%
							}
							 %>
						</td>
					</tr>
					<tr>
						<td>��ʼʱ��</td>
						<td>
						<div class="" id = "divStartDateError">
						
							<select class="birthsel" id="selYear" name = "startYear" onclick="resetcolor('divStartDateError','divEndDateError')"></select>
							<select class="birthsel" id="selMonth" name = "startMonth" onclick="resetcolor('divStartDateError','divEndDateError')"></select>
							<select class="birthsel" id="selDay" name = "startDay" onclick="resetcolor('divStartDateError','divEndDateError')"></select>
							<script type="text/javascript">
							   	var selYear = window.document.getElementById("selYear");
							    var selMonth = window.document.getElementById("selMonth");
							    var selDay = window.document.getElementById("selDay");
						    	new DateSelector(selYear, selMonth, selDay, <%=startYear%>,<%=startMonth%>,<%=startDay%>);
						    </script>
						
						</div>
						</td>
						<td>����ʱ��</td>
						<td>
							<div class="" id = "divEndDateError">
								<select class="birthsel" id="selYear1" name ="endYear" onclick="resetcolor('divStartDateError','divEndDateError')"></select>
								<select class="birthsel" id="selMonth1" name = "endMonth" onclick="resetcolor('divStartDateError','divEndDateError')"></select>
								<select class="birthsel" id="selDay1" name = "endDay" onclick="resetcolor('divStartDateError','divEndDateError')"></select>
								<script type="text/javascript">
								   	var selYear = window.document.getElementById("selYear1");
								    var selMonth = window.document.getElementById("selMonth1");
								    var selDay = window.document.getElementById("selDay1");
							    	new DateSelector(selYear, selMonth, selDay, <%=endYear%>,<%=endMonth%>,<%=endDay%>);
							    </script>
						    </div>
						</td>
						<input type = "hidden" name="currentPageNum" id ="currentPageNum" value=<%=mypage.getCurrentPage()+"" %>><!-- �˴����ڴ���Ŀ��ҳ���ҳ�Ų������������� -->
					</tr>
					
				</table>
				<div class="lastline">
					<select class="span2" name="timeType" id ="timeTypeSel" >
						<option value="notbytime">����ʱ���ѯ</option>
						<option value="bytime">����ʱ���ѯ</option>
					</select>
					<%
						if(timeType.equals("notbytime"))
						{
						%>
						<script type="text/javascript">
						var userActiveState = document.getElementById("timeTypeSel");
							userActiveState[0].selected = "selected";
						</script>
						<%
						}
						else if(timeType.equals("bytime"))
						{
						%>
						<script type="text/javascript">
						var userActiveState = document.getElementById("timeTypeSel");
							userActiveState[1].selected = "selected";
						</script>
						<%
						}
					 %>
					&nbsp;		
					<input type="button" class="btn btn-primary" value="��ѯ" onclick="inquery()"/>			
					<input type="reset" class="btn btn-primary" value="���" onclick="resetall()"/>
					
				</div>
			</form>
		</div>
		
		<div class="info">
			<form name="staff_info" action="staff_info_maintain.jsp">
				<table  class="table table-bordered table-striped">
					<tr>
						<th  class="firstline" colspan="7">��ѯ���</th>
					</tr>
					<tr>
						<th>��&nbsp;&nbsp;&nbsp;&nbsp;��</th>
						<th>��&nbsp;&nbsp;&nbsp;&nbsp;�� </th>
						<th>��Ȩ״̬</th>
						<th>Email</th>
						<th>ע��ʱ��</th>
						<th colspan="2">����&nbsp;&nbsp;&nbsp;&nbsp; </th>
					</tr>
<%
	while(it.hasNext())
	{
		User u = it.next();
		String activestate;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		String resultDate=sdf.format(u.getRegistDate());//��ȡע��ʱ��
		if(u.getActiveState().equals("unactive"))
		{
			activestate="δ��Ȩ";
		}
		else
		{
			activestate="����Ȩ";
		}
%>
					<tr>
						<td><%=u.getUname() %></td>
						<td><%=u.getPwd() %></td>
						<td><%=activestate %></td>
						<td><%=u.getEmail() %></td>
						<td><%=resultDate %></td>
						<td>
						<%
						if(activestate.equals("����Ȩ"))
						{
						 %>
						 <a href = "UserActiveServlet.do?uid=<%=u.getUid()%>&startYear=<%=startYear%>&startMonth=<%=startMonth %>&startDay=<%=startDay%>&endYear=<%=endYear%>&endMonth=<%=endMonth%>&endDay=<%=endDay%>&currentPage=<%=currentPage%>&userActiveState=<%=userActiveState%>&timeType=<%=timeType%>&userName=<%=userName%>" onClick="return confirm('ȡ����Ȩ��')" >ȡ����Ȩ</a>
						 
						 <%
						 }
						 else
						 {
						  %>
						 <a href = "UserActiveServlet.do?uid=<%=u.getUid()%>&startYear=<%=startYear%>&startMonth=<%=startMonth %>&startDay=<%=startDay%>&endYear=<%=endYear%>&endMonth=<%=endMonth%>&endDay=<%=endDay%>&currentPage=<%=currentPage%>&userActiveState=<%=userActiveState%>&timeType=<%=timeType%>&userName=<%=userName%>" onClick="return confirm('ȷ����Ȩ��')">��Ȩ</a>
						  <%
						  }
						   %>
						</td>
						<td><a href="UserDelServlet.do?uid=<%=u.getUid()%>&startYear=<%=startYear%>&startMonth=<%=startMonth %>&startDay=<%=startDay%>&endYear=<%=endYear%>&endMonth=<%=endMonth%>&endDay=<%=endDay%>&currentPage=<%=currentPage%>&userActiveState=<%=userActiveState%>&timeType=<%=timeType%>&userName=<%=userName%>" onClick="return confirm('ȷ��ɾ����')">ɾ��</a></td>
					</tr>
						<%
							}
						%>
					
				</table>
				<div class="lastline">
				</div>
					
			</form>
			
		</div>
		<div class="pagination pagination-centered pagination-small">
		<ul>
		<%
			
		 
              if(mypage.isHasPrePage())
              {
               %>
			   <li><a href="#" onclick="jumptoPage(<%=mypage.getCurrentPage()-1%>)">��һҳ</a></li>
               <%
               }
               if(mypage.getTotalPage()<=7)
               {
               		for(int i=1;i<=mypage.getTotalPage();i++)
               		{
               	%>
               	<li><a href="#" id="<%=i%>" onclick="jumptoPage(<%=i%>)"><%=i %></a></li>
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
               		<li><a href="#" id="<%=i%>" onclick="jumptoPage(<%=i%>)"><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		<li><a href="#" onclick="jumptoPage(<%=mypage.getTotalPage()%>)"><%=mypage.getTotalPage()%></a></li>
               		<%
               		}
               		else if((mypage.getTotalPage()-mypage.getCurrentPage())<=3)
               		{
               		%>
               		<li><a href="#" onclick="jumptoPage(1)">1</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getTotalPage()-6;i<=mypage.getTotalPage();i++)
               			{
               		%>
               		<li><a href="#" id="<%=i%>" onclick="jumptoPage(<%=i%>)"><%=i %></a></li>
               		<%
               			}
               		
               		}    
               		else
               		{
               		%>
               		<li><a href="#" onclick="jumptoPage(1)">1</a></li>
               		<li><a href="#">...</a></li>
               		<%
               			for(int i =mypage.getCurrentPage()-3;i<=mypage.getCurrentPage()+3;i++)
               			{
               		%>
               		<li><a href="#" id="<%=i%>" onclick="jumptoPage(<%=i%>)"><%=i %></a></li>
               		<%
               			}
               		%>
               		<li><a href="#">...</a></li>
               		<li><a href="#" onclick="jumptoPage(<%=mypage.getTotalPage()%>)"><%=mypage.getTotalPage()%></a></li>
               		<%
               		}           
               }
              if(mypage.isHasNextPage())
              {
               %>
               <li><a href="#" onclick="jumptoPage(<%=mypage.getCurrentPage()+1%>)" >��һҳ</a></li>
               <%
               }
                %>
		</ul>
            </div>
	</body>
</html>
</html>
