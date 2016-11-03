package com.core.java.poc;

import java.math.BigDecimal;

public class CompareAndEquals {
	int x, y;

	CompareAndEquals(int x, int y) {
		this.x = x;
		this.y = y;
	}

	void sum() {
		int z = x + y;
	}

	public static void main(String[] args) {
		CompareAndEquals ce1 = new CompareAndEquals(10, 20);
		ce1.sum();
		CompareAndEquals ce2 = new CompareAndEquals(10, 20);
		ce2.sum();
		Integer x = 5;
		System.out.println(x.compareTo(3));
		System.out.println(x.compareTo(5));
		System.out.println(x.compareTo(8));
		
		BigDecimal bd1 = new BigDecimal(2.0);
		BigDecimal bd2 = new BigDecimal(2.00);
		      
		System.out.println("comparing BigDecimal using equals: " + bd1.equals(bd2));
		System.out.println("comparing BigDecimal using compareTo: " + bd1.compareTo(bd2));


		
		// int result = ((Object) ce1).compareTo(ce2);
		if (ce1 == ce2) {
			System.out.println("Equals ");
		} else {
			System.out.println("Not Equals ");
		}

	}

}
