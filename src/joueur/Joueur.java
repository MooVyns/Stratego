package joueur;

import stratego.AbstractJoueur;
import stratego.Camp;
import stratego.Piece;
import stratego.Plateau;
import stratego.TypePiece;


public class Joueur extends AbstractJoueur {
	private int piecesReserve [] = new int[TypePiece.values().length];
	
	public Joueur(String nom, Camp camp, Plateau plateau) {
		super(nom, camp, plateau);
	}

	@Override
	public void placerPiece(String coord, TypePiece type, Piece piece) throws Exception {
		//condition sur la piece 
		//existe elle dans la reserve ?
		if (piecesReserve[type.getValeur()]>0) {
		plateau.placerPiece(coord, piece);
		}
	}

	@Override
	public void retirePiece(String coord) {
		plateau.retirerPiece(coord);
	}

	@Override
	public void deplacerPiece(String coord, String newCoord) {
		plateau.retirerPiece(newCoord);
		///
	}

	@Override
	public void jouer() {

	}
	
	public void dispoReserve(Piece p) {

		
		piecesReserve[TypePiece.Maréchal.getValeur()]=1;
		piecesReserve[TypePiece.Général.getValeur()]=1;
		piecesReserve[TypePiece.Colonel.getValeur()]=2;
		piecesReserve[TypePiece.Major.getValeur()]=3;
		piecesReserve[TypePiece.Capitaine.getValeur()]=4;
		piecesReserve[TypePiece.Lieutenant.getValeur()]=4;
		piecesReserve[TypePiece.Sergent.getValeur()]=4;
		piecesReserve[TypePiece.Démineur.getValeur()]=5;
		piecesReserve[TypePiece.Eclaireur.getValeur()]=8;
		piecesReserve[TypePiece.Espion.getValeur()]=1;
		piecesReserve[TypePiece.Bombe.getValeur()]=6;
		piecesReserve[TypePiece.Drapeau.getValeur()]=1;
			

	}

}
