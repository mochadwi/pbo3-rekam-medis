package app.views.menu;

import app.BasePresenter;
import app.BaseView;

public interface MenuContract {

    interface View extends BaseView<Presenter> {

        void showView();

        void showMenuErrorView();

        void showMenuSuccesView();
    }

    interface Presenter extends BasePresenter<View> {
        
        void menu(String mPilihan);        
    }
}
