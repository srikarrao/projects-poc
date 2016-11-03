package com.srikar.collections.stack;

import java.util.Stack;

public class StackImpl {
	   public static void main(String[] args) {
		   Stack stack = new Stack(); 
		   System.out.println(stack.isEmpty());
		   stack.add(11);
		   stack.add(22);
		   stack.add(-1);
		   stack.add(99);
	      System.out.println(stack);
	      stack.remove(1);
	      System.out.println(stack);
	   }
	}