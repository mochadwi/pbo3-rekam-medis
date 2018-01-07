package app;

import app.views.login.LoginPresenter;
import app.views.login.LoginView;

public class Dashboard {

    public static void main(String[] args) {
        initLogin();
        initMenu();
    }

    private static void initMenu() {

    }

    private static void initLogin() {
        LoginPresenter loginPresenter = new LoginPresenter();
        LoginView loginView = new LoginView();

        loginPresenter.bind(loginView);
        loginView.setPresenter(loginPresenter);

        loginView.showView();
    }
}
