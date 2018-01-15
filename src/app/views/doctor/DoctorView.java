/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.doctor;

import app.models.Doctor;
import app.utils.Strings;
import app.views.doctor.DoctorContract;

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
    public void setPresenter(DoctorContract.Presenter presenter) {
        this.presenter = presenter;
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
        Doctor doctor = new Doctor();

        System.out.println("=================================================");
        System.out.println("|      <>   -= " + Strings.mMsgCreateData + " " + Strings.mMsgTitlePatient + " =-   <>       |");
        System.out.println("=================================================");

        System.out.print("Masukkan ID Dokter           : ");
        doctor.setId(in.next());
        
        System.out.print("Masukkan Nama Dokter         : ");
        doctor.setName(in.next());

        System.out.print("Masukkan Pendidikan Terakhir : ");
        doctor.setEducationalBkgrd(in.next());

        System.out.print("Masukkan No Telp             : ");
        doctor.setPhone(in.next());

        presenter.create(doctor);
    }

    @Override
    public void showReadDataView() {
        
    }
}