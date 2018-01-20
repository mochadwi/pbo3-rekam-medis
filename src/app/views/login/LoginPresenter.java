package app.views.login;

import app.Dashboard;
import app.utils.Status;
import app.utils.Strings;

import static app.Dashboard.status;

public class LoginPresenter implements LoginContract.Presenter {

    private int attempts = 0;

    private LoginContract.View view;

    @Override
    public void login(String name, String pass) {
        view.showLoading();

        if (isLoggedIn(name, pass)) {
            if (attempts == 2) { // mulai dari 0
                view.showLoginErrorView("Kesempatan anda habis!\n\n");

                Dashboard.status = Status.STOP;
                return;
            }

            view.showLoginSuccessView();
            Dashboard.status = Status.MENU;
        }
    }

    @Override
    public boolean isLoggedIn(String name, String pass) {

        if ((!name.equals(Strings.mNamaPengguna) || !pass.equals(Strings.mKataSandi)) && attempts < 2) {
            attempts++;
            view.showLoginErrorView("Nama dan sandi salah, silakan ulangi!\n\n");
            view.showView();

            return false;
        }

        return true;
    }

    @Override
    public void bind(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void unBind() {
        this.view = null;
    }
}
