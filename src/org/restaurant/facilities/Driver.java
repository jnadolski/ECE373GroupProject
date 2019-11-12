package org.restaurant.facilities;

import java.util.ArrayList;
import org.restaurant.people.*;
import org.restaurant.supplies.*;

public class Driver {

	public static void main(String[] args) {
		Restaurant r = new Restaurant(); 
		r.setName("Tester");
		r.setLocation("123 N Main St");
		r.setPhone("123-456-7890");
		r.setRating(5.0);
		r.setRevenue(1000.00);
		
		Table t1 = new Table(); 
		Table t2 = new Table(); 
		Table t3 = new Table(); 
		t1.setTableNumber(1);
		t2.setTableNumber(2);
		t3.setTableNumber(3);
		t1.setNumberOfSeats(2);
		t2.setNumberOfSeats(2);
		t3.setNumberOfSeats(4);
		
		r.addTable(t1);
		r.addTable(t2);
		r.addTable(t3);
		
		Ingredient i1 = new Ingredient(); 
		Ingredient i2 = new Ingredient(); 
		Ingredient i3 = new Ingredient(); 
		Ingredient i4 = new Ingredient(); 
		Ingredient i5 = new Ingredient(); 
		i1.setName("Lettuce");
		i2.setName("Chicken");
		i3.setName("Croutons");
		i4.setName("Mint");
		i5.setName("White rum");
		i1.setCost(1.00);
		i2.setCost(1.50);
		i3.setCost(0.50);
		i4.setCost(0.25);
		i5.setCost(5.00);
		
		Inventory inv = new Inventory(); 
		r.setInventory(inv);
		inv.addIngredient(i1);
		inv.addIngredient(i2);
		inv.addIngredient(i3);
		inv.addIngredient(i4);
		inv.addIngredient(i5);
		
		Food f1 = new Food(); 
		f1.setName("Caesar Salad");
		f1.setCost(5.50);
		f1.addIngredient(i1, 2);
		f1.addIngredient(i2, 1);
		f1.addIngredient(i3, 3);
		
		Drink d1 = new Drink(); 
		d1.setName("Mojito");
		d1.setCost(3.50);
		d1.setHasAlcohol(true);
		d1.addIngredient(i4, 2);
		d1.addIngredient(i5, 1);
		
		r.addToFoodMenu(f1);
		r.addToDrinkMenu(d1);
		
		Manager m = new Manager(); 
		m.setName("Mr. Mason");
		m.setHireDate("11/11/19");
		r.setManager(m);
		m.addShift(m, 101);
		m.addShift(m, 301);
		m.addShift(m, 501);
		m.addShift(m, 701);
		
		System.out.println(m.getName() + "'s Shift Times: ");
		m.printShift();
		
		System.out.println("\n\nHiring Employees: ");
		
		Waiter w = new Waiter(); 
		w.setName("Wilson");
		m.hireWaiter(w, "11/11/19");
		m.addShift(w, 502);
		m.addShift(w, 503);
		m.addShift(w, 602);
		m.addShift(w, 603);
		m.addShift(w, 702);
		m.addShift(w, 703);
		
		Bartender b = new Bartender();
		b.setName("Ben");
		m.hireBartender(b, "11/11/19");
		m.addShift(b, 502);
		m.addShift(b, 503);
		m.addShift(b, 602);
		m.addShift(b, 603);
		m.addShift(b, 702);
		m.addShift(b, 703);
		
		Chef c = new Chef();
		c.setName("Chad");
		m.hireChef(c, "11/11/19");
		m.addShift(c, 502);
		m.addShift(c, 503);
		m.addShift(c, 602);
		m.addShift(c, 603);
		m.addShift(c, 702);
		m.addShift(c, 703);
		
		Hostess h = new Hostess();
		h.setName("Hannah");
		m.hireHostess(h, "11/11/19");
		m.addShift(h, 502);
		m.addShift(h, 503);
		m.addShift(h, 602);
		m.addShift(h, 603);
		m.addShift(h, 702);
		m.addShift(h, 703);
		
		System.out.println("\n\nHostess changing table statuses: ");
		h.changeTableStatus(t1, "Cleaned");
		h.changeTableStatus(t2, "Cleaned");
		h.changeTableStatus(t3, "Cleaned");
		
		System.out.println("\n\nManager Assigning Waiters to Tables: ");
		m.assignTableToWaiter(t1, w);
		m.assignTableToWaiter(t2, w);
		m.assignTableToWaiter(t3, w);
		w.printTablesCovered();
		
		ArrayList<Customer> p1 = h.createParty(1);
		ArrayList<Customer> p2 = h.createParty(2);
		ArrayList<Customer> p3 = h.createParty(3);
		h.addPartyToWaitList(p1, "Lewis");
		h.addPartyToWaitList(p2, "Nick");
		h.addReservation(p3, "Jennifer", "987-654-3210", 51115);
		
		System.out.println("\n\n");
		h.printReservationList();
		System.out.println("\n\n");
		h.printWaitList();
		
		//error testing to make sure customers are not seated at tables that do not have enough seats 
		System.out.println("\nExpected Error statement: ");
		h.seatGuests(t1, p3);
		
		h.seatGuests(t1, p1);
		
		//error testing to see if party is sat at table in use
		System.out.println("\nExpected Error statement: ");
		h.seatGuests(t1, p2);
		
		h.seatGuests(t2, p2);
		h.seatGuests(t3, p3);
		
		
		System.out.println("\nWaiter taking Customer 1's order: ");
		t1.getCustomers().get(0).setAge(21);
		w.inputOrder(t1.getCustomers().get(0), f1, c);
		w.passOrderToBar(b, t1.getCustomers().get(0), d1);
		
		System.out.println("\nRestock and trying again: [No Message Expected]");
		inv.restock();
		w.inputOrder(t1.getCustomers().get(0), f1, c);
		w.passOrderToBar(b, t1.getCustomers().get(0), d1);
		
		System.out.println("\nSending to Chef: ");
		c.printQueuedOrders();
		System.out.println("\nChef completes order... \n");
		c.completeOrder(0);
		c.printCompletedOrders();
		
		System.out.println("\nChecking Bartender: ");
		b.printQueuedOrders();
		System.out.println("\nBartender completes order... \n");
		b.completeOrder(0);
		b.printCompletedOrders();
		
		System.out.println("\nWaiter tries to remove Customer from system: \n");
		
		
		
		//waiter check age method 
	}

}

