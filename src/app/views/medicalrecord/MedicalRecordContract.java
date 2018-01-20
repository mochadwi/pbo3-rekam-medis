/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.medicalrecord;

import app.BasePresenter;
import app.BaseView;
import app.models.DataRekamMedis;
import java.util.Date;
import java.util.List;

/**
 *
 * @author G-Eight
 */
public interface MedicalRecordContract {
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
 
        void create(DataRekamMedis dataRekamMedis); 
 
        List<DataRekamMedis> read(); 
 
        void update(DataRekamMedis dataRekamMedis); 
 
        void delete(DataRekamMedis dataRekamMedis); 
        
        String find(String id);
        
        Date convertDate(String date);
    }
}
