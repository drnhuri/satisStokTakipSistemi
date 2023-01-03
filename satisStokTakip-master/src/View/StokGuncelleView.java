/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Bilgi.TabloKontrol;
import Bilgi.Urunler;
import Bilgi.VeriTabaniIslemler;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sevinc
 */
public class StokGuncelleView extends JFrame implements KeyListener {

    private JLabel isim, urunSeriNo, urunBilgi, ySatis, yStok;
    private JTextField urunSeriNoText, ySatisText, yStokText;
    private JButton guncelleBtn;
    private JTable bilgiTablo;
    private DefaultTableModel defaultTableModel;
      
    public StokGuncelleView() {
        super();
        Urunler urunler = new Urunler();
        
        setTitle("ÖZSEVİNÇ ELEKTRİK");
        setSize(1100, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        Font font = new Font("Verdana", Font.BOLD, 13);

        //isim
        isim = new JLabel("STOK GÜNCELLE PANELİ");
        isim.setFont(new Font("Verdana", Font.ITALIC, 20));
        isim.setBounds(getWidth() / 2 - 150, 50, 300, 30);

        //urunSeriNo
        urunSeriNo = new JLabel("Güncellemek İstediğiniz Ürünün Seri No Giriniz:");
        urunSeriNo.setFont(font);
        urunSeriNo.setBounds(60, 500, 400, 30);

        //urunSeriNoText
        urunSeriNoText = new JTextField();
        urunSeriNoText.setFont(font);
        urunSeriNoText.setBounds(430, 500, 350, 30);

        //urunBilgi
        urunBilgi = new JLabel("İstenilen bilgileri aşağıda girin veya tablodan otomatik seçin.");
        urunBilgi.setFont(font);
        urunBilgi.setBounds(280, 440, 500, 30);

        defaultTableModel = new DefaultTableModel();
        bilgiTablo = new JTable();
        bilgiTablo.setModel(defaultTableModel);
        bilgiTablo.setEnabled(false);
        bilgiTablo.setFont(font);

        JScrollPane sp = new JScrollPane(bilgiTablo);
        sp.setBounds(100, 140, 900, 200);
        TabloKontrol tabloKontrol = new TabloKontrol();
        updateTable(tabloKontrol.getDefaultTable("Urunler"));


        //ySatis
        ySatis = new JLabel("Yeni Satış Fiyatı Giriniz:");
        ySatis.setFont(font);
        ySatis.setBounds(230, 560, 200, 30);

        //yStok
        yStok = new JLabel(" Yeni Stok Bilgisi Giriniz:");
        yStok.setFont(font);
        yStok.setBounds(230, 620, 200, 30);

        //ySatisText
        ySatisText = new JTextField();
        ySatisText.setFont(font);
        ySatisText.setBounds(430, 560, 350, 30);
        ySatisText.addKeyListener(this);

        //yStokText
        yStokText = new JTextField();
        yStokText.setFont(font);
        yStokText.setBounds(430, 620, 350, 30);
        yStokText.addKeyListener(this);

        //guncelleBtn
        guncelleBtn = new JButton("Güncelle");
        guncelleBtn.setFont(font);
        guncelleBtn.setBounds(490, 690, 200, 30);
    
        getContentPane().add(isim);
        getContentPane().add(urunSeriNo);
        getContentPane().add(urunSeriNoText);
        getContentPane().add(urunBilgi);
        getContentPane().add(ySatis);
        getContentPane().add(yStok);
        getContentPane().add(ySatisText);
        getContentPane().add(yStokText);
        getContentPane().add(guncelleBtn);
        getContentPane().add(sp);

        setVisible(true);
    }

    public void updateTable(ArrayList<ArrayList<String>> list) {
        VeriTabaniIslemler    vti = new VeriTabaniIslemler() {};
        Object columnTitle[] = vti.getColumnList("Urunler").toArray();
        Object rows[][] = vti.getObjectArray(list);
        defaultTableModel.setDataVector(rows, columnTitle);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (e.getSource() == yStokText) {
            if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
            }
        } else {
            if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD) || (c == KeyEvent.VK_COMMA))) {
                getToolkit().beep();
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public String getUrunSeriNoText() {
        return urunSeriNoText.getText();
    }

    public String getySatisText() {
        return ySatisText.getText();
    }

    public String getyStokText() {
         return yStokText.getText();

    }

    public void setUrunSeriNoText(String urunSeriNoText) {
        this.urunSeriNoText.setText(urunSeriNoText);
    }

    public void setySatisText(String ySatisText) {
        this.ySatisText.setText(ySatisText);
    }

    public void setyStokText(String yStokText) {
        this.yStokText.setText(yStokText);
    }
    
    public void AddGuncelleBtn(ActionListener listener){
        guncelleBtn.addActionListener(listener);
    }

    public JTable getBilgiTablo() {
        return bilgiTablo;
    }
    
    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }
     public void  blgTabloSiralaMouseListener(MouseAdapter listener){
        bilgiTablo.getTableHeader().addMouseListener(listener);
    }
    public void  blgTabloMouseListener(MouseAdapter listener){
        bilgiTablo.addMouseListener(listener);
    }

}
