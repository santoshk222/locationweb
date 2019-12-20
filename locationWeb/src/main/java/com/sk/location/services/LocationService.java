package com.sk.location.services;

/***********************************************************************
 * History.
 * 
 * 21.12.2019 Created.
 **********************************************************************/
import java.util.List;

import com.sk.location.entities.Location;

public interface LocationService {

	Location saveLocation(Location location);

	Location updateLocation(Location location);

	void deleteLocation(Location location);

	Location getLocationById(int id);

	List<Location> getAll();
}
