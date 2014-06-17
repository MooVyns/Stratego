package stratego;

import joueur.Joueur;

public class AppliStratego {
	private AbstractJoueur[] joueurs;
	private Plateau plateau;
	private IFabriqueJoueur iFabrique;
	//private Sauvegarde sauvegarde;

	public AppliStratego(IFabriqueJoueur iFabrique) {
		this.joueurs = new Joueur[2];
		this.plateau = new Plateau();
		this.iFabrique = iFabrique;
	}

	public void initJoueur() {
		joueurs[0] = iFabrique.creerJoueur("pierre", Camp.Sud, plateau);
		joueurs[1] = iFabrique.creerJoueur("paul", Camp.Nord, plateau);
	}

	public static void main(String[] args) {
		Plateau plateau = new Plateau ();
		System.out.println(plateau.toString());
		
		
	}
}
