package joueur;

import stratego.AbstractJoueur;
import stratego.Camp;
import stratego.Piece;
import stratego.Plateau;

public class Joueur extends AbstractJoueur {
	public Joueur(String nom, Camp camp, Plateau plateau) {
		super(nom, camp, plateau);
	}

	@Override
	public void placerPiece(String coord, Piece piece) throws Exception {
		//condition sur la piece 
		//existe elle dans la reserve ?
		plateau.placerPiece(coord, piece);
	}

	@Override
	public void retirePiece(String coord) {
		if (getCamp().equals(coord)) 
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

}
