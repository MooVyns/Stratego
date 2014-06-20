package joueur;

import exceptions.PieceNonDisponibleException;
import stratego.AbstractJoueur;
import stratego.Camp;
import stratego.Direction;
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
			if (plateau
					.placerPiece(coord, new Piece(typePiece, this.getCamp())))
				this.getReserve().retirerPiece(typePiece);
		} else
			try {
				throw new PieceNonDisponibleException();
			} catch (PieceNonDisponibleException e) {
			}
	}

	@Override
	public void retirerPiece(String coord) {
		if (getCamp().equals(coord)) {
			plateau.retirerPiece(coord);
			// this.getReserve().remettrePiece(typePiece);
		}
	}

	@Override
	public void jouer(Direction dir, int nbrCases, String coord) {
		//R�cup�ration de la pi�ce la piece
		//Verification de la possibilit� de d�placement(type)
		//Calcul des nouvelles coordonn�es
		//Verification des coordonn�es
	}
}
