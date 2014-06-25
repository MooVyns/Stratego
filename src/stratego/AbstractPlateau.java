package stratego;


public abstract class AbstractPlateau {
	private int COLONNES = 7;
	private int LIGNES = 9;
	private Case[][] plateau;

	public AbstractPlateau(int colonnes, int lignes) {
		this.COLONNES = colonnes;
		this.LIGNES = lignes;
		plateau = new Case[COLONNES][LIGNES];
		for (int i = 0; i < getNbColonnes(); ++i) {
			for (int j = 0; j < getNbLignes(); ++j) {
				plateau[i][j] = new Case(OperationCoordonnées.coordToString(i,
						j));
			}
		}
	}

	public int getNbLignes() {
		return LIGNES;
	}

	public int getNbColonnes() {
		return COLONNES;
	}

	public Case[][] getPlateau() {
		return this.plateau;
	}

	public Case getCase(String coord) {
		int[] coordStr = OperationCoordonnées.stringToCoord(coord);
		return this.plateau[coordStr[0]][coordStr[1]];
	}

	// ok
	public boolean caseOccupee(String coord) {
		return this.getCase(coord).estOccupée();
	}

	public Piece getPiece(String coord) {
		return this.getCase(coord).getPiece();
	}

	public void cacherPieces(Camp camp) {
		for (int i = 0; i < getNbLignes(); i++) {
			for (int j = 0; j < getNbColonnes(); j++)
				if (plateau[j][i].estOccupée()) {
					if (plateau[j][i].getPiece().getCamp() == camp) {
						plateau[j][i].getPiece().cacher();
					}
				}
		}
	}

	public void rendreVisiblePieces(Camp camp) {
		for (int i = 0; i < getNbLignes(); i++) {
			for (int j = 0; j < getNbColonnes(); j++)
				if (plateau[j][i].estOccupée()) {
					if (plateau[j][i].getPiece().getCamp() == camp) {
						plateau[j][i].getPiece().rendreVisible();
					}
				}
		}
	}

	public abstract boolean placerPiece(String coord, Piece piece);
	public abstract boolean retirerPiece(String coord);
	public abstract boolean jouer(IEnumDirection direction, int nbrCases, String coord);
	public abstract void affrontement(Piece pieceDeplacer, Piece pieceEnAttente);
	public abstract String toString();
	public abstract String etatPlateau();

}
