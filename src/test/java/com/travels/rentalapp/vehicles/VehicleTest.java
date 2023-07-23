package com.travels.rentalapp.vehicles;

import static org.junit.Assert.*;

import org.junit.Test;

import com.travels.rentalapp.vehicles.Vehicle;
import com.travels.rentalapp.vehicles.constants.AirContition;
import com.travels.rentalapp.vehicles.constants.FuelTypes;
import com.travels.rentalapp.vehicles.constants.VehicleType;

public class VehicleTest {

	@Test
	public void buildCar() {
		Vehicle car =  new Vehicle.VehicleBuilder(VehicleType.CAR).build();
		
		assertEquals(VehicleType.CAR, car.getType());
		assertEquals(FuelTypes.PETROL, car.getFuelType());
		assertEquals(AirContition.NONAC, car.getAirContition());
		assertEquals(4, car.getSeatingCapacity());
	}

	@Test
	public void buildSUV() {
		Vehicle suv =  new Vehicle.VehicleBuilder(VehicleType.SUV).build();
		
		assertEquals(VehicleType.SUV, suv.getType());
		assertEquals(FuelTypes.DIESEL, suv.getFuelType());
		assertEquals(AirContition.AC, suv.getAirContition());
		assertEquals(7, suv.getSeatingCapacity());
	}

	@Test
	public void buildBus() {
		Vehicle bus =  new Vehicle.VehicleBuilder(VehicleType.BUS).build();
		
		assertEquals(VehicleType.BUS, bus.getType());
		assertEquals(FuelTypes.DIESEL, bus.getFuelType());
		assertEquals(AirContition.NONAC, bus.getAirContition());
		assertEquals(30, bus.getSeatingCapacity());
	}

	@Test
	public void buildVan() {
		Vehicle van =  new Vehicle.VehicleBuilder(VehicleType.VAN).build();
		
		assertEquals(VehicleType.VAN, van.getType());
		assertEquals(FuelTypes.DIESEL, van.getFuelType());
		assertEquals(AirContition.NONAC, van.getAirContition());
		assertEquals(15, van.getSeatingCapacity());
	}

	@Test
	public void buildVanWithACandPetrol() {
		Vehicle van =  new Vehicle.VehicleBuilder(VehicleType.VAN)
				.setAirContition(AirContition.AC)
				.setFuelType(FuelTypes.PETROL)
				.setSeatingCapacity(20)
				.build();
		
		assertEquals(VehicleType.VAN, van.getType());
		assertEquals(FuelTypes.PETROL, van.getFuelType());
		assertEquals(AirContition.AC, van.getAirContition());
		assertEquals(20, van.getSeatingCapacity());
	}

	@Test
	public void getPetrolNonACCarRentalRate(){
		Vehicle car =  new Vehicle.VehicleBuilder(VehicleType.CAR).build();
		car.bookSeats(3);
		
		assertEquals(3, car.getSeatOccupied());
		assertEquals(14.0 , car.getRentRate(), 0.05);
	}
	
	@Test
	public void getPetrolNonACCarExtraPersonRentalRate(){
		Vehicle car =  new Vehicle.VehicleBuilder(VehicleType.CAR).build();
		car.bookSeats(3);
		car.bookSeats(2);
		
		assertEquals(5, car.getSeatOccupied());
		assertEquals(15.0 , car.getRentRate(), 0.05);
	}

	@Test
	public void getDeiselNonACBusRentalRate(){
		Vehicle car =  new Vehicle.VehicleBuilder(VehicleType.BUS).build();
		car.bookSeats(27);
		
		assertEquals(27, car.getSeatOccupied());
		assertEquals(12.7 , car.getRentRate(), 0.05);
	}

	@Test
	public void getDieselACSUVRentalRate(){
		Vehicle car =  new Vehicle.VehicleBuilder(VehicleType.SUV).build();
		car.bookSeats(7);
		
		assertEquals(7, car.getSeatOccupied());
		assertEquals(15.0 , car.getRentRate(), 0.05);
	}

}
