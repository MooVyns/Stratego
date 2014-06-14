package stratego;

public enum TypePiece {
	Maréchal(10,"A"),
	Général(9,"B"),
	Colonel(8,"C"),
	Major(7,"D"),
	Capitaine(6,"E"),
	Lieutenant(5,"F"),
	Sergent(4,"G"),
	Démineur(3,"H"),
	Eclaireur(2,"I"),
	Espion(1,"J"),
	Bombe(11,"O"),
	Drapeau(0,"X");	
	
	private int valeur;
	private String initiale;
	
	
	TypePiece(int valeur, String initiale){
		this.valeur = valeur;
		this.initiale = initiale;
	}
	
	public String toString(){
		return this.initiale;
	}
	
	public int getValeur(){
		return this.valeur;
	}
	
	
	public TypePiece getTypePiece(int v){
		return TypePiece.values()[0];		
	}
	

}
