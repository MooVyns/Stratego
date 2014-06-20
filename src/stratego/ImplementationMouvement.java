package stratego;


public abstract class ImplementationMouvement {
	protected final int CASES_DEPLACEMENT_MAX;

	public ImplementationMouvement(int deplacementMax) {
		CASES_DEPLACEMENT_MAX = deplacementMax;
	}

	public abstract boolean estJouable();
	
	public abstract void jouer();
}
