package app.ref;

import java.util.Scanner;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Anggota {

    String kode_anggota, nama, alamat, pekerjaan,
            instansi, alamat_instansi, no_telp, cari, koneksi;
    Scanner SC = new Scanner(System.in);
    Koneksi connect = new Koneksi();
    char pilihan;
    int no;

    public void tampil_anggota() {
        // TODO code application logic here
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                      |");
        System.out.println("|DATA ANGGOTA                                                                          |");
        System.out.println("|                                                                                      |");
        System.out.println("+----+---------------+-----------------+------------------------------+----------------+");
        System.out.println("| NO | KODE_ANGGOTA  |      NAMA       |      ALAMAT                  |   No HP/Telp   |");
        System.out.println("+----+---------------+-----------------+------------------------------+----------------+");

        try {
            connect.state = connect.conn.createStatement();
            String sql_tampil_anggota = "SELECT kd_anggota,nama_anggota,alamat,no_telp from tbl_anggota";
            ResultSet Res = connect.state.executeQuery(sql_tampil_anggota);
            int no = 1;
            String status;

            //if(Res.last()==true){
            while (Res.next()) {
                System.out.println("  | " + no + "  |  " + Res.getString("kd_anggota") + " | " + Res.getString("nama_anggota") + "       | " + Res.getString("alamat") + " | " + Res.getString("no_telp") + "  | ");
                no++;
            }
            /*}
            else{
               System.out.println("  |                          TIDAK ADA DATA BUKU                             |");
            }*/
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        System.out.println("+----+---------------+-----------------+------------------------------+------------------+");
        System.out.println("|      +----------------------+ +-------------------------+  +-------------------------+ |");
        System.out.println("|      |HAPUS DATA ANGGOTA <H>| | TAMBAH DATA ANGGOTA <A> |  |   EDIT DATA ANGGOTA <E> | |");
        System.out.println("|      +----------------------| +-------------------------+  +-------------------------+ |");
        System.out.println("|      +----------------------+ +-------------------------+  +-------------------------+ |");
        System.out.println("|      |CARI DATA ANGGOTA <C> | |KEMBALI KE MENU <K>      |  | DETAIL DATA ANGGOTA <D> | |");
        System.out.println("|      +----------------------+ +-------------------------+  +-------------------------+ |");
        System.out.println("+----------------------------------------------------------------------------------------+");
    }

    void tambah_anggota() {

        String sql_last_anggota = "SELECT MAX(kd_anggota) AS 'kd_anggota' from tbl_anggota";
        int lastAnggota = 0;
        int lengthKdAnggota = 0;
        String tempKdAnggota = "";
        
        try {
            ResultSet Res = connect.state.executeQuery(sql_last_anggota);
            tempKdAnggota = Res.getString("kd_anggota");
            lengthKdAnggota = tempKdAnggota.length() - 1;
            
//            lastAnggota = Integer.parseInt(tempKdAnggota.) + 1;
        } catch (SQLException e) {
            System.out.println("Gagal mendapatkan last annggota: " + e.getMessage());
        }
        
        Date tgl                = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        String today = ""; // format kaya yg di ModulBuku

        // Simpan current date+lastAnggota di kode_anggota
        kode_anggota = ""; // today+lastAnggota
        
        System.out.println("  Masukkan Kode Anggota   : " + kode_anggota);
        System.out.print("  Masukkan Nama Anggota   : ");
        nama = SC.nextLine();
        System.out.print("  Masukkan Alamat         : ");
        alamat = SC.nextLine();
        System.out.print("  Masukkan No Telp        : ");
        no_telp = SC.nextLine();
        System.out.print("  Masukkan Pekerjaan      : ");
        pekerjaan = SC.nextLine();
        System.out.print("  Masukkan Instansi       : ");
        instansi = SC.nextLine();
        System.out.print("  Masukkan Alamat Instansi: ");
        alamat_instansi = SC.nextLine();
        try {
            String sql_tambah_anggota = "INSERT INTO tbl_anggota VALUES('" + kode_anggota + "','" + nama + "','" + alamat + "','" + no_telp + "','" + pekerjaan + "','" + instansi + "','" + alamat_instansi + "')";

            if (connect.state.execute(sql_tambah_anggota)) {
                System.out.println("  ----------------------------------------------------------------------------");
                System.out.println("               ANGGOTA DENGAN KODE Bm");
                System.out.println("  ----------------------------------------------------------------------------");
            } else {
                System.out.println("  ----------------------------------------------------------------------------");
                System.out.println("                       ! KODE ANGGOTA  TIDAK DITEMUKAN");
                System.out.println("  ----------------------------------------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    void hapus_anggota() {
        String kode;
        System.out.print("  Masukkan Kode Anggota\t: ");
        kode = SC.nextLine();
        try {
            String sql_cek_kode = "SELECT * FROM tbl_anggota where kd_anggota='" + kode + "'";
            ResultSet RS = connect.state.executeQuery(sql_cek_kode);
            if (RS.next() == true) {
                String sql_hapus_anggota = "DELETE FROM tbl_anggota where kd_anggota='" + kode + "'";
                connect.state.execute(sql_hapus_anggota);
                System.out.println("  ----------------------------------------------------------------------------");
                System.out.println("               ANGGOTA DENGAN KODE " + kode + " TELAH DIHAPUS");
                System.out.println("  ----------------------------------------------------------------------------");
            } else {
                System.out.println("  ----------------------------------------------------------------------------");
                System.out.println("                       ! KODE ANGGOTA " + kode + " TIDAK DITEMUKAN");
                System.out.println("  ----------------------------------------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    void detail_anggota() {
        String kode;
        System.out.print("  Masukkan Kode Anggota\t: ");
        kode = SC.nextLine();
        try {
            String sql_detail_anggota = "SELECT * FROM tbl_anggota where kd_anggota ='" + kode + "'";
            ResultSet Res = connect.state.executeQuery(sql_detail_anggota);
            if (Res.next() == true) {
                System.out.println("  +--------------------------------------------------------------------------+");
                System.out.println("  |                               DETAIL ANGGOTA                             |");
                System.out.println("  +--------------------------------------------------------------------------+");
                System.out.println("    KODE ANGGOTA\t\t : " + Res.getString("kd_anggota"));
                System.out.println("    NAMA ANGGOTA\t\t : " + Res.getString("nama_anggota"));
                System.out.println("    ALAMAT\t\t       : " + Res.getString("alamat"));
                System.out.println("    NO. HP/TELP\t    : " + Res.getString("no_telp"));
                System.out.println("    PEKERJAAN\t      : " + Res.getString("pekerjaan"));
                System.out.println("    INSTANSI\t\t     : " + Res.getString("instansi"));
                System.out.println("    ALAMAT INSTANSI\t: " + Res.getString("alamat_instansi"));
                System.out.println("  ----------------------------------------------------------------------------");

            } else {
                System.out.println("  ----------------------------------------------------------------------------");
                System.out.println("                       ! KODE ANGGOTA " + kode + " TIDAK DITEMUKAN");
                System.out.println("  ----------------------------------------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    void cari_anggota() {
        String kode_menu, kode_anggota, nama_anggota, alamat;
        System.out.println("  +--------------------------------------------------------------------------+");
        System.out.println("  |                                CARI ANGGOTA                              |");
        System.out.println("  +--------------------------------------------------------------------------+");
        System.out.println("  | Cari Berdasarkan :                                                       |");
        System.out.println("  |                    1. KODE ANGGOTA                                       |");
        System.out.println("  |                    2. NAMA ANGGOTA                                       |");
        System.out.println("  |                    3. ALAMAT                                             |");
        System.out.println("  +--------------------------------------------------------------------------+");

        System.out.print("    Pilih Menu\t\t: ");
        kode_menu = SC.nextLine();
        while (!"1".equals(kode_menu) && !"2".equals(kode_menu) && !"3".equals(kode_menu)) {
            System.out.println("  ----------------------------------------------------------------------------");
            System.out.println("  |                  MASUKAN SALAH ! SILAHKAN ULANGI KEMBALI                 |");
            System.out.println("  ----------------------------------------------------------------------------");
            System.out.print("    Pilih Menu\t\t: ");
            kode_menu = SC.nextLine();
        }

        switch (kode_menu) {
            case "1":
                System.out.print("    Masukkan Kode Anggota\t: ");
                kode_anggota = SC.nextLine();
                this.hasil_pencarian_kode_anggota(kode_anggota);
                break;
            case "2":
                System.out.print("    Masukkan Nama Anggota\t: ");
                nama_anggota = SC.nextLine();
                this.hasil_pencarian("nama_anggota", nama_anggota, "NAMA ANGGOTA");
                break;
            case "3":
                System.out.print("    Masukkan Alamat\t: ");
                alamat = SC.nextLine();
                this.hasil_pencarian("alamat", alamat, "ALAMAT");
                break;
        }
    }

    void hasil_pencarian(String param_field, String param_value, String param_title) {
        String field, value, title;
        field = param_field;
        value = param_value;
        title = param_title;

        System.out.println("  +--------------------+-----------------+---------------+--------+----------+");
        System.out.println("  |              HASIL PENCARIAN BERDASARKAN " + title + "                  |");
        System.out.println("  +----+---------------+-----------------+---------------+--------+----------+");
        System.out.println("  | NO |  KODE ANGGOTA  |   NAMA ANGGOTA |   ALAMAT   |  NO_TELP | pekerjaan |");
        System.out.println("  +----+---------------+-----------------+---------------+--------+----------+");
        try {
            connect.state = connect.conn.createStatement();
            String sql_tampil_anggota = "SELECT kd_anggota, nama_anggota, alamat, no_telp, pekerjaan from tbl_anggota where " + field + " like '%" + value + "%'";
            ResultSet Res = connect.state.executeQuery(sql_tampil_anggota);
            int no = 1;
            String status;

            while (Res.next()) {
                System.out.println("  | " + no + "  |  " + Res.getString("kd_anggota") + " | " + Res.getString("nama_anggota") + "       | " + Res.getString("alamat") + " | " + Res.getString("no_telp") + "  | " + Res.getString("pekerjaan") + "|");
                no++;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        System.out.println("  +--------------------------------------------------------------------------+");
    }

    void hasil_pencarian_kode_anggota(String kode) {
        String kode_anggota;
        kode_anggota = kode;
        System.out.println("  +--------------------+-----------------+---------------+--------+-----------+");
        System.out.println("  |                    HASIL PENCARIAN BERDASRKAN KODE ANGGOTA                |");
        System.out.println("  +------------------+-------------------+------------+-----------+-----------+");
        System.out.println("  |    KODE ANGGOTA  |  NAMA ANGGOTA     |   ALAMAT   |  NO_TELP  | PEKERJAAN |");
        System.out.println("  +------------------+-------------------+------------+-----------+-----------+");
        try {
            connect.state = connect.conn.createStatement();
            String sql_cari_kode_anggota = "SELECT kd_anggota, nama_anggota, alamat, no_telp, pekerjaan from tbl_anggota where kd_anggota='" + kode_anggota + "'";
            ResultSet Res = connect.state.executeQuery(sql_cari_kode_anggota);

            String status;

            if (Res.next() == true) {

                System.out.println("  |    " + Res.getString("kd_anggota") + "    | " + Res.getString("nama_anggota") + "       | " + Res.getString("alamat") + " | " + Res.getString("no_telp") + "  | " + Res.getString("pekerjaan"));
            } else {
                System.out.println("         ! DATA ANGGOTA DENGAN KODE ANGGOTA " + kode + " TIDAK DITEMUKAN");

            }
            System.out.println("  +--------------------------------------------------------------------------+");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    void edit_anggota() {

        String kode;
        System.out.print("  Masukkan Kode Anggota\t: ");
        kode = SC.nextLine();
        try {
            String sql_cek_kode = "SELECT * FROM tbl_anggota where kd_anggota='" + kode + "';";
            ResultSet Res = connect.state.executeQuery(sql_cek_kode);
            if (Res.next() == true) {

                System.out.println("  +--------------------------------------------------------------------------+");
                System.out.println("  |                               DETAIL ANGGOTA                             |");
                System.out.println("  +--------------------------------------------------------------------------+");
                System.out.println("    KODE ANGGOTA\t\t  : " + Res.getString("kd_anggota"));
                System.out.println("    NAMA ANGGOTA\t\t  : " + Res.getString("nama_anggota"));
                System.out.println("    ALAMAT\t\t        : " + Res.getString("alamat"));
                System.out.println("    NO. HP/TELP\t     : " + Res.getString("no_telp"));
                System.out.println("    PEKERJAAN\t       : " + Res.getString("pekerjaan"));
                System.out.println("    INSTANSI\t\t      : " + Res.getString("instansi"));
                System.out.println("    ALAMAT INSTANSI\t : " + Res.getString("alamat_instansi"));
                System.out.println("  ----------------------------------------------------------------------------");

                System.out.print("  Masukkan Nama Anggota        : ");
                nama = SC.nextLine();
                System.out.print("  Masukkan Alamat              : ");
                alamat = SC.nextLine();
                System.out.print("  Masukkan Pekerjaan           : ");
                pekerjaan = SC.nextLine();
                System.out.print("  Masukkan Instansi            : ");
                instansi = SC.nextLine();
                System.out.print("  Masukkan Alamat Instansi     : ");
                alamat_instansi = SC.nextLine();
                try {
                    String sql_edit_anggota = "UPDATE tbl_anggota set nama_anggota='" + nama + "',alamat='" + alamat + "',pekerjaan='" + pekerjaan + "',instansi='" + instansi
                            + "',alamat_instansi='" + alamat_instansi + "' where kd_anggota='" + kode + "'";
                    connect.state.execute(sql_edit_anggota);
                    System.out.println("  +--------------------------------------------------------------------------+");
                    System.out.println("  |                              EDIT DATA ANGGOTA                             |");
                    System.out.println("  +--------------------------------------------------------------------------+");
                    System.out.print("    Masukkan Kode Buku\t: ");
                    kode = SC.nextLine();

                    System.out.println("  +--------------------------------------------------------------------------+");
                    System.out.println("  | *Jika Data Sama Harap Masukkan Kembali. Tidak Boleh Dikosongkan !        |");
                    System.out.println("  +--------------------------------------------------------------------------+");
                    System.out.println("  |                   DATA AWAL                  |      DATA PENGGANTI       |");
                    System.out.println("  +--------------------------------------------------------------------------+");
                } catch (SQLException e) {
                    System.out.println(e.toString());
                }

            } else {
                System.out.println("  ----------------------------------------------------------------------------");
                System.out.println("                       ! KODE ANGGOTA " + kode + " TIDAK DITEMUKAN");
                System.out.println("  ----------------------------------------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        Anggota agt = new Anggota();
        char pilihan;
        agt.tampil_anggota();
        System.out.print("Pilihan Anda :");
        agt.pilihan = SC.next().charAt(0);

        switch (agt.pilihan) {
            case 'H':
                agt.hapus_anggota();
                break;
            case 'A':
                agt.tambah_anggota();
                break;
            case 'E':
                agt.edit_anggota();
                break;
            case 'C':
                agt.cari_anggota();
                break;
            case 'D':
                agt.detail_anggota();
                break;
        }

    }
}
