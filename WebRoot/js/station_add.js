
function add(){
	var station_id = document.getElementById("station_add_id").value;
    var station_name = document.getElementById("station_add_name").value;
    var station_org = document.getElementById("station_add_org").value;
    var station_type = document.getElementById("station_add_type").value;
    if(station_id!="")
    {
    	if(station_name!="")
    	{
    		if(station_org!="")
        	{
        		return true;
        	}
    		else
    		{
    			alert("请输入岗位编制");
    			return false;
    		}
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
    var myform=document.getElementById("station_add");
    myform.submit();
}