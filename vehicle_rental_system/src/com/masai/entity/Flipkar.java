package com.masai.entity;

import java.time.LocalDateTime;
import java.util.Map;

public class Flipkar {

	public static void main(String[] args) {
		
		RentService service = new RentService();
		
		service.addBranch("gurugram", Map.of("sedan",1, "suv",3, "bike", 3));
		service.addBranch("delhi", Map.of("sedan",3, "suv",2, "bike", 2));
		
		service.addVehicle("delhi", "bike", 1);
		
		try {
			System.out.println(service.rentVehi("suv", LocalDateTime.of(2024,3,13,11,0), LocalDateTime.of(2024,3,13,13,0)));
		}
		catch(VehicleNotAvailableException e){
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
}
