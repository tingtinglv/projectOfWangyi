
var judge3 = false;
function regpwdcheck(input1,input2,input3)
{
	 var pwd = document.getElementById(input1);
     if(pwd.value=="")
     {
     	var pwdinput=document.getElementById(input2);
     		pwdinput.setAttribute("class","control-group error");
     	 document.getElementById(input3).innerHTML="密码不能为空";
     	 return false;
     }
     else
     {
    	 if(pwd.value.length<6&&pwd.value.length>=1)
   	  	{
    	 var pwdinput=document.getElementById(input2);
   		  pwdinput.setAttribute("class","control-group warning");
   		  document.getElementById(input3).innerHTML="密码安全较低";
   	  	}
    	 return  true;
     }
}
 function pwdcheck(input1,input2,input3)
 {
 	 var pwd = document.getElementById(input1);
      if(pwd.value=="")
      {
      	var pwdinput=document.getElementById(input2);
      		pwdinput.setAttribute("class","control-group error");
      	document.getElementById(input3).innerHTML="密码不能为空";
      	 return false;
      }
      else
      {
    	  
    	  return true;
      }
}
function pwdconfcheck(input1,input2,input3)
{
	 var pwd = document.getElementById(input1);
     if(pwd.value=="")
     {
     	var pwdinput=document.getElementById(input2);
     		pwdinput.setAttribute("class","control-group error");
     	 document.getElementById(input3).innerHTML="密码不能为空";
     	return false;
     }
     else
     {
    	 return true;
     }
     
}
function answercheck(input1,input2,input3)
{
	var answer = document.getElementById(input1);
    if(answer.value=="")
    {
    	var pwdinput=document.getElementById(input2);
    		pwdinput.setAttribute("class","control-group error");
    	 document.getElementById(input3).innerHTML="回答不能为空";
    	return false;
    }
    else
    {
   	 return true;
    }
}
function emailcheck(input1,input2,input3)
{
	var email = document.getElementById(input1);
    if(email.value=="")
    {
    	var pwdinput=document.getElementById(input2);
    		pwdinput.setAttribute("class","control-group error");
    	 document.getElementById(input3).innerHTML="邮箱不能为空";
    	return false;
    }
    else
    {
   	 	var result =isEmail(email.value)
   	 	if(result==true)
   	 	{
   	 		return true;
   	 	}
   	 	else
   	 	{
   	 		var pwdinput=document.getElementById(input2);
   	 		pwdinput.setAttribute("class","control-group error");
   	 		document.getElementById(input3).innerHTML="不是合法邮箱";
   	 		return false;
   	 	}
    }
}
function isEmail(str)
{
    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    return reg.test(str);
}

function unamecheck(input1,input2,input3)
{
	 var uname = document.getElementById(input1);
     if(uname.value=="")
     {
     	var unameinput=document.getElementById(input2);
     		unameinput.setAttribute("class","control-group error");
     	 document.getElementById(input3).innerHTML="账号不能为空";
     	 return false;
     }
     else
     {
    	 return true;
     }
     
}
function regunamecheck(input1,input2,input3)
{
	 var uname = document.getElementById(input1);
     if(uname.value=="")
     {
     	var unameinput=document.getElementById(input2);
     		unameinput.setAttribute("class","control-group error");
     	 document.getElementById(input3).innerHTML="账号不能为空";
     	 return false;
     }
     else
     {
    	 judgeuname(uname);
    	 return true;
     }
     
}
function pwdforunamecheck(input1,input2,input3)
{
	 var uname = document.getElementById(input1);
     if(uname.value=="")
     {
     	var unameinput=document.getElementById(input2);
     		unameinput.setAttribute("class","control-group error");
     	 document.getElementById(input3).innerHTML="账号不能为空";
     	 return false;
     }
     else
     {
    	 judgeforuname(uname);
    	 return true;
     }
     
}
function questioncheck(input1,input2,input3)
{
	 var question = document.getElementById(input1);
    if(question.value=="")
    {
    	var unameinput=document.getElementById(input2);
    		unameinput.setAttribute("class","control-group error");
    	 document.getElementById(input3).innerHTML="请选择密保问题";
    	 return false;
    }
    else
    {
   	 return true;
    }
    
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

//1.开始调用Ajax的功能
function judgeuname(uname)
{

   var unamevalue = uname.value;
   //发送请求
   sendRequest("UserUnameCheckServlet?uname="+unamevalue); 
}
function judgeforuname(uname)
{
   var unamevalue = uname.value;
   //发送请求
   sendforRequest("UserUnameCheckServlet",unamevalue); 
}
function judgeforanswer(unameid,answerid,emailid)
{
	var uname = document.getElementById(unameid); 
	var answer = document.getElementById(answerid);
	var email = document.getElementById(emailid);
	var unamevalue = uname.value;
	var answervalue = answer.value;
	var emailvalue = email.value;
	var check1 = emailcheck("pwdforemail","inputdiv3","pwdforemailspan");
	var check2 = answercheck("pwdforans","inputdiv2","pwdforansspan");
	if(check1&&check2)
	{
		sendforansRequest("UserAnswerCheckServlet",unamevalue,answervalue,emailvalue);
	}
	
}

//2.发送客户端的请求
function sendRequest(url) {
      createXMLHttpRequest();
      XMLHttpReq.open("GET", url, true);
      //指定响应函数
      XMLHttpReq.onreadystatechange = handleResponse;
      // 发送请求
      XMLHttpReq.send(null); 
 }
function sendforRequest(url,unamevalue) {
    createXMLHttpRequest();
    XMLHttpReq.open("POST", url, true);
    XMLHttpReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
    //指定响应函数
    XMLHttpReq.onreadystatechange = handleforResponse;
    // 发送请求
    var param = "uname="+unamevalue;
    XMLHttpReq.send(param); 
}
function sendforansRequest(url,unamevalue,answervalue,emailvalue)
{
	 	createXMLHttpRequest();
	    XMLHttpReq.open("POST", url, true);
	    XMLHttpReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	    //指定响应函数
	    XMLHttpReq.onreadystatechange = handleforansResponse;
	    // 发送请求
	    var param = "uname="+unamevalue+"&answer="+answervalue+"&email="+emailvalue;
	    XMLHttpReq.send(param);
}
function handleResponse() {
    // 判断对象状态
    if (XMLHttpReq.readyState == 4) 
    { 
        // 信息已经成功返回，开始处理信息
       if (XMLHttpReq.status == 200) 
       { 
    	   var res = XMLHttpReq.responseXML;
           var response= res.getElementsByTagName("state")[0].firstChild.nodeValue;
           var nameSpan = document.getElementById("regunamespan");
           var unameinput=document.getElementById("t3zrydivloginput4");
           //document.getElementById("hello").innerHTML = response;
    	   if(response=="success")
    		{
    		   	nameSpan.innerHTML="账号已被注册";
    		    judge3 = false;
    		   	unameinput.setAttribute("class","control-group error");
    		} 
    		else if(response=="fail")
    		{
    			nameSpan.innerHTML="账号可使用";
    			unameinput.setAttribute("class","control-group success");
    			judge3 = true;
    		}
          }
     }
   }
function handleforResponse() {
    // 判断对象状态
    if (XMLHttpReq.readyState == 4) 
    { 
        // 信息已经成功返回，开始处理信息
       if (XMLHttpReq.status == 200) 
       { 
    	   var res = XMLHttpReq.responseXML;
           var response1= res.getElementsByTagName("state")[0].firstChild.nodeValue;
           
           var nameSpan = document.getElementById("pwdforunamespan");
           var unameinput=document.getElementById("inputdiv1");
           var questionspan = document.getElementById("pwdforquesspan");
           //document.getElementById("hello").innerHTML = response;
    	   if(response1=="success")
    		{
    		   var response2= res.getElementsByTagName("question")[0].firstChild.nodeValue;
    		   questionspan.innerHTML = response2;
    		   	nameSpan.innerHTML="账号存在,可以找回";
    		   	unameinput.setAttribute("class","control-group success");
    		    document.getElementById("mydiv1next").disabled=false;
    		} 
    		else if(response1=="fail")
    		{
    			nameSpan.innerHTML="账号不存在";
    			unameinput.setAttribute("class","control-group error");
    			document.getElementById("mydiv1next").disabled=true;
    		}
         }
     }
   }
function handleforansResponse()
{
	if (XMLHttpReq.readyState == 4) 
    { 
        // 信息已经成功返回，开始处理信息
       if (XMLHttpReq.status == 200) 
       { 
    	   var res = XMLHttpReq.responseXML;
           var response1= res.getElementsByTagName("state")[0].firstChild.nodeValue;
           //document.getElementById("hello").innerHTML = response;
    	   if(response1=="success")
    		{
    		   next();
    		} 
    		else if(response1=="fail")
    		{
    			alert("验证信息输入错误");
    		}
         }
     }
}
function changecolor(input1,input2)
{
	var pwdinput=document.getElementById(input1);
     pwdinput.setAttribute("class","");
     document.getElementById(input2).innerHTML="";
}
function resetall1()
{
	changecolor('t3zrydivloginput4','regunamespan');
	changecolor('t3zrydivloginput5','regpwdspan');
	changecolor('t3zrydivloginput6','regpwdconfspan');
	changecolor('t3zrydivloginput7','regquestionspan');
	changecolor('t3zrydivloginput8','reganswerspan');
	changecolor('t3zrydivloginput9','regemailspan');
}
function resetall2()
{
	changecolor('t3zrydivloginput3','unamespan');
	changecolor('t3zrydivloginput2','pwdspan');
}
function registaccount1()
{
	var judge1 = regunamecheck("reguname","t3zrydivloginput4","regunamespan");
	var judge2 = regpwdcheck("regpwd","t3zrydivloginput5","regpwdspan");
	var judge4 = pwdconfcheck("regpwdconf","t3zrydivloginput6","regpwdconfspan");
	var judge5 = judgepwdequal();
	var judge6 = answercheck('reganswer','t3zrydivloginput8','reganswerspan');
	var judge7 = emailcheck('regemail','t3zrydivloginput9','regemailspan');
	var judge8 = questioncheck('questionselect','t3zrydivloginput7','regquestionspan');
	if(judge1&&judge2&&judge3&&judge4&&judge5&&judge6&&judge7&&judge8)
	{
		
		document.registaccount.submit();
		return true;
	}
	else
	{
		return false;
	}
}

function judgepwdequal()
{
	var pwd = document.getElementById("regpwd").value;
	var pwdconf = document.getElementById("regpwdconf").value;
	if(pwd==pwdconf)
	{
		return true;
	}
	else
	{
		var unameinput1=document.getElementById("t3zrydivloginput6");
 		unameinput1.setAttribute("class","control-group error");
 		var unameinput1=document.getElementById("t3zrydivloginput5");
 		unameinput1.setAttribute("class","control-group error");
 		document.getElementById("regpwdconfspan").innerHTML="密码不一致";
 		return false;
	}
}
function judgelogin()
{
	var judge1 = unamecheck("uname","t3zrydivloginput3","unamespan");
	var judge2 = pwdcheck("pwd","t3zrydivloginput2","pwdspan");
	if(judge1==true&&judge2==true)
	{
		document.t3zryform1.submit();
		return true;
	}
	else
	{
		return false;
	}
	
}
function linkReg()
{
	resetall1();
	var reguname = document.getElementById("reguname");
	var regpwd = document.getElementById("regpwd");
	var regpwdconf = document.getElementById("regpwdconf");
	var questionselect=document.getElementById("questionselect");
	var reganswer = document.getElementById("reganswer");
	var regemail = document.getElementById("regemail");
	reguname.value="";
	regpwd.value="";
	regpwdconf.value="";
	questionselect.options[0].selected = true;
	reganswer.value = "";
	regemail.value = "";
}

var num = 1;
function back()
{
	num--;
	if(num==1)
	{
		document.getElementById("mydiv1").style.display="block";
		document.getElementById("mydiv2").style.display="none";
		document.getElementById("mydiv3").style.display="none";
	}
	else if(num==2)
	{
		document.getElementById("mydiv1").style.display="none";
		document.getElementById("mydiv2").style.display="block";
		document.getElementById("mydiv3").style.display="none";
	}
}
function next()
{
	num++;
	if(num==2)
	{
		document.getElementById("mydiv1").style.display="none";
		document.getElementById("mydiv2").style.display="block";
		document.getElementById("mydiv3").style.display="none";
	}
	else if(num==3)
	{
		document.getElementById("mydiv1").style.display="none";
		document.getElementById("mydiv2").style.display="none";
		document.getElementById("mydiv3").style.display="block";
	}
}

function resetforpwd()
{
	num = 1;
	document.getElementById("mydiv1").style.display="block";
	document.getElementById("mydiv2").style.display="none";
	document.getElementById("mydiv3").style.display="none";
	document.getElementById("mydiv1next").disabled=true;
	var pwdforuname= document.getElementById("pwdforuname");
	var pwdforans = document.getElementById("pwdforans");
	var pwdforemail = document.getElementById("pwdforemail");
	var pwdforpwd = document.getElementById("pwdforpwd");
	var pwdforpwdconf =document.getElementById("pwdforpwdconf");
	pwdforuname.value="";
	pwdforans.value="";
	pwdforemail.value="";
	pwdforpwd.value="";
	pwdforpwdconf.value="";
	changecolor("inputdiv1","pwdforunamespan");
	changecolor("inputdiv2","pwdforansspan");
	changecolor("inputdiv3","pwdforemailspan");
	changecolor("inputdiv4","pwdforpwdspan");
	changecolor("inputdiv5","pwdforpwdconfspan");
}

function judgeforpwdequal()
{
	var pwd = document.getElementById("pwdforpwd").value;
	var pwdconf = document.getElementById("pwdforpwdconf").value;
	if(pwd==pwdconf)
	{
		return true;
	}
	else
	{
		var unameinput1=document.getElementById("inputdiv4");
 		unameinput1.setAttribute("class","control-group error");
 		var unameinput1=document.getElementById("inputdiv5");
 		unameinput1.setAttribute("class","control-group error");
 		document.getElementById("pwdforpwdspan").innerHTML="密码不一致";
 		return false;
	}
}
function pwdforsubmit()
{
	if(judgeforpwdequal()&&regpwdcheck("pwdforpwd","inputdiv4","pwdforpwdspan")&&pwdconfcheck("pwdforpwdconf","inputdiv5","pwdforpwdconfspan"))
	{
		document.pwdforgetform.submit();
		return true;
	}
	else
	{
		return false;
	}
}

