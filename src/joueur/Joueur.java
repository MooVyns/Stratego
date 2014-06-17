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
		if (getPiecesReserve()[type.getValeur()]>0) {
			plateau.placerPiece(coord, new Piece(type, this.getCamp()));
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
		placerPiece(newCoord, plateau.retirerPiece(coord).getTypePiece());
	}

	@Override
	public void jouer() {

	}
	
	

}
