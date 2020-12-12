package com.bnp.tictacteo;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bnp.constants.Result;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TicTacToeTest {
	TicTacToe game;

	@Before
	public void setUp() {
		game = new TicTacToe();
	}

	@Test
	public void testLegalMove() {
		Result result = game.playX(1);
		assertTrue(Result.NEXT == result);
	}

	@Test
	public void testIllegalMove() {
		game.playX(1);

		Result result = game.playO(1);
		assertTrue(Result.ILLEGAL == result);
	}

	@Test
	public void testIllegalMove1() {
		Result result = game.playX(0);
		assertTrue(Result.ILLEGAL == result);
	}

	@Test
	public void testIllegalMove2() {
		Result result = game.playO(111);
		assertTrue(Result.ILLEGAL == result);
	}

	@Test
	public void testWin() {
		game.playX(1);
		game.playO(4);
		game.playX(2);
		game.playO(5);

		Result result = game.playX(3);
		assertTrue(Result.WIN == result);
	}

	@Test
	public void testDraw() {
		game.playX(1);
		game.playO(2);
		game.playX(3);
		game.playO(5);
		game.playX(4);
		game.playO(6);
		game.playX(8);
		game.playO(7);

		Result result = game.playX(9);
		assertTrue(Result.DRAW == result);
	}
}
