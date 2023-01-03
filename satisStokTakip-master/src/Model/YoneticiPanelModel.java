/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bilgi.Personeller;
import Bilgi.VeriTabaniIslemler;
import Controller.PersonelEkranController;
import Controller.RaporGoruntuleController;
import Controller.StokGuncelleController;
import Controller.UrunEkleController;
import View.PersonelEkranView;
import View.RaporGoruntuleView;
import View.StokGuncelleView;
import View.UrunEkleView;
import View.YoneticiPaneliView;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

;

/**
 *
 * @author sevinc
 */
public class YoneticiPanelModel {
      
    VeriTabaniIslemler vti = new VeriTabaniIslemler() {};
    
    // calisan ekleme metodu    

    public void calisanEkle(String ad, String Soyad, String Cinsiyet, int maas, String tc, int departman, String sifre) {

        Personeller personel = new Personeller();
        personel.setIsim(ad);
        personel.setCinsiyet(Cinsiyet);
        personel.setDepartman(departman);
        personel.setMaas(maas);
        personel.setSoyisim(Soyad);
        personel.setTcKN(tc);
        personel.setSifre(sifre);
        vti.calisanEkle(personel.getIsim(), personel.getSoyisim(), personel.getCinsiyet(),
                personel.getMaas(), personel.getTcKN(), personel.getDepartman(), personel.getSifre());

    }

    public void calisanGncll(String tcKimlikNo, int maas, int departman) {
        Personeller personel = new Personeller();
        personel.setDepartman(departman);
        personel.setMaas(maas);
        personel.setTcKN(tcKimlikNo);
        vti.Guncelle(personel.getTcKN(), personel.getMaas(), personel.getDepartman());
    }

    public void raporEkran() {
        RaporGoruntuleView raporGoruntuleView = new RaporGoruntuleView();
        RaporGoruntuleModel raporGoruntuleModel = new RaporGoruntuleModel();
        RaporGoruntuleController raporGoruntuleController = new RaporGoruntuleController(raporGoruntuleModel, raporGoruntuleView);
    }

    public void personelEkran() {
        PersonelEkranView personelEkranView = new PersonelEkranView();
        PersonelEkranModel personelEkranModel = new PersonelEkranModel();
        PersonelEkranController personelEkranController = new PersonelEkranController(personelEkranModel, personelEkranView);
    }

    public void stokEkran() {
        StokGuncelleView stokGuncelleView = new StokGuncelleView();
        StokGuncelleModel stokGuncelleModel = new StokGuncelleModel();
        StokGuncelleController stokGuncelleController = new StokGuncelleController(stokGuncelleModel, stokGuncelleView);
    }

    public void urunEkleEkran() {
        UrunEkleView urunEkleView = new UrunEkleView();
        UrunEkleModel urunEkleModel = new UrunEkleModel();
        UrunEkleController urunEkleController = new UrunEkleController(urunEkleModel, urunEkleView);
    }
    
    

}
