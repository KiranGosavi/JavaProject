package com.src;

import com.bin.Vehicle;

public class ParkingLot {
	private Level[] levels;
	private int noLevel;
	private final int NUM_LEVELS_DEFAULT = 5;
	private final int NUM_SPOTSATLEL_DEFAULT=30;
	private int totalFreeSpots;
	
	//Initialize Parking garage with given floor number and given spots number at each level
	public ParkingLot(int noLevel, int noSpotatLvl){
		levels = new Level[noLevel];
		this.noLevel=noLevel;
		for (int i = 0; i < noLevel; i++){
			levels[i] = new Level(i+1, noSpotatLvl);
		}
	}

	//Initialize Parking garage with default values
	public ParkingLot(){
		levels = new Level[NUM_LEVELS_DEFAULT];
		this.noLevel=NUM_LEVELS_DEFAULT;
		for (int i = 0; i < NUM_LEVELS_DEFAULT; i++){
			levels[i] = new Level(i+1, NUM_SPOTSATLEL_DEFAULT);
		}
	}

	//Park vehicle in a parking garage
	public boolean parkVehicle(Vehicle vehicle){
		for (int i = 0; i < levels.length; i++){
			if (levels[i].parkVehicle(vehicle))
				return true;
		}
		return false;
	}
	
	//Remove vehicle from parking garage.
	public boolean removeVehicle(Vehicle v){
		for (int i=0; i < levels.length; i++){
			Level l=levels[i];
			Spot[] s=l.getSpotsAtLevel();
			for (Spot spot : s) {
				if(v.getNoplate()==spot.getVehicleNoPlate()){
					l.spotFreed();
					return true;
				}
				
			}
			
		}
		return false;
		
	}
	
	//Find total free spot in a Parking garage
	public int findTotalFreeSpots(){
		int totalNo=0;
		for (int i = 0; i < this.noLevel; i++) {
			Level l=levels[i];
			totalNo=totalNo+l.getFreeSpots();
		}
		return totalNo;
	}
	
	
	//Find spot details of a vehicle in a Parking garage
	public Spot parkingInfo(Vehicle vehicle){
		if (parkVehicle(vehicle)){
			Spot s=vehicle.getVehicleSpotInfo(vehicle);
			return s;
		}
		return null;
	}
	
	//Find Level info of a parked vehicle.
	public int parkingLvlInfo(Vehicle vehicle){
		if (parkVehicle(vehicle)){
			for (int i=0; i < levels.length; i++){
				Level l=levels[i];
				Spot[] s=l.getSpotsAtLevel();
				for (Spot spot : s) {
					if(vehicle.getNoplate()==spot.getVehicleNoPlate()){
						return l.floor;
					}
					
				}
			
			}
		}
		return -1;
	}
	
}
