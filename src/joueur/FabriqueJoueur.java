package joueur;

import stratego.AbstractJoueur;
import stratego.Camp;
import stratego.IFabriqueJoueur;
import stratego.Plateau;

public class FabriqueJoueur implements IFabriqueJoueur{

	@Override
	public AbstractJoueur creerJoueur(String nom, Camp camp, Plateau plateau) {
		return new Joueur(nom,camp,plateau);			
	}

}
