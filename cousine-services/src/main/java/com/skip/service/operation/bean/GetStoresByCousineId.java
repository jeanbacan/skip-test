package com.skip.service.operation.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skip.service.domain.Store;
import com.skip.service.dto.StoreDTO;
import com.skip.service.operation.ICommandOperation;
import com.skip.service.repository.StoreRepository;

/**
 * Command to search for cousines by text
 * @author Note-Chronos
 *
 */
public class GetStoresByCousineId implements ICommandOperation<Long, List<StoreDTO>> {

	@Autowired
	private StoreRepository storesRepository;
	
	@Override
	public List<StoreDTO> execute(Long param) {
		
		List<StoreDTO> returnList = new ArrayList<>();
				
		List<Store> stores = storesRepository.findByCousineId(param);
		
		//With proper time this could go to DTO helper or a DTO Wrapper pattern
		stores.stream().
			map(obj -> new StoreDTO(obj.getId(), obj.getName())).
			forEach(returnList::add);
		
		return returnList;
	}
	
	public void setStoreRepository(StoreRepository storesRepository) {
		this.storesRepository = storesRepository;
	}
}
