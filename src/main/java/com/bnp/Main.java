package com.bnp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bnp.constants.Result;
import com.bnp.tictacteo.TicTacToe;

public class Main {

	private final static String USERX = "user x";
	private final static String USERO = "user o";

	private static TicTacToe game = new TicTacToe();

	public static void main(String[] args) throws IOException {
		Result result = null;

		while (Result.WIN != result && Result.DRAW != result) {
			do {
				result = game.playX(readData(USERX));
				game.print();
			} while (Result.ILLEGAL == result);

			if (Result.NEXT == result) {
				do {
					result = game.playO(readData(USERO));
					game.print();
				} while (Result.ILLEGAL == result);
			}
		}
		
		if(Result.WIN == result) {
			System.out.println("Win");
		} else if(Result.DRAW == result) {
			System.out.println("Draw");
		}
	}

	private static int readData(final String user) throws IOException {
		System.out.println(user + " turn [1-9]:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String data = reader.readLine();

		try {
			Integer value = Integer.valueOf(data);
			if(value > 0 && value < 10) {
				return value;
			} else {
				System.err.println("Please enter valid value. Valid values are [1-9]");
				return readData(user);
			}
		} catch (Exception e) {
			System.err.println("Please enter valid value. Valid values are [1-9]");
			return readData(user);
		}
	}

}
