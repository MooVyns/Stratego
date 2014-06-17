package stratego;

import ihm.ConsoleIHM;
import joueur.FabriqueJoueur;
import joueur.Joueur;

public class AppliStratego {
	private AbstractJoueur[] joueurs;
	private Plateau plateau;
	private IFabriqueJoueur iFabrique;
	private IHM ihm;
	private Sauvegarde sauvegarde;

	public AppliStratego(IFabriqueJoueur iFabrique, IHM ihm) {
		this.joueurs = new Joueur[2];
		this.plateau = new Plateau();
		this.iFabrique = iFabrique;
		this.ihm = ihm;
	}

	public void initJoueur() {
		joueurs[0] = iFabrique.creerJoueur("pierre", Camp.Sud, plateau);
		joueurs[1] = iFabrique.creerJoueur("paul", Camp.Nord, plateau);
	}

	public static void main(String[] args) {
		AppliStratego app = new AppliStratego(new FabriqueJoueur(),new ConsoleIHM());
		app.initJoueur();		
		System.out.println(TypePiece.Bombe == TypePiece.Major);
	}
}
