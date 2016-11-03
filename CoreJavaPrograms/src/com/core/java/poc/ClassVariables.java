package com.core.java.poc;

public class ClassVariables {
	public static int numberOfItems = 0;
	public int x = 1;

	public static void main(String[] args) {
		ClassVariables cv1 = new ClassVariables();
		ClassVariables cv2 = new ClassVariables();

		cv1.displayNumberOfItems();
		cv2.displayNumberOfItems();
		
		Next n = new Next();
		n.display();
	}

	public void displayNumberOfItems() {
		numberOfItems += 1;
		System.out.println(numberOfItems);
	}

}

class Next {
public void display(){
	System.out.println(new ClassVariables().x);
}
}
