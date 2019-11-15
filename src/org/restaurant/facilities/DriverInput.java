package org.restaurant.facilities;

import java.util.ArrayList;
import java.util.Scanner;
import org.restaurant.people.*;
import org.restaurant.supplies.*;

public class DriverInput {

	public static void main(String[] args) {
		int numTables; 
		int w_index = 0;
		int b_index = 0;
		int c_index = 0;
		int h_index = 0;
		int shiftCode = 0;
		String employeeName;
		boolean hire_exit = false;
		Scanner in = new Scanner(System.in);
		
		Restaurant r = new Restaurant(); 
		System.out.println("Enter restaurant name:");
		r.setName(in.nextLine());
		if(!r.getName().equalsIgnoreCase("skip")) {		//delete this line 
		System.out.println("Enter restaurant phone number:");
		r.setPhone(in.nextLine());
		System.out.println("Enter restaurant location:");
		r.setLocation(in.nextLine());
		System.out.println("Enter restaurant rating:");
		r.setRating(in.nextDouble());
		System.out.println("Enter restaurant revenue:");
		r.setRevenue(in.nextDouble());
		}														//delete this line
		System.out.println("How many tables are in the restaurant? ");
		numTables = in.nextInt();
		for(int i = 1; i <= numTables; i++) {
			Table t = new Table(); 
			t.setTableNumber(i);
			System.out.println("How many seats are at table " + i + "? ");
			t.setNumberOfSeats(in.nextInt());
		}
		
		
		//initializing inventory, ingredients, food, and drink 
		Inventory inv = new Inventory(); 
		System.out.println("\n---Creating Menu Items---");
		String selection = "test"; 
		String done = "not done"; 
		boolean flag = false; 
		do {
			System.out.println("To create an item, enter \"ingredient\", \"food\", \"drink\", or enter \"done\" to finish.");
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
				System.out.println();
			}
			else if(selection.equalsIgnoreCase("food")) {
				if(inv.getIngredients().size() == 0) {
					System.out.println("Need at least one ingredient to create food.\n");
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
						flag = false;
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
						if((flag != true) && (!done.equalsIgnoreCase("done")))
							System.out.println("Invalid ingredient.");
					}while(!done.equalsIgnoreCase("done"));
					r.addToFoodMenu(f);
					flag = false; 
					done = "not done"; 
					System.out.println();
				}
			}
			else if(selection.equalsIgnoreCase("drink")) {
				if(inv.getIngredients().size() == 0) {
					System.out.println("Need at least one ingredient to create drink.\n");
				}
				else {
					System.out.println("Creating a drink!");
					Drink d = new Drink();  
					System.out.println("Enter name: ");
					d.setName(in.nextLine());
					System.out.println("Does it have alcohol: (\"yes\"/\"no\")");
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
								System.out.println("Enter amount of " + i.getName() + " in this drink:");
								d.addIngredient(i, in.nextInt());
								flag = true; 
							}
						}
						if((flag != true) && (!done.equalsIgnoreCase("done")))
							System.out.println("Invalid ingredient.");
					}while(!done.equalsIgnoreCase("done"));
					r.addToDrinkMenu(d);
					flag = false; 
					done = "not done"; 
					System.out.println();
				}
			}
			else {
				if (!selection.equalsIgnoreCase("done")) {
					System.out.println(selection + " is an invalid input. Try again.\n");
				}
			}
		}while(!selection.equalsIgnoreCase("done"));
		
		//hiring
		System.out.println("\n---Hiring Employees---");
		Manager m = new Manager();
		System.out.println("Please enter the manager's name: ");
		m.setName(in.nextLine());
		System.out.println("Please enter the manager's hire date: ");
		m.setHireDate(in.nextLine());
		
		do {
			System.out.println("Enter \"waiter\", \"bartender\", \"hostess\", or \"chef\" to hire a new employee. Enter \"done\" when finished.");
			selection = in.nextLine();
			while(selection.isBlank()) {
				selection = in.nextLine();
			}
			if(selection.equalsIgnoreCase("waiter")) {
				Waiter w = new Waiter();
				System.out.println("Please enter the waiter's name: ");
				w.setName(in.nextLine());
				System.out.println("Please enter the waiter's hire date: ");
				m.hireWaiter(w, in.nextLine());
				System.out.println("Please enter the waiter's pay rate: ");
				m.setEmployeePay(m.getWaiters().get(w_index), in.nextDouble());
				w_index = w_index + 1;
				System.out.println();
			}
			else if (selection.equalsIgnoreCase("bartender")) {
				Bartender b = new Bartender();
				System.out.println("Please enter the bartender's name: ");
				b.setName(in.nextLine());
				System.out.println("Please enter the bartender's hire date: ");
				m.hireBartender(b, in.nextLine());
				System.out.println("Please enter the bartender's pay rate: ");
				m.setEmployeePay(m.getBartenders().get(b_index), in.nextDouble());
				b_index = b_index + 1;
				System.out.println();
			}
			
			else if (selection.equalsIgnoreCase("hostess")) {
				Hostess h = new Hostess();
				System.out.println("Please enter the hostess' name: ");
				h.setName(in.nextLine());
				System.out.println("Please enter the hostess' hire date: ");
				m.hireHostess(h, in.nextLine());
				System.out.println("Please enter the hostess' pay rate: ");
				m.setEmployeePay(m.getHostesses().get(h_index), in.nextDouble());
				h_index = h_index + 1;
				System.out.println();
			}
			
			else if (selection.equalsIgnoreCase("chef")) {
				Chef c = new Chef();
				System.out.println("Please enter the chef's name: ");
				c.setName(in.nextLine());
				System.out.println("Please enter the chef's hire date: ");
				m.hireChef(c, in.nextLine());
				System.out.println("Please enter the chef's pay rate: ");
				m.setEmployeePay(m.getChefs().get(c_index), in.nextDouble());
				c_index = c_index + 1;
				System.out.println();
			}
			else if (selection.equalsIgnoreCase("done")) {
				if ((m.getBartenders().size() < 1) || (m.getWaiters().size() < 1) || 
						(m.getChefs().size() < 1) || (m.getHostesses().size() < 1)) {
					System.out.println("One of each type of employee is required to move on to the next section.\n");
					hire_exit = false;
				}
				else {
					hire_exit = true;
				}
			}
			else {
				if (!selection.equalsIgnoreCase("done")) {
					System.out.println("Invalid input. Please try again.");
					System.out.println();
				}
			}
		}while((!selection.equalsIgnoreCase("done")) || (hire_exit == false));
		//need to enter manager information first
		//give option to hire waitress, chef, bartender, and hostess
		//need one of each to move on to next section or maybe offer force quit to move on and see printing informaiton 
		System.out.println("\n---Assigning Shifts---");
		do {
			System.out.println("Enter an employee's name to assign a shift to their schedule. Enter \"print\" to view all current employees, and \"done\" when finished.");
			selection = in.nextLine();
			
			if (selection.equalsIgnoreCase("print")) {
				m.printEmployees();
				System.out.println();
			}
			
			else if (m.employeeExists(selection) == true) {
				Employee e = m.searchEmployee(selection);
				System.out.println("Please enter a shift code: ");
				shiftCode = in.nextInt();
				in.nextLine(); // gets rid of the null character after taking in an Int.
				m.addShift(e, shiftCode);
				System.out.println();
			}
			
			else {
				if (!selection.equalsIgnoreCase("done")) {
					System.out.println(selection + " is not an employee at " + r.getName() +".");
				}
			}
			
		}while(!selection.equalsIgnoreCase("done"));
		
		//prints or actions
		System.out.println();
		do {
			System.out.println("Enter \"print\" to print information, \"exit\" to exit, or one of the following to see their actions: (manager, hostess, waiter, chef, bartender) "); 
			selection = in.nextLine();
			if(selection.isBlank())
				selection = in.nextLine();
			if(selection.equalsIgnoreCase("print")) {
				do {
					System.out.println("To print the information, enter one of the following: restaurant, shifts, done ");
					selection = in.nextLine();
					if(selection.isBlank())
						selection = in.nextLine();
					if(selection.equalsIgnoreCase("restaurant")) {
						System.out.println("---Restaurant Information---");
						System.out.println(r.getName() + "\n" + r.getLocation() + "\n" + r.getPhone());
						System.out.println("Rating:  " + r.getRating() + "\nRevenue:  " + r.getRevenue());
						System.out.println();
					}
					else if(selection.equalsIgnoreCase("shifts")) {
						System.out.println("Enter an employee's name to view their shifts: ");
						employeeName = in.nextLine();
						if (m.employeeExists(employeeName) == true) {
							Employee e = m.searchEmployee(employeeName);
							e.printShift();
							System.out.println();
						}
						else {
							System.out.println(employeeName + " is not an employee at " + r.getName() + ".\n");
						}
						//ask for employee to see shift of 
					}
					
					else {
						if(!selection.equalsIgnoreCase("done")) {
							System.out.println(selection + " is an invalid input. Please try again.\n");
		
						}
					}
					//reservation list from hostess
					//wait list from hostess
					//print table status from hostess 
					//tables assigned to waiter 
					//print queued orders in chef
					//print completed orders in chef
					//print queued orders in bartender 
					//print completed orders in bartender 
					
					
				}while(!selection.equalsIgnoreCase("done")); 
			}
			else if(selection.equalsIgnoreCase("manager")) {
				System.out.println("Manager options: "); 
				System.out.println("Adds shifts to employees' schedules.");//add shifts 
				System.out.println("Remove shifts from employee's schedules.");//remove shifts
				System.out.println("Assigns tables covered to a waiter.");//assign table to waiter
				System.out.println("Removes tables that the waiter no longer covers.\n");//remove table from waiter 
			}
			else if(selection.equalsIgnoreCase("Hostess")) {
				System.out.println("Hostess options: "); 
				System.out.println("Creates a party of customers.");//create party
				System.out.println("Must add party to the wait or reservation list.");	//must add party to wait list or reservation list 
				System.out.println("Seats guests at appropriate tables.");//seat guests
				System.out.println("Checks a table's current status.");//check table status
				System.out.println("Changes a table's status.\n");//change table status
			}
			else if(selection.equalsIgnoreCase("Waiter")) {
				System.out.println("Waiter options: "); 
				System.out.println("Inputs customers' orders into the system.");//input order 
				System.out.println("Passes drink orders to the bar.");//pass order to bar
				System.out.println();//make customer pay (done through tables assigned -> customer of that table)
				//make table leave 
			}
			else if(selection.equalsIgnoreCase("Chef")) {
				System.out.println("Chef options: "); 
				System.out.println("Completes food orders.\n");//complete order 
			}
			else if(selection.equalsIgnoreCase("Bartender")) {
				System.out.println("Bartender options: "); 
				System.out.println("Completes drink orders. Must check that customer is 21 or older.\n");
				//complete order --- need to set customer age to over 21 first 
			}
			else {
				if (!selection.equalsIgnoreCase("exit")) {
					System.out.println("Invalid input. Please try again.\n");
				}
			}
			
		}while(!selection.equalsIgnoreCase("exit")); 
		
		System.out.println("End of restaurant interactive demonstration."); 
		in.close();
	}

}