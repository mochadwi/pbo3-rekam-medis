/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.menu;

import app.Dashboard;
import app.utils.Status;

/**
 *
 * @author G-Eight
 */
public class MenuPresenter implements MenuContract.Presenter {

    private MenuContract.View view;

    @Override
    public void menu(String pilihan) {
        view.showLoading();

        switch (pilihan) {
            case "0":
                // do nothing
                view.showMenuSuccessView();
                Dashboard.status = Status.AUTH;
                break;
            case "1":
                view.showMenuSuccessView();
                Dashboard.status = Status.PATIENT;
                break;
            case "2":
                view.showMenuSuccessView();
                Dashboard.status = Status.DOCTOR;
                break;
            case "3":
                view.showMenuSuccessView();
                Dashboard.status = Status.MEDICINE;
                break;
            case "4":
                view.showMenuSuccessView();
                Dashboard.status = Status.MEDICALRECORD;
                break;

            default:
                view.showMenuErrorView("Pilih Angka 0-4!");
                view.showView();
        }

        view.showMenuToContinue();

    }

    @Override
    public void bind(MenuContract.View view) {
        this.view = view;
    }

    @Override
    public void unBind() {
        this.view = null;
    }
}
