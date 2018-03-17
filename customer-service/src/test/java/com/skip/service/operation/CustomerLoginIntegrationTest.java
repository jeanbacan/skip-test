/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skip.service.operation;

import static org.junit.Assume.assumeTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skip.service.exception.UserNotFoundException;
import com.skip.service.operation.bean.CustomerAuthenticate;
import com.skip.service.repository.CustomerRepository;

/**
 * Unit tests for Search Cousines by Name
 */
@SpringBootTest
@Category(IIntegrationCategory.class)
public class CustomerLoginIntegrationTest {

	private CustomerAuthenticate auth = new CustomerAuthenticate();
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@BeforeClass
	public void initIntegration() {
		auth.setCustomerRepository(customerRepository);
		//init authentication object and datas
	}
	
	@Test
	public void testLogin() {
		assumeTrue(true);
	}

	@Test
	public void testCachedUser() {
		assumeTrue(true);
	}

	@Test
	public void testCorrectPassword() {
		assumeTrue(true);
	}


	@Test(expected=UserNotFoundException.class)
	public void testWrongPassword() {
		assumeTrue(true);
	}
	
}
