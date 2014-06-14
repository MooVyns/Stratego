package stratego;

public class Piece {
	private TypePiece typePiece;
	private Camp camp;
	private Case c;

	public Piece(TypePiece valeur, Camp camp) {
		this.typePiece = valeur;
		this.camp = camp;
	}

	public TypePiece getTypePiece() {
		return this.typePiece;
	}

	public String getCamp() {
		return this.camp.toString();
	}

	public String getCoordonnees() {
		return c.getCoordonnees();
	}

	////////
	public boolean estJouable() {
		return false;
	}

	public boolean surPlateau() {
		return c != null;
	}

	////////
	public boolean enReserve() {
		return false;
	}

	public boolean estSupérieur(Piece p2) {
		return this.typePiece.getValeur() > p2.getTypePiece().getValeur();		
	}

	////////
	public String ancienneCoordonnee() {
		return null;
	}

	////////
	public String nouvelleCoordonnee() {
		return null;
	}

}
