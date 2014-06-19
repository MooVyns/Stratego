package stratego;

public abstract class AbstractJoueur {
	protected Plateau plateau;
	private String nom;
	private Camp camp;
	private int[] piecesReserve;

	public AbstractJoueur(String nom, Camp camp, Plateau plateau) {
		this.nom = nom;
		this.camp = camp;
		this.plateau = plateau;
		piecesReserve = new int[TypePiece.values().length];
		this.initReserve();
	}

	public String getNom() {
		return nom;
	}

	public Camp getCamp() {
		return camp;
	}

	public int[] getPiecesReserve() {
		return piecesReserve;
	}

	public void initReserve() {
		piecesReserve[TypePiece.Maréchal.getValeur()] = 1;
		piecesReserve[TypePiece.Général.getValeur()] = 1;
		piecesReserve[TypePiece.Colonel.getValeur()] = 2;
		piecesReserve[TypePiece.Major.getValeur()] = 3;
		piecesReserve[TypePiece.Capitaine.getValeur()] = 4;
		piecesReserve[TypePiece.Lieutenant.getValeur()] = 4;
		piecesReserve[TypePiece.Sergent.getValeur()] = 4;
		piecesReserve[TypePiece.Démineur.getValeur()] = 5;
		piecesReserve[TypePiece.Eclaireur.getValeur()] = 8;
		piecesReserve[TypePiece.Espion.getValeur()] = 1;
		piecesReserve[TypePiece.Bombe.getValeur()] = 6;
		piecesReserve[TypePiece.Drapeau.getValeur()] = 1;
	}

	public abstract void placerPiece(String coord, TypePiece type);

	public abstract void retirerPiece(String coord);

	public abstract void deplacerPiece(String coord, String newCoord);

	public abstract void jouer();

}
