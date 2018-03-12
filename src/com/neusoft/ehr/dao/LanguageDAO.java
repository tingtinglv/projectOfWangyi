package com.neusoft.ehr.dao;

import com.neusoft.ehr.entity.Language;

public interface LanguageDAO {
	public boolean add(Language l);
	public boolean del(int empId);
	public boolean update(Language l);
	public Language findByEmpId(int empId);
}
