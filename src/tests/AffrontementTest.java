package tests;

import static org.junit.Assert.*;
import joueur.FabriqueJoueur;
import joueur.Joueur;

import org.junit.Test;

import plateau.Direction;
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
		plateau.placerPiece("B6",
				new Piece(TypePiece.Lieutenant, Camp.values()[1]));
		
		
		joueurs[1].jouer("B6", Direction.Nord, 1);
		joueurs[1].jouer("B5", Direction.Nord, 1);
		assertEquals(plateau.getCase("B4").getPiece().getTypePiece(), TypePiece.Bombe);		
		
	
		
		//TEST PIECE FORTE SE DEPLACE
		plateau.placerPiece("D4",
				new Piece(TypePiece.Démineur, Camp.values()[0]));
		plateau.placerPiece("D6",
				new Piece(TypePiece.Lieutenant, Camp.values()[1]));
		
		
		joueurs[1].jouer("D6", Direction.Nord, 1);
		joueurs[1].jouer("D5", Direction.Nord, 1);
		assertEquals(plateau.getCase("D4").getPiece().getTypePiece(), TypePiece.Lieutenant);
		
		
		
		
		//TEST FAIBLE SE DEPLACE
		/*plateau.placerPiece("B4",
				new Piece(TypePiece.Bombe, Camp.values()[0]));
		plateau.placerPiece("B6",
				new Piece(TypePiece.Lieutenant, Camp.values()[1]));
		
		
		joueurs[1].jouer("B6", Direction.Nord, 1);
		joueurs[1].jouer("B6", Direction.Nord, 1);
		assertEquals(plateau.getCase("B4").getPiece().getTypePiece(), TypePiece.Bombe);
		
		
		
		//TEST EGALITE
		plateau.placerPiece("B4",
				new Piece(TypePiece.Bombe, Camp.values()[0]));
		plateau.placerPiece("B6",
				new Piece(TypePiece.Lieutenant, Camp.values()[1]));
		
		
		joueurs[1].jouer("B6", Direction.Nord, 1);
		joueurs[1].jouer("B6", Direction.Nord, 1);
		assertEquals(plateau.getCase("B4").getPiece().getTypePiece(), TypePiece.Bombe);
		
		//TEST DEMINAGE
		plateau.placerPiece("B4",
				new Piece(TypePiece.Bombe, Camp.values()[0]));
		plateau.placerPiece("B6",
				new Piece(TypePiece.Lieutenant, Camp.values()[1]));
		
		
		joueurs[1].jouer("B6", Direction.Nord, 1);
		joueurs[1].jouer("B6", Direction.Nord, 1);
		assertEquals(plateau.getCase("B4").getPiece().getTypePiece(), TypePiece.Bombe);*/
		
		
		
	}

}
