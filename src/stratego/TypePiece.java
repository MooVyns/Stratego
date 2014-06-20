package stratego;

public enum TypePiece {
	Drapeau(0, "X", "Drapeau"), Espion(1, "J", "Espion"), Eclaireur(2, "I",
			"Eclaireur"), D�mineur(3, "H", "D�mineur"), Sergent(4, "G",
			"Sergent"), Lieutenant(5, "F", "Lieutenant"), Capitaine(6, "E",
			"Capitaine"), Major(7, "D", "Major"), Colonel(8, "C", "Colonel"), G�n�ral(
			9, "B", "G�n�ral"), Mar�chal(10, "A", "Mar�chal"), Bombe(11, "O",
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
