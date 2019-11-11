package org.restaurant.people;

import org.restaurant.facilities.Restaurant;
import org.restaurant.facilities.Table;
import org.restaurant.supplies.Ingredient;

public class Manager extends Employee {
	// Constructor.
	public Manager() {
		
	}
	// Methods.
	public void payEmployee(Employee employee, int hoursWorked) {
		this.getRestaurant().subtractRevenue(employee.getHourlyPay() * hoursWorked); // keeps track of what money leaves restaurant, but not the employee's total money.
		System.out.println("Employee " + employee.getName() + " was paid $" + (employee.getHourlyPay() * hoursWorked) + ".");
	}
	
	/*public void addEmployeeHours(Employee employee, int hours) {
		employee.addHoursWorked(hours);
	}*/
	
	public void hireWaiter(Waiter waiter, String hireDate) {
		if (waiter.getRestaurant().getName().compareTo("unknown") == 1) {
			
			waiter.setHireDate(hireDate);
			this.getRestaurant().addWaiter(waiter); // possibly make restaraunt protected??
			waiter.setRestaurant(this.getRestaurant());
			
			System.out.println("Waiter " + waiter.getName() + " was hired at Restaurant " + this.getRestaurant().getName() + ".");		
		}
		
		else {
			System.out.print("Waiter " + waiter.getName() + " cannot be hired at Restaurant " + this.getRestaurant().getName() + ". ");
			System.out.println("Waiter " + waiter.getName() + "already works at " + waiter.getRestaurant().getName() + ".");
		}
		// print command alerting of new hire.
	}
	
	public void fireWaiter(Waiter waiter) {
		this.getRestaurant().removeWaiter(waiter);
		waiter.setRestaurant(new Restaurant());
		System.out.println("Waiter " + waiter.getName() + " was fired from Restaurant " + this.getRestaurant().getName() + ".");
	}
	
	public void hireBartender(Bartender bartender, String hireDate) {
		if (bartender.getRestaurant().getName().compareTo("unknown") == 1) {
			
			bartender.setHireDate(hireDate);
			this.getRestaurant().addBartender(bartender); // possibly make restaraunt protected??
			bartender.setRestaurant(this.getRestaurant());
			
			System.out.println("Bartender " + bartender.getName() + " was hired at Restaurant " + this.getRestaurant().getName() + ".");		
		}
		
		else {
			System.out.print("Bartender " + bartender.getName() + " cannot be hired at Restaurant " + this.getRestaurant().getName() + ". ");
			System.out.println("Waiter " + bartender.getName() + "already works at " + bartender.getRestaurant().getName() +".");
		}
	}
	
	public void fireBartender(Bartender bartender) {
		this.getRestaurant().removeBartender(bartender);
		bartender.setRestaurant(new Restaurant());
		System.out.println("Bartender " + bartender.getName() + " was fired from Restaurant " + this.getRestaurant().getName() +".");
	}
	
	public void hireChef(Chef chef, String hireDate) {
		if (chef.getRestaurant().getName().compareTo("unknown") == 1) {
			
			chef.setHireDate(hireDate);
			this.getRestaurant().addChef(chef); // possibly make restaraunt protected??
			chef.setRestaurant(this.getRestaurant());
			
			System.out.println("Chef " + chef.getName() + " was hired at Restaurant " + this.getRestaurant().getName() + ".");		
		}
		
		else {
			System.out.print("Chef " + chef.getName() + " cannot be hired at Restaurant " + this.getRestaurant().getName() + ". ");
			System.out.println("Chef " + chef.getName() + "already works at " + chef.getRestaurant().getName() + ".");
		}
	}
	
	public void fireChef(Chef chef) {
		this.getRestaurant().removeChef(chef);
		chef.setRestaurant(new Restaurant());
		System.out.println("Chef " + chef.getName() + " was fired from Restaurant " + this.getRestaurant().getName() + ".");
	}
	
	public void hireHostess(Hostess hostess, String hireDate) {
		if (hostess.getRestaurant().getName().compareTo("unknown") == 1) {
			
			hostess.setHireDate(hireDate);
			this.getRestaurant().addHostess(hostess); // possibly make restaraunt protected??
			hostess.setRestaurant(this.getRestaurant());
			
			System.out.println("Hostess " + hostess.getName() + " was hired at Restaurant " + this.getRestaurant().getName() + ".");		
		}
		
		else {
			System.out.print("Hostess " + hostess.getName() + " cannot be hired at Restaurant " + this.getRestaurant().getName() + ". ");
			System.out.println("Hostess " + hostess.getName() + "already works at " + hostess.getRestaurant().getName() + ".");
		}
	}
	
	public void fireHostess(Hostess hostess) {
		this.getRestaurant().removeHostess(hostess);
		hostess.setRestaurant(new Restaurant());
		System.out.println("Hostess " + hostess.getName() + " was fired from Restaurant " + this.getRestaurant() + ".");
	}
	
	public void setHireDate(String hireDate) {
		super.setHireDate(hireDate);
	}
	
	public void setRestaurant(Restaurant restaurant) {
		super.setRestaurant(restaurant);
	}
	
	public void orderItem(Ingredient ingredient, Integer amount) {
		if (this.getRestaurant().getRevenue() - (ingredient.getCost() * amount) >= 0) { // make revenue and money separate???
			// go through inventory and find item. if it's not there, then add to inventory.
			ingredient.addAmount(amount);
			this.getRestaurant().subtractRevenue(ingredient.getCost() * amount);
			System.out.println(amount + " " + ingredient.getName() + "(s) have been successfully ordered.");
		}
		
		else {
			System.out.println("Cannot order " + amount + " " + ingredient.getName() +"(s). Restaurant " + this.getRestaurant().getName() + " does not have enough revenue.");
		}
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
