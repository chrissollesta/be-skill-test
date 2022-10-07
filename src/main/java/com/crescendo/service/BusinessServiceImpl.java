package com.crescendo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescendo.dto.BusinessDto;
import com.crescendo.mapper.BusinessMapper;
import com.crescendo.model.Business;
import com.crescendo.repository.BusinessRepository;

@Service
public class BusinessServiceImpl implements IBusinessService {
	
	@Autowired
	private BusinessRepository businessRepository;

	@Override
	public List<BusinessDto> getAllBusiness() {
		var businesses = businessRepository.findAll();
		var businessDtos = businesses.stream()
				.map(business -> BusinessMapper.toDto(business))
				.collect(Collectors.toList());
		return businessDtos;
	}
	
	@Override
	public List<BusinessDto> getAllBusinessById(long id) {
		var ids = new ArrayList<Long>();
		ids.add(id);
		
		var businesses = businessRepository.findAllById(ids);
		var businessDtos = businesses.stream()
				.map(business -> BusinessMapper.toDto(business))
				.collect(Collectors.toList());
		return businessDtos;
	}

	@Override
	public BusinessDto getById(long id) {
		Optional<Business> optBusiness = businessRepository.findById(id);
		if(optBusiness.isPresent()) {
			Business business = optBusiness.get();
			return BusinessMapper.toDto(business);
		}
		return null;
	}

	@Override
	public BusinessDto create(BusinessDto dto) {
		var savedBusiness = businessRepository.save(BusinessMapper.toEntity(dto));
		return BusinessMapper.toDto(savedBusiness);
	}

	@Override
	public BusinessDto update(BusinessDto dto) {
		var businessToBeUpdated = BusinessMapper.toEntity(dto);
		Optional<Business> optBusiness = businessRepository.findById(dto.getId());
		if(optBusiness.isPresent()) {
			var savedBusiness = optBusiness.get();
			businessToBeUpdated.setReviews(savedBusiness.getReviews());
		}
		
		var updatedBusiness = businessRepository.save(businessToBeUpdated);
		return BusinessMapper.toDto(updatedBusiness);
	}

	@Override
	public void delete(long id) {
		businessRepository.deleteById(id);
	}

}
