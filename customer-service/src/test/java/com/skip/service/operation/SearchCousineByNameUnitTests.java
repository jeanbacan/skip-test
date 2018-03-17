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

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;

import com.skip.service.domain.Cousine;

/**
 * Unit tests for Search Cousines by Name
 */
@RunWith(MockitoJUnitRunner.class)
public class SearchCousineByNameUnitTests {

	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
	@Autowired
	private ICommandOperation<String, List<Cousine>> searchCousineCommand;

	@Test
	public void testNullParameter() {
		List<Cousine> result = this.searchCousineCommand.execute(null);
		assertTrue("List should not be empty", result != null);
	}

	@Test
	public void findByName() {
		List<Cousine> result = this.searchCousineCommand.execute("a");
		assertTrue("List should return at least one", result.size() > 0);
	}

}
