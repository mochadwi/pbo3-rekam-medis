/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.patient;

import app.BasePresenter;
import app.BaseView;
import app.models.DataPasien;

import java.util.List;

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

        void showMenuErrorView(String errMessage);

        void showMenuSuccessView();

        void showMenuToContinue();
    }

    interface Presenter extends BasePresenter<View> {

        void menu(String pilihan);

        void create(DataPasien dataPasien);

        List<DataPasien> read();

        void update(String idPasien);

        void delete(DataPasien dataPasien);

        String find(String idPasien);

        String findMin();

        String findMax();

//        <T> boolean validateData(T data); // receives any kind of data

        boolean validateData(String data);
    }
}
