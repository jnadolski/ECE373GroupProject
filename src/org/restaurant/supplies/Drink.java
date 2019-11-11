package org.restaurant.supplies;

import java.util.ArrayList;

public class Drink {

	private String name; 
	private double cost; 
	private boolean availability; 
	private boolean complete; 
	private boolean hasAlcohol; 
	private ArrayList<Ingredient> ingredients; 
	private ArrayList<Integer> serving; 
	
	public Drink() {
		name = "unknown"; 
		cost = 0; 
		availability = false; 
		complete = false;
		hasAlcohol = false; 
		ingredients = new ArrayList<Ingredient>(); 
		serving = new ArrayList<Integer>(); 
	}
	
	public void setName(String name) { this.name = name; } 
	public String getName() { return name; }
	public void setCost(double cost) { this.cost = cost; } 
	public double getCost() { return cost; } 
	public void setHasAlcohol(boolean alcohol) { hasAlcohol = alcohol; }
	public boolean getHasAlcohol() { return hasAlcohol; }
	public void addIngredient(Ingredient i, int serving) { 
		this.serving.add(serving);
		ingredients.add(i); 
	}
	public boolean checkAvailability() {
		availability = true; 
		for(int i = 0; i < ingredients.size(); i++) {
			if((ingredients.get(i).getAmount() - serving.get(i)) < 0) {
				availability  = false; 
			}
		}
		return availability; 
	}
	public void completeOrder() {
		if(checkAvailability() == false) 
			complete = false; 
		else {
			for(int i = 0; i < ingredients.size(); i++) {
				ingredients.get(i).subtractAmount(serving.get(i));
			}
			complete = true; 
		}
	}
	public boolean checkCompleted() { return complete; }

}
