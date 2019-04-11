package com.bin;

import java.util.ArrayList;

import com.src.Spot;



public abstract class Vehicle {

	protected String  noPlate;
	protected int parkingSpt;
	protected ArrayList<Spot> parkedSpotList=new ArrayList<Spot>();
	protected VehicleSize size;
	public int spotsNeeded;
	
	public VehicleSize getSize(){
		return size;
	}
	public String getNoplate(){
		return noPlate;
	}
	
	public Vehicle(String noplate){
		noPlate=noplate;
	}
	public void parkVehicle(Spot s){
		parkedSpotList.add(s);
	}
	
	public int getSpotsNeeded(){
		return spotsNeeded;
	}
	
	public Spot getVehicleSpotInfo(Vehicle v){
		for (int i = 0; i < parkedSpotList.size(); i++){
			Spot s=parkedSpotList.get(i);
			if (v.noPlate==s.getVehicleNoPlate()){
				//System.out.println("Spot Info"+s.toString());
				return s;
			}
		}
		return null;
		
	}
	
	public void clearSpots(){
		
		for (int i = 0; i < parkedSpotList.size(); i++){
			parkedSpotList.get(i).removeVehicle();
		}
		parkedSpotList.clear();
	}
	public void parkInSpot(Spot s){
		parkedSpotList.add(s);
	}
	
	public abstract boolean canFitInSpot(Spot spot);
}
