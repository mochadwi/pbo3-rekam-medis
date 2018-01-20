package app.utils;

import net.sf.persist.Persist;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author mochadwi
 */
public class Db {

    private String usernameDb = "postgres";
    private String passwordDb = "    ";
    private String dbName = "postgres";
    private String schemeName = "rekam_medis_db";
    private String host = "localhost";
    private String port = "5432";

    private Persist persist;

    private static Db instance = null;

    private Db() {
        // Exists only to defeat instantiation.
        String urlWithSchema = "jdbc:postgresql://" + host + ":" + port + "/" + dbName + "?currentSchema=" + schemeName + "&user=" + usernameDb + "&password=" + passwordDb;
//        String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbName + "?user=" + usernameDb + "&password=" + passwordDb;
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(urlWithSchema);
            System.out.println("Hello, postgresql driver connected to:"
                    + "\n" + urlWithSchema);
        } catch (Exception e) {
            e.printStackTrace();
        }

        persist = new Persist(conn);
    }

    public static synchronized Db getInstance() {
        if (instance == null) {
            synchronized (Db.class) {
                if (instance == null) {
                    instance = new Db();
                }
            }
        }
        return instance;
    }

    public Persist initPersist() {
        return this.persist;
    }
}
