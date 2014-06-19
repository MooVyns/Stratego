package stratego;

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

	public Camp getCamp() {
		return this.camp;
	}

	public String getCoordonnees() {
		return c.getCoordonnees();
	}

	public boolean surPlateau() {
		return c != null;
	}

	public boolean estSup�rieur(Piece p2) {
		return this.typePiece.getValeur() > p2.getTypePiece().getValeur();
	}

	public static Piece creerPiece(TypePiece typePiece, Camp camp) {
		return new Piece(typePiece, camp);
	}
}
