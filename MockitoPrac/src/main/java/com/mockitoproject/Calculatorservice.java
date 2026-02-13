package com.mockitoproject;

public class Calculatorservice {
	
	
	Calculator c;
	
	public Calculatorservice(Calculator c) {
		this.c = c;
	}
	
	public int doubleadd(int a,int b) {
		return 2*c.add(a, b);
	}
	
}
