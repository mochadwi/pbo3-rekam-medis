/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.transaction;

import app.BasePresenter;
import app.BaseView;

/**
 *
 * @author G-Eight
 */
public interface TransactionContract {
    interface View extends BaseView<Presenter> {

        void showView();

        void showMenuErrorView();

        
    }

    interface Presenter extends BasePresenter<View> {
        
        void validation(int pilihan);
        
    }
}
