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
		System.out.println("Quelle pi�ce voulez vous placer ?");
		for (int i = 0; i < TypePiece.values().length; i++)
			System.out.println(TypePiece.values()[i].representation()
					+ "  => "
					+ TypePiece.values()[i].toString()
					+ "  "
					+ (j.getReserve().getNombrePieceDisponible(TypePiece
							.values()[i])) + " pi�ce(s) disponible(s)");
		String choix = sc.next().toUpperCase();
		/*
		 * while () { System.out
		 * .println("La pi�ce non identifi�e. Tapez un nombre entre 0 et 12.");
		 * 
		 * }
		 */
		return TypePiece.getTypePiece(choix);
	}

	public String choixCoordonnees() {
		System.out.println("Entrez les coordonn�es");
		return sc.next().toUpperCase();
	}

	public void afficherString(String str) {
		System.out.println(str);
	}

	public String retirerPiece() {
		System.out.println("Quelle pi�ce voulez vous retirer ?");
		return this.choixCoordonnees();
	}

	@Override
	public IEnumDirection choixDirection(IEnumDirection enumDir) {
		System.out
				.println("Dans quelle direction voulez vous deplacez la piece ?");
		for (int i = 0; i < enumDir.enumeration().length; i++)
			System.out.println(enumDir.enumeration()[i].getRepresentation()
					+ " => " + enumDir.enumeration()[i].toString());

		String dir = sc.next().toUpperCase();
		return enumDir.getDirection(dir);
	}

	public int choixNbCases() {
		System.out.println("De combien de cases voulez vous bouger la pi�ce ?");
		return Integer.parseInt(sc.next());
	}

	@Override
	public String choixActionPlacementPiece() {
		System.out.println("Que Souhaitez-vous Faire ?");
		System.out.println("R => Je souhaite retirer une piece :");
		System.out.println("A => Je souhaite Ajouter une piece :");
		String rep = sc.next().toUpperCase();
		return rep;
	}

}
