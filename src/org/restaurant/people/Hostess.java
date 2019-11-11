package org.restaurant.people;

import java.util.ArrayList;

import org.restaurant.facilities.Table;

public class Hostess extends Employee {
	// Attributes.
	private ArrayList<Customer> waitList;
	private ArrayList<Customer> reservations;
	
	// Constructor.
	public Hostess() {
		waitList = new ArrayList<Customer>();
		reservations = new ArrayList<Customer>();
	}
	
	// Methods.
	public void addToWaitList(Customer... customers) {
		for (Customer a : customers) {
			waitList.add(a);
		}
	}
	
	public void addReservation(Table table, Customer... customers) {
		if (table.getStatus().compareTo("Cleaned") != 1) {
			System.out.println("Customer(s) cannot be seated at Table " + table.getTableNumber() + ". Table's status: " + checkTableStatus(table));
			return;
		}
		for (Customer a : customers) {
			table.addCustomer(a);
			a.setTable(table);
			reservations.add(a);
		}
		table.setStatus("Reserved");
	}
	
	public void seatGuests(Table table, Customer...customers) {
		if (table.getStatus().compareTo("Cleaned") != 1) {
			System.out.println("Customer(s) cannot be seated at Table " + table.getTableNumber() + ". Table's status: " + checkTableStatus(table));
			return;
		}
		
		if (table.getNumberOfSeats() < customers.length) {
			System.out.println("The party of " + customers.length + " cannot be seated to Table " + table.getTableNumber() + ". Table " + table.getTableNumber() + " can only seat " + table.getNumberOfSeats() + " Customers.");
			return;
		}
		
		for (Customer c : customers) {
			if (c.getReservation_time() != 0) {
				c.isSeated();
				reservations.remove(c);
				c.getTable().setStatus("In Use");
			}
			else {
				c.setTable(table);
				waitList.remove(c);
				table.setStatus("In Use");
			}
		}
	}
	
	public String checkTableStatus(Table table) {
		return table.getStatus();
	}
	
	public void changeTableStatus(Table table, String status) {
		if ((status.compareTo("Cleaned") == 1) || (status.compareTo("Dirty") == 1) || (status.compareTo("In Use") == 1) || (status.compareTo("Deactivated") == 1)
				|| (status.compareTo("Reserved") == 1)) {
			table.setStatus(status);
			System.out.println("Table " + table.getTableNumber() + "'s status has been set to: " + status);
		}
		
		else {
			System.out.println(status + " is an invalid Table status. Please enter: Cleaned, Dirty, In Use, Deactivated, Reserved.");
			return;
		}
	}
}
