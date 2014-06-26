package tests;

import static org.junit.Assert.fail;
import joueur.FabriqueJoueur;

import org.junit.Test;

import plateau.Plateau;
import stratego.AbstractJoueur;
import stratego.Camp;

public class DeplacementPiecesTest {
	@Test
	public void test() {
		Plateau plateau = new Plateau(7, 9);
		FabriqueJoueur Fabrique = new FabriqueJoueur();
		AbstractJoueur joueur = Fabrique.creerJoueur("j1", Camp.values()[0],
				plateau);
		
	}
}
