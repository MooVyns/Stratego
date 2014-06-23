package ihm;

import java.util.Scanner;

import plateau.Plateau;
import stratego.AbstractJoueur;
import stratego.IEnumDirection;
import stratego.IHM;
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
	public TypePiece choixPiece(AbstractJoueur j) {
		System.out.println("Quelle pièce voulez vous placer ?");
		for (int i = 0; i < TypePiece.values().length; i++)
			System.out.println(TypePiece.values()[i].representation()
					+ "  => "
					+ TypePiece.values()[i].toString()
					+ "  "
					+ (j.getReserve().getNombrePieceDisponible(TypePiece
							.values()[i])) + " pièce(s) disponible(s)");
		String choix = sc.next().toUpperCase();
		/*
		 * while () { System.out
		 * .println("La pièce non identifiée. Tapez un nombre entre 0 et 12.");
		 * 
		 * }
		 */
		return TypePiece.getTypePiece(choix);
	}

	public String choixCoordonnees() {
		System.out.println("Entrez les coordonnées");
		return sc.next().toUpperCase();
	}

	public void afficherString(String str) {
		System.out.println(str);
	}

	public String retirerPiece() {
		System.out.println("Quelle pièce voulez vous retirer ?");
		return this.choixCoordonnees();
	}

	@Override
	public IEnumDirection choixDirection(IEnumDirection enumDir) {
		System.out.println("Dans quelle direction voulez vous deplacez la piece ?");
		for (int i = 0; i < enumDir.enumeration().length; i++)
			System.out.println(enumDir.enumeration()[i].getRepresentation());
		
		String dir = sc.next();		
		return enumDir.getDirection(dir);
	}

}
