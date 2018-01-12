package app.utils;

import net.sf.persist.Persist;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author mochadwi
 */

public class Db {

    private String usernameDb = "mochadwi";
    private String passwordDb = "";
    private String dbName = "rekam_medis_db";
    private String host = "localhost";
    private String port = "5432";

    public static Persist persist;

    public Db() {
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbName + "?user=" + usernameDb + "&password=" + passwordDb;
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url);
            System.out.println("Hello, postgresql driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        persist = new Persist(conn);
    }
}
