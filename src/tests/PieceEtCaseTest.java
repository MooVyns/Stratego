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
		Case c = new Case(Camp.Nord,"A2");
		c.setPiece(piece);
		
		//TEST COORDONNEES
		System.out.println("TEST COORDONNEES");
		assertEquals(c.getCoordonnees(), "A2");
		assertEquals(piece.getCoordonnees(), c.getCoordonnees());		
		
		//TEST CAMP
		System.out.println("TEST CAMP");		
		
		//TEST TYPEPIECE
		System.out.println("TEST TYPEPIECE");
	}

}
