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
	public String[] saisieNomJoueur() {
		String[] noms = new String[2];
		for (int i = 1; i <= noms.length; i++) {
			System.out.println("Joueur " + i + ", Entrez votre nom");
			noms[i - 1] = sc.next();
		}
		return noms;
	}

}
