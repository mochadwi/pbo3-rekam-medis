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
    public void create(DataDokter dataDokter) {

        Db.getInstance().initPersist().insert(dataDokter);
    }

    @Override
    public List<DataDokter> read() {
        return Db.getInstance().initPersist().readList(DataDokter.class);
    }

    @Override
    public void update(DataDokter dataDokter) {

    }

    @Override
    public void delete(DataDokter dataDokter) {

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
