/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.patient;

import app.models.Patient;
import app.utils.Strings;

import java.util.Scanner;

/**
 * @author mochadwi
 */

public class PatientView implements PatientContract.View {

    private Scanner in;
    private String mPilihan;

    private PatientContract.Presenter presenter;

    public PatientView() {
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
        System.out.println("|          <>   -= " + Strings.mMsgDefaultMenu + Strings.mMsgTitlePatient + " =-   <>          |");
        System.out.println("=================================================");
        System.out.println("|                                               |");
        System.out.println("| 1. " + Strings.mMsgCreateData + " \t\t\t\t\t\t\t\t|");
        System.out.println("| 2. " + Strings.mMsgUpdateData + " \t\t\t\t\t\t\t\t\t|");
        System.out.println("| 3. " + Strings.mMsgDeleteData + " \t\t\t\t\t\t\t\t|");
        System.out.println("| 4. " + Strings.mMsgReadData + " \t\t\t\t\t\t\t\t|");
        System.out.println("| 0. " + Strings.mMsgExit + Strings.mMsgTitlePatient + " \t\t\t\t\t\t|");
        System.out.println("|                                               |");
        System.out.print(Strings.mMsgChoice);
        mPilihan = in.next();
        System.out.println("=================================================");

        presenter.menu(mPilihan);
    }

    @Override
    public void showCreateDataView() {
        Patient patient = new Patient();

        System.out.println("=================================================");
        System.out.println("|      <>   -= " + Strings.mMsgCreateData + " " + Strings.mMsgTitlePatient + " =-   <>       |");
        System.out.println("=================================================");

        System.out.print("Masukkan Nama Pasien    : ");
        patient.setName(in.next());

        System.out.print("Masukkan Umur           : ");
        patient.setAge(in.next());

        System.out.print("Masukkan Alamat         : ");
        patient.setAddr(in.next());

        System.out.print("Masukkan Pekerjaan      : ");
        patient.setJob(in.next());

        System.out.print("Masukkan Jenis Kelamin  : ");
        patient.setGender(in.next());

        System.out.print("Masukkan No Telp        : ");
        patient.setPhone(in.next());

        System.out.print("Masukkan No Telp Teman  : ");
        patient.setPhoneFr(in.next());

        System.out.print("Masukkan Status Menikah : ");
        patient.setMarital(in.next());

        presenter.create(patient);
    }

    @Override
    public void showReadDataView() {

    }

    @Override
    public void showUpdateDataView() {

    }

    @Override
    public void showDeleteDataView() {

    }

    @Override
    public void showMenuErrorView() {
        System.out.print("\n\n\n\nPilih Angka 1-4!\n\n\n\n");
    }

    @Override
    public void showMenuSuccessView() {
        System.out.println("\n\n\n\nSucces!!\n\n\n\n");
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
