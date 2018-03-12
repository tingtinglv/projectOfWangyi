$(document).ready(function(){
	var curPage = document.getElementById("currentPageNum");
	var page = "a#"+parseInt(curPage.value);
	$(page).css("background-color","#0088cc");
	$(page).css("color","white");
});

function inquery()
{
	var currentPageNum=document.getElementById("currentPageNum");
	currentPageNum.value="";
	if(judgeDate())
	{
		document.adminform.submit();
		return true;
	}
	else
	{
		alert("起始日期应小于结束日期");
		changertoerror("divStartDateError");
		changertoerror("divEndDateError");
		return false;
	}
	
}
function changertoerror(divID)
{
	var myDiv= document.getElementById(divID);
	myDiv.setAttribute("class","control-group error");
	
}
function resetcolor(divID1,divID2)
{
	var myDiv1= document.getElementById(divID1);
	myDiv1.setAttribute("class","");
	var myDiv2= document.getElementById(divID2);
	myDiv2.setAttribute("class","");
}

function jumptoPage(targetPage)
{
	var currentPageNum = document.getElementById("currentPageNum");
	currentPageNum.value=""+targetPage;
	//alert(currentPageNum.value);
	document.adminform.submit();
}

function judgeDate()
{
	var startYear = parseInt(document.getElementById("selYear").value);
	var startMonth = parseInt(document.getElementById("selMonth").value);
	var startDay = parseInt(document.getElementById("selDay").value);
	var endYear = parseInt(document.getElementById("selYear1").value);
	var endMonth = parseInt(document.getElementById("selMonth1").value);
	var endDay = parseInt(document.getElementById("selDay1").value);
	//alert(startYear+"-"+startMonth+"-"+startDay+" "+endYear+"-"+endMonth+"-"+endDay);
	if(startYear>endYear)
	{
		return false;
	}
	else
	{
		if(startMonth>endMonth)
		{
			return false;
		}
		else
		{
			if(startDay>endDay)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
}

function resetall()
{
	resetcolor("divStartDateError","divEndDateError");
	var userActiveState = document.getElementById("userActiveSel");
	userActiveState[0].selected = "selected";
	var userActiveState = document.getElementById("timeTypeSel");
	userActiveState[0].selected = "selected";
	var userName= document.getElementById("userName");
	userName.value="";
}


//使用Ajax 删除
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
function delUser(uid)
{
   if(confirm("确定删除？"))
  {
	 //发送请求
	   sendRequest("UserDelServlet.do?uid="+uid);
	   //while(!judge){}
	  // judge=false;
	   document.adminform.submit();
  }
   
}
function changeUserActive(uid,action)
{
	if(action=="unactive")
	{
		if(confirm("取消授权？"))
		  {
			 //发送请求
			sendRequest("UserActiveServlet.do?uid="+uid); 
			//while(!judge){}
			  // judge=false;
			  document.adminform.submit();
		  }
	}
	else if(action=="active")
	{
		if(confirm("确定授权？"))
		  {
			 //发送请求
			sendRequest("UserActiveServlet.do?uid="+uid); 
			//while(!judge){}
			 //  judge=false;
			  document.adminform.submit();
		  }
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
function handleResponse() {
    // 判断对象状态
    if (XMLHttpReq.readyState == 4) 
    { 
        // 信息已经成功返回，开始处理信息
       if (XMLHttpReq.status == 200) 
       { 
    	   var res = XMLHttpReq.responseXML;
           var response= res.getElementsByTagName("response")[0].firstChild.nodeValue;
           
           //document.getElementById("hello").innerHTML = response;
    	   if(response=="success")
    		{
    		   return true;
    		} 
    		else if(response=="fail")
    		{
    			return false;
    		}
           }
     }
   }


