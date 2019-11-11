package org.restaurant.people;

import java.util.ArrayList;

import org.restaurant.facilities.Restaurant;

public abstract class Employee {
	// Attributes
	private String name;
	private String hireDate;
	private double hourlyPay;
	// private int hoursWorked; // maybe not.
	private Restaurant restaurant; // insert package later;
	private ArrayList<Integer> shift;
	private String[] day = {"Sunday", "Monday", "Tuesday",
							"wednesday", "Thursday", "Friday",
							"Saturday"};
	private String[] timeSlot = {"6:00 PM to 7:00 PM", "7:00 PM to 8:00 PM",
								"8:00 PM to 9:00 PM", "9:00 PM to 10:00 PM"};
	
	// Constructor.
	public Employee() {
		name = "unknown";
		hireDate = "unknown";
		hourlyPay = 0.0;
		//hoursWorked = 0;
		restaurant = new Restaurant();
		shift = new ArrayList<Integer>();
	}
	
	// Methods;
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	protected void setHourlyPay(double hourlyPay) { // protect?
		this.hourlyPay = hourlyPay;
	}
	
	public double getHourlyPay() {
		return hourlyPay;
	}
	
	/*protected void addHoursWorked(int hours) {
		hoursWorked = hoursWorked + hours;
	}
	
	public int getHoursWorked() {
		return hoursWorked;
	}*/
	
	protected void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	protected void setShift(Integer shift) {
		this.shift.add(shift);
	}
	
	public ArrayList<Integer> getShift() {
		return this.shift;
	}
	
	protected void removeShift(Integer shift) {
		this.shift.remove(shift);
	}
	
	public void printShift() {
		String tokens[];
		String stringIndex;
		int indices[] = {101, 102, 103, 104, 201, 202, 203, 204,
						301, 302, 303, 304, 401, 402, 403, 404,
						501, 502, 503, 504, 601, 602, 603, 604,
						701, 702, 703, 704};
		int tempValue;
		int tempIndices[] = new int[2];
		
		for(int i = 0; i < indices.length; i++) {
			
			for(int j = 0; j < shift.size(); j++) {
				
				tempValue = shift.get(j);
				
				if(tempValue == indices[i]) {
					stringIndex = shift.get(j).toString();
					tokens = stringIndex.split("0");
					tempIndices[0] = Integer.parseInt(tokens[0]);
					tempIndices[1] = Integer.parseInt(tokens[1]);
					
					System.out.println(day[tempIndices[0]] + " " + timeSlot[tempIndices[1]]);
				}
			}
		}
	}
	
	public String getHireDate() {
		return hireDate;
	}
	
	protected void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
}
