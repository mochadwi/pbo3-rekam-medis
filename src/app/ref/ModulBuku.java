package app.ref;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;
public class ModulBuku {
    String kd_buku, menu_buku, nm_buku, nm_pengarang, nm_penerbit, no_rak;
    int tahun, jumlah, no_ddc;
    
    Date tgl                = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
    Scanner SC              = new Scanner(System.in);
    Koneksi connect         = new Koneksi();
    
    void data_buku(){
        System.out.println("\n\n  +--------------------------------------------------------------------------+");
        System.out.println("  | DATA BUKU                                                                |");
        System.out.println("  +----+---------------+-----------------+---------------+--------+----------+");
        System.out.println("  | NO |   KODE BUKU   |    NAMA BUKU    |   PENGARANG   | NO RAK |  STATUS  |");
        System.out.println("  +----+---------------+-----------------+---------------+--------+----------+");
        
        try{ 
            connect.state = connect.conn.createStatement();
            String sql_tampil_buku = "SELECT kd_buku, nm_buku, nm_pengarang, no_rak, jumlah from tbl_buku";
            ResultSet Res = connect.state.executeQuery(sql_tampil_buku);
          
            int no = 1;
            Res.last();
            int jumlah = Res.getRow();
            Res.beforeFirst();
            String status;
            if(jumlah>0){
                while(Res.next()){
                    if(Integer.parseInt(Res.getString("jumlah")) != 0){
                        status = "ADA     ";
                    }
                    else{
                        status = "DIPINJAM";
                    }
                    System.out.println("  | "+no+"  | "+Res.getString("kd_buku")+" | "+Res.getString("nm_buku")+"       | "+Res.getString("nm_pengarang")+" | "+Res.getString("no_rak")+"  | "+status+" |");
                    no++;
                }
            }
            else{
               System.out.println("  |                          TIDAK ADA DATA BUKU                             |");
            }
       }
       catch(SQLException e){
             System.out.println(e.toString());
       }
        
       
        System.out.println("  +--------------------------------------------------------------------------+");
        System.out.println("  | +--------------------+  +----------------------+  +--------------------+ |");
        System.out.println("  | | EDIT DATA BUKU (E) |  | TAMBAH DATA BUKU (A) |  | HAPUS DATA BUKU (H)| |");
        System.out.println("  | +--------------------+  +----------------------+  +--------------------+ |");
        System.out.println("  | +--------------------+  +----------------------+  +--------------------+ |");
        System.out.println("  | |  DETAIL BUKU (D)   |  |  CARI DATA BUKU (C)  |  |     KEMBALI (K)|   | |");
        System.out.println("  | +--------------------+  +----------------------+  +--------------------+ |");
        System.out.println("  +--------------------------------------------------------------------------+\n\n");
         
      
        
    }
    
    boolean validasi_form_kosong(String nm_buku, String nm_pengarang, String nm_penerbit, String no_rak, int no_ddc, int tahun, int jumlah){
       boolean kosong;
       if("".equals(nm_buku) || "".equals(nm_pengarang) || "".equals(nm_penerbit) || "".equals(no_rak) || "0".equals(no_ddc) || "0".equals(tahun) || "0".equals(jumlah)){
           kosong = true;
       }
       else{
           kosong = false;
       }
       return kosong;
   } 
    
   void form_tambah_buku(){
        String tanggal = format.format(tgl);
        String aksi;
        try{
            connect.state = connect.conn.createStatement();
            String sql_data_buku = "SELECT * from tbl_buku";
            ResultSet Res = connect.state.executeQuery(sql_data_buku);
            Res.last();
            int rec = Res.getRow()+1;
        
        System.out.println("  +--------------------------------------------------------------------------+");
        System.out.println("  |                             TAMBAH DATA BUKU                             |");
        System.out.println("  +--------------------------------------------------------------------------+"); 

        System.out.print("    Masukkan Nama Buku\t\t: ");nm_buku = SC.nextLine();
        System.out.print("    Masukkan Nama Pengarang\t: ");nm_pengarang = SC.nextLine();
        System.out.print("    Masukkan Nama Penerbit\t: ");nm_penerbit = SC.nextLine();
        System.out.print("    Masukkan No Rak\t\t: ");no_rak = SC.nextLine();
        System.out.print("    Masukkan No DDC\t\t: ");no_ddc = SC.nextInt();
        System.out.print("    Masukkan Tahun Terbit\t: ");tahun = SC.nextInt();
        System.out.print("    Masukkan Jumlah Buku\t: ");jumlah = SC.nextInt();
        
        kd_buku = no_rak +"."+ tanggal + rec;
        String lastDigitKdBuku = "";
        System.out.print("    Masukkan Digit Terakhir Kode Buku\t\t: " + kd_buku); lastDigitKdBuku = SC.nextLine();
        System.out.println("");
        System.out.println("");
        System.out.print("Cek Kode Buku: "+ kd_buku); String nil = SC.nextLine();
        
        System.out.println("  +--------------------------------------------------------------------------+"); 
        System.out.print("    Apakah Anda Yakin Ingin Menyimpan Data Di Atas Y/T ? : ");aksi=SC.next();
        
       
        while(!"Y".equals(aksi) && !"T".equals(aksi)){
            System.out.println("  ----------------------------------------------------------------------------");
            System.out.println("  |                  MASUKAN SALAH ! SILAHKAN ULANGI KEMBALI                 |");
            System.out.println("  ----------------------------------------------------------------------------");   
            System.out.print("    Pilih Menu\t\t: ");aksi = SC.next();
        }
        
        if( "Y".equals(aksi)){
            if(this.validasi_form_kosong(nm_buku, nm_pengarang, nm_penerbit, no_rak, no_ddc, tahun, jumlah)==true){
                System.out.println("  ----------------------------------------------------------------------------");
                System.out.println("  |          DATA GAGAL DISIMPAN ! ADA FORM YANG BELUM DIISI                 |");
                System.out.println("  ----------------------------------------------------------------------------");   
            }
            else{
                String sql_tambah_buku = "INSERT into tbl_buku values('"+no_rak+"."+tanggal+""+rec+"','"+nm_buku+"',"+no_ddc+",'"+nm_pengarang+"','"+nm_penerbit+"','"+no_rak+"',"+jumlah+","+tahun+")";
                connect.state.execute(sql_tambah_buku);
                System.out.println("  ----------------------------------------------------------------------------");
                System.out.println("  |                      DATA BERHASIL DISIMPAN                               |");
                System.out.println("  ----------------------------------------------------------------------------");
            }
        }
        else{
            System.out.println("  ----------------------------------------------------------------------------");
            System.out.println("  |                  PENAMBAHAN DATA TELAH DIBATALKAN                        |");
            System.out.println("  ----------------------------------------------------------------------------");         
        }
       }
       catch(SQLException e){
           System.out.println(e.toString());
       }
       
   }

   void hapus_buku(){
       String kode, aksi;
       System.out.print("  \n    Masukkan Kode Buku\t: ");kode = SC.nextLine();
       try{
            String sql_cek_kode = "SELECT * FROM tbl_buku where kd_buku='"+kode+"'";
            ResultSet RS = connect.state.executeQuery(sql_cek_kode);
            if(RS.next()==true){
                System.out.print("    Apakah Anda Yakin Ingin Menghapus Data Buku Dengan Kode "+kode+" Y/T ? : ");aksi=SC.next();
        
       
                while(!"Y".equals(aksi) && !"T".equals(aksi)){
                    System.out.println("  ----------------------------------------------------------------------------");
                    System.out.println("  |                  MASUKAN SALAH ! SILAHKAN ULANGI KEMBALI                 |");
                    System.out.println("  ----------------------------------------------------------------------------");   
                    System.out.print("    Pilih Menu\t\t: ");aksi = SC.next();
                }
        
                if("Y".equals(aksi)){
                    String sql_hapus_buku = "DELETE FROM tbl_buku where kd_buku='"+kode+"'";
                    connect.state.execute(sql_hapus_buku);
                    System.out.println("  ----------------------------------------------------------------------------");
                    System.out.println("               BUKU DENGAN KODE "+kode+" TELAH DIHAPUS");
                    System.out.println("  ----------------------------------------------------------------------------");
                }
                else{
                    System.out.println("  ----------------------------------------------------------------------------");
                    System.out.println("  |                 PENGHAPUSAN DATA TELAH DIBATALKAN                        |");
                    System.out.println("  ----------------------------------------------------------------------------");         
                }
            }
            else{
                System.out.println("  ----------------------------------------------------------------------------");
                System.out.println("                       ! KODE BUKU "+kode+" TIDAK DITEMUKAN");
                System.out.println("  ----------------------------------------------------------------------------");
            }
       }
       catch(SQLException e){
            System.out.println(e.toString());
       }
   }
   
   void detail_buku(){
       String kode;
       System.out.print("    \n    Masukkan Kode Buku\t: ");kode = SC.nextLine();
       try{
           String sql_detail_buku = "SELECT * FROM tbl_buku where kd_buku='"+kode+"'";
           ResultSet Res = connect.state.executeQuery(sql_detail_buku);
           if(Res.next()==true){
                System.out.println("  +--------------------------------------------------------------------------+");
                System.out.println("  |                               DETAIL BUKU                                |");
                System.out.println("  +--------------------------------------------------------------------------+"); 
                System.out.println("    KODE BUKU\t\t: "+Res.getString("kd_buku"));
                System.out.println("    NAMA BUKU\t\t: "+Res.getString("nm_buku"));
                System.out.println("    NO DDC\t\t: "+Res.getString("no_ddc"));
                System.out.println("    NAMA PENGARANG\t: "+Res.getString("nm_pengarang"));
                System.out.println("    NAMA PENERBIT\t: "+Res.getString("nm_penerbit"));
                System.out.println("    NO RAK\t\t: "+Res.getString("no_rak"));
                System.out.println("    TAHUN TERBIT\t: "+Res.getString("tahun_terbit"));
                System.out.println("    JUMLAH\t\t: "+Res.getString("jumlah"));
                System.out.println("  ----------------------------------------------------------------------------");
           
           }
           else{
                System.out.println("  ----------------------------------------------------------------------------");
                System.out.println("                       ! KODE BUKU "+kode+" TIDAK DITEMUKAN");
                System.out.println("  ----------------------------------------------------------------------------");       
           }
       }
       catch(SQLException e){
           System.out.println(e.toString());
       }
   }
   
   void cari_buku(){
        String kode_menu, kode_buku, nama_buku, nama_pengarang, nama_penerbit;
        System.out.println("  +--------------------------------------------------------------------------+");
        System.out.println("  |                                CARI BUKU                                 |");
        System.out.println("  +--------------------------------------------------------------------------+"); 
        System.out.println("  | Cari Berdasarkan :                                                       |");
        System.out.println("  |                    1. KODE BUKU                                          |");
        System.out.println("  |                    2. NAMA BUKU                                          |");
        System.out.println("  |                    3. NAMA PENGARANG                                     |");
        System.out.println("  |                    4. NAMA PENERBIT                                      |");
        System.out.println("  +--------------------------------------------------------------------------+");
        
        System.out.print("    Pilih Menu\t\t: ");kode_menu = SC.nextLine();
        while(!"1".equals(kode_menu) && !"2".equals(kode_menu) && !"3".equals(kode_menu) && !"4".equals(kode_menu)){
                System.out.println("  ----------------------------------------------------------------------------");
                System.out.println("  |                  MASUKAN SALAH ! SILAHKAN ULANGI KEMBALI                 |");
                System.out.println("  ----------------------------------------------------------------------------");   
                System.out.print("    Pilih Menu\t\t: ");kode_menu = SC.next();
        }
        
        switch(kode_menu){
            case "1" :System.out.print("    Masukkan Kode Buku\t: ");kode_buku = SC.nextLine();this.hasil_pencarian_kode_buku(kode_buku);break;
            case "2" :System.out.print("    Masukkan Nama Buku\t: ");nama_buku = SC.nextLine();this.hasil_pencarian("nm_buku", nama_buku, "NAMA BUKU ");break;
            case "3" :System.out.print("    Masukkan Nama Pengarang\t: ");nama_pengarang = SC.nextLine();this.hasil_pencarian("nm_pengarang", nama_pengarang, "NAMA PENGARANG");break;
            case "4" :System.out.print("    Masukkan Nama Penerbit\t: ");nama_penerbit = SC.nextLine();this.hasil_pencarian("nm_penerbit", nama_penerbit, "NAMA PENERBIT");break;    
        }
   }
   
   void hasil_pencarian(String param_field, String param_value, String param_title){
       String field, value, title;
       field     = param_field;
       value     = param_value;
       title     = param_title;
        
       
      
        System.out.println("  +--------------------+-----------------+---------------+--------+----------+");
        System.out.println("  |              HASIL PENCARIAN BERDASARKAN "+title+"                  |");
        System.out.println("  +----+---------------+-----------------+---------------+--------+----------+");
        System.out.println("  | NO |   KODE BUKU   |    NAMA BUKU    |   PENGARANG   | NO RAK |  STATUS  |");
        System.out.println("  +----+---------------+-----------------+---------------+--------+----------+");
       try{ 
            connect.state = connect.conn.createStatement();
            String sql_tampil_buku = "SELECT kd_buku, nm_buku, nm_pengarang, no_rak, jumlah from tbl_buku where "+field+" like '%"+value+"%'";
            ResultSet Res = connect.state.executeQuery(sql_tampil_buku);
            int no = 1;
            String status;
   
                while(Res.next()){
                    if(Integer.parseInt(Res.getString("jumlah")) != 0){
                        status = "ADA     ";
                    }
                    else{
                        status = "DIPINJAM";
                    }
                    System.out.println("  | "+no+"  |  "+Res.getString("kd_buku")+" | "+Res.getString("nm_buku")+"       | "+Res.getString("nm_pengarang")+" | "+Res.getString("no_rak")+"  | "+status+" |");
                    no++;
                }
       }
       catch(SQLException e){
             System.out.println(e.toString());
       }
        
       
        System.out.println("  +--------------------------------------------------------------------------+");
   }
   
   void hasil_pencarian_kode_buku(String kode){
        String kode_buku;
        kode_buku = kode;
        System.out.println("  +--------------------+-----------------+---------------+--------+----------+");
        System.out.println("  |                    HASIL PENCARIAN BERDASRKAN KODE BUKU                  |");
        System.out.println("  +--------------------+-----------------+---------------+--------+----------+");
        System.out.println("  |     KODE BUKU      |    NAMA BUKU    |   PENGARANG   | NO RAK |  STATUS  |");
        System.out.println("  +--------------------+-----------------+---------------+--------+----------+");
        try{ 
            connect.state = connect.conn.createStatement();
            String sql_cari_kode_buku = "SELECT kd_buku, nm_buku, nm_pengarang, no_rak, jumlah from tbl_buku where kd_buku='"+kode_buku+"'";
            ResultSet Res = connect.state.executeQuery(sql_cari_kode_buku);
            
            String status;
   
            if(Res.next()==true){
               
                    if(Integer.parseInt(Res.getString("jumlah")) != 0){
                        status = "ADA     ";
                    }
                    else{
                        status = "DIPINJAM";
                    }
                    System.out.println("  |    "+Res.getString("kd_buku")+"    | "+Res.getString("nm_buku")+"       | "+Res.getString("nm_pengarang")+" | "+Res.getString("no_rak")+"  | "+status+" |");            
            }
            else{
                    System.out.println("         ! DATA BUKU DENGAN KODE BUKU "+kode+" TIDAK DITEMUKAN");

            }
            System.out.println("  +--------------------------------------------------------------------------+");
       }
       catch(SQLException e){
             System.out.println(e.toString());
       }
   }
   
   void edit_data_buku(){
        String aksi,kode,nama_buku,nama_pengarang, nama_penerbit, no_rak;
        String sql_cek_data_buku, sql_update_data_buku;
        int no_ddc, jumlah, tahun;
        System.out.println("  +--------------------------------------------------------------------------+");
        System.out.println("  |                              EDIT DATA BUKU                              |");
        System.out.println("  +--------------------------------------------------------------------------+"); 
          System.out.print("    Masukkan Kode Buku\t: ");kode = SC.nextLine();
        
        System.out.println("  +--------------------------------------------------------------------------+");
        System.out.println("  | *Jika Data Sama Harap Masukkan Kembali. Tidak Boleh Dikosongkan !        |");
        System.out.println("  +--------------------------------------------------------------------------+"); 
        System.out.println("  |                   DATA AWAL                  |      DATA PENGGANTI       |"); 
        System.out.println("  +--------------------------------------------------------------------------+");
        try{
           sql_cek_data_buku = "SELECT * FROM tbl_buku where kd_buku='"+kode+"'";
           ResultSet Res     = connect.state.executeQuery(sql_cek_data_buku);
           if(Res.next()==true){
                  System.out.println("    KODE BUKU\t\t: "+Res.getString("kd_buku")+"\t\t     TIDAK BISA DIGANTI");
                  System.out.print("    NAMA BUKU\t\t: "+Res.getString("nm_buku")+"\t\t     ");nama_buku=SC.nextLine();
                  System.out.print("    NAMA PENGARANG\t: "+Res.getString("nm_pengarang")+"\t\t     ");nama_pengarang=SC.nextLine();
                  System.out.print("    NAMA PENERBIT\t: "+Res.getString("nm_penerbit")+"\t\t     ");nama_penerbit=SC.nextLine();
                  System.out.print("    NO RAK\t\t: "+Res.getString("no_rak")+"\t\t\t     ");no_rak=SC.nextLine();
                  System.out.print("    NO DDC\t\t: "+Res.getString("no_ddc")+"\t\t\t     ");no_ddc=SC.nextInt();
                  System.out.print("    TAHUN TERBIT\t: "+Res.getString("tahun_terbit")+"\t\t\t     ");tahun=SC.nextInt();
                  System.out.print("    JUMLAH\t\t: "+Res.getString("jumlah")+"\t\t\t     ");jumlah=SC.nextInt();
                  System.out.println("  ----------------------------------------------------------------------------");
                  System.out.print("    Apakah Anda Yakin Ingin Mengubah Data Di Atas Y/T ? : ");aksi=SC.next();
        
       
                  while(!"Y".equals(aksi) && !"T".equals(aksi)){
                    System.out.println("  ----------------------------------------------------------------------------");
                    System.out.println("  |                  MASUKAN SALAH ! SILAHKAN ULANGI KEMBALI                 |");
                    System.out.println("  ----------------------------------------------------------------------------");   
                    System.out.print("    Pilih Menu\t\t: ");aksi = SC.next();
                  }
                  
                  if("Y".equals(aksi)){
                    if(this.validasi_form_kosong(nama_buku, nama_pengarang, nama_penerbit, no_rak, no_ddc, tahun, jumlah)==true){
                        System.out.println("  ----------------------------------------------------------------------------");
                        System.out.println("  |           DATA GAGAL DIUBAH ! ADA FORM YANG BELUM DIISI                  |");
                    }
                    else{
                        sql_update_data_buku = "UPDATE tbl_buku set nm_buku='"+nama_buku+"', no_ddc="+no_ddc+", nm_pengarang='"+nama_pengarang+"', nm_penerbit='"+nama_penerbit+"', no_rak='"+no_rak+"', jumlah="+jumlah+", tahun_terbit="+tahun+" where kd_buku='"+Res.getString("kd_buku")+"'";
                        connect.state.execute(sql_update_data_buku);
                        System.out.println("  ----------------------------------------------------------------------------");
                        System.out.println("  |                       DATA BERHASIL DIUBAH                               |");
                    }
                  }
                  else{
                        System.out.println("  ----------------------------------------------------------------------------");
                        System.out.println("  |                  PENGUBAHAN DATA TELAH DIBATALKAN                        |");       
                  }
                  
           }
           else{
               System.out.println("                       ! KODE BUKU "+kode+" TIDAK DITEMUKAN");    
           }
           System.out.println("  +--------------------------------------------------------------------------+");
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
   }
   
   public static void main(String[] args) {   
        ModulBuku MB = new ModulBuku();
        Scanner SC      = new Scanner(System.in);
        Koneksi connect = new Koneksi();
        boolean found = false;
        while(!"K".equals(MB.menu_buku)){
            MB.data_buku();
            System.out.print("    Pilih Menu\t\t: ");MB.menu_buku = SC.next(); 
            while(!"A".equals(MB.menu_buku) && !"E".equals(MB.menu_buku) && !"H".equals(MB.menu_buku) && !"D".equals(MB.menu_buku) && !"C".equals(MB.menu_buku) && !"K".equals(MB.menu_buku)){
                System.out.println("  ----------------------------------------------------------------------------");
                System.out.println("  |                  MASUKAN SALAH ! SILAHKAN ULANGI KEMBALI                 |");
                System.out.println("  ----------------------------------------------------------------------------");   
                System.out.print("    Pilih Menu\t\t: ");MB.menu_buku = SC.next();
            }
            switch(MB.menu_buku){
                case "A" : MB.form_tambah_buku();break;
                case "E" : MB.edit_data_buku();break;
                case "H" : MB.hapus_buku();break;
                case "D" : MB.detail_buku();break;
                case "C" : MB.cari_buku();break;
                case "K" : System.exit(0);break;
            }
        }
    }  
}
