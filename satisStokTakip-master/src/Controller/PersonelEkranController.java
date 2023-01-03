/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bilgi.TabloKontrol;
import Model.PersonelEkranModel;
import View.PersonelEkranView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author sevinc
 */
public class PersonelEkranController {

    private PersonelEkranModel personelEkranModel;
    private PersonelEkranView personelEkranView;
    private TabloKontrol tabloKontrol;

    public PersonelEkranController(PersonelEkranModel personelEkranModel, PersonelEkranView personelEkranView) {
        this.personelEkranModel = personelEkranModel;
        this.personelEkranView = personelEkranView;

        this.personelEkranView.urunEkleBtn(new AddUrunEkleBtnListener());
        this.personelEkranView.stokBtn(new AddStokBtnListener());
        this.personelEkranView.kurBtn(new AddKurBtnListener());
        this.personelEkranView.tutarBtn(new AddTutarBtnListener());
        this.personelEkranView.satBtn(new AddSatBtnListener());
        this.personelEkranView.silBtn(new AddSilBtnListener());
        this.personelEkranView.blgTabloMouseListener(new AddBilgiTabloListener());
      
        

        //ilk başta kuru görüntülemek
        personelEkranView.setKur(personelEkranModel.kur());
    }

    class AddUrunEkleBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                personelEkranModel.urunEkleEkran();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Birşeyler ters gitti tekrar deneyiniz.", "Uyarı", 0);
                e1.printStackTrace();
            }
        }
    }

    class AddStokBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                personelEkranModel.stokEkran();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Birşeyler ters gitti tekrar deneyiniz.", "Uyarı", 0);
                e1.printStackTrace();
            }
        }
    }

    class AddKurBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                personelEkranView.setKur(personelEkranModel.kur());
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Birşeyler ters gitti tekrar deneyiniz.", "Uyarı", 0);
                e1.printStackTrace();
            }
        }
    }

    class AddTutarBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //bilgilerin eksik ve satılacak ürün adedinin 0 dan yüksek olduğunu kontrol ediyorum
                if (String.valueOf(personelEkranView.getsMiktarText()).trim().isEmpty() || personelEkranView.getSeriNoText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Bilgilerin Eksiksiz Girdiğinizden \n"
                            + "Emin Olun...\n"
                            + "(Ürün Seri No veya Adet boş bırakılmaz...)", "UYARI", 0);

                } else if (Integer.parseInt(personelEkranView.getsMiktarText()) <= 0) {
                    JOptionPane.showMessageDialog(null, "0 ' dan yüksek bir değer giriniz.", "UYARI", 0);
                } else {

                    personelEkranView.settTutarText(personelEkranModel.toplamTutar(Integer.parseInt(personelEkranView.getsMiktarText()), personelEkranView.getSeriNoText()));
                }

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Birşeyler ters gitti tekrar deneyiniz.", "Uyarı", 0);
                e1.printStackTrace();
            }
        }
    }

    class AddSatBtnListener implements ActionListener {
//bilgilerin eksik ve satılacak ürün adedinin 0 dan yüksek olduğunu kontrol ediyorum
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (personelEkranView.getsMiktarText().trim().isEmpty() || personelEkranView.getSeriNoText().trim().isEmpty()
                        || false == personelEkranModel.urunSatisKontrol(personelEkranView.getSeriNoText())) {

                    JOptionPane.showMessageDialog(null, "Seri No hatalı veya Satılacak adet girilmedi...", "UYARI", 0);

                } else if (Integer.parseInt(personelEkranView.getsMiktarText()) <= 0) {
                    JOptionPane.showMessageDialog(null, "0 ' dan yüksek bir değer giriniz.", "UYARI", 0);
                } else {
                     if (personelEkranModel.satis(Integer.parseInt(personelEkranView.getsMiktarText()), personelEkranView.getSeriNoText()) == true) {
                        JOptionPane.showMessageDialog(null, "Ürün satıldı.", "UYARI", 0);
                    }
                     
                    
                   

                }
                tabloKontrol = new TabloKontrol();
                personelEkranView.updateTable(tabloKontrol.getDefaultTable("Urunler"));
                

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Birşeyler ters gitti tekrar deneyiniz.", "Uyarı", 0);
                e1.printStackTrace();
            }
        }
    }
    class AddSilBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
              try {
                  
                if (personelEkranView.getSeriNoText().trim().isEmpty() || personelEkranModel.urunSatisKontrol(personelEkranView.getSeriNoText()) == false) {
                    JOptionPane.showMessageDialog(null, "Ürün seri no eksik veya hatalı... ", "UYARI", 0);

                } else {

                    personelEkranModel.urunSil("Urunler","urunSeriNo", personelEkranView.getSeriNoText());
                    JOptionPane.showMessageDialog(null, "Ürün Silindi... ", "UYARI", 0);
                    tabloKontrol = new TabloKontrol();
                    personelEkranView.updateTable(tabloKontrol.getDefaultTable("Urunler"));

                            
                }
                
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Birşeyler ters gitti tekrar deneyiniz.", "Uyarı", 0);
                e1.printStackTrace();
            }
        }
    }

 
 class AddBilgiTabloListener extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            
            personelEkranView.setSeriNoText((String) personelEkranView.getBilgiTablo().getValueAt(personelEkranView.getBilgiTablo().rowAtPoint(e.getPoint()), 0));
            
        }

     
 }
}


