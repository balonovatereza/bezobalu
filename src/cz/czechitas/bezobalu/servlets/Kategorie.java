package cz.czechitas.bezobalu.servlets;

public class Kategorie {
	
	private int idKategorie;
	private String nazev;
	
	public Kategorie(int idKategorie, String nazev) {
		this.idKategorie=idKategorie;
		this.nazev=nazev;
	}
	
	
	public int getIdKategorie() {
		return idKategorie;
	}
	public void setIdKategorie(int idKategorie) {
		this.idKategorie = idKategorie;
	}
	public String getNazev() {
		return nazev;
	}
	public void setNazev(String nazev) {
		this.nazev = nazev;
	}

}
