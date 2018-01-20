/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.user;

import app.models.DataUser;
import app.utils.Strings;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author G-Eight
 */
public class UserView implements UserContract.View{
    private Scanner in;
    private String mPilihan;

    private UserContract.Presenter presenter;
    
    public UserView() {
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
        System.out.println("|          <>   -= " + Strings.mMsgDefaultMenu + Strings.mMsgTitleUser + " =-   <>          |");
        System.out.println("=================================================");
        System.out.println("|                                               |");
        System.out.println("| 1. " + Strings.mMsgCreateData + " \t\t\t\t\t\t\t\t|");
        System.out.println("| 2. " + Strings.mMsgUpdateData + " \t\t\t\t\t\t\t\t\t|");
        System.out.println("| 3. " + Strings.mMsgDeleteData + " \t\t\t\t\t\t\t\t|");
        System.out.println("| 4. " + Strings.mMsgReadData + " \t\t\t\t\t\t\t\t|");
        System.out.println("| 0. " + Strings.mMsgExit + Strings.mMsgTitleUser + " \t\t\t\t\t\t|");
        System.out.println("|                                               |");
        System.out.print(Strings.mMsgChoice);
        mPilihan = in.next();
        System.out.println("=================================================");

        presenter.menu(mPilihan);
    }

    @Override
    public void showCreateDataView() {
        DataUser dataUser = new DataUser();

        System.out.println("=================================================");
        System.out.println("|      <>   -= " + Strings.mMsgCreateData + " " + Strings.mMsgTitleUser + " =-   <>       |");
        System.out.println("=================================================");

        System.out.print("Masukkan ID User           : ");
        dataUser.setId_user(in.next());
        
        System.out.print("Masukkan Nama User         : ");
        dataUser.setNama_user(in.next());
        
        System.out.print("Masukkan Password          : ");
        dataUser.setPassword(in.next());

        presenter.create(dataUser);
    }

    @Override
    public void showReadDataView() {
      List<DataUser> dataUser = presenter.read();

        System.out.println("|=============================================================================|");
        System.out.println("|                       -= DATA DOKTER REKAM MEDIS=-                          |");
        System.out.println("|=============================================================================|");

        for (int i = 0; i < dataUser.size(); i++) {

            System.out.println("-----------------------------DATA DOKTER Ke-" + (i + 1) + "-------------------------------");
            System.out.println("Id User            : " + dataUser.get(i).getId_user());
            System.out.println("Nama User          : " + dataUser.get(i).getNama_user());
            System.out.println("Password           : " + dataUser.get(i).getPassword());
            System.out.println("------------------------------------------------------------------------------------------");
        }
        System.out.println();
        System.out.print("==============================================================================");
    }

    @Override
    public void showUpdateDataView() {
        DataUser dataUser = new DataUser();

        System.out.println("=================================================");
        System.out.println("|      <>   -= " + Strings.mMsgUpdateData + " " + Strings.mMsgTitleUser + " =-   <>       |");
        System.out.println("=================================================");

        System.out.print("Ubah Nama Dokter                : ");
        dataUser.setNama_user(in.next());

        System.out.print("Ubah Umur Dokter                : ");
        dataUser.setPassword(in.next());

        presenter.update(dataUser);
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
        System.out.println("Success!!");
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
    public void setPresenter(UserContract.Presenter presenter) {
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
