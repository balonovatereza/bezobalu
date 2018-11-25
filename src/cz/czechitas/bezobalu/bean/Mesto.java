package cz.czechitas.bezobalu.bean;

public class Mesto {
private int idMesta;
private String nazev;

public int getIdMesta() {
	return idMesta;
}
public void setIdMesta(int idMesta) {
	this.idMesta = idMesta;
}
public String getNazev() {
	return nazev;
}
public void setNazev(String nazev) {
	this.nazev = nazev;
}
public Mesto(int idMesta, String nazev) {
	super();
	this.idMesta = idMesta;
	this.nazev = nazev;
}
}
