package com.effectivejava.staticfactorymethods;

public final class StaticFactoryMethodImpl {
	public int reqValue1;
	public String type;
	public StaticFactoryMethodImpl(int x){
		
	}
	public StaticFactoryMethodImpl(int reqValue1, String type) {
		this.reqValue1 = reqValue1;
		this.type = type;
	}

	public static int getSum(int opt1) {
		return new ValuesForClient().getSum(10, opt1);
	}

	public static int getDiff(int opt1) {
		return new ValuesForClient().getDiff(1000, opt1);
	}
	
	public int peformCalculation(int y){
		return new ValuesForClient().getCalculatedValue(reqValue1, y, type);
	}

}
