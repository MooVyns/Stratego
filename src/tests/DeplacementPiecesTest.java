package tests;

import static org.junit.Assert.*;
import joueur.FabriqueJoueur;

import org.junit.Test;

import plateau.Direction;
import plateau.Plateau;
import stratego.AbstractJoueur;
import stratego.Camp;
import stratego.Piece;
import stratego.TypePiece;

public class DeplacementPiecesTest {
	@Test
	public void test() {
		Plateau plateau = new Plateau(7, 9);
		FabriqueJoueur Fabrique = new FabriqueJoueur();
		AbstractJoueur joueur = Fabrique.creerJoueur("j1", Camp.values()[0],
				plateau);

		plateau.placerPiece("A1", new Piece(TypePiece.Bombe, Camp.values()[0]));
		plateau.placerPiece("A2",
				new Piece(TypePiece.Colonel, Camp.values()[0]));

		/* TEST jouer() plateau */
		assertEquals(plateau.jouer(Direction.Nord, 1, "A1"), false);
		assertEquals(plateau.jouer(Direction.Sud, 1, "A1"), false);
		assertEquals(plateau.jouer(Direction.Sud, 1, "A2"), true);

		/* TEST jouer() joueur */
		assertEquals(joueur.jouer("A3", Direction.Nord, 1), true);
		assertEquals(joueur.jouer("A2", Direction.Nord, 1), true);
		System.out.println("f");
		// assertEquals(joueur.jouer("A1", Direction.Nord, 1),false);
		assertEquals(joueur.jouer("A1", Direction.NordEst, 1), true);
	}
}
