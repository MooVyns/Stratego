package plateau;

import stratego.IEnumDirection;


public enum Direction implements IEnumDirection{
	haut(0, -1, "H"), bas(0, 1, "B"), hautGauche(-1, 0, "HG"), // pas de changement de ligne
	hautDroite(1, 0, "HD"), // pas de changement de ligne
	basGauche(-1, 1, "BG"), basDroite(1, 1, "BD");

	private int colonne;
	private int ligne;
	private String representation;

	Direction(int colonne, int ligne, String representation) {
		this.colonne = colonne;
		this.ligne = ligne;
		this.representation = representation;
	}

	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}
	
	public String getRepresentation(){
		return this.representation;
	}
	
	public IEnumDirection[] enumeration(){
		return Direction.values();
	}

	@Override
	public IEnumDirection getDirection(String dir) {
		for (int i = 0; i < Direction.values().length; i++) {
			if (Direction.values()[i].getRepresentation().equals(dir))
				return Direction.values()[i];			
		}
		return null;
	}
}
