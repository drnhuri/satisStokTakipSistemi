/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bilgi;



/**
 *
 * @author sevinc
 */
public class Urunler {
    private String urunSeriNo , urunAdi,birimCinsi;
    private int katagoriId ,miktar ;
    private float alisFiyati ,satisFiyati;
  
    public Urunler() {
    }

    public String getUrunSeriNo() {
        return urunSeriNo;
    }

    public void setUrunSeriNo(String urunSeriNo) {
        this.urunSeriNo = urunSeriNo;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getBirimCinsi() {
        return birimCinsi;
    }

    public void setBirimCinsi(String birimCinsi) {
        this.birimCinsi = birimCinsi;
    }

    public int getKatagoriId() {
        return katagoriId;
    }

    public void setKatagoriId(int katagoriId) {
        this.katagoriId = katagoriId;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public float getAlisFiyati() {
        return alisFiyati;
    }

    public void setAlisFiyati(float alisFiyati) {
        this.alisFiyati = alisFiyati;
    }

    public float getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(float satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public Urunler(String urunSeriNo, String urunAdi, String birimCinsi, int katagoriId,int miktar, float alisFiyati, float satisFiyati) {
        this.urunSeriNo = urunSeriNo;
        this.urunAdi = urunAdi;
        this.birimCinsi = birimCinsi;
        this.katagoriId = katagoriId;
        this.miktar = miktar;
        this.alisFiyati = alisFiyati;
        this.satisFiyati = satisFiyati;
        
    }
    
  
	

    
    
    
    
}
