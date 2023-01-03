/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author sevinc
 */
import Bilgi.VeriTabaniIslemler;
import Controller.PersonelEkranController;
import Controller.YoneticiPanelController;
import View.PersonelEkranView;
import View.YoneticiPaneliView;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GirisModel {

    // kullanicinin
    public void gKontrol(String tcKimlikNo, String sifre) {
        try {
            VeriTabaniIslemler vti = new VeriTabaniIslemler() {
            };
            //girilen bilgiler personelemi ait yoksa yöneticiyemi
            if (vti.girisKontrol(tcKimlikNo, sifre) == 1) {
                PersonelEkranView personelEkranView = new PersonelEkranView();
                PersonelEkranModel personelEkranModel = new PersonelEkranModel();
                PersonelEkranController personelEkranController = new PersonelEkranController(personelEkranModel, personelEkranView);
            } else if (vti.girisKontrol(tcKimlikNo, sifre) == 2) {
                YoneticiPanelModel yoneticiPanelModel = new YoneticiPanelModel();
                YoneticiPaneliView yoneticiPaneliView = new YoneticiPaneliView();
                YoneticiPanelController controller = new YoneticiPanelController(yoneticiPanelModel, yoneticiPaneliView);
            } else {
                JOptionPane.showMessageDialog(null, "Bilgileri eksiksiz ve doğru giriniz.", "Uyarı", 0);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Veritabanına bağlanmadı.", "Uyarı", 0);

        }

    }

}
