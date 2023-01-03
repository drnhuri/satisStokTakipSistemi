/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GirisModel;
import View.GirisView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author sevinc
 */
public class GirisController {

    private GirisModel girisModel;
    private GirisView girisView;

    public GirisController(GirisModel girisModel, GirisView girisView) {
        this.girisModel = girisModel;
        this.girisView = girisView;
        this.girisView.girisBtnListener(new AddGirisListener());
    }

    class AddGirisListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                girisModel.gKontrol(girisView.getkTCgiris(),girisView.getkSifreGiris());
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null,"Bilgileri eksiksiz ve doğru giriniz.","Uyarı",0);
               
            }
        }
    }

}
