package com.java.iq.core.companies.turo;

import java.util.HashMap;
import java.util.Map;

import com.java.iq.core.companies.turo.CarDataCache.DoublyLinkedList.Node;

public class CarDataCache {

	private static final int CAPACITY = 2;
	private final Map<String, CarData> vinToCarData;
	private final DoublyLinkedList lruCarData;

	public CarDataCache() {
		this.vinToCarData = new HashMap<>(CAPACITY);
		this.lruCarData = new DoublyLinkedList();
	}

	public void put(String vin, CarData carData) {

		CarData prevCarDataNode = vinToCarData.get(vin);

		if (prevCarDataNode != null) {
			lruCarData.remove(prevCarDataNode.vinNode);
		} else {
			if (vinToCarData.size() == CAPACITY) {
				Node expiredCarDataNode = lruCarData.remove();
				vinToCarData.remove(expiredCarDataNode.data);
			}

		}
		vinToCarData.put(vin, carData);
		lruCarData.insert(carData.vinNode);
	}

	public boolean remove(String vin) {
		CarData carData = vinToCarData.remove(vin);
		if (carData != null) {
			lruCarData.remove(carData.vinNode);
			return true;
		}
		return false;
	}

	public CarData get(String vin) {
		CarData prevCarData = vinToCarData.get(vin);

		if (prevCarData != null) {
			lruCarData.remove(prevCarData.vinNode);
			lruCarData.insert(prevCarData.vinNode);
		}

		return prevCarData;
	}

	public void print() {

		lruCarData.print();
		vinToCarData.forEach((K, V) -> {
			System.out.print(V);
		});

		System.out.println();
	}

	public static void main(String[] args) {
		CarDataCache cache = new CarDataCache();
		cache.put("VAADR17891022KL", new CarData("VAADR17891022KL"));
		cache.print();

		System.out.println("-------------------------");

		cache.put("AZADR178CDDL83", new CarData("AZADR178CDDL83"));
		cache.print();
		cache.get("VAADR17891022KL");
		cache.print();

		System.out.println("-------------------------");

		cache.put("CAZDR178M5167", new CarData("CAZDR178M5167"));
		cache.print();
		// cache.get("CAZDR178M5167");
		// cache.print();
	}

	static class CarData {

		static int offset = 1;
		String vin;
		String model;
		DoublyLinkedList.Node vinNode;

		@Override
		public String toString() {
			return "CarData [vin=" + vin + ", model=" + model + "]";
		}

		public CarData(String vin) {
			this.vin = vin;
			this.vinNode = new DoublyLinkedList.Node(this.vin);
			this.model = "Model-" + offset;
			offset++;
		}
	}

	static class DoublyLinkedList {

		Node head;
		Node tail;
		int size = 0;

		static class Node {
			Node prev;
			Node next;
			String data;

			public Node(String data) {
				this.data = data;
			}
		}

		public void insert(Node node) {

			if (tail == null) {
				head = tail = node;
			} else {
				node.prev = tail;
				tail.next = node;
				tail = node;
			}
			size++;
		}

		public Node get() {
			return head;
		}

		public Node remove() {

			if (head == null) {
				return head;
			}

			Node temp = head;
			head = head.next;
			head.prev = null;
			temp.next = null; // to avoid memory leaks
			size--;
			return temp;
		}

		public boolean remove(Node node) {

			if (head == null || node == null) {
				return false;
			}

			if (node.prev != null) {
				node.prev.next = node.next;
				node.prev = null;
			} else {
				head = node.next;
			}

			if (node.next != null) {
				node.next.prev = node.prev;
				node.next = null;
			} else {
				tail = node.prev;
			}

			size--;
			return true;
		}

		public void print() {
			Node temp = head;
			System.out.print("X");
			while (temp != null) {
				System.out.print("<--" + temp.data + "-->");
				temp = temp.next;
			}
			System.out.println("X");
		}
	}
}