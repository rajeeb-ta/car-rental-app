package com.travels.rentalapp.vehicles.states;

import com.travels.rentalapp.vehicles.Vehicle;
import com.travels.rentalapp.vehicles.constants.AirContition;
import com.travels.rentalapp.vehicles.constants.FuelTypes;
import com.travels.rentalapp.vehicles.constants.VehicleType;

public class CurrentStatus implements VehicleState {
	
	private Vehicle vehicle;
	
	public CurrentStatus(Vehicle vehicle) {
		// TODO Auto-generated constructor stub
		this.vehicle =  vehicle;
		hasAC();
		isDiesel();
		busType();
	}
	
	private void busType(){
		if (this.vehicle.getType() == VehicleType.BUS) {
			this.vehicle.setRentRate(this.vehicle.getRentRate() - (this.vehicle.getRentRate() * 0.02));
		}
	}
	
	private void hasAC() {
		if (this.vehicle.getAirContition() == AirContition.AC) { 
			this.vehicle.setRentRate(this.vehicle.getRentRate() + 2);
		}
	}

	private void isDiesel(){
		if (this.vehicle.getFuelType() == FuelTypes.DIESEL) {
		   this.vehicle.setRentRate(this.vehicle.getRentRate() - 1);
		}
	}
	
	@Override
	public void bookSeats(int noOfSeats) {
		vehicle.setSeatOccupied(vehicle.getSeatOccupied() + noOfSeats);
		if(vehicle.getSeatingCapacity() >= vehicle.getSeatOccupied() )
			this.vehicle.setRentRate(this.vehicle.getRentRate());
		else
			this.vehicle.setRentRate(this.vehicle.getRentRate() + 1);
	}
	
	@Override
	public double rentRate() {
		return this.vehicle.getRentRate();
	}

}
