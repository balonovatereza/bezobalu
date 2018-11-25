package cz.czechitas.bezobalu.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
	

}
