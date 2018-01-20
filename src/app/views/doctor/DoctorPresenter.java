/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.doctor;

import app.Dashboard;
import app.models.DataDokter;
import app.utils.Db;
import app.utils.Status;
import java.util.List;

/**
 *
 * @author G-Eight
 */
public class DoctorPresenter implements DoctorContract.Presenter {

   private DoctorContract.View view;

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
                view.showMenuSuccessView("\n\n\nData found!!\n");
                Dashboard.status = Status.DOCTOR;
                break;

            case "-2":
                view.showMenuSuccessView("\n\n\nData not found!!\n");
                view.showUpdateDataView();
                break;
            default:
                view.showMenuErrorView("Pilih Angka 0-4!");
                view.showView();
        }

        view.showMenuToContinue();
    }

    @Override
    public void create(DataDokter dataDokter) {

        Db.getInstance().initPersist().insert(dataDokter);
    }

    @Override
    public List<DataDokter> read() {
        return Db.getInstance().initPersist().readList(DataDokter.class);
    }

    @Override
    public void update(DataDokter dataDokter) {
        Db.getInstance().initPersist().update(dataDokter);
    }

    @Override
    public void delete(String idDokter) {
        Db.getInstance().initPersist()
                .executeUpdate("UPDATE data_dokter SET value_dokter=0 WHERE id_dokter=?", idDokter);
    }
    
    @Override
    public String find(String idDokter) {
        DataDokter dataDokter = Db.getInstance().initPersist().readByPrimaryKey(DataDokter.class, idDokter);

        if (dataDokter != null) return dataDokter.getId_dokter();

        return "";
    }

    @Override
    public String findMin() {
        return "";
    }

    @Override
    public String findMax() {
        return Db.getInstance().initPersist().read(String.class,
                "SELECT MAX(id_dokter) FROM data_dokter");
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
    public void bind(DoctorContract.View view) {
        this.view = view;
    }

    @Override
    public void unBind() {
        this.view = null;
    }

    
}
