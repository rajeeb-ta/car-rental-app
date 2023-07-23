package com.travels.rentalapp.route.service;

import java.util.HashMap;
import java.util.Map;

public class PlaceDistanceServiceImpl implements PlaceDistanceService {
	
	private Map<String, Double> distanceMap = new HashMap<String, Double>();
	
	//TODO: should make it replaceable for real and test calls
	public PlaceDistanceServiceImpl() {
		distanceMap.put("Pune-Pune", 0.0);
		distanceMap.put("Pune-Mumbai", 200.0);
		distanceMap.put("Pune-Bangalore", 1000.0);
		distanceMap.put("Pune-Delhi", 2050.0);
		distanceMap.put("Pune-Chennai", 1234.5);
		distanceMap.put("Bangalore-Chennai", 345.7);
	}

	@Override
	public double getDistance(String sourcePlace, String destinationPlace) {
		double distance = 0.0;
		if(distanceMap.get(sourcePlace+"-"+destinationPlace)!= null){
			distance = distanceMap.get(sourcePlace+"-"+destinationPlace);
		} else if (distanceMap.get(destinationPlace+"-"+sourcePlace)!= null) {
			distance = distanceMap.get(destinationPlace+"-"+sourcePlace);
		}
		return distance;
	
	}

}
