package com.simulator;

public class ProcessScheduler {
	//Attributes consist of a linked list queue of processes 
	//CurrProcess of type process 
	public LinkedListQueue<Process> processes = new LinkedListQueue<Process>();
	public Process currentProcess = null;
	
	//Take in process p, set the currprocess if equal to null/ else enqueue it!
	public void addProcess(Process p) 
	{
		if(currentProcess==null) currentProcess=p;
		else processes.enqueue(p);
	}
	//Returns the currently running process
	public Process getCurrentProcess() 
	{
		return this.currentProcess;
	}
	//Dequeue from process queue
	public void runNextProcess() 
	{
		this.currentProcess=processes.dequeue();
	}
	//Current process is replaced by the first element in the process queue
	public void cancelCurrentProcess() 
	{
		this.currentProcess=null;
		this.currentProcess=processes.dequeue();
	}
	//Print the queue
	public void printProcessQueue() 
	{
		processes.print();
	}
	 
}
