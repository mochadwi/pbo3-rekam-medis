package app;

import app.utils.Status;
import app.views.doctor.DoctorPresenter;
import app.views.doctor.DoctorView;
import app.views.login.LoginPresenter;
import app.views.login.LoginView;
import app.views.menu.MenuPresenter;
import app.views.menu.MenuView;
import app.views.patient.PatientPresenter;
import app.views.patient.PatientView;

public class Dashboard {

    // store state / session of apps
    public static Status status = Status.DATA;

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

            case TRANSACTION:

                initTransaction();
                break;

            default:
                initDefault();
        }

        main(args); // restart apps
    }

    private static void initDefault() {
        initLogin();
        initRegist();

        status = Status.MENU;
    }

    private static void initTransaction() {

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

        status = Status.MENU;
    }
}
