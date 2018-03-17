package com.skip.service.operation.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skip.service.domain.Cousine;
import com.skip.service.dto.CousineDTO;
import com.skip.service.operation.ICommandOperation;
import com.skip.service.repository.CousineRepository;

/**
 * Command to search for cousines by text
 * @author Note-Chronos
 *
 */
public class SearchCousinesByNameOperation implements ICommandOperation<String, List<CousineDTO>> {

	@Autowired
	private CousineRepository cousineRepository;
	
	@Override
	public List<CousineDTO> execute(String param) {
		
		List<CousineDTO> returnList = new ArrayList<>();
				
		List<Cousine> cousines = cousineRepository.findByName(param);
		
		//With proper time this could go to DTO helper or a DTO Wrapper pattern
		cousines.stream().
			map(obj -> new CousineDTO(obj.getId(), obj.getName())).
			forEach(returnList::add);
		
		return returnList;
	}
	
	public void setStoreRepository(CousineRepository cousineRepository) {
		this.cousineRepository = cousineRepository;
	}

}
