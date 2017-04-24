package com.java.iq.core.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * <p>
 * Source: http://www.geeksforgeeks.org/snake-ladder-problem-2/ <br>
 * Time Complexity: O (N) <br>
 * Space Complexity: O (N) <br>
 * </p>
 * 
 * @author srikarrao.gandla
 *
 */
public class SnakesAndLadders {

	private static final int BOARD_SIZE = 30;

	static class MoveEntry {
		int vertice;
		int distance;

		MoveEntry() {
			this.vertice = 0;
			this.distance = 0;
		}
	}

	private static int getMinDiceThrows(int move[], int D) {
		boolean[] visited = new boolean[D];
		Queue<MoveEntry> movesQueue = new LinkedList<MoveEntry>();

		visited[0] = true;
		movesQueue.add(new MoveEntry());
		MoveEntry res = new MoveEntry();
		while (!movesQueue.isEmpty()) {
			res = movesQueue.peek();
			int v = res.vertice;

			if (v == D - 1)
				break;

			movesQueue.remove();

			for (int j = v + 1; j <= (v + 6) && j < D; ++j) {
				if (!visited[j]) {
					MoveEntry temp = new MoveEntry();
					temp.distance = (res.distance + 1);
					visited[j] = true;

					if (move[j] != -1)
						temp.vertice = move[j];
					else
						temp.vertice = j;
					movesQueue.add(temp);
				}
			}
		}

		return res.distance;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the destination vertice: ");
		int dest = scn.nextInt();
		int[] moves = new int[BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 10;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		System.out.println("Minimum dice throws required is " + getMinDiceThrows(moves, dest));
	}
}