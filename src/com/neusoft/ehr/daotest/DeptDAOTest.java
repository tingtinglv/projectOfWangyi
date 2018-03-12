package com.neusoft.ehr.daotest;

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.neusoft.ehr.dao.DeptDAO;
import com.neusoft.ehr.entity.Dept;
import com.neusoft.ehr.factory.DeptDAOFactory;

public class DeptDAOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
        
//        //测试add
       for(int i=2;i<14;i++){
        Dept d = new Dept();
        String s = String.valueOf(i);
        System.out.println(s);
        d.setDep_seq(s);
        d.setDep_name("部门"+s+"号");
        d.setDep_tel(s);
        d.setDep_type("部门");
        d.setDep_desc("sun");
        d.setDep_updep("总公司");
        d.setDep_date("2012-11-12");
        dd.add(d);}
//        //测试update
//        d.setDep_seq("5");
//        d.setDep_name("z3");
//        d.setDep_tel("6299873917");
//        d.setDep_type("iasdha");
//        d.setDep_desc("1");
//        d.setDep_updep("1");
//        d.setDep_date("2011-11-11");
//        dd.update(d);
        //测试select by id
//        d = dd.findbyid("123");
//        System.out.println(d.getDep_name());
        //测试select by name
//        List l = dd.findbyname("张三");
//        d = (Dept) l.get(0);
//        System.out.println(d.getDep_date());
        //测试select by type
//        List a1 = dd.findbylike("16");
//        Iterator it = a1.iterator();
//        while(it.hasNext()){
//        	d = (Dept)it.next();
//        	System.out.println(d.getDep_name());
//        	System.out.println(d.getDep_seq());
//       }
//        int i = dd.findbytypecount("部门");
//        System.out.println(i);
//        d.setDep_seq("1");
//        dd.dele(d);
//        String str = "2012-12-12";
//        StringTokenizer st=new StringTokenizer(str);
//        System.out.println(st.nextToken("-"));
//        System.out.println(st.nextToken("-"));
//        System.out.println(st.nextToken("-"));
	}

}
