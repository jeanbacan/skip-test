package com.skip.service.operation;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import com.skip.service.dto.StoreDTO;
import com.skip.service.operation.bean.GetStoresByCousineId;
import com.skip.service.repository.StoreRepository;

/**
 * Unit tests for Stores by Cousines Command
 */
@RunWith(MockitoJUnitRunner.class)
public class GetStoresByCousineIdUnitTests {

	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock
	private StoreRepository storeRepository;
	
	//Could work better on tests with more cenarios. BDD
	
	@Test
	public void testNullParameter() {
		GetStoresByCousineId getStoresByCousineId = new GetStoresByCousineId();
		getStoresByCousineId.setStoreRepository(storeRepository);
		
		List<StoreDTO> result = getStoresByCousineId.execute(null);
		assertTrue("List should not be empty", result != null);
	}

	@Test
	public void findByName() {
		GetStoresByCousineId getStoresByCousineId = new GetStoresByCousineId();
		getStoresByCousineId.setStoreRepository(storeRepository);
		
		List<StoreDTO> result = getStoresByCousineId.execute(1L);
		assertTrue("List should return at least one", result.size() > 0);
	}

}
