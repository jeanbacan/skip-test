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
public class CustomerAuthenticate implements ICommandOperation<UserAuthDTO, CustomerLoggedDTO> {

	/**
	 * Can persist user data at mysql with cache. And at server with EhCache
	 */
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public CustomerLoggedDTO execute(UserAuthDTO customer) {
		
		//Authentications like JwtAuth and EhCache for user data
		
		
		CustomerLoggedDTO dto = new CustomerLoggedDTO(1L, "Name");
		return dto;
	}
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
}
