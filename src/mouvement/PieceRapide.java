package mouvement;

import stratego.ImplementationMouvement;


public class PieceRapide extends ImplementationMouvement {

	public PieceRapide(int deplacementMax) {
		super(deplacementMax);
		// TODO Auto-generated constructor stub
	}

	public boolean estJouable() {
		return false;
	}

	@Override
	public void jouer() {
		// TODO Auto-generated method stub		
	}

}
