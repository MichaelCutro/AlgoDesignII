package com.ll;

public class GroceryItem {
	//Instance Variables 
	private String Name;
	private double Price;
	
	//Default constructor
	public GroceryItem()
	{
		this.Name= "No name yet";
		this.Price= 0.0;
		
	}
	//Param constructor 
	public GroceryItem(String aName, double aValue)
	{
		//Call Mutes
		this.setName(aName);
		this.setPrice(aValue);
	}
	//getterrrrs && setterrrrrs
	public String getName() 
	{
		return Name;
	}
	public void setName(String name) 
	{
		this.Name = name;
	}
	public double getPrice() 
	{
		return Price;
	}
	public void setPrice(double price) 
	{
		if(price >= 0.0) 
		{
		this.Price = price;
		}
		else 
		{
			System.out.println("Value cannot be negative");
		}
	}
	//toString method
	public String toString () 
	{
		return "Name: "+this.Name+", Price: "+this.Price;
	}
	//equals method
	public boolean equals (GroceryItem aGroceryItem)
	{
		return aGroceryItem != null &&
				this.Name.equals(aGroceryItem.getName()) && 
				this.Price == aGroceryItem.getPrice();
	}
	
	
	

}
