package com.travels.rentalapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.travels.rentalapp.vehicles.constants.FuelTypes;
import com.travels.rentalapp.vehicles.constants.VehicleType;

public class TheCarRentalAppTest {

	@Test
	public void carRentRoundTripFare() {
	   	double tripfare = TheCarRentalApp.getTotalTripExpence(VehicleType.CAR, FuelTypes.DIESEL, false, "Pune-Mumbai-Pune");
	   	
	   	//KM:400, Person: 3, NonAC-Diesel-Car-Rate: 13
    	assertEquals(15600.0, tripfare, 0.05);
	}

	@Test
	public void carACPetrolRentOneWayTripFare() {
	   	double tripfare = TheCarRentalApp.getTotalTripExpence(VehicleType.CAR, FuelTypes.PETROL, true, "Pune-Bangalore");
	   	
	   	//KM: 1000 , Person: 3 , AC-Petrol-Car-Rate: 1 (14+2 )
    	assertEquals(48000.0, tripfare, 0.05);
	}


}
