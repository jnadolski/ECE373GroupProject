package org.restaurant.facilities;

import java.util.ArrayList;
import java.util.Scanner;
import org.restaurant.people.*;
import org.restaurant.supplies.*;

public class DriverInput {

	public static void main(String[] args) {
		int numTables; 
		Scanner in = new Scanner(System.in);
		
		Restaurant r = new Restaurant(); 
		System.out.println("Enter restaurant name:");
		r.setName(in.nextLine());
		if(!r.getName().equalsIgnoreCase("skip")) {
		System.out.println("Enter restaurant phone number:");
		r.setPhone(in.nextLine());
		System.out.println("Enter restaurant phone location:");
		r.setLocation(in.nextLine());
		System.out.println("Enter restaurant rating:");
		r.setRating(in.nextDouble());
		System.out.println("Enter restaurant revenue:");
		r.setRevenue(in.nextDouble());
		System.out.println("How many tables are in the restaurant? ");
		numTables = in.nextInt();
		for(int i = 0; i < numTables; i++) {
			
		}
		
		System.out.println("---Restaurant Information---");
		System.out.println(r.getName() + "\n" + r.getLocation() + "\n" + r.getPhone());
		System.out.println("Rating:  " + r.getRating() + "\nRevenue:  " + r.getRevenue());
		}
		
		Inventory inv = new Inventory(); 
		System.out.println("\n---Creating Menu Items---");
		String selection = "test"; 
		String done = "not done"; 
		boolean flag = false; 
		do {
			System.out.println("To create an item, enter \"ingredient\", \"food\", \"drink\", or enter \"exit\" to exit.");
			selection = in.nextLine();
			if(selection.isBlank())
				selection = in.nextLine();
			if(selection.equalsIgnoreCase("ingredient")) {
				System.out.println("Creating an ingredient!");
				Ingredient i = new Ingredient(); 
				System.out.println("Enter name: ");
				i.setName(in.nextLine());
				System.out.println("Enter cost: ");
				i.setCost(in.nextDouble());
				inv.addIngredient(i);
				System.out.println("Enter amount in stock: ");
				inv.restock(i, in.nextInt());
			}
			else if(selection.equalsIgnoreCase("food")) {
				if(inv.getIngredients().size() == 0) {
					System.out.println("Need at least one ingredient to create food.");
				}
				else {
					System.out.println("Creating a food!");
					Food f = new Food();  
					System.out.println("Enter name: ");
					f.setName(in.nextLine());
					System.out.println("Enter cost: ");
					f.setCost(in.nextDouble());
					do {
						System.out.println("Enter ingredient name to add or enter \"done\": ");
						done = in.nextLine();
						if(done.isBlank())
							done = in.nextLine();
						for(Ingredient i : inv.getIngredients()) {
							if(done.equalsIgnoreCase(i.getName())) {
								System.out.println("Enter amount of " + i.getName() + " in this food:");
								f.addIngredient(i, in.nextInt());
								flag = true; 
							}
						}
						if(flag != true)
							System.out.println("Invalid ingredient.");
					}while(!done.equalsIgnoreCase("done"));
					r.addToFoodMenu(f);
					flag = false; 
					done = "not done"; 
				}
			}
			else if(selection.equalsIgnoreCase("drink")) {
				if(inv.getIngredients().size() == 0) {
					System.out.println("Need at least one ingredient to create drink.");
				}
				else {
					System.out.println("Creating a drink!");
					Drink d = new Drink();  
					System.out.println("Enter name: ");
					d.setName(in.nextLine());
					System.out.println("Does it have alcohol: (\"yes\"/\"no\"");
					done = in.nextLine();
					if(done.equalsIgnoreCase("yes"))
						d.setHasAlcohol(true);
					else if(done.equalsIgnoreCase("no"))
						d.setHasAlcohol(false);
					else {
						System.out.println("Invalid option. " + d.getName() + " is assumed to be nonalcoholic.");
						d.setHasAlcohol(false);
					}
					System.out.println("Enter cost: ");
					d.setCost(in.nextDouble());
					do {
						System.out.println("Enter ingredient name to add or enter \"done\": ");
						done = in.nextLine();
						if(done.isBlank())
							done = in.nextLine();
						for(Ingredient i : inv.getIngredients()) {
							if(done.equalsIgnoreCase(i.getName())) {
								System.out.println("Enter amount of " + i.getName() + " in this food:");
								d.addIngredient(i, in.nextInt());
								flag = true; 
							}
						}
						if(flag != true)
							System.out.println("Invalid ingredient.");
					}while(!done.equalsIgnoreCase("done"));
					r.addToDrinkMenu(d);
					flag = false; 
					done = "not done"; 
				}
			}
		}while(!selection.equalsIgnoreCase("exit"));
		
		System.out.println("Enter an option: (print, hire, manager, )"); 
		
	}

}
