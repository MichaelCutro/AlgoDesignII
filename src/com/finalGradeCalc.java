package com.main;

import java.io.*;
import java.util.Scanner;

public class finalGradeCalc {
	public static final String DELIM = "\t";
	public static final String gradeFile = "testFile.txt";
	public static final String file = "other";
	public static final String[] delims = new String[] { "LABS", "HOMEWORK", "EXAM 1", "EXAM 2", "LAB EXAM 1",
			"LAB EXAM 2", "FINAL", "EXTRA CREDIT" };
	public static final String toDrop = "HOMEWORK";
	public static double[] weights = new double[] { 0.20, 0.30, 0.10, 0.10, 0.10, 0.10, 0.10, 0.02 };

	public static void main(String[] args) {
		double finalGrade = 0.0;
		// Read entire file inside one string
		String content = null;
		try {
			// Read using string terminator as delim
			content = new Scanner(new File(file)).useDelimiter("\\Z").next();
			// Find all grades under specified headers
			for (int i = 0; i < delims.length; i++) 
			{
				String delim = delims[i];
				try {
					// try to grab string of grades in between consecutive headers using index of
					// within string
					String gradeString = content.substring(content.indexOf(delim) + delim.length() + 1,
							content.indexOf(delims[i + 1]));
					double[] grades = toDoubles(gradeString.split("\\n"));
					if (delim.equals(toDrop)) 
					{
						grades = dropLowest(grades);
					}
					
					System.out.println("Your "+ delim+ " average is: " + avg(grades));
				
					
					finalGrade += (avgWeighted(grades, weights[i]));
				} catch (Exception e) {
					String gradeString = content.substring(content.indexOf(delim) + delim.length() + 1,
							content.length());
					double[] grades = toDoubles(gradeString.split("\\n"));
					if (delim.equals(toDrop)) 
					{
						grades = dropLowest(grades);
					}
					System.out.println("Your "+delim + " average is: " + avgWeightedEC(grades, weights[i]));
					finalGrade += (avgWeightedEC(grades, weights[i]));
					
					
					
				}
				
			}
			
			System.out.println("Your raw total is: " + Math.ceil(finalGrade));
			if(finalGrade >= 90)
                System.out.println("Your final grade is A");
            else if(finalGrade >= 85)
                System.out.println("Your final grade is B+");
            else if(finalGrade >= 80)
                System.out.println("Your final grade is B");
            else if(finalGrade >= 75)
                System.out.println("Your final grade is C+");
            else if(finalGrade >= 70)
                System.out.println("Your final grade is C");
            else if(finalGrade >= 65)
                System.out.println("Your final grade is D+");
            else if(finalGrade >= 60)
                System.out.println("Your final grade is D");
            else
                System.out.println("your final grade is F");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static double[] toDoubles(String[] str) 
	{
		double[] db = new double[str.length];
		for (int i = 0; i < str.length; i++) 
		{
			db[i] = Double.parseDouble(str[i]);
		}
		return db;
	}

	public static double[] dropLowest(double[] grades) 
	{
		double low = Double.MAX_VALUE;
		int idx = -1;
		// Find index of the lowest grade
		double[] ret = new double[grades.length - 1];
		for (int i = 0; i < grades.length; i++) 
		{
			if (grades[i] < low) 
			{
				low = grades[i];
				idx = i;
			}
		}
		System.out.println("Dropping lowest grade '" + grades[idx] + "' from " + toDrop);
		// Flag index of lowest grade to drop
		grades[idx] = -1.0;
		int i = 0;
		// Add all the grades to return list except lowest
		for (double d : grades) 
		{
			// Increment index in return list
			if (d != -1.0) 
			{
				ret[i] = d;
				i++;
			}
		}
		return ret;
	}

	// Find average with weight
	public static double avgWeighted(double[] grades, double weight) 
	{
		double avg = avg(grades);
		return (avg * weight);

	}

	public static double avgWeightedEC(double[] grades, double weight) 
	{
		double avg = avgEC(grades);
		return (avg * weight);

	}

	public static double avgEC(double[] grades) 
	{
		double avg = 0.0;
		for (double d : grades) 
		{
			avg += d;
		}

		return avg;
	}

	// Find basic average
	public static double avg(double[] grades)
	{
		double avg = 0.0;
		for (double d : grades) 
		{
			avg += d;
		}
		avg = avg / grades.length;
		return avg;
	}

}
