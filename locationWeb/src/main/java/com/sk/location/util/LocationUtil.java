package com.sk.location.util;

import java.util.List;

import com.sk.location.entities.Location;

public class LocationUtil {

	public static String action;

	public static void composeMail(String action, String email, Object object, EmailUtil emailUtil) {

		email = "santoshspringxyz@gmail.com";
		String subject = "";
		Location location = null;
		List<Location> list = null;
		if (object instanceof Location) {
			location = (Location) object;
		} else if (object instanceof List<?>) {
			list = (List<Location>) object;
		}
		String locationDetails = "Location details are: \n" + location;
		StringBuilder builder = new StringBuilder();
		builder.append("Hello " + email.substring(0, email.indexOf("@")));
		if (action.equalsIgnoreCase(MailActionsConstatnts.NEW)) {
			subject = "New location created";
			builder.append("New location is added in the repository with id : " + location.getId());
			builder.append(locationDetails);
		} else if (action.equals(MailActionsConstatnts.UPDATE)) {
			subject = "location updated";
			builder.append("location is updated in the repository.");
			builder.append(locationDetails);
		} else if (action.equals(MailActionsConstatnts.DELETE)) {
			subject = "location deleted";
			builder.append("location is deleted from the repository.");
		} else if (action.equals(MailActionsConstatnts.GETALL)) {
			subject = "All location Report";
			builder.append("location is deleted from the repository.");
			for (Location location2 : list) {
				builder.append("\n");
				builder.append(location2);
			}
		}
		emailUtil.sendMail(email, subject, builder.toString());
	}

}
