package app.views.login;

import app.utils.Strings;

public class LoginPresenter implements LoginContract.Presenter {

    private int attempts = 0;

    private LoginContract.View view;

    @Override
    public void login(String name, String pass) {
        view.showLoading();

        if (isLoggedIn(name, pass)) {
            if (attempts == 2) { // mulai dari 0
                view.showLoginAttemptFailed();

                return;
            }

            view.showLoginSuccessView();
        }
    }

    @Override
    public boolean isLoggedIn(String name, String pass) {

        if ((!name.equals(Strings.mNamaPengguna) || !pass.equals(Strings.mKataSandi)) && attempts < 2) {
            attempts++;
            view.showLoginErrorView();
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
