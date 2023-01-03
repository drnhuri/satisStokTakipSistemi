/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bilgi.VeriTabani;
import Bilgi.Veriler;
import Controller.StokGuncelleController;
import Controller.UrunEkleController;
import View.StokGuncelleView;
import View.UrunEkleView;

/**
 *
 * @author sevinc
 */
public class PersonelEkranModel {
    VeriTabani vti = new VeriTabani();
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
    
    public String kur(){
         Veriler veriler = new Veriler();
         veriler.veri();
        String kur = "<html>Güncel Dolar Satış Kuru;<br/>"+veriler.veri()+"</html>";
    return kur;
    }
    public String toplamTutar(int miktar , String urunSeriNo){
       String sonuc =  vti.toplamTutar(miktar, urunSeriNo);
        return sonuc;
    }
    public boolean urunSatisKontrol(String urunSeriNo){
        boolean kontrol = vti.urunKontrol(urunSeriNo);
        return kontrol;
    }
    public boolean satis(int miktar , String urunSeriNo){
      return vti.urunSat(miktar, urunSeriNo);
    }
    public void urunSil(String tabloAdi,String pointer ,String deger){
        vti.sil(tabloAdi, pointer, deger);
    }
}
