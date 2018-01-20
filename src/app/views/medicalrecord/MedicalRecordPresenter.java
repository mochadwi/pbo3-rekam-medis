/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.medicalrecord;

import app.Dashboard;
import app.models.DataRekamMedis;
import app.utils.Db;
import app.utils.Status;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author G-Eight
 */
public class MedicalRecordPresenter implements MedicalRecordContract.Presenter{
    private MedicalRecordContract.View view; 
 
    @Override 
    public void menu(String pilihan) { 
 
        view.showLoading(); 
 
        switch (pilihan) { 
            case "0": 
                // do nothing 
                view.showMenuSuccessView(); 
                Dashboard.status = Status.MENU; 
                break; 
            case "1": 
                view.showMenuSuccessView(); 
                view.showCreateDataView(); 
                break; 
            case "2": 
                view.showMenuSuccessView(); 
                view.showUpdateDataView(); 
                break; 
            case "3": 
                view.showMenuSuccessView(); 
                view.showDeleteDataView(); 
                break; 
            case "4": 
                view.showMenuSuccessView(); 
                view.showReadDataView(); 
                break; 
            default: 
                view.showMenuErrorView(); 
                view.showView(); 
        } 
 
        view.showMenuToContinue(); 
    } 
 
    @Override 
    public void create(DataRekamMedis dataRekamMedis) { 
        Db.getInstance().initPersist().insert(dataRekamMedis);
    } 
 
    @Override 
    public List<DataRekamMedis> read() { 
        return Db.getInstance().initPersist().readList(DataRekamMedis.class); 
    } 
 
    @Override 
    public void update(DataRekamMedis dataRekamMedis) { 
 
    } 
 
    @Override 
    public void delete(DataRekamMedis dataRekamMedis) { 
 
    } 
 
    
    
    @Override 
    public void bind(MedicalRecordContract.View view) { 
        this.view = view; 
    } 
 
    @Override 
    public void unBind() { 
        this.view = null; 
    } 

    @Override
    public String find(String id) {
        return "";
    }
    
    @Override
    public Date convertDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date2=null;
        try {
            //Parsing the String
            date2 = dateFormat.parse(date);
        } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
        return date2;
    }
    
}
