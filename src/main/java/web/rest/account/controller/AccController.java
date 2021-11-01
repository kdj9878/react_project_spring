package web.rest.account.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/user")
public class AccController {

	private static final Logger log = LoggerFactory.getLogger(AccController.class);
	
	@GetMapping(value = "/login")
	public String MainController() {
		
		String value = "연결 성공";
		log.info("연결 됨");
		
		return value;
	}
	
	
	
	

}
