package stratego;

import java.util.Scanner;

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
		String[] noms = ihm.saisieNomJoueur();
		for (int i = 0; i < noms.length; i++) {
			joueurs[i] = iFabrique.creerJoueur(noms[i], Camp.values()[i],
					plateau);
		}
	}

	public void PlacementDesPieces() {
		for (int i = 0; i < joueurs.length; i++) {
			ihm.afficherString(joueurs[i].getNom()
					+ ", à vous de placer vos pions");
			while (!joueurs[i].getReserve().estVide()) {
				TypePiece type = ihm.choixPiece(joueurs[i]);
				String coord = ihm.choixCoordonnees();
				joueurs[i].placerPiece(coord, type);
				ihm.afficherPlateau(plateau);
			}
		}
		System.out.println("Que Souhaitez-vous Faire ?");
		Scanner sc = new Scanner(System.in);
		System.out.println("Je souhaite retirer une piece :");
		System.out.println("Je souhaite Ajouter une piece :");
		String rep = sc.next();
		for (int i = 0; i < joueurs.length; i++) 
		{
		if (rep == "oui") {
 			ihm.choixCoordonnees();
         	joueurs[i].retirerPiece(ihm.choixCoordonnees());
			}

		}
	}
	
	public void deroulementPartie(){
		
	}
	
	
	public void sauvegarderPartie(){
		
	}
	
	public void chargerPartie(){
		
	}

	public static void main(String[] args) {
		AppliStratego app = new AppliStratego(new FabriqueJoueur(),
				new ConsoleIHM());
		System.out.println(app.plateau.testdessin());
		app.initJoueur();
		app.PlacementDesPieces();
		
	}
	
}
