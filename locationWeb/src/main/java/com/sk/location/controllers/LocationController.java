package com.sk.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sk.location.entities.Location;
import com.sk.location.repos.LocationRepository;
import com.sk.location.services.LocationService;
import com.sk.location.util.EmailUtil;
import com.sk.location.util.LocationConstants;
import com.sk.location.util.LocationUtil;
import com.sk.location.util.MailActionsConstatnts;
import com.sk.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	private LocationService service;
	@Autowired
	LocationRepository repo;
	@Autowired
	ReportUtil reportUtil;
	@Autowired
	ServletContext sc;
	@Autowired
	private EmailUtil emailUtil;

	@RequestMapping(value = { LocationConstants.CEATE_LOCATION_SHOW_PATH, "/", "home" })
	public String showCreate(ModelMap modal) {
		modal.addAttribute("location", new Location());
		modal.addAttribute("isEdit", false);
		return LocationConstants.CEATE_LOCATION_SHOW_FILE;
	}

	@RequestMapping(value = LocationConstants.CEATE_LOCATION_GET, method = RequestMethod.POST)
	public String getCreate(@ModelAttribute("location") Location location, BindingResult br, ModelMap map) {
		if (br.hasErrors()) {
			return "error";
		}
		Location savedLoc = service.saveLocation(location);
		String msg = "location Saved: " + savedLoc.getId();
		map.addAttribute("msg", msg);
		LocationUtil.composeMail(MailActionsConstatnts.NEW, "santoshspringxyz@gmail.com", location, emailUtil);
		return LocationConstants.REDIRECT + LocationConstants.DISPLAY_LOCATIONS_PATH;
	}

	@RequestMapping(value = LocationConstants.REPORT)
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> dataset = repo.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, dataset);
		return LocationConstants.REPORT_FILE;
	}

	@RequestMapping(value = LocationConstants.DISPLAY_LOCATIONS_PATH)
	public String displayAll(ModelMap modal) {
		List<Location> list = service.getAll();
		modal.addAttribute("locations", list);
		LocationUtil.composeMail(MailActionsConstatnts.GETALL, "santoshspringxyz@gmail.com", list, emailUtil);
		return LocationConstants.DISPLAY_LOCATIONS_FILE;
	}

	@RequestMapping(value = LocationConstants.DELETE_LOCATION_PATH + "/{" + LocationConstants.LOCATION_PATH_VAR + "}")
	public String deleteLocation(@PathVariable(LocationConstants.LOCATION_PATH_VAR) int id, ModelMap modal) {
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		LocationUtil.composeMail(MailActionsConstatnts.DELETE, "santoshspringxyz@gmail.com", location, emailUtil);
		return LocationConstants.REDIRECT + LocationConstants.DISPLAY_LOCATIONS_PATH;
	}

	@RequestMapping(value = LocationConstants.EDIT_LOCATION_PATH + "/{" + LocationConstants.LOCATION_PATH_VAR + "}")
	public String editLocation(@PathVariable(LocationConstants.LOCATION_PATH_VAR) int id, ModelMap modal) {

		Location location = service.getLocationById(id);
		if (location != null) {
			modal.addAttribute("location", location);
			modal.addAttribute("isEdit", true);
		}
		return LocationConstants.CEATE_LOCATION_SHOW_FILE;
	}

}
