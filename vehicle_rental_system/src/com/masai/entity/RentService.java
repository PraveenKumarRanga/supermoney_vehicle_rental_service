package com.masai.entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentService {

	private Map<String, Branch> branches;

	public RentService(Map<String, Branch> branches) {
		super();
		this.branches = new HashMap<>();
	}
	
	public RentService() {
		// TODO Auto-generated constructor stub
	}

	public void addBranch(String name, Map<String, Integer> vehicles) {
		
		Branch branch = new Branch(name, vehicles);
		
	}
	
	public void addVehicle(String branchName, String type, int quantity) {
		
		if(branches.containsKey(branchName)) {
			Branch branch = branches.get(branchName);
			branch.addVehichle(type, quantity);
		}
		
	}
	
	public String rentVehi(String type, LocalDateTime startTime, LocalDateTime endTime) throws VehicleNotAvailableException {
		
		for(Branch branch : branches.values()) {
			if(branch.getVehicles().containsKey(type)) {
				for(Vehicle vehi : branch.getVehicles().get(type)) {
					if(!vehi.isAvailable()) {
						vehi.setAvailable(true);
						return branch.getName();
					}
				}
			}
		}
		
		throw new VehicleNotAvailableException("vehicle is not available");
		
	}
	public void printSystemViewTimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
		
		for(Branch branch : branches.values()) {
			System.out.println(branch.getName()+" : ");
			
			for(Map.Entry<String, List<Vehicle>> entry : branch.getVehicles().entrySet()) {
				String type = entry.getKey();
				
				boolean allBooked = true;
				
				for(Vehicle vehicle : entry.getValue()) {
					if(!vehicle.isAvailable()) {
						allBooked = false;
						break;
					}
				}
				if(allBooked) {
					System.out.println("All "+ type +" are booked");
					System.out.println("\"" + type + "\" is available for Rs. " + getPriceForType(type));
				}
			}
		}
		
		
	}
	
	
	public double getPriceForType(String type) {
		
		switch (type.toLowerCase()) {
		case "suv" :
			return 100.0;
		case "sedan" :
			return 120.0;
		case "bike" :
			return 50.0;
		default:
			return 0.0;
		
		}
		
	}
	
	
	
	
}
