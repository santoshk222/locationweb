package com.sk.location.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.location.entities.Location;
import com.sk.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository locationRepo;

	@Override
	public Location saveLocation(Location location) {
		return locationRepo.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return locationRepo.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		locationRepo.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		return locationRepo.findById(id).get();
		// return null;
	}

	@Override
	public List<Location> getAll() {
		return locationRepo.findAll();
	}

}
