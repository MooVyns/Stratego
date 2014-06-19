package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import stratego.Camp;
import stratego.Piece;
import stratego.TypePiece;

public class PieceTest {

	@Test
	public void test() {
		Piece piece = new Piece(TypePiece.Capitaine, Camp.Sud);
	}

}