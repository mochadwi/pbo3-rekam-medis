/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.doctor;

import java.util.Scanner;
import app.views.doctor.DoctorContract;

/**
 *
 * @author G-Eight
 */
public class DoctorView implements DoctorContract.View {
    
    private String mPilihan;

    private DoctorContract.Presenter presenter;
    
    @Override
    public void setPresenter(DoctorContract.Presenter presenter) {
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
        System.out.println("| 1. Isi Data                                   |");
        System.out.println("| 2. Hapus Data                                 |");
        System.out.println("| 3. Edit Data                                  |");
        System.out.println("| 4. Tampil Data                                |");
        System.out.println("| 0. Keluar                                     |");
        System.out.println("|                                               |");
        System.out.println("=================================================");
        System.out.println("\n");
        System.out.print("Pilihan Anda ? ");
        mPilihan = in.next();
        System.out.println("\n");
        System.out.println("===============================================================================");
          
        presenter.validation(mPilihan);
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

    @Override
    public void showCreateDataView() {
        
        String idDokter, namaDokter, riwayatPend, noTelp;
        Scanner in = new Scanner(System.in);
        
        System.out.println("===ISI DATA===");
        System.out.print("ID Dokter : ");
        idDokter = in.nextLine();
        System.out.print("Nama Dokter : ");
        namaDokter = in.nextLine();
        System.out.print("Riwayat Pendidikan : ");
        riwayatPend = in.nextLine();
        System.out.print("Nomor Telepon : ");     
        noTelp = in.nextLine();
        
        
        
    }

    @Override
    public void showReadDataView() {
        
    }
}