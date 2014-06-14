
public class PieceImmobile extends ImplementationMouvement {
	
	public PieceImmobile(int deplacementMax) {
		super(deplacementMax);
	}

	public boolean estJouable() {
		return CASES_DEPLACEMENT_MAX != -1;
	}

}
