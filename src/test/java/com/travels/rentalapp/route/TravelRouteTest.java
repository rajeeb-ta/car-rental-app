package com.travels.rentalapp.route;

import static org.junit.Assert.*;

import org.junit.Test;

import com.travels.rentalapp.route.TravelRoute;

public class TravelRouteTest {

	@Test
	public void distanceFromPuneToMumbai() {
		TravelRoute travelRoute = new TravelRoute("Pune-Mumbai");
		
		assertEquals(200.0, travelRoute.getTotalDist(), 0.05);
		
	}

	@Test
	public void distanceFromPuneToMumbaiPune() {
		TravelRoute travelRoute = new TravelRoute("Pune-Mumbai-Pune");
		
		assertEquals(400.0, travelRoute.getTotalDist(), 0.05);
		
	}

	@Test
	public void distanceFromPuneToPune() {
		TravelRoute travelRoute = new TravelRoute("Pune-Pune");
		
		assertEquals(0.0, travelRoute.getTotalDist(), 0.05);
		
	}

	@Test
	public void distanceFromPuneChennaiBangalore() {
		TravelRoute travelRoute = new TravelRoute("Pune-Chennai-Bangalore");
		
		assertEquals(1580.2, travelRoute.getTotalDist(), 0.05);
		
	}
}
