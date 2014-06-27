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
		assertEquals(plateau.getCase("B4").getPiece(), null);		
		
	
		
		//TEST PIECE FORTE SE DEPLACE
		plateau.placerPiece("D4",
				new Piece(TypePiece.Démineur, Camp.values()[0]));
		plateau.placerPiece("D6",
				new Piece(TypePiece.Lieutenant, Camp.values()[1]));
		
		
		joueurs[1].jouer("D6", Direction.Nord, 1);
	
		joueurs[1].jouer("D5", Direction.Nord, 1);
	
		//assertEquals(plateau.getCase("D4").getPiece().getTypePiece(), TypePiece.Lieutenant);
		
		
		
		
		//TEST FAIBLE SE DEPLACE
		plateau.placerPiece("F4",
				new Piece(TypePiece.Lieutenant, Camp.values()[0]));
		plateau.placerPiece("F6",
				new Piece(TypePiece.Démineur, Camp.values()[1]));
		
		
		joueurs[1].jouer("F6", Direction.Nord, 1);
		joueurs[1].jouer("F5", Direction.Nord, 1);
		assertEquals(plateau.getCase("F4").getPiece().getTypePiece(), TypePiece.Lieutenant);
		
		
		
		//TEST EGALITE
		plateau.placerPiece("A3",
				new Piece(TypePiece.Lieutenant, Camp.values()[0]));
		plateau.placerPiece("A6",
				new Piece(TypePiece.Lieutenant, Camp.values()[1]));
		
		
		joueurs[1].jouer("A6", Direction.Nord, 1);
		joueurs[1].jouer("A5", Direction.Nord, 1);
		joueurs[1].jouer("A4", Direction.Nord, 1);
		assertEquals(plateau.getCase("A3").getPiece(), null);
		
		
		//TEST DEMINAGE
		plateau.placerPiece("C3",
				new Piece(TypePiece.Bombe, Camp.values()[0]));
		plateau.placerPiece("C6",
				new Piece(TypePiece.Démineur, Camp.values()[1]));
		
		
		joueurs[1].jouer("C6", Direction.Nord, 1);
		joueurs[1].jouer("C5", Direction.Nord, 1);
		joueurs[1].jouer("C4", Direction.Nord, 1);
		assertEquals(plateau.getCase("C3").getPiece().getTypePiece(), TypePiece.Démineur);
		
		
		
	}

}
