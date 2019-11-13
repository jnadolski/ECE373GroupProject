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
		
		System.out.println("Restaurant information: ");
		System.out.println(r.getName() + "\n" + r.getLocation() + "\n" + r.getPhone());
		System.out.println("Rating: " + r.getRating() + "\nRevenue: " + r.getRevenue() + "\n");
		
		System.out.println("Creating tables...");
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
		
		System.out.println("Creating ingredients...");
		Ingredient i1 = new Ingredient(); 
		Ingredient i2 = new Ingredient(); 
		Ingredient i3 = new Ingredient(); 
		Ingredient i4 = new Ingredient(); 
		Ingredient i5 = new Ingredient(); 
		Ingredient i6 = new Ingredient(); 
		Ingredient i7 = new Ingredient(); 
		Ingredient i8 = new Ingredient(); 
		Ingredient i9 = new Ingredient(); 
		Ingredient i10 = new Ingredient(); 
		Ingredient i11 = new Ingredient(); 
		
		i1.setName("Lettuce");
		i2.setName("Chicken");
		i3.setName("Croutons");
		i4.setName("Mint");
		i5.setName("White rum");
		i6.setName("BBQ Sauce");
		i7.setName("Ranch");
		i8.setName("Nacho Cheese");
		i9.setName("Tortilla Chips");
		i10.setName("Jack Daniels");
		i11.setName("Coca Cola");
		
		i1.setCost(1.00);
		i2.setCost(1.50);
		i3.setCost(0.50);
		i4.setCost(0.25);
		i5.setCost(2.00);
		i6.setCost(1.00);
		i7.setCost(1.00);
		i8.setCost(0.50);
		i9.setCost(0.25);
		i10.setCost(2.00);
		i11.setCost(0.10);
		
		System.out.println("Adding ingredients to inventory...");
		Inventory inv = new Inventory(); 
		r.setInventory(inv);
		inv.addIngredient(i1);
		inv.addIngredient(i2);
		inv.addIngredient(i3);
		inv.addIngredient(i4);
		inv.addIngredient(i5);
		inv.addIngredient(i6);
		inv.addIngredient(i7);
		inv.addIngredient(i8);
		inv.addIngredient(i9);
		inv.addIngredient(i10);
		inv.addIngredient(i11);
		
		System.out.println("Generating food...");
		Food f1 = new Food(); 
		f1.setName("Caesar Salad");
		f1.setCost(5.50);
		f1.addIngredient(i1, 2);
		f1.addIngredient(i2, 1);
		f1.addIngredient(i3, 3);
		
		Food f2 = new Food(); 
		f2.setName("BBQ Wings");
		f2.setCost(8.00);
		f2.addIngredient(i2, 6);
		f2.addIngredient(i6, 2);
		
		Food f3 = new Food(); 
		f3.setName("Ranch Wings");
		f3.setCost(8.00);
		f3.addIngredient(i2, 6);
		f3.addIngredient(i7, 2);	
		
		Food f4 = new Food(); 
		f4.setName("Nachos");
		f4.setCost(7.00);
		f4.addIngredient(i8, 6);
		f4.addIngredient(i9, 3);		
		
		System.out.println("Generating drinks...\n");
		Drink d1 = new Drink(); 
		d1.setName("Mojito");
		d1.setCost(4.50);
		d1.setHasAlcohol(true);
		d1.addIngredient(i4, 2);
		d1.addIngredient(i5, 1);
		
		Drink d2 = new Drink(); 
		d2.setName("Coca Cola");
		d1.setCost(3.50);
		d1.setHasAlcohol(false);
		d1.addIngredient(i11, 1);
		
		Drink d3 = new Drink(); 
		d3.setName("White Rum");
		d3.setCost(3.50);
		d3.setHasAlcohol(true);
		d3.addIngredient(i5, 1);
	
		Drink d4 = new Drink(); 
		d4.setName("Jack Daniels");
		d4.setCost(3.50);
		d4.setHasAlcohol(true);
		d4.addIngredient(i10, 1);
		
		Drink d5 = new Drink(); 
		d5.setName("Jack and Coke");
		d5.setCost(5.50);
		d5.setHasAlcohol(true);
		d5.addIngredient(i10, 2);
		d5.addIngredient(i11, 1);
		
		r.addToFoodMenu(f1);
		r.addToFoodMenu(f2);
		r.addToFoodMenu(f3);
		r.addToFoodMenu(f4);
		r.addToDrinkMenu(d1);
		r.addToDrinkMenu(d2);
		r.addToDrinkMenu(d3);
		r.addToDrinkMenu(d4);
		r.addToDrinkMenu(d5);
		
		System.out.println("Food in the restaurant menu:");
		for(Food f : r.getFoodMenu()) {
			System.out.println(f.getName());
		}
		System.out.println("\nDrinks in the restaurant menu:");
		for(Drink d : r.getDrinkMenu()) {
			System.out.println(d.getName());
		}
		
		System.out.println("\n\nHiring Employees: ");
		
		Manager m = new Manager(); 
		m.setName("Mr. Mason");
		m.setHireDate("11/11/19");
		r.setManager(m);
		m.addShift(m, 101);
		m.addShift(m, 301);
		m.addShift(m, 501);
		m.addShift(m, 701);
		
		System.out.println("\nManager " + m.getName() + " is hired. Shift Times: ");
		m.printShift();
		
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
		
		System.out.println("\n");
		h.printReservationList();
		System.out.println();
		h.printWaitList();
		
		//error testing to make sure customers are not seated at tables that do not have enough seats 
		System.out.println("\n\nExpected Error statement: ");
		h.seatGuests(t1, p3);
		
		//correct seating
		h.seatGuests(t1, p1);
		
		//error testing to see if party is sat at table in use
		System.out.println("\nExpected Error statement: ");
		h.seatGuests(t1, p2);
		
		System.out.println("\n\nSeating customers to proper tables: \n");
		h.seatGuests(t2, p2);
		h.seatGuests(t3, p3);
		
		System.out.println("Showing empty reservations and waitlist: ");
		h.printReservationList();
		System.out.println();
		h.printWaitList();
		
		System.out.println("\nWaiter taking Customer 1's order: ");
		t1.getCustomers().get(0).setAge(21);
		w.inputOrder(t1.getCustomers().get(0), f1, c);
		w.passOrderToBar(b, t1.getCustomers().get(0), d1);
		
		System.out.println("\nRestock and trying again: [No message expected]");
		inv.restock();
		w.inputOrder(t1.getCustomers().get(0), f1, c);
		w.passOrderToBar(b, t1.getCustomers().get(0), d1);
		
		System.out.println("\nWaiter taking Table 2's order...");
		t2.getCustomers().get(0).setAge(21);
		t2.getCustomers().get(1).setAge(21);
		w.inputOrder(t2.getCustomers().get(0), f2, c);
		w.passOrderToBar(b, t2.getCustomers().get(0), d2);
		w.inputOrder(t2.getCustomers().get(1), f3, c);
		w.passOrderToBar(b, t2.getCustomers().get(1), d3);
		
		System.out.println("\nSending to Chef: ");
		c.printQueuedOrders();
		System.out.println("\nChef completes 1 order... \n");
		c.completeOrder(0);
		c.printCompletedOrders();
		c.printQueuedOrders();
		
		System.out.println("\nChecking Bartender: ");
		b.printQueuedOrders();
		System.out.println("\nBartender completes 1 order... \n");
		b.completeOrder(0);
		b.printCompletedOrders();
		b.printQueuedOrders();
		
		System.out.println("\nHostess checks table 1's status: " + h.checkTableStatus(t1));
		System.out.println("\nWaiter tries to remove Customer from system: \n");
		t1.getCustomers().get(0).leave();
		
		System.out.println("\nCustomer pays and then leaves:\n");
		t1.getCustomers().get(0).payBillSelf();
		System.out.println(); 
		t1.getCustomers().get(0).tipWaiter(3);
		t1.getCustomers().get(0).leave();
		
		System.out.println("\nHostess checks table 1's status: " + h.checkTableStatus(t1));
		System.out.println("Hostess tries to incorrectly change table status: ");
		h.changeTableStatus(t1, "Not dirty"); 
		h.changeTableStatus(t1, "Cleaned"); 
		
		//waiter check age method 
	}

}

