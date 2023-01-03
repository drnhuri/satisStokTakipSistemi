
package View;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UrunEkleView extends JFrame implements KeyListener{
    private JLabel isim ,urunSeriNo,ktgrIsmi, ktgrIsmi2 , urunAdi, alisFiyat , satisFiyat,miktar, birim;
    private JTextField urunSeriNoText, ktgrIsmi2Text , urunAdiText, alisFiyatText , satisFiyatText,miktarText;
    private JComboBox ktgrIsmiBox , birimBox;
    private JButton urunEkleBtn;

    public UrunEkleView(){
         super();
       
        setTitle("ÖZSEVİNÇ ELEKTRİK");
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        Font font = new Font("Verdana", Font.BOLD, 15);
        
        //isim
        isim = new JLabel("ÜRÜN EKLEME SİSTEMİ");
        isim.setFont(new Font("Verdana", Font.ITALIC, 20));
        isim.setBounds((getWidth() / 2) - 120 , 40, 240, 20);
        
        //urunSeriNo
        urunSeriNo = new JLabel("Ürün Seri No Giriniz:");
        urunSeriNo.setFont(font);
        urunSeriNo.setBounds(95, 150, 320, 30);
        
        //ktgrIsmi
        ktgrIsmi = new JLabel("Katagori Adı Seçiniz:");
        ktgrIsmi.setFont(font);
        ktgrIsmi.setBounds(90, 210, 320, 30);
        
        //ktgrIsmi2
        ktgrIsmi2 = new JLabel("Yeni Katagori Adı Giriniz:");
        ktgrIsmi2.setFont(font);
        ktgrIsmi2.setBounds(55, 270, 320, 30);
        
        //urunAdi
        urunAdi = new JLabel("Ürün Adı Giriniz:");
        urunAdi.setFont(font);
        urunAdi.setBounds(125, 330, 320, 30);
        
        
        //alisFiyat
        alisFiyat = new JLabel("Alış Fiyatı Giriniz:");
        alisFiyat.setFont(font);
        alisFiyat.setBounds(120, 390, 320 ,30);
        
        
        //satisFiyat
        satisFiyat = new JLabel("Satış Fiyatı Giriniz:");
        satisFiyat.setFont(font);
        satisFiyat.setBounds(110, 450, 320, 30);
        
        
        //miktar
        miktar = new JLabel("Miktar Giriniz:");
        miktar.setFont(font);
        miktar.setBounds(150, 510, 320, 30);
        
        
        //birim
        birim = new JLabel("Birim Seçiniz:");
        birim.setFont(font);
        birim.setBounds(155, 570,320, 30);
        
        //urunSeriNoText
        urunSeriNoText = new JTextField();
        urunSeriNoText.setFont(font);
        urunSeriNoText.setBounds(300, 150, 320, 30);
        
        //ktgrIsmiBox
        ktgrIsmiBox = new JComboBox();
        ktgrIsmiBox.setFont(font);
        ktgrIsmiBox.setBounds(300, 210, 320, 30);

       
        //ktgrIsmi2Text
        ktgrIsmi2Text = new JTextField();
        ktgrIsmi2Text.setFont(font);
        ktgrIsmi2Text.setBounds(300, 270, 320, 30);
        
        //urunAdiText
        urunAdiText = new JTextField();
        urunAdiText.setFont(font);
        urunAdiText.setBounds(300, 330, 320, 30);
        
        
        //alisFiyatText
        alisFiyatText = new JTextField();
        alisFiyatText.setFont(font);
        alisFiyatText.setBounds(300, 390, 320 ,30);
        alisFiyatText.addKeyListener(this);
        
        
        //satisFiyatText
        satisFiyatText = new JTextField();
        satisFiyatText.setFont(font);
        satisFiyatText.setBounds(300, 450, 320, 30);
        satisFiyatText.addKeyListener(this);

        
        
        //miktarText
        miktarText = new JTextField();
        miktarText.setFont(font);
        miktarText.setBounds(300, 510, 320, 30);
        miktarText.addKeyListener(this);
        
        
        //birimBox
        birimBox = new JComboBox<>();
        birimBox.setFont(font);
        birimBox.setBounds(300, 570,320, 30);
        birimBox.addItem("adet");
        birimBox.addItem("metre");
        
        //urunEkleBtn
        urunEkleBtn = new JButton("Ürün Ekle");
        urunEkleBtn.setFont(font);
        urunEkleBtn.setBounds(325,680,250,30);

        
        
        getContentPane().add(isim);
        getContentPane().add(urunSeriNo);
        getContentPane().add(ktgrIsmi);
        getContentPane().add(ktgrIsmi2);
        getContentPane().add(urunAdi);
        getContentPane().add(alisFiyat);
        getContentPane().add(satisFiyat);
        getContentPane().add(miktar);
        getContentPane().add(birim);
        getContentPane().add(urunSeriNoText);
        getContentPane().add(ktgrIsmiBox);
        getContentPane().add(ktgrIsmi2Text);
        getContentPane().add(urunAdiText);
        getContentPane().add(alisFiyatText);
        getContentPane().add(satisFiyatText);
        getContentPane().add(miktarText);
        getContentPane().add(birimBox);
        getContentPane().add(urunEkleBtn);
              
        setVisible(true);
    }
    //texte istemediğim karakterleri girmesin
    @Override
    public void keyTyped(KeyEvent e) {
          char c = e.getKeyChar();
        if (e.getSource() == miktarText) {
            if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
            }
        } else {
            if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD) ||(c == KeyEvent.VK_COMMA) )) {
                getToolkit().beep();
                e.consume();
            }
        }
     
        
    }
    public static void main(String[] args) {
        UrunEkleView urunEkle = new UrunEkleView();
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

    public String getKtgrIsmi2Text() {
        return ktgrIsmi2Text.getText();
    }
     public JTextField getKtgrIsmi2TextField() {
        return ktgrIsmi2Text;
    }

    public String getUrunAdiText() {
        return urunAdiText.getText();
    }

    public float getAlisFiyatText() {
        return Float.parseFloat(alisFiyatText.getText().replace(",", "."));
    }

    public float getSatisFiyatText() {
        return Float.parseFloat(satisFiyatText.getText().replace(",", "."));
    }

    public int getKtgrIsmiBoxItem() {
        return ktgrIsmiBox.getSelectedIndex();
    }

    
   public JComboBox getKtgrIsmiBox() {
        return ktgrIsmiBox;
    }
    public String getBirimBox() {
        return birimBox.getSelectedItem().toString();
    }

    public int getMiktarText() {
        return Integer.parseInt(miktarText.getText());
    }
    

   public void urunEkleBtnListener(ActionListener listener){
        urunEkleBtn.addActionListener(listener);
    }
   public void katagoriListener(ItemListener listener){
        ktgrIsmiBox.addItemListener(listener);
    }
    
}
