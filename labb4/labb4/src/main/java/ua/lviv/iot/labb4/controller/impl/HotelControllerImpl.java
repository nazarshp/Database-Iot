package ua.lviv.iot.labb4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.controller.HotelController;
import ua.lviv.iot.labb4.domain.Hotel;
import ua.lviv.iot.labb4.service.HotelService;

import java.util.List;
import java.util.Optional;

@Service
public class HotelControllerImpl implements HotelController {
    @Autowired
    private HotelService hotelService;

    @Override
    public List<Hotel> findAll() {
        return hotelService.findAll();
    }

    @Override
    public Optional<Hotel> findById(Integer id) {
        return hotelService.findById(id);
    }

    @Override
    public int create(Hotel hotel) {
        return hotelService.create(hotel);
    }

    @Override
    public int update(Integer id, Hotel hotel) {
        return hotelService.update(id, hotel);
    }

    @Override
    public int delete(Integer id) {
        return hotelService.delete(id);
    }

}
