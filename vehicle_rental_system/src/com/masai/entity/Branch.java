package com.masai.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Branch {

	
	private String name;
	
	private Map<String, List<Vehicle>> vehicles;

	public Branch(String name, Map<String, Integer> vehicle) {
		super();
		this.name = name;
		this.vehicles = new HashMap<>();
//		for(Map.Entry<String, Integer> entry : vehicle.entrySet()) {
//			addVehicle(entry.getKey(), entry.getValue());
//		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the vehicles
	 */
	public Map<String, List<Vehicle>> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(Map<String, List<Vehicle>> vehicles) {
		this.vehicles = vehicles;
	}
	
	public void addVehichle(String type, int quantity) {
		List<Vehicle> vehiList = new ArrayList<>();
		RentService service = new RentService();
		double price = service.getPriceForType(type);
		for(int i=0; i<quantity; i++) {
			vehiList.add(new Vehicle(type, price));
		}
		vehicles.put(type, vehiList);
	}
	
}
