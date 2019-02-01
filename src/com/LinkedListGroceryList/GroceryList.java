package com.ll;
import java.text.DecimalFormat;
public class GroceryList {
	
	//Internal class listNode
	private class ListNode {
		
		//instance variables
		private GroceryItem data; 
		
		//type of list node
		private ListNode link;
		
		//Def constructor
		public ListNode () 
		{
			this.data = null;
			this.link = link;
		}
		
		//param constructor
		public ListNode( GroceryItem aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	//instance variables
	ListNode head;
	ListNode current;
	ListNode previous;
	
	//Constructor initializing head
	public GroceryList () 
	{
		head = current = previous = null;
	}
	
	//Added Methods 
	public void goToNext ()
	{
		if (current == null) 
			return;
		current = previous;
		current = current.link;
	}
	
	public GroceryItem getDataAtCurrent ()
	{
		if (current != null)
			return current.data;
		else 
			return null;
	}
	
	public void setDataAtCurrent ( GroceryItem item) 
	{
		if (current != null)
			current.data = item;
	}
	
	public void nextLink ()
	{
		current = current.link;
		current = current.link;
	}
	public void moveCurrForward ()
	{
		if (current == null)
			return;
		previous = current;
		current = current.link;
	}
	public void addItem (GroceryItem item)
	{
		//Create a new node
		ListNode newNode = new ListNode(item, null);
		//check head if null the list is empty 
		if (head == null)
		{
			head = newNode;
			current = head;
			return;
		}
		ListNode temp = head;
		//Find the end of the list 
		while(temp.link!=null)
		{
			temp = temp.link;
			//Add to the end
		}
		temp.link = newNode;
	}
	
	public void insertAfterCurrent (GroceryItem aData) 
	{
		//Using current as the pointer to point to the new node 
		ListNode newNode = new ListNode();
		newNode.data = aData;
		if (current != null)
		{
			newNode.link=current.link;
			current.link = newNode;
			
		}
		else if 
			(head != null) //Current outside of the linked list 
			return;
		else  //Empty list 
			return;
	}
	
	public void deleteCurrentNode ()
	{
		if (current != null && previous != null) 
		{
			previous.link = current.link;
			current = current.link;
		}
		else if (current != null && previous == null)
		{
			head = head.link;
			current = head;
		}
		else 
		{
			System.out.println("List was empty");
		}
	}
	
	public void showList ()
	{
		ListNode temp = head;
		while (temp != null) 
		{
			System.out.println("Name: "+temp.data.getName()+ ", Price: "+temp.data.getPrice());
			temp = temp.link;
		}
		
	}
	
	public boolean contains (GroceryItem aData)
	{
		ListNode temp = head;
		while (temp != null) 
		{
			if(temp.data.equals(aData)) return true;
			temp = temp.link;
		}
		return false;
	}
	
	public String totalCost ()
	{
		double sum = 0.0;
		ListNode temp = head;
		while (temp != null) 
		{
			sum = sum + temp.data.getPrice();
			temp = temp.link;
		}
		//Format 4 style points
		return new DecimalFormat("#.##").format(sum); 
	}
	
}
