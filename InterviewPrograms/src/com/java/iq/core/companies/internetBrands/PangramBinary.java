package com.java.iq.core.companies.internetBrands;

/**
 * Pangram to return result as binary string 
 * @author SrikarRao
 *
 */
public class PangramBinary {

public static void main(String[] args){

	String[] arr = new String[4];
	arr[0] = "we promplty judged antique ivory buckles for the next prize";
	arr[1] = "we promplty judged antique ivory buckles for the prizes";
	arr[2] = "the quick brown fox jumps over the lazy dog";
	arr[3] = "the quick brown fox jump over the lazy dog";
	System.out.print(isPanagram(arr));
}
private static String isPanagram(String[] s) {
	
	StringBuilder sb = new StringBuilder();
	for(int i=0;i<s.length;i++){
	String res = isPanagram(s[i]);
	sb.append(res);
	}
	return sb.toString();
}
	/**
	 * method to return if the given string is "pangram" or "non-pangram"
	 * 
	 * @param s
	 * @return
	 */
	private static String isPanagram(String s) {

		
		boolean[] isCharArray = new boolean[26];
		int count = 0;
		for (int i = 0; i < s.length(); i++) {

			if (count == 26) {
				return "1";
			}
			char character = s.charAt(i);
			int val = (character >= 'a' && character <= 'z' ? character - 'a'
					: (character >= 'A' && character <= 'Z' ? character - 'A'
							: -1));
			if (val >= 0) {
				if (!isCharArray[val]) {
					isCharArray[val] = true;
					count++;
				}
			}
		}

		return count == 26 ? "1" : "0";
	}
}