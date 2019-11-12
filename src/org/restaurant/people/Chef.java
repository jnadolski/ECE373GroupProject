package org.restaurant.people;

import java.util.ArrayList;

import org.restaurant.supplies.Food;

public class Chef extends Employee {
	// Attributes;
	private ArrayList<Food> queuedOrders;
	//private ArrayList<Food> preparingOrders;
	private ArrayList<Food> completedOrders;
	
	// Constructor;
	public Chef() {
		queuedOrders = new ArrayList<Food>();
		//preparingOrders = new ArrayList<Food>();
		completedOrders = new ArrayList<Food>();
	}
	
	// Methods;
	public void queueOrder(Food order) {
//		for (Food f : this.getRestaurant().getFoodMenu()) {
//			if (f.getName().compareTo(order.getName()) == 1) {
//				queuedOrders.add(order);
//				return;
//			}
//		}
//		
//		System.out.println("Chef " + this.getName() + " cannot prepare " + order.getName() + " because it is not in Restaurant " + this.getRestaurant().getName() + "'s menu.");
		queuedOrders.add(order);
	}
	
	public void completeOrder(int index) {
		queuedOrders.get(index).completeOrder();
		completedOrders.add(queuedOrders.get(index));
		queuedOrders.remove(index);
	}
}
