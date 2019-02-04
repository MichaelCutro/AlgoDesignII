package com.trees;

public class StrBSTreeTester {

public static String [] words = {"buzzwigs","ABBREVIATIONS","Cat","food","abovementioned","ABSORBABILITIES","VOLATILITY","I","TWIRLIEST","at"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing the tree");
		System.out.println("Inserting 10 words\n");
		StrBSTree tree = new StrBSTree();
		for (String i: words) {
			tree.insert(i);
		}
		System.out.println("\nPrinting pre-order traversal");
		tree.printPreOrder(tree.root);
		
		System.out.println("\nRemoving the word “food”");
		tree.remove("food");
		tree.printPreOrder(tree.root);
		
		
		System.out.println("\nThe Depth of "+" TWIRLIEST is "+tree.getDepth(tree.root, "TWIRLIEST", 0));
		System.out.println("Done!");
	}

}
