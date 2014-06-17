package stratego;

public enum Direction {
	gauche(0,-2), 
	droite(0,2),
	hautGauche(1,-1),
	hautDroite(1,1),
	basGauche(-1,-1),
	basDroite(-1,1);
	
	private int colonne;
	private int ligne;
	
	
	Direction(int colonne, int ligne){
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
