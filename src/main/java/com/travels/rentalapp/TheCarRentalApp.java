package com.travels.rentalapp;

import com.travels.rentalapp.route.TravelRoute;
import com.travels.rentalapp.vehicles.Vehicle;
import com.travels.rentalapp.vehicles.constants.AirContition;
import com.travels.rentalapp.vehicles.constants.FuelTypes;
import com.travels.rentalapp.vehicles.constants.VehicleType;

public class TheCarRentalApp {

	public static double getTotalTripExpence(VehicleType vehicle, FuelTypes fuelType, boolean ACorNonAC, String tripRoute){
		
		Vehicle tripVehicle = new Vehicle.VehicleBuilder(vehicle)
				                  .setAirContition(ACorNonAC? AirContition.AC: AirContition.NONAC)
				                  .setFuelType(fuelType)
				                  .build();
		
		//Not mentioned as input requirement!
		tripVehicle.bookSeats(3);
		
		TravelRoute travelRoute = new TravelRoute(tripRoute);
		
		double tripRate = tripVehicle.getRentRate();
		double kilometers = travelRoute.getTotalDist();
		
		return tripRate * kilometers * tripVehicle.getSeatOccupied();
	};
}
