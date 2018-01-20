package app;

import app.utils.Status;
import app.views.doctor.DoctorPresenter;
import app.views.doctor.DoctorView;
import app.views.login.LoginPresenter;
import app.views.login.LoginView;
import app.views.medicalrecord.MedicalRecordPresenter;
import app.views.medicalrecord.MedicalRecordView;
import app.views.medicine.MedicinePresenter;
import app.views.medicine.MedicineView;
import app.views.menu.MenuPresenter;
import app.views.menu.MenuView;
import app.views.patient.PatientPresenter;
import app.views.patient.PatientView;

public class Dashboard {

    // store state / session of apps
    public static Status status = Status.MEDICALRECORD;

    public static void main(String[] args) {

        switch (status) {
            case STOP:

                // do nothing or exit?
                System.exit(status.getAbbreviation());
                break;
            case MENU:

                initMenu();
                break;

            case PATIENT:

                initPatient();
                break;

            case DOCTOR:

                initDoctor();
                break;
                
            case MEDICINE:
                
                initMedicine();
                break;
                
            case MEDICALRECORD:

                initMedicalRecord();
                break;
                
            default:
                initDefault();
        }

        main(args); // restart apps
    }

    private static void initDefault() {
        initLogin();
//        initRegist();
    }

    private static void initMedicalRecord() {
        MedicalRecordPresenter medicalRecordPresenter = new MedicalRecordPresenter();
        MedicalRecordView medicalRecordView = new MedicalRecordView();
        
        medicalRecordPresenter.bind(medicalRecordView);
        medicalRecordView.setPresenter(medicalRecordPresenter);
        
        medicalRecordView.showView();
    }

    private static void initMedicalRecord() {
        MedicalRecordPresenter medicalRecordPresenter = new MedicalRecordPresenter();
        MedicalRecordView medicalRecordView = new MedicalRecordView();
        
        medicalRecordPresenter.bind(medicalRecordView);
        medicalRecordView.setPresenter(medicalRecordPresenter);
        
        medicalRecordView.showView();
    }

    private static void initMedicine() {
        MedicinePresenter medicinePresenter = new MedicinePresenter();
        MedicineView medicineView = new MedicineView();
        
        medicinePresenter.bind(medicineView);
        medicineView.setPresenter(medicinePresenter);
        
        medicineView.showView();
    }
    
    private static void initDoctor() {
        DoctorPresenter doctorPresenter = new DoctorPresenter();
        DoctorView doctorView = new DoctorView();

        doctorPresenter.bind(doctorView);
        doctorView.setPresenter(doctorPresenter);

        doctorView.showView();
    }

    private static void initPatient() {

        PatientPresenter patientPresenter = new PatientPresenter();
        PatientView patientView = new PatientView();

        patientPresenter.bind(patientView);
        patientView.setPresenter(patientPresenter);

        patientView.showView();
    }

    private static void initMenu() {

        MenuPresenter menuPresenter = new MenuPresenter();
        MenuView menuView = new MenuView();

        menuPresenter.bind(menuView);
        menuView.setPresenter(menuPresenter);

        menuView.showView();
    }

    private static void initRegist() {

        status = Status.AUTH;
    }

    private static void initLogin() {

        LoginPresenter loginPresenter = new LoginPresenter();
        LoginView loginView = new LoginView();

        loginPresenter.bind(loginView);
        loginView.setPresenter(loginPresenter);

        loginView.showView();
    }
}
