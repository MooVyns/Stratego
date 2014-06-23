package joueur;

import plateau.Plateau;
import stratego.AbstractJoueur;
import stratego.Camp;
import stratego.IFabriqueJoueur;

public class FabriqueJoueur implements IFabriqueJoueur{
	@Override
	public AbstractJoueur creerJoueur(String nom, Camp camp, Plateau plateau) {
		return new Joueur(nom,camp,plateau);			
	}

}
