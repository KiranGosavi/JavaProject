package com.bin;

import com.src.Spot;

public class Car extends Vehicle {
	public Car(String noplate){
		super(noplate);
		spotsNeeded = 2;
		size = VehicleSize.car;
	}

	@Override
	public boolean canFitInSpot(Spot spot) {
		// TODO Auto-generated method stub
		
		return spot.getSize() == VehicleSize.large || spot.getSize() == VehicleSize.car;
		//return false;
	}

}
