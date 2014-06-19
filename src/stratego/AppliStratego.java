package stratego;

import ihm.ConsoleIHM;
import joueur.FabriqueJoueur;
import joueur.Joueur;

public class AppliStratego {
	private AbstractJoueur[] joueurs;
	private Plateau plateau;
	private IFabriqueJoueur iFabrique;
	private IHM ihm;
	

	public AppliStratego(IFabriqueJoueur iFabrique, IHM ihm) {
		this.joueurs = new Joueur[2];
		this.plateau = new Plateau();
		this.iFabrique = iFabrique;
		this.ihm = ihm;
	}

	public void initJoueur() {
		ihm.EntrerNomJoueur();
		joueurs[0] = iFabrique.creerJoueur(ihm.getNomJoueur(), Camp.Sud, plateau);
		ihm.EntrerNomJoueur();
		joueurs[1] = iFabrique.creerJoueur(ihm.getNomJoueur(), Camp.Nord, plateau);
		ihm.afficherNomJoueur(joueurs[0]);
		ihm.afficherNomJoueur(joueurs[1]);
	}
	
	public void PlacementDesPieces(){
		for(int i = 0; i <joueurs.length; i++){
			while(true){
				//joueurs[i].placerPiece(coord, type);
			}
		}
	}
	

	public static void main(String[] args) {
		AppliStratego app = new AppliStratego(new FabriqueJoueur(),new ConsoleIHM());
		app.initJoueur();		
	}
}
