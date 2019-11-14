package org.restaurant.facilities;

import java.util.ArrayList;
import java.util.Scanner;
import org.restaurant.people.*;
import org.restaurant.supplies.*;

public class DriverInput {

	public static void main(String[] args) {
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
		
		System.out.println("---Restaurant Information---");
		System.out.println(r.getName() + "\n" + r.getLocation() + "\n" + r.getPhone());
		System.out.println("Rating:  " + r.getRating() + "\nRevenue:  " + r.getRevenue());
		}
		
		Inventory inv = new Inventory(); 
		System.out.println("\n---Creating Menu Items---");
		char selection = 'i'; 
		do {
			System.out.println("Enter 'i' to create ingredient, 'f' to create food, 'd' to create drink, or 'e' to exit: ");
			selection = in.next().charAt(0);
			switch(selection) {
				case 'i':
					System.out.println("Creating an ingredient!");
					Ingredient i = new Ingredient(); 
					System.out.println("Enter ingredient name: ");
					i.setName(in.nextLine());
					System.out.println("Enter ingredient cost: ");
					i.setCost(in.nextDouble());
					inv.addIngredient(i);
					System.out.println("Enter ingredient amount: ");
					inv.restock(i, in.nextInt());
					break; 
				case 'f':
					
					System.out.println("f...");
					break;
				case 'd':
					System.out.println("d...");
					break;
			}
		}while(selection != 'e');
	}

}
