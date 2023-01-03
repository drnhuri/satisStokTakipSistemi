/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UrunEkleModel;
import View.UrunEkleView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JOptionPane;

/**
 *
 * @author sevinc
 */
public class UrunEkleController {

    private UrunEkleModel urunEkleModel;
    private UrunEkleView urunEkleView;

    public UrunEkleController(UrunEkleModel urunEkleModel, UrunEkleView urunEkleView) {
        this.urunEkleModel = urunEkleModel;
        this.urunEkleView = urunEkleView;
        this.urunEkleView.urunEkleBtnListener(new AddUrunEkleListener());
        this.urunEkleView.katagoriListener(new AddKatagoriListener());
        this.urunEkleModel.katagoriGuncelle(this.urunEkleView.getKtgrIsmiBox());

       
    }
class  AddKatagoriListener implements ItemListener{

        @Override
        //Yeni bir katagori eklerse yeni katagori textfieldını açıyoruz
        //var olan katagoriyi seçerse textfield görünür hale geliyor
        public void itemStateChanged(ItemEvent e) {
                   if (urunEkleView.getKtgrIsmiBox().getSelectedIndex() == 0) {
            urunEkleView.getKtgrIsmi2TextField().setVisible(true);
        } else {
            urunEkleView.getKtgrIsmi2TextField().setVisible(false);
        }
        }
}
    class AddUrunEkleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //TextFieldların boş olup olmadığını kontrol ediyoruz
            try {
                if (urunEkleView.getUrunAdiText().trim().isEmpty() || String.valueOf(urunEkleView.getAlisFiyatText()).trim().isEmpty()
                        || String.valueOf(urunEkleView.getMiktarText()).trim().isEmpty() || String.valueOf(urunEkleView.getSatisFiyatText()).trim().isEmpty()
                        || urunEkleView.getUrunSeriNoText().trim().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Bilgilerin eksiksiz olduğundan emin olun...", "Uyarı", HEIGHT);

                } else {
                    //yeni bir katagori veya var oğlan katagoriyemi eklemek istiyor onu nkontrol ediyoruz
                    if (urunEkleView.getKtgrIsmiBoxItem() != 0) {

                        urunEkleModel.urunEkle(urunEkleView.getUrunSeriNoText(), urunEkleView.getKtgrIsmiBox().getItemCount()-1,
                                urunEkleView.getMiktarText(), urunEkleView.getBirimBox(), urunEkleView.getAlisFiyatText(), urunEkleView.getSatisFiyatText(), urunEkleView.getUrunAdiText());

                    } else {
                        if (!urunEkleView.getKtgrIsmi2Text().trim().isEmpty()) {
                            try {
                                //yeni katagori ise katagorileri güncelleyip ürünü ve katagoriyi ekliyoruz
                                urunEkleModel.katagoriEkle(urunEkleView.getKtgrIsmi2Text());

                                urunEkleModel.katagoriGuncelle(urunEkleView.getKtgrIsmiBox());
                                
                                urunEkleModel.urunEkle(urunEkleView.getUrunSeriNoText(), urunEkleView.getKtgrIsmiBox().getItemCount()-1,
        urunEkleView.getMiktarText(), urunEkleView.getBirimBox(), urunEkleView.getAlisFiyatText(), urunEkleView.getSatisFiyatText(), urunEkleView.getUrunAdiText());

                            } catch (Error e1) {
                                JOptionPane.showMessageDialog(null, "Ürün eklenmedi ! \n"
                                        + "Bilgilerin eksiksiz ve doğru olduğundan emin olun...");

                            }

                        }

                    }

                }

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Bilgileri eksiksiz ve doğru giriniz.", "Uyarı", 0);

            }
        }
    }

}
