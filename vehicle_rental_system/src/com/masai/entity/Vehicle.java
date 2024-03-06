package com.masai.entity;

public class Vehicle {

	private String type;
	
	private double pricePerHour;
	
	private boolean isAvailable;

	public Vehicle(String type, double pricePerHour) {
		super();
		this.type = type;
		this.pricePerHour = pricePerHour;
		this.isAvailable = false;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the pricePerHour
	 */
	public double getPricePerHour() {
		return pricePerHour;
	}

	/**
	 * @param pricePerHour the pricePerHour to set
	 */
	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.isAvailable = available;
	}
	
	
	
	
}
