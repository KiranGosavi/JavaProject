package com.bin;

import com.src.Spot;

public class Motorcycle extends Vehicle {
	public Motorcycle(String noplate){
		super(noplate);
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}

	@Override
	public boolean canFitInSpot(Spot spot) {
		// TODO Auto-generated method stub
		return spot.getSize() == VehicleSize.large || spot.getSize() == VehicleSize.car || spot.getSize() == VehicleSize.Motorcycle;
	}

	

}
