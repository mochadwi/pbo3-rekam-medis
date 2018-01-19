package app.models;

import net.sf.persist.annotations.Column;
import net.sf.persist.annotations.NoColumn;

public class DataPasien {
    // the attribute must be the same with db columns
    // to allow Persist auto-map the fields
    private String id_pasien, nama_pasien, umur, alamat_pasien, pekerjaan, jenis_kelamin, nomor_telepon, status_perkawinan, nomor_telepon_kerabat;
    private int value_pasien;

    public DataPasien() {
    }

    // id_pasien,nama_pasien,umur,alamat_pasien,pekerjaan,jenis_kelamin,nomor_telepon,status_perkawinan,nomor_telepon_kerabat,value_pasien

    public DataPasien(String id_pasien, String nama_pasien, String umur, String alamat_pasien, String pekerjaan, String jenis_kelamin, String nomor_telepon, String status_perkawinan, String nomor_telepon_kerabat, int value_pasien) {
        this.id_pasien = id_pasien;
        this.nama_pasien = nama_pasien;
        this.umur = umur;
        this.alamat_pasien = alamat_pasien;
        this.pekerjaan = pekerjaan;
        this.jenis_kelamin = jenis_kelamin;
        this.nomor_telepon = nomor_telepon;
        this.status_perkawinan = status_perkawinan;
        this.nomor_telepon_kerabat = nomor_telepon_kerabat;
        this.value_pasien = value_pasien;
    }

    public String getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(String id_pasien) {
        this.id_pasien = id_pasien;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getAlamat_pasien() {
        return alamat_pasien;
    }

    public void setAlamat_pasien(String alamat_pasien) {
        this.alamat_pasien = alamat_pasien;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNomor_telepon() {
        return nomor_telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }

    public String getStatus_perkawinan() {
        return status_perkawinan;
    }

    public void setStatus_perkawinan(String status_perkawinan) {
        this.status_perkawinan = status_perkawinan;
    }

    public String getNomor_telepon_kerabat() {
        return nomor_telepon_kerabat;
    }

    public void setNomor_telepon_kerabat(String nomor_telepon_kerabat) {
        this.nomor_telepon_kerabat = nomor_telepon_kerabat;
    }

    public int getValue_pasien() {
        return value_pasien;
    }

    public void setValue_pasien(int value_pasien) {
        this.value_pasien = value_pasien;
    }
}
