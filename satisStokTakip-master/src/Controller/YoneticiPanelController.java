/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bilgi.TabloKontrol;
import Model.YoneticiPanelModel;
import View.YoneticiPaneliView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JOptionPane;

/**
 *
 * @author sevinc
 */
public class YoneticiPanelController {

    private YoneticiPanelModel yoneticiPanelModel;
    private YoneticiPaneliView yoneticiPaneliView;
    private TabloKontrol tabloKontrol ;

    public YoneticiPanelController(YoneticiPanelModel yoneticiPanelModel, YoneticiPaneliView yoneticiPaneliView) {
        this.yoneticiPanelModel = yoneticiPanelModel;
        this.yoneticiPaneliView = yoneticiPaneliView;
        this.yoneticiPaneliView.prsnlEkranBtnListener(new AddPrsnlEkranBtnListener());
        this.yoneticiPaneliView.rprEkranBtnListener(new AddRprEkranBtnListener());
        this.yoneticiPaneliView.urunEkleEkranBtnListener(new AddUrunEkleEkranBtnListener());
        this.yoneticiPaneliView.stokBtnListener(new AddStokBtnListener());
        this.yoneticiPaneliView.calisanEkleBtnListener(new AddCalisanEkleBtnListener());
        this.yoneticiPaneliView.calisanGnclleBtnListener(new AddCalisanGnclleBtnListener());
        this.yoneticiPaneliView.blgTabloSiralaMouseListener(new AddBilgiTabloSırala());
        this.yoneticiPaneliView.blgTabloMouseListener(new AddBilgiTabloListener());
        
    }

    class AddCalisanEkleBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (yoneticiPaneliView.getAdText().trim().isEmpty() || yoneticiPaneliView.getSoyadText().trim().isEmpty()
                        || yoneticiPaneliView.getTcKNText().length() != 11
                        || yoneticiPaneliView.getSifreText().trim().isEmpty() || String.valueOf(yoneticiPaneliView.getMaasText()).trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Boş yer bırakmayınız. \n"
                            + "TC kimlik no 11 haneli olmak zorunda..", "Uyarı", HEIGHT);

                } else {
                    yoneticiPanelModel.calisanEkle(yoneticiPaneliView.getAdText(), yoneticiPaneliView.getSoyadText(), yoneticiPaneliView.getCinsiyetBox(),
                            yoneticiPaneliView.getMaasText(), yoneticiPaneliView.getTcKNText(), yoneticiPaneliView.getDepartmanBox(), yoneticiPaneliView.getSifreText());
                             TabloKontrol tabloKontrol = new TabloKontrol();
                 yoneticiPaneliView.updateTable(tabloKontrol.getDefaultTable("Personeller"));               
                }

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Boş yer bırakmayınız. \n"
                        + "TC kimlik no 11 haneli olmak zorunda..", "Uyarı", HEIGHT);

            }
        }
    }
 class AddBilgiTabloSırala extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e); 
                
                    tabloKontrol = new TabloKontrol();
            String columnName = yoneticiPaneliView.getDefaultTableModel().getColumnName(yoneticiPaneliView.getBilgiTablo().columnAtPoint(e.getPoint()));
            yoneticiPaneliView.updateTable(tabloKontrol.getSortedTable("Personeller" ,columnName));
        }
     
     
     
    }
 
 class AddBilgiTabloListener extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            yoneticiPaneliView.setYetkiTCText((String) yoneticiPaneliView.getBilgiTablo().getValueAt(yoneticiPaneliView.getBilgiTablo().rowAtPoint(e.getPoint()), 3));
            yoneticiPaneliView.setyMaasText((String) yoneticiPaneliView.getBilgiTablo().getValueAt(yoneticiPaneliView.getBilgiTablo().rowAtPoint(e.getPoint()), 5));
            
        }

     
 }

   class AddCalisanGnclleBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
               
                yoneticiPanelModel.calisanGncll(yoneticiPaneliView.getYetkiTCText(), yoneticiPaneliView.getyMaasText(), yoneticiPaneliView.getyPozisyonBox());
                TabloKontrol tabloKontrol = new TabloKontrol();
                 yoneticiPaneliView.updateTable(tabloKontrol.getDefaultTable("Personeller"));
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Bilgileri eksiksiz ve doğru giriniz.", "Uyarı", 0);
              
               
            }
        }
        
    }

    class AddStokBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                yoneticiPanelModel.stokEkran();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Birşeyler ters gitti tekrar deneyiniz.", "Uyarı", 0);
              
            }
        }
    }

    class AddRprEkranBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                yoneticiPanelModel.raporEkran();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Birşeyler ters gitti tekrar deneyiniz.", "Uyarı", 0);
              
            }
        }
    }

    class AddUrunEkleEkranBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                yoneticiPanelModel.urunEkleEkran();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Birşeyler ters gitti tekrar deneyiniz.", "Uyarı", 0);
               

            }
        }
    }

    class AddPrsnlEkranBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                yoneticiPanelModel.personelEkran();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Birşeyler ters gitti tekrar deneyiniz.", "Uyarı", 0);

            }
        }
    }
    
}
