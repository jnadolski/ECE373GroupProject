package org.restaurant.people;

import java.util.ArrayList;

import org.restaurant.supplies.Drink;
import org.restaurant.supplies.Food;

public class Bartender extends Employee {
	// Attributes;
	private ArrayList<Drink> orders;
	private ArrayList<Drink> completed;
	private double tips;
	
	// Constructor;
	public Bartender() {
		orders = new ArrayList<Drink>();
		completed = new ArrayList<Drink>();
		tips = 0.0;
	}
	
	// Methods;
	protected void collectTip(double tip) {
		tips = tips + tip;
		System.out.println("Bartender " + this.getName() + " was tipped $" + tip);
	}
	
	/*public void takeOrder(Drink drink) {
		if(drink.checkAvailability() == false) {
			System.out.println(drink.getName() + " is currently out of stock. Please make another selection.");
		}
		
		else {
			orders.add(drink);
		}
	} */
	
	public void inputOrder(Customer customer, Drink drink) {
		if (checkAge(customer) == false) {
			System.out.print("Bartender " + this.getName() + " cannot serve Customer " + customer.getName() + ".");
			System.out.println("Customer " + customer.getName() + "is not 21 or older.");
			return;
		}
		
		if (drink.checkAvailability() == false) {
			System.out.println(drink.getName() + " is currently out of stock. Please make another selection.");
			return;
		}
		else {
			customer.setDrink_list(drink);
			orders.add(drink);
		}
	}
	
	public void completeOrder(int index) {
		orders.get(index).completeOrder();
		completed.add(orders.get(index));
		orders.remove(index);
	}
	
	private boolean checkAge(Customer customer) {
		if (customer.getAge() < 21) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void printQueuedOrders() {
		System.out.println("Queued Orders: ");
		int placeInQueue = 1; 
		for(Drink d : orders) {
			System.out.println(placeInQueue + ". " + d.getName());
			placeInQueue++; 
		}
	}
	
	public void printCompletedOrders() {
		System.out.println("Completed Orders: ");
		for(Drink d : completed) {
			System.out.println(d.getName());
		}
	}
	
	/*public Drink deliverOrder(Drink drink) {
		Drink temp;
		temp = orders.get(drink); // loop thru and see if it's in their
		
		if (temp == null) {
			System.out.println("Cannot deliver " + drink.getName() + " because it is not in this Bartender's list of orders.");
			return null;
		}
		
		orders.remove(drink);
		return temp;
		
	}*/ // not implementing. assume that it happens outside of system.
}
