package joueur;

import stratego.AbstractJoueur;
import stratego.Camp;
import stratego.Piece;
import stratego.Plateau;
import stratego.TypePiece;


public class Joueur extends AbstractJoueur {
	
	
	public Joueur(String nom, Camp camp, Plateau plateau) {
		super(nom, camp, plateau);
	}

	@Override
	public void placerPiece(String coord, TypePiece type) throws Exception {
		//condition sur la piece 
		//existe elle dans la reserve ?
		if (getPiecesReserve()[type.getValeur()]>0) {
			Piece piece = new Piece(type, this.getCamp());
			plateau.placerPiece(coord, piece);
			this.piecesReserve[type.getValeur()]--;
		}
	}

	@Override
	public void retirerPiece(String coord) {
		if (getCamp().equals(coord)){
			this.piecesReserve[plateau.retirerPiece(coord).getTypePiece().getValeur()]++;
		}
	}

	@Override
	public void deplacerPiece(String coord, String newCoord) throws Exception {
		retirerPiece(coord);
		//Piece piece = plateau.getPiece(coord);
		//placerPiece(newCoord, piece);
	}

	@Override
	public void jouer() {

	}
	
	

}
