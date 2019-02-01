package com.simulator;

public class Process {
	//Create Attributes Name and completion time
	private String name;
	private double completionTime;
	//Create default constructor init variables 
	// to a Default Value
	public Process() 
	{
		this.name="unamed-process";
		this.completionTime=0.0;
	}
	//Create Param Constructor
	public Process(String name, double runtime) 
	{
		//super();
		this.name = name;
		this.completionTime = runtime;
	}
	//Getters and Setters w/ Validation check
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		if(name==null) return;
		this.name = name;
	}
	
	public double getCompletionTime() 
	{
		return completionTime;
	}
	
	public void setCompletionTime(double completionTime) 
	{
		this.completionTime = completionTime;
	}
	
	@Override
	public String toString() 
	{
		return "process-name: "+this.name+", process-runtime: "+this.completionTime;
	}
	
}
