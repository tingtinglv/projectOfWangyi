<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.neusoft.ehr.entity.*"%>
<%@ page import="com.neusoft.ehr.comm.*" %>


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

		<title>staff_info_maintain</title>
		<meta name="description" content="">
		<meta name="author" content="MarsDmo">

		<meta name="viewport" content="width=device-width; initial-scale=1.0">

		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->
		<link href="/neusoft/css/bootstrap.css" rel="stylesheet">
		<link href="/neusoft/css/staff.css" rel="stylesheet" type="text/css" />
		<link href="/neusoft/css/datepicker.css" rel="stylesheet" type="text/css" />

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
				  <li class="active">员工信息中心</li>
				</ul>
		</header>
		<%
			Staff staff = (Staff)request.getAttribute("staff");
			String empName = staff.getEmpName();
			String empSex = staff.getEmpSex();
			String nation =staff.getNation();
			String empBirth = staff.getEmpBirth().toString();
			String empCard =staff.getEmpCard();
			String stature = staff.getStature();
			String empTel = staff.getEmpTel();
		 %>
		<form name="staffInfo" action="StaffUpdateServlet.action" method="post">
		<div class="info">
			<table  class="table table-bordered table-striped">
				<tr>
					<th  class="firstline" colspan="6">基本信息</th>
				</tr>
				<tr>
					<td><span style="color:red">*</span>&nbsp;姓名</td>
					<td><input type="text" readonly value="<%=empName %>"/></td>
					<td><span style="color:red">*</span>&nbsp;性别</td>
					<td><input type="text" readonly value="<%=empSex %>"/></td>
					<td>民族</td>
					<td><input type="text" readonly value="<%=nation %>"/></td>
				</tr>
 			<tr>
					<td><span style="color:red">*</span>&nbsp;出生日期</td>
					<td><input type="text" readonly value="<%=empBirth %>"/></td>
					<td><span style="color:red">*</span>&nbsp;身份证号</td>
					<td><input type="text" name="empCard" readonly value="<%=empCard %>"/></td>
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
					<input type="text" name="stature" value="<%=staff.getStature() %>"/>
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
					<input type="text" name="empTel" value="<%=empTel %>"/>
					</td>
					<td>电子邮件</td>
					<td>
					<input type="text" name="email" value="<%=staff.getEmail() %>"/>
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
					<input type="text" name="school" value="<%=staff.getSchool() %>"/>
					</td>
					<td>所学专业</td>
					<td>
					<input type="text" name="major" value="<%=staff.getMajor() %>"/>
					</td>
					<td>毕业日期</td>
					<td>
						<input type="text" id="gradDate" name="gradDate" data-date-format="yyyy-mm-dd" value="<%=staff.getGradDate().toString() %>"/>
					</td>
				</tr>
				<tr>
					<td>籍贯</td>
					<td><input type="text" name="nativePlace" value="<%=staff.getNativePlace() %>"/></td>
					<td>出生地</td>
					<td><input type="text" name="birthplace" value="<%=staff.getBirthplace()%>"/></td>
					<td>户口所在地</td>
					<td><input type="text" name="domicilePlace" value="<%=staff.getDomicilePlace() %>"/></td>
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
					<input type="text" id="empSeq" name="empSeq" class="needCheck" onblur="staffCheck()" onclick="rtnormal(-1,'empSeq')" value="<%=staff.getEmpSeq()%>"/>
					</td>
					<td><span style="color:red">*</span>&nbsp;部门</td>
					<td>
					<input id="dep" type="text" data-provide="typeahead" data-items="5" name="dep" data-source='[<%=depName %> ]' onclick="rtnormal(-1,'dep')" value="<%=staff.getDepName() %>"/>
					</td>
					<td><span style="color:red">*</span>&nbsp;岗位</td>
					<td>
					<input id="post" type="text" data-provide="typeahead" data-items="5" name="post" data-source='[<%=postName %> ]' onclick="rtnormal(-1,'post')" value="<%=staff.getPostName() %>"/>
					</td>
				</tr>

				<tr>
					<td><span style="color:red">*</span>&nbsp;入职日期</td>
					<td>
						<input type="text" name="jobStartDate" id="jobStartDate" data-date-format="yyyy-mm-dd" onclick="rtnormal(-1,'jobStartDate')" value="<%=staff.getStartDate() %>"/>
					</td>
					<td><span style="color:red">*</span>&nbsp;参加工作日期</td>
					<td>
						<input type="text" name="jobDate" id="jobDate" data-date-format="yyyy-mm-dd" onclick="rtnormal(-1,'jobDate')" value="<%=staff.getJobDate() %>"/>
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
					<select name="empForms">
						<option value="正式员工">正式员工</option>
						<option value="临时员工">临时员工</option>
					</select></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			<div class="lastline">
				<input type="submit" class="btn btn-primary" value="提交" />
			</div>
		</div>
		</form>
		<div id="modalPop" class="modalpop hide fade">
			<div class="modal-body" >
				<a class="close" data-dismiss="modal" >&times;</a>
				<div id=warning></div>
			</div>
		</div>
		
		<div class="info">
			<table class="table table-bordered table-striped">
				<tr>
					<th class="firstline" colspan="7">
						职业生涯信息
					</th>
				</tr>
				<tr>
					<td rowspan="4">
						1
					</td>
					<td>
						所在单位
					</td>
					<td>
						<input type="text" />
					</td>
					<td>
						起始时间
					</td>
					<td>
						
					</td>
					<td>
						截止时间
					</td>
					<td></div>
					</td>
				</tr>

				<tr>
					<td>
						从事工作内容
					</td>
					<td>
						<input type="text" />
					</td>
					<td>
						担任职务
					</td>
					<td>
						<input type="text" />
					</td>
					<td>
						年薪/月薪
					</td>
					<td>
						<input type="text" />
					</td>
				</tr>
				<tr>
					<td>
						证明人
					</td>
					<td>
						<input type="text" />
					</td>
					<td>
						证明人职务
					</td>
					<td>
						<input type="text" />
					</td>
					<td>
						证明人电话
					</td>
					<td>
						<input type="text" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						备注
					</td>
					<td>
						<input type="text" />
					</td>
				</tr>
			</table>
			<div class="lastline">
				<input type="button" class="btn btn-primary" value="添加" />
			</div>
		</div>
		<div class="info" id="language">
			<table class="table table-bordered table-striped">
				<tr>
					<th class="firstline" colspan="3">
						外语能力
					</th>
				</tr>
				<tr>
					<th>
						外国语种
					</th>
					<th>
						熟练程度
					</th>
				</tr>
				<tr>
					<td>
						<select>
							<option value="">
								英语
							</option>
							<option value="">
								日语
							</option>
							<option value="">
								法语
							</option>
							<option value="">
								韩语
							</option>
							<option value="">
								其他
							</option>
						</select>
					</td>

					<td>
						<select>
							<option value="">
								完全不懂
							</option>
							<option value="">
								少量，不能进行业务沟通
							</option>
							<option value="">
								有限的业务沟通
							</option>
							<option value="">
								一般，业务沟通受少量限制
							</option>
							<option value="">
								好，无困难地进行谈判和演讲
							</option>
							<option value="">
								流利，在商务中自如地 运用
							</option>
						</select>
					</td>
				</tr>
			</table>
			<div class="lastline">
				<input type="button" class="btn btn-primary" value="添加" />
			</div>
		</div>
		<div class="info">
			<table class="table table-bordered table-striped">
				<tr>
					<th class="firstline" colspan="4">
						家庭成员及社会关系信息
					</th>
				</tr>
				<tr>
					<td>
						姓名
					</td>
					<td>
						所在单位
					</td>
					<td>
						职位
					</td>
					<td>
						联系电话
					</td>
				</tr>
				<tr>
					<td>
						<select>
							<option value="">
								父亲
							</option>
							<option value="">
								母亲
							</option>
							<option value="">
								配偶
							</option>
						</select>
					</td>

					<td>
						<input type="text" />
					</td>
					<td>
						<input type="text" />
					</td>
					<td>
						<input type="text" />
					</td>
				</tr>
			</table>
			<div class="lastline">
				<input type="button" class="btn btn-primary" value="添加" />
			</div>
		</div>
	</body>
</html>
