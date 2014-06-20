package joueur;

import exceptions.CoordonneeInconnuException;
import exceptions.PieceNonDisponibleException;
import stratego.AbstractJoueur;
import stratego.Camp;
import stratego.Direction;
import stratego.OperationCoordonnées;
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
	public void jouer(Direction direction, int nbrCases, String coord) {
		try {
			if (OperationCoordonnées.verfiCoordonnees(coord,plateau)) {
				plateau.jouer(direction,nbrCases,coord);
				
			} else
				throw new CoordonneeInconnuException();
		} catch (CoordonneeInconnuException e) {
		}
	}
}
