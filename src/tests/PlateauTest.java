package tests;

import org.junit.Test;

import plateau.Plateau;
import stratego.Camp;
import stratego.Piece;
import stratego.TypePiece;

public class PlateauTest {

	@Test
	public void test() {
		Plateau plateau = new Plateau(7, 9);

		// TEST CAMP
		System.out.println("TEST CAMP");
		plateau.placerPiece("A1", new Piece(TypePiece.Capitaine, Camp.Sud));
		plateau.placerPiece("A1", new Piece(TypePiece.Capitaine, Camp.Nord));

		// TEST COORDONNEES
		System.out.println("TEST COORDONNEES");
		plateau.placerPiece("R1", new Piece(TypePiece.Capitaine, Camp.Nord));
		plateau.placerPiece("AD", new Piece(TypePiece.Capitaine, Camp.Nord));
		plateau.placerPiece("A20", new Piece(TypePiece.Capitaine, Camp.Nord));

		// TEST CASE OCCUPEE
		System.out.println("TEST CASE OCCUPEE");

		// TEST RETIRER PIECE

	}

}
