package com.java.iq.core.games;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

	private static char[][] board = new char[3][3];
	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			initBoard();
			displayBoard();
			playGame();
			checkScores();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void initBoard() {
		// fills up the board with blanks
		for (int r = 0; r < 3; r++)
			for (int c = 0; c < 3; c++)
				board[r][c] = ' ';
	}

	public static void displayBoard() {
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|"
				+ board[0][2]);
		System.out.println("    --+-+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|"
				+ board[1][2]);
		System.out.println("    --+-+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|"
				+ board[2][2]);
		System.out.println("     0 1 2 ");
	}

	public static void displayBoard2() {
		for (int r = 0; r < 3; r++) {
			// System.out.print("\t" + r + " ");
			for (int c = 0; c < 3; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}
		// System.out.println("\t  0 1 2 ");
	}

	public static void playGame() throws InputMismatchException {
		int row;
		int col;
		int i = 0;
		while (i < 9) {
			if (i % 2 == 0) {
				System.out.print("'O',choose your location (row, column): ");
				row = keyboard.nextInt();
				col = keyboard.nextInt();
				System.out.println("");
				if (row < 3 && col < 3) {
					if (board[row][col] == ' ') {
						board[row][col] = 'O';
						i++;
					} else {
						System.out
								.println("Location already taken, try another location");
					}
				} else {
					System.out.println("Invalid row, column number");
				}
			} else {
				System.out.print("'X',choose your location (row, column): ");
				row = keyboard.nextInt();
				col = keyboard.nextInt();
				System.out.println("");
				if (row < 3 && col < 3) {
					if (board[row][col] == ' ') {
						board[row][col] = 'X';
						i++;
					} else {
						System.out
								.println("Location already taken, try another location");
					}
				} else {
					System.out.println("Invalid row, column number");
				}
			}
			displayBoard2();
		}

	}

	public static void checkScores() {
		int xPoints = 0;
		int oPoints = 0;

		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				if (board[i][0] == 'X') {
					xPoints++;
				} else {
					oPoints++;
				}
			}
		}

		for (int j = 0; j < 3; j++) {
			if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
				if (board[0][j] == 'X') {
					xPoints++;
				} else {
					oPoints++;
				}
			}
		}

		int k = 0;
		if (board[k][k] == board[k + 1][k + 1]
				&& board[k + 1][k + 1] == board[k + 2][k + 2]) {
			if (board[0][k] == 'X') {
				xPoints++;
			} else {
				oPoints++;
			}
		}

		int l = 2;
		int m = 0;
		if (board[l][m] == board[l - 1][m + 1]
				&& board[l - 1][m + 1] == board[l - 2][m + 2]) {
			if (board[0][k] == 'X') {
				xPoints++;
			} else {
				oPoints++;
			}
		}

		if (xPoints > oPoints) {
			System.out.println("X won the game!!");
		} else if (xPoints < oPoints) {
			System.out.println("O won the game!!");
		} else {
			System.out.println("The game is a tie!");
		}
	}
}
