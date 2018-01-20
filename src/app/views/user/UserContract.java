/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.user;

import app.BasePresenter;
import app.BaseView;
import app.models.DataUser;
import java.util.List;

/**
 *
 * @author G-Eight
 */
public interface UserContract {
    interface View extends BaseView<Presenter> {

        void showView();

        void showCreateDataView();

        void showReadDataView();

        void showUpdateDataView();

        void showDeleteDataView();

        void showMenuErrorView();

        void showMenuSuccessView();

        void showMenuToContinue();
    }

    interface Presenter extends BasePresenter<View> {
        
        void menu(String pilihan);

        void create(DataUser dataUser);

        List<DataUser> read();

        void update(DataUser dataUser);

        void delete(DataUser dataUser);
    }
}
