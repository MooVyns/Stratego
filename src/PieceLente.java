import stratego.Direction;


public class PieceLente extends ImplementationMouvement {

	public PieceLente(int deplacementMax) {
		super(deplacementMax);
		// TODO Auto-generated constructor stub
	}

	public boolean estJouable() {
		return false;
	}

	@Override
	public void jouer(Direction dir, int nbrCases) {
		// TODO Auto-generated method stub
		
	}

}
