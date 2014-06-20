package mouvement;

import stratego.ImplementationMouvement;


public class PieceImmobile extends ImplementationMouvement {
	
	public PieceImmobile(int deplacementMax) {
		super(deplacementMax);
	}

	public boolean estJouable() {
		return CASES_DEPLACEMENT_MAX != -1;
	}

	@Override
	public void jouer() {
		// TODO Auto-generated method stub
		
	}

}
