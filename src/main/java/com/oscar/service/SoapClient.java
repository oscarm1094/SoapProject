package com.oscar.service;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.oscar.model.Add;
import com.oscar.model.AddResponse;

public class SoapClient extends WebServiceGatewaySupport{
	
	public AddResponse additionOperation(Add request, String soapAction) {
		AddResponse response = (AddResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request, new SoapActionCallback(soapAction));
		return response;
	}

}
