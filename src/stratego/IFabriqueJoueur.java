package stratego;



public interface IFabriqueJoueur {
	public AbstractJoueur creerJoueur(String nom, Camp camp, AbstractPlateau plateau);
}
