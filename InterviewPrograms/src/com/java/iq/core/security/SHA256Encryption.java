package com.java.iq.core.security;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class SHA256Encryption {

	public static void main(String[] args) {
		String data = "HelloWorld";
		System.out.println("Before encryption: " + data);
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] b = digest.digest(data.getBytes("UTF-8"));
			String hash = DatatypeConverter.printHexBinary(b);
			System.out.println("After encryption: " + hash.toLowerCase());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}