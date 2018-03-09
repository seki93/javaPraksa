package hello.model;

public enum Supporter {
	
	NISTAPAMETNO(" "),
	OBOZAVA("o"),
	NAVIJA("n"),
	PODRZAVA("p"),
	SIMPATISE("s");
	
	String nesto;
	
	Supporter (String nesto) {
		this.nesto = nesto;
	}
	
	public String nesto() {
		return nesto;
	}

}
