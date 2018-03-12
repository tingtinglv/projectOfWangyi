<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.neusoft.ehr.entity.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">

		<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

		<title>staff_entry</title>
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
				  <li class="active">员工入职管理</li>
				</ul>
		</header>
		<form name="staffInfo" action="StaffAddServlet.action" method="post">
		<div class="info">
			<table  class="table table-bordered table-striped">
				<tr>
					<th  class="firstline" colspan="6">基本信息</th>
				</tr>
				<tr>
					<td><span style="color:red">*</span>&nbsp;姓名</td>
					<td>
					<input id="empName" name="empName" type="text"  onclick="rtnormal(-1,'empName')"/>
					</td>
					<td><span style="color:red">*</span>&nbsp;性别</td>
					<td>
					<select name="empSex" >
						<option value="男">男</option>
						<option value="女">女</option>
					</select></td>
					<td>民族</td>
					<td>
					<select name="nation" >
						 <option value="汉族">汉族</option> 
					     <option value="蒙古族">蒙古族</option>
					     <option value="回族">回族</option>
					     <option value="藏族">藏族</option>
					     <option value="维吾尔族">维吾尔族</option>
					     <option value="维吾尔族">维吾尔族</option>
					     <option value="苗族">苗族</option>
					     <option value="彝族">彝族</option>
					     <option value="壮族">壮族</option>
					     <option value="布依族">布依族</option>
					     <option value="朝鲜族">朝鲜族</option>
					     <option value="满族">满族</option>
					     <option value="侗族">侗族</option>
					     <option value="瑶族">瑶族</option>
					     <option value="白族">白族</option>
					     <option value="土家族">土家族</option>
					     <option value="哈尼族">哈尼族</option>
					     <option value="哈萨克族">哈萨克族</option>
					     <option value="傣族">傣族</option>
					     <option value="黎族">黎族</option>
					     <option value="傈僳族">傈僳族</option>
					     <option value="佤族">佤族</option>
					     <option value="畲族">畲族</option>
					     <option value="高山族">高山族</option>
					     <option value="拉祜族">拉祜族</option>
					     <option value="水族">水族</option>
					     <option value="东乡族">东乡族</option>
					     <option value="纳西族">纳西族</option>
					     <option value="景颇族">景颇族</option>
					     <option value="柯尔克孜族">柯尔克孜族</option>
					     <option value="土族">土族</option>
					     <option value="达斡尔族">达斡尔族</option>
					     <option value="仫佬族">仫佬族</option>
					     <option value="羌族">羌族</option>
					     <option value="布朗族">布朗族</option>
					     <option value="撒拉族">撒拉族</option>
					     <option value="毛南族">毛南族</option>
					     <option value="仡佬族">仡佬族</option>
					     <option value="锡伯族">锡伯族</option>
					     <option value="阿昌族">阿昌族</option>
					     <option value="普米族">普米族</option>
					     <option value="塔吉克族">塔吉克族</option>
					     <option value="怒族">怒族</option>
					     <option value="乌孜别克族">乌孜别克族</option>
					     <option value="俄罗斯族">俄罗斯族</option>
					     <option value="鄂温克族">鄂温克族</option>
					     <option value="德昂族">德昂族</option>
					     <option value="保安族">保安族</option>
					     <option value="裕固族">裕固族</option>
					     <option value="京族">京族</option>
					     <option value="塔塔尔族">塔塔尔族</option>
					     <option value="独龙族">独龙族</option>
					     <option value="鄂伦春族">鄂伦春族</option>
					     <option value="赫哲族">赫哲族</option>
					     <option value="门巴族">门巴族</option>
					     <option value="珞巴族">珞巴族</option>
					     <option value="基诺族">基诺族</option>
						 <option value="">其他</option>
					</select></td>
				</tr>
 			<tr>
					<td><span style="color:red">*</span>&nbsp;出生日期</td>
					<td><input type="text" name="empBirth" id="empBirth" data-date-format="yyyy-mm-dd" onclick="rtnormal(-1,'empBirth')"/> </td>
					<td><span style="color:red">*</span>&nbsp;身份证号</td>
					<td>
					<input type="text" id="empCard" name="empCard" onclick="rtnormal(-1,'empCard')"/>
					</td>
					<td>政治面貌</td>
					<td>
					<select name="politStatus" >
						<option value="党员">党员</option>
						<option value="预备党员">预备党员</option>
						<option value="团员">团员</option>
						<option value="其他" selected="selected">其他</option>
					</select></td>
				</tr>
				<tr>
					<td>身高</td>
					<td>
					<input type="text" name="stature" />
					</td>
					<td>血型</td>
					<td>
					<select name="bloodType" >
						<option value="A型">A型</option>
						<option value="B型">B型</option>
						<option value="AB型">AB型</option>
						<option value="O型">O型</option>
						<option value="其他" selected="selected">其他</option>
					</select></td>
					<td>婚姻状况</td>
					<td>
					<select name="marriage" >
						<option value="未婚">未婚</option>
						<option value="已婚">已婚</option>
						<option value="丧偶">丧偶</option>
						<option value="离婚">离婚</option>
						<option value="其他" selected="selected">其他</option>
					</select></td>
				</tr>
				
				<tr>
					<td>联系电话</td>
					<td>
					<input type="text" name="empTel" />
					</td>
					<td>电子邮件</td>
					<td>
					<input type="text" name="email" />
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>最高学历</td>
					<td>
					<select name="education" >
						<option value="高中及以下">高中及以下</option>
						<option value="大专">大专</option>
						<option value="本科">本科</option>
						<option value="研究生">研究生</option>
						<option value="" selected="selected">-- 请选择  --</option>
					</select></td>
					<td>最高学位</td>
					<td>
					<select name="degree" >
						<option value="无学位">无学位</option>
						<option value="学士">学士</option>
						<option value="双学位">双学位</option>
						<option value="硕士">硕士</option>
						<option value="博士">博士</option>
						<option value="博士后">博士后</option>
						<option value="" selected="selected">-- 请选择  --</option>
					</select></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>毕业院校</td>
					<td>
					<input type="text" name="school" />
					</td>
					<td>所学专业</td>
					<td>
					<input type="text" name="major" />
					</td>
					<td>毕业日期</td>
					<td>
						<input type="text" id="gradDate" name="gradDate" data-date-format="yyyy-mm-dd"/>
					</td>
				</tr>
				<tr>
					<td>籍贯</td>
					<td><input type="text" name="nativePlace" /></td>
					<td>出生地</td>
					<td><input type="text" name="birthplace" /></td>
					<td>户口所在地</td>
					<td><input type="text" name="domicilePlace" /></td>
				</tr>
			</table>
		</div>
		<%
			String depName="";
			String postName="";
			List<Dept> depList = (List<Dept>)request.getAttribute("depList");
			List<Post> postList = (List<Post>)request.getAttribute("postList");
			if(postList.size()>0){
			    Iterator it = postList.iterator();
			    while(it.hasNext()){
			    	Post p = (Post)it.next();
			    	if(postName.equals(""))
			    		postName="\""+p.getPost_name()+"("+p.getPost_seq()+")\"";
			    	else
			    		postName=postName+","+"\""+p.getPost_name()+"("+p.getPost_seq()+")\"";
			    }
			}
			if(depList.size()>0){
			    Iterator it = depList.iterator();
			    while(it.hasNext()){
			    	Dept d = (Dept)it.next();
			    	if(depName.equals(""))
			    		depName="\""+d.getDep_name()+"("+d.getDep_seq()+")\"";
			    	else
			    		depName=depName+","+"\""+d.getDep_name()+"("+d.getDep_seq()+")\"";
			    }
			}
		 %>
		<div class="info">
			<table  class="table table-bordered table-striped">
				<tr>
					<th  class="firstline" colspan="6">职业信息</th>
				</tr>
				<tr>
					<td><span style="color:red">*</span>&nbsp;员工编号</td>
					<td>
					<input type="text" id="empSeq" name="empSeq" class="needCheck" onblur="staffCheck()" onclick="rtnormal(-1,'empSeq')"/>
					</td>
					<td><span style="color:red">*</span>&nbsp;部门</td>
					<td>
					<input id="dep" type="text" data-provide="typeahead" data-items="5" name="dep" data-source='[<%=depName %> ]' onclick="rtnormal(-1,'dep')"/>
					</td>
					<td><span style="color:red">*</span>&nbsp;岗位</td>
					<td>
					<input id="post" type="text" data-provide="typeahead" data-items="5" name="post" data-source='[<%=postName %> ]' onclick="rtnormal(-1,'post')"/>
					</td>
				</tr>

				<tr>
					<td><span style="color:red">*</span>&nbsp;入职日期</td>
					<td>
						<input type="text" name="jobStartDate" id="jobStartDate" data-date-format="yyyy-mm-dd" onclick="rtnormal(-1,'jobStartDate')"/>
					</td>
					<td><span style="color:red">*</span>&nbsp;参加工作日期</td>
					<td>
						<input type="text" name="jobDate" id="jobDate" data-date-format="yyyy-mm-dd" onclick="rtnormal(-1,'jobDate')"/>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><span style="color:red">*</span>&nbsp;人员来源</td>
					<td>	
					<select name="empOrigin">
						<option value="校园招聘">校园招聘</option>
						<option value="社会招聘">社会招聘</option>
						<option value="其他" selected="selected">其他</option>
					</select></td>
					<td><span style="color:red">*</span>&nbsp;用工形式</td>
					<td>
					<select name="empForms">S
						<option value="正式员工">正式员工</option>
						<option value="临时员工">临时员工</option>
					</select></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div class="info">
			<table  class="table table-bordered table-striped">
				<tr>
					<th  class="firstline" colspan="6">试用期信息</th>
				</tr>
				<tr>
					<td>是否试用</td>
					<td>
						<input name="probation" id="typeYes" value="是" type="radio" >是&nbsp;&nbsp;
						<input name="probation" value="否" type="radio" checked="checked"/>否
					</td>
					<td><span style="color:red">*</span>&nbsp;开始日期</td>
					<td>
						<input type="text" name="startDate" id="startDate" data-date-format="yyyy-mm-dd"/>
					</td>
					<td><span style="color:red">*</span>&nbsp;结束日期</td>
					<td>
						<input type="text" name="endDate" id="endDate" data-date-format="yyyy-mm-dd"/>
					</td>
				</tr>
			</table>
			<div class="lastline">
				<a class="btn btn-primary" href="staff_info_maintain.jsp">其他信息录入</a>
				<input type="button" class="btn btn-primary" value="录入" onclick="checkInfo()"/>
			</div>
		</div>
		</form>
		<div id="modalPop" class="modalpop hide fade">
			<div class="modal-body" >
				<a class="close" data-dismiss="modal" >&times;</a>
				<div id=warning></div>
			</div>
		</div>
	</body>
</html>
