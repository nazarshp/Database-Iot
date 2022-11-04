package ua.lviv.iot.labb4.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.dao.ReviewDao;
import ua.lviv.iot.labb4.domain.Review;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ReviewDaoImpl implements ReviewDao {
    private static final String FIND_ALL = "SELECT * FROM review";
    private static final String CREATE = "INSERT review(raiting, description, date) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE review SET raiting=?, description=?, date=? WHERE id=?";
    private static final String DELETE = "DELETE FROM review WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM review WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Review> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Review.class));
    }

    @Override
    public Optional<Review> findById(Integer id) {
        Optional<Review> review;
        try {
            review = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Review.class), id));
        } catch (EmptyResultDataAccessException e) {
            review = Optional.empty();
        }
        return review;
    }

    @Override
    public int create(Review review) {
        return jdbcTemplate.update(CREATE, review.getRaiting(), review.getDescription(), review.getDate());
    }

    @Override
    public int update(Integer id, Review review) {
        return jdbcTemplate.update(UPDATE, review.getRaiting(), review.getDescription(), review.getDate(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

}
