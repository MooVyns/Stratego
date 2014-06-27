package stratego;

public class Piece {
	private TypePiece typePiece;
	private Camp camp;
	private Case c;
	private boolean estVisible;

	public Piece(TypePiece typePiece, Camp camp) {
		this.typePiece = typePiece;
		this.camp = camp;
		this.estVisible = true;
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

	public int getDeplacementMax() {
		return this.typePiece.getDeplacementMax();
	}

	public boolean estJouable() {
		return typePiece.estJouable();
		// + verifier si la piece est bloquer
	}

	public void setCase(Case c) {
		this.c = c;
	}

	public void supprimer() {
		setCase(null);
	}

	public boolean getEstVisible() {
		return this.estVisible;
	}

	public void cacher() {
		this.estVisible = false;
	}

	public void rendreVisible() {
		this.estVisible = true;
	}

	public String toString() {
		if (this.estVisible == true)
			if(camp == Camp.values()[0])
				return this.typePiece.getRepresentation();
			else
				return this.typePiece.getRepresentation().toLowerCase();
		else
			return "#";
	}

	public boolean surPlateau() {
		return c != null;
	}

	public boolean estSupérieur(Piece p2) {
		return this.typePiece.getValeur() > p2.getTypePiece().getValeur();
	}

	
	public boolean estEgale(Piece p2){
		return this.typePiece.getValeur() == p2.getTypePiece().getValeur();
	}
	
}
