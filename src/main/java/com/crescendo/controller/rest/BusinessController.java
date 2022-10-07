package com.crescendo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crescendo.dto.BusinessDto;
import com.crescendo.service.IBusinessService;

@RestController
@RequestMapping(value = "/api")
public class BusinessController {
	
	@Autowired
	private IBusinessService businessService;
	
	@GetMapping(value = "/businesses")
	public List<BusinessDto> getAllBusiness() {
		return businessService.getAllBusiness();
	}
	
	@GetMapping(value = "/businesses/{businessId}")
	public List<BusinessDto> getAllBusinessById(@PathVariable String businessId) {
		return businessService.getAllBusiness();
	}
	
	@PostMapping(value = "/businesses/")
	public BusinessDto createBusiness(@RequestBody BusinessDto dto) {
		return businessService.create(dto);
	}
	
	@PutMapping(value = "/businesses/{businessId}")
	public BusinessDto updateBusiness(@PathVariable long businessId, @RequestBody BusinessDto dto) {
		dto.setId(businessId);
		return businessService.update(dto);
	}
	
	@DeleteMapping(value = "/businesses/{businessId}")
	public void delete(@PathVariable long businessId) {
		businessService.delete(businessId);
	}

}
