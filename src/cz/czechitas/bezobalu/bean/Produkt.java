package cz.czechitas.bezobalu.bean;

public class Produkt {
	private String nazev;
	private int idProduktu;
	private float cena;
	private int idKategorie;
		
	public String getNazev() {
		return nazev;
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}

	public int getIdProduktu() {
		return idProduktu;
	}

	public void setIdProduktu(int idProduktu) {
		this.idProduktu = idProduktu;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public int getIdKategorie() {
		return idKategorie;
	}

	public void setIdKategorie(int idKategorie) {
		this.idKategorie = idKategorie;
	}

	public Produkt(String nazev, int idProduktu, float cena, int idKategorie) {
		super();
		this.nazev = nazev;
		this.idProduktu = idProduktu;
		this.cena = cena;
		this.idKategorie = idKategorie;
	}

	public Produkt() {
		
	}

}
