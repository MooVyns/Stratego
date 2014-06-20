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
				if (j > 4 && j != 8)
					plateau[i][j] = new Case(Camp.Sud,
							OperationCoordonn�es.coordToString(i, j));
				if (j < 3)
					plateau[i][j] = new Case(Camp.Nord,
							OperationCoordonn�es.coordToString(i, j));
				if (j == 4)
					plateau[i][j] = new Case(Camp.Centre,
							OperationCoordonn�es.coordToString(i, j));
				if (j == 3)
					if (i % 2 == 0)
						plateau[i][j] = new Case(Camp.Centre,
								OperationCoordonn�es.coordToString(i, j));
					else
						plateau[i][j] = new Case(Camp.Nord,
								OperationCoordonn�es.coordToString(i, j));
				if (j == 8)
					if (i % 2 == 0)
						plateau[i][j] = new Case(Camp.Indisponible,
								OperationCoordonn�es.coordToString(i, j));
					else
						plateau[i][j] = new Case(Camp.Sud,
								OperationCoordonn�es.coordToString(i, j));
			}
		}
	}

	// ok
	public boolean caseOccupee(String coord) {
		int[] numCoord = OperationCoordonn�es.stringToCoord(coord);
		return plateau[numCoord[0]][numCoord[1]].estOccup�e();
	}

	public Piece getPiece(String coord) {
		int[] numCoord = OperationCoordonn�es.stringToCoord(coord);
		return plateau[numCoord[0]][numCoord[1]].getPiece();
	}

	public int getNbLignes() {
		return LIGNES;
	}

	public int getNbColonnes() {
		return COLONNES;
	}

	public Case getCase(String coord) {
		int[] coordStr = OperationCoordonn�es.stringToCoord(coord);
		return this.plateau[coordStr[0]][coordStr[1]];
	}

	// a verifier
	public boolean placerPiece(String coord, Piece piece) {
		boolean res = true;
		try {

			int[] numCoord = OperationCoordonn�es.stringToCoord(coord);
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
		// bonne coordonn� ?
		try {
			int[] numCoord = OperationCoordonn�es.stringToCoord(coord);
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
					e.printStackTrace();
				}
			}
		} catch (CoordonneeInconnuException e) {
		}
	}

	public void jouer(Direction direction, int nbrCases, String coord) {
		try {
			Piece piece = null;
			//La piece existe ?
			if (((piece = this.getPiece(coord))) != null) {
				//Peut-elle bouger autant ?
				if (nbrCases <= piece.getDeplacementMax()) {

					String newCoord = this.getPiece(coord)
							.calculNouvellesCoordonn�e(direction, nbrCases);
					int[] newCoordInt = OperationCoordonn�es
							.stringToCoord(newCoord);
					//Les nouvelles coordonn�es sont elles corrects ?
					if (OperationCoordonn�es.verfiCoordonnees(newCoord, this)) {
						// la case est elle d�ja occup�e ?
						if (plateau[newCoordInt[0]][newCoordInt[1]]
								.estOccup�e()) {
							// affrontement();
						} else {
							// deplacer la piece
						}
					} else
						throw new CoordonneeInconnuException();
				} else
					throw new DeplacementImpossibleException();
			} else
				throw new AucunePieceSurCaseException();
		} catch (CoordonneeInconnuException e) {
		} catch (DeplacementImpossibleException e) {
		} catch (AucunePieceSurCaseException e) {
		}

	}

	public void affrontement(Piece pieceDeplacer, Piece pieceEnAttente) {
		String coordPieceEnAttente = pieceEnAttente.getCoordonnees();
		String coordOriginePieceDeplacer = pieceDeplacer.getCoordonnees();
		int coordonnees[] = OperationCoordonn�es
				.stringToCoord(coordOriginePieceDeplacer);

		// La piece deplac�e est la plus forte
		if (pieceDeplacer.estSup�rieur(pieceEnAttente)) {
			pieceEnAttente.supprimer();
			this.placerPiece(coordPieceEnAttente, pieceDeplacer);
		}
		// La piece deplacer est la moins forte
		if (pieceEnAttente.estSup�rieur(pieceDeplacer)) {
			pieceDeplacer.setCase(null);// la piece ne pointe plus sur une case
			this.plateau[coordonnees[0]][coordonnees[1]].setPiece(null);
			// la case ne pointe plus sur la piece
		} else {
			// Suppression des 2 pieces
			// Egalit� !!!
		}
	}

	public String toString() {
		String str = "  ";
		for (int i = 0; i < COLONNES; ++i)
			str += (char) ('A' + i) + " ";

		str += "\n";
		for (int i = 0; i < LIGNES; ++i) {
			str += (i + 1) + " ";
			for (int j = 0; j < COLONNES; ++j) {
				if (plateau[j][i].estOccup�e())
					str += plateau[j][i].getPiece().getTypePiece()
							.representation();
				else {
					if (plateau[j][i].getCamp() == Camp.Nord)
						str += "^ ";
					if (plateau[j][i].getCamp() == Camp.Sud)
						str += "~ ";
					if (plateau[j][i].getCamp() == Camp.Centre)
						str += "- ";
					if (plateau[j][i].getCamp() == Camp.Indisponible)
						str += "  ";
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
				if (plateau[j][i].estOccup�e()) {
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
