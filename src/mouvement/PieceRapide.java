package mouvement;

import stratego.ImplementationMouvement;


public class PieceRapide extends ImplementationMouvement {

	public PieceRapide() {
		this.setDeplacementMax(8);//calculer a partir de la taille du plateau
	}

	public boolean estJouable() {
		return false;
	}


}
