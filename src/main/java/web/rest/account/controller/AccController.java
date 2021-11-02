package web.rest.account.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.rest.account.service.UserService;

@RestController
@RequestMapping(value = "api/user")
public class AccController {

	private static final Logger log = LoggerFactory.getLogger(AccController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/login")
	public int MainController(HttpServletRequest request, @RequestBody Map<String, Object> param) {
		
//		userService.searchUserById(param);
		
		return 1;
	}
	
	
	
	

}
