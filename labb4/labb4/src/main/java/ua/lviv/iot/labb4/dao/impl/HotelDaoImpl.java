package ua.lviv.iot.labb4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.dao.HotelDao;
import ua.lviv.iot.labb4.domain.Hotel;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class HotelDaoImpl implements HotelDao {
    private static final String FIND_ALL = "SELECT * FROM hotel";
    private static final String CREATE = "INSERT hotel(name, phone, hotel_code) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE hotel SET name=?, phone=?, hotel_code=? WHERE id=?";
    private static final String DELETE = "DELETE FROM hotel WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM hotel WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Hotel> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Hotel.class));
    }

    @Override
    public Optional<Hotel> findById(Integer id) {
        Optional<Hotel> hotel;
        try {
            hotel = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Hotel.class), id));
        } catch (EmptyResultDataAccessException e) {
            hotel = Optional.empty();
        }
        return hotel;
    }

    @Override
    public int create(Hotel hotel) {
        return jdbcTemplate.update(CREATE, hotel.getName(), hotel.getPhone(), hotel.getHotel_code());
    }

    @Override
    public int update(Integer id, Hotel hotel) {
        return jdbcTemplate.update(UPDATE, hotel.getName(), hotel.getPhone(), hotel.getHotel_code(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

}
