$(function(){
	var startDate = new Date(1900,1,1);
	var endDate = new Date(3000,1,1);
	$('#empBirth').datepicker();
	$('#gradDate').datepicker();
	$('#jobStartDate').datepicker();
	$('#jobDate').datepicker();
	$('#date').datepicker();
	$('#startDate').datepicker().on('changeDate', function(ev){
		startDate = new Date(ev.date);
		if (ev.date.valueOf() > endDate.valueOf()){
			warning(0,"startDate");
			document.getElementById("warning").innerHTML="开始日期晚于结束日期！";
		    $('#modalPop').modal({
		        backdrop:false,
		        keyboard:false,
		        show:true
		        });
		    setTimeout("warningCls()",3000);
		} else {
			rtnormal(-1,'startDate');
			rtnormal(-1,'endDate');
		}
		});
	$('#endDate').datepicker().on('changeDate', function(ev){
		endDate = new Date(ev.date);
		if (ev.date.valueOf() < startDate.valueOf()){
			warning(0,"endDate");
			document.getElementById("warning").innerHTML="开始日期晚于结束日期！";
		    $('#modalPop').modal({
		        backdrop:false,
		        keyboard:false,
		        show:true
		        });
		    setTimeout("warningCls()",3000);
		} else {
			rtnormal(-1,'startDate');
			rtnormal(-1,'endDate');
		}
		});
	$('#delayDate').datepicker();
	$('#firedDate').datepicker();
	
    $('#firedSure').on('click', function () {
		document.staffFire.submit();
        });
    $('#reviewSure').on('click', function () {
		document.staffReview.submit();
        });
	
});

function reviewInfo(ep){
	$('#probationModal').modal({
		backdrop:true,
		keyboard:false,
		show:true
	});
	var tdEmpSeq = document.getElementById("tdEmpSeq"+ep).innerHTML;
	var tdEmpName = document.getElementById("tdEmpName"+ep).innerHTML;
	var tdStartDate = document.getElementById("tdStartDate"+ep).innerHTML;
	var tdEndDate = document.getElementById("tdEndDate"+ep).innerHTML;
	var tdReviews = document.getElementById("tdReviews"+ep).innerHTML;
	var tdRemark = document.getElementById("tdRemark"+ep).innerHTML;
	document.getElementById("modalEmpSeq").value = tdEmpSeq;
	document.getElementById("modalEmpName").value = tdEmpName;
	document.getElementById("modalStartDate").value = tdStartDate;
	document.getElementById("modalEndDate").value = tdEndDate;
	document.getElementById("reviews").value = tdReviews;
	document.getElementById("remark").value = tdRemark;
}
function fireInfo(ep){
	$('#fireModal').modal({
		backdrop:true,
		keyboard:false,
		show:true
	});
	var tdEmpSeq = document.getElementById("tdEmpSeq"+ep).innerHTML;
	var tdEmpName =document.getElementById("tdEmpName"+ep).innerHTML;
	document.getElementById("modalEmpSeq").value = tdEmpSeq;
	document.getElementById("modalEmpName").value = tdEmpName;
}

function staffCheck(){
	var empSeq = document.getElementById("empSeq");
	if(empSeq.value!="")
		judgeEmp(empSeq.value);
}

//1.开始调用Ajax的功能
function judgeEmp(empSeq)
{
   //发送请求
   sendRequest("./StaffCheckServlet.action?empSeq="+empSeq); 
}
//2.发送客户端的请求
function sendRequest(url) {
      createXMLHttpRequest();
      XMLHttpReq.open("post", url, true);
      //指定响应函数
      XMLHttpReq.onreadystatechange = handleResponse;
      // 发送请求
      XMLHttpReq.send(null); 
 }
//3.创建XMLHttpReques对象
function createXMLHttpRequest() {
   if (window.XMLHttpRequest) {
        //Mozilla 浏览器 
        XMLHttpReq = new XMLHttpRequest();
     } else{
         // IE浏览器
         if (window.ActiveXObject) {
           try {
                  XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
               }catch (e) {
                  try {
                         XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
                      }catch (e) { }
               }
          }
     }
 }

function handleResponse() {
    // 判断对象状态
    if (XMLHttpReq.readyState == 4) 
    { 
        //处理返回的信息
       if (XMLHttpReq.status == 200) 
       { 
    	   var res = XMLHttpReq.responseXML;
           var response= res.getElementsByTagName("response")[0].firstChild.nodeValue;
    	   if(response=="success")
    		{
    		   warning(0,"empSeq");
    		   document.getElementById("warning").innerHTML="<h4>员工编号已被占用！</h4>";
    		    $('#modalPop').modal({
    		        backdrop:false,
    		        keyboard:false,
    		        show:true
    		        });
    		    setTimeout("warningCls()",3000);
    		}
       }
    }
}

/*
 * 输入框提示警告
 */
function warning(flag,id){
	flag=flag+1;
	var f="rtnormal("+flag+",'"+id+"')";
	var empSeq = document.getElementById(id);
	empSeq.setAttribute("class", "exist");//for firefox
	empSeq.setAttribute("className", "exist");//for IE
	if(flag<4)
		setTimeout(f,100);
}
function rtnormal(flag,id){
	flag = flag+1;
	var f="warning("+flag+",'"+id+"')";
	var empSeq = document.getElementById(id);
	empSeq.setAttribute("class", "needCheck");//for firefox
	empSeq.setAttribute("className", "needCheck");//for IE
	if(flag==0){
		warningCls();
	}else{
		setTimeout(f,100);
	}
}
/*
 * 关闭弹出框
 */
function warningCls(){
	$('#modalPop').modal({
        backdrop:false,
        keyboard:false,
        show:false
        });
	$('#modalPop').modal('hide');
}

//校验必填项
function checkInfo(){
	var empName=document.getElementById("empName");
	var empBirth = document.getElementById("empBirth");
	var empCard = document.getElementById("empCard");
	var empSeq = document.getElementById("empSeq");
	var dep = document.getElementById("dep");
	var post = document.getElementById("post");
	var jobStartDate = document.getElementById("jobStartDate");
	var jobDate = document.getElementById("jobDate");
	var typeYes = document.getElementById("typeYes");
	var startDate = document.getElementById("startDate");
	var endDate = document.getElementById("endDate");
	if(empName.value=="")
		checkEmpty("<h5>员工姓名不能为空！</h4>","empName");
	else if(empBirth.value=="")
		checkEmpty("<h4>员工出生日期不能为空！</h4>","empBirth")
	else if(empCard.value=="")
		checkEmpty("<h4>员工身份证号不能为空！</h4>","empCard")
	else if(empSeq.value=="")
		checkEmpty("<h4>员工编号不能为空！</h4>","empSeq")
	else if(dep.value=="")
	checkEmpty("<h4>部门不能为空</h4>","dep")
	else if(post.value=="")
	checkEmpty("<h4>岗位不能为空！</h4>","post")
	else if(jobStartDate.value=="")
	checkEmpty("<h4>入职日期不能为空！</h4>","jobStartDate")
	else if(jobDate.value=="")
	checkEmpty("<h4>参加工作日期不能为空！</h4>","jobDate")
	else if(typeYes.checked)
	{
		if(startDate.value=="")
			checkEmpty("<h4>开始试用日期不能为空！</h4>","startDate")
		else if(endDate.value=="")
			checkEmpty("<h4>结束使用日期不能为空！</h4>","endDate")
		else
			document.staffInfo.submit();
	}
	else
		document.staffInfo.submit();
}
function checkEmpty(str,id){
	warning(0,id);
	   document.getElementById("warning").innerHTML=str;
	    $('#modalPop').modal({
	        backdrop:false,
	        keyboard:false,
	        show:true
	        });
	    setTimeout("warningCls()",3000);
}



