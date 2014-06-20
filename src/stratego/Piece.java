package stratego;

import mouvement.FabriqueImplementation;

public class Piece {
	private TypePiece typePiece;
	private Camp camp;
	private Case c;
	private ImplementationMouvement implementation;

	public Piece(TypePiece typePiece, Camp camp) {
		this.typePiece = typePiece;
		this.camp = camp;
		this.implementation = FabriqueImplementation.creer(typePiece
				.getValeur());
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

	public boolean estJouable() {
		return implementation.estJouable();
		// + verifier si la piece est bloquer
	}

	public void setCase(Case c) {
		this.c = c;
	}

	public void supprimer(){
		setCase(null);
	}

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
