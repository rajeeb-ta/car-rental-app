package com.travels.rentalapp.vehicles;

import com.travels.rentalapp.vehicles.constants.AirContition;
import com.travels.rentalapp.vehicles.constants.FuelTypes;
import com.travels.rentalapp.vehicles.constants.VehicleSize;
import com.travels.rentalapp.vehicles.constants.VehicleType;
import com.travels.rentalapp.vehicles.states.CurrentStatus;
import com.travels.rentalapp.vehicles.states.VehicleState;

public class Vehicle implements VehicleState {

	private VehicleType type;
	private VehicleSize size;
	private FuelTypes fuelType;
	private AirContition airContition;
	private int seatingCapacity;
	private int seatOccupied;
	private double rentRate = 14.0;

	VehicleState vehicleState;
	
	private Vehicle(VehicleType type, VehicleSize size, FuelTypes fuelType, AirContition airContition, int seatingCapacity) {
		super();
		this.type = type;
		this.size = size;
		this.fuelType = fuelType;
		this.airContition = airContition;
		this.seatingCapacity = seatingCapacity;
		this.vehicleState = new CurrentStatus(this);
	}

	public int getSeatOccupied() {
		return seatOccupied;
	}

	public void setSeatOccupied(int seatOccupied) {
		this.seatOccupied = seatOccupied;
	}

	public VehicleType getType() {
		return type;
	}

	public VehicleSize getSize() {
		return size;
	}

	public FuelTypes getFuelType() {
		return fuelType;
	}

	public AirContition getAirContition() {
		return airContition;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public double getRentRate() {
		return rentRate;
	}

	public void setRentRate(double rentRate) {
		this.rentRate = rentRate;
	}

	public static class VehicleBuilder {
		private VehicleType vehicleType;
		private VehicleSize vehicleSize;
		private FuelTypes fuelType;
		private AirContition airContition;
		private int seatingCapacity;

		public VehicleBuilder(VehicleType vehicleType) {
			super();

			this.vehicleType = vehicleType;
			switch (vehicleType) {
			case SUV: {
				this.vehicleSize = VehicleSize.BIG;
				this.airContition = AirContition.AC;
				this.fuelType = FuelTypes.DIESEL;
				this.seatingCapacity = 7;
				break;
			}
			case BUS: {
				this.vehicleSize = VehicleSize.BIG;
				this.airContition = AirContition.NONAC;
				this.fuelType = FuelTypes.DIESEL;
				this.seatingCapacity = 30;
				break;
			}
			case VAN: {
				this.vehicleSize = VehicleSize.BIG;
				this.airContition = AirContition.NONAC;
				this.fuelType = FuelTypes.DIESEL;
				this.seatingCapacity = 15;
				break;
			}
			case CAR: {
				this.vehicleSize = VehicleSize.SMALL;
				this.airContition = AirContition.NONAC;
				this.fuelType = FuelTypes.PETROL;
				this.seatingCapacity = 4;
				break;
			}
			}
		}

		public VehicleBuilder setFuelType(FuelTypes fuelType) {
			this.fuelType = fuelType;
			return this;
		}

		public VehicleBuilder setAirContition(AirContition airContition) {
			this.airContition = airContition;
			return this;
		}

		public VehicleBuilder setSeatingCapacity(int seatingCapacity) {
			this.seatingCapacity = seatingCapacity;
			return this;
		}

		public Vehicle build() {
			return new Vehicle(this.vehicleType, this.vehicleSize, this.fuelType, this.airContition, this.seatingCapacity);
		}
	}

	@Override
	public double rentRate() {
		return vehicleState.rentRate();
	}

	@Override
	public void bookSeats(int noOfSeats) {
		vehicleState.bookSeats(noOfSeats);
		
	}
}
