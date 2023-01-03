/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bilgi.TabloKontrol;
import Model.StokGuncelleModel;
import View.StokGuncelleView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author sevinc
 */
public class StokGuncelleController {

    private StokGuncelleModel stokGuncelleModel;
    private StokGuncelleView stokGuncelleView;
    private TabloKontrol tabloKontrol ;

    public StokGuncelleController(StokGuncelleModel stokGuncelleModel, StokGuncelleView stokGuncelleView) {
        this.stokGuncelleModel = stokGuncelleModel;
        this.stokGuncelleView = stokGuncelleView;
        this.stokGuncelleView.AddGuncelleBtn(new AddGncllBtnListener());
        this.stokGuncelleView.blgTabloSiralaMouseListener(new AddBilgiTabloSırala());
        this.stokGuncelleView.blgTabloMouseListener(new AddBilgiTabloListener());
    }

    class AddGncllBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Textfieldların boşluk kontrolu ve stoğun güncellenmesi
            try {
                if (stokGuncelleView.getUrunSeriNoText().trim().isEmpty() || stokGuncelleView.getySatisText().trim().isEmpty() || stokGuncelleView.getyStokText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Boşlukları dolddurun.", "Uyarı", 0);
                }
                else{
                    
                    stokGuncelleModel.stokGuncelle(stokGuncelleView.getUrunSeriNoText(), Integer.parseInt(stokGuncelleView.getyStokText()), Float.parseFloat(stokGuncelleView.getySatisText().replace(",",".")));
                    TabloKontrol tabloKontrol = new TabloKontrol();
                 stokGuncelleView.updateTable(tabloKontrol.getDefaultTable("Urunler"));
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Birşeyler ters gitti tekrar deneyiniz.", "Uyarı", 0);
                e1.printStackTrace();
            }
        }
    }
    
    class AddBilgiTabloSırala extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e); 
                
            tabloKontrol = new TabloKontrol();
            String columnName = stokGuncelleView.getDefaultTableModel().getColumnName(stokGuncelleView.getBilgiTablo().columnAtPoint(e.getPoint()));
            stokGuncelleView.updateTable(tabloKontrol.getSortedTable("Urunler" ,columnName));
        }
     
     
     
    }
 
 class AddBilgiTabloListener extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            stokGuncelleView.setUrunSeriNoText((String) stokGuncelleView.getBilgiTablo().getValueAt(stokGuncelleView.getBilgiTablo().rowAtPoint(e.getPoint()), 0));
            stokGuncelleView.setySatisText((String) stokGuncelleView.getBilgiTablo().getValueAt(stokGuncelleView.getBilgiTablo().rowAtPoint(e.getPoint()), 3));
            stokGuncelleView.setyStokText((String) stokGuncelleView.getBilgiTablo().getValueAt(stokGuncelleView.getBilgiTablo().rowAtPoint(e.getPoint()), 6));

        }

     
 }
    
}
