package app.utils;

import net.sf.persist.Persist;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author mochadwi
 */
public class Db {

    private String usernameDb = "nawkgwclpwtjif";
    private String passwordDb = "eaebcfbf0ce51a3eea975049ba9d1cc8f526b3098a62e980d609a4cde6e9e438";
    private String dbName = "d5cl9lkgh000i6";
    private String schemeName = "rekam_medis_db";
    private String host = "ec2-107-20-193-202.compute-1.amazonaws.com";
    private String port = "5432";

    private Persist persist;

    private static Db instance = null;

    private Db() {
        // Exists only to defeat instantiation.
        String urlWithSchema = "jdbc:postgresql://" + host + ":" + port + "/" + dbName + "?sslmode=require&currentSchema=" + schemeName + "&user=" + usernameDb + "&password=" + passwordDb;
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