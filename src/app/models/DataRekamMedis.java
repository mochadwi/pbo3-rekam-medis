package app.models;

import java.util.Date;
import net.sf.persist.annotations.Column;

public class DataRekamMedis {

    private String nomor_rm, nomor_pasien, id_dokter, kode_obat, id_user,
            tindakan, diagnosa, keluhan, value;
    private Date tglBerobat;

    public DataRekamMedis() {
    }

    public DataRekamMedis(String nomor_rm, String nomor_pasien, String id_dokter, String kode_obat, String id_user, String tindakan, String diagnosa, String keluhan, String value, Date tglBerobat) {
        this.nomor_rm = nomor_rm;
        this.nomor_pasien = nomor_pasien;
        this.id_dokter = id_dokter;
        this.kode_obat = kode_obat;
        this.id_user = id_user;
        this.tindakan = tindakan;
        this.diagnosa = diagnosa;
        this.keluhan = keluhan;
        this.value = value;
        this.tglBerobat = tglBerobat;
    }

    public String getNomor_rm() {
        return nomor_rm;
    }

    public void setNomor_rm(String nomor_rm) {
        this.nomor_rm = nomor_rm;
    }

    public String getNomor_pasien() {
        return nomor_pasien;
    }

    public void setNomor_pasien(String nomor_pasien) {
        this.nomor_pasien = nomor_pasien;
    }

    public String getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(String id_dokter) {
        this.id_dokter = id_dokter;
    }

    public String getKode_obat() {
        return kode_obat;
    }

    public void setKode_obat(String kode_obat) {
        this.kode_obat = kode_obat;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getTindakan() {
        return tindakan;
    }

    public void setTindakan(String tindakan) {
        this.tindakan = tindakan;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    @Column(name = "tanggal_berobat")
    public Date getTglBerobat() {
        return tglBerobat;
    }

    public void setTglBerobat(Date tglBerobat) {
        this.tglBerobat = tglBerobat;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
