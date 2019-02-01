/**
 * @MichaelCutro 
 * ${MrC}
 */
package com.main;

//Write class word helper to store methods for driver
public class WordHelper {
	//mk char array of vowels to find vowels 
	public static char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u', 'y' };
	/**Implement sort by vowels, consonants, length method(s) static w/ 
	 * @param words
	 */
	public static String[] sortByVowels(String[] words) {
		return vowelSort(words);
	}

	public static String[] sortByConsonants(String[] words) {
		return consonantSort(words);
	}

	public static String[] sortByLength(String[] words) {
		return lengthSort(words);
	}

	//Construct vowels in method//increment vowels if isvowel
	public static int vowelsIn(String s) {
		int vowels = 0;
		for (char c : s.toCharArray()) {
			if (isVowel(c)) {
				vowels++;
			}
		}
		return vowels;
	}
	//Create method to identify vowels
	public static boolean isVowel(char c) {
		for (char c2 : vowels) {
			if (c2 == c) {
				return true;
			}
		}
		return false;
	}
	//Sort list by vowels 
	public static String[] vowelSort(String[] words) {
		//Clone to keep original list intact
		String[] ret = words.clone();
		String temp = null;
		for (int i = 0; i < ret.length; i++) {
			for (int j = 1; j < ret.length; j++) {
				int v1 = vowelsIn(ret[j - 1]);
				int v2 = vowelsIn(ret[j]);
				if (v1 > v2) {
					temp = ret[j - 1];
					ret[j - 1] = ret[j];
					ret[j] = temp;
				}
			}
		}
		return ret;
	}
	//Bub Sort list by length 
	public static String[] lengthSort(String[] words) {

		String temp;
		//keep original list intact
		String[] ret = words.clone();
		int n = ret.length;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (ret[j - 1].length() > ret[j].length()) {
					// swap element smallest to largest 
					temp = ret[j - 1];
					ret[j - 1] = ret[j];
					ret[j] = temp;
				}
			}
		}
		return ret;
	}
	//Sort list by consonant 
	public static String[] consonantSort(String[] words) {
		String[] ret = words.clone();
		String temp = null;
		for (int i = 0; i < ret.length; i++) {
			for (int j = 1; j < ret.length; j++) {
				int v1 = vowelsIn(ret[j - 1]);
				int v2 = vowelsIn(ret[j]);
				if (ret[j - 1].length() - v1 > ret[j].length() - v2) {
					temp = ret[j - 1];
					ret[j - 1] = ret[j];
					ret[j] = temp;
				}
			}
		}
		return ret;
	}

}
