package com.java.iq.core.companies.guidewire;

public class MovieTicketSeatArrangement {

	public static void main(String[] args) {
		System.out.println(new MovieTicketSeatArrangement().solution(2, ""));
		System.out.println(new MovieTicketSeatArrangement().solution(2, " "));
		System.out.println(new MovieTicketSeatArrangement().solution(2, null));
		System.out.println(new MovieTicketSeatArrangement().solution(3, "1A 2F 1C 3D"));
		System.out.println(new MovieTicketSeatArrangement().solution(3, "1A 2F 1C 3D 3G"));
		System.out.println(new MovieTicketSeatArrangement().solution(3, "1D 2D 3D"));
		System.out.println(new MovieTicketSeatArrangement().solution(2, "1A 2F 1C"));
	}

	public int solution(int N, String S) {

		final int seatsInEachRow = 10;
		int rows = N;
		boolean[][] seatMap = new boolean[rows][seatsInEachRow];

		if (S == null || S.trim().isEmpty() || S.trim().isEmpty()) {
			return rows * 3;
		}

		String[] seats = S.trim().split("\\s+");

		for (String seat : seats) {
			if (!seat.isEmpty() && isBlank(seat) && (seat.length() > 1)) {

				int[] rowCol = findRowCol(seat);
				if (rowCol[0] != -1 && rowCol[0] < N && rowCol[1] != -1 && rowCol[1] < 10) {
					seatMap[rowCol[0]][rowCol[1]] = true;
				}
			}
		}

		int totalUnreservedSeatCount = 0;
		for (int i = 0; i < N; i++) {
			boolean firstReserved = false;
			boolean middleReserved = false;
			boolean lastReserved = false;
			int reservedSeatCount = 0;
			int middleReservedCounter = 0;
			for (int j = 0; j < 10; j++) {
				boolean isReserved = seatMap[i][j];
				if (isReserved) {

					if (j < 3) {
						firstReserved = true;
					}

					if (j >= 3 && j < 7) {
						if (j == 4 || j == 5) {
							middleReserved = true;
						} else {
							middleReservedCounter++;
						}
					}

					if (j > 7) {
						lastReserved = true;
					}
				}
			}

			if (firstReserved) {
				reservedSeatCount++;
			}

			if (middleReserved || middleReservedCounter > 1) {
				reservedSeatCount++;
			}

			if (lastReserved) {
				reservedSeatCount++;
			}
			totalUnreservedSeatCount += (3 - reservedSeatCount);
		}
		return totalUnreservedSeatCount;
	}

	private int[] findRowCol(String seat) {

		int[] rowCol = new int[2];
		int rowNumber = 0;
		int colNumber = 0;

		char[] cArray = seat.toCharArray();
		int i = 0;
		while (i < cArray.length) {
			int x = cArray[i] - '0';
			if (x < 0 || x > 9) {
				break;
			}

			rowNumber = rowNumber * 10 + x;
			i++;
		}

		int y = cArray[i] - 'A';

		if (y >= 0 && y <= 10) {

			if (y > 7) {
				if (y == 8) {
					y = -1;
				} else {
					y = y - 1;
				}
			}
			colNumber = y;
		}

		rowCol[0] = rowNumber - 1;
		rowCol[1] = colNumber;

		return rowCol;
	}

	private boolean isBlank(String s) {
		int i = 0;
		while (i < s.length() && s.charAt(i) != ' ') {
			i++;
		}
		return i == s.length();
	}
}