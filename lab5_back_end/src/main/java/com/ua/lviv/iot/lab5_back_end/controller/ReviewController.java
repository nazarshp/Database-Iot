package com.ua.lviv.iot.lab5_back_end.controller;

import com.ua.lviv.iot.lab5_back_end.domain.Review;
import com.ua.lviv.iot.lab5_back_end.dto.ReviewDto;
import com.ua.lviv.iot.lab5_back_end.dto.assembler.ReviewDtoAssembler;
import com.ua.lviv.iot.lab5_back_end.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewDtoAssembler reviewDtoAssembler;

    @GetMapping(value = "/{reviewId}")
    public ResponseEntity<ReviewDto> getReview(@PathVariable Integer reviewId) {
        Review review = reviewService.findById(reviewId);
        ReviewDto reviewDto = reviewDtoAssembler.toModel(review);
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ReviewDto>> getAllReviews() {
        List<Review> reviews = reviewService.findAll();
        CollectionModel<ReviewDto> reviewDtos = reviewDtoAssembler.toCollectionModel(reviews);
        return new ResponseEntity<>(reviewDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ReviewDto> addReview(@RequestBody Review review) {
        Review newReview = reviewService.create(review);
        ReviewDto reviewDto = reviewDtoAssembler.toModel(newReview);
        return new ResponseEntity<>(reviewDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{reviewId}")
    public ResponseEntity<?> updateReview(@RequestBody Review uReview, @PathVariable Integer reviewId) {
        reviewService.update(reviewId, uReview);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Integer reviewId) {
        reviewService.delete(reviewId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
