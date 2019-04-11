package com.client;
import java.util.Scanner;

import javax.sql.rowset.spi.TransactionalWriter;

import com.bin.*;
import com.exception.InvalidVehicleType;
import com.src.*;

public class Main {
	
	
	public static void main(String[] args) {
		
		ParkingLot P1 = new ParkingLot();				//default parking slot with default no of floor and parking spots
		//ParkingLot P2=new ParkingLot(5, 20);          //customized parking slot
	    Vehicle v2 = new Motorcycle("IK 737347");
	    Vehicle v3 = new Motorcycle("IK 7373");
	    Vehicle v4 = new Motorcycle("IK 73");
	    Vehicle v5 = new Motorcycle("IK 773748384");
	    P1.parkVehicle(v2);
	    P1.parkVehicle(v3); 
	    P1.parkVehicle(v4);
	    P1.parkVehicle(v5);
	    
	    
	    
	    String ans;
	    do{
	    	System.out.println("Enter choice from below options: ");
		    System.out.println("\n1.Park Vehicle \n2.Remove vehicle \n3.Check Location of parked vehicle\n 4.Check Total available spots in parkingLot.");
		    System.out.println("your choice: ");
		    Scanner sc=new Scanner(System.in);
		    int ch=sc.nextInt();
		    switch(ch){
		    
				    case 1:System.out.println("\n\n*********************Prak Vehicle******************************\n");
				    	
				    	System.out.println("Enter type of vehicle to be parked: ");
				    	Scanner s1=new Scanner(System.in);
				    	String type=s1.next();
				    	System.out.println("Enter vehicle Number plate to be parked: ");
				    	Scanner sc1=new Scanner(System.in);
				    	String noplate=sc1.next();
				    	Vehicle v1=null;
				    	try{
						    	if(type.equalsIgnoreCase(VehicleSize.car.name())){
						    		v1=new Car(noplate);
						    	}else if(type.equalsIgnoreCase(VehicleSize.Motorcycle.name())){
						    		v1=new Motorcycle(noplate);
						    	}else {
						    		throw new InvalidVehicleType("Currently Parking garage supports only Car or Motorcycle parking!");
						    	}
					    	}catch (InvalidVehicleType e) {
				    		e.printStackTrace();
						}
				    	 if(P1.parkVehicle(v1)){
				    		 System.out.println("Vehicle parked successfully:");
				    	 }
				    	break;
				    case 2:System.out.println("\n\n*********************Remove Vehicle******************************\n");
				    	System.out.println("Available total parking spots: "+P1.findTotalFreeSpots());
				    	System.out.println("Removed vehicle from garage parking successfully: "+P1.removeVehicle(v4));
				    	System.out.println("Available total parking spots: "+P1.findTotalFreeSpots());
				    	break;
				    case 3:System.out.println("\n\n*********************Search Parked vehicle Info******************************\n"); 
				    	System.out.println("Searching parking infomation for vehicle (IK 773748384):.... ");
				    	Spot s=P1.parkingInfo(v5);
				    	Level l=s.getLevel();
				    	System.out.println("Your vehicle is parked on Floor: "+l.getFloor()+" Row:  "+s.getRow()+"  Parking spot:  "+s.getSpotNumber());
				    	break;
				    case 4:System.out.println("\n\n*********************Check free parking spots******************************\n");
				    	System.out.println("Available total parking spots in parking garage are: "+P1.findTotalFreeSpots());
				    	break;
				    default:System.out.println("Please enter valid choice.");
				    	
		    }
		    System.out.println("Do you want to continue? (yes/no)");
		    Scanner sc2=new Scanner(System.in);
		    ans=sc2.next();
		    
	    }while(ans.equalsIgnoreCase("yes"));
	}
}