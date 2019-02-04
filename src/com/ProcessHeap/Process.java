package com.main;

/**
 * @author MikeCutro
 */
public class Process {
	// Instance variables
	private int Priority;
	private double time;
	private String name;

	// Parameterized Constructor
	public Process(String aName, double aTime, int aPriority) {
		if (aPriority < 1 || aTime < 1)
			return;
		this.Priority = aPriority;
		this.time = aTime;
		this.name = aName;
	}

	// Source getters and setters
	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		// Needs to be greater than 0
			this.Priority = priority;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		// Needs to be greater than 0
			this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Added method toString
	@Override
	public String toString() {
		return this.name + " " + this.time + " " + this.Priority;
	}

}
