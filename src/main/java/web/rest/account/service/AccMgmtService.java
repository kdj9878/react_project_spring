package web.rest.account.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.rest.account.dao.AccMgmtDao;

@Service
public class AccMgmtService {
	
	private static final Logger log = LoggerFactory.getLogger(AccMgmtService.class);
	
	@Autowired
	private AccMgmtDao accMgmtDao;
	

}
