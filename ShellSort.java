package com.homework.shellsort;

public class ShellSort implements Runnable {
	private int[] mass;
	private int stop;
	
	public ShellSort(int[] mass, int stop) {
		super();
		this.mass = mass;
		this.stop = stop;
	}
	
	private int getStop() {
		return stop;
	}


	public int[] getMass() {
		return mass;
	}

	public ShellSort() {
		super();
	}

	private int[] sort(int[] mass, int stop) {
		int inner, outer;
		int temp;

		int h = 1; 
		
		while (h <= stop) {
			h = h * 3 + 1; 
		}

		while (h > 0) { 
			
			for (outer = h; outer < stop; outer++) {
				temp = mass[outer];
				inner = outer;
			
				while (inner > h - 1 && mass[inner - h] >= temp) {
					mass[inner] = mass[inner - h];
					inner -= h;
				}
				mass[inner] = temp;
			}
			
			h = (h - 1) / 3; 
		}
		
		return mass;
	}
	@Override
	public void run() {
		synchronized (this){
		sort(mass,getStop());
		}
		
	}
	

}
