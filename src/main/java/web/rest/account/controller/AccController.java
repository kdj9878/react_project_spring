package web.rest.account.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.rest.account.service.UserService;


@RestController
@RequestMapping(value = "/api/user")
public class AccController {

	private static final Logger log = LoggerFactory.getLogger(AccController.class);
	
	@Autowired
	private UserService userService;
	
	
	/*	로그인 시 실행되는 메소드
	 * 	/api/user/login
	 */
	@PostMapping("/login")
	public Map<String, Object> MainController(HttpServletRequest request, @RequestBody Map<String, Object> param) {
		/*
		 * @requestBody
		 * json 데이터를 java object로 자동으로 변환해준다.
		 * 사용하기 위해서는 기본생성자와 getter 혹은 setter가 필요하다.
		 * 하지만 여기서는 Map에 바로 넣기 위해서 처음부터 객체 형태로 전송
		 */
		return userService.searchUserById(param);
	}
	
	
	/*
	 * 유저 리스트를 가져오는 메소드
	 *	/api/user/list
	 */
	@GetMapping("/list")
	public List<Map<String, Object>> getRuqeust(HttpServletRequest request) {
		return userService.getUserList();
	}
	
	/*
	 * 유저 정보 변경을 위한 메소드
	 *	/api/user/infoChange
	 */
	@PutMapping("/infoChange")
	public List<Map<String, Object>> modUserInfo(@RequestBody Map<String, Object> params) {
		return userService.modUserInfo(params);
		
	}
	
	
	

}
