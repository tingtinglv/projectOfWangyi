
function query(){
	var station_id = document.getElementById("station_info_id").value;
    var station_name = document.getElementById("station_info_name").value;
    var station_type = document.getElementById("station_info_type").value;
    
    if(station_id!="")
    {
    	if(station_name!="")
    	{
    		return true;
    	}
    	else{
        	alert("请输入岗位名称");
        	return false;
        }
    }
    else{
    	alert("请输入岗位编号");
    	return false;
    }
    var myform=document.getElementById("station_query");
    myform.submit();
}