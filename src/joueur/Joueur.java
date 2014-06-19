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
	public void placerPiece(String coord, TypePiece typePiece) {
		if (this.getReserve().pieceEstDisponible(typePiece)) {
			plateau.placerPiece(coord, new Piece(typePiece, this.getCamp()));
			this.getReserve().retirerPiece(typePiece);
		}
	}

	@Override
	public void retirerPiece(String coord) {
		if (getCamp().equals(coord)){
			plateau.retirerPiece(coord);
			//this.getReserve().remettrePiece(typePiece);
		}
	}

	@Override
	public void jouer() {

	}
}
