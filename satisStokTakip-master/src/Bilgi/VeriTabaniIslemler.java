package Bilgi;

import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public abstract class VeriTabaniIslemler {

    private String driver = "com.mysql.jdbc.Driver";
    private String path;
    private String url;
    private Connection conn;
    private Statement stmt;
    private PreparedStatement preparedStatement;
    private ResultSet rs;
    private DatabaseMetaData md;

    public VeriTabaniIslemler() {
        this.path = path;
        url = "jdbc:mysql://127.0.0.1:3306/satisstoktakip";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Driver Connection Yok.", "Uyarı", JOptionPane.WARNING_MESSAGE);
        }

        openDB();
        closeDB();
    }

    public final void openDB() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/satisstoktakip", "root", "124578");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Baglanti Saglanamadi.", "Uyarı", JOptionPane.WARNING_MESSAGE);
        }
    }

    public final void closeDB() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DB kapatma sirasinda hata.", "Uyarı", JOptionPane.WARNING_MESSAGE);
        }
    }

    public final void executeSQL(String sql, String message) {
        openDB();
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, message, "Uyarı", JOptionPane.WARNING_MESSAGE);
        }
        closeDB();
    }

    public final ResultSet executeSQL(String sql) {
        openDB();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "işlem sırasında hata oluştu...", "Uyarı", JOptionPane.WARNING_MESSAGE);
        }
        closeDB();
        return rs;
    }

//hocam projemi mysql de bitirmiştim ama tabloları sqlite javanın içinde istedeniz bende bu şekilde oluşturdum.
    //kolonları tek tek ekliyecektim ama primary key integer varchar her metotda belirtmem gerekiyor
    //bende o yüzden böyle bir şey yaptım (hocam kusura bakmayın üst sınıftanda dersim var projenizi erken bitirmek istedim fakat değişiklikler alakalı zaman karmaşasına girdim o yüzden böyle yaptım bu sıfırdan 2. projem) 
    public final void createTableUrunler() {
        String sql = "CREATE TABLE \"Urunler\" (\n"
                + "	\"urunSeriNo\"	TEXT UNIQUE,\n"
                + "	\"katagoriId\"	INTEGER,\n"
                + "	\"alisFiyati\"	REAL,\n"
                + "	\"satisFiyati\"	REAL,\n"
                + "	\"urunAdi\"	TEXT UNIQUE,\n"
                + "	\"urunId\"	INTEGER,\n"
                + "	\"miktar\"	INTEGER,\n"
                + "	\"birim\"	TEXT,\n"
                + "	PRIMARY KEY(\"urunId\" AUTOINCREMENT)\n"
                + ");";
        String message = "Tablo olusturulamadi.";
        executeSQL(sql, message);
    }

    public final void createTableKatagori() {
        String sql = "CREATE TABLE IF NOT EXISTS \"Katagoriler\" (\n"
                + "	\"katagoriId\"	INTEGER UNIQUE,\n"
                + "	\"katagoriAdi\"	TEXT UNIQUE,\n"
                + "	PRIMARY KEY(\"katagoriId\" AUTOINCREMENT)\n"
                + ");";
        String message = "Tablo olusturulamadi.";
        executeSQL(sql, message);
    }

    public final void createTableStok() {
        String sql = "CREATE TABLE IF NOT EXISTS \"Stok\" (\n" +
"	\"UrunSeriNo\"	TEXT,\n" +
"	\"urunAdi\"	TEXT,\n" +
"	\"satilanMiktar\"	INTEGER,\n" +
"	\"alinanMiktar\"	INTEGER,\n" +
"	\"Tarih\"	TEXT\n" +
");";
        String message = "Tablo olusturulamadi.";
        executeSQL(sql, message);
    }

    public final void createTablePersonel() {
        String sql = "CREATE TABLE IF NOT EXISTS \"Personeller\" (\n"
                + "	\"id\"	INTEGER UNIQUE,\n"
                + "	\"isim\"	TEXT,\n"
                + "	\"soyisim\"	TEXT,\n"
                + "	\"tcKimlikNo\"	TEXT UNIQUE,\n"
                + "	\"cinsiyet\"	TEXT,\n"
                + "	\"maas\"	INTEGER,\n"
                + "	\"departman\"	INTEGER,\n"
                + "	\"sifre\"	TEXT,\n"
                + "	PRIMARY KEY(\"id\" AUTOINCREMENT)\n"
                + ");";
        String message = "Tablo olusturulamadi.";
        executeSQL(sql, message);
    }

    public final ArrayList<String> katagoriler() {
        String katagoriAdi = " ";
        String sql = "Select katagoriAdi from Katagoriler";
        ArrayList<String> katagorilerList = new ArrayList<>();

        try {
            openDB();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                katagoriAdi = rs.getString("katagoriAdi");
                katagorilerList.add(katagoriAdi);
            }
        } catch (SQLException e) {
        }
        closeDB();
        return katagorilerList;

    }

    public final int girisKontrol(String kTC, String kSifre) throws SQLException {
        openDB();
        String sql = "select * from Personeller where tcKimlikNo = ? and sifre = ?";
        int kontrol = 0;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, kTC);
            preparedStatement.setString(2, kSifre);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getString("tcKimlikNo").equals(kTC) && rs.getString("sifre").equals(kSifre)) {
                    if (0 == rs.getInt("departman")) {
                        kontrol = 1;

                    } else {
                        kontrol = 2;

                    }

                }
                break;

            }

        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Hatalı Gİriş...", "Bilgilendirme", HEIGHT);
        }
        closeDB();
        return kontrol;

    }
    //ürün güncelle

    public final void Guncelle(String urunSeriNo, int miktar, float satisFiyati) {

        String sql = "UPDATE  Urunler SET miktar = ?, satisFiyati = ? WHERE Urunler.UrunSeriNo = ?";

        try {

            openDB();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, miktar);
            preparedStatement.setFloat(2, satisFiyati);
            preparedStatement.setString(3, urunSeriNo);
            
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                stokGuncelle(miktar, urunSeriNo, "alinanMiktar");
                JOptionPane.showMessageDialog(null, "Güncellendi. \n"
                        + "Tablodan kontrol edebilirsiniz...", "Bilgilednirme", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(null, "Bilgilerin eksiz ve doğru olduğundan emin olun \n"
                        + "ÜrünSeriNo , miktar ve satış fiyatı boş olmamalı.", "Uyarı", HEIGHT);
            }

        } catch (SQLException ex) {

        }
        closeDB();

    }

    //methot overloding personel güncelle
    public final void Guncelle(String tcKimlikNo, int maas, int departman) {

        String sql = "UPDATE  Personeller SET departman = ?, maas = ? WHERE Personeller.tcKimlikNo= ?";

        try {

            openDB();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, departman);
            preparedStatement.setInt(2, maas);
            preparedStatement.setString(3, tcKimlikNo);
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                JOptionPane.showMessageDialog(null, "Güncellendi. \n"
                        + "Tablodan kontrol edebilirsiniz...", "Bilgilednirme", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(null, "Bilgilerin eksiz ve doğru olduğundan emin olun \n"
                        + "Tc kimlik ve maaş boş olmamalı.", "Uyarı", HEIGHT);
            }

        } catch (SQLException ex) {
            

        }
        closeDB();

    }

    public final void calisanEkle(String ad, String Soyad, String Cinsiyet, int maas, String tc, int departman, String sifre) {
     
        String sql = "insert into Personeller (isim , soyisim , tcKimlikNo , cinsiyet , maas , departman , sifre) values (?,?,?,?,?,?,?)";
        try {
            openDB();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, Soyad);
            preparedStatement.setString(3, tc);
            preparedStatement.setString(4, Cinsiyet);
            preparedStatement.setInt(5, maas);
            preparedStatement.setInt(6, departman);
            preparedStatement.setString(7, sifre);
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                 JOptionPane.showMessageDialog(null, "Personel Eklendi...", "Bilgilendirme", HEIGHT);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kullanıcı Eklenmedi...\n"
                    + "T.C.K.No kontol ediniz.(Aynı olamaz)", "Uyarı", HEIGHT);
      

        }
        closeDB();
        
    }

    public void urunEkle(String urunSeriNo, int katagoriId, int miktar, String birim, float alisFiyati, float SatisFiyati, String urunAdi) {
        boolean kontrol = false;
        String sql = "INSERT INTO Urunler (urunSeriNo, katagoriId, miktar, birim, alisFiyati, satisFiyati, urunAdi) VALUES (?,?,?,?,?,?,?)";
         
        try {
            openDB();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, urunSeriNo);
            preparedStatement.setInt(2, katagoriId);
            preparedStatement.setInt(3, miktar);
            preparedStatement.setString(4, birim);
            preparedStatement.setFloat(5, alisFiyati);
            preparedStatement.setFloat(6, SatisFiyati);
            preparedStatement.setString(7, urunAdi);
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                JOptionPane.showMessageDialog(null, "ürün eklendi", "bilgilendirme", HEIGHT);
                    stokGuncelle(miktar, urunSeriNo, "alinanMiktar");      
            } else {
                JOptionPane.showMessageDialog(null, "Ürün eklenmedi ! \n"
                        + "Bilgilerin eksiksiz ve doğru olduğundan emin olun...");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ürün eklenmedi ! \n"
                                        + "Aynı ürün mağazada olablir...");
        }
        closeDB();
       
        
    }
    public final void sil(String tabloAdi , String pointer ,String deger){
      String sql =   "DELETE FROM "+tabloAdi+" WHERE "+pointer+" = "+deger+ "";
      String mesaj = "Ürün Silindi";
        executeSQL(sql, mesaj);
      
    }

    public final boolean urunKontrol(String urunSeriNo) {
        openDB();
        String sql = "select * from Urunler where urunSeriNo = ?";
        boolean kontrol = false;

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, urunSeriNo);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (urunSeriNo != rs.getString("urunSeriNo")) {
                    kontrol = true;
                    break;

                }

            }

        } catch (SQLException ex) {
           
        }
        closeDB();
        return kontrol;
    }

    public final String toplamTutar(int miktar, String urunSeriNo) {
        String bilgi = "";
        float fiyat   = 0;
        String sql = "select * from Urunler where urunSeriNo = ?";
        try {
            openDB();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, urunSeriNo);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                if (urunSeriNo != rs.getString("urunSeriNo")) {
                    fiyat = (float) (((rs.getInt("satisFiyati") * (0.18))+ rs.getInt("satisFiyati")) * miktar);
                    bilgi = " " + fiyat + " TL";
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeDB();
        return bilgi;
    }
    public void stokGuncelle(int miktar, String urunSeriNo ,String satis){
        String urunAdi = null ;
                String sql = "insert into Stok (UrunSeriNo ,urunAdi ,"+satis+" , Tarih) values (?,?,?,?)";
                String sql2 = "select * from  Urunler where urunSeriNo = "+urunSeriNo+" ";
                openDB();
                try {
                     stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sql2);
                     while(rs.next()){
                         if (urunSeriNo != rs.getString("urunSeriNo")) {
                            urunAdi = rs.getString("urunAdi");
                            break;
                             
                         }
                     }
        } catch (Exception e) {
        }
        try {
           
             preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, urunSeriNo);
                    preparedStatement.setString(2, urunAdi);
                    preparedStatement.setInt(3, miktar);
                    preparedStatement.setString(4, tarih("yyyy/M/dd"));
                    int row = preparedStatement.executeUpdate();
        } catch (Exception e) {
            
        }
       closeDB();
    }

    public boolean urunSat(int miktar, String urunSeriNo) {
        boolean kontrol =  false;
        String sql = "update Urunler Set miktar = (miktar - ?) where urunSeriNo = ? and miktar >= ?";
        try {
            openDB();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, miktar);
            preparedStatement.setString(2, urunSeriNo);
            preparedStatement.setInt(3, miktar);

            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                kontrol = true;
                stokGuncelle(miktar, urunSeriNo ,"satilanMiktar");
                
            } else {
                JOptionPane.showMessageDialog(null, "Stokta o kadar ürün mevcut değil... ", "Uyarı", HEIGHT);
            }

        } catch (SQLException e) {
           
        }
        closeDB();
        return kontrol;
    }

    public final String urunArama(String urunSeriNo) {
        String sql = "select * from  Urunler where urunSeriNo = ? ";
        String bilgi = "Girdiğiniz Seri No ya ait ürün bulunmadı.";
        int stokMiktar = 0;
        String stokBirim = "";
        String urunAdi = "";
        int brimFiyat = 0;

        try {
            openDB();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, urunSeriNo);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                {
                    if (urunSeriNo != rs.getString("urunSeriNo")) {
                        stokBirim = rs.getString("birim");

                        stokMiktar = rs.getInt("miktar");
                        brimFiyat = rs.getInt("satisFiyati");
                        urunAdi = rs.getString("urunAdi");
                        bilgi = "Ürün Adı:  " + urunAdi + " .\n"
                                + "Ürün Satış Fiyatı:  " + brimFiyat + " TL.\n"
                                + "Ürün Stok Bilgisi: " + stokMiktar + " " + stokBirim + " mevcut.";
                        break;
                    }

                }

            }

        } catch (SQLException e) {
            
        }
        closeDB();
        return bilgi;

    }

    public void katagoriEkle(String katagoriAdi) {
        String sql = "insert into Katagoriler (katagoriAdi) values (?)";
        try {
            openDB();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, katagoriAdi);
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                JOptionPane.showMessageDialog(null, "Katagori eklendi", "bilgilendirme", HEIGHT);

            } else {
                JOptionPane.showMessageDialog(null, "Katagori eklenmedi ! \n"
                        + "Bilgilerin eksiksiz ve doğru olduğundan emin olun...");
            }
        } catch (SQLException ex) {
        }
        closeDB();
    }

    public String tarih(String tarih) {
        LocalDate takvim = LocalDate.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(tarih);
        String tarih2 = (takvim.format(dtf));
        return tarih2;
    }

    public final ArrayList<String> getTableList() {
        ArrayList<String> tableList = new ArrayList<String>();
        openDB();
        try {
            md = conn.getMetaData();
            rs = md.getTables(null, null, null, null);
            while (rs.next()) {
                tableList.add(rs.getString(3));
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "tablo liste olusturma sirasinda hata", "Uyarı", JOptionPane.WARNING_MESSAGE);
        }
        closeDB();
        return tableList;
    }

    public final ArrayList<String> getColumnList(String tableName) {
        ArrayList<String> columnList = new ArrayList<String>();
        openDB();
        try {
            md = conn.getMetaData();
            rs = md.getColumns(null, null, tableName, null);
            while (rs.next()) {
                columnList.add(rs.getString(4));
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "kolon liste olusturma sirasinda hata", "Uyarı", JOptionPane.WARNING_MESSAGE);
        }
        closeDB();
        return columnList;
    }

    public final void executeUpdateSQL(String sql, String message) {
        openDB();
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, message, "Uyarı", JOptionPane.WARNING_MESSAGE);
        }
        closeDB();
    }

    public final ArrayList<ArrayList<String>> executeQuerySQL(String sql, String message, String columnName) {
        ArrayList<ArrayList<String>> queryList = new ArrayList<ArrayList<String>>();
        openDB();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ArrayList<String> valueList = new ArrayList<String>();
                if (columnName == null) {
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        valueList.add(rs.getString(i));
                    }
                } else {
                    valueList.add(rs.getString(columnName));
                }
                queryList.add(valueList);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, message, "MyDB", JOptionPane.WARNING_MESSAGE);
        }
        closeDB();
        return queryList;
    }

    public final Object[][] getObjectArray(ArrayList<ArrayList<String>> list) {
        if (list.size() == 0) {
            return null;
        }
        Object[][] objectArray = new Object[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                objectArray[i][j] = list.get(i).get(j);
            }
        }
        return objectArray;
    }

}
