package com.ua.lviv.iot.lab5_back_end.service.impl;

import com.ua.lviv.iot.lab5_back_end.domain.Hotel;
import com.ua.lviv.iot.lab5_back_end.exception.HotelNotFoundException;
import com.ua.lviv.iot.lab5_back_end.repository.HotelRepository;
import com.ua.lviv.iot.lab5_back_end.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public Hotel findById(Integer id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));
    }

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Transactional
    public Hotel create(Hotel hotel) {
        hotelRepository.save(hotel);
        return hotel;
    }

    @Transactional
    public void update(Integer id, Hotel uHotel) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));

        //update
        hotel.setName(uHotel.getName());
        hotel.setPhone(uHotel.getPhone());
        hotel.setHotelCode(uHotel.getHotelCode());
        hotelRepository.save(hotel);
    }

    @Transactional
    public void delete(Integer id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));
        hotelRepository.delete(hotel);
    }
}
