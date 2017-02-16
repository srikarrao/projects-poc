package com.java.iq.core.companies.zynga;

public class HourMinDegree {

	public static void main(String[] args) {

		System.out.println(calcAngle(9, 60));
		System.out.println(calcAngle(3, 30));
	}

	private static int calcAngle(int h, int m) {
		if (h < 0 || m < 0 || h > 12 || m > 60)
			System.out.println("Wrong input");

		if (h == 12)
			h = 0;
		if (m == 60)
			m = 0;

		// Calculate the angles moved by hour and minute hands
		// with reference to 12:00
		int hour_angle = (h * 60 + m) / 2;
		int minute_angle = 6 * m;

		// Find the difference between two angles
		int angle = Math.abs(hour_angle - minute_angle);

		// Return the smaller angle of two possible angles
		angle = Math.min(360 - angle, angle);

		return angle;
	}
}
