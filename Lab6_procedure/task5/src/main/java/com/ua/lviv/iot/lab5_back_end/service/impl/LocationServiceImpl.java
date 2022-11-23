package com.ua.lviv.iot.lab5_back_end.service.impl;

import com.ua.lviv.iot.lab5_back_end.domain.Location;
import com.ua.lviv.iot.lab5_back_end.exception.LocationNotFoundException;
import com.ua.lviv.iot.lab5_back_end.repository.LocationRepository;
import com.ua.lviv.iot.lab5_back_end.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    public Location findById(Integer id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Transactional
    public Location create(Location location) {
        locationRepository.save(location);
        return location;
    }

    @Transactional
    public void update(Integer id, Location uLocation) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));

        //update
        location.setStreet(uLocation.getStreet());
        location.setCity(uLocation.getCity());
        locationRepository.save(location);
    }

    @Transactional
    public void delete(Integer id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
        locationRepository.delete(location);
    }
}
