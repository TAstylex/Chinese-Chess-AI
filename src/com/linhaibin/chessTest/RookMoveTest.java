package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.KnightPiece;
import com.linhaibin.chess.RookPiece;
import com.linhaibin.chess.State;
import com.linhaibin.chess.UserMove;

public class RookMoveTest {

	private State state;
	private RookPiece rookPiece;
	@Before
	public void setUp() throws Exception {
		state = new State();
		rookPiece = new RookPiece(23);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGenerateAllSimple() {
		int fromX = 0;
		int fromY = 9;
		List<State> newStateList = rookPiece.generateAllMove(state, fromX, fromY);
		assertEquals(newStateList.size(), 2);
	}

	@Test
	public void testGenerateNumberAllMid() {
		int fromX = 0;
		int fromY = 9;
		int toX = 0;
		int toY = 8;
		
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		List<State> newStateList = rookPiece.generateAllMove(midState, toX, toY);
		assertEquals(newStateList.size(), 10);
	}

	@Test
	public void testLegalMove() {
		int fromX = 0;
		int fromY = 0;
		int toX = 0;
		int toY = 2;
		
		assertEquals(true,rookPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	@Test
	public void testIllegalMoveSuicide() {
		int fromX = 0;
		int fromY = 0;
		int toX = 0;
		int toY = 3;
		
		assertEquals(false,rookPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	
	@Test
	public void testIllegalMoveAcross() {
		int fromX = 0;
		int fromY = 0;
		int toX = 1;
		int toY = 1;
		
		assertEquals(false,rookPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	@Test
	public void testLegalMoveWithObstacle() {
		int fromX = 0;
		int fromY = 0;
		int toX = 0;
		int toY = 4;
		
		assertEquals(false,rookPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
}