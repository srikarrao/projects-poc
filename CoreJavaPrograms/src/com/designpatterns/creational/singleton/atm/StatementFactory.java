package com.designpatterns.creational.singleton.atm;

public class StatementFactory extends Factory {

	private static StatementFactory uniqueInstance;

	private StatementFactory() {
	}

	public static StatementFactory getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new StatementFactory();
			System.out.println("Creating a new StatementFactory instance");
		}
		return uniqueInstance;
	}

	public StatementType createStatements(String selection) {
		if (selection.equalsIgnoreCase("detailedStmt")) {
			return new DetailedStatement();
		} else if (selection.equalsIgnoreCase("miniStmt")) {
			return new MiniStatement();
		}
		throw new IllegalArgumentException("Selection doesnot exist");
	}
}