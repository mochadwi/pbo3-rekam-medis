/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.doctor;

import app.utils.Config;
import app.views.menu.MenuContract;

/**
 *
 * @author G-Eight
 */
public class DoctorPresenter implements DoctorContract.Presenter {

   private DoctorContract.View menuView;

    @Override
    public void validation(String pilihan) {
        menuView.showLoading();

        //int choice = Integer.parseInt(pilihan);
        if (pilihan.equals("1") || pilihan.equals("2") || pilihan.equals("3")
                || pilihan.equals("4")) {

//            menuView.showMenuSuccesView();
            menuView.showCreateDataView();

        } else {
            menuView.showMenuErrorView();
            menuView.showView();
        }

    }

    @Override
    public void bind(DoctorContract.View menuView) {
        this.menuView = menuView;
    }

    @Override
    public void unBind() {
        this.menuView = null;
    }
}
