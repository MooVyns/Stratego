package tests;

import joueur.FabriqueJoueur;
import ihm.ConsoleIHM;

import org.junit.Test;

import plateau.Direction;
import plateau.Plateau;
import stratego.AbstractJoueur;
import stratego.Camp;

public class ConsoleIHMTest {

	@Test
	public void test() {
		FabriqueJoueur Fabrique = new FabriqueJoueur();
		AbstractJoueur joueur = Fabrique.creerJoueur("j1", Camp.values()[0],
				new Plateau(7, 9));

		ConsoleIHM ihm = new ConsoleIHM();
		System.out.println(ihm.choixActionPlacementPiece());
		System.out.println(ihm.choixPiece(joueur));
		System.out.println(ihm.choixDirection(Direction.Nord));
		System.out.println(ihm.choixNbCases());
		System.out.println(ihm.choixCoordonnees());

	}
}
