package web.rest.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import web.rest.common.dao.DetpMntDao;

@Service
public class DetpMntService {

	private DetpMntDao detpMntDao;
	
	
	public List<Map<String, Object>> getDetpList() {
		
		return detpMntDao.getDetpList();
	}

	
	
}
