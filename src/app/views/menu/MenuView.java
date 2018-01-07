package app.views.menu;

import java.util.Scanner;

public class MenuView implements MenuContract.View {
    
    private int mPilihan;
    private MenuContract.Presenter presenter;
    
    @Override
    public void setPresenter(MenuContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showView() {
        Scanner in = new Scanner(System.in);

        System.out.println("===============================================================================");
        System.out.println("                            -= KLINIK KATAMSO =-                               ");
        System.out.println("   Jl. Brigjen Katamso, Cihaurgeulis, Cibeunying Kaler, Bandung, Jawa Barat    ");
        System.out.println("===============================================================================");
        System.out.println("=================================================");
        System.out.println("|          <>   -= MENU UTAMA =-   <>           |");
        System.out.println("=================================================");
        System.out.println("|                                               |");
        System.out.println("| 1. Data Pasien                                |");
        System.out.println("| 2. Data Dokter                                |");
        System.out.println("| 3. Data Obat                                  |");
        System.out.println("| 4. Data Transaksi                             |");
        System.out.println("| 0. Keluar                                     |");
        System.out.println("|                                               |");
        System.out.print("| Pilihan Anda ? ");
        mPilihan = in.nextInt();
        System.out.println("                               |");
        System.out.println("|                                               |");
        System.out.println("=================================================");
        System.out.println("===============================================================================");
          
        presenter.menu(mPilihan);
    }

    @Override
    public void showMenuErrorView() {
        System.out.println("Pilih Angka 1-4!");
    }

    @Override
    public void showMenuSuccesView() {
        System.out.println("Succes!!");
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
