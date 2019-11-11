package org.restaurant.facilities;

import java.util.*;

import org.restaurant.people.Customer;
import org.restaurant.people.Waiter;

public class Table {
	
	private int tableNumber;
	private int numberOfSeats;
	private ArrayList<Customer> customers;
	private String status;
	private Waiter waiter;
	
	public Table() {
		this.tableNumber = 0;
		this.numberOfSeats = 0;
		this.customers = new ArrayList<Customer>();
		this.status = "unknown";
		this.waiter = new Waiter();
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}
	
	public void removeCustomer(Customer customer) { // added
		this.customers.remove(customer);
	}

	public String getStatus() {
		return status;
	}

	//Hostess sets status 
	public void setStatus(String status) {
		this.status = status;
	}

	public Waiter getWaiter() {
		return waiter;
	}

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
	
}
