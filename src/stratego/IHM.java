package stratego;


import plateau.Plateau;


public interface IHM {
	public void afficherPlateau(Plateau plateau);
	public String[] saisieNomJoueur();
	public String choixCoordonnees();
	public void afficherString(String str);
	public TypePiece choixPiece(AbstractJoueur j);
	public String retirerPiece ();
	public int choixNbCases();
	public String choixActionPlacementPiece();
	//impossible d'avoir une methode static avec une interface
	public IEnumDirection choixDirection(IEnumDirection enumDir);
}


// ajouter la possibilit� retirer la piece. 

