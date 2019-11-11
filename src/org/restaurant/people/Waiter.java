package org.restaurant.people;

import java.util.ArrayList;

import org.restaurant.facilities.Table;
import org.restaurant.supplies.Drink;
import org.restaurant.supplies.Food;

public class Waiter extends Employee {
	// Attributes;
	private ArrayList<Table> tablesCovered;
	//private ArrayList<Party> partiesServing;
	//private ArrayList<Food> orders; // possibly remove
	private double tips;
	
	// Constructor;
	public Waiter() {
		tablesCovered = new ArrayList<Table>();
		//partiesServing = new ArrayList<Party>();
		//orders = new ArrayList<Food>();
		tips = 0.0;
	}
	
	// Methods;
	public ArrayList<Table> getTablesCovered() {
		return tablesCovered;
	}
	
	protected void addTable(Table aTable) { // place in Manager
		tablesCovered.add(aTable);
	}
	
	protected void removeTable(Table aTable) { // place in Manager
		tablesCovered.remove(aTable);
	}
	
	/*public ArrayList<Party> getPartiesServed() {
		return partiesServing;
	}*/
	
	/*public void addParty(Party aParty) {
		partiesServing.add(aParty);
	}*/
	
	/*public void removeParty(Party aParty) {
		partiesServing.remove(aParty);
	}*/
	
	protected void collectTip(double tip) {
		tips = tips + tip;
		System.out.println("Waiter " + this.getName() + " was tipped $" + tip);
	}
	
	/*public void takeOrder(Food order) {
		if (order.checkAvailability() == false) {
			System.out.println(order.getName() + " is currently out of stock. Please make another selection.");
		}
		else {
			orders.add(order);
		}
	}*/ // ignore.
	
	public void inputOrder(Customer customer, Food order) {
		if (order.checkAvailability() == false) {
			System.out.println(order.getName() + " is currently out of stock. Please make another selection.");
			return;
		}
		else {
			customer.setFood_list(order);
		}
	} /// customer and waiter interact outside of system, waiter adds the order to the customer's food list.
	
	public void placeOrder(Chef chef, Food order) { // chef and food as argument, added to the chef's queue.
		chef.queueOrder(order);
	} // 
	
	public void passOrderToBar(Bartender bartender, Customer customer, Drink drink) {
		bartender.inputOrder(customer, drink);
	}
	
	// add methods so that customers have two paths. Can order drinks through waiter who passes to bartender.
	
	/*public Food deliverOrder(Food order) {
		Food temp;
		temp = orders.get(order);
		
		if (temp == null) {
			System.out.println("Cannot deliver " + order.getName() + " because it is not in this Waiter's list of orders.");
			return null;
		}
		
		orders.remove(order);
		
		return temp;
	}*/ 
}
