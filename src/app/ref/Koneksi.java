package app.ref;
import java.sql.*;
public class Koneksi {
    String user     = "root";
    String pass     = "";
    String db       = "db_perpustakaan"; 
    String urlValue = "jdbc:mysql://localhost:3306/"+db;
    // Accessible to outside package
    public static Connection conn = null;
    public static Statement state = null;
    
    public Koneksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(urlValue,user,pass);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
