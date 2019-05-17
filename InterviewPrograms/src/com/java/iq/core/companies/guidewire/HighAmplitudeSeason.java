package com.java.iq.core.companies.guidewire;

public class HighAmplitudeSeason {

	public String solution(int[] T) {
		String[] seasons = new String[] { "WINTER", "SPRING", "SUMMER", "AUTUMN" };
		int numOfDays = T.length;
		int numOfSeasons = seasons.length;
		int numOfDaysPerSeason = numOfDays / numOfSeasons;

		int startDay = 0;
		int[] winterMinMax = findMinMaxTemp(T, startDay, numOfDaysPerSeason * 1);
		int winterAmplitude = winterMinMax[1] - winterMinMax[0];

		int[] springMinMax = findMinMaxTemp(T, numOfDaysPerSeason * 1, numOfDaysPerSeason * 2);
		int springAmplitude = springMinMax[1] - springMinMax[0];

		int[] summerMinMax = findMinMaxTemp(T, numOfDaysPerSeason * 2, numOfDaysPerSeason * 3);
		int summerAmplitude = summerMinMax[1] - summerMinMax[0];

		int[] autumMinMax = findMinMaxTemp(T, numOfDaysPerSeason * 3, numOfDaysPerSeason * 4);
		int autumAmplitude = autumMinMax[1] - autumMinMax[0];

		int maxAmplitude = Math.max(Math.max(winterAmplitude, springAmplitude),
				Math.max(summerAmplitude, autumAmplitude));

		if (maxAmplitude == winterAmplitude) {
			return seasons[0];
		} else if (maxAmplitude == springAmplitude) {
			return seasons[1];
		} else if (maxAmplitude == summerAmplitude) {
			return seasons[2];
		}

		// returns Autumn
		return seasons[3];
	}

	private static int[] findMinMaxTemp(int[] T, int start, int end) {
		int[] minMax = new int[2];
		int minWinterTemp = Integer.MAX_VALUE;
		int maxWinterTemp = Integer.MIN_VALUE;

		while (start < end) {
			int temp = T[start];
			minWinterTemp = Math.min(minWinterTemp, temp);
			maxWinterTemp = Math.max(maxWinterTemp, temp);
			start++;
		}
		minMax[0] = minWinterTemp;
		minMax[1] = maxWinterTemp;
		return minMax;
	}

	public static void main(String[] args) {
		System.out.println(new HighAmplitudeSeason().solution(new int[] { -3, -14, -5, 7, 8, 42, 8, 3 }));
		System.out.println(new HighAmplitudeSeason().solution(new int[] { 2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18 }));
	}
}
