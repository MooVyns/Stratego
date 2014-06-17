package stratego;


public abstract class AbstractJoueur {
	protected Plateau plateau;
	private String nom;
	private Camp camp;
	
	public AbstractJoueur (String nom, Camp camp, Plateau plateau) {		
		this.nom=nom;
		this.camp=camp;
		this.plateau = plateau;
		
	}
	
	 public String getNom() {
		 return nom;
	 }
	 public String getCamp() {
		 return camp.toString();
	 }
	 
	 public  abstract void placerPiece (String coord, Piece piece) throws Exception;
	 public  abstract void retirerPiece (String coord);
	 public  abstract void deplacerPiece (String coord, String newCoord) throws Exception;
	 public  abstract void jouer ();
}
