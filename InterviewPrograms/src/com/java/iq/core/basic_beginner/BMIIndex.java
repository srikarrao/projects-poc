package com.java.iq.core.basic_beginner;

import java.util.Scanner;

public class BMIIndex {
	public static boolean inPounds = false;
	public static boolean inFeet = false;
	public static double weight = 0;
	public static double height = 0;
	public static String name;
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter your name to know your BMI");
		try {
			name = scn.nextLine();
			System.out.println("Welcome to BMI index: " + name);
			getHeight();
			getWeight();
			double result = calculateBMI();
			displayBMI(name, result);
		} catch (Exception e) {
			System.out.println("Exception Occurred " + e);
		}
	}

	public static double calculateBMI() {
		double bmi = 0;
		try {
			bmi = weight / (height * height);
		} catch (Exception ne) {
			System.out.println("Couldn't calculate the BMI: " + ne);
		}
		return bmi;
	}

	public static void displayBMI(String name, double bmiValue) {
		try {
			if (bmiValue > 0) {
				if (bmiValue < 18.5) {
					System.out.println(name + ", the BMI value: "
							+ String.format("%.2f", bmiValue) + " says you're "
							+ "underweight");
				} else if (bmiValue >= 18.5 && bmiValue <= 24.9) {
					System.out.println(name + ", the BMI Value: "
							+ String.format("%.2f", bmiValue) + " says you're "
							+ "normal");
				} else if (bmiValue >= 25.0 && bmiValue <= 29.9) {
					System.out.println(name + ", the BMI Value: "
							+ String.format("%.2f", bmiValue) + " says you're "
							+ "overweight");
				} else {
					System.out.println(name + ", the BMI value: "
							+ String.format("%.2f", bmiValue)
							+ " says you're  " + " overdose");
				}
				System.out.println("Refer the below table for details");
				System.out.println();
				System.out.println("BMI      Category     ");
				System.out.println("--------------------");
				System.out.println("less than 18.5    underweight");
				System.out.println("18.5 to 24.9 normal");
				System.out.println("25.0 to 29.9 overweight");
				System.out.println("30.0 or more overdose");
			}
		} catch (Exception e) {
			System.out.println("Couldn't display BMI : " + e);
		}
	}

	public static void getWeight() {
		try {
			boolean isWeightValid = false;
			while (!isWeightValid && height > 0) {
				System.out
						.println("Please press '1' to pass body weight in pounds or '2' to provide in kilograms");
				int weightInput = scn.nextInt();
				switch (weightInput) {
				case 1:
					System.out.println("Now provide the body weight in pounds");
					inPounds = true;
					isWeightValid = true;
					weight = scn.nextDouble() * 0.453592;
					break;
				case 2:
					System.out
							.println("Now provide the body weight in kilograms");
					isWeightValid = true;
					weight = scn.nextDouble();
					break;
				default:
					System.out.println("Invalid option");
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid weight input " + e);
		}
	}

	public static void getHeight() {

		try {
			boolean isHeightValid = false;
			while (!isHeightValid) {
				System.out
						.println("Please press '1' to pass body height in feet or '2' to provide in meters");
				int heightInput = scn.nextInt();
				switch (heightInput) {
				case 1:
					System.out.println("Now provide the body height in feet");
					inFeet = true;
					height = scn.nextDouble() * 0.3048;
					isHeightValid = true;
					break;
				case 2:
					System.out.println("Now provide the body height in meters");
					height = scn.nextDouble();
					isHeightValid = true;
					break;
				default:
					System.out.println("Invalid option");
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid height input " + e);
		}
	}
}
