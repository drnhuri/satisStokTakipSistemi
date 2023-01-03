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
public class Kategori {

    private int id;
    private String kategoriAd;
    

    public Kategori() {

    }

    public Kategori(int id, String kategoriAd) {
        this.id = id;
        this.kategoriAd = kategoriAd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKategoriAd() {
        return kategoriAd;
    }

    public void setKategoriAd(String kategoriAd) {
        this.kategoriAd = kategoriAd;
    }

}
