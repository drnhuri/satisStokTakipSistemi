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
public class Stok extends Urun{

    private int id;
    private int urunId;
    private int satilanMiktar;
    private int alinanMiktar;

    public Stok() {

    }

    public Stok(int id, int urunId, int satilanMiktar, int alinanMiktar) {
        this.id = id;
        this.urunId = urunId;
        this.satilanMiktar = satilanMiktar;
        this.alinanMiktar = alinanMiktar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public int getSatilanMiktar() {
        return satilanMiktar;
    }

    public void setSatilanMiktar(int satilanMiktar) {
        this.satilanMiktar = satilanMiktar;
    }

    public int getAlinanMiktar() {
        return alinanMiktar;
    }

    public void setAlinanMiktar(int alinanMiktar) {
        this.alinanMiktar = alinanMiktar;
    }

}
