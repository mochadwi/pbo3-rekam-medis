/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.account;

import app.BasePresenter;
import app.BaseView;
import app.models.Account;
import java.util.List;

/**
 *
 * @author G-Eight
 */
public interface AccountContract {
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

        void create(Account account);

        List<Account> read();

        void update(Account account);

        void delete(Account account);
    }
}
