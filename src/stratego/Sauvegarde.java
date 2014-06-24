package stratego;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Sauvegarde {
	private final static String FICHIERSAUVEGARDE = "sauvegarde.txt";	
	
	public static void creerFichierSauvegarde(){
		File f = new File(FICHIERSAUVEGARDE);
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static void sauvegarderPartie(String s){
		creerFichierSauvegarde();
		try {

			PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(FICHIERSAUVEGARDE)));
			p.write(s);
			p.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public void chargerPartie(){
		
	}
}
