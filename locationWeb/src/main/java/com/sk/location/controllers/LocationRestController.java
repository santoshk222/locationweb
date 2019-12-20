package com.sk.location.controllers;

/***********************************************************************
 * History.
 * 21.12.2019 Created initial version
 * 
 **********************************************************************/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.location.entities.Location;
import com.sk.location.repos.LocationRepository;

/**
 * Rest controller to manage locations.
 * 
 * @author Santosh Korade.
 *
 */
@RestController
@RequestMapping("/locations")
public class LocationRestController {

	/**
	 * Repository.
	 */
	@Autowired
	LocationRepository locationRepo;

	/**
	 * get all Locations.
	 * 
	 * @return list of locations
	 */
	@GetMapping
	public List<Location> getLocations() {
		return locationRepo.findAll();
	}

	/**
	 * createLocations
	 * 
	 * @param location
	 *             location
	 * @return location
	 */
	@PostMapping
	public Location createLocations(@RequestBody Location location) {
		return locationRepo.save(location);
	}

	/**
	 * update Locations.
	 * 
	 * @param location
	 *             location
	 * @return location
	 */
	@PutMapping
	public Location updateLocations(@RequestBody Location location) {
		return locationRepo.save(location);
	}

	/**
	 * delete Location.
	 * 
	 * @param id
	 *             id
	 */
	@DeleteMapping("/{id}")
	public void deleteLocations(@PathVariable int id) {
		locationRepo.deleteById(id);
	}

	/**
	 * returns one Location.
	 * 
	 * @param id
	 *             id
	 * @return Location
	 */
	@GetMapping("/{id}")
	public Location getLocations(@PathVariable int id) {
		return locationRepo.findById(id).get();

	}
}
