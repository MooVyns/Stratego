package plateau;

import stratego.AbstractPlateau;
import stratego.Camp;
import stratego.Case;
import stratego.IEnumDirection;
import stratego.OperationCoordonn�es;
import stratego.Piece;
import exceptions.*;

public class Plateau extends AbstractPlateau {
	private Case[][] plateau;

	// a finir
	public Plateau() {
		plateau = new Case[getNbColonnes()][getNbLignes()];
		for (int i = 0; i < getNbColonnes(); ++i) {
			for (int j = 0; j < getNbLignes(); ++j) {
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

	public Case getCase(String coord) {
		int[] coordStr = OperationCoordonn�es.stringToCoord(coord);
		return this.plateau[coordStr[0]][coordStr[1]];
	}

	// a verifier
	public boolean placerPiece(String coord, Piece piece) {
		boolean res = true;
		try {

			int[] numCoord = OperationCoordonn�es.stringToCoord(coord);
			if (numCoord[0] > getNbColonnes() || numCoord[1] > getNbLignes()
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
		// bonne coordonn�e ?
		try {
			int[] numCoord = OperationCoordonn�es.stringToCoord(coord);
			if (numCoord[0] > getNbColonnes() || numCoord[0] > getNbLignes()) {
				throw new CoordonneeInconnuException();
			}
			// y a-t-il une piece a cette endroit ?
			if (this.caseOccupee(coord)) {
				this.getCase(coord).retirerPiece();
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

	public void jouer(IEnumDirection direction, int nbrCases, String coord) {
		try {
			Piece piece = null;
			// La piece existe ?
			if (((piece = this.getPiece(coord))) != null) {
				// Peut-elle bouger autant ?
				if (nbrCases <= piece.getDeplacementMax()) {

					String newCoord = OperationCoordonn�es
							.calculNouvellesCoordonn�e(coord, direction,
									nbrCases);

					// Les nouvelles coordonn�es sont elles correctes ?
					if (OperationCoordonn�es.verfiCoordonnees(newCoord, this)) {
						// la case est-elle d�ja occup�e ?
						if (this.getCase(newCoord).estOccup�e()) {
							// affrontement();
							System.out.println("affrontement");
						} else {
							// d�placer la piece
							// r�cup pc avec coord jouer
							Piece p = getCase(coord).getPiece();

							this.getCase(coord).getPiece();

							// placer sur nouvelles coordonn�es
							this.getCase(newCoord).setPiece(p);
							// effacer les anciennes coordonn�es
							this.getCase(coord).retirerPiece();
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

	/*
	 * Fin de partie, lors de l'affrontement verifier si un drapeau a �t�
	 * elimin�
	 */
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
			this.plateau[coordonnees[0]][coordonnees[1]].retirerPiece();
			// la case ne pointe plus sur la piece
		} else {
			// Suppression des 2 pieces
			// Egalit� !!!
		}
	}

	public String toString() {
		String str = "";
		String m1 = "     ___     ___     ___      \n";// haut du plateau

		String m2 = " ___/ ";
		String dessinCase = " \\___/ ";

		for (int i = 0; i < getNbColonnes(); i++) {
			if (i % 2 == 1) {
				if (i == getNbColonnes() - 2) {
					dessinCase = " \\___ ";
				}
				if (!plateau[i][0].estOccup�e())
					m2 += plateau[i][0].toString() + dessinCase;
				else
					m2 += plateau[i][0].getPiece().toString() + dessinCase;
			}
		}
		dessinCase = " \\___/ ";
		String m3 = "/ ";
		for (int j = 0; j < getNbColonnes(); j++) {
			if (j % 2 == 0) {
				if (j == getNbColonnes() - 1) {
					dessinCase = " \\";
				}
				if (!plateau[j][0].estOccup�e())
					m3 += plateau[j][0].toString() + dessinCase;
				else
					m3 += plateau[j][0].getPiece().toString() + dessinCase;
			}
		}
		m3 += "\n";
		m2 += "\n";
		str += m1 + m2 + m3;
		dessinCase = " \\___/ ";

		for (int i = 1; i < getNbLignes(); i++) {
			if (i == getNbLignes() - 1)
				m3 = "  ";
			else
				m3 = "/ ";
			for (int j = 0; j < getNbColonnes(); j++) {
				if (j % 2 == 0) {
					if (j == getNbColonnes() - 1)
						dessinCase = " \\";

					if (j == getNbColonnes() - 1 && i == getNbLignes() - 1)
						dessinCase = " ";

					if (j == getNbColonnes() - 1 && i == 0) {
						m3 = "  ";
					}

					if (!plateau[j][i].estOccup�e())
						m3 += plateau[j][i].toString() + dessinCase;
					else
						m3 += plateau[j][i].getPiece().toString() + dessinCase;
				}

			}
			m3 += " \n";
			dessinCase = " \\___/ ";

			String m4 = "\\___/ ";
			for (int j = 0; j < getNbColonnes(); j++) {
				if (j % 2 == 1)
					if (!plateau[j][i].estOccup�e())
						m4 += plateau[j][i].toString() + dessinCase;
					else
						m4 += plateau[j][i].getPiece().toString() + dessinCase;
			}

			m4 += " \n";
			dessinCase = " \\___/ ";
			str += m4 + m3;
		}

		return str;
	}

	public String etatPlateau() {
		String etat = new String();
		int nbCasesVide = 0;
		for (int i = 0; i < getNbLignes(); i++) {
			for (int j = 0; j < getNbColonnes(); j++) {
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

	public void cacherPieces(Camp camp) {
		for (int i = 0; i < getNbLignes(); i++) {
			for (int j = 0; j < getNbColonnes(); j++)
				if (plateau[j][i].estOccup�e()) {
					if (plateau[j][i].getPiece().getCamp() == camp) {
						plateau[j][i].getPiece().cacher();
					}
				}
		}
	}

	public void rendreVisiblePieces(Camp camp) {
		for (int i = 0; i < getNbLignes(); i++) {
			for (int j = 0; j < getNbColonnes(); j++)
				if (plateau[j][i].estOccup�e()) {
					if (plateau[j][i].getPiece().getCamp() == camp) {
						plateau[j][i].getPiece().rendreVisible();
					}
				}
		}
	}

}
