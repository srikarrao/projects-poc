package com.java.iq.core.bst;

public class Node<T> {
	public T data;
	public Node<T> left, right;

	public Node(T data) {
		this.data = data;
		left = right = null;
	}
	
}