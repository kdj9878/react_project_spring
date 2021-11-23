package web.rest.account.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.rest.account.dao.UserDao;

@Service
public class UserService {

	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;
	
	public Map<String, Object> searchUserById(Map<String, Object> param) {
		Map<String, Object> userInfo = userDao.searchUserById(param);
		
		
		
		
		return userInfo;
		
	}

	public List<Map<String, Object>> getUserList() {
		
		
		List<Map<String, Object>> userList = userDao.getUserList();
		
		return userList;
		
		
	}
	
	
	
}
