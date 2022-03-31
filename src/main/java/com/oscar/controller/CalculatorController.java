package com.oscar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oscar.model.Add;
import com.oscar.model.AddResponse;
import com.oscar.model.ObjectFactory;
import com.oscar.service.SoapClient;

@RestController
@RequestMapping("/calculadora")
public class CalculatorController {

	
	@Autowired
	private SoapClient soapClient;
	
	@GetMapping(value="/suma/{num1}/{num2}", produces = MediaType.APPLICATION_XML_VALUE)
	public AddResponse addition(@PathVariable String num1, @PathVariable String num2 ) {
		ObjectFactory factory = new ObjectFactory();
		Add requestAdd = factory.createAdd();
		requestAdd.setIntA(Integer.parseInt(num1));
		requestAdd.setIntB(Integer.parseInt(num2));
		
		AddResponse response = soapClient.additionOperation(requestAdd,"http://tempuri.org/Add");
		return response;
	}
}
