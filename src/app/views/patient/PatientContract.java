/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.patient;

import app.BasePresenter;
import app.BaseView;

/**
 * @author mochadwi
 */

public interface PatientContract {
    interface View extends BaseView<Presenter> {

        void showView();

        void showCreateDataView();

        void showReadDataView();

        void showUpdateDataView();

        void showDeleteDataView();

        void showMenuErrorView();

        void showMenuSuccessView();
    }

    interface Presenter extends BasePresenter<View> {

        void validation(int pilihan);

        void menu(String pilihan);
    }
}
