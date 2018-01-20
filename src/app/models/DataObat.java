/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import net.sf.persist.annotations.Column;

/**
 *
 * @author G-Eight
 */
public class DataObat {
    private String kd, name, variety;
    private int value;

    public DataObat() {
    }

    public DataObat(String kd, String name, String variety, int value) {
        this.kd = kd;
        this.name = name;
        this.variety = variety;
        this.value = value;
    }

    @Column(name="kode_obat")
    public String getKd() {
        return kd;
    }

    public void setKd(String kd) {
        this.kd = kd;
    }

    @Column(name="nama_obat")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "jenis")
    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    @Column(name = "value_obat")
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
