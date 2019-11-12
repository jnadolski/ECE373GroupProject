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
		employee.setShift(shift);
	}
	
	public void removeShift(Employee employee, Integer shift) {
		employee.removeShift(shift);
	}
	
	public void assignTableToWaiter(Table table, Waiter waiter) {
		waiter.addTable(table);
	}
	
	public void removeTableFromWaiter(Table table, Waiter waiter) {
		waiter.removeTable(table);
	}

}
