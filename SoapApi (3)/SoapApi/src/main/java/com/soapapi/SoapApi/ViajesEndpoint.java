package com.soapapi.SoapApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import viajesapi.GetCustomerRequest;
import viajesapi.GetCustomerResponse;

@Endpoint
public class ViajesEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080";

	private CustomerRepository customerRepository;

	@Autowired
	public ViajesEndpoint(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCustomerResponse getCountry(@RequestPayload GetCustomerRequest request) {
		GetCustomerResponse response = new GetCustomerResponse();
		response.setCustomer(customerRepository.findById(request.getId()));

		return response;
	}
    
}
