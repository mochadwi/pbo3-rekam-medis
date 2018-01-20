/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views.medicalrecord;

import app.models.DataDokter;
import app.models.DataRekamMedis;
import app.utils.Db;
import app.utils.Strings;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author G-Eight
 */
public class MedicalRecordView implements MedicalRecordContract.View {

    private Scanner in;
    private String mPilihan;

    private MedicalRecordContract.Presenter presenter;

    public MedicalRecordView() {
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
        System.out.println("|          <>   -= " + Strings.mMsgDefaultMenu + Strings.mMsgTitleMedicalRecord + " =-   <>          |");
        System.out.println("=================================================");
        System.out.println("|                                               |");
        System.out.println("| 1. " + Strings.mMsgCreateData + " \t\t\t\t\t\t\t\t|");
        System.out.println("| 2. " + Strings.mMsgUpdateData + " \t\t\t\t\t\t\t\t\t|");
        System.out.println("| 3. " + Strings.mMsgDeleteData + " \t\t\t\t\t\t\t\t|");
        System.out.println("| 4. " + Strings.mMsgReadData + " \t\t\t\t\t\t\t\t|");
        System.out.println("| 0. " + Strings.mMsgExit + Strings.mMsgTitleMedicalRecord + " \t\t\t\t\t\t|");
        System.out.println("|                                               |");
        System.out.print(Strings.mMsgChoice);
        mPilihan = in.next();
        System.out.println("=================================================");

        presenter.menu(mPilihan);
    }

    @Override
    public void showCreateDataView() {
        DataRekamMedis dataRekamMedis = new DataRekamMedis();

        System.out.println("=================================================");
        System.out.println("|      <>   -= " + Strings.mMsgCreateData + " " + Strings.mMsgTitleMedicalRecord + " =-   <>       |");
        System.out.println("=================================================");

        System.out.print("Masukkan Nomor RM        : ");
        dataRekamMedis.setNomor_rm(in.next());
        
        System.out.print("Masukkan Nomor Pasien    : ");
        dataRekamMedis.setNomor_pasien("p01");
        
        System.out.print("Masukkan ID Dokter       : ");
//        DataDokter dokter = Db.getInstance().initPersist()
//                .readByPrimaryKey(DataDokter.class, in.next());
        
//        presenter.validateData(dokter.getId_dokter());
        dataRekamMedis.setId_dokter("d01");

        System.out.print("Masukkan Tanggal Berobat (dd-MMM-yyyy)): ");
        dataRekamMedis.setTglBerobat(presenter.convertDate(in.next()));
      
        System.out.print("Masukkan Keluhan         : ");
        dataRekamMedis.setKeluhan(in.next());

        System.out.print("Masukkan Diagnosa        : ");
        dataRekamMedis.setDiagnosa(in.next());
        
        System.out.print("Masukkan Tindakan        : ");
        dataRekamMedis.setTindakan(in.next());
        
        System.out.print("Masukkan Kode Obat       : ");
        dataRekamMedis.setKode_obat("o01");
        
        System.out.print("Masukkan ID User         : ");
        dataRekamMedis.setId_user("u01");

        presenter.create(dataRekamMedis);
    }

    @Override
    public void showReadDataView() {

        List<DataRekamMedis> dataRekamMedis = presenter.read();

        System.out.println("|=============================================================================|");
        System.out.println("|                       -= DATA PASIEN REKAM MEDIS=-                          |");
        System.out.println("|=============================================================================|");

        for (int i = 0; i < dataRekamMedis.size(); i++) {

            System.out.println("-----------------------------DATA PASIEN Ke-" + (i + 1) + "-------------------------------");
            System.out.println("Nomor RM        : " + dataRekamMedis.get(i).getNomor_rm());
            System.out.println("Nomor Pasien    : " + dataRekamMedis.get(i).getNomor_pasien());
            System.out.println("ID Dokter       : " + dataRekamMedis.get(i).getId_dokter());
            System.out.println("Tanggal Berobat : " + dataRekamMedis.get(i).getTglBerobat());
            System.out.println("Keluhan         : " + dataRekamMedis.get(i).getKeluhan());
            System.out.println("Diagnosa        : " + dataRekamMedis.get(i).getDiagnosa());
            System.out.println("Tindakan        : " + dataRekamMedis.get(i).getTindakan());
            System.out.println("Kode Obat       : " + dataRekamMedis.get(i).getKode_obat());
            System.out.println("ID User         : " + dataRekamMedis.get(i).getId_user());

        }
        System.out.println();
        System.out.print("==============================================================================");
    }

    @Override
    public void showUpdateDataView() {
        DataRekamMedis dataRekamMedis = new DataRekamMedis();

        System.out.println("=================================================");
        System.out.println("|      <>   -= " + Strings.mMsgUpdateData + " " + Strings.mMsgTitleMedicalRecord + " =-   <>       |");
        System.out.println("=================================================");
        
        System.out.print("Ubah Nomor Pasien    : ");
        dataRekamMedis.setNomor_pasien("p01");
        
        System.out.print("Ubah ID Dokter       : ");
//        DataDokter dokter = Db.getInstance().initPersist()
//                .readByPrimaryKey(DataDokter.class, in.next());
        
//        presenter.validateData(dokter.getId_dokter());
        dataRekamMedis.setId_dokter("d01");

        System.out.print("Ubah Tanggal Berobat : ");
        dataRekamMedis.setTglBerobat(new Date());
        
        System.out.print("Ubah Keluhan         : ");
        dataRekamMedis.setKeluhan(in.next());

        System.out.print("Ubah Diagnosa        : ");
        dataRekamMedis.setDiagnosa(in.next());
        
        System.out.print("Ubah Tindakan        : ");
        dataRekamMedis.setTindakan(in.next());
        
        System.out.print("Ubah Kode Obat       : ");
        dataRekamMedis.setKode_obat("o01");
        
        System.out.print("Ubah ID User         : ");
        dataRekamMedis.setId_user("u01");

        presenter.update(dataRekamMedis);
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
    public void setPresenter(MedicalRecordContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
