/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
package app.views.medicine; 
 
import app.Dashboard; 
import app.models.DataObat; 
import app.utils.Db;
import app.utils.Status; 
import java.util.List; 
 
/** 
 * 
 * @author G-Eight 
 */ 
public class MedicinePresenter implements MedicineContract.Presenter { 
    private MedicineContract.View view; 
 
    @Override 
    public void menu(String pilihan) { 
 
        view.showLoading(); 
 
        switch (pilihan) { 
            case "0": 
                // do nothing 
                view.showMenuSuccessView("\n\n\nSucces!!\n"); 
                Dashboard.status = Status.MENU; 
                break; 
            case "1": 
                view.showMenuSuccessView("\n\n\nSucces!!\n"); 
                view.showCreateDataView(); 
                break; 
            case "2": 
                view.showMenuSuccessView("\n\n\nSucces!!\n"); 
                view.showUpdateDataView(); 
                break; 
            case "3": 
                view.showMenuSuccessView("\n\n\nSucces!!\n"); 
                view.showDeleteDataView(); 
                break; 
            case "4": 
                view.showMenuSuccessView("\n\n\nSucces!!\n"); 
                view.showReadDataView(); 
                break; 
                
            case "-1":
                view.showMenuSuccessView("\n\n\nMedicine Data found!!\n");
                Dashboard.status = Status.MEDICINE;
                break;

            case "-2":
                view.showMenuSuccessView("\n\n\nData not found!!\n");
                view.showUpdateDataView();
                break;
                
            case "-3": 
                view.showMenuSuccessView("\n\n\nData not found!!\n"); 
                view.showDeleteDataView(); 
                break; 
                
            default: 
                view.showMenuErrorView("Pilih Angka 0-4!"); 
                view.showView(); 
        } 
 
        view.showMenuToContinue(); 
    } 
 
    @Override 
    public void create(DataObat dataObat) { 
        Db.getInstance().initPersist().insert(dataObat);
    } 
 
    @Override 
    public List<DataObat> read() { 
        return Db.getInstance().initPersist().readList(DataObat.class); 
    } 
 
    @Override 
    public void update(DataObat dataObat) { 
        Db.getInstance().initPersist().update(dataObat);
    } 
 
    @Override 
    public void delete(String kdObat) { 
        Db.getInstance().initPersist()
                .executeUpdate("UPDATE data_obat SET value_obat=0 WHERE kode_obat=?", kdObat);
    } 
 
    @Override
    public String find(String kdObat) {

        DataObat dataObat = Db.getInstance().initPersist().readByPrimaryKey(DataObat.class, kdObat);

        if (dataObat != null) return dataObat.getKd();

        return "";
    }

    @Override
    public String findMin() {
        return "";
    }

    @Override
    public String findMax() {

        return Db.getInstance().initPersist().read(String.class,
                "SELECT MAX(kode_obat) FROM data_obat");
    }

    @Override
    public boolean validateData(String data) {

        if (data.isEmpty()) {

            view.showMenuErrorView("Data Tidak ditemukan!");
            return false;
        }


        return true;
    }
    
    @Override 
    public void bind(MedicineContract.View view) { 
        this.view = view; 
    } 
 
    @Override 
    public void unBind() { 
        this.view = null; 
    } 
} 