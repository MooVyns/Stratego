package ihm;

import java.util.Scanner;


import stratego.IHM;
import stratego.Plateau;
import stratego.TypePiece;

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

	@Override
	public TypePiece choixPiece() {
		System.out.println("Quelle pièce voulez vous placer ?");
		for (int i = 0; i < TypePiece.values().length; i++)
			System.out.println(i +"  " +TypePiece.values()[i].toString());		
		//Ajouter la verification
		String choix = sc.next();		
		return TypePiece.values()[Integer.parseInt(choix)];
	}
	
	
	public String choixCoordonnees(){
		System.out.println("A quelle endroit ?");
		return sc.next();
	}
	
	public void afficherString(String str){
		System.out.println(str);
	}
}
