/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Bilgi.KarakterKontrol;
import Bilgi.TabloKontrol;
import Bilgi.VeriTabaniIslemler;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sevinc
 */
public class YoneticiPaneliView extends JFrame implements KeyListener {

    private JLabel isim, ad, soyad, cinsiyet, maas, tcKN, sifre, departman, yetki, cBilgi, yPozisyon, yMaas;
    private JTextField adText, soyadText, maasText, tcKNText, sifreText, yetkiTCText, yMaasText;
    private JButton personelEkranBtn, raporEkranBtn, urunEkleEkranBtn, urunGncllBtn, calisanEkleBtn,  gncllBtn;
    private JComboBox departmanBox, yPozisyonBox, cinsiyetBox;
    private JTable bilgiTablo;
    private DefaultTableModel defaultTableModel;

public YoneticiPaneliView(int donusYok) {
    
}

    public YoneticiPaneliView() {
        super();

        setTitle("ÖZSEVİNÇ ELEKTRİK");
        setSize(1200, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Font font = new Font("Verdana", Font.BOLD, 13);

        //isim
        isim = new JLabel("YÖNETİCİ PANELİ");
        isim.setFont(new Font("Verdana", Font.ITALIC, 20));
        isim.setBounds((getWidth() / 2) - 120, 10, 240, 30);

        //personelEkranBtn
        personelEkranBtn = new JButton("Personel Ekran");
        personelEkranBtn.setFont(font);
        personelEkranBtn.setBounds(70, 75, 200, 30);

        //raporEkranBtn
        raporEkranBtn = new JButton("Rapor Görüntüle");
        raporEkranBtn.setFont(font);
        raporEkranBtn.setBounds(70, 115, 200, 30);

        //urunEkleEkranBtn
        urunEkleEkranBtn = new JButton("Ürün ve Katagori Ekle");
        urunEkleEkranBtn.setFont(font);
        urunEkleEkranBtn.setBounds(800, 75, 200, 30);

        //urunGncllBtn
        urunGncllBtn = new JButton("Ürünleri Güncelle");
        urunGncllBtn.setFont(font);
        urunGncllBtn.setBounds(800, 115, 200, 30);

        //ad
        ad = new JLabel("Ad:");
        ad.setFont(font);
        ad.setBounds(105, 175, 100, 30);

        //adText
        adText = new JTextField();
        adText.setFont(font);
        adText.setBounds(150, 175, 175, 30);
        
        adText.setDocument(new KarakterKontrol(15));

        //soyad
        soyad = new JLabel("Soyad:");
        soyad.setFont(font);
        soyad.setBounds(80, 205, 100, 30);

        //soyadText
        soyadText = new JTextField();
        soyadText.setFont(font);
        soyadText.setBounds(150, 205, 175, 30);
        soyadText.setDocument(new KarakterKontrol(15));

        //cinsiyet
        cinsiyet = new JLabel("Cinsiyet:");
        cinsiyet.setFont(font);
        cinsiyet.setBounds(65, 235, 100, 30);

        //cinsiyetText
        cinsiyetBox = new JComboBox();
        cinsiyetBox.setFont(font);
        cinsiyetBox.setBounds(150, 235, 175, 30);
        cinsiyetBox.addItem("bay");
        cinsiyetBox.addItem("bayan");

        //maas
        maas = new JLabel("Maaş:");
        maas.setFont(font);
        maas.setBounds(85, 265, 100, 30);

        //maasText
        maasText = new JTextField();
        maasText.setFont(font);
        maasText.setBounds(150, 265, 175, 30);
        maasText.addKeyListener(this);
        maasText.setDocument(new KarakterKontrol(9));

        //tcKN
        tcKN = new JLabel("T.C.K.No:");
        tcKN.setFont(font);
        tcKN.setBounds(65, 295, 100, 30);

        //tcKNText
        tcKNText = new JTextField();
        tcKNText.setFont(font);
        tcKNText.setBounds(150, 295, 175, 30);
        tcKNText.addKeyListener(this);
        tcKNText.setDocument(new KarakterKontrol(11));

        //sifre
        sifre = new JLabel("Şifre:");
        sifre.setFont(font);
        sifre.setBounds(90, 325, 100, 30);

        //sifreText
        sifreText = new JTextField();
        sifreText.setFont(font);
        sifreText.setBounds(150, 325, 175, 30);
        sifreText.setDocument(new KarakterKontrol(15));

        //departman
        departman = new JLabel("Departman:");
        departman.setFont(font);
        departman.setBounds(45, 355, 100, 30);

        //departmanBox
        departmanBox = new JComboBox();
        departmanBox.setFont(font);
        departmanBox.setBounds(150, 355, 175, 30);
        departmanBox.addItem("Personel");
        departmanBox.addItem("Yönetici");

        //calisanEkleBtn
        calisanEkleBtn = new JButton("Personel Ekle");
        calisanEkleBtn.setFont(font);
        calisanEkleBtn.setBounds(150, 390, 175, 30);


        //yetki
        yetki = new JLabel("Yetkilendirmek İçin Çalışanın T.C.K.No:");
        yetki.setFont(font);
        yetki.setBounds(485, 295, 300, 30);

        //yetkiTCText
        yetkiTCText = new JTextField();
        yetkiTCText.setFont(font);
        yetkiTCText.setBounds(780, 295, 250, 30);
        yetkiTCText.setDocument(new KarakterKontrol(11));
        yetkiTCText.addKeyListener(this);
        yetkiTCText.setDocument(new KarakterKontrol(11));

        //cBilgi
        cBilgi = new JLabel("Çalışan Bilgilerini Eksiksiz Girin Yada Tablodan Otomatik Seçin....");
        cBilgi.setFont(new Font("Verdana", Font.ITALIC, 17));
        cBilgi.setBounds(540, 265, 560, 30);

        //bilgiTablo
        defaultTableModel = new DefaultTableModel();
        bilgiTablo = new JTable();
        bilgiTablo.setModel(defaultTableModel);
        bilgiTablo.setEnabled(false);
        bilgiTablo.setFont(font);
        JScrollPane sp = new JScrollPane(bilgiTablo);
        sp.setBounds(450, 185, 650, 75);
        TabloKontrol tabloKontrol = new TabloKontrol();
        updateTable(tabloKontrol.getDefaultTable("Personeller"));
        

  
        //yPozisyon
        yPozisyon = new JLabel("Yeni Pozisyon:");
        yPozisyon.setFont(font);
        yPozisyon.setBounds(660, 325, 175, 30);

        //yPozisyonBox
        yPozisyonBox = new JComboBox();
        yPozisyonBox.setFont(font);
        yPozisyonBox.addItem("Personel");
        yPozisyonBox.addItem("Yönetici");
        yPozisyonBox.setBounds(780, 325, 250, 30);

        //yMaas
        yMaas = new JLabel("Yeni Maaş:");
        yMaas.setFont(font);
        yMaas.setBounds(685, 355, 175, 30);

        //yMaasText
        yMaasText = new JTextField();
        yMaasText.setFont(font);
        yMaasText.setBounds(780, 355, 250, 30);
        yMaasText.addKeyListener(this);

        //gncllBtn
        gncllBtn = new JButton("Güncelle");
        gncllBtn.setFont(font);
        gncllBtn.setBounds(780, 390, 250, 30);


        getContentPane().add(isim);
        getContentPane().add(personelEkranBtn);
        getContentPane().add(raporEkranBtn);
        getContentPane().add(urunEkleEkranBtn);
        getContentPane().add(urunGncllBtn);
        getContentPane().add(ad);
        getContentPane().add(adText);
        getContentPane().add(soyad);
        getContentPane().add(soyadText);
        getContentPane().add(cinsiyet);
        getContentPane().add(cinsiyetBox);
        getContentPane().add(maas);
        getContentPane().add(maasText);
        getContentPane().add(tcKN);
        getContentPane().add(tcKNText);
        getContentPane().add(sifre);
        getContentPane().add(sifreText);
        getContentPane().add(departman);
        getContentPane().add(departmanBox);
        getContentPane().add(calisanEkleBtn);
        getContentPane().add(yetki);
        getContentPane().add(yetkiTCText);
        getContentPane().add(cBilgi);
        getContentPane().add(sp);
        getContentPane().add(yPozisyon);
        getContentPane().add(yPozisyonBox);
        getContentPane().add(yMaas);
        getContentPane().add(yMaasText);
        getContentPane().add(gncllBtn);

        setVisible(true);

    }
    
    public String getAdText() {
        return adText.getText();
    }

    public String getSoyadText() {
        return soyadText.getText();
    }

    public int getMaasText() {
        return Integer.parseInt(maasText.getText());
    }

    public String getTcKNText() {
        return tcKNText.getText();
    }

    public String getYetkiTCText() {
        return yetkiTCText.getText();
    }

    public void setYetkiTCText(String yetkiTCText) {
        this.yetkiTCText.setText(yetkiTCText); 
    }

    public void setyMaasText(String yMaasText) {
        this.yMaasText.setText(yMaasText);
    }
    
    
    public int getyMaasText() {
        return Integer.parseInt(yMaasText.getText());
    }

    public int getyPozisyonBox() {
        return yPozisyonBox.getSelectedIndex();
    }

    public int getDepartmanBox() {
        return departmanBox.getSelectedIndex();
    }

    public String getCinsiyetBox() {
        return cinsiyetBox.getSelectedItem().toString();
    }

    public String getSifreText() {
        return sifreText.getText();
    }

    public JTable getBilgiTablo() {
        return bilgiTablo;
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }
    
      
    public void prsnlEkranBtnListener(ActionListener listener){
        personelEkranBtn.addActionListener(listener);
    }
    
    public void rprEkranBtnListener(ActionListener listener){
        raporEkranBtn.addActionListener(listener);
    }
    
    public void urunEkleEkranBtnListener(ActionListener listener){
        urunEkleEkranBtn.addActionListener(listener);
    }
    public void stokBtnListener(ActionListener listener){
        urunGncllBtn.addActionListener(listener);
    }
    
    public void calisanEkleBtnListener(ActionListener listener){
        calisanEkleBtn.addActionListener(listener);
    }
    
    public void calisanGnclleBtnListener(ActionListener listener){
        gncllBtn.addActionListener(listener);
    }
    
    public void  blgTabloSiralaMouseListener(MouseAdapter listener){
        bilgiTablo.getTableHeader().addMouseListener(listener);
    }
    public void  blgTabloMouseListener(MouseAdapter listener){
        bilgiTablo.addMouseListener(listener);
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!((c >= '0') && (c <= '9') || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_BACK_SPACE)) {
            getToolkit().beep();
            e.consume();

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

 public void updateTable(ArrayList<ArrayList<String>> list ) {
  VeriTabaniIslemler    vti = new VeriTabaniIslemler() {};
        Object columnTitle[] = vti.getColumnList("Personeller").toArray();
        Object rows[][] = vti.getObjectArray(list);
         getDefaultTableModel().setDataVector(rows, columnTitle);
        
    }
 
  
}
