package app.views.login;

import app.BasePresenter;
import app.BaseView;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void showView();
        void showLoginErrorView(String errMsg);
        void showLoginSuccessView();
    }

    interface Presenter extends BasePresenter<View> {
        void login(String name, String pass);
        boolean isLoggedIn(String name, String pass);
    }
}