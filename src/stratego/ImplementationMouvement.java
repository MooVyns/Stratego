package stratego;


public abstract class ImplementationMouvement {
	private int CASES_DEPLACEMENT_MAX;	
	
	public void setDeplacementMax(int deplacementMax){
		CASES_DEPLACEMENT_MAX  = deplacementMax;
	}
	
	public int getDeplacementMax(){
		return this.CASES_DEPLACEMENT_MAX;
	}

	public boolean estJouable() {
		return this.getDeplacementMax() != 0;
	}


	public String calculNouvellesCoordonn�e(String coord, Direction direction, int nbrCases) {
		int [] coordStr = OperationCoordonn�es.stringToCoord(coord);
		coordStr[0]+=(direction.getColonne() * nbrCases);
		coordStr[1]+=(direction.getLigne() * nbrCases);		
		return OperationCoordonn�es.coordToString(coordStr[0], coordStr[1]);
	}
}
