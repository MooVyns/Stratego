package stratego;

public class Case {
	private Camp camp;
	private String coord;
	private Piece piece;
	
	public Case(String coord){
		this.coord = coord;
	}
	
	public Case(String coord, Camp camp){
		this(coord);
		this.camp = camp;
	}
	
	public Camp getCamp(){
		return this.camp;
	}
	
	public void setCamp(Camp camp){
		this.camp = camp;
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
	
	public String toString(){
		return camp.getRepresentation();
	}
	
	
}
