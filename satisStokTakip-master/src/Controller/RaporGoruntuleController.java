/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RaporGoruntuleModel;
import View.RaporGoruntuleView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author sevinc
 */
public class RaporGoruntuleController {

    private RaporGoruntuleView raporGoruntuleView;
    private RaporGoruntuleModel raporGoruntuleModel;
   

    public RaporGoruntuleController(RaporGoruntuleModel raporGoruntuleModel, RaporGoruntuleView raporGoruntuleView) {
        this.raporGoruntuleModel = raporGoruntuleModel;
        this.raporGoruntuleView = raporGoruntuleView;
        this.raporGoruntuleView.goruntuleBtn(new AddRaporBtnListener());

    }

    class AddRaporBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                boolean kontrol = raporGoruntuleModel.rprGoruntule(raporGoruntuleView.getBaslaChooser(), raporGoruntuleView.getBitisChooser());
                if (kontrol) {

                    
                    raporGoruntuleView.updateTable(raporGoruntuleModel.getDefaultTable(raporGoruntuleModel.getDf().format(raporGoruntuleView.getBaslaChooser().getDate()),
                            raporGoruntuleModel.getDf().format(raporGoruntuleView.getBitisChooser().getDate())));
                } else {
                    JOptionPane.showMessageDialog(null, "Geçerli Tarih Seçiniz..", "Uyarı", 0);
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Birşeyler ters gitti tekrar deneyiniz.", "Uyarı", 0);

            }

        }

    }

}
