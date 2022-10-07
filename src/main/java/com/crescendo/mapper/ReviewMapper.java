package com.crescendo.mapper;

import com.crescendo.dto.ReviewDto;
import com.crescendo.model.Review;

public class ReviewMapper {
	
	public static ReviewDto toDto(Review entity) {
		ReviewDto dto = new ReviewDto();
		dto.setId(entity.getId());
		dto.setRating(entity.getRating());
		dto.setText(entity.getText());
		dto.setCreateDateTime(entity.getCreateDateTime());
		return dto;
	}
	
	public static Review toEntity(ReviewDto dto) {
		Review entity = new Review();
		entity.setId(dto.getId());
		entity.setRating(dto.getRating());
		entity.setText(dto.getText());
		entity.setCreateDateTime(dto.getCreateDateTime());
		return entity;
	}

}
