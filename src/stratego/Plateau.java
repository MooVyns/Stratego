package stratego;

public class Plateau {
	private Case[][] plateau;
	private final int COLONNES = 7;
	private final int LIGNES = 9;

	public Plateau() {
		plateau = new Case[COLONNES + 1][LIGNES + 1];
		for (int i = 0; i < (COLONNES + 1); ++i) {
			for (int j = 0; j < (LIGNES + 1); ++j) {
				plateau[i][j] = new Case(Camp.Nord, coordToString(i, j));
			}
		}
	}

	private String coordToString(int i, int j) {
		String res = new String();
		res += (char) (i + 64);
		res += Integer.toString(j);
		return res;
	}

	public void placerPiece(String coord, Piece piece) {

	}

	public void retirerPiece(String coord) {
		
	}

	public boolean caseOccupee(String coord) {
		return false;

	}

	public boolean caseOK(String coord, Piece piece) {
		return false;
	}

	public void getPlateauDeJeu() {

	}

	// ///
	public void memoriserPlateau() {

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
}
