package com.java.iq.core.companies.turo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CarDataCache {

	private static final int CAPACITY = 2;
	private final Map<String, CarData> vinToCarData;
	private final Queue<String> lruCarData;
	private final DoublyLinkedList dllLruCarData;

	public CarDataCache() {
		this.vinToCarData = new HashMap<>(CAPACITY);
		this.lruCarData = new LinkedList<>();
		this.dllLruCarData = new DoublyLinkedList();
	}

	public void put(String vin, CarData carData) {

		CarData prevCarData = vinToCarData.get(vin);

		if (prevCarData != null) {
			lruCarData.remove(prevCarData.vin);
		} else {
			if (vinToCarData.size() == CAPACITY) {
				String expiredVin = lruCarData.remove();
				vinToCarData.remove(expiredVin);
			}

		}
		vinToCarData.put(vin, carData);
		lruCarData.add(vin);
	}

	public boolean remove(String vin) {
		CarData carData = vinToCarData.remove(vin);
		if (carData != null) {
			lruCarData.remove(carData.vin);
			return true;
		}
		return false;
	}

	public CarData get(String vin) {
		CarData prevCarData = vinToCarData.get(vin);

		if (prevCarData != null) {
			lruCarData.remove(prevCarData.vin);
			lruCarData.add(prevCarData.vin);
		}

		return prevCarData;
	}

	public void print() {

		lruCarData.forEach(node -> {
			System.out.print(node + "->");
		});

		System.out.println("X");

		vinToCarData.forEach((K, V) -> {
			System.out.print(V);
		});

		System.out.println();
	}

	public static void main(String[] args) {
		CarDataCache cache = new CarDataCache();
		cache.put("VAADR17891022KL", new CarData("VAADR17891022KL"));
		cache.print();
		cache.get("VAADR17891022KL");
		cache.print();

		System.out.println("-------------------------");

		cache.put("AZADR178CDDL83", new CarData("AZADR178CDDL83"));
		cache.print();
		cache.get("AZADR178CDDL83");
		cache.print();

		System.out.println("-------------------------");

		cache.put("CAZDR178M5167", new CarData("CAZDR178M5167"));
		cache.print();
		cache.get("CAZDR178M5167");
		cache.print();
	}

	static class CarData {

		static int offset = 1;
		String vin;
		String model;

		@Override
		public String toString() {
			return "CarData [vin=" + vin + ", model=" + model + "]";
		}

		public CarData(String vin) {
			this.vin = vin;
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
			Node curr;
			String data;
		}

		public void insert(String data) {
			size++;
		}

		public Node get() {
			return head;
		}

		public Node remove(Node node) {

			if (head != null) {
				size--;
			}

			return node;
		}
	}
}