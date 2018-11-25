package cz.czechitas.bezobalu.dao;

import java.sql.Connection;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cz.czechitas.bezobalu.bean.Produkt;

public class JdbcDao {
	private static final String FILTRUJPRODUKTY = "SELECT p.* FROM produkt p JOIN spojovacitabulka st ON p.id = st.idproduktu WHERE st.idmesta = ? AND p.idKategorie=? ORDER BY p.nazev ASC";
	private static final String FILTRUJKATEGORIE = "SELECT DISTINCT k.* FROM kategorie k JOIN produkt p ON p.idKategorie = k.id JOIN spojovacitabulka st ON p.id = st.idproduktu WHERE idmesta = ? ORDER BY k.nazev";


	private DataSource getDataSource() {
        try {
            Context ctx = new InitialContext();
            return (DataSource)ctx.lookup("java:/comp/env/jdbc/bezobaluCloudDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }
	public ArrayList<Produkt> filtrujProdukty(int idMesta, int idKategorie) {

		ArrayList<Produkt> ret = new ArrayList<Produkt>();
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(FILTRUJPRODUKTY)) {
			stmt.setInt(1, idMesta);
			stmt.setInt(2, idKategorie);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { // toto zaridi ze jedeme po radku na konec seznamu
				Produkt produkt = new Produkt();
				produkt.setId(rs.getInt("id"));
				produkt.setCena(rs.getFloat("cena"));
				produkt.setNazev(rs.getString("nazev"));
				ret.add(produkt);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public ArrayList<Kategorie> filtrujKategorie(int idMesta) {

		ArrayList<Kategorie> ret = new ArrayList<Kategorie>();
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(FILTRUJKATEGORIE)) {
			stmt.setInt(1, idMesta);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { // toto zaridi ze jedeme po radku na konec seznamu
				Kategorie kategorie = new Kategorie();
				kategorie.setId(rs.getInt("id"));
				kategorie.setNazev(rs.getString("nazev"));
				ret.add(kategorie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
