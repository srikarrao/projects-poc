package com.effectivejava.staticfactorymethods;

public class ValuesForClient {

	public int getSum(int v1, int v2) {
		return v1 + v2;
	}

	public int getDiff(int v1, int v2) {
		return v1 - v2;
	}

	public int getCalculatedValue(int v1, int v2, String operationType) {
		if (operationType == "add") {
			return getSum(v1, v2);
		} else if (operationType == "subtract") {
			return getDiff(v1, v2);
		} else {
			System.out.println("No operation performed");
			return 0;
		}
	}
}
