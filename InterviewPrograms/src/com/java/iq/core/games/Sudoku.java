package com.java.iq.core.games;

import java.util.Random;
import java.util.Scanner;

/**
 * Java program for Sudoku
 * 
 * @author SrikarRao
 *
 */
public class Sudoku {

	private static Scanner scn = new Scanner(System.in);
	private static int count = 0;

	public static void main(String[] args) {
		beginGame();
	}

	private static void beginGame() {
		try {
			System.out.println("Enter the number of rows-columns");
			int numOfRows = scn.nextInt();

			System.out.println("Enter the number of columns");
			int numOfColumns = scn.nextInt();

			if (numOfColumns == numOfRows) {
				int[][] sudokuList = new int[numOfRows][numOfColumns];

				for (int i = 0; i < numOfRows; i++)
					for (int j = 0; j < numOfColumns; j++) {
						sudokuList[i][j] = 0;
					}
				addNumberstoSFrame(sudokuList);
				displaySudoku(sudokuList);
				insertNumbers(sudokuList);
			} else
				System.out
						.println("The rows and columns should be equal in Sudoku. Please enter equal numbers for rows and columns");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void insertNumbers(int[][] sudokuList) {
		int value = 0;
		int rowNum = 0;
		int colNum = 0;
		count++;
		try {
			if (!isSudokuCompleted(sudokuList)) {
				System.out.println("Enter the row number");
				rowNum = scn.nextInt();

				System.out.println("Enter the column number");
				colNum = scn.nextInt();

				if (rowNum < sudokuList.length && colNum < sudokuList.length) {
					System.out.println("Enter the value");
					value = scn.nextInt();
					if (value > 0 && value <= sudokuList.length) {
						if (checkIfUniqueRow(value, sudokuList, rowNum)
								&& checkIfUniqueCol(value, sudokuList, colNum)) {
							sudokuList[rowNum][colNum] = value;
							displaySudoku(sudokuList);
						} else {
							System.out.println("Value Already Exists Inside!");
							displaySudoku(sudokuList);
						}
					} else {
						System.out.println("Enter Value between 1 - "
								+ sudokuList.length);
						displaySudoku(sudokuList);
					}
				} else {
					System.out.println("Enter the row and column numbers <= "
							+ sudokuList.length);
				}
				insertNumbers(sudokuList);
			} else {
				System.out.println("Congrats!! You won the Sudoku in " + count
						+ "takes!");
				displaySudoku(sudokuList);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static boolean isSudokuCompleted(int[][] sudokuList) {
		for (int i = 0; i < sudokuList.length; i++)
			for (int j = 0; j < sudokuList.length; j++)
				if (sudokuList[i][j] == 0) {
					return false;
				}
		return true;
	}

	public static boolean checkIfUniqueRow(int value, int[][] sudokuList, int x) {
		for (int i = x; i <= x; i++) {
			for (int j = 0; j < sudokuList.length; j++) {
				if (sudokuList[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean checkIfUniqueCol(int value, int[][] sudokuList, int y) {
		for (int i = y; i <= y; i++) {
			for (int j = 0; j < sudokuList.length; j++) {
				if (sudokuList[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}

	public static void addNumberstoSFrame(int[][] sudokuList) {
		Random randomGenerator = new Random();
		int x = 0;
		for (int i = 0; i < sudokuList.length + 2; i++) {
			int rowInt = randomGenerator.nextInt(sudokuList.length);
			int columnInt = randomGenerator.nextInt(sudokuList.length);
			if (sudokuList[rowInt][columnInt] == 0) {
				x = randomGenerator.nextInt(sudokuList.length);
				if (checkIfUniqueRow(x, sudokuList, rowInt)
						&& checkIfUniqueCol(x, sudokuList, columnInt)) {
					sudokuList[rowInt][columnInt] = x;
				}
			}
		}
	}

	public static void displaySudoku(int[][] sudokuList) {
		for (int i = 0; i < sudokuList.length; i++) {
			for (int j = 0; j < sudokuList.length; j++) {
				System.out.print(sudokuList[i][j] + " ");
			}
			System.out.println();
		}
	}
}