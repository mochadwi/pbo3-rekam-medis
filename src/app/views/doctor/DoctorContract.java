/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.doctor;

import app.BasePresenter;
import app.BaseView;

/**
 *
 * @author G-Eight
 */
public interface DoctorContract {
    interface View extends BaseView<Presenter> {

        void showView();

        void showCreateDataView();
        
        void showReadDataView();
        
        void showMenuErrorView();

        void showMenuSuccesView();
    }

    interface Presenter extends BasePresenter<View> {
        
        void validation(String mPilihan);        
    }
    
}
