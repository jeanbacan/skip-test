package com.skip.service.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skip.service.dto.CousineDTO;
import com.skip.service.dto.StoreDTO;
import com.skip.service.operation.ICommandOperation;

/**
 * Responsible for cousine operations
 * 
 * @author Note-Chronos
 *
 */
@RestController
@RequestMapping("/Cousine")
public class CousineResource {

	@Autowired
	private ICommandOperation<String, List<CousineDTO>> searchCousines;
	
	@Autowired
	private ICommandOperation<Long, List<StoreDTO>> getStoresByCousineId;

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
	 * Search for specific cousine by name
	 * @param searchText
	 * @return
	 */
	@RequestMapping(value = "/search/{searchText}", method=RequestMethod.GET)
	  public List<CousineDTO> searchByName(@PathVariable String searchText){
		  return searchCousines
				  .execute(searchText);
	  }

	/**
	 * Get stores by cousine
	 * @return List<StoreDTO> available stores
	 */
	@RequestMapping(value = "/{cousineId}/stores", method=RequestMethod.GET)
	  public List<StoreDTO> getCousineById(@PathVariable Long cousineId){
		  return getStoresByCousineId.execute(cousineId);
	  }
	
}
