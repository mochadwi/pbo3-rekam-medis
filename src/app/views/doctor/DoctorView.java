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
        
        dataDokter.setValue_dokter(1);

        presenter.create(dataDokter);
    }

    @Override
    public void showReadDataView() {
      List<DataDokter> dataDokter = presenter.read();

        System.out.println("|=============================================================================|");
        System.out.println("|                       -= DATA DOKTER=-                          |");
        System.out.println("|=============================================================================|");

        if (dataDokter.isEmpty()) showMenuErrorView("Data kosong!"); 

        int count = 1; 
        for (int i = 0; i < dataDokter.size(); i++) { 

            if (dataDokter.get(i).getValue_dokter()== 0) continue;
            
            System.out.println("-----------------------------DATA DOKTER Ke-" + (count++) + "-------------------------------"); 
            System.out.println("Id Dokter            : " + dataDokter.get(i).getId_dokter());
            System.out.println("Nama Dokter          : " + dataDokter.get(i).getNama_dokter());
            System.out.println("Alamat Dokter        : " + dataDokter.get(i).getAlamat_dokter());
            System.out.println("Riwayat Pendidikan   : " + dataDokter.get(i).getRiwayat_pendidikan());
            System.out.println("Nomor Telepon Dokter : " + dataDokter.get(i).getNomor_telepon_dokter());

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

        System.out.print("Cari ID             : ");
        dataDokter.setId_dokter(in.next());
        String found = presenter.validateData(presenter.find(dataDokter.getId_dokter())) ? "-1" : "-2";
        presenter.menu(found);
        
        System.out.print("Ubah Nama Dokter                : ");
        dataDokter.setNama_dokter(in.next());

        System.out.print("Ubah Umur Dokter                : ");
        dataDokter.setAlamat_dokter(in.next());

        System.out.print("Ubah Riwayat Pendidikan Dokter  : ");
        dataDokter.setRiwayat_pendidikan(in.next());

        System.out.print("Ubah Nomor Telepon Dokter       : ");
        dataDokter.setNomor_telepon_dokter(in.next());
        
        dataDokter.setValue_dokter(1);

        presenter.update(dataDokter);
    }

    @Override
    public void showDeleteDataView() {
        String idDokter = ""; 
 
        System.out.println("================================================="); 
        System.out.println("|      <>   -= " + Strings.mMsgDeleteData + " " + Strings.mMsgTitleDoctor + " =-   <>       |"); 
        System.out.println("================================================="); 
 
        System.out.print("Cari ID             : "); 
        idDokter = in.next(); 
        String found = presenter.validateData(presenter.find(idDokter)) ? "-1" : "-3"; 
        presenter.menu(found); 
 
        presenter.delete(idDokter); 
    }
    
    @Override
    public void showMenuErrorView(String errMessage) {
        System.out.println("\n\n\n\n" + errMessage + "\n\n\n\n");
    }
    
    @Override
    public void showMenuSuccessView(String errMsg) {
        System.out.println(errMsg);
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