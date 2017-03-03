package com.javapuzzles.otherexamples;

/**
 * 
 * @author SrikarRao Topic: narrowing, widening primitive typing Refer Multicast
 *         program
 *
 */
public class PrimitiveTyping {

	public static void main(String[] args) {
		byte b = -1;
		char c = 'A';
		int g = '?';
		
		
		char z = '\uffff';

		int i = c; 

		System.out.println(c); // A
		System.out.println(i); // 65 // sign extension not performed
		System.out.println(c & 0xfff); // 65 // sign extension performed
		System.out.println((short) c); // 65 // cast causes sign extension
		System.out.println(b & 0xff); // 255
		System.out.println((char) (b & 0xff)); // ÿ // // byte to char (no sign extension)
		System.out.println((char) b); // ? // sign extension is performed
		System.out.println(z); // ? // might be wrong
		System.out.println(g); // 63
		System.out.println((int) z); // 65535

	}

}
