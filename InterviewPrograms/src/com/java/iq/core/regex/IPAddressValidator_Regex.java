package com.java.iq.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JAVA program to validate ipaddress using regular expression
 * 
 * @author SrikarRao
 *
 */
public class IPAddressValidator_Regex {
	private Pattern pattern;
	private Matcher matcher;

	// Regular Expression for IP Address
	private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	public IPAddressValidator_Regex() {
		pattern = Pattern.compile(IPADDRESS_PATTERN);
	}

	/**
	 * Validate ip address with regular expression
	 * 
	 * @param ip
	 *            ip address for validation
	 * @return true valid ip address, false invalid ip address
	 */
	public boolean validate(final String ip) {
		matcher = pattern.matcher(ip);
		return matcher.matches();
	}
}