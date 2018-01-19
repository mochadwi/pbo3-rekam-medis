/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.patient;

import app.models.DataPasien;
import app.utils.Strings;

import java.util.List;
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
        DataPasien dataPasien = new DataPasien();

        System.out.println("=================================================");
        System.out.println("|      <>   -= " + Strings.mMsgCreateData + " " + Strings.mMsgTitlePatient + " =-   <>       |");
        System.out.println("=================================================");

        System.out.print("Masukkan Nama DataPasien    : ");
//        dataPasien.setName(in.next());

        System.out.print("Masukkan Umur           : ");
//        dataPasien.setAge(in.next());

        System.out.print("Masukkan Alamat         : ");
//        dataPasien.setAddr(in.next());

        System.out.print("Masukkan Pekerjaan      : ");
//        dataPasien.setJob(in.next());

        System.out.print("Masukkan Jenis Kelamin  : ");
//        dataPasien.setGender(in.next());

        System.out.print("Masukkan No Telp        : ");
//        dataPasien.setPhone(in.next());

        System.out.print("Masukkan No Telp Teman  : ");
//        dataPasien.setPhoneFr(in.next());

        System.out.print("Masukkan Status Menikah : ");
//        dataPasien.setMarital(in.next());

        presenter.create(dataPasien);
    }

    @Override
    public void showReadDataView() {

        List<DataPasien> dataPasien = presenter.read();

        System.out.println("|=============================================================================|");
        System.out.println("|                       -= DATA PASIEN REKAM MEDIS=-                          |");
        System.out.println("|=============================================================================|");

        for (int i = 0; i < dataPasien.size(); i++) {

            System.out.println("-----------------------------DATA PASIEN Ke-" + (i + 1) + "-------------------------------");
            System.out.println("Kode DataPasien   : " + dataPasien.get(i).getId_pasien());
            System.out.println("Nama DataPasien   : " + dataPasien.get(i).getNama_pasien());
            System.out.println("Alamat        : " + dataPasien.get(i).getAlamat_pasien());
            System.out.println("Jenis Kelamin : " + dataPasien.get(i).getJenis_kelamin());
            System.out.println("Umur          : " + dataPasien.get(i).getUmur());
//            System.out.println("Agama         : " + dataPasien.get(i).get);
//            System.out.println("========================================================================");
//            System.out.println("|                         -= DATA REKAM MEDIS =-                       |");
//            System.out.println("========================================================================");
//            System.out.println("| TGL BEROBAT |   PEMERIKSAAN   |       DIAGNOSIS     |   PENGOBATAN   |");
//            System.out.println("========================================================================");
//            System.out.println("|             |                 |                     |                |");
//            System.out.println("========================================================================");
//            System.out.print(dataPasien.get(i).TglBerobat);
//            System.out.print(dataPasien.get(i).Pemeriksaan);
//            System.out.print(dataPasien.get(i).Diagnosis);
//            System.out.print(dataPasien.get(i).Pengobatan);
        }
        System.out.println();
        System.out.print("==============================================================================");
    }

    @Override
    public void showUpdateDataView() {
        DataPasien dataPasien = new DataPasien();

        System.out.println("=================================================");
        System.out.println("|      <>   -= " + Strings.mMsgUpdateData + " " + Strings.mMsgTitlePatient + " =-   <>       |");
        System.out.println("=================================================");

        System.out.print("Ubah Nama DataPasien    : ");
        dataPasien.setNama_pasien(in.next());

        System.out.print("Ubah Umur           : ");
        dataPasien.setUmur(in.next());

        System.out.print("Ubah Alamat         : ");
        dataPasien.setAlamat_pasien(in.next());

        System.out.print("Ubah Pekerjaan      : ");
        dataPasien.setPekerjaan(in.next());

        System.out.print("Ubah Jenis Kelamin  : ");
        dataPasien.setJenis_kelamin(in.next());

        System.out.print("Ubah No Telp        : ");
        dataPasien.setNomor_telepon(in.next());

        System.out.print("Ubah No Telp Teman  : ");
        dataPasien.setNomor_telepon_kerabat(in.next());

        System.out.print("Ubah Status Menikah : ");
        dataPasien.setStatus_perkawinan(in.next());

        presenter.update(dataPasien);
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
        System.out.println("\n\n\nSucces!!\n");
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
