package com.travels.rentalapp.route;

import java.util.ArrayList;

public class TravelRoute {
	
	ArrayList<Route> routes = new ArrayList<Route>();
	
	public TravelRoute(String travelPlaces) {
		String[] placesArray = travelPlaces.split("-");
		String lastPlaceVisited = placesArray.length > 0 ? placesArray[0] : "";
		
		for(String place : placesArray) { 
		   routes.add(new Route(lastPlaceVisited, place));
		   lastPlaceVisited = place;
		}
	}

	public double getTotalDist(){
		double totalDistance = 0.0;
		for(Route route: routes){
			totalDistance += route.getDistance();
		}
		return totalDistance;
	}
}
