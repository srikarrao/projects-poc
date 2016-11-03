package com.javapuzzles.solutions;
import java.math.BigDecimal;

/**
 * Program implementing monetary calculations (avoid float, double) Use
 * BigDecimal(String) or long, int data types
 * 
 * @author SrikarRao
 *
 */
public class TimeForAChange {

	public static void main(String[] args) {

		BigDecimal change = new BigDecimal("2.0")
				.subtract(new BigDecimal("1.1"));
		System.out.println(change);
	}

}
