package stratego;

public class Case {
	private Camp camp;
	private String coord;
	private Piece piece;
	
	public Case(Camp camp, String coord){
		this.camp = camp;
		this.coord = coord;
	}
	
	public void setPiece(Piece piece){
		this.piece = piece;
	}	

	public String getCamp(){
		return this.camp.toString();
	}

	public boolean estOccup�e() {
		return piece != null;
	}

	public String getCoordonnees() {
		return this.coord;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void retirerPiece(){
		this.piece = null;
	}
}
