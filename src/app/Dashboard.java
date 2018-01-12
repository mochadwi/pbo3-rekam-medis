package app;

import app.utils.Status;
import app.views.doctor.DoctorPresenter;
import app.views.doctor.DoctorView;
import app.views.login.LoginPresenter;
import app.views.login.LoginView;
import app.views.menu.MenuPresenter;
import app.views.menu.MenuView;

public class Dashboard {

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

            case DATA:

                initPatient();
                initDoctor();
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

    }

    private static void initMenu() {

        status = Status.MENU;

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

        status = Status.AUTH;

        LoginPresenter loginPresenter = new LoginPresenter();
        LoginView loginView = new LoginView();

        loginPresenter.bind(loginView);
        loginView.setPresenter(loginPresenter);

        loginView.showView();
    }
}
