package com.skip.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skip.service.domain.Customer;
import com.skip.service.dto.CustomerLoggedDTO;
import com.skip.service.dto.UserAuthDTO;
import com.skip.service.operation.ICommandOperation;

/**
 * Responsible for cousine operations
 * 
 * @author Note-Chronos
 *
 */
@RestController
@RequestMapping("/Customer")
public class CustomerResource {

	@Autowired
	private ICommandOperation<UserAuthDTO, CustomerLoggedDTO> authenticateUser;
	
	@Autowired
	private ICommandOperation<Customer, Long> createUser;

	/**
	 * Return the cousine end-point with services
	 * 
	 * @return String empty
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getCousine() {
		return "";
	}

	/**
	 * Create User
	 * @param Customer object customer
	 * @return Long user id
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Long createUser(Customer customer){
		  return createUser.execute(customer);
	  }

	/**
	 * Get stores by cousine
	 * @return List<StoreDTO> available stores
	 */
	@RequestMapping(value = "/auth", method=RequestMethod.POST)
	  public CustomerLoggedDTO authenticateUser(UserAuthDTO authUserDTO){
		  return authenticateUser.execute(authUserDTO);
	  }
	
}
