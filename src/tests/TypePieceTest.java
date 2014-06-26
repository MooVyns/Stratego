package tests;

import static org.junit.Assert.*;
import stratego.TypePiece;

import org.junit.Test;

public class TypePieceTest {

	@Test
	public void test() {
		//TEST GetTypePiece
		assertEquals(TypePiece.getTypePiece("O"),TypePiece.Bombe);		
		assertEquals(TypePiece.getTypePiece("X"),TypePiece.Drapeau);	
		assertEquals(TypePiece.getTypePiece("A"),TypePiece.Maréchal);	
		assertEquals(TypePiece.getTypePiece("F"),TypePiece.Lieutenant);
		assertEquals(TypePiece.getTypePiece("W"),null);
		
		//TEST getDeplacementMax
		assertEquals(TypePiece.Bombe.getDeplacementMax(),0);
		assertEquals(TypePiece.Maréchal.getDeplacementMax(),1);
		assertEquals(TypePiece.Drapeau.getDeplacementMax(),0);
		
		//TEST estJouable
		assertEquals(TypePiece.Bombe.estJouable(),false);
		assertEquals(TypePiece.Maréchal.estJouable(),true);
		
		//TEST exist
		assertEquals(TypePiece.exist("Z"),false);
		assertEquals(TypePiece.exist("A"),true);
		assertEquals(TypePiece.exist("W"),false);
	}

}
