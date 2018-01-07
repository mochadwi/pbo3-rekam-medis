package app;

import app.views.login.LoginPresenter;
import app.views.login.LoginView;
import app.views.menu.MenuPresenter;
import app.views.menu.MenuView;

public class Dashboard {

    public static void main(String[] args) {
        initLogin();
        initMenu();
    }

    private static void initMenu() {
        MenuPresenter menuPresenter = new MenuPresenter();
        MenuView menuView = new MenuView();

        menuPresenter.bind(menuView);
        menuView.setPresenter(menuPresenter);

        menuView.showView();
    }

    private static void initLogin() {
        LoginPresenter loginPresenter = new LoginPresenter();
        LoginView loginView = new LoginView();

        loginPresenter.bind(loginView);
        loginView.setPresenter(loginPresenter);

        loginView.showView();
    }
}
