package com.ua.lviv.iot.lab5_back_end.service.impl;

import com.ua.lviv.iot.lab5_back_end.domain.Review;
import com.ua.lviv.iot.lab5_back_end.exception.ReviewNotFoundException;
import com.ua.lviv.iot.lab5_back_end.repository.ReviewRepository;
import com.ua.lviv.iot.lab5_back_end.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public Review findById(Integer id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Transactional
    public Review create(Review review) {
        reviewRepository.save(review);
        return review;
    }

    @Transactional
    public void update(Integer id, Review uReview) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));

        //update
        review.setRaiting(uReview.getRaiting());
        review.setDescription(uReview.getDescription());
        review.setDate(uReview.getDate());
        reviewRepository.save(review);
    }

    @Transactional
    public void delete(Integer id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));
        reviewRepository.delete(review);
    }
}
