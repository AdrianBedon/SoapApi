package com.soapapi.SoapApi;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import viajesapi.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

	Customer findById(long id);
}

