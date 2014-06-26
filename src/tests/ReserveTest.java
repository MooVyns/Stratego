package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import stratego.Reserve;
import stratego.TypePiece;

public class ReserveTest {

	@Test
	public void test() {
		Reserve reserve = new Reserve();		
		assertFalse(reserve.estVide());		
		assertEquals(reserve.getNombrePieceDisponible(TypePiece.Capitaine),2);
		
		/*on enleve un capitaine*/
		reserve.retirerPiece(TypePiece.Capitaine);		
		assertEquals(reserve.getNombrePieceDisponible(TypePiece.Capitaine),1);
		
		/*on retire le dernier capitaine*/
		reserve.retirerPiece(TypePiece.Capitaine);
		assertEquals(reserve.getNombrePieceDisponible(TypePiece.Capitaine),0);
		assertEquals(reserve.pieceEstDisponible(TypePiece.Capitaine),false);
		
		/*On remet un capitaine*/
		reserve.remettrePiece(TypePiece.Capitaine);
		assertEquals(reserve.getNombrePieceDisponible(TypePiece.Capitaine),1);
	}

}
