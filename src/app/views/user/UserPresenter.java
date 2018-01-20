/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.user;

import app.Dashboard;
import app.models.DataUser;
import app.utils.Db;
import app.utils.Status;
import java.util.List;

/**
 *
 * @author G-Eight
 */
public class UserPresenter implements UserContract.Presenter{
    private UserContract.View view;

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
    public void create(DataUser dataUser) {
        Db.getInstance().initPersist().insert(dataUser);
    }

    @Override
    public List<DataUser> read() {
        return Db.getInstance().initPersist().readList(DataUser.class);
    }

    @Override
    public void update(DataUser dataUser) {
        
    }

    @Override
    public void delete(DataUser dataUser) {
        
    }

    @Override
    public void bind(UserContract.View view) {
        this.view = view;
    }

    @Override
    public void unBind() {
        this.view = null;
    }

}
