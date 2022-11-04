package ua.lviv.iot.labb4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.controller.LocationController;
import ua.lviv.iot.labb4.domain.Location;
import ua.lviv.iot.labb4.service.LocationService;

import java.util.List;
import java.util.Optional;

@Service
public class LocationControllerImpl implements LocationController {
    @Autowired
    private LocationService locationService;

    @Override
    public List<Location> findAll() {
        return locationService.findAll();
    }

    @Override
    public Optional<Location> findById(Integer id) {
        return locationService.findById(id);
    }

    @Override
    public int create(Location client) {
        return locationService.create(client);
    }

    @Override
    public int update(Integer id, Location location) {
        return locationService.update(id, location);
    }

    @Override
    public int delete(Integer id) {
        return locationService.delete(id);
    }

}
