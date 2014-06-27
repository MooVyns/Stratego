package tests;

import static org.junit.Assert.*;
import joueur.FabriqueJoueur;
import joueur.Joueur;

import org.junit.Test;

import plateau.Plateau;
import stratego.AbstractJoueur;
import stratego.Camp;
import stratego.IFabriqueJoueur;
import stratego.Piece;
import stratego.TypePiece;

public class AffrontementTest {

	@Test
	public void test() {
		Plateau plateau = new Plateau(7, 9);
		IFabriqueJoueur IFabrique = new FabriqueJoueur();
		AbstractJoueur[] joueurs = new Joueur[2];
		joueurs[0] = IFabrique.creerJoueur("j1", Camp.values()[0],
				plateau);
		joueurs[1] = IFabrique.creerJoueur("j2", Camp.values()[1],
				plateau);
		
		
		//TEST BOMBE
		plateau.placerPiece("B4",
				new Piece(TypePiece.Bombe, Camp.values()[0]));
		plateau.placerPiece("B4",
				new Piece(TypePiece.Bombe, Camp.values()[0]));
		
		
		//TEST DEMINAGE
		
		
		
		
		//TEST PIECE FORTE SE DEPLACE
		
		
		
		
		
		//TEST FAIBLE SE DEPLACE
		
		
		
		
		//TEST EGALITE
		
		
	}

}
