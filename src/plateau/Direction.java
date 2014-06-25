package plateau;

import stratego.IEnumDirection;


public enum Direction implements IEnumDirection {
	Nord(0, -1, "N", "Nord"), Sud(0, 1, "S", "Sud"), NordOuest(-1, 0, "NO",
			"NordOuest"), NordEst(1, 0, "NE", "NordEst"), SudOuest(-1, 1,
			"SO", "SudOuest"), SudEst(1, 1, "SE", "SudEst");

	private int colonne;
	private int ligne;
	private String representation;
	private String nom;

	Direction(int colonne, int ligne, String representation, String nom) {
		this.colonne = colonne;
		this.ligne = ligne;
		this.representation = representation;
		this.nom = nom;
	}

	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public String getRepresentation() {
		return this.representation;
	}

	public String toString() {
		return this.nom;
	}

	public IEnumDirection[] enumeration() {
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
	
	
	public boolean exist(String str){
		for (int i = 0; i < Direction.values().length; i++) {
			if (str.equals(Direction.values()[i].getRepresentation()))
				return true;
		}
		return false;
	}
}
