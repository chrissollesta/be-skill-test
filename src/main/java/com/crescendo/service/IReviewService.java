package com.crescendo.service;

import java.util.List;

import com.crescendo.dto.ReviewDto;

public interface IReviewService {
	
	List<ReviewDto> getAllReviewsByBusinessId(long businessId);
	
	ReviewDto create(ReviewDto dto, long businessId);
	
}
