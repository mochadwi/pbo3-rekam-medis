package app.views.login;

import app.utils.Config;
import app.views.menu.MenuContract;

import java.util.Scanner;

public class LoginView implements LoginContract.View {

    private String mNamaPengguna, mKataSandi;

    private LoginContract.Presenter presenter;
    
    private MenuContract.View menuView;

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }
    
    public void setMenuView(MenuContract.View menuView) {
        this.menuView = menuView;
    }

    @Override
    public void showView() {
        Scanner in = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("| Silahkan Masukan Nama Pengguna dan Kata Sandi |");
        System.out.println("=================================================");
        System.out.println("                                                 ");

        System.out.print("   Nama Pengguna : ");
        mNamaPengguna = in.nextLine();
        System.out.print("   Kata Sandi    : ");
        mKataSandi = in.nextLine();

        System.out.println("                                                 ");
        System.out.println("=================================================");

        presenter.login(mNamaPengguna, mKataSandi);
    }

    @Override
    public void showLoginErrorView() {
        System.out.println("Nama dan sandi salah, silakan ulangi!\n\n");
    }

    @Override
    public void showLoginSuccessView() {
        System.out.println("Selamat Datang!!!\n\n");
        
    }

    @Override
    public void showLoginAttemptFailed() {
        System.out.println("Kesempatan anda habis!\n\n");
    }

    @Override
    public void showLoading() {
        try {
            // loading 3 seconds
            for (int i = 0; i < 1; i++) {
                Thread.sleep(1000);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n\n");
    }

    @Override
    public void hideLoading() {

    }
}
