package app.utils;

import app.models.DataPasien;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mochadwi
 */

public class Dummy {
    public static List<DataPasien> getPatients() {
        List<DataPasien> dataPasiens = new ArrayList<>();

        dataPasiens.add(new DataPasien("101", "nama org", "19", "tuisba", "SE", "Male", "0812341234",
                "married", "0820834123412", 1));
        dataPasiens.add(new DataPasien("102", "nama org", "19", "tuisba", "SE", "Male", "0812341234",
                "married", "0820834123412", 1));
        dataPasiens.add(new DataPasien("103", "nama org", "19", "tuisba", "SE", "Male", "0812341234",
                "married", "0820834123412", 1));

        return dataPasiens;
    }
}
