package ihm;

import java.util.Scanner;

import stratego.AbstractJoueur;
import stratego.AbstractPlateau;
import stratego.IEnumDirection;
import stratego.IHM;
import stratego.OperationCoordonnées;
import stratego.TypePiece;

public class ConsoleIHM implements IHM {
	private Scanner sc;

	public ConsoleIHM() {
		sc = new Scanner(System.in);
	}

	@Override
	public void afficherPlateau(AbstractPlateau plateau) {
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

	// ok
	@Override
	public TypePiece choixPiece(AbstractJoueur j) {
		System.out.println("Quelle pièce voulez vous placer ?");
		for (int i = 0; i < TypePiece.values().length; i++)
			System.out.println(TypePiece.values()[i].getRepresentation()
					+ "  => "
					+ TypePiece.values()[i].toString()
					+ "  "
					+ (j.getReserve().getNombrePieceDisponible(TypePiece
							.values()[i])) + " pièce(s) disponible(s)");
		String choix;

		do {
			choix = sc.next().toUpperCase();
			if (!TypePiece.exist(choix))
				System.out
						.println("Cette piece n'existe pas ! Choisissez votre pièce");
		} while (!TypePiece.exist(choix));

		return TypePiece.getTypePiece(choix);
	}

	// faire verif
	public String choixCoordonnees(AbstractPlateau plateau) {
		System.out.println("Entrez les coordonnées");
		String coord;
		do {
			coord = sc.next().toUpperCase();
			if (!OperationCoordonnées.verfiCoordonnees(coord, plateau)) {
				System.out
						.println("Coordonnées incorrects ! Entrez de nouvelles coordonnées");
			}
		} while (!OperationCoordonnées.verfiCoordonnees(coord, plateau));
		return coord;
	}

	public void afficherString(String str) {
		System.out.println(str);
	}

	public String retirerPiece(AbstractPlateau plateau) {
		System.out.println("Quelle pièce voulez vous retirer ?");
		return this.choixCoordonnees(plateau);
	}

	// ok
	@Override
	public IEnumDirection choixDirection(IEnumDirection enumDir) {
		System.out
				.println("Dans quelle direction voulez vous deplacez la piece ?");
		for (int i = 0; i < enumDir.enumeration().length; i++)
			System.out.println(enumDir.enumeration()[i].getRepresentation()
					+ " => " + enumDir.enumeration()[i].toString());
		String dir;

		do {
			dir = sc.next().toUpperCase();
			if (!enumDir.exist(dir))
				System.out
						.println("Cette direction n'existe pas ! Entrez une nouvelle direction");
		} while (!enumDir.exist(dir));

		return enumDir.getDirection(dir);
	}

	private boolean estUnNombre(String chaine) {
		for (int i = 0; i < chaine.length(); i++) {
			if (chaine.charAt(i) < '0' || chaine.charAt(i) > '9')
				return false;
		}
		return true;
	}

	// faire verif
	public int choixNbCases() {
		String num;
		System.out.println("De combien de cases voulez vous bouger la pièce ?");

		do {
			num = sc.next();
			if (!estUnNombre(num)) {
				System.out.println("Nombre indisponible ! Retapez un nombre");
			}
		} while (!estUnNombre(num));
		return Integer.parseInt(num);
	}

	// ok
	@Override
	public String choixActionPlacementPiece() {
		System.out.println("Que Souhaitez-vous Faire ?");
		System.out.println("R => Je souhaite retirer une piece :");
		System.out.println("A => Je souhaite Ajouter une piece :");
		String rep;
		do {
			rep = sc.next().toUpperCase();
			if (!rep.equals("A") && !rep.equals("R"))
				System.out
						.println("Ce choix n'est pas disponible ! Reformulez votre choix");
		} while (!rep.equals("A") && !rep.equals("R"));

		return rep;
	}

}
