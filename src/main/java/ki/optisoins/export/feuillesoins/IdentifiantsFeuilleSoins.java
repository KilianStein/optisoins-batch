package ki.optisoins.export.feuillesoins;

public enum IdentifiantsFeuilleSoins {
	DEFAULT("default"),
	IRN_2012020199("irn_2012020199");
	
	private final String repertoire;
	IdentifiantsFeuilleSoins(String repertoire){
		this.repertoire = repertoire;
	}
	
	public String getRepertoire() {
		return repertoire;
	}
}