package ua.lviv.iot.labb4.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.dao.ReservedDao;
import ua.lviv.iot.labb4.domain.Reserved;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ReservedDaoImpl implements ReservedDao {
    private static final String FIND_ALL = "SELECT * FROM reserved";
    private static final String CREATE = "INSERT reserved(from_date, to_date) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE reserved SET from_date=?, to_date=? WHERE id=?";
    private static final String DELETE = "DELETE FROM reserved WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM reserved WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Reserved> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Reserved.class));
    }

    @Override
    public Optional<Reserved> findById(Integer id) {
        Optional<Reserved> reserved;
        try {
            reserved = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Reserved.class), id));
        } catch (EmptyResultDataAccessException e) {
            reserved = Optional.empty();
        }
        return reserved;
    }

    @Override
    public int create(Reserved reserved) {
        return jdbcTemplate.update(CREATE, reserved.getFrom_date(), reserved.getTo_date());
    }

    @Override
    public int update(Integer id, Reserved reserved) {
        return jdbcTemplate.update(UPDATE, reserved.getFrom_date(), reserved.getTo_date(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

}
