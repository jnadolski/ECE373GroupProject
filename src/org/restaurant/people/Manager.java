package org.restaurant.people;

import java.util.ArrayList;

import org.restaurant.facilities.Restaurant;
import org.restaurant.facilities.Table;
import org.restaurant.supplies.Ingredient;

public class Manager extends Employee {
	// Constructor.
    private ArrayList<Waiter> waiter_list;
    private ArrayList<Bartender> bartender_list;
    private ArrayList<Chef> chef_list;
    private ArrayList<Hostess> hostess_list;
	
	public Manager() {
        this.waiter_list = new ArrayList<Waiter>();
        this.bartender_list = new ArrayList<Bartender>();
        this.hostess_list = new ArrayList<Hostess>(); 
        this.chef_list = new ArrayList<Chef>();
	}
	// Methods.
//	public void payEmployee(Employee employee, int hoursWorked) {
//		this.getRestaurant().subtractRevenue(employee.getHourlyPay() * hoursWorked); // keeps track of what money leaves restaurant, but not the employee's total money.
//		System.out.println("Employee " + employee.getName() + " was paid $" + (employee.getHourlyPay() * hoursWorked) + ".");
//	}
	
	/*public void addEmployeeHours(Employee employee, int hours) {
		employee.addHoursWorked(hours);
	}*/
	
	public void hireWaiter(Waiter waiter, String hireDate) {
		//if (waiter.getRestaurant().getName().compareTo("unknown") == 1) {
			
			waiter.setHireDate(hireDate);
			this.waiter_list.add(waiter); // possibly make restaraunt protected??
			//waiter.setRestaurant(this.getRestaurant());
			System.out.println("Waiter " + waiter.getName() + " was hired.");		
			//System.out.println("Waiter " + waiter.getName() + " was hired at Restaurant " + this.getRestaurant().getName() + ".");		
		//}
		
//		else {
//			System.out.print("Waiter " + waiter.getName() + " cannot be hired at Restaurant " + this.getRestaurant().getName() + ". ");
//			System.out.println("Waiter " + waiter.getName() + "already works at " + waiter.getRestaurant().getName() + ".");
//		}
		// print command alerting of new hire.
	}
	
	public void fireWaiter(Waiter waiter) {
		this.waiter_list.remove(waiter);
		//waiter.setRestaurant(new Restaurant());
		//System.out.println("Waiter " + waiter.getName() + " was fired from Restaurant " + this.getRestaurant().getName() + ".");
		System.out.println("Waiter " + waiter.getName() + " was fired.");
	}
	
	public void hireBartender(Bartender bartender, String hireDate) {
//		if (bartender.getRestaurant().getName().compareTo("unknown") == 1) {
//			
//			bartender.setHireDate(hireDate);
//			this.getRestaurant().addBartender(bartender); // possibly make restaraunt protected??
//			bartender.setRestaurant(this.getRestaurant());
//			
//			System.out.println("Bartender " + bartender.getName() + " was hired at Restaurant " + this.getRestaurant().getName() + ".");		
//		}
//		
//		else {
//			System.out.print("Bartender " + bartender.getName() + " cannot be hired at Restaurant " + this.getRestaurant().getName() + ". ");
//			System.out.println("Waiter " + bartender.getName() + "already works at " + bartender.getRestaurant().getName() +".");
//		}
		bartender.setHireDate(hireDate);
		this.bartender_list.add(bartender); 
		
		System.out.println("Bartender " + bartender.getName() + " was hired.");		
	}
	
	public void fireBartender(Bartender bartender) {
//		this.getRestaurant().removeBartender(bartender);
//		bartender.setRestaurant(new Restaurant());
//		System.out.println("Bartender " + bartender.getName() + " was fired from Restaurant " + this.getRestaurant().getName() +".");
		this.bartender_list.remove(bartender);
		System.out.println("Bartender " + bartender.getName() + " was fired.");
	}
	
	public void hireChef(Chef chef, String hireDate) {
//		if (chef.getRestaurant().getName().compareTo("unknown") == 1) {
//			
//			chef.setHireDate(hireDate);
//			this.getRestaurant().addChef(chef); // possibly make restaraunt protected??
//			chef.setRestaurant(this.getRestaurant());
//			
//			System.out.println("Chef " + chef.getName() + " was hired at Restaurant " + this.getRestaurant().getName() + ".");		
//		}
//		
//		else {
//			System.out.print("Chef " + chef.getName() + " cannot be hired at Restaurant " + this.getRestaurant().getName() + ". ");
//			System.out.println("Chef " + chef.getName() + "already works at " + chef.getRestaurant().getName() + ".");
//		}
		chef.setHireDate(hireDate);
		this.chef_list.add(chef); 
		
		System.out.println("Chef " + chef.getName() + " was hired.");		
	
	}
	
	public void fireChef(Chef chef) {
//		this.getRestaurant().removeChef(chef);
//		chef.setRestaurant(new Restaurant());
//		System.out.println("Chef " + chef.getName() + " was fired from Restaurant " + this.getRestaurant().getName() + ".");
		this.chef_list.remove(chef);
		System.out.println("Chef " + chef.getName() + " was fired.");
	}
	
	public void hireHostess(Hostess hostess, String hireDate) {
//		if (hostess.getRestaurant().getName().compareTo("unknown") == 1) {
//			
//			hostess.setHireDate(hireDate);
//			this.getRestaurant().addHostess(hostess); // possibly make restaraunt protected??
//			hostess.setRestaurant(this.getRestaurant());
//			
//			System.out.println("Hostess " + hostess.getName() + " was hired at Restaurant " + this.getRestaurant().getName() + ".");		
//		}
//		
//		else {
//			System.out.print("Hostess " + hostess.getName() + " cannot be hired at Restaurant " + this.getRestaurant().getName() + ". ");
//			System.out.println("Hostess " + hostess.getName() + "already works at " + hostess.getRestaurant().getName() + ".");
//		}
		
		hostess.setHireDate(hireDate);
		this.hostess_list.add(hostess);
		System.out.println("Hostess " + hostess.getName() + " was hired.");		
	}
	
	public void fireHostess(Hostess hostess) {
//		this.getRestaurant().removeHostess(hostess);
//		hostess.setRestaurant(new Restaurant());
//		System.out.println("Hostess " + hostess.getName() + " was fired from Restaurant " + this.getRestaurant() + ".");
		this.hostess_list.remove(hostess);
		System.out.println("Hostess " + hostess.getName() + " was fired.");
	}
	
	public void setHireDate(String hireDate) {
		super.setHireDate(hireDate);
	}
	
	//SHOULD CHANGING TO ACCEPT INVENTORY
	public void orderItem(Ingredient ingredient, Integer amount) {
		//if (this.getRestaurant().getRevenue() - (ingredient.getCost() * amount) >= 0) { // make revenue and money separate???
			// go through inventory and find item. if it's not there, then add to inventory.
			ingredient.addAmount(amount);
			//this.getRestaurant().subtractRevenue(ingredient.getCost() * amount);
			System.out.println(amount + " " + ingredient.getName() + "(s) have been successfully ordered.");
		//}
		
		//else {
		//	System.out.println("Cannot order " + amount + " " + ingredient.getName() +"(s). Restaurant " + this.getRestaurant().getName() + " does not have enough revenue.");
		//}
	}
	
	public void addShift(Employee employee, Integer shift) {
		if ((shift == 101) || (shift == 102) || (shift == 103)
				|| (shift == 201) || (shift == 202) || (shift == 203) || 
				(shift == 301) || (shift == 302) || (shift == 303) || 
				(shift == 401) || (shift == 402) || (shift == 403) || 
				(shift == 501) || (shift == 502) || (shift == 503) ||
				(shift == 601) || (shift == 602) || (shift == 603) || 
				(shift == 701) || (shift == 702) || (shift == 703)) {
			employee.setShift(shift);
		}
		else {
			System.out.println(shift + " is an invalid shift code. Please enter: 101, 102, 103, 201, 202, 203, 301, 302, 303, "
					+ "401, 402, 403, 501, 502, 503, 601, 602, 603, 701, 702, 703");
		}
	}
	
	public void removeShift(Employee employee, Integer shift) {
		if ((shift == 101) || (shift == 102) || (shift == 103)
				|| (shift == 201) || (shift == 202) || (shift == 203) || 
				(shift == 301) || (shift == 302) || (shift == 303) || 
				(shift == 401) || (shift == 402) || (shift == 403) || 
				(shift == 501) || (shift == 502) || (shift == 503) ||
				(shift == 601) || (shift == 602) || (shift == 603) || 
				(shift == 701) || (shift == 702) || (shift == 703)) {
			employee.removeShift(shift);
		}
		else {
			System.out.println(shift + " is an invalid shift code. Please enter: 101, 102, 103, 201, 202, 203, 301, 302, 303, "
					+ "401, 402, 403, 501, 502, 503, 601, 602, 603, 701, 702, 703");
		}
	}
	
	public void assignTableToWaiter(Table table, Waiter waiter) {
		waiter.addTable(table);
		table.setWaiter(waiter);
	}
	
	public void removeTableFromWaiter(Table table, Waiter waiter) {
		waiter.removeTable(table);
		table.setWaiter(new Waiter());
	}
	
	public ArrayList<Waiter> getWaiters() {
		return waiter_list;
	}
	
	public ArrayList<Bartender> getBartenders() {
		return bartender_list;
	}
	
	public ArrayList<Chef> getChefs() {
		return chef_list;
	}
	
	public ArrayList<Hostess> getHostesses() {
		return hostess_list;
	}
	
	public void setEmployeePay(Employee employee, double hourlyPay) {
		employee.setHourlyPay(hourlyPay);
	}
	
	public void printEmployees() {	// new, for testing interactive.
		System.out.println("Current Employees: ");
		System.out.println("Manager - " + this.getName());
		for (Waiter w : waiter_list) {
			System.out.println("Waiter - " + w.getName());
		}
		for (Bartender b : bartender_list) {
			System.out.println("Bartender - " + b.getName());
		}
		for (Hostess h : hostess_list) {
			System.out.println("Hostess - " + h.getName());
		}
		for (Chef c : chef_list) {
			System.out.println("Chef - " + c.getName());
		}
	}
	
	public boolean employeeExists(String name) {
		if (this.getName().equalsIgnoreCase(name)) {
			return true;
		}
		
		for (Waiter w : waiter_list) {
			if(w.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		for (Bartender b : bartender_list) {
			if(b.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		for (Hostess h : hostess_list) {
			if(h.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		for (Chef c : chef_list) {
			if(c.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	public Employee searchEmployee(String name) {
		if (this.getName().equalsIgnoreCase(name)) {
			return this;
		}
		
		for (Waiter w : waiter_list) {
			if(w.getName().equalsIgnoreCase(name)) {
				return w;
			}
		}
		for (Bartender b : bartender_list) {
			if(b.getName().equalsIgnoreCase(name)) {
				return b;
			}
		}
		for (Hostess h : hostess_list) {
			if(h.getName().equalsIgnoreCase(name)) {
				return h;
			}
		}
		for (Chef c : chef_list) {
			if(c.getName().equalsIgnoreCase(name)) {
				return c;
			}
		}
		
		return null;
	}

}
