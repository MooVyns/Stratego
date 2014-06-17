package stratego;

public class Plateau {
	private Case[][] plateau;
	private final int COLONNES = 7;
	private final int LIGNES = 9;

	// a finir
	public Plateau() {
		plateau = new Case[COLONNES + 1][LIGNES + 1];
		for (int i = 0; i < (COLONNES + 1); ++i) {
			for (int j = 0; j < (LIGNES + 1); ++j) {
				plateau[i][j] = new Case(Camp.Nord, coordToString(i, j));
			}
		}
	}

	// ok
	private String coordToString(int i, int j) {
		String res = new String();
		res += (char) (i + 64);
		res += Integer.toString(j);
		return res;
	}

	// a verifier
	private int[] stringToCoord(String coord) {
		int[] res = new int[2];
		res[0] = coord.charAt(0);
		res[1] = coord.charAt(0);
		return res;
	}

	// a verifier
	public void placerPiece(String coord, Piece piece) throws Exception {
		int[] numCoord = stringToCoord(coord);
		// les coordonnées existent ?
		if (numCoord[0] > COLONNES || numCoord[0] > LIGNES) {
			throw new Exception();
		}
		// la piece est-elle placée dans le bon camp ?
		if (plateau[numCoord[0]][numCoord[1]].getCamp().toString()
				.equals(piece.getCamp().toString())) {
			// y a-t-il une piece déjà placée à cette endroit ?
			if (!caseOccupee(coord)) {
				plateau[numCoord[0]][numCoord[1]].setPiece(piece);
			}
		} else {
			throw new Exception();
		}
	}

	// a verifier
	public void retirerPiece(String coord) {

		// bonne coordonné ?
		int[] numCoord = stringToCoord(coord);
		if (numCoord[0] > COLONNES || numCoord[0] > LIGNES) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ya til une piece a cette endroit ? 
		if (this.caseOccupee(coord)) 
				plateau[numCoord[0]][numCoord[1]].setPiece(null);


		// est-ce ma pièce ?

	}

	// ok
	public boolean caseOccupee(String coord) {
		int[] numCoord = stringToCoord(coord);
		return plateau[numCoord[0]][numCoord[1]].estOccupée();
	}

	public Piece getPiece(String coord) {
		int[] numCoord = stringToCoord(coord);
		return plateau[numCoord[0]][numCoord[1]].getPiece();
	}

	public String toString() {
		String str = new String();
		for (int i = 0; i < (COLONNES + 1); ++i) {
			for (int j = 0; j < (LIGNES + 1); ++j) {
				if (plateau[i][j].estOccupée()) {
				str += plateau[i][j].getPiece().getTypePiece().toString();
				}
				else {
				str += "# \n";
				}
			}
		}
		return str;
	}

	public String etatPlateau() {
		String etat = new String();
		int nbCasesVide = 0;
		for (int i = 0; i < LIGNES; i++) {
			for (int j = 0; j < COLONNES; j++) {
				nbCasesVide++;
			}
			etat += nbCasesVide +"/";
			nbCasesVide = 0;
		}
		return etat;
	}
	
	
}
