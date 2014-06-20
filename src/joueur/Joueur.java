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

	
	public boolean verfiCoordonnees(String coord) {
		for (int i = 0; i < this.plateau.getPlateau().length; ++i) {
			for (int j = 0; j < this.plateau.getPlateau().length; ++j) {
				if (coord.equals(this.plateau.getPlateau()[i][j])) {
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public void jouer(Direction dir, int nbrCases, String coord) {
		
		Piece p = null;
		//Verification des coordonn�es
		if(verfiCoordonnees(coord))
			//R�cup�ration de la pi�ce la piece
			 p = plateau.getPiece(coord);

		// Verification de la possibilit� de d�placement(type)

		if (p != null) {
			// jouer piece
		}

		// Calcul des nouvelles coordonn�es
		String coorPiece = p.getCoordonnees();

		// Verification des coordonn�es
	}
}
