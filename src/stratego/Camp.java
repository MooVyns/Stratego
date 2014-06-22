package stratego;

public enum Camp {

	Nord("Nord","^"), 
	Sud("Sud", "~"),
	Centre("Centre","-"),
	Indisponible("Indisponible"," ");

	private String nom;
	private String representation;
	
	Camp(String nom, String representation) {
		this.nom = nom;
		this.representation = representation;
	}

	public String toString() {
		return this.nom;
	}
	
	public String getRepresentation(){
		return this.representation;
	}

}
