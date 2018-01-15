/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.medicine;

import app.Dashboard;
import app.models.Medicine;
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
    public void create(Medicine medicine) {

    }

    @Override
    public List<Medicine> read() {
        return null;
    }

    @Override
    public void update(Medicine medicine) {

    }

    @Override
    public void delete(Medicine medicine) {

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
