package com.crescendo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescendo.dto.ReviewDto;
import com.crescendo.mapper.ReviewMapper;
import com.crescendo.model.Business;
import com.crescendo.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements IReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public List<ReviewDto> getAllReviewsByBusinessId(long businessId) {
		var reviews = reviewRepository.findByBusinessId(businessId);
		return reviews.stream().map(review -> ReviewMapper.toDto(review)).collect(Collectors.toList());
	}

	@Override
	public ReviewDto create(ReviewDto dto, long businessid) {
		var business = new Business();
		business.setId(businessid);
		
		var review = ReviewMapper.toEntity(dto);
		review.setBusiness(business);
		
		var savedReview = reviewRepository.save(review);
		
		return ReviewMapper.toDto(savedReview);
	}

}
