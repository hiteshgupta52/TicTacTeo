package com.bnp.tictacteo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bnp.constants.Result;

public class TicTacToe {

	private List<List<Integer>> winningPositions = null;

	public TicTacToe() {
		winningPositions = new ArrayList<List<Integer>>();
		winningPositions.add(Arrays.asList(1, 2, 3));
		winningPositions.add(Arrays.asList(4, 5, 6));
		winningPositions.add(Arrays.asList(7, 8, 9));
		winningPositions.add(Arrays.asList(1, 4, 7));
		winningPositions.add(Arrays.asList(2, 5, 8));
		winningPositions.add(Arrays.asList(3, 6, 9));
		winningPositions.add(Arrays.asList(3, 5, 7));
		winningPositions.add(Arrays.asList(1, 5, 9));
	}

	private List<Integer> moveXs = new ArrayList<Integer>();
	private List<Integer> moveOs = new ArrayList<Integer>();

	public Result playX(final int i) {
		return play(i, moveXs);
	}

	public Result playO(final int i) {
		return play(i, moveOs);
	}

	private Result play(final int i, List<Integer> myMoves) {
		Result result = null;
		if (isLegalMove(i)) {
			myMoves.add(i);
			result = isFinished(moveXs);
		} else {
			result = Result.ILLEGAL;
		}
		return result;
	}

	private Result isFinished(List<Integer> myMoves) {
		for (List<Integer> pos : winningPositions) {
			if (hasValidPattern(myMoves, pos)) {
				return Result.WIN;
			}
		}

		if (moveXs.size() + moveOs.size() == 9) {
			return Result.DRAW;
		}
		return Result.NEXT;
	}

	private boolean hasValidPattern(List<Integer> moves, List<Integer> validPattern) {
		return moves.containsAll(validPattern);
	}

	private boolean isLegalMove(int i) {
		if(i < 1 || i > 9) {
			return false;
		}
		for (int move : moveXs) {
			if (move == i)
				return false;
		}
		for (int move : moveOs) {
			if (move == i)
				return false;
		}
		return true;
	}

	public void print() {
		String[] data = new String[9];
		for (int i = 0; i < 9; i++) {
			data[i] = "-";
		}

		for (int move : moveXs) {
			data[move - 1] = "X";
		}
		for (int move : moveOs) {
			data[move - 1] = "O";
		}

		System.out.println("----------------------------");
		for (int i = 0; i < 9;) {
			System.out.println(data[i++] + " | " + data[i++] + " | " + data[i++]);
		}
		System.out.println("----------------------------");
	}
}
