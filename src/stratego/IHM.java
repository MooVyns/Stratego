package stratego;

public interface IHM {
	public void afficherPlateau(AbstractPlateau plateau);
	public String[] saisieNomJoueur();
	public String choixCoordonnees(AbstractPlateau plateau);
	public void afficherString(String str);
	public TypePiece choixPiece(AbstractJoueur j);
	public String retirerPiece (AbstractPlateau plateau);
	public int choixNbCases();
	public String choixActionPlacementPiece();
	//impossible d'avoir une methode static avec une interface
	public IEnumDirection choixDirection(IEnumDirection enumDir);
}


// ajouter la possibilité retirer la piece. 

