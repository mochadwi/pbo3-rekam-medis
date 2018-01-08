/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.patient;

import java.util.Scanner;

/**
 * @author mochadwi
 */

public class PatientView implements PatientContract.View {

    private String mPilihan;

    private PatientContract.Presenter presenter;

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
        mPilihan = in.next();
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
    public void showMenuSuccessView() {
        System.out.println("Succes!!");
    }

    @Override
    public void setPresenter(PatientContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
