package stratego;

public class Case {
	private Camp camp;
	private String coord;
	private Piece piece;
	
	public Case(Camp camp, String coord){
		this.camp = camp;
		this.coord = coord;
	}
	
	public Camp getCamp(){
		return this.camp;
	}
	
	public void setPiece(Piece piece){
		this.piece = piece;
		this.piece.setCase(this);
	}
	
	public Piece getPiece() {
		return piece;
	}

	public boolean estOccupée() {
		return piece != null;
	}

	public String getCoordonnees() {
		return this.coord;
	}	
	
	
	public void retirerPiece(){
		this.piece = null;
	}
	
	
}
