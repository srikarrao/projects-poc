package com.core.java.poc;

import java.util.HashMap;

public class ImmutableKeys {

	public static void main(String[] args) {
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		/*hmap.put(1, "Hello");
			hmap.put(1, "Hello22");
			hmap.put(2, "World");
			hmap.put(3, "value");
			
			hmap.remove(2);
			System.out.println(hmap +" ; " +hmap.size());
			for(int i =0; i<=hmap.size()+1; i++){
				System.out.println(hmap.get(i));
			}*/
		/*for(int i =0; i <15; i++){
			hmap.put(i, "value" +i );
			}
		
		for(int i =0; i<hmap.size(); i++){
			System.out.println(hmap.get(i));
		}*/
		
		Integer i = 1 ;
		//i = Integer.getInteger("x");
		System.out.println(i);
		hmap.put(i, "value");
		i = i +1 ;
		System.out.println(hmap.get(1) +" : " +i);
		
		/*String x = "hello";
		HashMap<String,Integer> hmap2 = new HashMap<String, Integer>();
		hmap2.put(x, 1);
		x = x + " bye";
		System.out.println(hmap2.get(x) +" : " +x);*/
		//System.out.println(hmap.get("hello"));
	//	String y = "hello";
		//System.out.println(hmap2.get("hello"));
		 
		/*String str = "sun.arch.data.model";
		System.out.println(Integer.getInteger(str));*/
}
}