package com.srikar.collections.arraylists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraylistImpl3_Sorting {

	public static void main(String[] args) {
		 List<String> listofcountries = new ArrayList<String>();
		   listofcountries.add("India");
		   listofcountries.add("US");
		   listofcountries.add("China");
		   listofcountries.add("Denmark");

		   /*Unsorted List*/
		   System.out.println("Before Sorting:");
		   for(String counter: listofcountries){
				System.out.println(counter);
			}

		   /* Sort statement and reverse the order*/
		   Collections.sort(listofcountries,Collections.reverseOrder());
		   
		   /* Sorted List*/
		   System.out.println("After Sorting:");
		   for(String counter: listofcountries){
				System.out.println(counter);
			}
		}
	}
