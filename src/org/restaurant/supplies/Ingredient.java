package org.restaurant.supplies;

public class Ingredient {

	private String name; 
	private double cost; 
	private int amount; 
	
	public Ingredient() {
		name = "unknown";
		cost = 0; 
		amount = 0; 
	}
	
	public void setName(String name) { this.name = name; } 
	public String getName() { return name; }
	public void setCost(double cost) { this.cost = cost; } 
	public double getCost() { return cost; } 
	public int getAmount() { return amount; } 
	public void addAmount(int add) { amount += add; }
	public boolean subtractAmount(int sub) {
		if((amount - sub) > 0)
			return false; 
		else 
			amount -= sub; 
		
		return true; 
	}

}
