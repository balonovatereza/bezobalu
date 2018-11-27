package cz.czechitas.bezobalu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cz.czechitas.bezobalu.bean.Kategorie;
import cz.czechitas.bezobalu.bean.Mesto;
import cz.czechitas.bezobalu.bean.Produkt;

public class JdbcDao {
	private static final String VYFILTRUJPRODUKTY = "SELECT p.* FROM produkt p JOIN spojovacitabulka st ON p.id = st.idproduktu WHERE st.idmesta = ? AND p.idKategorie=? ORDER BY p.nazev ASC";
	private static final String VYFILTRUJKATEGORIE = "SELECT DISTINCT k.* FROM kategorie k JOIN produkt p ON p.idKategorie = k.id JOIN spojovacitabulka st ON p.id = st.idproduktu WHERE idmesta = ? ORDER BY k.nazev";
	private static final String NAJDICENU = "SELECT cena FROM produkt p WHERE p.id = ?";
	private static final String VRATMESTA = "SELECT * FROM mesto ORDER BY nazev;";
	private static final String VRATPRODUKT = "SELECT p.nazev FROM produkt p WHERE p.id = ?";
	private static final String VRATKATEGORII = "SELECT k.nazev FROM kategorie k WHERE k.id = ?";

	private DataSource getDataSource() {
		try {
			Context ctx = new InitialContext();
			return (DataSource) ctx.lookup("java:/comp/env/bezobaluResource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Produkt> vyfiltrujProdukty(int idMesta, int idKategorie) {

		ArrayList<Produkt> ret = new ArrayList<Produkt>(); //
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(VYFILTRUJPRODUKTY)) {
			stmt.setInt(1, idMesta);
			stmt.setInt(2, idKategorie);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { // toto zaridi ze jedeme po radku na konec seznamu
				Produkt produkt = new Produkt();
				produkt.setIdProduktu(rs.getInt("id"));
				produkt.setCena(rs.getFloat("cena"));
				produkt.setNazev(rs.getString("nazev"));
				ret.add(produkt);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public ArrayList<Kategorie> vyfiltrujKategorie(int idMesta) {

		ArrayList<Kategorie> ret = new ArrayList<Kategorie>();
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(VYFILTRUJKATEGORIE)) {
			stmt.setInt(1, idMesta);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { // toto zaridi ze jedeme po radku na konec seznamu
				Kategorie kategorie = new Kategorie();
				kategorie.setIdKategorie(rs.getInt("id"));
				kategorie.setNazev(rs.getString("nazev"));
				ret.add(kategorie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public float najdiCenu(int idProduktu) {
		float cena = 0;
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(NAJDICENU)) {
			stmt.setInt(1, idProduktu);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				cena = rs.getFloat("cena");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cena;
	}

	public ArrayList<Mesto> vratMesta() {

		ArrayList<Mesto> ret = new ArrayList<Mesto>();
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(VRATMESTA)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Mesto mesto = new Mesto();
				mesto.setIdMesta(rs.getInt("id"));
				mesto.setNazev(rs.getString("nazev"));
				ret.add(mesto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public Produkt vratProdukt(int idProduktu) {
		Produkt produkt = null;
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(VRATPRODUKT)) {
			stmt.setInt(1, idProduktu);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				produkt = new Produkt();
				produkt.setNazev(rs.getString("nazev"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produkt;
	}

	public Kategorie vratKategorii(int idKategorie) {
		Kategorie kategorie = null;
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(VRATKATEGORII)) {
			stmt.setInt(1, idKategorie);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				kategorie = new Kategorie();
				kategorie.setNazev(rs.getString("nazev"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kategorie;
	}
}
