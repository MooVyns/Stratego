package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import stratego.Camp;
import stratego.Case;
import stratego.Piece;
import stratego.TypePiece;

public class PieceEtCaseTest {

	@Test
	public void test() {
		Piece piece = new Piece(TypePiece.Drapeau,Camp.Nord);
		Case c = new Case("A2",Camp.Nord);
		c.setPiece(piece);
		
		//TEST COORDONNEES
		assertEquals(c.getCoordonnees(), "A2");
		assertEquals(piece.getCoordonnees(), c.getCoordonnees());		
		
		//TEST CAMP
	
		
		//TEST TYPEPIECE
		
	}

}
