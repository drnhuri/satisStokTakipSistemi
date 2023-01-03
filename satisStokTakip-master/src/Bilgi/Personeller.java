/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bilgi;

import java.util.ArrayList;
/**
 *
 * @author sevinc
 */
public class Personeller {
    private String isim ,soyisim ,cinsiyet,sifre,tcKN;
    private int maas , departman;
  

    public Personeller(String isim, String soyisim, String cinsiyet, String sifre, int maas, int departman, String tcKN) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.cinsiyet = cinsiyet;
        this.sifre = sifre;
        this.maas = maas;
        this.departman = departman;
        this.tcKN = tcKN;
       
    }

    public Personeller() {
    }


    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public int getDepartman() {
        return departman;
    }

    public void setDepartman(int departman) {
        this.departman = departman;
    }

    public String getTcKN() {
        return tcKN;
    }

    public void setTcKN(String tcKN) {
        this.tcKN = tcKN;
    }

	

}
