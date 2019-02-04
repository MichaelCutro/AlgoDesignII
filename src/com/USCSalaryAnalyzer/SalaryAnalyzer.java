//First download driver
import java.io.*;
import java.util.*;
public class SalaryAnalyzer {
	
	static final String IN_FILE_NAME = "salary.txt";
	
	static final String OUT_FILE_NAME = "OVER250000.txt";
	
	static final String DELIM = "\t";
	
	public static void main(String[] args)  throws IOException 
	{
		System.out.println("Let's see how many state employees make over $250,000 and work at USC.");
		analyzeEmployeeFile(IN_FILE_NAME);
		System.out.println("Results have been printed to "+OUT_FILE_NAME);
	}
	public static void analyzeEmployeeFile(String fileName) throws IOException
	{
		String output = "";
		// Create a file Scanner to read the file
		Scanner fileScanner = new Scanner (new File(fileName));
		//Ignore line1
		fileScanner.nextLine();
		while(fileScanner.hasNextLine())
		{
			//Each line infile
			String line = fileScanner.nextLine();
			//Split each line into row data
			String rowData [] = line.split(DELIM);
			// salary > 250k?
			if(rowData.length<7) break;
			//Finding total income
			String salary = rowData[7];
			//If USC && Salary > 250k
			if (rowData[0].equals("UNIVERSITY OF SOUTH CAROLINA") && Integer.parseInt(salary)>250000 )
			{
				System.out.println(line);
				output+=(line+"\n");
				
			}
		}
		
		printToSalaryFile (OUT_FILE_NAME, output);
	}
	public static void printToSalaryFile(String fileName, String text) throws FileNotFoundException
	{
		PrintWriter fileWrite = new PrintWriter (new File (fileName));
		fileWrite.print(text);
		fileWrite.close();
	}
	
}
