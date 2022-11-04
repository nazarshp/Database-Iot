package ua.lviv.iot.labb4.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.dao.RoomDao;
import ua.lviv.iot.labb4.domain.Room;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class RoomDaoImpl implements RoomDao {
    private static final String FIND_ALL = "SELECT * FROM room";
    private static final String CREATE = "INSERT room(number, floor, price, type) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE room SET number=?, floor=?, price=?, type=? WHERE id=?";
    private static final String DELETE = "DELETE FROM room WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM room WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Room> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Room.class));
    }

    @Override
    public Optional<Room> findById(Integer id) {
        Optional<Room> room;
        try {
            room = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Room.class), id));
        } catch (EmptyResultDataAccessException e) {
            room = Optional.empty();
        }
        return room;
    }

    @Override
    public int create(Room room) {
        return jdbcTemplate.update(CREATE, room.getNumber(), room.getFloor(), room.getPrice(), room.getType());
    }

    @Override
    public int update(Integer id, Room room) {
        return jdbcTemplate.update(UPDATE, room.getNumber(), room.getFloor(), room.getPrice(), room.getType(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

}