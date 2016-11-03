package com.core.java.oops.inheriteance;

public class ChildClass implements ParentInterface {

	public static void main(String[] args) {

		ParentInterface child = new ChildClass();
		child.print();
		ChildClass child2 = (ChildClass) child;
		child2.printChild();
	}

	@Override
	public void print() {
		System.out.println("Inside Print!!");
	}

	public void printChild() {
		System.out.println("Inside Print Child!!");
	}
}
