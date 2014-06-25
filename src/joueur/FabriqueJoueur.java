package joueur;


import stratego.AbstractJoueur;
import stratego.AbstractPlateau;
import stratego.Camp;
import stratego.IFabriqueJoueur;

public class FabriqueJoueur implements IFabriqueJoueur{
	@Override
	public AbstractJoueur creerJoueur(String nom, Camp camp, AbstractPlateau plateau) {
		return new Joueur(nom,camp,plateau);			
	}

}
