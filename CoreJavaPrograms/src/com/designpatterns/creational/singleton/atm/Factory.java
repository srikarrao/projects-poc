package com.designpatterns.creational.singleton.atm;

public abstract class Factory {

	protected abstract StatementType createStatements(String selection);

}