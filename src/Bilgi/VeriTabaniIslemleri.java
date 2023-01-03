/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bilgi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hurud
 */
public class VeriTabaniIslemleri {

    private static final String kullaiciAdı = "root";
    private static final String parola = "124578";
    private static final String db_ismi = "satisstok";
    private static final String host = "localhost";
    private static final int port = 3306;

    private Connection connection = null;

    //veri tabanında işlem yapmak için kullanırız
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public void personelSil(int id) {
        String sorgu = "Delete From personel where id = ?";

        try {
            preparedStatement = connection.prepareCall(sorgu);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VeriTabaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void personelGuncelle(String yeniId, String yeniIsim, String yeniSoyisim, String yeniEmail, String yeniSifre, String yeniDepartman) {

        String sorgu = "Update personel set id = ? , personelAd = ? , personelSoyad = ? , email = ? , sifre = ? , departman = ? where id = ?";

        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1, yeniId);
            preparedStatement.setString(2, yeniIsim);
            preparedStatement.setString(3, yeniSoyisim);
            preparedStatement.setString(4, yeniEmail);
            preparedStatement.setString(5, yeniSifre);
            preparedStatement.setString(6, yeniDepartman);
            
            preparedStatement.setInt(7, id);
            
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VeriTabaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void personelEkle(String id, String isim, String soyisim, String email, String sifre, String departman) {

        String sorgu = "Insert Into personel(id,personelAd, personelSoyad, email,sifre,departman )  VALUES (?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sorgu);

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, isim);
            preparedStatement.setString(3, soyisim);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, sifre);
            preparedStatement.setString(6, departman);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VeriTabaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Personel> personelGetir() {

        ArrayList<Personel> cikti = new ArrayList<Personel>();

        try {
            statement = connection.createStatement();
            String sorgu = "Select * From personel";

            ResultSet rs = statement.executeQuery(sorgu);

            while (rs.next()) {
                int id = rs.getInt("id");
                String ad = rs.getString("personelAd");
                String soyad = rs.getString("personelSoyad");
                String email = rs.getString("email");
                String sifre = rs.getString("sifre");
                int departman = rs.getInt("departman");

                cikti.add(new Personel(id, ad, soyad, email, sifre, departman));
            }
            return cikti;

        } catch (SQLException ex) {
            Logger.getLogger(VeriTabaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void urunSil(int id) {
        String sorgu = "Delete From urun where id = ?";

        try {
            preparedStatement = connection.prepareCall(sorgu);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VeriTabaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void urunEkle(String id, String kategoriId, String urunAd, String miktar, String fiyat) {

        String sorgu = "Insert Into urun(id, kategoriId, urunAd, miktar, fiyat) VALUES (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sorgu);

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, kategoriId);
            preparedStatement.setString(3, urunAd);
            preparedStatement.setString(4, miktar);
            preparedStatement.setString(5, fiyat);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VeriTabaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Urun> urunGetir() {
        ArrayList<Urun> cikti = new ArrayList<Urun>();

        try {
            statement = connection.createStatement();
            String sorgu = "Select * From urun";

            ResultSet rs = statement.executeQuery(sorgu);

            while (rs.next()) {
                int id = rs.getInt("id");
                int kategoriId = rs.getInt("kategoriId");
                String urunAd = rs.getString("urunAd");
                int miktar = rs.getInt("miktar");
                float fiyat = rs.getFloat("fiyat");

                cikti.add(new Urun(id, kategoriId, urunAd, miktar, fiyat));
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(VeriTabaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public void stokSil(int id){
        String sorgu = "Delete From stok where id = ?";

        try {
            preparedStatement = connection.prepareCall(sorgu);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VeriTabaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stokEkle(String id, String urunId, String satilaMiktar, String alinanMiktar){
        String sorgu = "Insert Into stok (id, urunId, satilanMiktar, alinanMiktar) VALUES (?,?,?,?)";
        
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            
             preparedStatement.setString(1, id);
            preparedStatement.setString(2, urunId);
            preparedStatement.setString(3, satilaMiktar);
            preparedStatement.setString(4, alinanMiktar);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VeriTabaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Stok> stokGetir() {
        ArrayList<Stok> cikti = new ArrayList<Stok>();
        try {
            statement = connection.createStatement();
            String sorgu = "Select * From stok";

            ResultSet rs = statement.executeQuery(sorgu);

            while (rs.next()) {
                int id = rs.getInt("id");
                int urunId = rs.getInt("urunId");
                int satilanMiktar = rs.getInt("satilanMiktar");
                int alinanMiktar = rs.getInt("alinanMiktar");

                cikti.add(new Stok(id, urunId, satilanMiktar, alinanMiktar));

            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(VeriTabaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean girisYap(String email, String sifre) {

        String sorgu = "Select * From personel where email = ? and sifre = ?";

        try {
            preparedStatement = connection.prepareStatement(sorgu);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, sifre);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(VeriTabaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public VeriTabaniIslemleri() {
        //"jdbc:mysql://localhost:8111/satisstok"
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {

            System.out.println("Driver bulunamadı...");

        }

        try {
            connection = DriverManager.getConnection(url, kullaiciAdı, parola);

            System.out.println("Bağlantı Başarılı...");

        } catch (SQLException ex) {

            ex.printStackTrace();
            System.out.println("Bağlantı Başarısız");
        }

    }

    public static void main(String[] args) {
        VeriTabaniIslemleri veriTabani = new VeriTabaniIslemleri();

    }

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ShowError(SQLException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
