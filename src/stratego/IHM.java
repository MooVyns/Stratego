package stratego;


import plateau.Plateau;


public interface IHM {
	public void afficherPlateau(Plateau plateau);
	public String[] saisieNomJoueur();
	public String choixCoordonnees();
	public void afficherString(String str);
	public TypePiece choixPiece(AbstractJoueur j);
	public String retirerPiece ();
	//impossible d'avoir une methode static avec une interface
	public IEnumDirection choixDirection(IEnumDirection enumDir);
}


// ajouter la possibilité retirer la piece. 

