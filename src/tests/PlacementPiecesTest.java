package tests;

import static org.junit.Assert.*;
import joueur.FabriqueJoueur;

import org.junit.Test;

import plateau.Plateau;
import stratego.AbstractJoueur;
import stratego.Camp;
import stratego.Piece;
import stratego.TypePiece;

public class PlacementPiecesTest {
	@Test
	public void test() {
		Plateau plateau = new Plateau(7, 9);
		FabriqueJoueur Fabrique = new FabriqueJoueur();
		AbstractJoueur joueur = Fabrique.creerJoueur("j1", Camp.values()[0],
				plateau);

		/* TEST PlacerPiece() Plateau */
		System.out.println("TEST PlacerPiece() Plateau ");
		assertEquals(
				plateau.placerPiece("A1",
						new Piece(TypePiece.Bombe, Camp.values()[1])), false);
		assertEquals(
				plateau.placerPiece("A1",
						new Piece(TypePiece.Bombe, Camp.values()[0])), true);
		assertEquals(
				plateau.placerPiece("A7",
						new Piece(TypePiece.Bombe, Camp.values()[0])), false);
		assertEquals(
				plateau.placerPiece("A9",
						new Piece(TypePiece.Bombe, Camp.values()[0])), false);

		/* TEST PlacerPiece() Joueur */
		System.out.println("TEST PlacerPiece() Joueur");
		assertEquals(joueur.placerPiece("A1", TypePiece.Capitaine), false);
		assertEquals(joueur.placerPiece("A3", TypePiece.Capitaine), true);
		assertEquals(joueur.placerPiece("A2", TypePiece.D�mineur), true);
		assertEquals(joueur.placerPiece("A6", TypePiece.Drapeau), false);
		assertEquals(joueur.placerPiece("C9", TypePiece.Bombe), false);

		// TEST COORDONNEES
		System.out.println("TEST COORDONNEES");
		plateau.placerPiece("R1", new Piece(TypePiece.Capitaine, Camp.Nord));
		plateau.placerPiece("AD", new Piece(TypePiece.Capitaine, Camp.Nord));
		plateau.placerPiece("A20", new Piece(TypePiece.Capitaine, Camp.Nord));

		/* TEST RetirerPiece() Plateau */
		System.out.println("TEST RetirerPiece() Plateau");
		assertEquals(plateau.retirerPiece("A1"), true);
		assertEquals(plateau.retirerPiece("A2"), true);
		assertEquals(plateau.retirerPiece("A7"), false);

		/* TEST RetirerPiece() Joueur */
		System.out.println("TEST RetirerPiece() Joueur");
		assertEquals(joueur.retirerPiece("C2"), false);
		assertEquals(joueur.retirerPiece("A3"), true);
		assertEquals(joueur.retirerPiece("C9"), false);
		assertEquals(joueur.retirerPiece("A1"), false);
	}
}
