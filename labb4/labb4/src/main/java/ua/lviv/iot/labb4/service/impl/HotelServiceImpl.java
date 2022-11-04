package ua.lviv.iot.labb4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.dao.HotelDao;
import ua.lviv.iot.labb4.domain.Hotel;
import ua.lviv.iot.labb4.service.HotelService;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;

    @Override
    public List<Hotel> findAll() { return hotelDao.findAll(); }


    @Override
    public Optional<Hotel> findById(Integer id) {
        return hotelDao.findById(id);
    }

    @Override
    public int create(Hotel hotel) {
        return hotelDao.create(hotel);
    }

    @Override
    public int update(Integer id, Hotel hotel) {
        return hotelDao.update(id, hotel);
    }

    @Override
    public int delete(Integer id) {
        return hotelDao.delete(id);
    }

}
