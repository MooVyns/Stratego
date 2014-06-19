package stratego;

public interface IHM {
	public void afficherPlateau(Plateau plateau);
	public String getNomJoueur();
	public void EntrerNomJoueur();
	public void afficherNomJoueur(AbstractJoueur joueur);
}
