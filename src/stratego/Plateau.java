package stratego;

import exceptions.*;

public class Plateau {
	private Case[][] plateau;
	private final int COLONNES = 7;
	private final int LIGNES = 9;

	// a finir
	public Plateau() {
		plateau = new Case[COLONNES][LIGNES];
		for (int i = 0; i < COLONNES; ++i) {
			for (int j = 0; j < LIGNES; ++j) {
				if (j > 4)
					plateau[i][j] = new Case(Camp.Sud, coordToString(i, j));
				if (j < 3)
					plateau[i][j] = new Case(Camp.Nord, coordToString(i, j));
				if (j == 4)
					plateau[i][j] = new Case(Camp.Centre, coordToString(i, j));
				if (j == 3)
					if (i % 2 == 0)
						plateau[i][j] = new Case(Camp.Centre, coordToString(i,
								j));
					else
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
		res[0] = coord.charAt(0) - 65;
		res[1] = coord.charAt(1) - 49;
		return res;
	}

	// a verifier
	public boolean placerPiece(String coord, Piece piece) {
		boolean res = true;
		try {
			
			int[] numCoord = stringToCoord(coord);
			if (numCoord[0] > COLONNES || numCoord[1] > LIGNES
					|| coord.length() > 2) {
				res = false;
				throw new CoordonneeInconnuException();
			}
			if (plateau[numCoord[0]][numCoord[1]].getCamp() == piece.getCamp()) {
				if (!caseOccupee(coord)) {
					plateau[numCoord[0]][numCoord[1]].setPiece(piece);
				} else {
					res = false;
					throw new CaseOccupeeException();
				}
			} else {
				res = false;
				throw new MauvaisCampException();
			}
		} catch (CoordonneeInconnuException e) {
		} catch (CaseOccupeeException e) {
		} catch (MauvaisCampException e) {
		}
		return res;
	}

	// a verifier
	public void retirerPiece(String coord) {
		// bonne coordonné ?
		try {
			int[] numCoord = stringToCoord(coord);
			if (numCoord[0] > COLONNES || numCoord[0] > LIGNES) {
				throw new CoordonneeInconnuException();
			}
			// ya til une piece a cette endroit ?
			if (this.caseOccupee(coord)) {
				plateau[numCoord[0]][numCoord[1]].setPiece(null);
			} else {
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (CoordonneeInconnuException e) {
		}
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
		for (int i = 0; i < (COLONNES); ++i) {
			for (int j = 0; j < (LIGNES); ++j) {
				if (plateau[i][j].estOccupée()) {
					str += plateau[i][j].getPiece().getTypePiece().toString();
				} else {
					str += "_ ";
				}
			}
			str += "\n";
		}
		return str;
	}

	public String etatPlateau() {
		String etat = new String();
		int nbCasesVide = 0;
		for (int i = 0; i < LIGNES; i++) {
			for (int j = 0; j < COLONNES; j++) {
				if (plateau[j][i].estOccupée()) {
					etat += nbCasesVide
							+ plateau[j][i].getPiece().getCamp().toString();
					nbCasesVide = 0;
				} else {
					nbCasesVide++;
				}
			}
			etat += nbCasesVide + "/";
			nbCasesVide = 0;
		}
		return etat;
	}

}
