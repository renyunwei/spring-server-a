package com.ryw.server.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.ryw.server.common.RestTemplateExt;
import com.ryw.server.config.ContextConfig;

@RestController
public class ServerATestController {

	private static final Logger logger = LoggerFactory.getLogger(ServerATestController.class);
	
	@Autowired
	private Registration registration;
	
	@Value("${server.port}")
	private String serverPort;
	
	@Autowired
	private RestTemplateExt restTemplateExt;
	
	@Autowired
	private ContextConfig contextConfig;
	
	@RequestMapping(value = "hello-test", method = RequestMethod.GET)
	public String helloWorldA() {
		logger.info("hello world A server,this service's port is {}",serverPort);
		logger.info("/hello-test, host:" + registration.getHost() + ", service_id:" + registration.getServiceId());
		return "hello world A server";
	}
	
	@RequestMapping(value = "ribbon-test", method = RequestMethod.GET)
	public String ribbonTest() {
		logger.info("testing ribbon is started");
		
		Map<String, Object> requestMap = Maps.newHashMap();
		requestMap.put("username", "任云威");
		
		logger.info("server url:-->{}",contextConfig.getSpringServerB());
		
		String result = restTemplateExt.getForObject(contextConfig.getSpringServerB(), "hello-test", requestMap, String.class);
		
		return "hello world A server, that " + contextConfig.getSpringServerB() + "/hello-test result is " + result;
	} 
	
}
