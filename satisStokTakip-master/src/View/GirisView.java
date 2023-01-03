package View;

import Bilgi.KarakterKontrol;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GirisView extends JFrame implements KeyListener{

    private JLabel baslik, kTC, kSifre, gelistirici, tarih;
    private JTextField kTCgiris ;
    private JPasswordField kSifreGiris;
    private JButton girisBtn;

    public GirisView() {
        //Giriş paneli oluşturmak
        super();
        setTitle("ÖZSEVİNÇ ELEKTRİK");
        setSize(450, 320);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        Font font = new Font("Verdana", Font.BOLD, 12);
        
        //başlık label
        baslik = new JLabel("ÖZSEVİNÇ ELEKTRİK");
        baslik.setFont(new Font("Verdana", Font.BOLD, 20));
        baslik.setBounds((getWidth() / 2) - 100, 40, 350, 20);
        
        //Tc label
        kTC = new JLabel("Kullanıcı T.C.K.No: ");
        kTC.setFont(font);
        kTC.setBounds(40, 90, 130, 20);
        
        
        // sifre label
        kSifre = new JLabel("Kullanıcı Şifre: ");
        kSifre.setFont(font);
        kSifre.setBounds(40, 150, 130, 20);
        
        //kTC textfield
        kTCgiris = new JTextField();
        kTCgiris.setFont(font);
        kTCgiris.setBounds(kTC.getWidth() + 50 , 90, 130, 20);
        kTCgiris.addKeyListener(this);
        kTCgiris.setDocument(new KarakterKontrol(11));
        
        //kSifreGiris textfield
        kSifreGiris = new JPasswordField();
        kSifreGiris.setBounds(kSifre.getWidth() + 50 , 150, 130, 20);
        
        //Giris buton
        girisBtn = new JButton("Giriş Yap");
        girisBtn.setFont(font);
        girisBtn.setBounds(kSifreGiris.getX(), (getHeight()-100), 130, 20);
        
        // gelistrici ve versiyon label
        gelistirici = new JLabel("Versiyon 1.5 Yusuf Sevinç ");
        gelistirici.setBounds(getWidth()-160,getHeight()-90, 200, 80);
        

        getContentPane().add(baslik);
        getContentPane().add(kTC);
        getContentPane().add(kSifre);
        getContentPane().add(girisBtn);
        getContentPane().add(kTCgiris);
        getContentPane().add(kSifreGiris);
        getContentPane().add(gelistirici);


      
        setVisible(true);
    }

    public String getkTCgiris() {
        return kTCgiris.getText();
    }

    public String getkSifreGiris() {
        return kSifreGiris.getText();
    }
    
    public void girisBtnListener(ActionListener listener){
        girisBtn.addActionListener(listener);
    }
   
  
    
    @Override
    public void keyTyped(KeyEvent e) {
        //a sadece giriş için ayarladım
          char c = e.getKeyChar();
         if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == 'a')) ) {
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
 
}
