package com.crescendo.mapper;

import java.util.stream.Collectors;

import com.crescendo.dto.BusinessDto;
import com.crescendo.model.Business;

public class BusinessMapper {
	
	public static BusinessDto toDto(Business entity) {
		BusinessDto dto = new BusinessDto();
		dto.setId(entity.getId());
		dto.setBusinessName(entity.getBusinessName());
		dto.setAddress(entity.getAddress());
		dto.setPhone(entity.getPhone());
		dto.setReviews(entity.getReviews()
				.stream()
				.map(review -> ReviewMapper.toDto(review))
				.collect(Collectors.toList()));
		return dto;
	}
	
	public static Business toEntity(BusinessDto dto) {
		Business entity = new Business();
		entity.setId(dto.getId());
		entity.setBusinessName(dto.getBusinessName());
		entity.setAddress(dto.getAddress());
		entity.setPhone(dto.getPhone());
		return entity;
	}

}
