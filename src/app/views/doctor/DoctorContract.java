/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.doctor;

import app.BasePresenter;
import app.BaseView;
import java.util.List;

/**
 *
 * @author G-Eight
 */
public interface DoctorContract {
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

        void create(Doctor patient);

        List<Patient> read();

        void update(Patient patient);

        void delete(Patient patient);
    }
    
}
