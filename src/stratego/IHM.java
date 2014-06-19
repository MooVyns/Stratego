package stratego;

public interface IHM {
	public void afficherPlateau(Plateau plateau);
	public String[] saisieNomJoueur();
	public TypePiece choixPiece();
	public String choixCoordonnees();
	public void afficherString(String str);
}
