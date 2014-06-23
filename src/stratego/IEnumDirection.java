package stratego;

public interface IEnumDirection {
	public int getLigne();

	public int getColonne();

	public IEnumDirection[] enumeration();

	public String getRepresentation();

	public IEnumDirection getDirection(String dir);
}
