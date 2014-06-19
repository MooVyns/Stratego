package ihm;

import java.util.Scanner;

import stratego.AbstractJoueur;
import stratego.IHM;
import stratego.Plateau;

public class ConsoleIHM implements IHM {
	private Scanner sc;

	public ConsoleIHM() {
		sc = new Scanner(System.in);
	}

	@Override
	public void afficherPlateau(Plateau plateau) {
		System.out.println(plateau.toString());
	}

	@Override
	public String getNomJoueur() {
		return sc.next();
	}

	public void EntrerNomJoueur() {
		System.out.println("Entrez votre nom");
	}

	@Override
	public void afficherNomJoueur(AbstractJoueur joueur) {
		System.out.println(joueur.getNom());
	}
	

}
