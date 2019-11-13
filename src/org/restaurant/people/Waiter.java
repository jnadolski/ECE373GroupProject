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
	
	public void printTablesCovered() {
		System.out.println(this.getName() + " covers the tables: ");
		for(Table tables : this.tablesCovered) {
			System.out.println(tables.getTableNumber());
		}
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
		String strDouble = String.format("%.2f", tip);
		System.out.println("Waiter " + this.getName() + " was tipped $" + strDouble);
	}
	
	/*public void takeOrder(Food order) {
		if (order.checkAvailability() == false) {
			System.out.println(order.getName() + " is currently out of stock. Please make another selection.");
		}
		else {
			orders.add(order);
		}
	}*/ // ignore.
	
	public void inputOrder(Customer customer, Food order, Chef chef) {
//		for (Food f : this.getRestaurant().getFoodMenu()) {
//			if (f.getName().compareTo(order.getName()) == 1) {
//				if (order.checkAvailability() == false) {
//					System.out.println(order.getName() + " is currently out of stock. Please make another selection.");
//					return;
//				}
//				else {
//					customer.setFood_list(order);
//					return;
//				}
//			}
//		}
//		
//		System.out.println(order.getName() + " is not in Restauraunt " + this.getRestaurant().getName() + "'s menu. Please make another selection.");
		
		if (order.checkAvailability() == false) {
			System.out.println(order.getName() + " is currently out of stock. Please make another selection.");
			return;
		}
		else {
			customer.setFood_list(order);
			chef.queueOrder(order);
			return;
		}
		
	} /// customer and waiter interact outside of system, waiter adds the order to the customer's food list.
	
	public void passOrderToBar(Bartender bartender, Customer customer, Drink drink) {
		if (checkAge(customer) == true) {
			bartender.inputOrder(customer, drink);
		}
		else {
			System.out.println("Waiter " + this.getName() + " cannot pass this order to the bar, because Customer is not 21 or older.");
		}
	}
	
	private boolean checkAge(Customer customer) {
		if (customer.getAge() < 21) {
			return false;
		}
		else {
			return true;
		}
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
	
	//method to split bill by percentage
	//method to move food order 
}
