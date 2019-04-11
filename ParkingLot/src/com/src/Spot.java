package com.src;

import com.bin.Vehicle;
import com.bin.VehicleSize;

public class Spot {
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;
	
	public Spot(Level lvl, int r, int n, VehicleSize s){
		level = lvl;
		row = r;
		spotNumber = n;
		spotSize = s;
	}

	public boolean isAvailable(){
		return vehicle == null;
	}
	
	public boolean park(Vehicle v){
		vehicle = v;
		vehicle.parkInSpot(this);
		return true;
	}
	
	public void setRow(int row) {
		this.row = row;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getRow(){
		return row;
	}
	public Level getLevel(){
		return level;
	}
	public int getSpotNumber(){
		return spotNumber;
	}
	public VehicleSize getSize(){
		return spotSize;
	}

	public String getVehicleNoPlate(){
		return vehicle.getNoplate();
	}
	public boolean canFitVehicle(Vehicle vehicle){
		//check if the spot is big enough and is available
		return isAvailable() && vehicle.canFitInSpot(this);
	}
	public void removeVehicle(){
		level.spotFreed();
		vehicle = null;
	}
}
