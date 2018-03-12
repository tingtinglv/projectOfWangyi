<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>top</title>
		<meta name="author" content="new" />
		<link href="/neusoft/css/bootstrap.css" rel="stylesheet">
	    <link rel="stylesheet" href="../css/home.css"  type="text/css"/>
	    
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
		<!-- Date: 2014-07-06 -->
	</head>
	<body>
		<div id="t3zrytopdv1">
			<img  src="/neusoft/imgs/Neusoft.jpg"/>
			<img id="headerimg1" src="/neusoft/imgs/c.png" />
		</div>
		<%
			String uname ="";
			uname = (String)session.getAttribute("uname"); 
			int uid = 0;
			 uid =Integer.parseInt((String)session.getAttribute("uid")); 
		 %>
		<div id="t3zrytopdv2">
			您好:&nbsp;<%=uname%> &nbsp;
			<span id="time"></span>&nbsp;&nbsp;&nbsp;
			<script>
			function time1() {
				var date = new Date();
				document.getElementById("time").innerHTML =date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日" + "   " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
				setTimeout("time1()", 1000);
			}
			time1();
			</script>
			<a class="btn btn-primary" href="../UserUnloginServlet?uid=<%=uid %>" onClick="return confirm('确定退出？')" target="_parent">退出</a>
		</div>
	</body>
</html>

