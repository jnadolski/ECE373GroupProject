package org.restaurant.people;

import java.util.ArrayList;

import org.restaurant.facilities.Table;

public class Hostess extends Employee {
	// Attributes.
	private ArrayList<ArrayList<Customer>> waitList;
	private ArrayList<ArrayList<Customer>> reservations;
	private String[] day = {"Sunday", "Monday", "Tuesday",
			"wednesday", "Thursday", "Friday",
			"Saturday"};
	
	// Constructor.
	public Hostess() {
		waitList = new ArrayList<ArrayList<Customer>>();
		reservations = new ArrayList<ArrayList<Customer>>();
	}
	
	public ArrayList<Customer> createParty(int size) {
		ArrayList<Customer> party = new ArrayList<Customer>();
		
		for(int i = 0; i < size; i++) {
			party.add(new Customer()); 
		}
		
		return party;
	}
	
	// Methods.
	public void addPartyToWaitList(ArrayList<Customer> party, String name) {
		party.get(0).setName(name);
		waitList.add(party);
	}
	
	public void addReservation(ArrayList<Customer> party, String name, String phonenumber, int time) {
//		if (table.getStatus().compareTo("Cleaned") != 1) {
//			System.out.println("Customer(s) cannot be seated at Table " + table.getTableNumber() + ". Table's status: " + checkTableStatus(table));
//			return;
//		}
//		for (Customer a : customers) {
//			table.addCustomer(a);
//			a.setTable(table);
//			reservations.add(a);
//		}
//		table.setStatus("Reserved");
		party.get(0).setName(name);
		party.get(0).setPhone_number(phonenumber);
		party.get(0).setReservation_time(time);
		//possible reservation times will be in the format xyyyy where x is the day of week and yyyy is the hour from 1000-2200 (10:00am-10:00pm)
		reservations.add(party); 
	}
	
	public void seatGuests(Table table, ArrayList<Customer> party) {
		if (table.getStatus().compareTo("Cleaned") != 1) {
			System.out.println("Customer(s) cannot be seated at Table " + table.getTableNumber() + ". Table's status: " + checkTableStatus(table));
			return;
		}
		
		if (table.getNumberOfSeats() < party.size()) {
			System.out.println("The party of " + party.size() + " cannot be seated to Table " + table.getTableNumber() + ". Table " + table.getTableNumber() + " can only seat " + table.getNumberOfSeats() + " Customers.");
			return;
		}
		
//		for (Customer c : customers) {
//			if (c.getReservation_time() != 0) {
//				c.isSeated();
//				reservations.remove(c);
//				c.getTable().setStatus("In Use");
//			}
//			else {
//				c.setTable(table);
//				waitList.remove(c);
//				table.setStatus("In Use");
//			}
//		}
		

		if(reservations.contains(party))
			reservations.remove(party);
		else if(waitList.contains(party))
			waitList.remove(party);
		
		for(Customer c : party) {
			c.isSeated();
			c.setTable(table);
			c.getTable().setStatus("In Use");
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
	
	public void printReservationTime(Customer c) {
		int dayOfWeek = c.getReservation_time() / 10000; 
		int hour = (c.getReservation_time() - dayOfWeek*10000) / 100;
		int minutes = c.getReservation_time() - dayOfWeek*10000 - hour*100; 
		
		if(hour > 12) {
			System.out.println(day[dayOfWeek] + " at " + (hour-12) + ":" + minutes + "PM");
		}
		else
			System.out.println(day[dayOfWeek] + " at " + hour + ":" + minutes + "AM");
	}
	
}
