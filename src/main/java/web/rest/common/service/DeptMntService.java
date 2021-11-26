package web.rest.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.rest.common.dao.DeptMntDao;

@Service
public class DeptMntService {

	@Autowired
	private DeptMntDao deptMntDao;
	
	
	public List<Map<String, Object>> getDeptList() {
		
		
		List<Map<String, Object>> deptList = deptMntDao.getDeptList();
		return deptList;
	}

	
	
}
