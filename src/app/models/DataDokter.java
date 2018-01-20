package app.models;

import net.sf.persist.annotations.Column;

public class DataDokter {
    private String id_dokter, nama_dokter, riwayat_pendidikan, alamat_dokter,
                   nomor_telepon_dokter;
    private int value_dokter;

    public DataDokter() {
    }

    public DataDokter(String id_dokter, String nama_dokter, String riwayat_pendidikan, String alamat_dokter, String nomor_telepon_dokter, int value_dokter) {
        this.id_dokter = id_dokter;
        this.nama_dokter = nama_dokter;
        this.riwayat_pendidikan = riwayat_pendidikan;
        this.alamat_dokter = alamat_dokter;
        this.nomor_telepon_dokter = nomor_telepon_dokter;
        this.value_dokter = value_dokter;
    }
    
    public String getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(String id_dokter) {
        this.id_dokter = id_dokter;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getRiwayat_pendidikan() {
        return riwayat_pendidikan;
    }

    public void setRiwayat_pendidikan(String riwayat_pendidikan) {
        this.riwayat_pendidikan = riwayat_pendidikan;
    }

    public String getAlamat_dokter() {
        return alamat_dokter;
    }

    public void setAlamat_dokter(String alamat_dokter) {
        this.alamat_dokter = alamat_dokter;
    }

    @Column(name="nomor_telepon")
    public String getNomor_telepon_dokter() {
        return nomor_telepon_dokter;
    }

    public void setNomor_telepon_dokter(String nomor_telepon_dokter) {
        this.nomor_telepon_dokter = nomor_telepon_dokter;
    }

    public int getValue_dokter() {
        return value_dokter;
    }

    public void setValue_dokter(int value_dokter) {
        this.value_dokter = value_dokter;
    }


}
