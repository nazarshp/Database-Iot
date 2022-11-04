package ua.lviv.iot.labb4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.controller.ReviewController;
import ua.lviv.iot.labb4.domain.Review;
import ua.lviv.iot.labb4.service.ReviewService;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewControllerImpl implements ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Override
    public List<Review> findAll() {
        return reviewService.findAll();
    }

    @Override
    public Optional<Review> findById(Integer id) {
        return reviewService.findById(id);
    }

    @Override
    public int create(Review payment) {
        return reviewService.create(payment);
    }

    @Override
    public int update(Integer id, Review review) {
        return reviewService.update(id, review);
    }

    @Override
    public int delete(Integer id) {
        return reviewService.delete(id);
    }

}