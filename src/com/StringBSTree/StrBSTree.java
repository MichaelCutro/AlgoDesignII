/*
 * Author @MrC
 */
package com.trees;

public class StrBSTree {
	// Internal class node
	private class Node {
		// Instance vars data, left and right child
		// Data is a STRING value
		public String data;
		public Node leftChild;
		public Node rightChild;

		// Construct the node
		public Node(String aData) {
			this.data = aData;
			leftChild = rightChild = null;
		}
	}

	// Instance var for first element in the tree 
	public Node root;

	public StrBSTree() {
		this.root = null;
	}

	// Added methods
	// Insert new data
	public void insert(String aData) {
		System.out.println("Inserting " + aData);
		Node insert = new Node(aData);
		root = insert(root, insert);
	}

	// Insert
	private Node insert(Node aNode, Node aData) {
		// Check ya head
		if (aNode == null) {
			// We found a null element place it there
			return aData;
		}
		if (aNode.equals(aData)) {
			return aData;
		}
		// Values less than parent go left
		if (aData.data.length() < aNode.data.length()) {
			aNode.leftChild = (insert(aNode.leftChild, aData));
		}
		// Values greater than parent go right
		else {
			aNode.rightChild = (insert(aNode.rightChild, aData));
		}

		return aNode;
	}

	public void remove(String aData) {
		Node insert = new Node(aData);
		root = remove(root, insert);
	}

	public Node remove(Node aNode, Node aData) {
		// Find the value
		if (aNode == null) { // Val not found return null
			return null;
		} else if (aData.data.length() < aNode.data.length()) // Go Left
			aNode.leftChild = remove(aNode.leftChild, aData);
		else if (aData.data.length() > aNode.data.length()) // Go right
			aNode.rightChild = remove(aNode.rightChild, aData);
		else // We have found the value now kill it
		{
			if (aNode.rightChild == null) { // Either has no child or left
				return aNode.leftChild;
			} else if (aNode.leftChild == null) { // Has only right child
				return aNode.rightChild;
			} else {
				// It has two children
				// Overwrite the data
				Node Min = smallestInTree(aNode.rightChild);
				aNode.data = Min.data;
				aNode.rightChild = (remove(aNode.rightChild, aNode)); // Delete the duplicate {2 Children 2 Deletions)
			}
		}
		return aNode;
	}

	public Node smallestInTree(Node aNode) {
		if (aNode.leftChild == null) {
			root = aNode.leftChild;
		}
		return root;
	}

	// TRAVERSALS
	public void printPreOrder(Node aNode) {
		// Halting condition
		if (aNode != null) {
			System.out.println(aNode.data);
			printPreOrder(aNode.leftChild);// Recursive left
			printPreOrder(aNode.rightChild);// Recursive right
		}
	}

	// Get Depth
	// Number of edges from root of number
	// Take in String, Node, Length
	// Return -1 if depth isn't found
	public int getDepth(Node aNode, String aData, int currDepth) {
		if (!find(aData)) {
			return -1;
		}
		if (aNode.data == aData) {
			return currDepth;
		} else if (aData.length() > aNode.data.length()) { 
			return getDepth(aNode.rightChild, aData, currDepth + 1);
		} else if (aData.length() < aNode.data.length()) {  
			return getDepth(aNode.leftChild, aData, currDepth + 1);
		} else {
			return -1;
		}

	}

	// Helper method for getDepth
	private boolean find(String aData) { 
		// TODO Auto-generated method stub
		Node current = root;
		while (current != null) { // Null check
			if (current.data.equals(aData)) { // If data == found 
				return true;
			} else if (current.data.length() > aData.length()) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}

		}
		return false;
	}

}
