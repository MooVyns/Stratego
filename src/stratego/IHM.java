package stratego;


public interface IHM {
	public void afficherPlateau(Plateau plateau);
	public String[] saisieNomJoueur();
	public String choixCoordonnees();
	public void afficherString(String str);
	public TypePiece choixPiece(AbstractJoueur j);
	public void retirerPiece (String coord);
}


// ajouter la possibilité retirer la piece. 

