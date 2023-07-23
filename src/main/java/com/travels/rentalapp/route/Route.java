package com.travels.rentalapp.route;

import com.travels.rentalapp.route.service.PlaceDistanceService;
import com.travels.rentalapp.route.service.PlaceDistanceServiceImpl;

public class Route implements DistanceMeasurable {
	String source;
	String destination;
	double distanceFromSource;

	//TODO: inject this using spring bean
    PlaceDistanceService distanceService = new PlaceDistanceServiceImpl();
	
	public Route(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;

	}

	@Override
	public double getDistance(){
		double distance = distanceService.getDistance(this.source, this.destination);
		return distance;
	}
}
