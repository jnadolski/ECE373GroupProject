package org.restaurant.supplies;

import java.util.ArrayList;

import org.restaurant.facilities.Restaurant;

public class Inventory {

	private ArrayList<Ingredient> ingredientsList; 
	public Inventory() {
		ingredientsList = new ArrayList<Ingredient>(); 
	}
	public void addIngredient(Ingredient i) { ingredientsList.add(i); }
	public ArrayList<Ingredient> getIngredients() { return ingredientsList; } 
	public void restock() {
		for(Ingredient i : ingredientsList) {
			i.addAmount(10);
		}
	}
	public void restock(Ingredient ingredient, int amount) {
		for(Ingredient i : ingredientsList) {
			if(ingredient.getName().equals(i.getName())){
				i.addAmount(amount);
			}
		}
	}

}
