/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
package app.views.medicine; 
 
import app.BasePresenter; 
import app.BaseView; 
import app.models.DataObat; 
import java.util.List; 
 
/** 
 * 
 * @author G-Eight 
 */ 
public interface MedicineContract { 
    interface View extends BaseView<Presenter> { 
 
        void showView(); 
 
        void showCreateDataView(); 
 
        void showReadDataView(); 
 
        void showUpdateDataView(); 
 
        void showDeleteDataView(); 
 
        void showMenuErrorView(String errMessage); 
 
        void showMenuSuccessView(String errMessage); 
 
        void showMenuToContinue(); 
    } 
 
    interface Presenter extends BasePresenter<View> { 
 
        void menu(String pilihan); 
 
        void create(DataObat dataObat); 
 
        List<DataObat> read(); 
 
        void update(DataObat dataObat); 
 
        void delete(String kdObat); 
        
        String find(String kdObat);
        
        String findMin();
        
        String findMax();
        
        boolean validateData (String data);
    } 
} 