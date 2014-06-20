package stratego;

public enum TypePiece {
	Drapeau(0, "X"), Espion(1, "J"),  Eclaireur(2, "I"), Démineur(
			3, "H"), Sergent(4, "G"), Lieutenant(5, "F"),Capitaine(6, "E"), Major(7, "D"), Colonel(8, "C"), Général(9,
					"B"), Maréchal(10, "A"), Bombe(11, "O");

	private int valeur;
	private String initiale;

	TypePiece(int valeur, String initiale) {
		this.valeur = valeur;
		this.initiale = initiale;
	}

	public String toString() {
		return this.initiale;
	}

	public int getValeur() {
		return this.valeur;
	}

	public TypePiece getTypePiece(int v) {
		return TypePiece.values()[0];
	}
}
