package web.rest.common.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.rest.common.service.DetpMntService;

@RestController
@RequestMapping(value = "/api/common/detpMnt")
public class DetpMntController {

	@Autowired
	private static DetpMntService deptMntService;
	
	public List<Map<String, Object>> getDetpList (@RequestBody Map<String, Object>params){
		
		return deptMntService.getDetpList();
	}
}
