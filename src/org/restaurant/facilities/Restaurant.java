package org.restaurant.facilities;

import java.util.*;

import org.restaurant.people.Bartender;
import org.restaurant.people.Chef;
import org.restaurant.people.Hostess;
import org.restaurant.people.Manager;
import org.restaurant.people.Waiter;
import org.restaurant.supplies.*;

public class Restaurant {
    private String name;
    private String location;
    private String phone;
    private double rating;
    private double revenue;
//    private ArrayList<Waiter> waiter_list;
//    private ArrayList<Bartender> bartender_list;
//    private ArrayList<Chef> chef_list;
//    private ArrayList<Hostess> hostess_list;
    private Manager manager;
    private ArrayList<Food> foodMenu;
    private ArrayList<Drink> drinkMenu;
    private ArrayList<Table> tables;
    private Inventory inventory; 
    
    public Restaurant() {
        this.name = "unknown";
        this.location = "unknown";
        this.phone = "000-000-0000";
        this.rating = 0.0;
        this.revenue = 0.0;
//        this.waiter_list = new ArrayList<Waiter>();
//        this.bartender_list = new ArrayList<Bartender>();
//        this.chef_list = new ArrayList<Chef>();
        this.manager = new Manager();
        this.foodMenu = new ArrayList<Food>();
        this.drinkMenu = new ArrayList<Drink>();
        this.tables = new ArrayList<Table>();
        this.inventory = new Inventory(); 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

//    public ArrayList<Waiter> getWaiter_list() {
//        return this.waiter_list;
//    }
//
//    public void setWaiter_list(ArrayList<Waiter> waiter_list) {
//        this.waiter_list = waiter_list;
//    }
//
//    public ArrayList<Bartender> getBartender_list() {
//        return bartender_list;
//    }
//
//    public void setBartender_list(ArrayList<Bartender> bartender_list) {
//        this.bartender_list = bartender_list;
//    }
//
//    public ArrayList<Chef> getChef_list() {
//        return chef_list;
//    }
//
//    public void setChef_list(ArrayList<Chef> chef_list) {
//        this.chef_list = chef_list;
//    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
        //manager.setRestaurant(this); // might remove
    }

    public ArrayList<Table> getTables() {
        return this.tables;
    }

    public void addTable(Table table) {
    	this.tables.add(table); 
    }
    
    public void addRevenue(double Revenue) {
        this.revenue += Revenue;
    }
    
    public void subtractRevenue(double Revenue) {
        this.revenue -= Revenue;
    }
    
//    public void addWaiter(Waiter waiter) {
//        this.waiter_list.add(waiter);
//    }
//    
//    public void removeWaiter(Waiter waiter) {
//        this.waiter_list.remove(waiter);
//    }
//    
//    public void addBartender(Bartender bartender) {
//        this.bartender_list.add(bartender);
//    }
//    
//    public void removeBartender(Bartender bartender) {
//        this.bartender_list.remove(bartender);
//    }
//    
//    public void addChef(Chef chef) {
//    	this.chef_list.add(chef);
//    }
//    
//    public void removeChef(Chef chef) {
//    	this.chef_list.remove(chef);
//    }
//    
//    public void addHostess(Hostess hostess) {
//    	this.hostess_list.add(hostess);
//    }
//    
//    public void removeHostess(Hostess hostess) {
//    	this.hostess_list.remove(hostess);
//    }
    
    public ArrayList<Food> getFoodMenu() {
    	return foodMenu;
    }
    
    public void addToFoodMenu(Food food) {
    	foodMenu.add(food);
    }
    
    public ArrayList<Drink> getDrinkMenu() {
    	return drinkMenu;
    }
    
    public void addToDrinkMenu(Drink drink) {
    	drinkMenu.add(drink);
    }
    
    public Inventory getInventory() {
    	return this.inventory; 
    }
    
    public void setInventory(Inventory inventory) {
    	this.inventory = inventory; 
    }
}

