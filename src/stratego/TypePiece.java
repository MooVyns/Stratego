package stratego;

public enum TypePiece {
	Drapeau(0, "X", "Drapeau"), Espion(1, "J", "Espion"), Eclaireur(2, "I",
			"Eclaireur"), Démineur(3, "H", "Démineur"), Sergent(4, "G",
			"Sergent"), Lieutenant(5, "F", "Lieutenant"), Capitaine(6, "E",
			"Capitaine"), Major(7, "D", "Major"), Colonel(8, "C", "Colonel"), Général(
			9, "B", "Général"), Maréchal(10, "A", "Maréchal"), Bombe(11, "O",
			"Bombe");

	private int valeur;
	private String initiale;
	private String nom;

	TypePiece(int valeur, String initiale, String nom) {
		this.valeur = valeur;
		this.initiale = initiale;
		this.nom = nom;
	}

	public String representation() {
		return this.initiale;
	}

	public String toString() {
		return this.nom;
	}

	public int getValeur() {
		return this.valeur;
	}

	public TypePiece getTypePiece(int v) {
		return TypePiece.values()[0];
	}
}
