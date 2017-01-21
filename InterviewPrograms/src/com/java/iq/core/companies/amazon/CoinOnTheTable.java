package com.java.iq.core.companies.amazon;

import java.util.Scanner;

public class CoinOnTheTable {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int M = scn.nextInt();
		int K = scn.nextInt();
		int a = 0, b = 0;
		char arr[][] = new char[N][];

		for (int i = 0; i < N; i++) {
			arr[i] = scn.next().toCharArray();
			for (int j = 0; j < M; j++)
				if (arr[i][j] == '*') {
					a = i;
					b = j;
				}
		}

		int tempArr[][][] = new int[K + 1][N][M];
		int res = 1 << 29;
		for (int k = 0; k <= K; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					if (k == 0)
						tempArr[k][i][j] = i == 0 && j == 0 ? 0 : 1 << 29;
					else {
						int temp = 1 << 29;
						if (i > 0)
							temp = Math.min(temp, tempArr[k - 1][i - 1][j]
									+ (arr[i - 1][j] == 'D' ? 0 : 1));
						if (i < N - 1)
							temp = Math.min(temp, tempArr[k - 1][i + 1][j]
									+ (arr[i + 1][j] == 'U' ? 0 : 1));
						if (j > 0)
							temp = Math.min(temp, tempArr[k - 1][i][j - 1]
									+ (arr[i][j - 1] == 'R' ? 0 : 1));
						if (j < M - 1)
							temp = Math.min(temp, tempArr[k - 1][i][j + 1]
									+ (arr[i][j + 1] == 'L' ? 0 : 1));

						tempArr[k][i][j] = temp;
					}

		scn.close();
		for (int k = 0; k <= K; k++)
			res = Math.min(res, tempArr[k][a][b]);

		if (res < (1 << 29)) {
			System.out.println(res);
		} else {
			System.out.println(-1);
		}
	}
	
}