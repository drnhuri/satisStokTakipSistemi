/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bilgi;

/**
 *
 * @author hurud
 */
public class Personel extends Departman{
    
    VeriTabaniIslemleri veriTabani = new VeriTabaniIslemleri();

    private int id;
    private String personelAd;
    private String personelSoyad;
    private String email;
    private String sifre;
    private int departman;

    
    public Personel() {

    }

    public Personel(int id, String personelAd, String personelSoyad, String email, String sifre, int departman) {
        this.id = id;
        this.personelAd = personelAd;
        this.personelSoyad = personelSoyad;
        this.email = email;
        this.sifre = sifre;
        this.departman = departman;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonelAd() {
        return personelAd;
    }

    public void setPersonelAd(String personelAd) {
        this.personelAd = personelAd;
    }

    public String getPersonelSoyad() {
        return personelSoyad;
    }

    public void setPersonelSoyad(String personelSoyad) {
        this.personelSoyad = personelSoyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public int getDepartman() {
        return departman;
    }

    public void setDepartman(int departman) {
        this.departman = departman;
    }

}
