package stratego;

import plateau.Plateau;



public abstract class AbstractJoueur {
	protected Plateau plateau;
	private String nom;
	private Camp camp;
	private Reserve reserve;

	public AbstractJoueur(String nom, Camp camp, Plateau plateau) {
		this.nom = nom;
		this.camp = camp;
		this.plateau = plateau;
		this.reserve = new Reserve();
	}

	public String getNom() {
		return nom;
	}

	public Camp getCamp() {
		return camp;
	}

	public Reserve getReserve() {
		return reserve;
	}

	public abstract void placerPiece(String coord, TypePiece type);

	public abstract void retirerPiece(String coord);

	public abstract void jouer(String coord,IEnumDirection direction, int nbrCases);
}
