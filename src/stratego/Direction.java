package stratego;

public enum Direction {
	haut(0, -1), bas(0, 1), hautGauche(-1, 0), // pas de changement de ligne
	hautDroite(1, 0), // pas de changement de ligne
	basGauche(-1, 1), basDroite(1, 1);

	private int colonne;
	private int ligne;

	Direction(int colonne, int ligne) {
		this.setColonne(colonne);
		this.setLigne(ligne);
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

}
