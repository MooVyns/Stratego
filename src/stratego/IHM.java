package stratego;

import joueur.Joueur;

public interface IHM {
	public void afficherPlateau(Plateau plateau);
	public String[] saisieNomJoueur();
	public String choixCoordonnees();
	public void afficherString(String str);
	public TypePiece choixPiece(AbstractJoueur j);
}
