package com.ua.lviv.iot.lab5_back_end.dto.assembler;

import com.ua.lviv.iot.lab5_back_end.controller.ReviewController;
import com.ua.lviv.iot.lab5_back_end.domain.Review;
import com.ua.lviv.iot.lab5_back_end.dto.ReviewDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ReviewDtoAssembler implements RepresentationModelAssembler<Review, ReviewDto> {
    @Override
    public ReviewDto toModel(Review entity) {
        ReviewDto reviewDto = ReviewDto.builder()
                .id(entity.getId())
                .raiting(entity.getRaiting())
                .description(entity.getDescription())
                .date(entity.getDate())
                .build();
        Link selfLink = linkTo(methodOn(ReviewController.class).getReview(reviewDto.getId())).withSelfRel();
        reviewDto.add(selfLink);
        return reviewDto;
    }
}
