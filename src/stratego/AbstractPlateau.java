package stratego;

public abstract class AbstractPlateau {
	private final int COLONNES = 7;
	private final int LIGNES = 9;
	
	public int getNbLignes() {
		return LIGNES;
	}

	public int getNbColonnes() {
		return COLONNES;
	}
	
}
