package stratego;


public abstract class AbstractJoueur {
	protected AbstractPlateau plateau;
	private String nom;
	private Camp camp;
	private Reserve reserve;

	public AbstractJoueur(String nom, Camp camp, AbstractPlateau plateau) {
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

	public abstract boolean placerPiece(String coord, TypePiece type);

	public abstract boolean retirerPiece(String coord);

	public abstract boolean jouer(String coord,IEnumDirection direction, int nbrCases);
}
