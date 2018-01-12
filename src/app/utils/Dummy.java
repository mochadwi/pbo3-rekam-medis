package app.utils;

import app.models.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mochadwi
 */

public class Dummy {
    public static List<Patient> getPatients() {
        List<Patient> patients = new ArrayList<>();

        patients.add(new Patient("101", "nama org", "19", "tuisba", "SE", "Male", "0812341234",
                "0820834123412", "married"));
        patients.add(new Patient("102", "nama org", "19", "tuisba", "SE", "Male", "0812341234",
                "0820834123412", "married"));
        patients.add(new Patient("103", "nama org", "19", "tuisba", "SE", "Male", "0812341234",
                "0820834123412", "married"));

        return patients;
    }
}
