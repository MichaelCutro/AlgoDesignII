package com.io;

import java.util.Scanner;

public class ContainedWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter 2 words. I will determine if the letters of one is contained in the other");
		String word1 = keyboard.nextLine();
		String word2 = keyboard.nextLine();
		if (word1.length() > word2.length()) {
			System.out.println("false");
		} else {
			System.out.println(compareWords(word1, word2));
		}
	}

	private static boolean compareWords(String word1, String word2) {
		// TODO Auto-generated method stub
		if (word1.length() == 0)
			return true;
		// assign ch to first index of w1
		char ch = word1.charAt(0);
		if (word2.indexOf(ch) > -1) {
			// continue looking through w2 for other chars in w1
			return compareWords(word1.substring(1), word2);
		} else {
			return false;
		}
	}
	//CMD A + CMD SHFT F 

}
