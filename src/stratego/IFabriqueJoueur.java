package stratego;

import plateau.Plateau;

public interface IFabriqueJoueur {
	public AbstractJoueur creerJoueur(String nom, Camp camp, Plateau plateau);
}
