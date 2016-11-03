package com.designpatterns.creational.singleton.atm;

public class MiniStatement implements StatementType {

	@Override
	public String print() {
		System.out.println("Mini Statement Created");
		return "miniStmt";
	}
}