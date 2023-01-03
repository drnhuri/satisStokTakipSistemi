/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bilgi;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author sevinc
 */
public class Stok {
    private String urunSeriNO;
    private int satilanMiktar ,alinanMiktar;
    private Date tarih;
 

    public String getUrunSeriNO() {
        return urunSeriNO;
    }

    public void setUrunSeriNO(String urunSeriNO) {
        this.urunSeriNO = urunSeriNO;
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

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

}
