import stratego.Direction;


public class PieceImmobile extends ImplementationMouvement {
	
	public PieceImmobile(int deplacementMax) {
		super(deplacementMax);
	}

	public boolean estJouable() {
		return CASES_DEPLACEMENT_MAX != -1;
	}

	@Override
	public void jouer(Direction dir, int nbrCases) {
		// TODO Auto-generated method stub
		
	}

}
