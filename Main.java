package com.homework.shellsort;

public class Main {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int size = 1000;
		int[] mass = new int[size];
		for (int i = 0; i < mass.length; i++) {
			mass[i] = ((int)(Math.random() * 100000));
		}
		Thread[] tmp = new Thread[4];
		ShellSort[] sort = new ShellSort[4];
		int separator = size/tmp.length;

		for (int i = 0; i < tmp.length; i++) {
			sort[i] = new ShellSort(mass,separator*(i+1));

			
			tmp[i] = new Thread(sort[i]);
		}
		try {
		for (int i = 0; i < tmp.length;i++) {
			tmp[i].start();
		}
		
		for (int i = 0; i < tmp.length;i++) {
			tmp[i].join();
		}
		}catch(InterruptedException e) {
	
		}
		int[] finish = sort[3].getMass();

		for (int i = 0; i < finish.length; i++) {
			System.out.println(finish[i]);
		}
		System.out.println(System.currentTimeMillis() - start + "ms");
	}
}
