package joueur;

import exceptions.CoordonneeInconnuException;
import exceptions.PieceNonDisponibleException;
import stratego.AbstractJoueur;
import stratego.AbstractPlateau;
import stratego.Camp;
import stratego.IEnumDirection;
import stratego.OperationCoordonnées;
import stratego.Piece;
import stratego.TypePiece;

public class Joueur extends AbstractJoueur {
	public Joueur(String nom, Camp camp, AbstractPlateau plateau) {
		super(nom, camp, plateau);
	}

	@Override
	public boolean placerPiece(String coord, TypePiece typePiece) {
		try {
			if (this.getReserve().pieceEstDisponible(typePiece)) {
				if (plateau.placerPiece(coord,
						new Piece(typePiece, this.getCamp()))) {
					this.getReserve().retirerPiece(typePiece);
					return true;
				} else
					throw new PieceNonDisponibleException();
			}
		} catch (PieceNonDisponibleException e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean retirerPiece(String coord) {
		// Bien retirer une piece qui nous appartient
		if (getCamp() == plateau.getCase(coord).getCamp()) {
			if (plateau.retirerPiece(coord)) {
				// remettre dans la reserve
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean jouer(String coord, IEnumDirection direction, int nbrCases) {
		try {
			if (OperationCoordonnées.verfiCoordonnees(coord, plateau)) {
				return plateau.jouer(direction, nbrCases, coord);
			} else
				throw new CoordonneeInconnuException();
		} catch (CoordonneeInconnuException e) {
			return false;
		}
	}
}
