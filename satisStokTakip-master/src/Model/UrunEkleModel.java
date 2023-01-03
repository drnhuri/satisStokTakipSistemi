/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bilgi.Katagoriler;
import Bilgi.Urunler;
import Bilgi.VeriTabaniIslemler;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author sevinc
 */
public class UrunEkleModel {
    VeriTabaniIslemler vti = new VeriTabaniIslemler() {};
    
    public void urunEkle(String urunSeriNo, int katagoriId, int miktar, String birim, float alisFiyati, float SatisFiyati, String urunAdi){
                             Urunler urun = new Urunler();
                             urun.setUrunSeriNo(urunSeriNo);
                             urun.setUrunAdi(urunAdi);
                             urun.setAlisFiyati(alisFiyati);
                             urun.setSatisFiyati(SatisFiyati);
                             urun.setMiktar(miktar);
                             urun.setKatagoriId(katagoriId);
                             urun.setBirimCinsi(birim);
                             vti.urunEkle(urun.getUrunSeriNo(), urun.getKatagoriId(),
                        urun.getMiktar(), urun.getBirimCinsi(), urun.getAlisFiyati(), urun.getSatisFiyati(), urun.getUrunAdi());
    }
    public void katagoriEkle(String katagoriAdi){
        vti.katagoriEkle(katagoriAdi);
    }
    
    public void katagoriGuncelle(JComboBox katagoriIsimBox){
            Katagoriler katagori = new Katagoriler();
            ArrayList<String> guncelKatagori = katagori.katagoriler();
            katagoriIsimBox.removeAllItems();
            katagoriIsimBox.addItem("Yeni Katagori Ekle");
            for (int i = 0; i < guncelKatagori.size(); i++) {
                katagoriIsimBox.addItem(guncelKatagori.get(i));
         
     }
}
}