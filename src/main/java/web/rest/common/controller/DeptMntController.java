package web.rest.common.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.rest.common.service.DeptMntService;

@RestController
@RequestMapping(value = "/api/common/deptMnt")
public class DeptMntController {

	@Autowired
	private DeptMntService deptMntService;
	
	@GetMapping("/list")
	public List<Map<String, Object>> getDeptLists(){
		
		
		return deptMntService.getDeptList();
	}
}
