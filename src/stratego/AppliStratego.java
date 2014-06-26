package stratego;

import plateau.Direction;
import plateau.Plateau;
import ihm.ConsoleIHM;
import joueur.FabriqueJoueur;
import joueur.Joueur;

public class AppliStratego {
	private AbstractJoueur[] joueurs;
	private AbstractPlateau plateau;
	private IFabriqueJoueur iFabrique;
	private IHM ihm;
	private IEnumDirection enumDir;

	public AppliStratego(IFabriqueJoueur iFabrique, IHM ihm,
			IEnumDirection enumDir) {
		this.joueurs = new Joueur[2];
		this.plateau = new Plateau(7, 9);
		this.iFabrique = iFabrique;
		this.ihm = ihm;
		this.enumDir = enumDir;
	}

	public void initJoueur() {
		ihm.afficherPlateau(plateau);
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
					+ ", à vous de placer vos pions");
			while (!joueurs[i].getReserve().estVide()) {
				if (ihm.choixActionPlacementPiece().equals("R")) {
					joueurs[i].retirerPiece(ihm.retirerPiece());
					ihm.afficherPlateau(plateau);
				} else if (ihm.choixActionPlacementPiece().equals("A")){
					TypePiece type = ihm.choixPiece(joueurs[i]);
					String coord = ihm.choixCoordonnees();
					joueurs[i].placerPiece(coord, type);
					ihm.afficherPlateau(plateau);
				}
			}
		}

	}

	public void deroulementPartie() {
		while (true) {
			for (int i = 0; i < joueurs.length; i++) {
				this.plateau.rendreVisiblePieces(joueurs[i].getCamp());
				this.plateau.cacherPieces(joueurs[(i + 1) % 2].getCamp());
				ihm.afficherPlateau(plateau);
				do {// tant qu'il y a une erreur
					ihm.afficherString(joueurs[i].getNom()
							+ ", Quelle piece voulez vous jouer ?");
				} while (!joueurs[i].jouer(ihm.choixCoordonnees(),
						ihm.choixDirection(enumDir), ihm.choixNbCases()));
			}
		}
	}

	public boolean partieFinie() {
		return true;
	}

	public void sauvegarderPartie() {

	}

	public void chargerPartie() {

	}

	public static void main(String[] args) {
		AppliStratego app = new AppliStratego(new FabriqueJoueur(),
				new ConsoleIHM(), Direction.values()[0]);
		app.initJoueur();
		app.PlacementDesPieces();
		app.deroulementPartie();
	}

}
