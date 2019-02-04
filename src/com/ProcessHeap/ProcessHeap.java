package com.main;

import java.util.ArrayList;

public class ProcessHeap {
	// Instance variables
	public ArrayList<Process> Heap;
	private int maxSize;

	public ProcessHeap(int maxSize) {
		this.Heap = new ArrayList<Process>();
		this.maxSize = maxSize;
	}

	// Added methods
	public void insert(Process item) {
		if (Heap.size() == maxSize) {
			System.out.println("The List is full");
			return;
		}
		Heap.add(item);
		int last = Heap.size() - 1;
		int parent = parent(last);
		// Bubble time
		while (parent != last 
				&& Heap.get(last).getPriority() < Heap.get(parent).getPriority()) {
			swap(last, parent);
			last = parent;
			parent = parent(last);
		}

	}

	// Get the parents index
	public int parent(int i) {

		if (i % 2 == 1) {
			return i / 2;
		}

		return (i - 1) / 2;
	}

	// SWAP HELPER METHOD
	public void swap(int one, int two) {
		Process temp = Heap.get(two);
		Heap.set(two, Heap.get(one));
		Heap.set(one, temp);
	}

	public Process Peek() {
		return Heap.get(0);
	}

	public void printHeap() {
		for (Process a : Heap) {
			System.out.println(a.toString());
		}
	}

	public boolean isEmpty() {
		return Heap.size() == 0;
	}

	// Get rightChild index
	public int right(int i) {
		return 2 * i + 2;
	}

	// Get leftChild index
	public int left(int i) {
		return 2 * i + 1;
	}

	public Process remove() {
		if (Heap.size() == 1) {
			Process min = Heap.remove(0);
			return min;
		}
		// Get head
		Process min = Heap.get(0);
		// Get tail
		Process last = Heap.remove(Heap.size() - 1);
		// Set head to last item
		Heap.set(0, last);
		// Bubble up to have properties remain
		bubble(0);
		return min;
	}

	private void bubble(int i) {
		// TODO Auto-generated method stub
		int left = left(i);
		int right = right(i);
		int min = -1;
		// Less than go left
		if (left <= Heap.size() - 1 
				&& Heap.get(left).getPriority() < Heap.get(i).getPriority()) {
			min = left;
		} else {
			min = i;
		}
		// Min child on right side of current
		if (right <= Heap.size() - 1 
				&& Heap.get(right).getPriority() < Heap.get(min).getPriority()) {
			min = right;
		}
		// Parent child swap
		if (min != i) {
			swap(i, min);
			bubble(min);
		}

	}

}
