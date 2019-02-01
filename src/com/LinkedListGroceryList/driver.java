package com.ll;

public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Grocery List Tester"
							+"\nCreating grocery list"
							+"\nAdding 5 grocery items");
		
		//Demonstrate grocery item
		GroceryItem item0 = new GroceryItem("Taco Shells", 2.0);
		GroceryItem item1 = new GroceryItem("Salsa", 1.59);
		GroceryItem item2 = new GroceryItem("Chips", 1.29);
		GroceryItem item3 = new GroceryItem("Ground Beef", 4.59);
		GroceryItem item4 = new GroceryItem("Shredded Cheese", 2.99);
		GroceryItem item5 = new GroceryItem("Heart Burn Medicine", 5.99);
		GroceryItem item6 = new GroceryItem("Banana", 0.99);
		GroceryList list = new GroceryList();
		list.addItem(item0);
		list.addItem(item1);
		list.addItem(item2);
		list.addItem(item3);
		list.addItem(item4);
		list.showList();
		
		System.out.println("Moving Current Twice");
		System.out.println("Adding an item after current");
		list.nextLink();
		
		list.insertAfterCurrent(item5);
		System.out.println("Printing List");
		list.showList();
		
		System.out.println("Maybe I should add something healthy");
		list.insertAfterCurrent(item6);
		list.showList();
		
		System.out.println("Nevermind lets get rid of that");
		list.moveCurrForward();
		list.deleteCurrentNode();
		list.showList();
		
		System.out.println("Did I remember the salsa?");
		System.out.println(list.contains(item1));
		
		System.out.println("The total cost is "+ list.totalCost());
		
		
		
		
		
	}

}
