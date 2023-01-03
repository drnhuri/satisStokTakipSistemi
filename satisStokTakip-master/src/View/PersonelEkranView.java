package View;

import Bilgi.TabloKontrol;
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

public class PersonelEkranView extends JFrame implements KeyListener {

    private JLabel pIsim, seriNo, sMiktar, kur ,uyarı;
    private JButton urunEkleBtn, stokGuncelleBtn, urunSilBtn, tTutarBtn, satBtn, kurBtn;
    private JTextField seriNoText, sMiktarText, tTutarText;
    private JTable bilgiTablo;
    private DefaultTableModel defaultTableModel;
   

    

    public PersonelEkranView() {
        super();
    
        setTitle("Personel Ekran");
        setSize(1300, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Font font = new Font("Verdana", Font.BOLD, 15);

        //pisim
        pIsim = new JLabel("SATIŞ SİSTEMİ");
        pIsim.setFont(new Font("Verdana", Font.ITALIC, 20));
        pIsim.setBounds((getWidth() / 2) - 100, 40, 200, 20);

        //urunEkleBtn
        urunEkleBtn = new JButton("Ürün Ekle");
        urunEkleBtn.setFont(font);
        urunEkleBtn.setBounds(50, 150, 150, 30);


        //stokGuncelleBtn
        stokGuncelleBtn = new JButton("Stok Güncelle");
        stokGuncelleBtn.setFont(font);
        stokGuncelleBtn.setBounds(50, 220, 150, 30);

        //kurBtn
        kurBtn = new JButton("Kuru Güncelle");
        kurBtn.setFont(font);
        kurBtn.setBounds(50, 430, 150, 30);


        //kur
        kur = new JLabel("Güncel Dolar Satış Kuru:");
        kur.setFont(font);
        kur.setBounds(40, 350, 500, 60);

        
        //seriNo
        seriNo = new JLabel("Satılacak veya Silinecek Ürün Seri No Girin:");
        seriNo.setFont(font);
        seriNo.setBounds(410, 340, 370, 30);

        //defaultTableModel
        defaultTableModel = new DefaultTableModel();
        bilgiTablo = new JTable();
        bilgiTablo.setModel(defaultTableModel);
        bilgiTablo.setEnabled(false);
        bilgiTablo.setFont(font);

        JScrollPane sp = new JScrollPane(bilgiTablo);
        sp.setBounds(400, 140, 850, 120);
        TabloKontrol tabloKontrol = new TabloKontrol();
        updateTable(tabloKontrol.getDefaultTable("Urunler"));

        //uyarı
        uyarı = new JLabel("Ürün Bilgilerini Eksiksiz Girin Yada Tablodan Otomatik Seçin....");
        uyarı.setFont(new Font("Verdana", Font.ITALIC, 17));
        uyarı.setBounds(420, 280, 570, 30);
        
        //seriNoText
        seriNoText = new JTextField();
        seriNoText.setFont(font);
        seriNoText.setBounds(770, 340, 150, 30);

        //sMiktar
        sMiktar = new JLabel("Satılacak Miktar (ADET/METRE):");
        sMiktar.setFont(font);
        sMiktar.setBounds(490, 400, 320, 30);

        //sMiktarText
        sMiktarText = new JTextField();
        sMiktarText.setBounds(seriNoText.getX(), sMiktar.getY(), seriNoText.getWidth(), seriNoText.getHeight());
        sMiktarText.setFont(font);
        sMiktarText.addKeyListener(this);

        //tTutarText
        tTutarText = new JTextField();
        tTutarText.setEditable(false);
        tTutarText.setBounds(sMiktarText.getX(), sMiktarText.getY() + 50, sMiktarText.getWidth() + 100, sMiktarText.getHeight());

        //urunSilBtn
        urunSilBtn = new JButton("Ürün Sil");
        urunSilBtn.setFont(font);
        urunSilBtn.setBounds(tTutarText.getX() + 150, tTutarText.getY() + 75, tTutarText.getWidth() - 100, tTutarText.getHeight());

//
        //tTutarBtn
        tTutarBtn = new JButton("KDV'li Toplam Tutar:");
        tTutarBtn.setBounds(sMiktarText.getX() - 160, sMiktarText.getY() + 50, sMiktarText.getWidth(), sMiktarText.getHeight());

        //satBtn
        satBtn = new JButton("Ürünü Sat");
        satBtn.setFont(font);
        satBtn.setBounds(tTutarText.getX(), tTutarText.getY() + 75, tTutarText.getWidth() - 120, tTutarText.getHeight());


        getContentPane().add(pIsim);
        getContentPane().add(urunEkleBtn);
        getContentPane().add(stokGuncelleBtn);
        getContentPane().add(kurBtn);
        getContentPane().add(kur);
        getContentPane().add(seriNo);
        getContentPane().add(seriNoText);
        getContentPane().add(urunSilBtn);
        getContentPane().add(sp);
        getContentPane().add(sMiktar);
        getContentPane().add(sMiktarText);
        getContentPane().add(tTutarBtn);
        getContentPane().add(tTutarText);
        getContentPane().add(satBtn);
        getContentPane().add(uyarı);

        setVisible(true);
    }

    public static void main(String[] args) {
        PersonelEkranView pe = new PersonelEkranView();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
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

    public void updateTable(ArrayList<ArrayList<String>> list) {
        VeriTabaniIslemler vti = new VeriTabaniIslemler() {};
        Object columnTitle[] = vti.getColumnList("Urunler").toArray();
        Object rows[][] = vti.getObjectArray(list);
        getDefaultTableModel().setDataVector(rows, columnTitle);
    }

    public String getSeriNoText() {
        return seriNoText.getText();
    }

    public String getsMiktarText() {
        return sMiktarText.getText();
    }

    public float gettTutarText() {
        return Float.parseFloat(tTutarText.getText());
    }

    public void settTutarText(String tTutarText) {
        this.tTutarText.setText(tTutarText); 
    }
    

    public JTable getBilgiTablo() {
        return bilgiTablo;
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }
    
    public void urunEkleBtn(ActionListener listener){
        urunEkleBtn.addActionListener(listener);
    }
    public void stokBtn(ActionListener listener){
        stokGuncelleBtn.addActionListener(listener);
    }
    public void kurBtn(ActionListener listener){
        kurBtn.addActionListener(listener);
    }
    public void tutarBtn(ActionListener listener){
        tTutarBtn.addActionListener(listener);
    }
    public void satBtn(ActionListener listener){
        satBtn.addActionListener(listener);
    }
    public void silBtn(ActionListener listener){
        urunSilBtn.addActionListener(listener);
    }
    public void  blgTabloSiralaMouseListener(MouseAdapter listener){
        bilgiTablo.getTableHeader().addMouseListener(listener);
    }
    public void  blgTabloMouseListener(MouseAdapter listener){
        bilgiTablo.addMouseListener(listener);
    }

    public void setKur(String kur) {
        this.kur.setText(kur);
    }

    public void setSeriNoText(String seriNoText) {
        this.seriNoText.setText(seriNoText); 
    }
    
    
    

}
