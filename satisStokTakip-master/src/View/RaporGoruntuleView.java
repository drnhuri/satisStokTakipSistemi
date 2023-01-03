/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
/**
 *
 * @author sevinc
 */

import Bilgi.TabloKontrol;
import Bilgi.VeriTabaniIslemler;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RaporGoruntuleView extends JFrame {

    private JLabel isim, aralik, baslaTrh, bitTrh;
    private JDateChooser baslaChooser, bitisChooser;
    private JButton raporBtn;
    private JTable bilgiTablo;
    private DefaultTableModel defaultTableModel;

    public RaporGoruntuleView() {
        super();
        setTitle("ÖZSEVİNÇ ELEKTRİK");
        setSize(1200, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        Font font = new Font("Verdana", Font.BOLD, 13);

        //isim
        isim = new JLabel("ALIŞ SATIŞ GÖRÜNTÜLEME PANELİ");
        isim.setFont(new Font("Verdana", Font.ITALIC, 20));
        isim.setBounds((getWidth() / 2) - 160, 40, 360, 30);

        //aralik
        aralik = new JLabel("Lütfen Aşağıda Tarih Aralığını Seçiniz");
        aralik.setFont(font);
        aralik.setBounds(70, 150, 400, 30);

        //baslaTrh
        baslaTrh = new JLabel("Lütfen Aşağıda Başlangıç Tarihi Seçiniz");
        baslaTrh.setFont(font);
        baslaTrh.setBounds(70, 230, 400, 30);

        //baslaChooser
        baslaChooser = new JDateChooser();
        baslaChooser.setFont(font);
        baslaChooser.setBounds(70, 260, 400, 30);

        //bitTrh
        bitTrh = new JLabel("Lütfen Aşağıda Bitiş Tarihi Seçiniz");
        bitTrh.setFont(font);
        bitTrh.setBounds(70, 320, 400, 30);

        //bitisChooser
        bitisChooser = new JDateChooser();
        bitisChooser.setFont(font);
        bitisChooser.setBounds(70, 360, 400, 30);

        //raporBtn
        raporBtn = new JButton("Raporu Görüntüle");
        raporBtn.setFont(font);
        raporBtn.setBounds(70, 420, 250, 30);


        defaultTableModel = new DefaultTableModel();
        bilgiTablo = new JTable();
        bilgiTablo.setModel(defaultTableModel);
        bilgiTablo.setEnabled(false);
        bilgiTablo.setFont(font);

        JScrollPane sp = new JScrollPane(bilgiTablo);
        sp.setBounds(550, 140, 600, 200);
        TabloKontrol tabloKontrol = new TabloKontrol();
        updateTable(tabloKontrol.getDefaultTable("Stok"));


        getContentPane().add(isim);
        getContentPane().add(aralik);
        getContentPane().add(baslaTrh);
        getContentPane().add(baslaChooser);
        getContentPane().add(bitTrh);
        getContentPane().add(bitisChooser);
        getContentPane().add(raporBtn);
        getContentPane().add(sp);

        setVisible(true);
    }

    public void updateTable(ArrayList<ArrayList<String>> list) {
        VeriTabaniIslemler vti = new VeriTabaniIslemler() {};
        Object columnTitle[] = vti.getColumnList("Stok").toArray();
        Object rows[][] = vti.getObjectArray(list);
        defaultTableModel.setDataVector(rows, columnTitle);
    }

    public JDateChooser getBaslaChooser() {
        return baslaChooser;
    }

    public JDateChooser getBitisChooser() {
        return bitisChooser;
    }

   
    
    public void goruntuleBtn(ActionListener listener){
        raporBtn.addActionListener(listener);
    }

    public JTable getBilgiTablo() {
        return bilgiTablo;
    }

 
    

}
