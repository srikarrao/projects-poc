package com.srikar.collections.sets;

import java.util.TreeSet;

public class TreeSetDemo {
   public static void main(String[] args) {
   // creating a TreeSet 
   TreeSet <Integer>treeadd = new TreeSet<Integer>();
     
   // adding in the tree set
   treeadd.add(1);
   treeadd.add(13);
   treeadd.add(17);
   treeadd.add(2);
     
   // rmoving 17 from the set
   System.out.println("Remove 17: "+treeadd.remove(17));      
   System.out.println("Remove 17: "+treeadd.remove(10));
   }     
}
