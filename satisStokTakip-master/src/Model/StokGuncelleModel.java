/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bilgi.Urunler;
import Bilgi.VeriTabaniIslemler;

/**
 *
 * @author sevinc
 */
public class StokGuncelleModel {
VeriTabaniIslemler vti = new VeriTabaniIslemler() {};
    public void stokGuncelle(String urunSeriNo, int miktar, float satisFiyati) {
        Urunler urun = new Urunler();
        urun.setUrunSeriNo(urunSeriNo);
        urun.setSatisFiyati(satisFiyati);
        urun.setMiktar(miktar);
        vti.Guncelle(urun.getUrunSeriNo(), urun.getMiktar(), urun.getSatisFiyati());
    }

}
