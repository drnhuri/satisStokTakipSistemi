/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bilgi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hurud
 */
public class Urun extends Kategori {

    private int id;
    private int kategoriId;
    private String urunAd;
    private int miktar;
    private float fiyat;
    
    VeriTabaniIslemleri veriTabani = new VeriTabaniIslemleri();
    
    //public void UrunEkle(int id, int)

    public Urun() {

    }

    public Urun(int id, int kategoriId, String urunAd, int miktar, float fiyat) {
        this.id = id;
        this.kategoriId = kategoriId;
        this.urunAd = urunAd;
        this.miktar = miktar;
        this.fiyat = fiyat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getUrunAd() {
        return urunAd;
    }

    public void setUrunAd(String urunAd) {
        this.urunAd = urunAd;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public float getFiyat() {
        return fiyat;
    }

    public void setFiyat(float fiyat) {
        this.fiyat = fiyat;
    }
    
   
}
