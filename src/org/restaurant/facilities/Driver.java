package org.restaurant.facilities;

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
		
	}

}
