<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">

		<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

		<title>menu</title>
		<meta name="description" content="">
		<meta name="author" content="Marine">

		<meta name="viewport" content="width=device-width; initial-scale=1.0">

		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->
		<link rel="shortcut icon" href="/favicon.ico">
		<link rel="apple-touch-icon" href="/apple-touch-icon.png">

		<link href="/neusoft/css/bootstrap.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="/neusoft/css/home.css" />
		<link rel="stylesheet" type="text/css" href="/neusoft/css/menu.css" />

		<script type="text/javascript" src="/neusoft/js/menu/jquery.js"></script>
		<script type="text/javascript" src="/neusoft/js/menu/sliding_effect.js"></script>
		<script type="text/javascript" src="/neusoft/js/menu/menu.js"></script>

		<script src="/neusoft/js/jquery.js"></script>
		<script src="/neusoft/js/google-code-prettify/prettify.js"></script>
		<script src="/neusoft/js/bootstrap-transition.js"></script>
		<script src="/neusoft/js/bootstrap-alert.js"></script>
		<script src="/neusoft/js/bootstrap-modal.js"></script>
		<script src="/neusoft/js/bootstrap-dropdown.js"></script>
		<script src="/neusoft/js/bootstrap-scrollspy.js"></script>
		<script src="/neusoft/js/bootstrap-tab.js"></script>
		<script src="/neusoft/js/bootstrap-tooltip.js"></script>
		<script src="/neusoft/js/bootstrap-popover.js"></script>
		<script src="/neusoft/js/bootstrap-button.js"></script>
		<script src="/neusoft/js/bootstrap-collapse.js"></script>
		<script src="/neusoft/js/bootstrap-carousel.js"></script>
		<script src="/neusoft/js/bootstrap-typeahead.js"></script>
		<script src="/neusoft/js/application.js"></script>
		<script src="/neusoft/js/customize.js"></script>

	</head>

	<body>
		<div class="accordion" id="accordion">
			<ul class="nav nav-list" id="sliding-navigation">
				<li class="sliding-element">
				<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" href="main.jsp" target="main"><i
											class="icon-home "></i>&nbsp; 首页
							</a>
						</div>
						</div>
				</li>
				<li class="sliding-element">
				<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" href="../DeptSeleServlet.action?seq=&name=&type="
								target="main"><i class="icon-th-large "></i>&nbsp; 部门管理 </a>
						</div>
						</div>
				</li>

				<li class="sliding-element">
				<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" href="../PostFindServlet.action?post_seq=&post_name=&post_type=" target="main">
								<i class="icon-th "></i>&nbsp; 岗位管理 </a>
						</div>
						</div>
				</li>

				<li class="sliding-element">
				<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapseFour"><i
								class=" icon-th-list"></i>&nbsp; 入职管理 </a>
						</div>
						<div id="collapseFour" class="accordion-body collapse ">
							<div class="accordion-inner">
								<ul class="nav nav-list">
									<li class="sliding-element">
										<a href="staff_entry.jsp" target="main"><i
											class="icon-edit "></i>人才库入职</a>
									</li>
									<li class="sliding-element">
										<a href="../StaffEntryInfoServlet.action" target="main"><i
											class="icon-edit"></i> 普通入职</a>
									</li>
								</ul>
							</div>
						</div>
						</div>
				</li>
				<li class="sliding-element">
				<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapseThree"><i
								class=" icon-th-list"></i>&nbsp;员工试用期管理</a>
						</div>
						<div id="collapseThree" class="accordion-body collapse ">
							<div class="accordion-inner">
								<ul class="nav nav-list">
									<li class="sliding-element">
										<a href="../StaffProbationServlet.action" target="main"><i
											class="icon-search "></i>试用期员工查询</a>
									</li>
									<li class="sliding-element">
										<a href="../StaffPassedServlet.action" target="main"><i
											class="icon-search"></i> 已转正员工查询</a>
									</li>
								</ul>
							</div>
						</div>
						</div>
				</li>
				<li class="sliding-element">
				<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapseOne"> <i
								class=" icon-th-list"></i>&nbsp; 部门调动管理</a>
						</div>
						<div id="collapseOne" class="accordion-body collapse ">
							<div class="accordion-inner">
								<ul class="nav nav-list">
									<li class="sliding-element">
										<a href="../DepChFindServlet.action?seq=&name=&depname=&postname=" target="main"><i
											class="icon-edit "></i> 员工部门调动</a>
									</li>
									<li class="sliding-element">
										<a href="../DepChangedServlet.action?syear=1900&smonth=1&sday=1&eyear=2014&emonth=12&eday=31&empseq=&empname=&type=" target="main"><i
											class="icon-search"></i> 已调动部门员工查询</a>
									</li>
								</ul>
							</div>
						</div>
						</div>
				</li>
				<li class="sliding-element">
				<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapseTwo"><i
								class=" icon-th-list"></i>&nbsp; 岗位调动管理</a>
						</div>
						<div id="collapseTwo" class="accordion-body collapse ">
							<div class="accordion-inner">
								<ul class="nav nav-list">
									<li class="sliding-element">
										<a href="../PostStaffServlet.action" target="main"><i
											class="icon-edit "></i> 员工岗位调动</a>
									</li>
									<li class="sliding-element">
										<a href="../PostchFindServlet.action?seq=&name=&type=&start_date=&end_date=" target="main"><i
											class="icon-search"></i> 已调动岗位员工查询</a>
									</li>
								</ul>
							</div>
						</div>
						</div>
				</li>
				<li class="sliding-element">
				<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapseFive"><i
								class=" icon-th-list"></i>&nbsp;离职管理</a>
						</div>
						<div id="collapseFive" class="accordion-body collapse ">
							<div class="accordion-inner">
								<ul class="nav nav-list">
									<li class="sliding-element">
										<a href="../StaffFireServlet.action" target="main"><i
											class="icon-edit "></i>员工离职</a>
									</li>
									<li class="sliding-element">
										<a href="../StaffFiredServlet.action" target="main"><i
											class="icon-search"></i> 已离职员工查询</a>
									</li>
								</ul>
							</div>
						</div>
						</div>
				</li>
				<li class="sliding-element">
				<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapseSix"><i
								class=" icon-th-list"></i>&nbsp; 员工管理</a>
						</div>
						<div id="collapseSix" class="accordion-body collapse ">
							<div class="accordion-inner">
								<ul class="nav nav-list">
									<li class="sliding-element">
										<a href="../StaffFindServlet.action" target="main"><i
											class="icon-list-alt "></i> 员工信息中心</a>
									</li>
								</ul>
							</div>
						</div>
						</div>
				</li>
				<li class="sliding-element">
				<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapseSeven"><i
								class=" icon-th-list"></i>&nbsp; 报表管理 </a>
						</div>
						<div id="collapseSeven" class="accordion-body collapse ">
							<div class="accordion-inner">
								<ul class="nav nav-list" id="sliding-navigation">
									<li class="sliding-element">
										<a href="staff_new_report.jsp" target="main"> <i
											class="icon-list-alt"></i> 新聘员工报表</a>
									</li>
									<li class="sliding-element">
										<a href="staff_fired_report.jsp" target="main"><i
											class="icon-list-alt"></i> 离职员工报表</a>
									</li>
									<li class="sliding-element">
										<a href="../ReportDepchServlet.action?syear=1900&smonth=1&sday=1&eyear=2014&emonth=12&eday=31&empseq=&empname=&type=" target="main"><i
											class="icon-list-alt"></i> 部门调动报表</a>
									</li>
									<li class="sliding-element">
										<a href="../PostcfReServlet.action?seq=&name=&type=&start_date=&end_date=" target="main"><i
											class="icon-list-alt"></i> 岗位调动报表</a>
									</li>
									<li class="sliding-element">
										<a href="staff_resource_report.jsp" target="main"><i
											class="icon-list-alt"></i> 人事月报表</a>
									</li>
								</ul>
							</div>
						</div>
						</div>
				</li>
			</ul>
		</div>
	</body>
</html>
