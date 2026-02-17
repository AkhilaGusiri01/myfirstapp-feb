package com.example.myfirstapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.myfirstapp.service.interfaces.AddService;

import jakarta.annotation.PostConstruct;
@Service

public class AddServiceImpl implements AddService {
	private static final Logger logger = LoggerFactory.getLogger(AddServiceImpl.class);
	//read server port from properties file and assign to serverport variable
	@Value("${server.port}")
	private int serverport;
	
	//read property my.propert from properties file and assign to myProperty variable
	@Value("${my.property}")
	private String myProperty;
	public AddServiceImpl() {
		logger.info("AddServiceImpl is called this: {}", this);
		logger.info("AddServiceImpl server port: {}", serverport);
		logger.info("AddServiceImpl myProperty: {}", myProperty);
	}
    @Override
    public int add(int val1, int val2) {
        int result= val1 + val2;
        return result;
    }


@PostConstruct
public void init()
{
	logger.info("AddServiceImpl init method called this: {}", this);
	logger.info("AddServiceImpl server port in init: {}", serverport);
	logger.info("AddServiceImpl myProperty in init: {}", myProperty);
}
}
//ctrl+shift+o to import the required packages