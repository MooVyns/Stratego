package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import plateau.Plateau;
import stratego.Camp;
import stratego.Piece;
import stratego.TypePiece;

public class PlateauTest {

	@Test
	public void test() {
		Plateau plateau = new Plateau(7, 9);

		
		plateau.placerPiece("A1",
				new Piece(TypePiece.Bombe, Camp.values()[0]));
		plateau.placerPiece("B7",
				new Piece(TypePiece.Bombe, Camp.values()[1]));
		
		// TEST CASE OCCUPEE
		System.out.println("TEST CASE OCCUPEE");
		assertEquals(plateau.caseOccupee("A1"), true);
		assertEquals(plateau.caseOccupee("A2"), false);
		assertEquals(plateau.caseOccupee("B7"), true);		
		
		
		// TEST GETPIECE
		System.out.println("TEST GETPIECE");
		assertEquals(plateau.getPiece("A1"), plateau.getCase("A1").getPiece());
		assertEquals(plateau.getPiece("B7"), plateau.getCase("B7").getPiece());
		assertEquals(plateau.getPiece("A2"), null);

		//TEST CACHERPIECE		
		System.out.println("TEST CACHERPIECE");
		plateau.cacherPieces(Camp.values()[0]);
		System.out.println(plateau.toString());
		plateau.cacherPieces(Camp.values()[1]);
		System.out.println(plateau.toString());
		
		//TEST RENDREVISIBLEPIECES
		System.out.println("TEST RENDREVISIBLEPIECES");
		plateau.rendreVisiblePieces(Camp.values()[0]);
		System.out.println(plateau.toString());
		plateau.rendreVisiblePieces(Camp.values()[1]);
		System.out.println(plateau.toString());
		
		
		//TEST ETAT PLATEAU
		System.out.println(plateau.etatPlateau());
		
	}
}
