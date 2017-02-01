package com.java.iq.core.companies.uber;

import java.util.*;
import java.util.Map.Entry;

public class ElementsExpiration {

	Timer exprTimer;
	private static long EXPIRED_TIME_IN_SEC = 1l;
	private static Map<Double, ArrayList<Date>> exprMap = new HashMap<>();

	public static void main(String args[]) {
		new ElementsExpiration(1);
		log("Start Adding element every second\n\n");
	}

	public ElementsExpiration(int seconds) {
		exprTimer = new Timer();
		exprTimer.schedule(new exprReminder(), 0, seconds * 1000);
	}

	class exprReminder extends TimerTask {
		public void run() {
			exprClearExipredElementsFromMap(exprMap);
			addElement();
		}
	}

	public void addElement() {
		exprAddElementToMap(Math.random(), exprMap);
	}

	// Check for element's expired time. If element is > 5 seconds old then
	// remove it
	private static void exprClearExipredElementsFromMap(
			Map<Double, ArrayList<Date>> map) {
		Date currentTime = new Date();
		Date actualExpiredTime = new Date();

		// if element time stamp and current time stamp difference is 1 second
		// then delete element
		actualExpiredTime.setTime(currentTime.getTime() - EXPIRED_TIME_IN_SEC
				* 1000l);
		System.out.println("exprMap size:" + map.size());

		Iterator<Entry<Double, ArrayList<Date>>> exprIterator = map.entrySet()
				.iterator();
		while (exprIterator.hasNext()) {
			Entry<Double, ArrayList<Date>> entry = exprIterator.next();
			ArrayList<Date> exprElement = entry.getValue();

			while (exprElement.size() > 0
					&& exprElement.get(0).compareTo(actualExpiredTime) < 0) {
				log("----------- Element Deleted: " + entry.getKey());
				exprElement.remove(0);
			}

			if (exprElement.size() == 0) {
				exprIterator.remove();
			}
		}
	}

	// Adding new element to map with current timestamp
	private static void exprAddElementToMap(Double digit,
			Map<Double, ArrayList<Date>> myMap) {
		ArrayList<Date> exprList = new ArrayList<>();
		myMap.put(digit, exprList);
		exprList.add(new Date());
		log("+++++++++++ Element added:" + digit + "\n");
	}

	private static void log(String string) {
		System.out.println(string);

	}
}