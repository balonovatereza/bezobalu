package cz.czechitas.bezobalu.bean;

public class Kategorie {
	private int id;
	private String nazev;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazev() {
		return nazev;
	}
	public void setNazev(String nazev) {
		this.nazev = nazev;
	}
	public Kategorie(int id, String nazev) {
		super();
		this.id = id;
		this.nazev = nazev;
	}
	public Kategorie () {
		
	}
}
