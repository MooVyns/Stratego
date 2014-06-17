package stratego;

public class Plateau {
	private Case[][] plateau;
	private final int COLONNES = 7;
	private final int LIGNES = 9;

	
	//a finir
	public Plateau() {
		plateau = new Case[COLONNES + 1][LIGNES + 1];
		for (int i = 0; i < (COLONNES + 1); ++i) {
			for (int j = 0; j < (LIGNES + 1); ++j) {
				plateau[i][j] = new Case(Camp.Nord, coordToString(i, j));
			}
		}
	}

	//ok
	private String coordToString(int i, int j) {
		String res = new String();
		res += (char) (i + 64);
		res += Integer.toString(j);
		return res;
	}

	
	private int[] stringToCoord(String coord) {
		int[] res = new int[2];
		res[0] = coord.charAt(0);
		res[1] = coord.charAt(0);
		return res;
	}

	//ok
	public void placerPiece(String coord, Piece piece) throws Exception {
		int[] numCoord = stringToCoord(coord);
		// les coordonnées existe ?
		if (numCoord[0] > COLONNES || numCoord[0] > LIGNES) {
			throw new Exception();
		}
		// la piece est telle placer dans le bon camp ?
		if (plateau[numCoord[0]][numCoord[1]].getCamp().toString()
				.equals(piece.getCamp().toString())) {
			// y'a t-il une piece deja placer a cette endroit
			if (!caseOccupee(coord)) {
				plateau[numCoord[0]][numCoord[1]].setPiece(piece);
			}
		} else {
			throw new Exception();
		}
	}

	public void retirerPiece(String coord) {
		// bonne coordonné ?
		int[] numCoord = stringToCoord(coord);
		if (numCoord[0] > COLONNES || numCoord[0] > LIGNES) {
			throw new Exception();
		}
		// ya til une piece a cette endroit ? 
		if (this.caseOccupee(coord)) 
				plateau[numCoord[0]][numCoord[1]].setPiece(null);
		// est ce ma piece ?
		
		int[] numCoord = stringToCoord(coord);
		plateau[numCoord[0]][numCoord[1]].retirerPiece();

	}

	//ok
	public boolean caseOccupee(String coord) {
		int[] numCoord = stringToCoord(coord);		
		return plateau[numCoord[0]][numCoord[1]].estOccupée();
	}

	
	public String toString() {
		String str = new String();
		for (int i = 0; i < (COLONNES + 1); ++i) {
			for (int j = 0; j < (LIGNES + 1); ++j) {
				str += plateau[i][j].getPiece().getTypePiece().toString();
			}
		}
		return str;
	}
	
	public String etatPlateau(){
		return null;
	}
	
	
}