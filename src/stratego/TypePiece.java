package stratego;

public enum TypePiece {
	Drapeau(0, "X", "Drapeau", 0), Espion(1, "J", "Espion", 1), Eclaireur(2,
			"I", "Eclaireur", 1), Démineur(3, "H", "Démineur", 1), Sergent(4,
			"G", "Sergent", 1), Lieutenant(5, "F", "Lieutenant", 1), Capitaine(
			6, "E", "Capitaine", 1), Major(7, "D", "Major", 1), Colonel(8, "C",
			"Colonel", 1), Général(9, "B", "Général", 1), Maréchal(10, "A",
			"Maréchal", 1), Bombe(11, "O", "Bombe", 0);

	private int valeur;
	private String initiale;
	private String nom;
	private int deplacementMax;

	TypePiece(int valeur, String initiale, String nom, int deplacementMax) {
		this.valeur = valeur;
		this.initiale = initiale;
		this.nom = nom;
		this.deplacementMax = deplacementMax;
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

	public static TypePiece getTypePiece(String c) {
		for (int i = 0; i < TypePiece.values().length; i++) {
			if (TypePiece.values()[i].representation().equals(c))
				return TypePiece.values()[i];			
		}
		return null ;
	}	

	public int getDeplacementMax() {
		return this.deplacementMax;
	}

	public boolean estJouable() {
		return this.deplacementMax != 0;
	}

}
