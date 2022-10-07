package com.crescendo.service;

import java.util.List;

import com.crescendo.dto.BusinessDto;

public interface IBusinessService {
	
	List<BusinessDto> getAllBusiness();
	
	List<BusinessDto> getAllBusinessById(long id);
	
	BusinessDto getById(long id);
	
	BusinessDto create(BusinessDto dto);
	
	BusinessDto update(BusinessDto dto);
	
	void delete(long dto);
	
}
