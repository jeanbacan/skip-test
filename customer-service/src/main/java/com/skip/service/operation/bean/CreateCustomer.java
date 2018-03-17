package com.skip.service.operation.bean;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skip.service.domain.Customer;
import com.skip.service.dto.CustomerLoggedDTO;
import com.skip.service.dto.UserAuthDTO;
import com.skip.service.operation.ICommandOperation;
import com.skip.service.repository.CustomerRepository;

/**
 * Command to search for cousines by text
 * @author Note-Chronos
 *
 */
public class CreateCustomer implements ICommandOperation<Customer, Long> {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public Long execute(Customer customer) {
		
		//Add validations to guarantee cusomer object, also encrypt password
		
		Customer newCustomer = customerRepository.save(customer);
		return newCustomer.getId();
	}
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
}
