package cz.czechitas.bezobalu.bean;

public class Produkt {
	private String nazev;
	private int id;
	private float cena;
	public String getNazev() {
		return nazev;
	}
	public void setNazev(String nazev) {
		this.nazev = nazev;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getCena() {
		return cena;
	}
	public void setCena(float cena) {
		this.cena = cena;
	}
	public Produkt(String nazev, int id, float cena) {
		super();
		this.nazev = nazev;
		this.id = id;
		this.cena = cena;
	}
	
	public Produkt() {
		
	}

}
