package org.restaurant.people;

import java.util.*;

import org.restaurant.facilities.Table;
import org.restaurant.supplies.Drink;
import org.restaurant.supplies.Food;

public class Customer {
	private Table table;
	private String name;
	//private double money;
	private boolean paid; // used instead of money...
	private int age;
	private int wait_time;
	private String phone_number;
	private boolean seated;
	private int reservation_time;
	//private Customer paid_by;
	private ArrayList<Food> food_list;
	private ArrayList<Drink> drink_list;
	
	public Customer() {
		this.table = new Table();
		this.name = "unknown";
		this.paid = false;
		this.age = 0;
		this.wait_time = 0;
		this.phone_number = "unknown";
		this.seated = false;
		this.reservation_time  = 0;
		//this.paid_by = 
		this.food_list = new ArrayList<Food>();
		this.drink_list = new ArrayList<Drink>();
	}

	public Table getTable() {
		return table;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getPaid() {
		return paid;
	}

	protected void setPaid(boolean isPaid) {
		this.paid = isPaid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWait_time() {
		return wait_time;
	}

	protected void setWait_time(int wait_time) {
		this.wait_time = wait_time;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public boolean isSeated() {
		return seated;
	}

	protected void setSeated(boolean seated) {
		this.seated = seated;
	}

	public int getReservation_time() {
		return reservation_time;
	}

	public void setReservation_time(int reservation_time) {
		this.reservation_time = reservation_time;
	}

//	public Customer getPaid_by() {
//		return paid_by;
//	}
//
//	public void setPaid_by(Customer paid_by) {
//		this.paid_by = paid_by;
//	}

	public ArrayList<Food> getFood_list() {
		return food_list;
	}

	protected void setFood_list(Food food) {
		if (food.checkAvailability() == true) {
			this.food_list.add(food);
		}
		
		else {
			System.out.println(food.getName() + " is currently out of stock. Please make another selection.");
		}
	}

	public ArrayList<Drink> getDrink_list() {
		return drink_list;
	}

	protected void setDrink_list(Drink drink) {
		if (drink.checkAvailability() == true) {
			this.drink_list.add(drink);
		}
		
		else {
			System.out.println(drink.getName() + " is currently out of stock. Please make another selection.");
		}
	}
	
	protected void seated() {
		this.seated = true;
	}
	
	protected void setTable(Table aTable) {
		this.table = aTable;
	}
	
	protected void setWaitTime(int time) {
		wait_time = time;
	}
	
	public void tipBartender(Bartender b, double amount) {
		b.collectTip(amount);
	}
	
	public void tipWaiter(double amount) {
		table.getWaiter().collectTip(amount);
	}
	
	public void payBillSelf() {
		/*double total = 0;
		
		for (Food item:this.food_list) 
		{
			total += food.getCost();
		}
		for (Drink drink:this.drink_list) 
		{
			total += drink.getCost();
		}
		
		if(this.getMoney() < total) 
		{
			System.out.println(this.getName() + " does not have enough money to pay the bill himself/herself");
			return;
		}*/
		paid = true;
		//this.setPaid_by(this);
	}
	
	public void payBillTable() {
		/*double total = 0;
		
		food_list = this.getTable().getFood(); // should return all the food ordered at that table
		
		for (Food item:food_list) 
		{
			total += food.getCost();
		}
		
		drink_list = this.getTable().getFood(); // should return all the drinks ordered at that table
		
		for (Drink drink:this.drink_list) 
		{
			total += drink.getCost();
		}
		
		if(this.getMoney() < total) 
		{
			System.out.println(this.getName() + " does not have enough money to pay the bill for the table");
			return;
		}*/
		for (Customer c : this.getTable().getCustomers()) {
			if (c.getPaid() == false) {
				c.setPaid(true);
				//c.setPaidBy(this);
			}
			
//			else {
//				System.out.println("Customer " + c.getName() + "'s bill was already paid for by Customer " + c.getPaid_by().getName() + ".");
//			}
		}
		//this.setPaid_by(this);
	}
	
	public void payBillOthers(Customer...customers) {
		/*double total = 0;
		for (Customer c:customers)
		{
			for (Food item: c.getFood_list()) 
			{
				total += item.getCost();
			}
			for (Drink item: c.getDrink_list()) 
			{
				total += item.getCost();
			}
			
		}
		
		if(this.getMoney() < total) 
		{
			System.out.print(this.getName() + " does not have enough money to pay the bill for ");
			for(Customer c: customers) 
			{
				System.out.print(c.getName() + " ");
			}
			System.out.print(".");
			return;
		}
		
		this.setPaid_by(this);*/
		
		for (Customer c : customers) {
			if (c.getPaid() == false) {
				c.setPaid(true);
				//c.setPaidBy(this);
			}
			
//			else {
//				System.out.println("Customer " + c.getName() + "'s bill was already paid for by Customer " + c.getPaid_by().getName() + ".");
//			}
		}
		
	}
	
//	private void setPaidBy(Customer customer) {
//		paid_by = customer;
//	}
//	
	public void leave() { // added
		if (paid == false) {
			System.out.println("Customer " + this.getName() + " cannot leave the restaurant because their bill is not yet paid.");
		}
		else {
			paid = false;
			wait_time = 0;
			seated = false;
			reservation_time = 0;
			//paid_by = new Customer();
			food_list = new ArrayList<Food>();
			drink_list = new ArrayList<Drink>();
			
			table.removeCustomer(this);
		}
	}
}
