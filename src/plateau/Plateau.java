package plateau;

import stratego.AbstractPlateau;
import stratego.Camp;
import stratego.IEnumDirection;
import stratego.OperationCoordonnées;
import stratego.Piece;
import stratego.TypePiece;
import exceptions.*;

public class Plateau extends AbstractPlateau {

	public Plateau(int colonnes, int lignes) {
		super(colonnes, lignes);
		for (int i = 0; i < getNbColonnes(); ++i) {
			for (int j = 0; j < getNbLignes(); ++j) {
				if (j > 4 && j != 8)
					this.getPlateau()[i][j].setCamp(Camp.Sud);
				if (j < 3)
					this.getPlateau()[i][j].setCamp(Camp.Nord);
				if (j == 4)
					this.getPlateau()[i][j].setCamp(Camp.Centre);
				if (j == 3)
					if (i % 2 == 0)
						this.getPlateau()[i][j].setCamp(Camp.Centre);
					else
						this.getPlateau()[i][j].setCamp(Camp.Nord);
				if (j == 8)
					if (i % 2 == 0)
						this.getPlateau()[i][j].setCamp(Camp.Indisponible);
					else
						this.getPlateau()[i][j].setCamp(Camp.Sud);
			}
		}
	}

	public boolean placerPiece(String coord, Piece piece) {
		try {
			int[] numCoord = OperationCoordonnées.stringToCoord(coord);
			if (numCoord[0] > getNbColonnes() || numCoord[1] > getNbLignes()
					|| coord.length() > 2) {
				throw new CoordonneeInconnuException();
			}
			if (this.getCase(coord).getCamp() == piece.getCamp()) {
				if (!caseOccupee(coord)) {
					this.getCase(coord).setPiece(piece);
					return true;
				} else
					throw new CaseOccupeeException();
			} else
				throw new MauvaisCampException();
		} catch (CoordonneeInconnuException e) {
			return false;
		} catch (CaseOccupeeException e) {
			return false;
		} catch (MauvaisCampException e) {
			return false;
		}
	}

	public boolean retirerPiece(String coord) {
		// bonne coordonnée ?
		try {
			int[] numCoord = OperationCoordonnées.stringToCoord(coord);
			if (numCoord[0] > getNbColonnes() || numCoord[0] > getNbLignes()) {
				throw new CoordonneeInconnuException();
			}
			// y a-t-il une piece a cette endroit ?
			if (this.caseOccupee(coord)) {
				this.getCase(coord).retirerPiece();
				return true;
			} else {
				throw new AucunePieceSurCaseException();
			}
		} catch (CoordonneeInconnuException e) {
			return false;
		} catch (AucunePieceSurCaseException e) {
			return false;
		}
	}

	public boolean jouer(IEnumDirection direction, int nbrCases, String coord) {
		try {
			Piece piece = null;
			// La piece existe ?
			if (((piece = this.getPiece(coord))) != null) {
				// Peut-elle bouger autant ?
				if (nbrCases <= piece.getDeplacementMax()) {

					String newCoord = OperationCoordonnées
							.calculNouvellesCoordonnée(coord, direction,
									nbrCases);

					// Les nouvelles coordonnées sont elles correctes ?
					if (OperationCoordonnées.verfiCoordonnees(newCoord, this)) {
						// la case est-elle déja occupée ?
						if (this.getCase(newCoord).estOccupée()) {
							affrontement(this.getPiece(coord),
									this.getPiece(newCoord));
							return true;
						} else {
							// déplacer la piece
							// récup pc avec coord jouer
							Piece p = getCase(coord).getPiece();

							this.getCase(coord).getPiece();

							// placer sur nouvelles coordonnées
							this.getCase(newCoord).setPiece(p);
							// effacer les anciennes coordonnées
							this.getCase(coord).retirerPiece();
							return true;
						}
					} else
						throw new CoordonneeInconnuException();
				} else
					throw new DeplacementImpossibleException();
			} else
				throw new AucunePieceSurCaseException();
		} catch (CoordonneeInconnuException e) {
			return false;
		} catch (DeplacementImpossibleException e) {
			return false;
		} catch (AucunePieceSurCaseException e) {
			return false;
		}
	}

	/*
	 * Fin de partie, lors de l'affrontement verifier si un drapeau a été
	 * eliminé
	 */
	public void affrontement(Piece pieceDeplacer, Piece pieceEnAttente) {
		String coordPieceEnAttente = pieceEnAttente.getCoordonnees();
		String coordOriginePieceDeplacer = pieceDeplacer.getCoordonnees();

		// égalité
		if (pieceEnAttente.estEgale(pieceDeplacer)
				|| pieceEnAttente.getTypePiece() == TypePiece.Bombe
				&& pieceDeplacer.getTypePiece() != TypePiece.Démineur) {
			pieceEnAttente.supprimer();
			pieceDeplacer.supprimer();
			this.getCase(coordPieceEnAttente).retirerPiece();
			this.getCase(coordOriginePieceDeplacer).retirerPiece();
		}
		// La piece deplacée est la plus forte
		else if (pieceDeplacer.estSupérieur(pieceEnAttente)
				|| (pieceDeplacer.getTypePiece() == TypePiece.Démineur && pieceEnAttente
						.getTypePiece() == TypePiece.Bombe)) {
			pieceEnAttente.supprimer();
			this.getCase(coordPieceEnAttente).setPiece(pieceDeplacer);
		}
		// La piece deplacer est la moins forte
		else if (pieceEnAttente.estSupérieur(pieceDeplacer)) {
			pieceDeplacer.setCase(null);// la piece ne pointe plus sur une case
			this.getCase(coordOriginePieceDeplacer).retirerPiece();
			// la case ne pointe plus sur la piece
		}
	}

	public String toString() {
		String str = "    A   B   C   D   E   F   G \n";
		String m1 = "     ___     ___     ___      \n";// haut du plateau

		String m2 = " ___/ ";
		String dessinCase = " \\___/ ";

		for (int i = 0; i < getNbColonnes(); i++) {
			if (i % 2 == 1) {
				if (i == getNbColonnes() - 2) {
					dessinCase = " \\___ ";
				}
				if (!this.getPlateau()[i][0].estOccupée())
					m2 += this.getPlateau()[i][0].toString() + dessinCase;
				else
					m2 += this.getPlateau()[i][0].getPiece().toString()
							+ dessinCase;
			}
		}

		dessinCase = " \\___/ ";
		String m3 = "/ ";
		for (int j = 0; j < getNbColonnes(); j++) {
			if (j % 2 == 0) {
				if (j == getNbColonnes() - 1) {
					dessinCase = " \\";
				}
				if (!this.getPlateau()[j][0].estOccupée())
					m3 += this.getPlateau()[j][0].toString() + dessinCase;
				else
					m3 += this.getPlateau()[j][0].getPiece().toString()
							+ dessinCase;
			}
		}
		m3 += "\n";
		m2 += "\n";
		str += "  " + m1 + "  " + m2 + "1 " + m3;
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

					if (!this.getPlateau()[j][i].estOccupée())
						m3 += this.getPlateau()[j][i].toString() + dessinCase;
					else
						m3 += this.getPlateau()[j][i].getPiece().toString()
								+ dessinCase;
				}

			}
			m3 += " \n";
			dessinCase = " \\___/ ";

			String m4 = "\\___/ ";
			for (int j = 0; j < getNbColonnes(); j++) {
				if (j % 2 == 1)
					if (!this.getPlateau()[j][i].estOccupée())
						m4 += this.getPlateau()[j][i].toString() + dessinCase;
					else
						m4 += this.getPlateau()[j][i].getPiece().toString()
								+ dessinCase;
			}
			m4 += " \n";
			dessinCase = " \\___/ ";
			str += "  " + m4 + (i + 1) + " " + m3;
		}

		return str;
	}

	public String etatPlateau() {
		String etat = new String();
		int nbCasesVide = 0;
		for (int i = 0; i < getNbLignes(); i++) {
			for (int j = 0; j < getNbColonnes(); j++) {
				if (this.getPlateau()[j][i].getCamp() != Camp.Indisponible) {
					if (this.getPlateau()[j][i].estOccupée()) {
						etat += nbCasesVide
								+ this.getPlateau()[j][i].getPiece().toString();
						nbCasesVide = 0;
					} else
						nbCasesVide++;
				}
			}
			etat += nbCasesVide;
			if (i != getNbLignes() - 1)
				etat += "/";
			nbCasesVide = 0;
		}
		return etat;
	}
}
