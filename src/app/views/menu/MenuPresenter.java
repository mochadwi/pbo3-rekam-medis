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
    public void menu(int pilihan) {
        menuView.showLoading();
        
        if (pilihan < 1 || pilihan > 4) {
            menuView.showMenuErrorView();
            menuView.showView();
            return;
        }
        
        menuView.showMenuSuccesView();
        
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
