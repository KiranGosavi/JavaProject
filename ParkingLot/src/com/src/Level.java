package com.src;
import com.bin.*;
//import com.bin.VehicleSize;

public class Level {
	protected int floor;
	protected Spot[] levelSpots; //number of spots in each level.
	private int freeSpots;
	private static final int SPOT_PER_ROW = 10;
	
	public int getFloor(){
		return this.floor;
	}
	public Level(int flr, int numberSpots){
		floor = flr;
		freeSpots = numberSpots;
		levelSpots = new Spot[numberSpots];
		
		int largeSpotsNo = numberSpots / 4;
		int bikeSpotsNo = numberSpots / 4;
		int compactSpotsNo = numberSpots - largeSpotsNo - bikeSpotsNo;
		
		for (int i = 0; i < numberSpots; i++) {
			VehicleSize sz = VehicleSize.Motorcycle;
			
			if (i<largeSpotsNo) {
				sz=VehicleSize.large;
			}
			else if (i < largeSpotsNo + compactSpotsNo){
				sz = VehicleSize.car;
			}
			
			int row =i/SPOT_PER_ROW;
			
			levelSpots[i]=new Spot(this, row, i+1,sz);
			
		}
	}
	
	public Spot[] getSpotsAtLevel(){
		return levelSpots;
		
	}
	
	public boolean parkVehicle(Vehicle vehicle){
		//find a place to park this vehicle, return false if failed
		if (getFreeSpots() < vehicle.getSpotsNeeded())
			return false;

		int spotNumber = findFreeSpots(vehicle);
		if (spotNumber < 0)
			return false;
		return parkStartingAtSpot(spotNumber, vehicle);
	}
	
	private boolean parkStartingAtSpot(int num, Vehicle v){
		v.clearSpots();
		boolean success = true;
		for (int i = num; i < num + v.spotsNeeded; i++){
			success &= levelSpots[i].park(v);
		}
		freeSpots -= v.spotsNeeded;
		return success;
	}
	
	private int findFreeSpots(Vehicle vehicle){
		int spotsNeeded = vehicle.getSpotsNeeded();
		int lastRow = -1;
		int spotsFound = 0;

		for (int i = 0; i < levelSpots.length; i++){
			Spot spot = levelSpots[i];
			if (lastRow != spot.getRow()){
				spotsFound = 0;
				lastRow = spot.getRow();
			}
			if (spot.canFitVehicle(vehicle)){
				spotsFound++;
			}
			else{
				spotsFound = 0;
			}
			if (spotsFound == spotsNeeded){
				return i - (spotsNeeded - 1);
			}
		}
		return -1;
	}
	
	public int getFreeSpots(){
		return freeSpots;
	}
	public void spotFreed(){
		freeSpots++;
	}
	
		

}
