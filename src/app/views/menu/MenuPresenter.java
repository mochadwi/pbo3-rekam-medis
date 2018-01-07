/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.menu;

/**
 *
 * @author G-Eight
 */
public class MenuPresenter implements MenuContract.Presenter {

    private MenuContract.View menuView;

    @Override
    public void menu(String pilihan) {
        menuView.showLoading();

        //int choice = Integer.parseInt(pilihan);
        if (pilihan.equals("1") || pilihan.equals("2") || pilihan.equals("3")
                || pilihan.equals("4")) {

            menuView.showMenuSuccesView();

        } else {
            menuView.showMenuErrorView();
            menuView.showView();
        }

    }

    @Override
    public void bind(MenuContract.View menuView) {
        this.menuView = menuView;
    }

    @Override
    public void unBind() {
        this.menuView = null;
    }
}
