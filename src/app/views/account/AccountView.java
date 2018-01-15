/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.account;

import app.models.Account;
import app.utils.Strings;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author G-Eight
 */
public class AccountView implements AccountContract.View {
    private Scanner in;
    private String mPilihan;

    private AccountContract.Presenter presenter;

    public AccountView() {
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
        System.out.println("|          <>   -= " + Strings.mMsgDefaultMenu + Strings.mMsgTitleAccount + " =-   <>          |");
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
        Account account = new Account();

        System.out.println("=================================================");
        System.out.println("|      <>   -= " + Strings.mMsgCreateData + " " + Strings.mMsgTitlePatient + " =-   <>       |");
        System.out.println("=================================================");

        System.out.print("Masukkan ID Akun       :");
        account.setId(in.next());
        
        System.out.print("Masukkan Nama Pengguna : ");
        account.setName(in.next());

        System.out.print("Masukkan Password      : ");
        account.setPassword(in.next());

        presenter.create(account);
    }

    @Override
    public void showReadDataView() {

        List<Account> account = presenter.read();

        System.out.println("|=============================================================================|");
        System.out.println("|                       -= DATA PASIEN REKAM MEDIS=-                          |");
        System.out.println("|=============================================================================|");

        for (int i = 0; i < account.size(); i++) {

            System.out.println("-----------------------------DATA PASIEN Ke-" + (i + 1) + "-------------------------------");
            System.out.println("ID Akun       : " + account.get(i).getId());
            System.out.println("Nama Pengguna : " + account.get(i).getName());
            System.out.println("Password      : " + account.get(i).getPassword());
            
        }
        
        System.out.println();
        System.out.print("==============================================================================");
    }

    @Override
    public void showUpdateDataView() {
        Account account = new Account();

        System.out.println("=================================================");
        System.out.println("|      <>   -= " + Strings.mMsgUpdateData + " " + Strings.mMsgTitlePatient + " =-   <>       |");
        System.out.println("=================================================");

        System.out.print("Ubah Nama Pengguna : ");
        account.setName(in.next());

        System.out.print("Ubah Password      : ");
        account.setPassword(in.next());

        presenter.update(account);
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
    public void setPresenter(AccountContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
