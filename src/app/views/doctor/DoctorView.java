/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.doctor;

import app.models.DataDokter;
import app.utils.Strings;
import app.views.doctor.DoctorContract;
import java.util.List;

import java.util.Scanner;

/**
 *
 * @author G-Eight
 */
public class DoctorView implements DoctorContract.View {
    
    private Scanner in;
    private String mPilihan;

    private DoctorContract.Presenter presenter;
    
    public DoctorView() {
        this.in = new Scanner(System.in);
    }

    @Override
    public void showView() {
        System.out.println("===============================================================================");
        System.out.println("                            -= " + Strings.mMsgHospital + " =-                               ");
        System.out.println("   " + Strings.mMsgAddress + "    ");
        System.out.println("===============================================================================");

        System.out.println("\n");

        System.out.println("=================================================");
        System.out.println("|          <>   -= " + Strings.mMsgDefaultMenu + Strings.mMsgTitleDoctor + " =-   <>          |");
        System.out.println("=================================================");
        System.out.println("|                                               |");
        System.out.println("| 1. " + Strings.mMsgCreateData + " \t\t\t\t\t\t\t\t|");
        System.out.println("| 2. " + Strings.mMsgUpdateData + " \t\t\t\t\t\t\t\t\t|");
        System.out.println("| 3. " + Strings.mMsgDeleteData + " \t\t\t\t\t\t\t\t|");
        System.out.println("| 4. " + Strings.mMsgReadData + " \t\t\t\t\t\t\t\t|");
        System.out.println("| 0. " + Strings.mMsgExit + Strings.mMsgTitleDoctor + " \t\t\t\t\t\t|");
        System.out.println("|                                               |");
        System.out.print(Strings.mMsgChoice);
        mPilihan = in.next();
        System.out.println("=================================================");

        presenter.menu(mPilihan);
    }

    @Override
    public void showCreateDataView() {
        DataDokter dataDokter = new DataDokter();

        System.out.println("=================================================");
        System.out.println("|      <>   -= " + Strings.mMsgCreateData + " " + Strings.mMsgTitleDoctor + " =-   <>       |");
        System.out.println("=================================================");

        System.out.print("Masukkan ID Dokter           : ");
        dataDokter.setId_dokter(in.next());
        
        System.out.print("Masukkan Nama Dokter         : ");
        dataDokter.setNama_dokter(in.next());
        
        System.out.print("Masukkan Alamat Dokter       : ");
        dataDokter.setAlamat_dokter(in.next());

        System.out.print("Masukkan Pendidikan Terakhir : ");
        dataDokter.setRiwayat_pendidikan(in.next());

        System.out.print("Masukkan No Telp Dokter      : ");
        dataDokter.setNomor_telepon_dokter(in.next());

        presenter.create(dataDokter);
    }

    @Override
    public void showReadDataView() {
      List<DataDokter> dataDokter = presenter.read();

        System.out.println("|=============================================================================|");
        System.out.println("|                       -= DATA DOKTER REKAM MEDIS=-                          |");
        System.out.println("|=============================================================================|");

        for (int i = 0; i < dataDokter.size(); i++) {

            System.out.println("-----------------------------DATA DOKTER Ke-" + (i + 1) + "-------------------------------");
            System.out.println("Id Dokter            : " + dataDokter.get(i).getId_dokter());
            System.out.println("Nama Dokter          : " + dataDokter.get(i).getNama_dokter());
            System.out.println("Alamat Dokter        : " + dataDokter.get(i).getAlamat_dokter());
            System.out.println("Riwayat Pendidikan   : " + dataDokter.get(i).getRiwayat_pendidikan());
            System.out.println("Nomor Telepon Dokter : " + dataDokter.get(i).getNomor_telepon_dokter());
//            System.out.println("Umur          : " + dataDokter.get(i).getUmur());
//            System.out.println("Agama         : " + dataDokter.get(i).get);
//            System.out.println("========================================================================");
//            System.out.println("|                         -= DATA REKAM MEDIS =-                       |");
//            System.out.println("========================================================================");
//            System.out.println("| TGL BEROBAT |   PEMERIKSAAN   |       DIAGNOSIS     |   PENGOBATAN   |");
//            System.out.println("========================================================================");
//            System.out.println("|             |                 |                     |                |");
//            System.out.println("========================================================================");
//            System.out.print(dataDokter.get(i).TglBerobat);
//            System.out.print(dataDokter.get(i).Pemeriksaan);
//            System.out.print(dataDokter.get(i).Diagnosis);
//            System.out.print(dataDokter.get(i).Pengobatan);
        }
        System.out.println();
        System.out.print("==============================================================================");
    }

    @Override
    public void showUpdateDataView() {
        DataDokter dataDokter = new DataDokter();

        System.out.println("=================================================");
        System.out.println("|      <>   -= " + Strings.mMsgUpdateData + " " + Strings.mMsgTitleDoctor + " =-   <>       |");
        System.out.println("=================================================");

        System.out.print("Ubah Nama Dokter                : ");
        dataDokter.setNama_dokter(in.next());

        System.out.print("Ubah Umur Dokter                : ");
        dataDokter.setAlamat_dokter(in.next());

        System.out.print("Ubah Riwayat Pendidikan Dokter  : ");
        dataDokter.setRiwayat_pendidikan(in.next());

        System.out.print("Ubah Nomor Telepon Dokter       : ");
        dataDokter.setNomor_telepon_dokter(in.next());

        presenter.update(dataDokter);
    }

    @Override
    public void showDeleteDataView() {

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
    public void showMenuToContinue() {
        try {
            System.out.print("\n\n\nPress any key to continue...");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Override
    public void setPresenter(DoctorContract.Presenter presenter) {
        this.presenter = presenter;
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