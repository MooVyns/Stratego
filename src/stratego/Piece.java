package stratego;

import joueur.Joueur;

public class Piece {
	private TypePiece typePiece;
	private Camp camp;
	private Case c;

	public Piece(TypePiece typePiece, Camp camp) {
		this.typePiece = typePiece;
		this.camp = camp;
	}

	public TypePiece getTypePiece() {
		return this.typePiece;
	}

	public String getCamp() {
		return this.camp.toString();
	}

	public void setCase(Case c){
		this.c = c;
	}
	
	public String getCoordonnees() {
		return c.getCoordonnees();
	}

<<<<<<< HEAD
	////////
	public boolean estJouable() {
		return false;
		// return (
	}

=======
>>>>>>> 2d7afaa6a542c1d2c2b909c89051d4916cc7bedd
	public boolean surPlateau() {
		return c != null;
	}

	public boolean estSupérieur(Piece p2) {
		return this.typePiece.getValeur() > p2.getTypePiece().getValeur();
	}

	public static Piece creerPiece(TypePiece typePiece, Camp camp) {
		return new Piece(typePiece, camp);
	}
}
