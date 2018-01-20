/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
package app.views.medicine; 
 
import app.models.DataObat; 
import app.utils.Strings; 
import java.util.List; 
import java.util.Scanner; 
 
/** 
 * 
 * @author G-Eight 
 */ 
public class MedicineView implements MedicineContract.View { 
    private Scanner in; 
    private String mPilihan; 
 
    private MedicineContract.Presenter presenter; 
 
    public MedicineView() { 
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
        System.out.println("|          <>   -= " + Strings.mMsgDefaultMenu + Strings.mMsgTitleMedicine + " =-   <>          |"); 
        System.out.println("================================================="); 
        System.out.println("|                                               |"); 
        System.out.println("| 1. " + Strings.mMsgCreateData + " \t\t\t\t\t\t\t\t|"); 
        System.out.println("| 2. " + Strings.mMsgUpdateData + " \t\t\t\t\t\t\t\t\t|"); 
        System.out.println("| 3. " + Strings.mMsgDeleteData + " \t\t\t\t\t\t\t\t|"); 
        System.out.println("| 4. " + Strings.mMsgReadData + " \t\t\t\t\t\t\t\t|"); 
        System.out.println("| 0. " + Strings.mMsgExit + Strings.mMsgTitleMedicine + " \t\t\t\t\t\t|"); 
        System.out.println("|                                               |"); 
        System.out.print(Strings.mMsgChoice); 
        mPilihan = in.next(); 
        System.out.println("================================================="); 
 
        presenter.menu(mPilihan); 
    } 
 
    @Override 
    public void showCreateDataView() { 
        DataObat dataObat = new DataObat(); 
 
        System.out.println("================================================="); 
        System.out.println("|      <>   -= " + Strings.mMsgCreateData + " " + Strings.mMsgTitleMedicine + " =-   <>       |"); 
        System.out.println("================================================="); 
 
        System.out.print("Masukkan Kode Obat      : "); 
        dataObat.setKd(in.next()); 
         
        System.out.print("Masukkan Nama Obat      : "); 
        dataObat.setName(in.next()); 
 
        System.out.print("Masukkan Jenis Obat     : "); 
        dataObat.setVariety(in.next()); 
 
        dataObat.setValue(1);
        
        presenter.create(dataObat); 
    } 
 
    @Override 
    public void showReadDataView() { 
 
        List<DataObat> dataObat = presenter.read(); 
 
        System.out.println("|=============================================================================|"); 
        System.out.println("|                       -= DATA OBAT=-                          |"); 
        System.out.println("|=============================================================================|"); 
 
        if (dataObat.isEmpty()) showMenuErrorView("Data kosong!");

        int count = 1; 
        for (int i = 0; i < dataObat.size(); i++) { 
            
            if (dataObat.get(i).getValue() == 0) continue;
            System.out.println("-----------------------------DATA OBAT Ke-" + (count++) + "-------------------------------"); 
            System.out.println("Kode Obat   : " + dataObat.get(i).getKd()); 
            System.out.println("Nama Obat   : " + dataObat.get(i).getName()); 
            System.out.println("Jenis Obat  : " + dataObat.get(i).getVariety()); 
        }
        System.out.println(); 
        System.out.print("=============================================================================="); 
    } 
 
    @Override 
    public void showUpdateDataView() { 
        DataObat dataObat = new DataObat(); 
 
        System.out.println("================================================="); 
        System.out.println("|      <>   -= " + Strings.mMsgUpdateData + " " + Strings.mMsgTitleMedicine + " =-   <>       |"); 
        System.out.println("================================================="); 
 
        System.out.print("Cari Kode Obat    : ");
        dataObat.setKd(in.next());
        String found = presenter.validateData(presenter.find(dataObat.getKd())) ? "-1" : "-2";
        presenter.menu(found);
        
        System.out.print("Ubah Nama Obat    : "); 
        dataObat.setName(in.next()); 
 
        System.out.print("Ubah Jenis Obat   : "); 
        dataObat.setVariety(in.next()); 
        
        dataObat.setValue(1);
 
        presenter.update(dataObat); 
    } 
 
    @Override 
    public void showDeleteDataView() { 
        String kdObat = ""; 
 
        System.out.println("================================================="); 
        System.out.println("|      <>   -= " + Strings.mMsgDeleteData + " " + Strings.mMsgTitleMedicine + " =-   <>       |"); 
        System.out.println("================================================="); 
 
        System.out.print("Cari ID             : "); 
        kdObat = in.next(); 
        String found = presenter.validateData(presenter.find(kdObat)) ? "-1" : "-3"; 
        presenter.menu(found); 
 
        presenter.delete(kdObat); 
    } 
 
    @Override 
    public void showMenuErrorView(String errMessage) { 
        System.out.print("\n\n\n\n" + errMessage + "\n\n\n\n"); 
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
    public void setPresenter(MedicineContract.Presenter presenter) { 
        this.presenter = presenter; 
    } 
 
    @Override 
    public void showLoading() { 
 
    } 
 
    @Override 
    public void hideLoading() { 
 
    } 
} 