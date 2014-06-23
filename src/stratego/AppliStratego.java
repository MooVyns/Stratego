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
			this.plateau.cacherPieces(joueurs[(i + 1) % 2].getCamp());
			ihm.afficherString(joueurs[i].getNom()
					+ ", � vous de placer vos pions");
			while (!joueurs[i].getReserve().estVide()) {

				System.out.println("Que Souhaitez-vous Faire ?");
				Scanner sc = new Scanner(System.in);
				System.out.println(" R => Je souhaite retirer une piece :");
				System.out.println(" A => Je souhaite Ajouter une piece :");
				String rep = sc.next();
				if (rep.equals("R")) {
					joueurs[i].retirerPiece(ihm.choixCoordonnees());
					ihm.afficherPlateau(plateau);
				} else {
					TypePiece type = ihm.choixPiece(joueurs[i]);
					String coord = ihm.choixCoordonnees();
					joueurs[i].placerPiece(coord, type);
					ihm.afficherPlateau(plateau);
				}
			}
		}

	}

	public void deroulementPartie() {
		for (int i = 0; i < joueurs.length; i++) {
			this.plateau.rendreVisiblePieces(joueurs[i].getCamp());
			this.plateau.cacherPieces(joueurs[(i + 1) % 2].getCamp());
			ihm.afficherPlateau(plateau);
			System.out.println(joueurs[i].getNom()
					+ "Quelle piece voulez vous jouer ?");
			joueurs[i].jouer(Direction.bas, 1, ihm.choixCoordonnees());
		}

	}

	public void sauvegarderPartie() {

	}

	public void chargerPartie() {

	}

	public static void main(String[] args) {
		AppliStratego app = new AppliStratego(new FabriqueJoueur(),
				new ConsoleIHM());
		System.out.println(app.plateau.testdessin());
		app.initJoueur();
		app.PlacementDesPieces();

		app.deroulementPartie();

	}

}
