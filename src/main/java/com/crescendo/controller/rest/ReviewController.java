package com.crescendo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crescendo.dto.ReviewDto;
import com.crescendo.service.IReviewService;

@RestController
@RequestMapping(value = "/api")
public class ReviewController {
	
	@Autowired
	private IReviewService reviewService;
	
	@GetMapping(value = "/businesses/{businessId}/reviews")
	public List<ReviewDto> getAllReviewsByBusinessId(@PathVariable long businessId){
		return reviewService.getAllReviewsByBusinessId(businessId);
	}
	
	
	@PostMapping(value = "/businesses/{businessId}/reviews")
	public ReviewDto getAllReviewsByBusinessId(@PathVariable long businessId, @RequestBody ReviewDto dto){
		return reviewService.create(dto, businessId);
	}
	
	
}
