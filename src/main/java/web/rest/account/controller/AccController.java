package web.rest.account.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import web.rest.account.service.UserService;


@RestController
@RequestMapping(value = "/api/user")
public class AccController {

	private static final Logger log = LoggerFactory.getLogger(AccController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/login")
	@ResponseBody
	public Map<String, Object> MainController(HttpServletRequest request, @RequestBody Map<String, Object> param) {
		/*
		 * @requestBody
		 * json 데이터를 java object로 자동으로 변환해준다.
		 * 사용하기 위해서는 기본생성자와 getter 혹은 setter가 필요하다.
		 */

		return userService.searchUserById(param);
	}
	
	@GetMapping(value = "/get")
	@ResponseBody
	public String getRuqeust(@RequestParam(value = "id") String id) {
		
		
		
		return id;
	}
	
	
	
	

}
