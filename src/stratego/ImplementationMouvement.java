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
	
	public abstract void jouer();
}
